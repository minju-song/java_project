package co.yedam.operatorExe;
import java.util.*;

public class practice {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String a = sc.next();
		String b = sc.next();
		
		char [] a2 = new char[3];
		for(int i=0; i<a2.length; i++) {
			a2[i] = a.charAt(a2.length-i-1);
		}
		char [] b2 = new char[3];
		for(int i=0; i<b2.length; i++) {
			b2[i] = b.charAt(b2.length-i-1);
		}
		
		System.out.println(String.valueOf(a2) + " " + String.valueOf(b2));
	}
}
