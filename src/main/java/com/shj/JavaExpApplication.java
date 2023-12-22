package com.shj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * 本springboot项目是java实验和两次大作业的整合
 * @author shj
 * @date 2023/11/07
 */
@SpringBootApplication
@ServletComponentScan
//@EnableAsync // 启动异步注解
public class JavaExpApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaExpApplication.class, args);
    }

//    @Bean
//    public TaskExecutor taskExecutor(){
//        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
//        executor.setCorePoolSize(10); // 设置核心线程池大小
//        executor.setMaxPoolSize(20);  // 设置最大线程池大小
//        executor.setQueueCapacity(30); // 设置任务队列容量
//        executor.initialize();
//        return executor;
//    }

}
