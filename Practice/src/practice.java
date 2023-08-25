import java.util.Scanner;

public class practice {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String word = sc.next();
		int alpha[] = new int[26];
		
		for(int i=0; i<word.length(); i++) {
			alpha[word.charAt(i)-'a']++;
		}
		
		
		boolean ck = true;
		for(int i=0; i<alpha.length; i++) {
			if(alpha[i]>1) {
				int num1 = word.indexOf(alpha[i]);
				int num2 = word.lastIndexOf(alpha[i]);
				for(int j=num1+1; j<num2; j++) {
					if(word.charAt(j) !=  word.charAt(i)) {
						ck = false; break;
					}
				}
			}
		}
		
		System.out.println(ck);
	}

}
