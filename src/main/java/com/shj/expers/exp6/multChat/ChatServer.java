package com.shj.expers.exp6.multChat;

import java.io.*;
import java.net.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.concurrent.*;

public class ChatServer {
    private static final int PORT = 12345;
    private static final ExecutorService pool = Executors.newFixedThreadPool(10);
    private static final ConcurrentMap<String, PrintWriter> clients = new ConcurrentHashMap<>();
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        System.out.println("Server is running...");
        ServerSocket serverSocket = new ServerSocket(PORT);

        // 聊天记录文件, 保存聊天记录, 每次服务器重启会清空上一次的记录
        FileOutputStream msgOutput = new FileOutputStream("/Users/shj/IdeaProjects/JavaExp/src/main/java/com/shj/expers/exp6/multChat/msg.txt");

        // 这条线程用于服务器发送消息给每个客户端
        new Thread(() -> {
            while (true) {
                try {
                    System.out.println("please type server msg:");
                    String trim = SCANNER.nextLine().trim();
                    trim = "server:" + trim;
                    // 保存服务器消息
                    msgOutput.write((trim + "\n").getBytes());
                    msgOutput.flush();
                    for (PrintWriter clientWriter : clients.values()) {
                        clientWriter.println(trim);
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();


        while (true) {
            Socket clientSocket = serverSocket.accept();
            // 推送历史记录
            BufferedReader hisRecords = new BufferedReader(new InputStreamReader(Files.newInputStream(Paths.get("/Users/shj/IdeaProjects/JavaExp/src/main/java/com/shj/expers/exp6/multChat/msg.txt"))));
            System.out.println("New client connected: " + clientSocket);

            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
            String line;
            while ((line = hisRecords.readLine()) != null){
                writer.println(line);
            }
            hisRecords.close();
            writer.println("----------------------------");
            writer.println("The above is history records");
            // 用客户端字符串作为唯一标识, 客户端writer置入map, 便于后续推送消息
            clients.put(clientSocket.toString(), writer);
            pool.execute(new ClientHandler(clientSocket, msgOutput));
        }
    }

    private static class ClientHandler implements Runnable {
        private final Socket socket;
        private final BufferedReader reader;
        private final PrintWriter writer;

        private static FileOutputStream msgo = null;

        public ClientHandler(Socket socket, FileOutputStream msg) throws IOException {
            this.socket = socket;
            this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.writer = clients.get(socket.toString());
            this.msgo = msg;
        }

        @Override
        public void run() {
            try {
                String message;
                while ((message = reader.readLine()) != null) {
                    System.out.println("Received from " + socket + ": " + message);
                    // 保存客户端消息
                    this.msgo.write((message + "\n").getBytes());
                    this.msgo.flush();
                    broadcast(message, socket);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    clients.remove(socket.toString());
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        private void broadcast(String message, Socket currSocket) {
//            for (PrintWriter clientWriter : clients.values()) {
//                clientWriter.println(message);
//            }
            // 判断如果是当前socket则不推送, 防止给自己推送自己发送的消息
            for (String s : clients.keySet()) {
                if (s.equals(currSocket.toString())){
                    continue;
                }
                PrintWriter printWriter = clients.get(s);
                printWriter.println(message);
            }
        }
    }
}
