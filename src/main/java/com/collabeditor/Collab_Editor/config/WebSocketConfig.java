package com.collabeditor.Collab_Editor.config;

import com.collabeditor.Collab_Editor.websocket.DocumentWebSocketHandler;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

public class WebSocketConfig implements WebSocketConfigurer {
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(new DocumentWebSocketHandler(), "/ws/document")
                .setAllowedOrigins("*");
    }
}
