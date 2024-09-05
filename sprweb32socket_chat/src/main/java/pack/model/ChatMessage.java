package pack.model;

import lombok.Data;

// 메세지 객체(데이터 구조)를 정의. 메세지 타입(입장,채팅,퇴장), 발신자, 내용등을 정의
@Data
public class ChatMessage {
	private String sender;   // 채팅명 식별
	private String content;  // 메세지 내용
	private MessageType type;
	
	public enum MessageType{  // 열거형(상수값을 그룹화하여 코드의 안전성, 가독성 향상)을 이용해 메세지 유형 정의 
		JOIN, 
		CHAT,
		LEAVE
	}
}
