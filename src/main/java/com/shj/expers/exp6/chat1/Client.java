package com.shj.expers.exp6.chat1;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static final Scanner SCANNER = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 11111);
        new Thread(new ReadPublic(socket)).start();
        new Thread(new WritePublic(socket,true)).start();

//        socket.close();
    }
}
