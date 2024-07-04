package pack;

public class MyProcess{  //setter injection 사용
	private int nai;
	private String name;
	private ShowData showData; 
	
	public MyProcess() {
		// TODO Auto-generated constructor stub
	}
	
	public void setNai(int nai) {
		this.nai = nai;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setShowData(ShowData showData) {
		this.showData = showData;
	}
	
	public void displayData() {
		System.out.println("이름은 " + name + 
				", 나이는 " + nai + 
				", 별명은 " + showData.processNickName() + 
				", 취미는 " + showData.processHobby()
		);
	}
}
