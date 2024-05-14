package com.zeroone.star.ws.service;

import cn.hutool.json.JSONUtil;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p>
 * 描述：简单的聊天服务
 * </p>
 * <p>版权：&copy;01星球</p>
 * <p>地址：01星球总部</p>
 * @author 阿伟学长
 * @version 1.0.0
 */
@Component
@ServerEndpoint("/chat")
public class ChatServer {
    /**
     * 存储在线客户端
     * key：客户端id
     * value：客户端会话对象
     */
    private static final ConcurrentHashMap<String, Session> ONLINE_CLIENTS = new ConcurrentHashMap<>();

    @SneakyThrows
    @OnOpen
    public void onOpen(Session session) {
        // 判断客户度ID是否存在于在线客户端集合中
        String id = session.getQueryString();
        if (ONLINE_CLIENTS.containsKey(id)) {
            CloseReason closeReason = new CloseReason(CloseReason.CloseCodes.CANNOT_ACCEPT, "客户端ID重复");
            session.getUserProperties().put("reason", closeReason);
            session.close();
            return;
        }
        // 记录客户端对象到在线客户端集合中
        ONLINE_CLIENTS.put(id, session);
        System.out.println("客户端(" + id + ")：连接成功");
    }

    @SneakyThrows
    @OnMessage
    public String onMessage(String message, Session session) {
        // 解析消息（ID::消息内容）
        String[] msgArr = message.split("::", 2);
        // 如果ID值为ALL表示群发
        String id = msgArr[0];
        String msg = msgArr[1];
        if ("ALL".equalsIgnoreCase(id)) {
            // 群发
            ONLINE_CLIENTS.forEach((k, v) -> {
                // 排除自己
                if (v == session) {
                    return;
                }
                // 发送消息
                try {
                    v.getBasicRemote().sendText(msg);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        } else {
            // 获取客户端会话对象
            Session target = ONLINE_CLIENTS.get(id);
            // 判断客户端会话对象是否存在
            if (target != null) {
                // 发送消息给指定用户
                target.getBasicRemote().sendText(msg);
            }
        }
        return session.getQueryString() + "：消息发送成功";
    }

    @OnClose
    public void onClose(Session session) {
        // 处理拒绝连接关闭
        String id = session.getQueryString();
        Object obj = session.getUserProperties().get("reason");
        if (obj instanceof CloseReason) {
            CloseReason reason = (CloseReason) obj;
            if (reason.getCloseCode() == CloseReason.CloseCodes.CANNOT_ACCEPT) {
                System.out.println("客户端(" + id + ")：拒绝连接关闭");
                return;
            }
        }
        // 移除客户端对象
        ONLINE_CLIENTS.remove(id);
        System.out.println("客户端(" + id + ")：连接关闭");
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        System.out.println("客户端(" + session.getQueryString() + ")：连接异常" + throwable.getMessage());
    }

    public void sendMessage(String id, Object message) {
        String messageStr = JSONUtil.toJsonStr(message);
        // 群发
        if("ALL".equalsIgnoreCase(id)) {
            ONLINE_CLIENTS.forEach((k, v) -> {
                // 发送消息
                try {
                    v.getBasicRemote().sendText(messageStr);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            return;
        }
        // 指定发送
        Session target = ONLINE_CLIENTS.get(id);
        if (target != null) {
            try {
                target.getBasicRemote().sendText(messageStr);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
