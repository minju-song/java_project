package co.yedam.array;

class Person {
	int age;
}

class Student extends Person{
	String name;
	int score;
	double height;
	Gender gender;

	
	Student(String name, int score, double height, Gender gender) {
		this.name = name;
		this.score = score;
		this.height = height;
		this.gender = gender;
	}
//	Student(int score) {
//		this("익명",score, 100,);
//	}
//	Student(String name, int score) {
//		this(name, score, 100);
//	}
	
	void run(int score) {
		System.out.println("run : "+score);
	}
	void run(String name) {
		System.out.println("run : "+name);
	}
}
