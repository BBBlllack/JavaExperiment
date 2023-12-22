package com.shj.expers.exam.fileTran1;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class ScanHost {
    private static final Scanner SCANNER = new Scanner(System.in);
    public static void main(String[] args) {
        int i1 = SCANNER.nextInt();

        System.exit(-1);
        try {
            // 创建一个UDP套接字，不需要绑定到指定端口
            DatagramSocket socket = new DatagramSocket();

            // 循环遍历局域网内的IP地址
            for (int i = 1; i <= 254; i++) {
                String ipAddress = "192.168.3." + i; // 假设你的局域网IP段是192.168.1.x

                InetAddress address = InetAddress.getByName(ipAddress);

                // 尝试连接到主机，设置适当的超时时间
                if (address.isReachable(1000)) {
                    System.out.println("主机 " + ipAddress + " 可达");
                }
            }

            // 关闭套接字
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
