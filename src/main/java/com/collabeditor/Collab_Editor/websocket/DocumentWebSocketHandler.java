package com.collabeditor.Collab_Editor.websocket;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class DocumentWebSocketHandler extends TextWebSocketHandler {

    // This class will handle WebSocket messages for document updates.
    // You can override methods like `handleTextMessage` to process incoming messages.

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();
        System.out.println("Received message: " + payload);
        session.sendMessage(new TextMessage(payload));
    }
}
