package co.yedam.condition;
import java.util.*;
public class IfExe {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String grade = "";
		
		int score = (int) (Math.random()*100)+1;
		
		if(score>= 90) grade = "A";
		else if(score>=80) grade = "B";
		else if(score>=70) grade = "C";
		else if(score>=60) grade = "D";
		else grade = "F";
		
		System.out.printf("점수 %d점은 등급은 %s입니다.\n",score, grade);
		System.out.println("프로그램 종료");
		
		int score2=0;
		score2 = score / 10;
		switch(score2) {
		case 9:
			grade = "A"; break;
		case 8:
			grade = "B"; break;
		case 7:
			grade = "C"; break;
		case 6:
			grade = "D"; break;
		default:
			grade = "F";
		}
		
		System.out.printf("점수 %d점은 등급은 %s입니다.\n",score, grade);
		System.out.println("프로그램 종료");
	}

}
