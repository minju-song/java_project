package co.yedam.generic;

public class MainExe {
	public static void main(String[] args) {
		Box<String> box = new Box<String>();
		box.set("Hello");
		String result = box.get();
		System.out.println(result);
		
		Box<Integer> box2 = new Box<Integer>();
		box2.set(10); //10은 (Integer) 기본값인 int가 아님
		Integer result2 = box2.get();
		System.out.println(result2);
	}
}
