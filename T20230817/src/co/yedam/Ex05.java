package co.yedam;
import java.util.*;

public class Ex05 {
	static Scanner sc = new Scanner(System.in);
	static Friend [] friends = new Friend[10];
	
	public static String toString(String msg) {
		System.out.print(msg+">> ");
		return sc.next();
	}
	
	public void start() {
		boolean run = true;
		while(run) {			
			System.out.println();
			System.out.println("--------------------------------------");
			System.out.println("1.등록  2.목록  3.전화번호수정  4.삭제  5.종료");
			System.out.println("--------------------------------------");
			System.out.print(">> ");
			int select = sc.nextInt();
			
			switch(select) {
			case 1:
				register();
				break;
			case 2:
				list();
				break;
			case 3:
				modify();
				break;
			case 4:
				remove();
				break;
			case 5:
				System.out.println("프로그램 종료");
				run = false;
				break;
			}
		}
	}
	
	 public void register() {
		String name = toString("친구 이름");
		String phone = toString("전화번호");
		String birth = toString("생년월일");
		System.out.print("키>> ");
		double height = sc.nextDouble();
		
		Friend friend = new Friend(name, phone, birth, height);
		for(int i=0; i<friends.length; i++) {
			if(friends[i]==null) {
				friends[i] = friend;
				System.out.println(name+"님이 등록되었습니다.");
				break;
			}
		}
	}
	 
	 public void list() {
		 for(int i=0; i<friends.length; i++) {
			 if(friends[i]!=null) {
				 System.out.println("이름:"+friends[i].getName()+"\t전화번호:"+friends[i].getPhone()+"\t생년월일:"+friends[i].getBirth()+"\t키:"+friends[i].getHeight());
			 }
		 }
	 }
	 
	 public void modify() {
		 boolean ck = false;
		 String name = toString("수정하려는 이름");
		 for(int i=0; i<friends.length; i++) {
			 if(friends[i]!=null && name.equals(friends[i].getName())) {
				 String phone = toString("새로운 전화번호");
				 friends[i].setPhone(phone);
				 System.out.println(name+"님의 전화번호를 "+friends[i].getPhone()+"으로 수정하였습니다.");
				 ck = true;
				 break;
			 }
		 }
		 if (ck==false) {
			 System.out.println(name+"님이 없습니다.");
		 }
	 }
	 
	 public void remove() {
		 boolean ck = false;
		 String name = toString("삭제할 이름");
		 for(int i=0; i<friends.length; i++) {
			 if(friends[i]!=null && name.equals(friends[i].getName())) {
				 friends[i] = null;
				 System.out.println(name+"님이 삭제되었습니다.");
				 ck = true;
				 break;
			 }
		 }
		 if (ck==false) {
			 System.out.println(name+"님이 없습니다.");
		 }
	 }
	
	
	
	public static void main(String[] args) {
		
		Ex05 ex = new Ex05();
		ex.start();
		
		

	}

}
