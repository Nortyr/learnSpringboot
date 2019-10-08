package com.myspringboot.redis;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

/**
 * @Auther: 陈晖
 * @Date:2019/1/19 0019
 * @Descroption:
 */

@Component
public class RedisMessageListener implements MessageListener {
    @Override
    //得到消息后的处理方法

    public void onMessage(Message message, byte[] bytes) {
        String body= new String(message.getBody());
        String topic=new String(bytes);
        System.out.println(body);
        System.out.println(topic);
    }
}
