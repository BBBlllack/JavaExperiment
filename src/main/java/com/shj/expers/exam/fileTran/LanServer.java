package com.shj.expers.exam.fileTran;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class LanServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket serverSocket = new ServerSocket(10020);

        String[] filenames = {"1.txt","2.png","3.pdf"};
        int count = 0;
        Socket socket = serverSocket.accept();
//        new Thread(new Read(socket)).start();
//        new RecvFile(socket,false,"3.pdf");
//        new RecvFile(socket, false, filenames[2]);
        new RecvFile(socket,false,"3.pdf").start();
    }
}
