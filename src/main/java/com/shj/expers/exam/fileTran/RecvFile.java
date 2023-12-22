package com.shj.expers.exam.fileTran;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;

public class RecvFile extends Thread{
    public Socket socket;
    public boolean type;
    public String filename;

    public RecvFile(Socket socket, boolean type, String filename){
        this.socket = socket;
        this.type = type;
        this.filename = filename;
    }

    @Override
    public void run() {
        try {
            BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("/Users/shj/IdeaProjects/JavaExp/src/main/java/com/shj/expers/exam/fileTran/" + filename));
            int len;
            byte[] bytes = new byte[1024];
            boolean startflag = false;
            long start = 0;
            while ((len = bis.read(bytes)) != -1){
                if (!startflag){
                    start = System.currentTimeMillis();
                }
                startflag = true;
                bos.write(bytes,0,len);
            }
            long end = System.currentTimeMillis();
            bos.close();
            bis.close();
            System.out.println("文件接受完成!");
            System.out.println("耗时:"+ (end - start)/1000.0 + "s");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
