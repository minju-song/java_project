package co.yedam.prac;
import java.util.*;

public class Practice2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		String [][] str = new String[n][m];
		String [] data = new String[m];
		
		for(int i=0; i<n; i++) {
				data = sc.nextLine().split("");
			for(int j=0; j<data.length; j++) {
				str[i][j] = data[j];
			}
		}
		
		int count = 0;
		boolean ck = false;

		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if (str[i][j].equals("X")) ck = true;
			}
			if (ck = false) count++;
			ck = false;
		}
		
		

	}

}
