package co.yedam.board.vo;

//user 객체
public class User {
	private String id;
	private String pw;
	public String name;
	
	public User(String id, String pw, String name) {
		this.id = id;
		this.pw = pw;
		this.name = name;
	}

	public User() {
		
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}