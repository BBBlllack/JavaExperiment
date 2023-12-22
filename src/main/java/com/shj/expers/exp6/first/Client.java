package com.shj.expers.exp6.first;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(Config.HOST, Config.PORT);

        //获取输入输出
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        Scanner scanner = new Scanner(System.in);

        String receive, send;
        while (true) {

            if ((receive = bufferedReader.readLine()) != null) {
                System.out.println("client接收到:" + receive);
            }

            // 用户不合法时退出
            if (receive != null && receive.equals("Illegal User!")) {
                break;
            }

            // 服务器返回信息不合法时退出
            if (!(receive != null && (receive.equals("Verifying Server!") || receive.equals("Registration Successful!") || receive.equals("PassWord Wrong!")))) {
                System.out.println("Server Wrong!");
                break;
            }

            System.out.println("请输入密码:");
            send = scanner.next();
            printWriter.println(send);
            System.out.println("client发送:" + send);
            if ((receive = bufferedReader.readLine()) != null) {
                System.out.println("client接收到:" + receive);
                if (receive.equals("Registration Successful!")) {
                    System.out.println("client登陆成功！");
                    break;
                }
            }
        }

        // 释放资源
        bufferedReader.close();
        printWriter.close();
        socket.close();
    }
}
