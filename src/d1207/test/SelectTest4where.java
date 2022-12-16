package d1207.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import jdbc.util.OracleUtil;
//�ϵ��ڵ� : driver, user, password, �߿��� �������� �ҽ����� ���� ����. (���� �����Ϸ��� �ҽ��ڵ带 ����)
public class SelectTest4where {		//���ǽ� �߰�

	public static void main(String[] args) {
		Connection conn = OracleUtil.getConnection();
		
		PreparedStatement pstmt = null;			//sql ������ ��ü�� ����
		ResultSet rs = null;							//select ���� ��� ��ü�� ����
		//String sql = "select * from member_tbl_02 where custno = 100003";
		String sql = "select * from member_tbl_02 where custno = ?";  //?�� ���ǽİ�, ����
		
		try {
			pstmt = conn.prepareStatement(sql);		
			//sql ���ڸ� �����ϴ� ���
//			pstmt.setInt(1, 100005);		//1��° ? ��ȣ ���ڿ� ���޵� ���� 100001
			System.out.println("�˻��� ȸ�� ��ȣ �Է� >>> ");
			Scanner sc = new Scanner(System.in);
			int custno = Integer.parseInt(sc.nextLine());
			pstmt.setInt(1, custno);
			rs = pstmt.executeQuery();					//���� �����ϰ� �� ����� ��ü�� �����Ͽ� rs�� ��������
			
			System.out.println(custno + " : ��ȸ ���");
			System.out.println("::::::::::::::::::::::::::::::::::::;");
			int cnt=0;
			if(rs.next()) {	//���ǽ��� �÷� custno�� Pk -> ��ȸ����� 0 �Ǵ� 1��
			
				System.out.println(rs.getInt(1) + "\t" 
						+rs.getNString(2) + "\t"
						+rs.getString(3) + "\t"
						+rs.getString(4) + "\t"
						+rs.getDate(5) + "\t"
						+rs.getString(6) + "\t"
						+rs.getString(7));
				cnt++;
			}			
			//System.out.println("��ȸ�� ���� ���� : " + cnt);
			if(cnt==0)
				System.out.println("��ȸ�� ȸ����ȣ�� �����ϴ�.");	
		} catch (SQLException e) {
			e.printStackTrace();		
		}
	
		OracleUtil.close(conn);
	}
}
