package co.yedam.prac;
import java.util.*;

public class practice {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String arrStr[][] = new String[5][15];
		for(int i=0; i<arrStr.length; i++) {
			for(int j=0; j<arrStr[i].length; j++) {				
				arrStr[i][j] = "-";
			}
		}
		
		for(int i=0; i<5; i++) {
			String[] str = sc.nextLine().split("");
			for(int j=0; j<str.length; j++) {
				arrStr[i][j] = str[j];
			}
			
		}

		for(int j=0; j<arrStr[0].length; j++) {
			for(int i=0; i<arrStr.length; i++) {
				if(arrStr[i][j].equals("-")) continue;
				System.out.print(arrStr[i][j]);
			}
		}
		
	}
}
