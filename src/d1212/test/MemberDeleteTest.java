package d1212.test;

import java.sql.SQLException;

import d1208.test.MemberDao;

public class MemberDeleteTest {

	public static void main(String[] args) throws SQLException {
		//Ʈ����ǰ����� ���ؼ��� try ~ catch�� �̿��Ͽ� try�ȿ��� commit, catch�ȿ��� rollback
		//		-> Dao �޼ҵ忡�� �մϴ�. (�޼ҵ�� �ϳ��� Ʈ������� ����ǵ��� �ۼ�)
		
		MemberDao dao = MemberDao.getMemberDao();
		dao.delete(100122);
		
	}
}
