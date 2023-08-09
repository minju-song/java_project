package co.yedam.prac;
import java.util.*;

public class practice {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char arr[][] = new char[5][15];
		for(int i=0; i<5; i++) {
				String a = sc.nextLine();
				arr[i] = a.toCharArray();
			
		}
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[0].length; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		
		
		
	}
}
