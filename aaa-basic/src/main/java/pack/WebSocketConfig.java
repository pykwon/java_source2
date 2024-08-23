package pack;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

//웹소켓 서버 설정을 위한 설정 클래스
//@EnableWebSocketMessageBroker 어노테이션은 STOMP 웹소켓 메시징을 활성화함.

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
	@Override // 메시지 브로커를 구성
	public void configureMessageBroker(MessageBrokerRegistry config) {
		// "/topic"으로 시작하는 메시지는 메시지 브로커로 라우팅된다.
		config.enableSimpleBroker("/topic");
		// 클라이언트는 "/app"로 시작하는 메시지를 이 서버로 보내야 한다.
		config.setApplicationDestinationPrefixes("/app");
	}

	@Override // STOMP 엔드포인트를 등록
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		// "/ws" 엔드포인트는 SockJS 폴백 옵션을 통해 웹소켓을 사용할 수 있도록 설정한다.
		registry.addEndpoint("/ws").withSockJS();
	}
}