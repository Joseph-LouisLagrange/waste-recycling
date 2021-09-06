package com.darwin.wasterecycling.config.websocket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

@Slf4j
@ServerEndpoint(value = "/webSocket")
@Component
public class WsServerEndpoint {

    @OnOpen
    public void onOpen(Session session) {
        session.getOpenSessions().add(session);
        log.debug("WebSocket onOpen sessionId:{}",session.getId());
    }


    @OnClose
    public void onClose(Session session) {
        log.debug("WebSocket onClose sessionId:{}",session.getId());
    }


    @OnMessage
    public String onMsg(Session session,String text) throws IOException {
        log.debug("WebSocket onMsg: {} ,sessionId:{}",text,session.getId());
        return "ccc";
    }

    @OnError
    public void onError(Throwable t) {

    }
}
