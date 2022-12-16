package jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OracleUtil {

	public static Connection getConnection() {
		
		Connection conn = null;
		String url = "jdbc:oracle:thin:@192.168.1.25:1521:XE";
		String driver = "oracle.jdbc.driver.OracleDriver";
		String user = "iclass10";
		String password = "1234";
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,password);
			
		} catch (ClassNotFoundException e) {
			System.out.println("�����ͺ��̽� ����̹� �ε忡 ������ ������ϴ�. : " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("�����ͺ��̽� ���� �� ��뿡 ������ ������ϴ�. : " + e.getMessage());
		}
		
	
		return conn;
	}
	
	public static void close(Connection conn) {
		try {
			if(conn != null)
			conn.close();		//conn�� null ��ü��� close���� ���� -> ���ǽ� �߰�			
			System.out.println("���� ����!");
		} catch (SQLException e) {
			System.out.println("�����ͺ��̽� ���� ���� ���� : " + e.getMessage());
		}
	}
	//rs, pstmt, conn ��� close �ؾ��Ҷ�
	public static void close(Connection conn,PreparedStatement pstmt, ResultSet rs) {
		try {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) {
				conn.close();			//comm�� null ��ü��� close���� ���� -> ���ǽ� �߰�
				System.out.println("���� ����!");
			}else {
				System.out.println("Connection�� null�Դϴ�.");
			}
		}catch(SQLException e) {
			System.out.println("�����ͺ��̽� ���� ���� ���� : " + e.getMessage());
		}
	}
	
}
