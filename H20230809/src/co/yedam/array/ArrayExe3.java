package co.yedam.array;
import java.util.*;

class Person {
	int age;
}

class Student extends Person{
	String name;
	int score;
	
	Student(String name, int score) {
		this.name = name;
		this.score = score;
	}
	Student(int score) {
		this.score = score;
	}
}



public class ArrayExe3 {
	

	public static void main(String[] args) {
		Student arr[] = new Student[3];
		arr[0] = new Student("홍길동", 85);
		arr[1] = new Student("김길동",90);
		arr[2] =new Student("송민주",99);
		arr[2].age = 26;
				
		
		
		Student max = arr[0];
		for(int i=0; i<arr.length; i++) {
			if(max.score<arr[i].score) max = arr[i];
		}
		
		System.out.printf("1등은 %s 이며 %d점\n", max.name, max.score);
		System.out.println(arr[2].age);
		
	}

}
