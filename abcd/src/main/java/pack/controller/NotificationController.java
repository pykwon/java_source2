package pack.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import pack.model.MyNotification;

@Controller
public class NotificationController {
	// 클라이언트가 '/app/friend-request' 경로로 메시지를 보내면 이 메서드가 호출된다. 
	// STOMP 프로토콜을 사용해 메시지를 처리할 때 사용된다.
    @MessageMapping("/friend-request")
    // 이 메서드가 반환하는 값은 '/topic/notifications' 경로를 구독하는 모든 클라이언트에게 전송된다.
    @SendTo("/topic/notifications")
    public MyNotification friendRequest(String fromUser) {
    	if (fromUser == null || fromUser.trim().isEmpty()) {
            fromUser = "알 수 없는 사용자"; // 기본 사용자 이름 설정
        }
        return new MyNotification("친구 요청", fromUser + "님이 친구 요청을 보냈습니다.");
        // 새로운 MyNotification 객체를 생성하여 반환 
    }

    @MessageMapping("/comment")
    @SendTo("/topic/notifications")
    public MyNotification comment(String fromUser) {
    	if (fromUser == null || fromUser.trim().isEmpty()) {
            fromUser = "익명 사용자"; // 기본 사용자 이름 설정 
        }
        return new MyNotification("댓글", fromUser + "님이 게시물에 댓글을 달았습니다.");
    }

    @MessageMapping("/like")
    @SendTo("/topic/notifications")
    public MyNotification like(String fromUser) {
    	if (fromUser == null || fromUser.trim().isEmpty()) {
            fromUser = "알 수 없는 사용자"; // 기본 사용자 이름 설정
        }
        return new MyNotification("좋아요", fromUser + "님이 게시물을 좋아해요.");
    }
}
