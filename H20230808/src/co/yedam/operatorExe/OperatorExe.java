package co.yedam.operatorExe;

public class OperatorExe {

	public static void main(String[] args) {
		int x,y;
		x = y = 2;
		
		int result = x++ + 10;
		System.out.println(result);
		System.out.println(x);
		
		result = ++y + 10;
		System.out.println(result);
		System.out.println(y);
		
		String str = (x>10) ? "x는 10이상" : "x는 10미만 ";
		System.out.println(str);
	}

}
