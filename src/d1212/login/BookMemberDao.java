package d1212.login;

import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.google.common.hash.Hashing;

import jdbc.util.OracleUtil;

public class BookMemberDao {

	public boolean login(String id, String password) throws SQLException {
		Connection conn = OracleUtil.getConnection();
		String sql = "select count(mem_idx) from book_member\r\n"
				+ "where trim(email) =trim(?) and password=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, id);
		pstmt.setString(2, password);
		
		ResultSet rs = pstmt.executeQuery();
		
		rs.next();
		if(rs.getInt(1)==1) {
			return true;
		}
		
		rs.close();
		pstmt.close();
		conn.close();
		return false;
	}
	
	public void UpdatePassword (String id , String password) throws SQLException {
		Connection conn = OracleUtil.getConnection();
		String sql = "UPDATE BOOK_MEMBER SET PASSWORD64 = ? WHERE mem_idx = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, Hashing.sha256()
				.hashString(password, StandardCharsets.UTF_8)	
				.toString());
		pstmt.setString(2, id);
		pstmt.execute();
		pstmt.close();
		conn.close();
		
		
	}
	
	public void insert(int idx, String name, String email, String pw) throws SQLException {
		Connection conn = OracleUtil.getConnection();
		String sql = "insert into BOOK_MEMBER (mem_idx, name, email, password) values (?, ?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, idx);
		pstmt.setString(2, name);
		pstmt.setString(3, email);
		pstmt.setString(4, pw);
		pstmt.execute();
		pstmt.close();
		conn.close();
		
	}
	public static void main(String[] args) throws SQLException {
		BookMemberDao dao = new BookMemberDao();
		
//		if(dao.login("jong@daum.net" , "2345")) {
//			System.out.println("사용자 인증 - 로그인 성공했습니다.");
//			
//		}else {
//			System.out.println("사용자 인증 - 아이디 또는 패스워드가 잘못된 값입니다.");
//			
//		}
//		dao.UpdatePassword("12345", "1234");
		
		dao.insert(23456, "미니" , "deld@naver.com", "1234");
		
	}
}
