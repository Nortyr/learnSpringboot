package com.myspringboot.async;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * @Auther: 陈晖
 * @Date:2019/1/31 0031
 * @Descroption:
 */

/*
    @EnableAsync
    表示可以使用@Async
 */
@Configuration
@EnableAsync

public class AsyncConfig implements AsyncConfigurer {
    @Override
   public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor taskExecutor=new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(10);
        taskExecutor.setMaxPoolSize(30);
        taskExecutor.setQueueCapacity(2000);
        taskExecutor.initialize();
        return taskExecutor;
    }
}
