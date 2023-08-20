package co.yedam.exceptions;

//예외처리 : 프로그램이 정상적으로 종료시점까지 진행
public class NullPointExe {
	public static void main(String[] args) {
		String msg = "123";
		
		try{		
			System.out.println(msg.toString());
			int val = Integer.parseInt(msg);
			System.out.println("결과는 "+val);
		}
		catch (NullPointerException e) {
			System.out.println("msg의 값이 null을 참조함");
			System.out.println("예외 발생");
		}
		catch (NumberFormatException e) {
			System.out.println("msg값을 숫자로 변환할 수 없음");
		}
		finally {
			System.out.println("잠와죽겠다 예외발생이랑 상관없이 실행할 코드");
		}
		System.out.println("end of prog.");
	}
}
