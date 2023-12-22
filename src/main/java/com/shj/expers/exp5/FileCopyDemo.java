package com.shj.expers.exp5;
import java.io.*;

public class FileCopyDemo {
    public static void main(String[] args) {

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            FileWriter writer1 = new FileWriter("myfile1.txt");
            String line;

            System.out.println("输入学生信息（格式：学号 姓名 专业 班级 地址）或键入exit退出:");
            while (!(line = br.readLine()).equalsIgnoreCase("exit")) {
                writer1.write(line + "\n");
            }

            writer1.close();

            BufferedReader reader = new BufferedReader(new FileReader("myfile1.txt"));
            FileWriter writer2 = new FileWriter("myfile2.txt");

            while ((line = reader.readLine()) != null) {
                writer2.write(line + "\n");
            }

            reader.close();
            writer2.close();

            System.out.println("Data copied from myfile1.txt to myfile2.txt.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
