package com.shj.expers.exam.fileTran;

import org.apache.ibatis.javassist.compiler.ast.Variable;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

@Component
public class LanClient {
    static class FileTranClient extends Frame{
        public Button send = new Button("send");
        public Button sendText = new Button("change");
        TextArea northText = new TextArea(); // 上部文本框-约定文件名
        public FileDialog fileDialog = new FileDialog(this, "selectFile", FileDialog.LOAD);
        public Socket socket = new Socket("127.0.0.1",10020);
//        public ServerSocket serverSocket = new ServerSocket(10021);
        public FileTranClient() throws IOException {
//            设置窗口属性
            addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    setVisible(false);
                    dispose();
                }
            });
            setTitle("File Transport Client Base on Java AWT");
            setSize(800,600);
//            设置布局
            BorderLayout borderLayout = new BorderLayout();
            borderLayout.setHgap(10);
            borderLayout.setVgap(10);
            setLayout(borderLayout);
//            定义组件
            Button selectFile = new Button("select");


            TextArea textArea = new TextArea();
            textArea.setEditable(false); // 中心只读文本框

            northText.setEditable(true);

            selectFile.addActionListener(e -> {
                fileDialog.setVisible(true); // 显示文件选择框
                String selectedFile = fileDialog.getFile(); // 获取选定的文件名
                String selectedDirectory = fileDialog.getDirectory(); // 获取选定的文件所在目录
                String filePath = selectedDirectory + selectedFile;
                if (selectedFile != null) {
                    File file = new File(filePath);
                    double fileSizeMB = Math.round(file.length() / 1024.0 / 1024.0);
                    textArea.setText("选择的文件: " + filePath + "\n" + "文件大小: " + fileSizeMB + "MB");
                    System.out.println("选择的文件：" + filePath);
                }
            });

//            组装布局
            FlowLayout flowLayout = new FlowLayout();
            Panel southArea = new Panel();
            southArea.setLayout(flowLayout);
            southArea.add(sendText);
            southArea.add(selectFile);
            southArea.add(send);
            add(northText, BorderLayout.NORTH);
            add(textArea, BorderLayout.CENTER);
            add(southArea, BorderLayout.SOUTH);
            setVisible(true);

        }
    }

    public static void main(String[] args) throws IOException {
        FileTranClient fileTranClient = new FileTranClient();

        fileTranClient.sendText.addActionListener(e -> {
            if (fileTranClient.northText.getText() != null){
                System.out.println("文件类型更改...");
                new Thread(new Write(fileTranClient.socket, true, fileTranClient.northText.getText())).start();
            }
        });

        fileTranClient.send.addActionListener(e -> {
            if (fileTranClient.fileDialog.getFile() == null) {
                System.err.println("文件不存在!");
                return;
            }
            String filePath = fileTranClient.fileDialog.getDirectory() + fileTranClient.fileDialog.getFile();
            new SendFile(fileTranClient.socket, true, filePath).start();
        });



    }
}
