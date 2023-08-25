package co.yedam.board.service;

import java.sql.*;
import co.yedam.board.*;
import co.yedam.board.common.Dao;
import co.yedam.board.vo.Board;
import co.yedam.board.vo.User;

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
	
	void disconn() {
		try {
			if(rs != null) {
				rs.close();
			}
			if(psmt != null) {
				psmt.close();
			}
			if(conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Override
	public boolean add(Board board) {
		query = "insert into board (brd_no, brd_title, brd_content, brd_writer)" + "values((select nvl(max(brd_no),0)+1 from board),?,?, ?)";
		conn = Dao.conn();
		try {
			psmt = conn.prepareStatement(query);
			psmt.setString(1, board.getBrdTitle());
			psmt.setString(2, board.getBrdContent());
			psmt.setString(3, board.getBrdWriter());
			int r = psmt.executeUpdate(); //insert나 update, delete할 때 사용하는 메소드
			if(r==1) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconn();
		}
		return false;
	}

	@Override
	public List<Board> list(int page) {
		List<Board> list = new ArrayList<>();
		conn = Dao.conn();
		query = "select *  " //
				+ "from (select rownum rn, a.* " //
				+ "      from (select * from board " //
				+ "            order by brd_no) a " //
				+ "      where rownum <=(? * 5)) b " //
				+ "where b.rn > (?-1)*5";
		try {
			psmt = conn.prepareStatement(query);
			psmt.setInt(1, page);
			psmt.setInt(2, page);
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
		} finally {
			disconn();
		}
		return list;
	}

	@Override
	public boolean modify(Board board) {
//		query = "update board set brd_content = '"+board.getBrdContent()+"  where brd_no = "+board.getBrdNo();
		query = "update board set brd_content = ? where brd_no = ?";
		conn = Dao.conn();
		try {
			psmt = conn.prepareStatement(query);
			psmt.setString(1, board.getBrdContent());
			psmt.setInt(2, board.getBrdNo());
			int r = psmt.executeUpdate(); //insert나 update, delete할 때 사용하는 메소드
			if(r==1) {
				
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconn();
		}
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
		} finally {
			disconn();
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
		} finally {
			disconn();
		}
		return null;
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int total() {
		query = "select count(*) as cnt from board";
		conn = Dao.conn();
		try {
			psmt = conn.prepareStatement(query);
			rs = psmt.executeQuery();
			if(rs.next()) {				
				int cnt = rs.getInt("cnt");
				return (int) Math.ceil(cnt/5.0);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconn();
		}
		return 0;
	}
	

	@Override
	public User checkWriter(int brdNo) {
		query = "select u.user_id, u.user_pw, u.user_nm, b.brd_writer\r\n"
				+ "from users u JOIN board b ON u.user_nm = b.brd_writer\r\n"
				+ "where brd_no = ?";
		conn = Dao.conn();
		try {
			psmt = conn.prepareStatement(query);
			psmt.setInt(1, brdNo);
			rs = psmt.executeQuery();
			while(rs.next()) {
				User user = new User();
				user.setId(rs.getString("user_id"));
				user.setPw(rs.getString("user_pw"));
				user.setName(rs.getString("user_nm"));
//				System.out.println(user.getId());
				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconn();
		}
		return null;
	}
	
}
