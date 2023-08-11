package co.yedam.array;
import java.util.*;
public class TodoApp {
	static Scanner sc = new Scanner(System.in);
	static Todo[] arr = new Todo[20];  //Todo 객체 배열 생성
	static int idx=0; //배열에 들어간 Todo 갯수
	static boolean ck = false; //check

	//메뉴 프린트 메소드
	public static void printManual() {
		System.out.println("-----------------------------------------");
		System.out.println("| 1.등록 | 2.완료 | 3.조회 | 4.미완료 | 5.종료 |");
		System.out.println("-----------------------------------------");
		System.out.print("선택> ");
	}
	
	//1번 등록 메소드
	public static void addTodo() {
		System.out.printf("[%d] 번호, 할일, 날짜(MMDD)를 공백으로 구분하여 입력>> ",idx);
		int num = sc.nextInt(); //Todo.no
		String to = sc.next(); //Todo.todo
		String day = sc.next(); //Todo.dueDate
		arr[idx] = new Todo(num, to, day); //arr배열에 Todo객체 생성
		idx++; //인덱스 증가
		System.out.println(day+"의 할일을 등록하였습니다.");
	}
	
	//2번 완료 처리 메소드
	public static void complete() {
		ck = false;
		System.out.print("완료시킬 To do의 번호를 입력하세요>> ");
		String [] data = sc.nextLine().split(" "); //여러 번호가 들어올 경우 공백으로 구분하여 처리
		for(int i=0; i<data.length; i++) {
			int s = Integer.parseInt(data[i]);
			for(int j=0; j<arr.length; j++) {
				if(arr[j]!=null && s == arr[j].no && arr[j].done == false) {
					System.out.print(arr[j].no+"번 "); arr[j].done = true; //입력한 번호에 해당하는 작업 true
					ck = true;
				}
			}
			if(ck == false) {
				System.out.println(data[i]+"번은 없는 번호입니다.");
			}
			else System.out.println("완료");
			ck = false;
		}
	}
	
	//3번 날짜를 검색하여 할 일 조회
	public static void search() {
		ck = false;
		System.out.print("조회할 날짜 입력>> ");
		String s = sc.nextLine();
		System.out.printf("%s>> ", s);
		for(Todo e : arr) {
			if ( e != null && s.equals(e.dueDate)) {
				System.out.print(e.todo+" ");
				ck = true;
			}
		}
		if(ck == false) System.out.print("할 일이 없습니다.");
		System.out.println();
	}
	
	//4번 미완료된 할일 출력 (Todo.no 오름차순)
	public static void print() {
		int len = arr.length - 1;
		//오름차순으로 배열 정렬
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
		//정렬된 배열에서 done이 false인 데이터 출력
		for(int i=0; i<arr.length; i++) {
			if (arr[i] != null && arr[i].done == false) {				
				System.out.println(arr[i].no + ". "+arr[i].todo);
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
