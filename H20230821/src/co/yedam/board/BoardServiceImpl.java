package co.yedam.board;

import java.util.*;
import java.io.*;
import java.text.*;

//board 인터페이스를 상속받는 클래스
public class BoardServiceImpl implements BoardService {
	
	List<Board> boardList = new ArrayList<>();
	
	
	public BoardServiceImpl() {
		init();
	}
	
	@Override
	public int total() {
		return (int) Math.ceil(boardList.size()/5.0);
	}
	
	private void init() {
		try {
			FileInputStream fis = new FileInputStream("C:/Temp/board.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			boardList = (List<Board>) ois.readObject();
			
			ois.close();
			fis.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
		
	}
	
	private int getMaxNo() {
		int brdNo = 0;
		for(int i=0; i<boardList.size(); i++) {
			if(boardList.get(i).getBrdNo() > brdNo) {
				brdNo = boardList.get(i).getBrdNo();
			}
		}
		return brdNo+1;
	}

	@Override
	public boolean add(Board board) {
		board.setBrdNo(getMaxNo());
		Date now = new Date();
		board.setWriteDate(now);
		return boardList.add(board);
	}

	@Override
	public List<Board> list(int page) {
		List<Board> tmp = new ArrayList<>();
		int start = (page-1) * 5;
		int end = page*5-1;
		for(int i = 0; i < boardList.size(); i++) {
			if(i >= start && i <= end) tmp.add(boardList.get(i));
		}
		return tmp;
	}

	@Override
	public boolean modify(Board board) {
//		for(int i=0; i<boardList.size(); i++) {
//			if(boardList.get(i).getBrdNo()==board.getBrdNo()) {
//				boardList.get(i).setBrdContent(board.getBrdContent());
//				Date now = new Date();
////				board.setWriteDate(now);
//				boardList.get(i).setUpdateDate(now);
//				return true;
//			}
			if(boardList.get(board.getBrdNo()-1)!=null) {
				boardList.get(board.getBrdNo()-1).setBrdContent(board.getBrdContent());
				Date now = new Date();
				boardList.get(board.getBrdNo()-1).setUpdateDate(now);
				return true;
			}
//		}
		return false;
	}

	@Override
	public boolean remove(int brdNo) {
		if(boardList.get(brdNo-1)!=null) {
			boardList.remove(brdNo-1);
			return true;
		}
		return false;
	}

	@Override
	public Board search(int brdNo) {
//		for(int i=0; i<boardList.size(); i++) {
//			if(boardList.get(i).getBrdNo()==brdNo) {
//				return boardList.get(i);
//			}
//		}
		if(boardList.get(brdNo-1) != null) {
			return boardList.get(brdNo-1);
		}
		return null;
	}

	@Override
	public void save() {
		try {
			FileOutputStream fos = new FileOutputStream("C:/Temp/board.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(boardList);
			oos.flush();
			oos.close();
			fos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	
}
