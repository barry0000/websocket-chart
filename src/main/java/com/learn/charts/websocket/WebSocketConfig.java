package com.learn.charts.websocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketTransportRegistration;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

@Configuration
@EnableWebSocketMessageBroker //允许stomp协议
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer{
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/stomp")   //添加STOMP协议的端点。// 这个URL是供WebSocket客户端或SockJS客户端连接服务端访问的地址。
         .setAllowedOrigins("*").addInterceptors(new HttpSessionHandshakeInterceptor()). //添加允许跨域访问
         withSockJS();  //指定端点使用SockJS协议
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.setApplicationDestinationPrefixes("/app","/api") //客户端发送给服务端的前缀
                .enableSimpleBroker("/topic");  // 服务端推送给客户端的前缀
    }

}
