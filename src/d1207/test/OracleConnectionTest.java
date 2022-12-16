package d1207.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleConnectionTest {

	public static void main(String[] args) {

		Connection conn = null;		//Connection �������̽�

		//db���� ����
		String url = "jdbc:oracle:thin:@localhost:1521:XE";   //�����ͺ��̽� URL - �������� Ȯ�ΰ����մϴ�. jdbc:oracle:thin�� ������ ��������
					//jdbc��������,����Ŭ ���� ,localhost�� ������ ���ӽ� ip�� ��ü , 1521�� ����Ŭ�� ��Ʈ(���� ������)
		String driver="oracle.jdbc.driver.OracleDriver";     //����Ŭ ����̹�Ŭ����(��Ű����.Ŭ������) - �ܺζ��̺귯�� ojdbc6.jar �ʿ�
		String user ="system";			//������ ���� ���� - �����̸�
		String password="1234";				//            �� �н�����
		
		try {			//���� ó��
			//1.�޸𸮿� �����ͺ��̽� ����̹� Ŭ������ �ε��մϴ�.(�ε� -> ����) throws ClassNotFoundException ó��.
			Class.forName(driver);
			
	//2.DriverManager Ŭ������ �޸𸮿� �ε�� ����̹� Ŭ������ �����ϰ�		
	//3.DriverManager Ŭ������ �޼ҵ� getConnection ���� �����ͺ��̽�(����Ŭ) ����̹��� ���� Connection ������ü�� ����
	//                            		�� �������̽� Connection Ÿ������ �����մϴ�.
	//									�� new ���� �ܿ� ��ü�� �����ϴ� �ٸ� ���. : �޼ҵ带 �����Ͽ� ��ü�����ϴ� ����������		
			conn = DriverManager.getConnection(url,user,password);    	//throws SQLException
			
			System.out.println(conn);
			if(conn !=null) {
				System.out.println("�����ͺ��̽� ���� ����!!");
			}else 
				System.out.println("�����ͺ��̽� ���� ����!!");
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("�����ͺ��̽� ����̹� �ε忡 ������ ������ϴ�. : " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("�����ͺ��̽� ���� �� ��뿡 ������ ������ϴ�. : " + e.getMessage());
		} finally {
			//db ���� �� ��� db�۾��� �����ϸ� ���ӵ� ����.
			try {
				conn.close();				
			} catch (SQLException e) {
		}
		
	}

}
}
