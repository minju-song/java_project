package co.yedam.board;

//user기능의 인터페이스
public interface UserService {
	public User checkLogin(String id, String pw);

	public void readFile() throws Exception;

}
