package d1207.test;

import java.sql.Connection;

import jdbc.util.OracleUtil;

public class OracleUtilTest {

	public static void main(String[] args) {
		
		Connection conn = OracleUtil.getConnection();
		System.out.print("����Ȯ�� : ");
		System.out.println(conn);		//null�� ��µǸ� �������.
		
		OracleUtil.close(conn);
	}
}
