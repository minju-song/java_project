package co.yedam.board.service;

import co.yedam.board.vo.Board;
import co.yedam.board.vo.User;

public interface ReplyService {
	public void add(Board brd, User user);
	public void delete(User user);
	public void list(int brdNo);
	public void save();
}
