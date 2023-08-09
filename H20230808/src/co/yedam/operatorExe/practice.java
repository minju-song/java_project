package co.yedam.operatorExe;
import java.util.*;

public class practice {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int answer=0;
		String str = sc.nextLine();
		str = str.trim();
		String [] str2 = str.split(" ");
		answer = str2.length;
		if(str2.equals(' ')) answer = 0;
		System.out.println(answer);
	}
}
