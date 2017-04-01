/*
 * Copyright 2012-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.github.yanglong.demo.annotation;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

@Component
@ServerEndpoint(value = "/reverse",configurator = CopySessionToWebSocketConfigurator.class)
public class ReverseWebSocketEndpoint {

	@OnMessage
	public void handleMessage(Session session, String message) throws IOException {
		session.getBasicRemote()
				.sendText("老咸鱼收到！");
	}

	@OnOpen
	public void connected(Session session,EndpointConfig config){
		String token=session.getRequestURI().getQuery();
		HttpSession httpSession=(HttpSession) config.getUserProperties().get(HttpSession.class.getName());
		System.out.println("on open");
	}

	@OnClose
	public void closed(Session session,CloseReason reason){
		System.out.println("on closed");
	}

	@OnError
	public void error(Session session,Throwable exception){
		exception.printStackTrace();
		System.out.println("on error");
	}
}
