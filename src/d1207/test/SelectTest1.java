package d1207.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.util.OracleUtil;

public class SelectTest1 {

	public static void main(String[] args) {
		//java.sql ��Ű���� �������̽��� �ڹ�API�� ����Ŭ������ �����ϴ�. ������ �ٸ���ü�� ���ؼ� ��ü�� ����.
		Connection conn = OracleUtil.getConnection();
		System.out.print("����Ȯ�� : ");
		System.out.println(conn);		//null�� ��µǸ� �������.
		
		//SQL select �����غ��ô�. - ���ο� ��ü 2���� -> �������̽��� ���ؼ� DBMS ������ ���� ����ü�� ��ü�� ����
		PreparedStatement pstmt = null;		//sql ������ ��ü�� ����
		ResultSet rs = null;						//select ���� ��� ��ü�� ����
		String sql = "select * from member_tbl_02";
		
		try {
			pstmt = conn.prepareStatement(sql);		//sql ����� ���ڷ� �޾� ������ ��ü�� �����Ͽ� pstmt�� ��������
			rs = pstmt.executeQuery();					//���� �����ϰ� �� ����� ��ü�� �����Ͽ� rs�� ��������
			//while ������ �����غ�����.
			int cnt=0;
			while(rs.next()) {
				/*System.out.println("ù��° �÷��� �� : " + rs.getInt(1));
				System.out.println("�ι�° �÷��� �� : " + rs.getNString(2));
				System.out.println("����° �÷��� �� : " + rs.getNString(3));
				System.out.println("�׹�° �÷��� �� : " + rs.getNString(4));
				System.out.println("�ټ���° �÷��� �� : " + rs.getDate(5));
				System.out.println("������° �÷��� �� : " + rs.getNString(6));
				System.out.println("�ϰ���° �÷��� �� : " + rs.getNString(7));
				cnt++;*/
				System.out.println(rs.getInt(1) + "\t" + rs.getNString(2) + "\t"
						+rs.getString(3) + "\t"
						+rs.getString(4) + "\t"
						+rs.getDate(5) + "\t"
						+rs.getString(6) + "\t"
						+rs.getString(7));
				cnt++;
			}			
			System.out.println("��ȸ�� ���� ���� : " + cnt);
			
			/*System.out.println("��ȸ ����� �ֽ��ϱ�? (ù��° ��) : " + rs.next());		//next() �޼ҵ� : ��ȸ ��� �������� ����. �� �Ǵ� ����
			System.out.println("ù��° �÷��� �� : " + rs.getInt(1));
			System.out.println("�ι�° �÷��� �� : " + rs.getNString(2));
			System.out.println("����° �÷��� �� : " + rs.getNString(3));
			System.out.println("�׹�° �÷��� �� : " + rs.getNString(4));
			System.out.println("�ټ���° �÷��� �� : " + rs.getDate(5));
			System.out.println("������° �÷��� �� : " + rs.getNString(6));
			System.out.println("�ϰ���° �÷��� �� : " + rs.getNString(7));

			System.out.println("��ȸ ����� �ֽ��ϱ�? (�ι�° ��) : " + rs.next());	
			System.out.println("ù��° �÷��� �� : " + rs.getInt("custno"));
			System.out.println("�ι�° �÷��� �� : " + rs.getNString("custname"));
			System.out.println("����° �÷��� �� : " + rs.getNString("phone"));
			System.out.println("�׹�° �÷��� �� : " + rs.getNString("address"));
			System.out.println("�ټ���° �÷��� �� : " + rs.getDate("joindate"));
			System.out.println("������° �÷��� �� : " + rs.getNString("grade"));
			System.out.println("�ϰ���° �÷��� �� : " + rs.getNString("city"));
			
			System.out.println("��ȸ ����� �ֽ��ϱ�? (3��° ��) : " + rs.next());
			System.out.println("��ȸ ����� �ֽ��ϱ�? (4��° ��) : " + rs.next());
			System.out.println("��ȸ ����� �ֽ��ϱ�? (5��° ��) : " + rs.next());
			System.out.println("��ȸ ����� �ֽ��ϱ�? (6��° ��) : " + rs.next());
			System.out.println("��ȸ ����� �ֽ��ϱ�? (7��° ��) : " + rs.next());		//false
			*/
			
		
		} catch (SQLException e) {
			e.printStackTrace();			//??
		}
		
//		���� �����ϰ� ����� �ڹ� ��ü�� �����ϴ� ���
//		1)�����ϰ� statement ��ü���	2)�����ӿ�ũ : �ڵ��밡�ٸ� �ּҷ�	3)SQL �̿����� �ʰ� �ٷ� �ڹٰ�ü�� ����
	
	
		OracleUtil.close(conn);
	}
}
