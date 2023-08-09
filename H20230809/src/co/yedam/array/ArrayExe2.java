package co.yedam.array;

public class ArrayExe2 {
	public static void main(String[] args) {

		int num[] = {56,72,67};
		int max = num[0];
		for(int i=0; i<num.length; i++) {
			if(max<num[i]) max = num[i];
		}
		System.out.println(max);
		
		
		
		
		
		
		
		
		int arr[] = new int[5];
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = (int)(Math.random()*100)+1;
		}
		
		int sum=0;
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
			sum += arr[i];
		}
		double avg = (double)sum/(double)arr.length;
		System.out.println();
		System.out.println("합 : "+sum);
		System.out.println("평균 : "+avg);
	}
}
