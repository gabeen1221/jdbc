package d1212.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import jdbc.util.OracleUtil;

public class LoginTest {

	public static void main(String[] args) throws SQLException {
		
		Connection conn = OracleUtil.getConnection();
		String sql = "select * from book_member\r\n"
				+ "where trim(email) =trim(?) and password=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
	
		Scanner sc = new Scanner(System.in);
		System.out.println("���̵�(�̸���) �Է� >>> ");
		String id = sc.nextLine();

		System.out.println("�н����� �Է� >>> ");
		String password = sc.nextLine();
		
		pstmt.setString(1, id);
		pstmt.setString(2, password);
		
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
