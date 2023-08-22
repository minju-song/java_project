package co.yedam.generic;

import java.text.*;
import java.util.*;

public class DateExe {
	public static void main(String[] args) {
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		System.out.println(today.toString());
		System.out.println(sdf.format(today));
		
		String strTime = "2023-09-01 13:22:33";
		try {
			Date newdate = sdf.parse(strTime); //문자열을 바꿔줌
			System.out.println(newdate.toString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
//SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");