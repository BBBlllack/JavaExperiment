package com.shj.expers.FileTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class Test2 {
    public static void main(String[] args) throws IOException {

        // 基本流按数组拷贝文件
        long start = System.currentTimeMillis();

        FileInputStream fis = new FileInputStream("/Users/shj/IdeaProjects/JavaExp/src/main/java/com/shj/expers/FileTest/files/1.jpg");

        FileOutputStream fos = new FileOutputStream("/Users/shj/IdeaProjects/JavaExp/src/main/java/com/shj/expers/FileTest/files/2.png");
        int len;
        byte[] bytes = new byte[1024 * 1024 * 5]; // 开辟了一个5M大小的数组, 一次性拷贝5M
        while ((len = fis.read(bytes)) != -1){
//            System.out.println(Arrays.toString(bytes));
//            break;
            fos.write(bytes,0,len);
        }

        long end = System.currentTimeMillis();

        System.out.println(end - start);
    }
}
