package co.yedam.api;
class Member {
	private int memberId;
	private String memberName;
	
	Member(int memberId, String memberName) {
		this.memberId = memberId;
		this.memberName = memberName;
	}
	
	
	
	@Override
	public String toString() {
		return "Member [memberId = " + memberId + ", memberName = " + memberName + "]";
	}



	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return memberId;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
//		return super.equals(obj);
		Member target = (Member) obj;
		if(this.memberId == target.memberId //
				&& this.memberName.equals(target.memberName)) {
			return true; //논리적으로 동일
		}
		else return false;
		
	}
}

public class EqualsExe {
	public static void main(String[] args) {
		String str1 = new String("Hong");
		String str2 = new String("Hong");
		
		Member mem1 = new Member(101, "Hing");
		Member mem2 = new Member(101, "Hong");
		
		System.out.println(mem1.equals(mem2));
	}
}
