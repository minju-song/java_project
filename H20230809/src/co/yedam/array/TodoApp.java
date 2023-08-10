package co.yedam.array;
import java.util.*;
public class TodoApp {
	static Scanner sc = new Scanner(System.in);
	static Todo[] arr = new Todo[20];
	static int idx=0;

	public static void printManual() {
		System.out.println("---------------------------------------");
		System.out.println("| 1.등록 | 2.완료 | 3.조회 | 4.미완료 | 5.종료 |");
		System.out.println("---------------------------------------");
		System.out.print("선택> ");
	}
	
	public static void addTodo() {
		System.out.printf("[%d] 번호, 할일, 날짜를 공백으로 구분하여 입력>> ",idx);
		int num = sc.nextInt();
		String to = sc.next();
		String day = sc.next();
		arr[idx] = new Todo(num, to, day);
		idx++;
		System.out.println(day+"의 할일을 등록하였습니다.");
	}
	
	public static void complete() {
		System.out.print("완료시킬 To do의 번호를 입력하세요>> ");
		String [] data = sc.nextLine().split(" ");
		for(int i=0; i<data.length; i++) {
			int s = Integer.parseInt(data[i]);
			for(int j=0; j<arr.length; j++) {
				if(arr[j]!=null && s == arr[j].no) {
					System.out.print(arr[j].no+"번 "); arr[j].done = true;
				}
			}
		}
		System.out.println("완료");
	}
	
	public static void search() {
		System.out.print("조회할 날짜 입력>> ");
		String s = sc.nextLine();
		System.out.printf("%s>> ", s);
		for(Todo e : arr) {
			if ( e != null && s.equals(e.dueDate)) {
				System.out.print(e.todo+" ");
			}
		}
		System.out.println();
	}
	
	public static void print() {
		int len = arr.length - 1;
		for(int i=0; i<len; i++) {
			for(int j=0; j<len; j++) {
				if(arr[j] != null &&  arr[j+1]!=null && arr[j].no > arr[j+1].no) {
					Todo temp;
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		for(int i=0; i<arr.length; i++) {
			if (arr[i] != null && arr[i].done == false) {				
				System.out.println(arr[i].no + ", "+arr[i].todo);
			}
		}
		
	}
	
	public static void main(String[] args) {
		//등록/완료/조회(날짜)/미완료/
		//등록 : 순번나오면 [2 할일 0823] 형식으로 입력
		//완료 : 1 2 4 엔터치면 124의 상태가 완료가 됨 (한번에 여러건 입력)
		//조회 : 0812 넣으면 출력 (완료, 미완료 둘다)
		//미완료 : 미완료는 모두 출력 순번기준으로 보여주기
		boolean run = true;
		while(run) {
			printManual();
			int select = sc.nextInt();
			sc.nextLine();
			
			switch(select) {
			case 1:
				addTodo();
				break;
			case 2:
				complete();
				break;
			case 3:
				search();
				break;
			case 4:
				print();
				break;
			case 5:
				run = false;
			}
		}
		System.out.println("Todo 프로그램 종료");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void sortSample() {
		int[] intAry = {45,23,90,77,12};
		int len = intAry.length-1;
		for(int j=0; j<len; j++) {		
			for(int i=0; i<len; i++) {
				if(intAry[i]>intAry[i+1]) {
					int temp;
					temp = intAry[i];
					intAry[i] = intAry[i+1];
					intAry[i+1] = temp;
				}
			}
		}
		for(int num : intAry) 
			System.out.println(num);
	}

}
