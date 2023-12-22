package com.shj.expers.exam;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class CheckCodeAwt extends Frame {
    static class Pos{
        public int x;
        public int y;
        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Pos{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    public static ArrayList<Pos> clickList = new ArrayList<>();
    private BufferedImage image;
    public CheckCodeAwt(BufferedImage image, List genPos) {
        this.image = image;
        setTitle("Image Window");
        setSize(image.getWidth(), image.getHeight());

        // 创建一个Canvas用于显示图像
        Canvas canvas = new Canvas() {
            @Override
            public void paint(Graphics g) {
                g.drawImage(image, 0, 0, this);
            }
        };
        canvas.setSize(image.getWidth(), image.getHeight());

        // 将Canvas添加到窗口中
        add(canvas);
        canvas.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                int x = e.getX();
                int y = e.getY();
                clickList.add(new Pos(x, y));
                System.out.println("(x,y): (" + x + ","+ y + ")");

                // 每次添加之后判断是否需要校验
                if (clickList.size() == 4){
                    boolean flag = true;
                    System.out.println("开始校验...");
                    for (int i = 0; i < 4; i++) {
                        // 当点击的和产生的差值过大时, 判断错误, 验证不通过
                        Pos source = (Pos) genPos.get(i);
                        Pos click = clickList.get(i);
                        if (Math.abs(click.x - source.x) > 30){
                            flag = false;
                            break;
                        }
                        if (Math.abs(click.y - source.y) > 30){
                            flag = false;
                            break;
                        }
                    }
                    System.out.println(flag ? "验证通过!":"验证失败!");
                    System.out.println("校验结束...");
                    clickList.clear();
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        // 添加窗口关闭事件处理
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose(); // 关闭窗口
            }
        });

        setVisible(true); // 显示窗口
    }

    public static void main(String[] args) {
//        BufferedImage sampleImage = new BufferedImage(120, 40, BufferedImage.TYPE_INT_RGB);
        Map<String, Object> map = generateVerify(400, 300);
        BufferedImage verifyPic = (BufferedImage) map.get("verifyPic");
        String verifyCode = "请依次点击:" + map.get("verifyCode");
        ArrayList pos = (ArrayList) map.get("pos");
        System.out.println(pos);
        // 创建图像窗口并显示图像
        System.out.println(verifyCode);
        CheckCodeAwt imageWindow = new CheckCodeAwt(verifyPic, pos);
    }

    public static Map<String, Object> generateVerify(int width,int height){
        Random random = new Random();
        //创建一张图片
        BufferedImage verifyPic = new BufferedImage(width,height,BufferedImage.TYPE_3BYTE_BGR);
        //通过图片获取画笔
        Graphics2D g = verifyPic.createGraphics();
        //准备一个字母+数字的字典
        String letters = "23456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        //规定验证码的位数
        int verifyLength = 4;
        //生成随机验证码
        String verifyCode = "";
        //循环取值
        for(int i=0; i<verifyLength; i++) {
            verifyCode +=letters.charAt((int)(Math.random()*letters.length()));
        }
        //将图片的底板由黑变白
        g.setColor(Color.white);
        g.fillRect(0, 0, width, height);
        //将验证码画在图片之上
        g.setFont(new Font("微软雅黑",Font.BOLD, 24));
        ArrayList<Pos> poss = new ArrayList<>();
        Map<String, Object> data = new HashMap<String, Object>();
        for (int i = 0; i < verifyLength; i++) {
            //随机产生一个角度
//            double theta = Math.random() * Math.PI / 4 * ((int)(Math.random()*2) == 0?1:-1);
            //产生偏转
//            g.rotate(theta, 24+i*22, 20);
            //每画一个字幕之前都随机给一个颜色
            g.setColor(new Color((int)(Math.random()*256), (int)(Math.random()*256), (int)(Math.random()*256)));
            int x = 20+i* (random.nextInt(20) + 40);
            int y = random.nextInt(height - 100) + 50;
            poss.add(new Pos(x, y));
            g.drawString(verifyCode.charAt(i)+"", x, y);
            //回正
//            g.rotate(-theta, 24+i*22, 20);
        }
        g.drawString("请依次点击" + verifyCode, 0,40);


        //加入干扰线
        for (int i = 0; i < 5; i++) {
            //给随机颜色
            g.setColor(new Color((int)(Math.random()*256), (int)(Math.random()*256), (int)(Math.random()*256)));
            //画线
            g.drawLine((int)(Math.random()*width), (int)(Math.random()*height),
                    (int)(Math.random()*width), (int)(Math.random()*height));
        }
        //设置边框颜色
        g.setColor(Color.black);
        //给验证码一个外边框
        g.drawRect(0, 0, width - 2, height - 2);
        //将验证码和图片一起存入map, 同时记录坐标序列
        data.put("verifyCode", verifyCode);
        data.put("verifyPic", verifyPic);
        data.put("pos",poss); // 记录坐标序列
        return data;
    }
}
