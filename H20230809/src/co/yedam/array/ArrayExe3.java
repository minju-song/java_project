package co.yedam.array;
import java.util.*;


public class ArrayExe3 {
	

	public static void main(String[] args) {
		Student arr[] = new Student[3];
		arr[0] = new Student("홍길동", 85, 180, Gender.MAN);
		arr[1] = new Student("김길동",90 , 170, Gender.MAN);
		arr[2] =new Student("송민주",99 , 160,Gender.WOMAN);
		arr[2].age = 26;
				
		
		
		Student max = arr[0];
		for(int i=0; i<arr.length; i++) {
			if(max.score<arr[i].score) max = arr[i];
		}
		
		System.out.printf("1등은 %s 이며 %d점\n", max.name, max.score);
		System.out.println(arr[2].age);
		
	}

}
