package co.yedam.api;
import java.util.*;

import java.io.IOException;

public class StringExe {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		StringUtils ck = new StringUtils();
		
		String file = "C:/Dev/temp/flower.jpg";
		System.out.println("파일명: "+file);
		System.out.println("이미지명: "+StringUtils.getFileName(file));
		System.out.println();
		boolean run = true;
		while(run) {			
			System.out.print("주민번호 입력>>");
			String num = sc.nextLine();
			if(num.equals("그만")) break;
			String result = StringUtils.checkGender(num);
			System.out.println(result);
		}
		System.out.println("프로그램 종료");
	}
}
