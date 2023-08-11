package co.yedam.classes.friend;
import java.util.Date;

public class Friend {
	private String name;
	private String phone;
//	private Date birth;
	private String birth;

	public Friend(String name, String phone, String birth) {
		this.name = name;
		this.phone = phone;
		this.birth = birth;
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



	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

	public String getBirth() {
		return birth;
	}



	@Override
	public String toString() {
		return "Friend [name=" + name + ", phone=" + phone + ", birth=" + birth + "]";
	}
	
	
	
}
