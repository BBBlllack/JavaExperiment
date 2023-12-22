package com.shj.expers.exp5;

import java.io.*;

public class SecretDemo {
    public static void main(String a[]) throws InterruptedException {
        File fileone = new File("hello.txt");
        File filetwo = new File("hello.secret");
        char b[] = new char[100];

        try {
            FileReader in = new FileReader(fileone); // 创建指向 fileone 的字符输入流
            FileWriter out = new FileWriter(filetwo); // 创建指向 filetwo 的字符输出流

            int n = -1;
            while ((n = in.read(b)) != -1) {
                for (int i = 0; i < n; i++) {
                    b[i] = (char) (b[i] ^ 'a');
                }
                out.write(b, 0, n); // out 将数组 b 的前 n 单元写到文件
            }

            out.close();

            in = new FileReader(filetwo); // 创建指向 filetwo 的字符输入流
            System.out.println("加密后的文件内容:");
            n = in.read(b);
            while (n != -1) {
                String str = new String(b, 0, n);
                System.out.println(str);
                n = in.read(b);
            }

            in = new FileReader(filetwo);
            System.out.println("解密后的文件内容:");
            while ((n = in.read(b)) != -1) {
                for (int i = 0; i < n; i++) {
                    b[i] = (char) (b[i] ^ 'a');
                }
                String str = new String(b, 0, n);
                System.out.println(str);
            }

            in.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
