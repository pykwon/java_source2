package pack;

public class Message2 implements MessageInter{
	@Override
	public void sayHello(String name) {
		String imsi = name + "씨";
		System.out.println("반가워요 " + imsi);
	}
}
