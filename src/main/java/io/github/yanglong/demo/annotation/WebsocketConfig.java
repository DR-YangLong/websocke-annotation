package io.github.yanglong.demo.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * package: io.github.yanglong.demo.annotation <br/>
 * functional describe:enable WebSocket
 *
 * @author DR.YangLong [410357434@163.com]
 * @version 1.0    2017/3/30 15:19
 */
@EnableWebSocket
@Configuration
public class WebsocketConfig{

    @Bean
    public ServerEndpointExporter serverEndpointExporter(){
        return new ServerEndpointExporter();
    }
}
