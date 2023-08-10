package co.yedam.array;
import java.util.*;

public class CalendarExe {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] days = {"SUN","MON","TUE","WED","THU","FRI","SAT"};
		//달력 31일까지
		int count = 0;
		while(count!=12) {
			System.out.print("보고싶은 월>> ");
			int month = sc.nextInt();
			int space = getFirstDay(month);
			int day = getLastDate(month);
			
			System.out.println();
			for(int i=0; i<days.length; i++) {
				System.out.printf("%4s",days[i]);
			}
			
			System.out.println();
			
			for(int i=0; i<space; i++) {
				System.out.printf("%4s", " ");
			}
			for(int i=1; i<=day; i++) {
				System.out.printf("%4d", i);
				if((i+space)%7==0) System.out.println();
			}
			System.out.println();
			System.out.println();
			count++;
		}
		
	}
	
	public static int getFirstDay(int month) {
		int space = 0;
		if(month == 1) return space;
		space = (getLastDate(month-1) + getFirstDay(month-1)) % 7; 
		
		return space;
	}
	
	
	public static int getLastDate(int month) {
		//2월 28일
		int lastDate = 31;
		switch(month) {
		case 2:
			lastDate = 28; break;
		case 4:
		case 6:
		case 9:
		case 11:
			lastDate = 30; break;
		}
		
		return lastDate;
	}
}
