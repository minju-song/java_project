package co.yedam.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserServiceJdbc implements UserService{
	Scanner sc = new Scanner(System.in);
	List<User> list = new ArrayList<>();

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
//	conn = Dao.conn();
//	query = "select * from users";
//	psmt = conn.prepareStatement(query);
//	rs = psmt.executeQuery();
//	while(rs.next()) {
//		User user = new User();
//		user.setId(rs.getString("user_id"));
//		user.setPw(rs.getString("user_pw"));
//		user.setName(rs.getString("user_nm"));
//		
//		list.add(user);
//	}
	
	
	@Override
	public User checkLogin(String id, String pw) {
		conn = Dao.conn();
		query = "select * from users where user_id = ?";
		try {
			psmt = conn.prepareStatement(query);
			psmt.setString(1,id);
			rs = psmt.executeQuery();
			while(rs.next()) {
				if(pw.equals(rs.getString("user_pw"))) {
					System.out.println();
					System.out.print(rs.getString("user_nm")+"님 ");
					User user = new User(rs.getString("user_id"), rs.getString("user_pw"), rs.getString("user_nm"));
					return user;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconn();
 		}
		return null;
	}
	
//	conn = Dao.conn();
//	query = "select *  " //
//			+ "from (select rownum rn, a.* " //
//			+ "      from (select * from board " //
//			+ "            order by brd_no) a " //
//			+ "      where rownum <=(? * 5)) b " //
//			+ "where b.rn > (?-1)*5";
//	try {
//		psmt = conn.prepareStatement(query);
//		psmt.setInt(1, page);
//		psmt.setInt(2, page);
//		rs = psmt.executeQuery();
//		while(rs.next()) {
//			//rs -> arrayList로 변환
//			Board board = new Board();
//			board.setBrdNo(rs.getInt("brd_no"));
//			board.setBrdTitle(rs.getString("brd_title"));
//			board.setBrdContent(rs.getString("brd_content"));
//			board.setBrdWriter(rs.getString("brd_writer"));
//			
//			list.add(board);
//		}
//	} catch (SQLException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	return list;

	@Override
	public void readFile() throws Exception {
		conn = Dao.conn();
		query = "select * from users";
		psmt = conn.prepareStatement(query);
		rs = psmt.executeQuery();
		while(rs.next()) {
			User user = new User();
			user.setId(rs.getString("user_id"));
			user.setPw(rs.getString("user_pw"));
			user.setName(rs.getString("user_nm"));
			
			list.add(user);
		}
		
	}

}
