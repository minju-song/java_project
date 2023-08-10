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
			System.out.println("---------------------------------------------");
			System.out.println("| 1.등록 | 2.조회 | 3.목록 | 4.키 큰 학생 | 5.종료 |");
			System.out.println("---------------------------------------------");
			System.out.print("선택>> ");
			sel = sc.nextInt();
			switch(sel) {
			case 1: 
				System.out.print("이름 입력>> ");
				String name = sc.next();
				System.out.print("점수 입력>> ");
				int score = sc.nextInt();
				System.out.print("키 입력>> ");
				double height = sc.nextDouble();	
				students[people] = new Student(name, score, height,Gender.WOMAN);
				people++; break;
			case 2:
				System.out.print("찾을 학생의 이름 입력>> ");
				String search = sc.next();
				boolean check = false;
				for(int i=0; i<people; i++) {
					if(search.equals(students[i].name)) {
						System.out.printf("%s 학생의 점수는 %d점입니다. (키 : %.1f)\n",students[i].name, students[i].score, students[i].height );
						check = true;
					}
				}
				if (!check) System.out.printf("찾으시는 %s 학생이 없습니다.\n", search);
				break;
			case 3:
				System.out.println("목록 조회");
				for(int i=0; i<people; i++) {
					System.out.printf("[%s (키:%.1f)] %d점\n",students[i].name,students[i].height, students[i].score);
				}
				break;
			case 4:
				Student max = students[0];
				for(int i=0; i<people; i++) {
					if(max.height<students[i].height) {
						max = students[i];
					}
				}
				System.out.printf("가장 키가 큰 학생은 %s 입니다. (키: %.1f)\n", max.name, max.height);
				break;
			case 5:
				run = false; 
				
			}
		}
		System.out.println();
		System.out.println("<<<<<<<<<<<<<<<<프로그램 종료>>>>>>>>>>>>>>>>");
	}

}
