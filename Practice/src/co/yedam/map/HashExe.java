package co.yedam.map;

import java.util.*;

public class HashExe {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<String, Integer> nations = new HashMap<>();
		
		System.out.println("나라 이름과 인구를 입력하세요. (예: Korea 5000)");
		while(true) {
			System.out.print("나라 이름, 인구 >> ");
			String nation = sc.next();
			if(nation.equals("그만")) break;
			Integer person = sc.nextInt();
			nations.put(nation, person);
		}
		
		while(true) {			
			System.out.print("인구 검색 >> ");
			String n = sc.next();
			if(n.equals("그만")) break;
			Set<String> keys = nations.keySet();
			Iterator<String> iter = keys.iterator();
			boolean ck = false;
			while(iter.hasNext()) {
				if(n.equals(iter.next())) {
					System.out.println(n+"의 인구는 "+nations.get(n));
					ck = true;
					break;
				}
			}
			if(ck == false) System.out.println(n+" 나라는 없습니다.");
		}
		System.out.println("프로그램 종료");
		
		
		
	}

}
