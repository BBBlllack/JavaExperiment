package com.shj.controller;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

@Slf4j
@RestController
@RequestMapping("/video")
public class VideoController {

    @GetMapping("/q")
    public ResponseEntity<String> playq(HttpServletResponse response){
        String name = Thread.currentThread().getName();
        System.out.println(name);
        return ResponseEntity.ok(name);
    }

    @GetMapping(value = "/play", produces = "video/mp4", params = {"vname"})
    public ResponseEntity<InputStreamResource> playVideo(@RequestParam("vname") String name) throws IOException {
        log.info(Thread.currentThread().toString());
        // 从资源目录中读取视频文件
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("static/video/").append(name).append(".mp4");

        ClassPathResource videoFile = new ClassPathResource(stringBuilder.toString());

        // 将视频文件流返回给客户端
        InputStream videoStream = videoFile.getInputStream();
        InputStreamResource videoResource = new InputStreamResource(videoStream);

        return ResponseEntity.ok()
                .contentType(MediaType.valueOf("video/mp4"))
                .body(videoResource);
    }

}
