package co.yedam.classes.friend;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class FriendApp {
	Friend[] friends = new Friend[10];
	Scanner sc = new Scanner(System.in);
	
	FriendApp() {
		
	}
	
	void addFriend() {
		System.out.print("이름, 연락처, 생년월일>> ");
		String[] data = sc.nextLine().split(" ");
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
//		Date birth = null;
		Friend friend = new Friend(data[0], data[1], data[2]);
		
		for(int i=0; i<friends.length; i++) {
			if(friends[i]==null) {
				friends[i] = friend;
				break;
			}
		}
	}
	
	
	void list() {
		for(int i=0; i<friends.length; i++) {
			if(friends[i]!=null) {
				System.out.println(friends[i].toString()\);
			}
		}
	}
	
	
	static void start() {
		FriendApp app = new FriendApp();
		Scanner scn = app.sc;
		
		
		System.out.println("1.등록 | 2.목록 | 9.종료");
		System.out.println("선택>> ");
		
		int menu = Integer.parseInt(scn.nextLine());
		
		switch(menu) {
		case 1:
			break;
		case 2:
			break;
		case 9:
		}
	}
	
	
}
