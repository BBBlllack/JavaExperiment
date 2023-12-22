package com.shj.expers.FileTest;

import java.io.*;

public class Test3 {
    public static void main(String[] args) throws IOException {

        // 缓冲流按字节拷贝文件
        FileInputStream fileInputStream = new FileInputStream("/Users/shj/IdeaProjects/JavaExp/src/main/java/com/shj/expers/FileTest/files/1.jpg");
        FileOutputStream fileOutputStream = new FileOutputStream("/Users/shj/IdeaProjects/JavaExp/src/main/java/com/shj/expers/FileTest/files/2.png");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        long start = System.currentTimeMillis();
        int b;
        while ((b = bufferedInputStream.read()) != -1){
            bufferedOutputStream.write(b);
        }
        long end = System.currentTimeMillis();

        System.out.println(end - start);

    }
}
