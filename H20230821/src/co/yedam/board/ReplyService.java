package co.yedam.board;

public interface ReplyService {
	public void add(Board brd, User user);
	public void delete(User user);
	public void list(int brdNo);
	public void save();
}
