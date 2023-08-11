package co.yedam.classes.student;

public class Student {
	//private : 클래스내에서만 접근 가능
	//필드는 클래스 내에서 처리하기 위해 private설정하고 메소드로 처리
	private int stdNo;
	private String stdName;
	private int score;
	
	Student() {
		//기본생성자
	}
	
	Student(int stdNo) {
		this.stdNo = stdNo;
	}
	
	Student(int stdNo, String stdName, int score) {
		this.stdNo = stdNo;
		this.stdName = stdName;
		this.score = score;
	}
	
	void stdInfo() {
		System.out.print("학번: "+this.stdNo+"\t");
		System.out.print("이름: "+this.stdName+"\t");
		System.out.println("점수: "+this.score);
	}
	
	void setStdno(int stdNo) {
		this.stdNo = stdNo;
	}
	void setStdName(String stdName) {
		this.stdName = stdName;
	}
	void setScore (int score) {
		if(score<0) this.score = 0;
		else this.score = score;
	}
	//getter

	public int getStdNo() {
		return stdNo;
	}

	public String getStdName() {
		return stdName;
	}

	public int getScore() {
		return score;
	}
	
}
