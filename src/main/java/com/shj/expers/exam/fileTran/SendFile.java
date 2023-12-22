package com.shj.expers.exam.fileTran;

import java.io.*;
import java.net.Socket;

public class SendFile extends Thread{
    public Socket socket;
    public boolean type;
    public String file;
    public double time;
    public SendFile(Socket socket, boolean type, String file){
        this.socket = socket;
        this.type = type;
        this.file = file;
    }

    @Override
    public void run() {
        try {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
            BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
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
            System.out.println("文件发送完成!");
            this.time = (end - start) / 1000.0;
            System.out.println("耗时:"+ (end - start)/1000.0 + "s");
//            释放资源
            bos.close();
            bis.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
