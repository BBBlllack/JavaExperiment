package com.shj.expers.exp6.chat1;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

@SuppressWarnings("all")
public class ReadPublic implements Runnable{

    private Socket socket;

    public ReadPublic(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        InputStreamReader inputStreamReader;
        try {
           inputStreamReader = new InputStreamReader(socket.getInputStream());
           int b;
           while ((b = inputStreamReader.read()) != -1){
               System.out.print((char)b);
           }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
