package d1212.login;

import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.google.common.hash.Hashing;

import jdbc.util.OracleUtil;

public class LoginPassword64Test {

	public static void main(String[] args) throws SQLException {
		
		Connection conn = OracleUtil.getConnection();
		String sql = "select * from book_member\r\n"
				+ "where trim(email) =trim(?) and password64=?";
		//email �÷��� unique
		PreparedStatement pstmt = conn.prepareStatement(sql);
	
		Scanner sc = new Scanner(System.in);
		System.out.println("���̵�(�̸���) �Է� >>> ");
		String id = sc.nextLine();

		System.out.println("�н����� �Է� >>> ");
		String password = sc.nextLine();
		
		pstmt.setString(1, id);
		pstmt.setString(2, Hashing.sha256()
				.hashString(password, StandardCharsets.UTF_8)	
				.toString());
		
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next())
			System.out.println("����� ���� - �α��� �����߽��ϴ�.");
		else
			System.out.println("����� ���� - ���̵� �Ǵ� �н����尡 �߸��� ���Դϴ�.");
		
		rs.close();
		pstmt.close();
		conn.close();
			
	}
}
