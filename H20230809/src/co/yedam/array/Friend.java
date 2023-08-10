package co.yedam.array;

public class Friend {
	String name;
	String phone;
	Gender gender;
	
	Friend(String name, String phone, Gender gender) {
		this.name = name;
		this.phone = phone;
		this.gender = gender;
	}
	
	void showInfo() {
		String gen="";
		if(gender == Gender.MAN) gen = "남자";
		else gen="여자";
		System.out.printf("이름 : %s ,  연락처 : %s,  성별 : %s\n",name, phone,gen);
	}
	
	void briefInfo(int count) {
		System.out.printf("[%d] 이름 : %s, 연락처 : %s\n",count+1, name, phone);
	}
}
