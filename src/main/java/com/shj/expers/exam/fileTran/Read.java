package com.shj.expers.exam.fileTran;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

@SuppressWarnings("all")
public class Read implements Runnable{

    private Socket socket;

    public Read(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {

        try {
            InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
            int b;
            while ((b = inputStreamReader.read()) != -1){
                System.out.print((char)b);
            }

            inputStreamReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
