package co.yedam.variable;

public class Person {
	int age;
	String name;
	
	public Person(int age, String name) {
		this.age=age;
		this.name=name;
	}
	public String getName() {
		return this.name;
	}
	public int getAge() {
		return this.age;
	}
	void printPerson() {
		System.out.println("이름 : "+this.name);
		System.out.println("나이 : "+this.age);
		System.out.println();
	}

}
