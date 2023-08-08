package co.yedam.variable;
import java.util.Scanner;

public class VariableEx5 {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int score[] = null;
		
		
		int sel=0;
		while(sel!=5) {
			System.out.println("----------------------------------------------");
			System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
			System.out.println("----------------------------------------------");
			System.out.print("선택>> ");
			sel = sc.nextInt();
			int num = 0;
			switch(sel) {
			case 1: 
				System.out.print("학생수>> ");
				num = sc.nextInt();
				score = new int[num];
				break;
			case 2: 
				for(int i=0; i<score.length; i++) {
					System.out.printf("score[%d]>> ",i);
					score[i] = sc.nextInt();
				}
				break;
			case 3:
				for(int i=0; i<score.length; i++) {
					System.out.printf("score[%d]>> %d\n",i, score[i]);
				}
				break;
			case 4:
				int max=score[0]; int min = score[0]; int sum=0;
				for(int i=0; i<score.length; i++) {
					if(score[i]>max) max = score[i];
					if(score[i]<min) min = score[i];
					sum += score[i];
				}
				System.out.println("최고점수 : "+max);
				System.out.println("최저점수 : "+min);
				System.out.println("평균 : "+(double)(sum/score.length));
				break;
				
			}
		}
		System.out.println("프로그램 종료");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		String numStr = "123";
//		int num = Integer.parseInt(numStr);
//		System.out.println(num);
//		
//		int sum = 0;
//		
//		while(true) {
//			System.out.print("정수값 입력 (종료는 quit)>> ");
//			String str = sc.nextLine();
//			
//			if (str.equals("quit")) {
//				break;
//			}
//			
//			int n = Integer.parseInt(str);
//			if(n>100 || n<0) continue;
//			sum += n;
//		}
//		
//		System.out.println("입력한 값의 합게 : "+sum);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		System.out.println("------사칙연산 계산기------");
//		System.out.println("1)더하기  2)빼기   3)곱하기   4)나누기   5)종료");
//		while(true) {
//			System.out.print("메뉴 선택>>");
//			int sel = sc.nextInt();
//			if(sel == 5 ) { System.out.println("프로그램 종료"); break;}
//			System.out.print("연산할 숫자 두 개 입력(공백구분)");
//			int a = sc.nextInt();
//			int b = sc.nextInt();
//			int result = 0;
//			switch(sel) {
//			case 1: result = a+b; break;
//			case 2: result = a-b; break;
//			case 3: result = a*b; break;
//			case 4: result = a/b; break;
//			default : System.out.println("번호 다시 입력");
//			
//			}
//			
//			System.out.println("결과 : "+result);
//		}
	}
}
