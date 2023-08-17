package co.yedam.abstracts;

public class MainExe {

	public static void main(String[] args) {
		Animal dog = new Dog("멍멍이");
		Animal cat = new Cat("야옹이");
		
		dog.sound();
		cat.sound();

	}

}
