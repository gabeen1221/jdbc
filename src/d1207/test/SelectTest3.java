package d1207.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.util.OracleUtil;

public class SelectTest3 {

	public static void main(String[] args) {
		
		Connection conn = OracleUtil.getConnection();
		System.out.print("����Ȯ�� : ");
		System.out.println(conn);		
		
		PreparedStatement pstmt = null;		
		ResultSet rs = null;						
		String sql = "SELECT mt.custno, \r\n"
				+ "	custname \"ȸ���̸�\",\r\n"
				+ "	decode(grade,'A','VIP','B','�Ϲ�','C','����')\"�����\",\r\n"
				+ "	spr\r\n"
				+ "FROM MEMBER_TBL_02 mt \r\n"
				+ "JOIN  \r\n"
				+ "(\r\n"
				+ "	SELECT custno,sum(price)spr\r\n"
				+ "	FROM money_tbl_02 \r\n"
				+ "	GROUP BY custno\r\n"
				+ ")sale 	 \r\n"
				+ "ON mt.CUSTNO = sale.custno\r\n"
				+ "GROUP BY mt.custno,custname,grade,spr\r\n"
				+ "ORDER BY spr DESC";
		
		try {
			pstmt = conn.prepareStatement(sql);		
			rs = pstmt.executeQuery();					
			int cnt=0;
			while(rs.next()) {
			
				System.out.println(rs.getInt(1) + "\t" + rs.getNString(2) + "\t"
						+rs.getString(3) + "\t"
						+rs.getString(4) + "\t");
				cnt++;
			}			
			System.out.println("��ȸ�� ���� ���� : " + cnt);
			
		
		
		} catch (SQLException e) {
			e.printStackTrace();			
		}
		

	
		OracleUtil.close(conn);
		

	}
}
