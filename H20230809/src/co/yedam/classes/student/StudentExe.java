package co.yedam.classes.student;

public class StudentExe {
	public static void main(String[] args) {
		Student s1 = new Student();
		s1.setStdName("송민주");
		s1.setStdno(1);
		s1.setScore(100);
		s1.stdInfo();
		
		Student s2 = new Student(2);
		s2.setStdName("손흥민");
		s2.setScore(-70);
		s2.stdInfo();
		
		Student s3 = new Student(3,"이강인",60);
		s3.stdInfo();
		
		System.out.println(s1.getStdName());
	}
}
