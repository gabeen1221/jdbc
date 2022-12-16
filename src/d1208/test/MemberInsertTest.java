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
		//insert/update/delete는 ResultSet 사용 안함.
		
		pstmt = conn.prepareStatement(sql);
		//execute 메소드로 SQL 실행하기 전에 필요한 인자 전달
		pstmt.setString(1, "나행복");
		pstmt.setString(2, "010-7777-2299");
		pstmt.setString(3, "서울시 강남구 청담동");
		pstmt.setString(4, "B");
		pstmt.setString(5, "02");
		
		
		pstmt.execute();							//select SQL은 executeQuery 메소드, 나머지는 execute 메소드
		conn.close();
	} 
}
