package co.yedam.friend;

public class UnivFriend extends Friend {

	private String university;
	private String major;
	
	public UnivFriend(String name, String phone, String univ, String major) {
		super(name, phone);
		this.university = univ;
		this.major = major;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getUniversity() {
		return university;
	}

	public String getMajor() {
		return major;
	}

	@Override
	public String showInfo() {
		return super.showInfo() + "\t  학교 : "+university+"\t  전공 : "+major;
	}
	
}
