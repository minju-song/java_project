package co.yedam.array;
import java.util.*;

class Member {
	String name;
	int score;

}

public class ScoreApp {
	static Scanner sc = new Scanner(System.in);
	static Member scores[]=null;
	
	public static void printManual() {
		System.out.println("-------------------------------------------------");
		System.out.println("| 1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료 |");
		System.out.println("-------------------------------------------------");
		System.out.print("선택> ");
	}
	
	public static void stdNum() {
		System.out.print("학생 수> ");
		int n = sc.nextInt();;
		scores = new Member[n];
		for(int i=0; i<scores.length; i++) {
			scores[i] = new Member();
			scores[i].name = "";
			scores[i].score = 0;
		}
	}
	
	public static void addScore() {
		for(int i=0; i<scores.length; i++) {
			System.out.printf("[%d]이름 점수> ", i);
			String []data = sc.nextLine().split(" ");
			scores[i].name = data[0];
			scores[i].score = Integer.parseInt(data[1]);
		}
	}
	
	public static void scoreList() {
		for(int i=0; i<scores.length; i++) {
			System.out.printf("%s> %d점\n", scores[i].name, scores[i].score);
		}
	}
	
	public static void analy() {
		double sum = 0;
		Member max = scores[0];
		for(int i=0; i<scores.length; i++) {
			sum += scores[i].score;
			if(max.score<scores[i].score) max = scores[i];
		}
		System.out.printf("최고 점수: %d (%s)\n"+max.score, max.name);
		System.out.println("평균 점수: "+(double)(sum/scores.length));
	}
	
	
	
	public static void main(String[] args) {
		boolean run = true;
		int menu;
		
		while(run) {
			printManual();
			menu = sc.nextInt();
			switch(menu) {
			case 1:
				stdNum();
				break;
			case 2:
				addScore();
				break;
			case 3:
				scoreList();
				break;
			case 4:
				analy();
				break;
			case 5:
				run =false;
			}
		}
		System.out.println("프로그램 종료");
		
	}
}
