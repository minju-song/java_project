package co.yedam.array;

public class ArrayExe1 {
	public static void main (String [] args) {
		int[] intArr = null;
		intArr = new int[]{1, 2, 3, 4, 5};
		int [] intArr2 = null;
		
		intArr2 = intArr;
		for(int i=0; i<intArr2.length; i++) {
			System.out.print(intArr2[i]+" ");
		}
		
		int sum=0;
		for(int i=0; i<intArr2.length; i++) {
			sum+= intArr[i];
		}
		System.out.println(sum);
		
	}
}
