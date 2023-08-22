package co.yedam.friend;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class FriendApp {
	static Scanner sc = new Scanner(System.in);
	//추가, 수정, 삭제. 목록
	List<Friend> friends = new ArrayList<Friend>();
//	List
	
	public String printString(String str) {
		System.out.print(str+" 입력>> ");
		return sc.next();
	}
	
//	public boolean userCheck() {
//		
//	}
	
	public void start() {
		boolean run = true;
		while(run) {			
			System.out.println("===================================");
			System.out.println(" 1.추가 2.수정 3.삭제 4.목록 5.프로그램종료");
			System.out.println("===================================");
			int select = sc.nextInt();
			switch(select) {
			case 1:
				add();
				break;
			case 2:
				edit();
				break;
			case 3:
				del();
				break;
			case 4:
				list();
				break;
			case 5:
				run = false;
			}
		}
		System.out.println("프로그램 종료");
		
	}
	
	private void add() {
		String name = printString("이름");
		String phone = printString("번호");
		String date = printString("생일(YYMMDD)");
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
		Date birth = new Date();
		try {
			birth = sdf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Friend friend = new Friend(name, phone, birth);
		friends.add(friend);
		System.out.println(friend.getName()+"님이 추가되었습니다.");
		
	}
	
	private void edit() {
		boolean ck = false;
		String name = printString("수정할 친구의 이름");
		for(int i=0; i<friends.size(); i++) {
			if(name.equals(friends.get(i).getName())) {
				String phone = printString("새로운 연락처");
				friends.get(i).setPhone(phone);
				ck = true;
				break;
			}
		}
		String alert = (ck == true) ? name+"님이 수정되었습니다." : name+"님이 없습니다.";
		System.out.println(alert);
	}
	
	private void del() {
		boolean ck = false;
		String name = printString("삭제할 친구의 이름");
		for(int i=0; i<friends.size(); i++) {
			if(name.equals(friends.get(i).getName())) {
				friends.remove(i);
				ck = true;
				break;
			}
		}
		String alert = (ck == true) ? name+"님이 삭제되었습니다." : name+"님이 없습니다.";
		System.out.println(alert);
	}
	private void list() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
		for(int i=0; i<friends.size(); i++) {
			System.out.println(friends.get(i).toString());
		}
	}
}
