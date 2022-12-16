package project1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import jdbc.util.OracleUtil;

public class BoxDao {

	private static BoxDao dao = new BoxDao();
	private BoxDao() {};
	public static BoxDao getBoxDao() {
		return dao;
	}
	
	public void insert(Box box) throws SQLException {
		Connection conn = OracleUtil.getConnection();
		String sql = "INSERT INTO TBL_WEPTOON_BOX \r\n"
				+ "VALUES(SQ_WEPTOON_BOX.NEXTVAL, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, box.getUno());
		pstmt.setInt(2, box.getWno());

		pstmt.execute();
		conn.close();
	}
	
	
	
	public void selectList() throws SQLException {
		
		Connection conn = OracleUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT B.ID , A.NAME FROM (SELECT * \r\n"
				+ "FROM TBL_WEPTOON_WEPTOON tww  \r\n"
				+ "JOIN TBL_WEPTOON_BOX twb  \r\n"
				+ "ON tww.WNO = TWB.WNO) A JOIN\r\n"
				+ "(SELECT *\r\n"
				+ "FROM TBL_WEPTOON_USER twu \r\n"
				+ "JOIN TBL_WEPTOON_BOX twb \r\n"
				+ "ON twu.UNO = twb.UNO) B ON \r\n"
				+ "A.BNO = B.BNO";

		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		List<Box> boxList = new ArrayList<>();
		int cnt = 0;
		while(rs.next()) {
			System.out.println(rs.getString(1));
			System.out.println(rs.getString(2));
		}
		conn.close();
	}		
}
