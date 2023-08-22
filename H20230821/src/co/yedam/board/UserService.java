package co.yedam.board;

//user기능의 인터페이스
public interface UserService {
	public User checkLogin();

	public void readFile() throws Exception;

}
