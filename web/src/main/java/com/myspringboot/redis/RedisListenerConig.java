package com.myspringboot.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.Topic;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

/**
 * @Auther: 陈晖
 * @Date:2019/1/19 0019
 * @Descroption:
 */

@Configuration
public class RedisListenerConig {
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    @Autowired
    //自定义的消息监听器
    private MessageListener redisMsgListener;

    @Autowired
    //线程池
    private ThreadPoolTaskScheduler taskScheduler;

    @Bean
    public ThreadPoolTaskScheduler initTaskScheduler(){
        if(taskScheduler!=null){
            return taskScheduler;
        }
        taskScheduler =new ThreadPoolTaskScheduler();
        taskScheduler.setPoolSize(20);
        return taskScheduler;
    }

    @Bean
    public RedisMessageListenerContainer initRedisContainer(){
        RedisMessageListenerContainer container=new RedisMessageListenerContainer();

        //redis连接工厂
        container.setConnectionFactory(redisConnectionFactory);
        //设置运行任务池
        container.setTaskExecutor(initTaskScheduler());
        //定义监听渠道，名为topic1
        Topic topic=new ChannelTopic("topic");
        container.addMessageListener(redisMsgListener,topic);
        return container;
    }



}
