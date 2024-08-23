package pack.config;  
import org.springframework.context.annotation.Configuration;  
import org.springframework.messaging.simp.config.MessageBrokerRegistry;  
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;  
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;  
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;  

// WebSocket 설정을 담당하는 구성 클래스이다.
// WebSocketConfig 클래스는 WebSocket 메시지 브로커와 STOMP 엔드포인트를 설정.
// 이 클래스는 WebSocket 연결을 위한 설정을 포함한다.
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {  
// WebSocketMessageBrokerConfigurer 인터페이스를 구현하여 WebSocket 구성을 설정.

    // 메시지 브로커를 구성하는 메서드
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        // 메시지 브로커를 활성화하여 "/topic" 접두어를 가진 메시지를 처리.
        // 이 브로커는 클라이언트 간의 메시지 전달을 처리하는 역할.
        config.enableSimpleBroker("/topic");
        
        // 클라이언트가 서버로 메시지를 보낼 때 "/app" 접두어를 사용하게 한다.
        // 예를 들어, 클라이언트는 "/app/chat.sendMessage"와 같은 경로로 메시지를 보낸다.
        config.setApplicationDestinationPrefixes("/app");
    }

    // STOMP 엔드포인트를 등록하는 메서드
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // 클라이언트가 연결할 수 있는 WebSocket 엔드포인트를 "/ws"로 등록한다.
        // SockJS 폴백 옵션을 추가하여 WebSocket을 사용할 수 없는 경우에 대체 전송 메커니즘을 사용할 수 있도록 함.
        registry.addEndpoint("/ws").withSockJS();
    }
}
