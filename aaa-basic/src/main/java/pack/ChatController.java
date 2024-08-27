package pack;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController { 
	// 클라이언트가 "/app/message"로 전송한 메시지를 처리하는 메서드
	@MessageMapping("/message")
	// 처리된 메시지는 "/topic/messages"로 브로드캐스트된다.
	// 브로드캐스트:서버에서 받은 메시지를 연결된 모든 클라이언트에게 전송하는 것을 의미
	@SendTo("/topic/messages")
	public String sendMessage(String message) {
		return message; // 클라이언트로부터 받은 메시지를 그대로 반환
		// 메서드가 반환하는 메시지는 자동으로 /topic/messages 경로를 구독하고 있는 모든 클라이언트에게 전송
	}
}