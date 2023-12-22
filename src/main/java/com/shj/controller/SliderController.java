package com.shj.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Random;

/**
 * @author shj
 * @date 2023/11/07
 */
@Slf4j
@RestController
@RequestMapping("/slider")
public class SliderController {

    private final ResourceLoader resourceLoader = new DefaultResourceLoader();

//    判断用户坐标的合法性
    @GetMapping("/{pos}")
    public boolean checkPos(@PathVariable("pos") int pos, HttpServletRequest request) {
        log.info("用户拖动位置: " + pos);
        int posx = (int) request.getSession().getAttribute("posx");
        double p = Math.round(posx / (4000.0 / 300.0));
        log.info("等比缩放后真正位置: " + p);
        log.info("---------------------------");
        // 定义绝对值误差范围
        return Math.abs(pos - p) < 50;
    }


//    滑块验证生成图像, 并且随机涂黑, 将坐标存入session中
    @GetMapping("/bg")
    public ResponseEntity<byte[]> getBg(HttpServletRequest request) throws IOException {
        Resource resource = resourceLoader.getResource("classpath:/static/images/bgs/1.jpg");
        // 判空校验
        if (!resource.exists())
            return null;
        File file = resource.getFile();
        BufferedImage image = ImageIO.read(file);
        Graphics2D graphics = image.createGraphics();
        // 设置矩形的位置、大小和颜色
        int x = new Random().nextInt((image.getWidth() - 660 - 400) + 1) + 400;
        request.getSession().setAttribute("posx", x);
        log.info("生成的位置偏移: " + x);
        int y = 0;
        int width = 660;
        int height = image.getHeight() / 4 - 80;
        // 设置绘制矩形的笔刷
        graphics.setColor(Color.BLACK);
        // 绘制矩形
        graphics.fillRect(x, y, width, height);
        // 释放图形上下文资源
        graphics.dispose();
        // 将修改后的图片转换为字节数组
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(image, "jpg", outputStream);
        byte[] imageBytes = outputStream.toByteArray();

        // 设置响应头，指定响应内容类型为图片类型
        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(imageBytes);
    }
}
