package d1212.test;

import java.sql.Connection;
import java.sql.SQLException;

import d1208.test.Member;
import d1208.test.MemberDao;
import jdbc.util.OracleUtil;

public class MemberUpdateTest {

	public static void main(String[] args) throws SQLException {
		//Connection conn = OracleUtil.getConnection();
		//System.out.println("autocommit : " + conn.getAutoCommit()); //autocommit �⺻�� true
		
		MemberDao dao = MemberDao.getMemberDao();
		
		dao.update(new Member(100003 , "����" , "010-2323-2323" , "������ ���ʽ�" , null , null , "33"));
		
	
		
	}
}
