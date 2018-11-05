package com.netintech.xfquartz.websocket;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author: zhangyue
 * @date: 2018/10/26 13:01
 * @description:
 */
@ServerEndpoint(value = "/websocket/{param}")
@Component
public class MyWebSocket {

    /**
     * 定义一个全局的记录器，通过LoggerFactory获取
     */
    private final static Logger logger = (Logger) LoggerFactory.getLogger(MyWebSocket.class);

    /**
     * 静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
     */
    private static int onlineCount = 0;

    /**
     * concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。
     */
    private static CopyOnWriteArraySet<MyWebSocket> webSocketSet = new CopyOnWriteArraySet<MyWebSocket>();
    /**
     * 创建一个用来存所有连接过的session
     */
    private static final Map<String,MyWebSocket> connections = new HashMap<String,MyWebSocket>();
    /**
     * 与某个客户端的连接会话，需要通过它来给客户端发送数据
     */
    private Session session;

    /**
     * 连接建立成功调用的方法
     * @param userid 用户id
     * @param session
     */
    @OnOpen
    public void onOpen(@PathParam(value="param") String userid, Session session) {
        this.session = session;
        //加入map中
        connections.put(userid,this);
        //加入set中
        webSocketSet.add(this);
        //在线数加1
        addOnlineCount();
        logger.info("有新连接加入！当前在线人数为" + getOnlineCount());

    }

    /**
     * 连接关闭调用的方法
     * @param userid
     */
    @OnClose
    public void onClose(@PathParam(value="param") String userid) {
        //从map中删除
        connections.remove(userid);
        //从set中删除
        webSocketSet.remove(this);
        //在线数减1
        subOnlineCount();
        logger.info("有一连接关闭！当前在线人数为" + getOnlineCount());
    }

    /**
     * 收到客户端消息后调用的方法
     * @param userid  用户id
     * @param message 客户端发送过来的消息
     * @param session
     */
    @OnMessage
    public void onMessage(@PathParam(value="param") String userid, String message, Session session) {
        logger.info("来自客户端的消息:"+message);
        //群发消息
//        for (MyWebSocket item : webSocketSet) {
//            try {
//                item.sendMessage(message);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
    }

    /**
     * 发生错误时调用
     * @param session
     * @param error
     */
     @OnError
     public void onError(Session session, Throwable error) {
         logger.error("发生错误"+error.toString());
         error.printStackTrace();
     }

    /**
     * 发送消息
     * @param message
     * @param session
     * @throws IOException
     */
     public void sendMessage(String message, Session session) throws IOException {
         session.getBasicRemote().sendText(message);
         //this.session.getAsyncRemote().sendText(message);
     }

    /**
     * 群发自定义消息
     * @param message
     * @throws IOException
     */
    public static void sendInfo(String message) throws IOException {
        for(String in:connections.keySet()){
            try {
                connections.get(in).sendMessage(message,connections.get(in).getSession());
            } catch (IOException e) {
                continue;
            }
        }
    }

    /**
     * 自定义发送消息给用户
     * @param message
     * @param session
     * @throws IOException
     */
    public static void sendMessageToUser(String message, Session session) throws IOException {
        session.getBasicRemote().sendText(message);
    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        MyWebSocket.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        MyWebSocket.onlineCount--;
    }

    public static Map<String, MyWebSocket> getConnections() {
        return connections;
    }

    public Session getSession() {
        return session;
    }
}
