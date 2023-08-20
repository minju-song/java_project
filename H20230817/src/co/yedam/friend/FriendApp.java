package co.yedam.friend;
import java.util.*;

public class FriendApp {
	Friend[] friends = new Friend[10];
	Scanner sc = new Scanner(System.in);
	int idx = 0;
	public void start() {
		boolean run = true;
		int menu = -1;
		while(run) {	
			System.out.println();
			System.out.println("-------------[연락처]-------------");
			System.out.println("1.추가  2.조회  3.수정  4.삭제  5.종료");
			System.out.println("---------------------------------");
			System.out.print(">> ");
			try {				
				menu = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("메뉴 다시 선택하세요.");
				continue;
			} finally {
				sc.nextLine();
			}
		
			switch(menu) {
			case 1:
				add();
				break;
			case 2:
				search();
				break;
			case 3:
				modify();
				break;
			case 4:
				delete();
				break;
			case 5:
				System.out.println("프로그램 종료");
				run = false;
				break;
			default:
				System.out.println("잘못 선택하였습니다.");
			}
		
		}
	}
	
	private String printString(String msg) {
		System.out.print(msg+">> ");
		return sc.nextLine();
	}
	
	private void add() {
		boolean run = true;
		int select = -1;
		while(run) {			
			try {	
				System.out.println("1.회사친구  2.학교친구  3.기타");
				System.out.print(">> ");
				select = sc.nextInt();
				break;
			}
			catch (InputMismatchException e){
				System.out.println("다시 선택해주세요.");
				continue;
			} finally {
				sc.nextLine();
			}
		}
		String name = printString("이름입력");
		String phone = printString("번호입력");
		Friend friend = null;
		switch(select) {
		case 1:
			String company = printString("회사이름입력");
			String dep = printString("부서입력");
			friend = new CompFriend(name, phone, company, dep);
			break;
		case 2:			
			String univ = printString("학교이름입력");
			String major = printString("전공입력");
			friend = new UnivFriend(name, phone, univ, major);
			break;
		case 3:
			friend = new Friend(name, phone);
			break;
		}
		
		for(int i=0; i<friends.length; i++) {
			if(friends[i]==null) {
				friends[i] = friend;
				System.out.println(friends[i].getName()+"님이 추가되었습니다.");
				idx++;
				break;
			}
		}
	}
	
	private void search() {
		String name = printString("찾을 친구의 이름 입력 (엔터 시 전체목록)");
//		boolean ck = false;
		try {			
			for(int i=0; i<friends.length; i++) {
				if(friends[i]!=null && name.length()==0) {
//					if(i==idx) break;
					System.out.println(friends[i].showInfo());
					
//					ck=true;
				}
				else if(friends[i].getName().equals(name)) {
					System.out.println(friends[i].showInfo());
					break;
//					ck = true;
				}
			}
		}
		catch (NullPointerException e) {
			System.out.println(name+"님의 연락처가 없습니다.");
		}
//		if(ck == false) {
//			System.out.println(name+"님의 연락처가 없습니다.");
//		}
	}
	
	private void modify() {
		String name = printString("수정할 친구의 이름 입력");
//		boolean ck = false;
		try {			
			for(int i=0; i<friends.length; i++) {
				if(friends[i].getName().equals(name)) {
					String newPhone = printString("수정할 번호 입력");
					friends[i].setPhone(newPhone);
					System.out.println(friends[i].getName()+"님이 수정되었습니다.");
					break;
//				ck = true;
				}
			}
		} catch (NullPointerException e) {
			System.out.println(name+"님의 연락처가 없습니다.");
		}
	}
	
	private void delete() {
		String name = printString("삭제할 친구의 이름 입력");
//		boolean ck = false;
		try {			
			for(int i=0; i<friends.length; i++) {
				if(friends[i].getName().equals(name)) {
					friends[i] = null;
					System.out.println(name+"님이 삭제되었습니다.");
					idx--;
//					for(int j=i; j<friends.length-1; j++) {
//						friends[j] = friends[j+1];
//					}
//					friends[friend]
					break;
//				ck = true;
				}
			}
		} catch (NullPointerException e) {			
			System.out.println(name+"님의 연락처가 없습니다.");
		}

	}
	
}
