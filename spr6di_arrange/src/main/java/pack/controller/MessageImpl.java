package pack.controller;

import pack.model.MyInfoInter;
import pack.other.OutFileInter;

public class MessageImpl implements MessageInter{
	//MessageInter 타입의 파생 클래스 중 하나로 MessageImpl 작성.
	private String message1, message2;  // constructor injection용
	private int year;
	private MyInfoInter infoInter;
	
	private String spec;   // setter injection용
	private OutFileInter fileInter;
	
	public MessageImpl(String message1, String message2, 
			int year, MyInfoInter infoInter) {
		this.message1 = message1;
		this.message2 = message2;
		this.year = year;
		this.infoInter = infoInter;
	}
	
	public void setSpec(String spec) {
		this.spec = spec;
	}
	
	public void setFileInter(OutFileInter fileInter) {
		this.fileInter = fileInter;
	}
	
	@Override
	public void sayHi() {
		String msg = "MessageImpl 클래스에서 sayHi 내용 : ";
		msg += "\n" + message1 + " " + message2;
		msg += "\n" + (year + 2000) + "년";
		msg += "\n" + infoInter.myData();
		msg += "\n" + spec;
		
		System.out.println(msg);  // console로 출력
		
		// 위 메세지를 파일로 출력하기
		fileInter.outFile(msg);
	}
}
