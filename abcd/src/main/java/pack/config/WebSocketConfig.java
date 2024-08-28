package pack.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker  // WebSocket 메시지 브로커를 활성화하는 Spring 애너테이션. 
// STOMP 프로토콜을 통해 메시지를 처리할 수 있도록 Spring의 메시지 처리 인프라를 설정한다.

//WebSocket 설정을 위한 구성 클래스. 
//WebSocketMessageBrokerConfigurer 인터페이스를 구현하여 WebSocket 메시지 브로커 설정을 정의.
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {  
    @Override
    // 메시지 브로커를 구성하는 메서드 : 메시지가 어떤 경로를 통해 라우팅될지를 설정.
    public void configureMessageBroker(MessageBrokerRegistry config) {
    	// "/topic"으로 시작하는 메시지 경로를 처리하는 간단한 메모리 기반 메시지 브로커를 활성화. 
    	// 주로 클라이언트로 전달되는 메시지를 브로커가 처리한다.
        config.enableSimpleBroker("/topic");   
        
        //// 클라이언트에서 서버로 보내는 메시지의 경로에 "/app" 접두사를 설정한다. 
        // 예를 들어 클라이언트가 "/app/hello"로 메시지를 보내면, 
        // 서버에서 해당 경로를 처리하는 핸들러가 실행.
        config.setApplicationDestinationPrefixes("/app");  
    }

    @Override
    // STOMP 프로토콜을 통해 WebSocket 연결을 설정할 엔드포인트를 등록하는 메서드.
    public void registerStompEndpoints(StompEndpointRegistry registry) {  
        registry.addEndpoint("/ws").withSockJS();  
        // "/ws" 엔드포인트를 등록해 클라이언트가 이 경로로 WebSocket 연결을 할 수 있도록 한다. 
        // 또한, SockJS 폴백 옵션을 활성화하여 WebSocket을 지원하지 않는 브라우저에서 
        // HTTP 기반 전송을 사용할 수 있도록 한다.
    }
}