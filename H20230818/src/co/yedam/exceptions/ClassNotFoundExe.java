package co.yedam.exceptions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClassNotFoundExe {
	public static void main(String[] args) {
		//db연결처리할 때 발생할 수 있는 예외
		try {
			Class.forName("oracle.jdbc.OracleDriver1");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			System.out.println(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from employees");
			while(rs.next()) {
				System.out.println("사원번호 : "+rs.getInt("employee_id") + " 사원이름 : "+rs.getString("last_name") );
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("end of prog.");
	}
}
