package com.shj.expers.exam.fileTran1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class FileServerMultThread {
    private static final int port = 12345;
    public static void main(String[] args) {
        List<String> files = listFiles("/Users/shj/IdeaProjects/JavaExp/src/main/java/com/shj/expers/exam/fileTran1/serverFiles");
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("waiting for client link...");
            while (true) {
                Socket clientSocket = serverSocket.accept();
//                System.out.println("client is linked:" + clientSocket.getInetAddress());
                // 多线程实现并发下载
                new Thread(() -> {
                    try {
                        System.out.println("new Thread(" + Thread.currentThread().getName() + ") is created with socket " + clientSocket.getInetAddress());
                        DataInputStream in = new DataInputStream(clientSocket.getInputStream());
                        DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
                        System.out.println("client is linked:" + clientSocket.getInetAddress());
                        // 告知客户端有多少个文件
                        out.writeUTF(String.valueOf(files.size()));
                        for (int i = 0; i < files.size(); i++) {
                            out.writeUTF("[" + i + "]" + ":" + files.get(i));
                        }
                        out.writeUTF("hello, this is server file list, you can input the index of file you want to download");

                        // 获取客户端请求文件索引, 超出跳过本次循环
                        int i = Integer.parseInt(in.readUTF());
                        if (i > files.size()){
                            System.err.println("client send a error index!");
                            clientSocket.close();
                        }
                        System.out.println("client(" + clientSocket.getInetAddress() + ")request file:" + files.get(i));
                        // 读取文件名
                        String filename = files.get(i);
                        File file = new File(filename);
                        // 发送给客户端文件大小, 为客户端实现进度条做准备
                        out.writeUTF(String.valueOf(file.length()));

                        if (!file.exists()) {
                            out.writeBoolean(false); // 文件不存在
                            System.err.println("file not exist!: " + filename);
                        } else {
                            out.writeBoolean(true); // 文件存在
                            System.out.println("Start transferring files: " + filename);
                            // 计算传输效率
                            double filesize = file.length();
                            double current = 0L;
                            try (FileInputStream fileIn = new FileInputStream(file)) {
                                int unit = 1024 * 1024;
                                byte[] buffer = new byte[unit];
                                int bytesRead;
                                while ((bytesRead = fileIn.read(buffer)) != -1) {
                                    // 已经传输的计数器累加
                                    current += bytesRead;
                                    System.out.println((current / filesize) * 100 + "% : " + Thread.currentThread().getName());
                                    // 模拟网络限速
//                                    Thread.sleep(1000);
                                    out.write(buffer, 0, bytesRead);
                                }
                                out.close();
                                // 因为测试传输文件时并不会进行模拟限速, 但是下面捕获了Interrupted异常, 故在此加一行sleep
                                Thread.sleep(1);
                            }
                            System.out.println("File transfer completed: " + filename + "   " + clientSocket.getInetAddress() + " | " + Thread.currentThread().getName());
                        }
                    }catch (IOException | InterruptedException e){
                        e.printStackTrace();
                    }
                }).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> listFiles(String directoryPath) {
        List<String> fileList = new ArrayList<>();
        File directory = new File(directoryPath);
        // 检查目录是否存在
        if (!directory.exists()) {
            System.out.println("指定的目录不存在。");
            return fileList;
        }
        // 获取目录下所有文件和子目录
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                // 如果是文件，则将其绝对路径添加到列表中
                if (file.isFile()) {
                    fileList.add(file.getAbsolutePath());
                }
                // 如果是目录，则递归调用listFiles方法
                else if (file.isDirectory()) {
                    fileList.addAll(listFiles(file.getAbsolutePath()));
                }
            }
        }
        return fileList;
    }
}
