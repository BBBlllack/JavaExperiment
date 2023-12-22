package com.shj.expers.FileTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class Test1 {
    public static void main(String[] args) throws IOException {
        // 字节流可以操作所有文件

        // 基本流按字节拷贝文件

        // 文件拷贝基本代码
        Random random = new Random();

        long start = System.currentTimeMillis();
        FileInputStream fis = new FileInputStream("/Users/shj/IdeaProjects/JavaExp/src/main/java/com/shj/expers/FileTest/files/1.jpg");

        FileOutputStream fos = new FileOutputStream("/Users/shj/IdeaProjects/JavaExp/src/main/java/com/shj/expers/FileTest/files/2.png");

        int b;
        while ((b = fis.read()) != -1){
            fos.write(b);
        }

        fos.close();
        fis.close();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
