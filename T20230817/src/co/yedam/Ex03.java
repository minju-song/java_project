package co.yedam;

public class Ex03 {
	public static void main(String[] args) {
		
		int[] arr = new int[5];
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = (int) (Math.random()*10)+1;
		}
		
		int min = arr[0];
		int max = arr[0];
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i]>max) max = arr[i];
			if(arr[i]<min) min = arr[i];
		}
		
		System.out.println("최대값은 "+max);
		System.out.println("최소값은 "+min);
	}
}
