package co.yedam.stu;

public class Student {
	private String name;
	private String major;
	private String id;
	private double score;
	
	public Student(String major, String id, double score) {
		this.major = major;
		this.id = id;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}
	
	public String toString() {
		return "학과: "+getMajor()+"\n학번: "+getId()+"\n학점평균: "+getScore();
	}
	
	
}
