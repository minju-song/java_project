package co.yedam.generic;
import java.util.*;

public class SetExe {
	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		set.add("홍길동");
		set.add("김길동");
		set.add("박길동");
		set.add("홍길동");
		
//		set.remove("홍길동");
		
		Iterator<String> iter = set.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		System.out.println();
		
		List<Integer> list = new LinkedList<>();
		list.add(10);
		list.add(11);
		list.add(12);
		list.add(11);
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		System.out.println();
		
		Set<Integer> set2 = new HashSet<>();
		set2.add(10);
		set2.add(11);
		set2.add(12);
		set2.add(11);
		
		Iterator<Integer> iter2 = set2.iterator();
		while(iter2.hasNext()) {
			System.out.println(iter2.next());
		}
	}
}
