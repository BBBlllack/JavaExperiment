package com.shj.expers.exp6.multChat;

import java.io.*;

public class Test {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("/Users/shj/IdeaProjects/JavaExp/src/main/java/com/shj/expers/exp6/multChat/msg.txt");
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String line;
        while ((line = bufferedReader.readLine()) != null){
            System.out.println(line);
        }
        bufferedReader.close();
        inputStreamReader.close();
        fileInputStream.close();
    }
}
