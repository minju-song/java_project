package co.yedam.prac;
import java.util.*;

public class Practice2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str[] = sc.nextLine().split("");
		for(int i=0; i<str.length; i++) {
			str[i] = str[i].toLowerCase();
		}
		
		int check[] = new int[26];
		for(int i=0; i<check.length; i++) {
			check[i] = 0;;
		}
		String alpha[] = new String[26];
		for(int i=0; i<26; i++) {
			alpha = 97;
		}
		String a = alpha.toString();
		for(int i=0; i<26; i++) {
			for(int j=0; j<str.length; j++) {
				if (str[j].equals(alpha)) {
					check[i]++;
				}
			}
		}
		
		
		

	}

}
