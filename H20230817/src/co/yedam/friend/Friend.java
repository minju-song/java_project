package co.yedam.friend;
//친구의 연락처 정보
//학교친구 - 이름,연락처,학교이름,전공
//회사친구 - 이름,연락처,회사이름,부서
//친구 -- 이름,연락처
public class Friend {
	private String name;
	private String phone;
	
	public Friend(String name, String phone) {
		this.name = name;
		this.phone = phone;
	}
	
	public String getName() {
		return name;
	}
	public String getPhone() {
		return phone;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String showInfo() {
		return "이름 : "+name+"\t  번호 : "+phone;
	}
	
}
