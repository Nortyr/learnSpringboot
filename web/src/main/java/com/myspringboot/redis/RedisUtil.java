package com.myspringboot.redis;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import java.util.*;

/**
 * @Auther: 陈晖
 * @Date:2019/1/17 0017
 * @Descroption:
 */

@Component
@Data
public class RedisUtil {


    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public boolean set(String key,Object value){
        try {
            redisTemplate.opsForValue().set(key,value);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public Object get(String key){
        return key==null?null:redisTemplate.opsForValue().get(key);
    }

    public boolean set1(String key,String value){
        try {
            stringRedisTemplate.opsForValue().set(key,value);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
//绑定
    public boolean set2(){
       redisTemplate.opsForValue().set("key1","value1");
       redisTemplate.opsForValue().set("int_key","1");
       stringRedisTemplate.opsForValue().set("int","1");
       stringRedisTemplate.opsForValue().increment("int",1);
       Jedis jedis=(Jedis) stringRedisTemplate.getConnectionFactory().getConnection().getNativeConnection();
       jedis.decr("int");
       Map<String,String> hash=new HashMap<>();
       hash.put("field1","value1");
       hash.put("field2","value2");
       stringRedisTemplate.opsForHash().putAll("hash",hash);
       stringRedisTemplate.opsForHash().put("hash","field3","value3");
        BoundHashOperations hashOps=stringRedisTemplate.boundHashOps("hash");
        hashOps.delete("field1","field2");
        hashOps.put("field4","value4");
        return true;


    }
    //什么redisTemplate获取什么redisTemplate拿
    public void get2(){
        Object o=stringRedisTemplate.opsForValue().get("int");
        Object o1=redisTemplate.opsForValue().get("key1");
        Object o2=redisTemplate.opsForValue().get("int_key");
        System.out.println(o+"------------"+o1+"--------------"+o2);
        Map<Object, Object> hash=new HashMap<>();
       hash=stringRedisTemplate.opsForHash().entries("hash");
        System.out.println(hash);
//        hash=stringRedisTemplate.opsForHash().get

    }
    //左加右加
    public void set3(){
        stringRedisTemplate.opsForList().leftPushAll("list1","v1","v2","v3","v4");
        stringRedisTemplate.opsForList().leftPushAll("list2","v5","v6","v3","v4");

    }
    //有序集合
    public void set4(){
        Set<ZSetOperations.TypedTuple<String>> typedTupleSet=new HashSet<>();
        for(int i=1;i<=9;i++){
            double score=i*0.1;
            ZSetOperations.TypedTuple<String> typedTuple=new DefaultTypedTuple<String>("value"+i,score);
            typedTupleSet.add(typedTuple);
        }
        //往有序集合添加元素
        stringRedisTemplate.opsForZSet().add("zset1",typedTupleSet);
        BoundZSetOperations<String,String> zSetOperations=stringRedisTemplate.boundZSetOps("zset1");
        zSetOperations.add("value10",0.26);
        Set<String> setRange=zSetOperations.range(1,6);
    }

    /*
        SessionCallback:
            redisTemplate.execute(new SessionCallback(){
                public Object execute(RedisOperations ro){
                    ro.opsForValue().set();
                    return null;
                }
            });
            lamda:
            redisTemplate.execute((RedisOperations ro)->{
                ro.opsForValue().set();
                return null;
            });


     */

    //redis事务
    public void set5(){
        redisTemplate.opsForValue().set("v1","v2");
        //这里会有报错，不用care
        List list=(List)redisTemplate.execute((RedisOperations operations)->{
            operations.watch("v1");
            operations.multi();
            operations.opsForValue().set("k2","v2");
            operations.opsForValue().increment("k1",1);
            Object v2=operations.opsForValue().get("k2");
            System.out.println("命令再队列所以值为"+v2);
            operations.opsForValue().set("k3","v3");
            Object v3=operations.opsForValue().get("k3");
            System.out.println("命令再队列所以值为"+v3);
            return operations.exec();
        });
        System.out.println(list);
    }

    //redis流水线（一次性发送所有的请求）
    public void set6() {
    Long start=System.currentTimeMillis();
    //sessionCallback
    List list=(List)redisTemplate.executePipelined((RedisOperations operations)->{
       for(int i=1;i<=100000;i++){
           operations.opsForValue().set("pipeline_"+i,"value_"+i);
           String value=(String)operations.opsForValue().get("pipeline_"+i);
           if(i==100000){
               System.out.println("--------------------"+value);
           }
       }
       return null;
    });
    long end=System.currentTimeMillis();
    System.out.println("耗时"+(end-start));


    }



}
