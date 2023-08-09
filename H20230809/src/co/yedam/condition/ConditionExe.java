package co.yedam.condition;

public class ConditionExe {
	public static void main(String[] args) {
		//임의의 수 1~3
		
		char ran = (char)((Math.random()*4)+65);
		
		System.out.println(ran);
	
		
		switch(ran) {
		case 65:
			System.out.printf("%c 입니다.\n",ran); break;
		case 66:
			System.out.printf("%c 입니다.\n",ran); break;
		case 67:
			System.out.printf("%c 입니다.\n",ran); break;
		case 68:
			System.out.printf("%c 입니다.\n",ran); break;
		default:
			System.out.printf("오류\n");
		}
		
		
	}
}
