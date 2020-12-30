package com.guoyuhang;

import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    /**
     * 重载注册额消息处理器方法
     * @param webSocketHandlerRegistry
     */
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        //注册消息处理器
        //.withSockJS()添加sockjs功能
        webSocketHandlerRegistry.addHandler(marcoHandler(),"/marco").withSockJS();
    }

    @Bean
    public MarcoHandler marcoHandler() {
        return new MarcoHandler();
    }
}
