package co.yedam.generic;

import java.util.*;

public class ListExe {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("Hello");
		list.add(new String("World"));
		list.add("Good");

		String result = list.get(0);
		System.out.println(result);
		System.out.println(list.contains("Hello"));
		System.out.println(list.size());
		for(int i=0; i<list.size(); i++) {
			System.out.println(i+1+"번째 : "+list.get(i));
		}

		list.set(1, result);
		System.out.println("수정후");
		list.remove(1);
		list.clear();
		
		for(String str : list) {
			System.out.println(str);
		}
//		System.out.println(list.get(1));
	}
}
