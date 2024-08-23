package pack.model;

import lombok.Data;

// 메시지 객체를 정의하는 모델 클래스. 
// 메시지의 타입(채팅, 입장, 퇴장), 발신자, 내용 등을 포함하고 있다. 
// 주로 WebSocket을 통해 주고받는 데이터의 구조를 정의.
@Data
public class ChatMessage {
	// 세 가지 주요 필드와 하나의 중첩된 열거형 타입을 포함
	
	// 메시지를 보낸 사용자의 이름(또는 닉네임)을 저장. 메시지의 발신자를 식별
    private String sender;
    private String content;  // 메시지의 본문을 저장
    // 메시지의 유형을 나타내며, MessageType이라는 열거형 타입으로 정의. 
    // 메시지가 어떤 종류의 메시지인지(채팅, 사용자 입장, 사용자 퇴장)를 나타낸다.
    private MessageType type;

    // 메시지의 유형을 정의
    public enum MessageType {
        CHAT,  // 일반적인 채팅 메시지
        JOIN,  // 새로운 사용자가 채팅방에 입장할 때 전송되는 메시지
        LEAVE  // 사용자가 채팅방을 떠날 때 전송되는 메시지
    }
}
