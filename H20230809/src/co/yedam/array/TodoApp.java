package co.yedam.array;

public class TodoApp {

	public static void main(String[] args) {
		
		sortSample();
	}
	
	public static void sortSample() {
		int[] intAry = {45,23,90,77,12};
		int len = intAry.length-1;
		for(int j=0; j<4; j++) {		
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
