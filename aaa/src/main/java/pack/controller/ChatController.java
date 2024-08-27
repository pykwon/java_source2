package pack.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;  
import org.springframework.messaging.handler.annotation.SendTo;  
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import pack.model.ChatMessage;

// WebSocket 메시지를 처리하는 컨트롤러 클래스. 
// 클라이언트로부터 받은 메시지를 처리하고, 이를 다른 클라이언트들에게 브로드캐스트하는 역할.
// Spring의 STOMP 메시징을 통해 작동하며, 메시지 매핑 및 브로드캐스트를 수행.
@Controller
public class ChatController {
    // 클라이언트가 "/app/chat.sendMessage" 경로로 전송한 메시지를 처리하는 메서드.
    // @MessageMapping클라이언트가 이 경로로 메시지를 보낼 때 이 메서드가 호출되도록 함
    @MessageMapping("/chat.sendMessage")

    // @SendTo 어노테이션은 이 메서드가 반환하는 메시지를 "/topic/public" 경로를 구독하는 모든 
    // 클라이언트에게 브로드캐스트하도록 한다.
    @SendTo("/topic/public")
    
    // 이 메서드는 클라이언트로부터 채팅 메시지를 수신하고, 해당 메시지를 반환하여 브로드캐스트함.
    public ChatMessage sendMessage(ChatMessage chatMessage) {
        return chatMessage;  
        // 메시지를 그대로 반환. 이 반환된 메시지는 "/topic/public" 주제로 브로드캐스트됨.
    }

    // 클라이언트가 "/app/chat.addUser" 경로로 전송한 메시지를 처리하는 메서드.
    // 새로운 사용자가 채팅방에 참여할 때 호출.
    @MessageMapping("/chat.addUser")

    // 이 메서드 또한 메시지를 "/topic/public" 경로로 브로드캐스트함.
    @SendTo("/topic/public")
    
    // 새로운 사용자가 채팅방에 참여할 때 호출.
    // 사용자 이름을 WebSocket 세션에 저장하고, 이를 다른 클라이언트들에게 브로드캐스트.
    public ChatMessage addUser(ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
        // WebSocket 세션에 사용자 이름을 저장. 세션은 클라이언트와 서버 간의 연결을 추적.
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());

        // 새로운 사용자 참여 메시지를 반환하여 다른 클라이언트들에게 브로드캐스트.
        return chatMessage;
    }
}
