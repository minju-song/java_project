package co.yedam.array;

public class TodoApp {

	public static void main(String[] args) {
		//등록/완료/조회(날짜)/미완료/
		//등록 : 순번나오면 [2 할일 0823] 형식으로 입력
		//완료 : 1 2 4 엔터치면 124의 상태가 완료가 됨 (한번에 여러건 입력)
		//조회 : 0812 넣으면 출력 (완료, 미완료 둘다)
		//미완료 : 미완료는 모두 출력 순번기준으로 보여주기
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
