package com.shj.expers.exp6.first;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;


public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(Config.PORT);
        System.out.println("服务器正在监听端口:" + Config.PORT);
        Socket accept = serverSocket.accept();
        System.out.println("连接成功:" + accept.getInetAddress().getHostAddress());

        String receive, send;
        int count = 0; // 计数器
        //获取输入输出
        PrintWriter printWriter = new PrintWriter(accept.getOutputStream(), true);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(accept.getInputStream()));

        while (true) {
            if (count < 3) {
                printWriter.println("Verifying Server 1111!");
                System.out.println("server发送Verifying Server 1111!");
            }
            if (count == 3) {
                printWriter.println("Illegal User!");
                System.out.println("server发送Illegal User!");
                break;
            }

            receive = bufferedReader.readLine();
            System.out.println("server接收到:" + receive);
            // 规定密码为password
            if (receive.equals("password")) {
                send = "Registration Successful!";
                printWriter.println(send);
                System.out.println("server发送:" + send);
                break;
            } else if (count < 3) {
                count++;
                printWriter.println("PassWord Wrong!");
                System.out.println("server发送PassWord Wrong!");
            }
        }
        // 释放资源
        bufferedReader.close();
        printWriter.close();
        accept.close();
        serverSocket.close();
    }
}
