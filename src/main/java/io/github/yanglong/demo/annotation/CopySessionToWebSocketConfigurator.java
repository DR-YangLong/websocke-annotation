package io.github.yanglong.demo.annotation;

import javax.servlet.http.HttpSession;
import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;

/**
 * package: io.github.yanglong.demo.annotation <br/>
 * functional describe:get session property in WebSocket handshake
 * {@see org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor}
 * the same question:<br/>
 * <a href="http://stackoverflow.com/questions/17936440/accessing-httpsession-from-httpservletrequest-in-a-web-socket-serverendpoint">accessing-httpsession-from-httpservletrequest-in-a-web-socket-serverendpoint</a>
 *
 * @author DR.YangLong [410357434@163.com]
 * @version 1.0    2017/3/31 10:14
 */
public class CopySessionToWebSocketConfigurator extends ServerEndpointConfig.Configurator {
    @Override
    public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response) {
        if (request.getHttpSession() != null) {
            HttpSession session = (HttpSession) request.getHttpSession();
            sec.getUserProperties().put(HttpSession.class.getName(),session);
        }
    }
}
