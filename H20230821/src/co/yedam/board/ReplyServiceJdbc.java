package co.yedam.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.*;

public class ReplyServiceJdbc implements ReplyService{
	static Scanner sc = new Scanner(System.in);

	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	String query;
	
	
	@Override
	public void add(Board brd, User user) {
//		sc.nextLine();
		System.out.print("댓글 작성>>");
		String cont = sc.nextLine();
		query = "insert into replys (rep_no, rep_content, brd_no, rep_write) "
				+ "values ((select count(*) + 1 as cnt from replys), ?, ?, ? )";
		conn = Dao.conn();
		try {
			psmt = conn.prepareStatement(query);
			psmt.setString(1, cont);
			psmt.setInt(2, brd.getBrdNo());
			psmt.setString(3, user.name);
			int r = psmt.executeUpdate();
			if(r == 1) {
				System.out.println("댓글이 등록되었습니다.");
			}
			else {
				System.out.println("댓글등록실패");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(User user) {
		System.out.print("삭제할 댓글 번호 입력>>");
		int del = sc.nextInt();
		if(user.name.equals(checkReply(del))) {	
			query = "delete from replys where rep_no = ?";
			conn = Dao.conn();
			try {
				psmt = conn.prepareStatement(query);
				psmt.setInt(1, del);
				int r = psmt.executeUpdate();
				System.out.println("삭제되었습니다.");
					
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else System.out.println("삭제할 권한이 없습니다.");
		
		
	}
	//rep_no, rep_content, brd_no, rep_write

	@Override
	public void list(int brdNo) {
		System.out.println();
		System.out.println("<<<<댓글>>>>");
		List<Reply> list = new ArrayList<>();
		conn = Dao.conn();
		query = "select * from replys where brd_no = ? order by rep_no";
		try {
			psmt = conn.prepareStatement(query);
			psmt.setInt(1, brdNo);
			rs = psmt.executeQuery();
			while(rs.next()) {
				System.out.print(rs.getInt("rep_no")+") "+rs.getString("rep_content")+"\t\t작성자: "+rs.getString("rep_write"));
				System.out.println();
			}
			System.out.println();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String checkReply(int rep_no) {
		conn = Dao.conn();
		query = "select rep_write from replys where rep_no = ?";
		try {
			psmt = conn.prepareStatement(query);
			psmt.setInt(1, rep_no);
			rs = psmt.executeQuery();
			while(rs.next()) {
				return rs.getString("rep_write");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	public void save() {
		
	}

}
