package d1207.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.util.OracleUtil;

public class SelectTest3 {

	public static void main(String[] args) {
		
		Connection conn = OracleUtil.getConnection();
		System.out.print("연결확인 : ");
		System.out.println(conn);		
		
		PreparedStatement pstmt = null;		
		ResultSet rs = null;						
		String sql = "SELECT mt.custno, \r\n"
				+ "	custname \"회원이름\",\r\n"
				+ "	decode(grade,'A','VIP','B','일반','C','직원')\"고객등급\",\r\n"
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
			System.out.println("조회된 행의 개수 : " + cnt);
			
		
		
		} catch (SQLException e) {
			e.printStackTrace();			
		}
		

	
		OracleUtil.close(conn);
		

	}
}
