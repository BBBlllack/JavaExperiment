package com.shj.expers.exp6.chat1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    private static final Scanner SCANNER = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(11111);
        System.out.println("服务器等待连接...");
        Socket accept = serverSocket.accept();
        System.out.println("服务器连接成功:" + accept.getInetAddress().getHostAddress());
        new Thread(new ReadPublic(accept)).start();
        new Thread(new WritePublic(accept, false)).start();
//        accept.close();
//        serverSocket.close();
    }
}
