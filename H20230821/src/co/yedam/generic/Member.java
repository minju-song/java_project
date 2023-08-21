package co.yedam.generic;

public class Member {
	private int memberId;
	private String memberName;
	
	public Member(int id, String name) {
		this.memberId = id;
		this.memberName = name;
	}
	
	void setMemberID(int id) {
		this.memberId = id;
	}
	
	int getMemberID() {
		return this.memberId;
	}
	
	void setMemberName(String name) {
		this.memberName = name;
	}
	
	String getMemberName() {
		return memberName;
	}
}
