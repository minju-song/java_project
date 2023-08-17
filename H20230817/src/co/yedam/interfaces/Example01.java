package co.yedam.interfaces;

public class Example01 {
	public static void main(String[] args) {
		int[][] intArr = new int[5][5];
		
		
		
		
		int num = 1;
		for(int i=0; i<intArr[0].length; i++) {
			for(int j=0; j<intArr.length; j++) {
				intArr[j][i] = num++;
			}
		}
	
		for(int i=0; i<intArr.length; i++) {
			for(int j=0; j<intArr[i].length; j++) {
				System.out.print(intArr[i][j]+"\t");
			}
			System.out.println();
		}
		
		System.out.println();
		
		for(int i=intArr.length-1; i>=0; i--) {
			for(int j=0; j<intArr[i].length; j++) {
				System.out.print(intArr[i][j]+"\t");
			}
			System.out.println();
		}
		
		System.out.println();
		
		num = 1;
		for(int i=0; i<intArr.length; i++) {
			for(int j=0; j<intArr[i].length; j++) {
				intArr[i][j] = num++;
				System.out.print(intArr[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println();
		
		for(int i=intArr.length-1; i>=0; i--) {
			for(int j=0; j<intArr.length; j++) {
				System.out.print(intArr[j][i]+"\t");
			}
			System.out.println();
		}
		
		System.out.println();
	
	}
}
