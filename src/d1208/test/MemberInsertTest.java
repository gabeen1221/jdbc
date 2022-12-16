package d1208.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jdbc.util.OracleUtil;

public class MemberInsertTest {

	public static void main(String[] args) throws SQLException {
		String sql = "INSERT INTO member_tbl_02 \r\n"
				+ "values(seq_score11.nextval,?,?,?,sysdate,?,?)";

		Connection conn = OracleUtil.getConnection();
		PreparedStatement pstmt = null;
		//insert/update/delete�� ResultSet ��� ����.
		
		pstmt = conn.prepareStatement(sql);
		//execute �޼ҵ�� SQL �����ϱ� ���� �ʿ��� ���� ����
		pstmt.setString(1, "���ູ");
		pstmt.setString(2, "010-7777-2299");
		pstmt.setString(3, "����� ������ û�㵿");
		pstmt.setString(4, "B");
		pstmt.setString(5, "02");
		
		
		pstmt.execute();							//select SQL�� executeQuery �޼ҵ�, �������� execute �޼ҵ�
		conn.close();
	} 
}
