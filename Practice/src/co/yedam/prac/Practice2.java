package co.yedam.prac;
import java.util.*;

class Book {
	String title;
	String author;
	
	void setTitle(String t) {
		this.title = t;
	}
	void setAuthor(String a) {
		this.author = a;
	}
	String getTitle() {
		return this.title;
	}
	String getAuthor() {
		return this.author;
	}
	void print() {
		System.out.println("("+this.title+", "+this.author+")");
	}
}


public class Practice2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Book arr[] = new Book[2];
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = new Book();
			System.out.print("책 제목>> ");
			arr[i].setTitle(sc.nextLine());
			System.out.print("작가 이름>> ");
			arr[i].setAuthor(sc.nextLine());
		}
		
		for(int i=0; i<arr.length; i++) {
			arr[i].print();
		}
		
		
		

	}

}
