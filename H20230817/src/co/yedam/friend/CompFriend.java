package co.yedam.friend;

public class CompFriend extends Friend{
	private String company;
	private String department;

	public CompFriend(String name, String phone, String comp, String dep) {
		super(name, phone);
		this.company = comp;
		this.department = dep;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getCompany() {
		return company;
	}

	public String getDepartment() {
		return department;
	}


	@Override
	public String showInfo() {
		return super.showInfo()+"\t  회사 : "+company+"\t  부서 : "+department; 
	}
	
}
