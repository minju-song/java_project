package co.yedam.array;
import java.util.*;

public class FuncExe {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("두 줄 입력>> ");
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		System.out.printf("%d x %d의 넓이는 %d입니다.\n", n1, n2, getArea(n1,n2));
		
		int arr[] = new int[10];
		for(int i=0; i<10; i++) {
			arr[i] = i+1;
		}
		System.out.println(arr.length+"까지의 합은 "+sum(arr)+"입니다.");
		
		Friend f=getFriend("송민주","01082251849", Gender.WOMAN);
		f.showInfo();
		
//		String str = sc.next();
//		printStar(n);
//		printStr(n,str);
//		printStar();
//		System.out.println(n+"의 제곱은 "+getPow(n)+"입니다.");
	}
	
	public static void printStar() {
		System.out.println("*");
	}
	
	public static void printStar(int times) {
		for(int i=0; i<times; i++) {
			System.out.print(" *");
		}
		System.out.println();
	}
	
	public static void printStr(int times, String str) {
		for(int i=0; i<times; i++) {
			System.out.println(str+" ");
		}
	}
	
	public static int getPow(int n) {
		return n*n;
	}
	
	public static int getArea(int width, int height) {
		return width*height;
	}
	
	public static int sum (int[] arr) {
		int sum = 0;
		for(int i=0; i<arr.length; i++) {
			sum += arr[i];
		}
		return sum;
	}
	
	public static Friend getFriend(String name, String phone, Gender gender) {
		Friend f = new Friend(name, phone, gender);
		return f;
	}
}
