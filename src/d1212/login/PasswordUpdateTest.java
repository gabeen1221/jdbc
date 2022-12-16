package d1212.login;

import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.google.common.hash.Hashing;

import jdbc.util.OracleUtil;

public class PasswordUpdateTest {
	
	public static void main(String[] args) throws SQLException {
	
		Connection conn = OracleUtil.getConnection();
		String sql = "update book_member set password64=?\r\n"
				+ "where mem_idx=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		Scanner sc = new Scanner(System.in);
		System.out.println("ȸ����ȣ �Է� >>> ");
		pstmt.setInt(2, Integer.parseInt(sc.nextLine()));
		System.out.println("������ �н����� �Է� >>> ");
		String pass = sc.nextLine();
		
		String hval = Hashing.sha256()
				.hashString(pass, StandardCharsets.UTF_8)	
				.toString();
		pstmt.setString(1, hval);
		
		System.out.println("�� '1122'�� sha256�Լ��� �ؽð� �����?");
		System.out.println(hval);	
		
		System.out.println("�н����尡 ����Ǿ����ϴ�.");
		pstmt.execute();
		pstmt.close();
		conn.close();
		
		
		//�ؽð����� ���� ����(���)�Ҽ� ���� ������ �˰����� �ؽ��Լ��� �̹� ������ 
	}
}
