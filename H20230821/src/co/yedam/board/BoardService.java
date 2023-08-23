package co.yedam.board;

import java.util.List;

//board서비스의 인터페이스
//파일저장, DB저장
public interface BoardService {
	//등록(추가) 목록 수정 삭제 상세조회
	
	//등록
	public boolean add(Board board);
	
	//목록
	public List<Board> list(int page);
	
	//수정(글 내용만)
	public boolean modify(Board board);
	
	//삭제
	public boolean remove(int brdNo);
	
	//상세조회
	public Board search(int brdNo);

	//종료
	public void save();
	
	public int total();
	
	public User checkWriter(int brdNo);
}
