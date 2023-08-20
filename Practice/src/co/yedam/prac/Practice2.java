package co.yedam.prac;
import java.util.*;

public class Practice2 {
	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		str = str.toUpperCase();
		
		
		int n = sc.nextInt();
		
		int count[] = new int[26];
		for(int i=0; i<count.length; i++) {
			count[i] = 0;
		}
		
		for(int i=0; i<str.length(); i++) {
			count[str.charAt(i)-65]++;
		}
		

		int max=0;
		int secMax=0;
		for(int i=0; i<count.length; i++) {
			if(count[max]<count[i]) max = i;
		}
		
		char result=' ';
		for(int i=0; i<count.length; i++) {
			if(count[max]== count[i] && i!=max) {
				result = '?';
			}
		}
		if (result != '?') result = (char)(max+'A');
		
		System.out.println(result);
	}

}
