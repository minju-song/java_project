package co.yedam.api;

import java.util.*;

public class SetExe {
	public static void main(String[] args) {
		//ArrayList, HashSet: 중복된 값은 저장 불가, 
		
		Set<String> set = new HashSet<>();
		set.add("Hong");
		set.add("Hwang");
		set.add("Kim");
		set.add("Kim");
		
		for(String str : set) {
			System.out.println(str);
		}
		
		Set<Member> memberSet = new HashSet<>();
		memberSet.add(new Member(101,"Hong"));
		memberSet.add(new Member(102,"Hwang"));
		memberSet.add(new Member(103, "Kim"));
		memberSet.add(new Member(101,"Hong"));
		
		for(Member a : memberSet) {
			System.out.println(a);
		}
	}
}
