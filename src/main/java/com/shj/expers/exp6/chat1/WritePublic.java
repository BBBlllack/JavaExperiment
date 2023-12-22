package com.shj.expers.exp6.chat1;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

@SuppressWarnings("all")
public class WritePublic implements Runnable{

    private boolean type;// false - server, true - client

    private Socket socket;

    public WritePublic(Socket socket, boolean type){
        this.socket = socket;
        this.type = type;
    }

    @Override
    public void run() {
        String name = type ? "client":"server";
        try {
            Scanner scanner = new Scanner(System.in);
            OutputStream outputStream = socket.getOutputStream();
            while (true){
                outputStream.write((name+ ":" + scanner.nextLine() + "\n").getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
