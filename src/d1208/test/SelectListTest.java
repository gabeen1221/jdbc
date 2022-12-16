package d1208.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.util.OracleUtil;

public class SelectListTest {

	//select ��ȸ ����� ArrayList Ÿ���� ��ü�� �����ϱ� 
	//				(����Ʈ�� ���ʸ� Ÿ���� ���̺��� ������ �´� Ŭ���� ����)
	public static void main(String[] args) throws SQLException {
		Connection conn = OracleUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from member_tbl_02";
		
		pstmt = conn.prepareStatement(sql);		//Exception ó���� jvm���� throw(����. ���ѱ��)
		rs = pstmt.executeQuery();
		List<Member> memberList = new ArrayList<>();		//select ��ȸ����� �ڹ� ��ü�� ����.
		int cnt = 0;
		while(rs.next()) {
			Member m = new Member(
							rs.getInt(1),
							rs.getString(2),
							rs.getString(3),
							rs.getString(4),
							rs.getDate(5),
							rs.getString(6),
							rs.getString(7)
					);
			cnt++;
			memberList.add(m);
		}
		
		System.out.println("����Ʈ�� ũ�� : " + memberList.size());
		System.out.println("ī��Ʈ �� : " + cnt);
	}
}
