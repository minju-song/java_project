package co.yedam.variable;
import java.util.Scanner;

public class VariableExe2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int balance = 0; //10만원 이상 불가, 마이너스 금액 불가

		while(true) {
			
			System.out.println("| 1.예금 | 2.출금 | 3.잔고 | 4.종료 |");
			System.out.print("선택>> ");
			
			int menu = sc.nextInt();
			
			if(menu == 1) {
				System.out.print("입금액 입력>> ");
				int money = sc.nextInt();
				if(money >= 100000 || money <0) {
					System.out.println("금액이 적합하지 않습니다.");
					continue;
				}
				else {
					balance += money;
				}
			}
			else if(menu == 2) {
				System.out.print("출금액 입력>> ");
				int money = sc.nextInt();
				if (money > balance) {
					System.out.println("한도초과");
					continue;
				}
				else {
					balance -= money;
				}
				
			}
			else if(menu == 3) {
				if(balance<=0) {
					System.out.println("잔고없음");
				}
				else {
					
					System.out.println("잔고>> "+balance+"원");
				}
			}
			else if(menu == 4) break;
		}
		
		System.out.println("프로그램 종료");
	}
}

	
