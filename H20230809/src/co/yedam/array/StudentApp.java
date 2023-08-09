package co.yedam.array;
import java.util.*;

public class StudentApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Student[] students = new Student[10];
		//1.등록  2.조회  3.목록  
		int people=0;
		int sel;
		boolean run =true;
		while(run) {
			System.out.println("-----------------------------");
			System.out.println("1.등록   | 2.조회 | 3.목록 | 4.종료");
			System.out.println("-----------------------------");
			System.out.print("선택>> ");
			sel = sc.nextInt();
			switch(sel) {
			case 1: 
				System.out.print("이름과 점수 입력>> ");
				String name = sc.next();
				int score = sc.nextInt();
				students[people] = new Student(name, score);
				people++; break;
			case 2:
				System.out.print("찾을 학생의 이름 입력>> ");
				String search = sc.next();
				boolean check = false;
				for(int i=0; i<people; i++) {
					if(search.equals(students[i].name)) {
						System.out.printf("%s 학생의 점수는 %d점입니다.\n",students[i].name, students[i].score );
						check = true;
						break;
					}
				}
				if (check == false) System.out.println("찾는 학생이 없습니다.");
				break;
			case 3:
				System.out.println("목록 조회");
				for(int i=0; i<people; i++) {
					System.out.printf("[%s] %d점\n",students[i].name, students[i].score);
				}
				break;
			case 4:
				run = false; break;
				
			}
		}
		System.out.println("시스템 종료");
		
	}

}
