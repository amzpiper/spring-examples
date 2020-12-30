package com.guoyuhang;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class MarcoHandler2 extends TextWebSocketHandler {

    private static final Logger logger = LoggerFactory.getLogger(MarcoHandler2.class);

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        //建立连接
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        //关闭连接
    }
}
