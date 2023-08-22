package co.yedam.stu;

import java.util.*;

public class StuApp {
	List<Student> students = new ArrayList<>();
	Map<String, Student> map = new HashMap<>();
	Scanner sc = new Scanner(System.in);
	
	public void start() {
		System.out.println("학생 이름, 학과, 학번, 학점평균 입력하세요.");
		for(int i=0; i<4; i++) {
			System.out.print(">> ");
			String s = sc.nextLine();
			String data[] = s.split(", ");
			Student stu = new Student(data[1], data[2], Double.parseDouble(data[3]));
			map.put(data[0], stu);
		}
		
		Set<String> keys = map.keySet();
		Iterator<String> iter = keys.iterator();
		System.out.println("----------------------------------");
		while(iter.hasNext()) {
			String key = iter.next();
			System.out.println("이름 "+key);
			System.out.println(map.get(key).toString());
			System.out.println("----------------------------------");
		}
//		System.out.println("----------------------------------");
//		for(int i=0; i<map.size(); i++) {
//			System.out.println(students.get(i).toString());
//			System.out.println("----------------------------------");
//		}
		
		search();
		System.out.println("프로그램 종료");
	}
	
	public void search() {
		
		Set<String> keys = map.keySet();
		Iterator<String> iter = keys.iterator();
//		while(iter.hasNext()) {
//			String key = iter.next();
//			System.out.println("이름 "+key);
//			System.out.println(map.get(key).toString());
//			System.out.println("----------------------------------");
//		}
		while(true) {	
			System.out.print("학생 이름 >>");
			String name = sc.next();
			if(name.equals("그만")) break;
			while(iter.hasNext()) {
				String key = iter.next();
				if(name.equals(key)) {
					Student s = map.get(key);
					System.out.println(key+", "+s.getMajor()+", "+s.getId()+", "+s.getScore());
				}
			}
//			for(int i=0; i<map.size(); i++) {
//				if(name.equals(map.get(i).getName())) {
//					Student s = students.get(i);
//					System.out.println(s.getName()+", "+s.getMajor()+", "+s.getId()+", "+s.getScore());
//				}
//			}
		}
	}
}
