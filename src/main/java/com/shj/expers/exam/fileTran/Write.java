package com.shj.expers.exam.fileTran;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

@SuppressWarnings("all")
public class Write implements Runnable{

    private boolean type;// false - server, true - client

    private Socket socket;
    private String filename;

    public Write(Socket socket, boolean type, String filename){
        this.socket = socket;
        this.type = type;
        this.filename = filename;
    }

    @Override
    public void run() {
        try {
            BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
            bos.write(filename.getBytes());
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
