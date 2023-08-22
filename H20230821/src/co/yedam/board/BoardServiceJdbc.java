package co.yedam.board;

import java.sql.*;
import java.util.*;

public class BoardServiceJdbc implements BoardService {

	//Connection 객체 - db연결
	//PreparedStatement 객체 - 쿼리실행
	//ResultSet 객체 - 잠시 담아놓음
	//String 쿼리 - 퀴리실행변수
	
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	String query;
	
	
	
	
	@Override
	public boolean add(Board board) {
		return false;
	}

	@Override
	public List<Board> list(int page) {
		List<Board> list = new ArrayList<>();
		conn = Dao.conn();
		query = "select * from board";
		try {
			psmt = conn.prepareStatement(query);
			rs = psmt.executeQuery();
			while(rs.next()) {
				//rs -> arrayList로 변환
				Board board = new Board();
				board.setBrdNo(rs.getInt("brd_no"));
				board.setBrdTitle(rs.getString("brd_title"));
				board.setBrdContent(rs.getString("brd_content"));
				board.setBrdWriter(rs.getString("brd_writer"));
				
				list.add(board);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean modify(Board board) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(int brdNo) {
		query = "delete from board where brd_no = "+brdNo;
		conn = Dao.conn();
		try {
			psmt = conn.prepareStatement(query);
			int r = psmt.executeUpdate(); //insert나 update, delete할 때 사용하는 메소드
			if(r==1) return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Board search(int brdNo) {
		query = "select * from board where brd_no = "+brdNo;
		conn = Dao.conn();
		try {
			psmt = conn.prepareStatement(query);
			rs = psmt.executeQuery();
			if(rs.next()) {
				Board board = new Board();
				board.setBrdNo(rs.getInt("brd_no"));
				board.setBrdTitle(rs.getString("brd_title"));
				board.setBrdContent(rs.getString("brd_content"));
				board.setBrdWriter(rs.getString("brd_writer"));
				board.setWriteDate(rs.getDate("write_date"));
				return board;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int total() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
