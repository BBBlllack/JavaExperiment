package com.shj.expers.exp6.multChat;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class ChatClient {
    private static final String SERVER_IP = "127.0.0.1";
//    private static final String SERVER_IP = "117.10.139.187";
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) throws IOException, InterruptedException {
        // 图形化窗口组建
        Frame frame = new Frame("Chatroom");
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        // 只读文本框
        TextArea readOnlyTextArea = new TextArea("", 5, 40);
        readOnlyTextArea.setEditable(false);
        frame.add(readOnlyTextArea, BorderLayout.CENTER);

        // 创建底部的Panel
        Panel bottomPanel = new Panel();
        bottomPanel.setLayout(new BorderLayout());

        // 输入文本框, 进入之后才可用
        TextField inputTextField = new TextField("");
        inputTextField.setEditable(false);
        inputTextField.setText("active this textarea after you join");
        bottomPanel.add(inputTextField, BorderLayout.CENTER);

        // 按钮
        Button button = new Button("发送");
        bottomPanel.add(button, BorderLayout.EAST);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        // 关闭事件
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        frame.setVisible(true);

        Socket socket = new Socket(SERVER_IP, SERVER_PORT);
        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your username: ");
        readOnlyTextArea.append("Enter your username in console: ");
        String name = scanner.nextLine();
        frame.setTitle("Chatroom | " + name);
//        System.out.println("Welcome to the chat room, " + name);
        readOnlyTextArea.append("\n" + "Welcome to the chat room, " + name);
        readOnlyTextArea.append("\n" + "if you want to exit chatroom, you can type exit in console");
        // 激活输入文本框
        inputTextField.setText("");
        inputTextField.setEditable(true);

        // 读取历史记录
//        BufferedReader hisRecords = new BufferedReader(new InputStreamReader(Files.newInputStream(Paths.get("/Users/shj/IdeaProjects/JavaExp/src/main/java/com/shj/expers/exp6/multChat/msg.txt"))));
//        String line;
//        while ((line = hisRecords.readLine()) != null){
//            System.out.println(line);
//            readOnlyTextArea.append("\n" + line);
//        }
//        System.out.println("----------------------------");
//        System.out.println("The above is history records");
//        readOnlyTextArea.append("\n" + "----------------------------");
//        readOnlyTextArea.append("\n" + "The above is history records");

        Thread receivingThread = new Thread(() -> {
            try {
                String message;
                while ((message = reader.readLine()) != null) {
                    readOnlyTextArea.append("\n" + message);
//                    System.out.println(message);
                }
            } catch (Exception e) {

            }
        });
        receivingThread.start();

//        在控制台输入消息, 后续改进为图形化界面, 故此行注释
//        String input;
//        while ((input = scanner.nextLine()) != null) {
//            writer.println(name + ": " + input);
//        }

        // 按钮点击, 发送消息
        button.addActionListener(e -> {
            String inputText = inputTextField.getText();
            readOnlyTextArea.append("\n" + inputText);
            inputTextField.setText("");
            writer.println(name + ": " + inputText);
        });

        // 输入文本框检测到回车则发送消息
        inputTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    String inputText = inputTextField.getText();
                    readOnlyTextArea.append("\n" + inputText);
                    inputTextField.setText("");
                    writer.println(name + ": " + inputText);
                }
            }
        });
        // 用户输入exit之后退出
        System.out.println("if you want to exit, type exit in console");
        while (!scanner.nextLine().equals("exit"));
        writer.println(name + ": " + "bye~");
        Thread.sleep(1000);
        // 释放资源
//        hisRecords.close();
        writer.close();
        reader.close();
        socket.close();
    }
}
