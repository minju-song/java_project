package co.yedam.classes.student;

public class StudentApp {
	public static void main(String[] args) {
		Student[] students = new Student[10];
		
		Student s1 = new Student();
		s1.setStdno(100);
		s1.setStdName("송민주");
		s1.setScore(100);
		students[0] = s1;
		
		students[1] = new Student(101, "손흥민", 70);
		students[2] = new Student(102, "이강인", 80);
		students[3] = new Student(103, "김민재", 90);
		
		String searchName = "손흥민";
		for(int i=0; i<students.length; i++) {
			if( students[i]!=null && searchName.equals(students[i].getStdName())) {
				System.out.print("[이름: "+students[i].getStdName()+"]  ");
				System.out.print("[학번: "+students[i].getStdNo()+"]  ");
				System.out.println("[점수: "+students[i].getScore()+"]");
			}
		}
	}
}
