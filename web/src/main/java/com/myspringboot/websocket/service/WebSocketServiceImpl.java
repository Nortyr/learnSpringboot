package com.myspringboot.websocket.service;

import org.springframework.stereotype.Service;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @Auther: 陈晖
 * @Date:2019/1/31 0031
 * @Descroption:
 */

@ServerEndpoint("/ws")
@Service
public class WebSocketServiceImpl {
    private static int onlineCount=0;
    private static CopyOnWriteArraySet<WebSocketServiceImpl> webSocketSet=new CopyOnWriteArraySet<>();

    private Session session;

    @OnOpen
    public void onOpen(Session session){
        this.session =session;
        webSocketSet.add(this);
        addOnlineCount();
        System.out.println("有新连接加入！当前在线人数为"+getOnlineCount());
        try {
            sendMessage("有新的连接加入了");
        }catch (IOException e){
            System.out.println("IO异常");
        }
    }

    @OnClose
    public void onClose(){
        webSocketSet.remove(this);
        subOnlineCount();
        System.out.println("有连接关闭！当前在线人数为"+getOnlineCount());
    }

    @OnMessage
    public void onMessage(String message,Session session){
        System.out.println("来自客户端的消息："+message);
        for(WebSocketServiceImpl item:webSocketSet){
//            String username=item.getSession().getUserPrincipal().getName();
        }
    }
    @OnError
    public void onError(Session session,Throwable error){
        System.out.println("发生错误");
        error.printStackTrace();
    }

    private void sendMessage(String message) throws IOException{
        this.session.getBasicRemote().sendText(message);
    }

    private static synchronized int getOnlineCount(){
        return onlineCount;
    }

    private static synchronized void addOnlineCount(){
        WebSocketServiceImpl.onlineCount++;
    }

    private static synchronized void subOnlineCount(){
        WebSocketServiceImpl.onlineCount--;
    }
}
