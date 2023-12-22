package com.shj.expers.FileTest;

import java.io.*;

public class Test4 {
    public static void main(String[] args) throws IOException {
        // 缓冲流以字节数组拷贝文件
        FileInputStream fileInputStream = new FileInputStream("/Users/shj/IdeaProjects/JavaExp/src/main/java/com/shj/expers/FileTest/files/1.jpg");
        FileOutputStream fileOutputStream = new FileOutputStream("/Users/shj/IdeaProjects/JavaExp/src/main/java/com/shj/expers/FileTest/files/2.png");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        long start = System.currentTimeMillis();
        int len;
        byte[] bytes = new byte[1020 * 1024 * 5];
        while ((len = bufferedInputStream.read(bytes)) != -1){
            bufferedOutputStream.write(bytes,0,len);
        }

        bufferedOutputStream.close();
        bufferedInputStream.close();
        fileOutputStream.close();
        fileInputStream.close();

        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
