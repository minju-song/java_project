package co.yedam.prac;

import java.util.*;

public class SeatApp {
	static Scanner sc = new Scanner(System.in);
	
	Seat[][] all = new Seat[3][10];
	String grade[] = {"S","A","B"};
	
	public void init(Seat[][] arr) {
		for(int i=0; i<all.length; i++) {
			for(int j=0; j<all[i].length; j++) {
				Seat seat = new Seat();
				all[i][j] = seat;
			}
		}
	}
	
	public String printString(String str) {
		System.out.print(str+">> ");
		return sc.next();
	}
	
	public void start() {

		init(all);

		System.out.println("명품콘서트홀 예약 시스템입니다.");
		boolean run = true;
		while(run) {
			System.out.print("예약:1, 조회:2, 취소:3, 끝내기:4 >> ");
			int menu = sc.nextInt();
			switch(menu) {
			case 1:
				reserv();
				break;
			case 2:
				showAll();
				break;
			case 3:
				cancel();
				break;
			case 4:
				System.out.println("프로그램 종료");
				run = false;
			}
		}
	}
	
	public void reserv() {
		System.out.print("좌석구분 S(1), A(2), B(3)>> ");
		int seatGrade = sc.nextInt();
		showSeat(seatGrade);
		String name = printString("이름");
		System.out.print("번호>> ");
		int n = sc.nextInt();
		all[seatGrade-1][n-1].setName(name);
	}
	
	public void showSeat(int n) {
		System.out.print(grade[n-1]+">> ");
		for(int i=0; i<all[n-1].length; i++) {
			System.out.print(all[n-1][i].getName()+" ");
		}
		System.out.println();
	}
	
	public void showAll() {
		for(int i=0; i<all.length; i++) {
			System.out.print(grade[i]+">> ");
			for(int j=0; j<all[i].length; j++) {
				System.out.print(all[i][j].getName()+" ");
			}
			System.out.println();
		}
		System.out.println("<<<조회를 완료하였습니다.>>>");
	}
	
	public void cancel() {
		System.out.print("좌석 S:1, A:2, B:3>> ");
		int seat = sc.nextInt();
		showSeat(seat);
		String name = printString("이름");
		for(int i=0; i<all[seat-1].length; i++) {
			if(name.equals(all[seat-1][i].getName())) {
				all[seat-1][i].setName("---");
			}
			
		}
	}
	
}
