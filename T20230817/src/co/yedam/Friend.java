package co.yedam;

public class Friend {
	private String name;
	private String phone;
	private String birth;
	private double height;
	
	Friend(String name, String phone, String birth, double height) {
		this.name = name;
		this.phone = phone;
		this.birth = birth;
		this.height = height;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public String getName() {
		return name;
	}
	public String getPhone() {
		return phone;
	}
	public String getBirth() {
		return birth;
	}
	public double getHeight() {
		return height;
	}
	
	public void showInfo() {
		System.out.println("이름:"+name+"\t전화번호:"+phone+"\t생년월일:"+birth+"\t키:"+height);
	}
	
}
