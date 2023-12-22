package com.shj.expers.FileTest;

import java.io.*;

public class Test5 {
    public static void main(String[] args) throws IOException {
        // 字符流只能读写文本文件
        BufferedReader bufferedReader = new BufferedReader(new FileReader("/Users/shj/IdeaProjects/JavaExp/src/main/java/com/shj/expers/FileTest/files/1.jpg"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/Users/shj/IdeaProjects/JavaExp/src/main/java/com/shj/expers/FileTest/files/2.png"));

        long start = System.currentTimeMillis();
        int b;
        while ((b = bufferedReader.read()) != -1){
            bufferedWriter.write(b);
        }

        bufferedWriter.close();
        bufferedReader.close();

        long end = System.currentTimeMillis();

        System.out.println(end - start);
    }
}
