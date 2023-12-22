package com.shj.expers.exam.fileTran1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class FileClient {
    private static final int serverPort = 12345; // 服务器的端口
    private static final String serverAddress = "101.42.34.253"; // 服务器的IP地址
    private static final Scanner SCANNER = new Scanner(System.in);
    public static void main(String[] args) {
        try (Socket socket = new Socket(serverAddress, serverPort);
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {
            int num = Integer.parseInt(in.readUTF());
            List<String> files = new ArrayList<>();
            for (int i = 0; i < num; i++) {
                String file = in.readUTF();
                System.out.println(file);
                int colonIndex = file.indexOf(':');
                String result = file.substring(colonIndex + 1);
                files.add(result);
            }
            // 读取欢迎信息
            System.out.println(in.readUTF());

            // 告知服务器我要下载第几个文件
            int i;
            while (true){
                try {
                    i = SCANNER.nextInt();
                    break;
                }catch (InputMismatchException e){
                    System.err.println("input index is illegal!");
                }
            }
            if (i > files.size()){
                System.err.println("file index out of bounds!");
                System.exit(-1);
            }
            // 发送要请求的文件索引
            out.writeUTF(String.valueOf(i));
            System.out.println("success to request file: " + files.get(i));

            String filename = files.get(i);

            // 获取服务器推送的文件大小
            double filesize = Double.parseDouble(in.readUTF());
            System.out.println("filesize: " + filesize + "bytes");

            boolean fileExists = in.readBoolean();
            if (!fileExists) {
                System.err.println("file not found in server: " + filename);
                System.exit(-1);
            }


            String s = filename.split("/")[filename.split("/").length - 1];
            // 文件接收路径
            String clientFilePath = "/Users/shj/IdeaProjects/JavaExp/src/main/java/com/shj/expers/exam/fileTran1/clientFiles/";
            long start = System.currentTimeMillis();
            // 当前接收了多大
            long current = 0L;
            try (FileOutputStream fileOut = new FileOutputStream(clientFilePath + s)) {
                int unit = 1024 * 1024;
                byte[] buffer = new byte[unit];
                int bytesRead;
                while ((bytesRead = in.read(buffer)) != -1) {
                    current += bytesRead;
                    // 输出当前进度
                    System.out.println((current / filesize) * 100 + "%");
                    fileOut.write(buffer, 0, bytesRead);
                }
            }
            System.out.println("File download completed: " + filename + " | time consuming:" + (System.currentTimeMillis() - start) + "ms");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
