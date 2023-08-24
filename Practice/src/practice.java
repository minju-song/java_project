import java.util.Scanner;

public class practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str[] = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
		
		Scanner sc = new Scanner(System.in);
		String word = sc.next();
		for(int i=0; i<str.length; i++) {
			if(word.indexOf(str[i])== -1) continue;
			word = word.replace(str[i], "*");
		}
		
		System.out.println(word.length());
	}

}
