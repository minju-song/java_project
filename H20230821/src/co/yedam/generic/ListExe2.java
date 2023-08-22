package co.yedam.generic;

import java.util.*;

public class ListExe2 {
	public static void main(String[] args) {
		List<Member> list = new ArrayList<Member>();
		list.add(new Member(1001,"Hong"));
		Member member = new Member(1002, "Hwang");
		list.add(member);
		
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getMemberID() == 1001) list.remove(i);
//				list.get(i).setMemberName("홍");
		}
		
		for (Member mem : list) {
			System.out.println("("+mem.getMemberID()+") "+"이름: "+mem.getMemberName());
		}
	}
}
