package pack.config;  
import org.springframework.context.event.EventListener;  
import org.springframework.messaging.simp.SimpMessagingTemplate;  
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;  
import org.springframework.stereotype.Component;  
import org.springframework.web.socket.messaging.SessionDisconnectEvent;  
import pack.model.ChatMessage;  

// WebSocket 세션의 연결 및 연결 해제 이벤트를 처리하는 클래스
// 특히 클라이언트의 연결이 끊어졌을 때 SessionDisconnectEvent를 감지하여, 해당 클라이언트의 퇴장 메시지를 브로드캐스트하는 역할.
@Component  // 이 클래스가 Spring에서 관리되는 컴포넌트임을 명시.
public class WebSocketEventListener {

    private final SimpMessagingTemplate messagingTemplate;  // 메시지를 브로드캐스트하기 위한 SimpMessagingTemplate 인스턴스를 선언.

    // SimpMessagingTemplate 인스턴스를 주입받는 생성자
    public WebSocketEventListener(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;  // 생성자로 전달받은 SimpMessagingTemplate 인스턴스를 클래스 필드에 할당
    }

    // WebSocket 연결이 끊어졌을 때 호출되는 메서드
    // 이 메서드는 Spring의 이벤트 리스너로서 SessionDisconnectEvent를 감지
    @EventListener
    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
        // StompHeaderAccessor를 사용하여 STOMP 메시지의 헤더 정보를 액세스할 수 있게 래핑
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
        
        // WebSocket 세션에 저장된 "username" 속성을 가져온다.
        String username = (String) headerAccessor.getSessionAttributes().get("username");
        
        // 만약 username이 null이 아니면, 해당 사용자의 퇴장 메시지를 생성하여 브로드캐스트.
        if (username != null) {
            ChatMessage chatMessage = new ChatMessage();  // 새로운 ChatMessage 인스턴스를 생성
            chatMessage.setType(ChatMessage.MessageType.LEAVE);  // 메시지의 타입을 'LEAVE'로 설정.
            chatMessage.setSender(username);  // 메시지의 발신자를 WebSocket 세션에서 가져온 username으로 설정.

            // 메시지를 "/topic/public" 주제로 브로드캐스트.
            // 이를 통해 모든 구독된 클라이언트가 사용자의 퇴장 메시지를 수신하게 된다.
            messagingTemplate.convertAndSend("/topic/public", chatMessage);
        }
    }
}
