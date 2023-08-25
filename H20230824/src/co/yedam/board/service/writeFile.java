package co.yedam.board.service;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import co.yedam.board.common.Dao;
import co.yedam.board.vo.User;
public class writeFile {
	
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	String query;
	
	public void writeUser(User user) throws IOException {
		
		query = "update users set user_pw='12345' where user_id = ?";
//		query =  "insert into users (user_id, user_pw, user_nm) values (?, ?, ?)";
		conn = Dao.conn();
		try {
			psmt = conn.prepareStatement(query);
			psmt.setString(1, user.getId());
			int r = psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
