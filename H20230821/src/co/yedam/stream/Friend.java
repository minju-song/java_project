package co.yedam.stream;

import java.text.SimpleDateFormat;
import java.util.*;

public class Friend {
	private String name;
	private String phone;
	private Date birth; //1998-08-05 sdf.parse("1998-08-05")
	
	public Friend(String name, String phone, Date birth) {
		super();
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
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	
	public String getName() {
		return name;
	}
	public String getPhone() {
		return phone;
	}
	public Date getBirth() {
		return birth;
	}
	
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
		return "이름: "+name+ "\t 번호: "+phone+"\t 생일: "+sdf.format(birth);
	}
}
