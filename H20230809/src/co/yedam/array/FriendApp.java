package co.yedam.array;
import java.util.*;
//집가서 정리해보기
public class FriendApp {
	static Scanner sc = new Scanner(System.in);
	static Friend[] friends = new Friend[10];
	static boolean check = false;
	static String name; 
	static String phone; 
	static String gender;
	
	public static boolean checkFriend(String name) {
		for(int i=0; i<friends.length; i++) {
			if(name.equals(friends[i].name) && friends[i] != null) {
				return true;
			}
		}
		return false;
	}
	
	public static void init() {
		for(int i=0; i<friends.length; i++) {
			friends[i] = new Friend("test"+i, "010", Gender.MAN);
		}
		
	}
	
	public static void printManual() {
		System.out.println("------------------------------------------------");
		System.out.println("| 1.추가 | 2.수정 | 3.삭제 | 4.조회 | 5.목록 | 6.종료 |");
		System.out.println("------------------------------------------------");
		System.out.print("선택>> ");
	}
	
	public static void addFriend() {
		System.out.print("이름 입력>> ");
		name = sc.next();
		System.out.print("번호 입력 (-제외)>> ");
		phone = sc.next();
		System.out.print("성별 입력(1:남자, 2:여자)>> ");
		int gen = sc.nextInt();
		Gender gender;
		if(gen == 1) gender = Gender.MAN;
		else gender = Gender.WOMAN;
		boolean check = false;
		for(int i=0; i<friends.length; i++) {
			if(friends[i]==null) {
				friends[i] = new Friend(name, phone, gender);
				System.out.printf("%s 님이 정상등록 되었습니다.\n", name);
				check=true;
				break;
			}
		}
		if(!check) System.out.println("입력할 수 없습니다.");
		
	}
	
	public static void modify() {
		System.out.print("이름 입력>> ");
		name = sc.next();
		if (!checkFriend(name)) {
			System.out.println(name+"님의 연락처가 없습니다.");
			return;
		}			
			for(int i=0; i<friends.length; i++) {
				if(name.equals(friends[i].name) && friends[i] != null) {
					System.out.print("수정할 새로운 연락처 입력>> ");
					String newNum = sc.next();
					String oldNum = friends[i].phone;
					friends[i].phone = newNum;
					System.out.println(oldNum + "  ->  "+friends[i].phone);
					return;
				}
			}
		}

	public static void del() {
		System.out.print("삭제할 이름 입력>> ");
		name = sc.next();
		if(!checkFriend(name)) {
			System.out.println(name+"님의 연락처가 없습니다.");
			return;
		}					
			for(int i=0; i<friends.length; i++) {
				if(name.equals(friends[i].name)) {
					friends[i] = null;
					System.out.println(name+"님의 연락처가 삭제되었습니다."); return;
				}
			}
	}

	
	public static void search() {
		System.out.print("조회할 이름 입력>> ");
		name = sc.next();
		if(!checkFriend(name)) {
			System.out.println(name+"님의 연락처가 없습니다.");
			return;
		}
		String ss="";					
			for(int i=0; i<friends.length; i++) {
				if(name.equals(friends[i].name) && friends[i]!=null) {
					friends[i].showInfo();
					break;
				}
			}


	}
	
	public static void seaList() {
		for(int i=0; i<friends.length; i++) {
			if(friends[i]!= null) {
				friends[i].briefInfo(i);
			}
		}
	}
	
	public static void main(String[] args) {
		//추가, 수정, 삭제, 조회. 목록
		boolean run = true;
		int count = 0;
		int sel;
//		for(int i=0; i<friends.length; i++) {
//			friends[i] = new Friend("연락처에 없습니다.", "없는 연락처", Gender.MAN);
//		}
		while(run) {
			printManual();
			sel = sc.nextInt();
			switch(sel) {
			case 1: //추가
				addFriend();
				break;
			case 2: //수정
				modify();
				break;
			case 3: //삭제
				del();
				break;
			case 4: //조회
				search();
				break;
			case 5: //목록 조회
				seaList();
				break;
			case 6: //종료
				System.out.println("프로그램을 종료하겠습니다");
				run = false;
				break;
			default:
				System.out.println("잘못 선택하였습니다.");
			}
			
			
			
		}
		
	}
}
