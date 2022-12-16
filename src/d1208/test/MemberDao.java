package d1208.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import jdbc.util.OracleUtil;

//Dao Ŭ���� : Data Access Object.	SQL �����ϴ� �޼ҵ带 ��Ƴ��� Ŭ����
//						�� DAO Ŭ������ '��ü�� 1���� �����ǵ����ϴ� ����������' - �̱������� ����ϴ�.
//						�� 1���� ��ü�� ���� ���α׷����� ����ϵ��� �մϴ�. static �Ⱦ��� �̱������� ����ϴ�. 
//						�� �ν��Ͻ� �޼ҵ�� ������ �������̽� ����� ��ӿ��� �޼ҵ� �����ǰ� �����մϴ�.
public class MemberDao {

	private static MemberDao dao = new MemberDao();		//private static ��������� �����ϴ� ���� �ڱ��ڽ� ��ü
	private MemberDao() { };						//������ private(�� Ŭ���� �ܿ��� ������.)
	public static MemberDao getMemberDao() {			//������ ��ü�� �������ִ� public �޼ҵ� - �׻� ������ ��ü�� ����
		return dao;
	}
	
	public void delete(int custno) throws SQLException {
		String sql = "delete from member_tbl_02 where custno = ?";
		Connection conn = OracleUtil.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, custno);
		pstmt.execute();
		pstmt.close();
		conn.close();
	}
	
	public void update(Member member) throws SQLException {
		String sql = "update member_tbl_02 \r\n"
				+ "set phone = ?, address = ?, city = ?\r\n"
				+ "where custno = ?";
		Connection conn = OracleUtil.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, member.getPhone());
		pstmt.setString(2, member.getAddress());
		pstmt.setString(3, member.getCity());
		pstmt.setInt(4, member.getCustno());
		
		pstmt.execute();
		pstmt.close();		//pstmt�� ������ sql ���� ����.(close:�ڿ�����)
		//conn.commit();	//autocommit�� false(OFF)�϶��� �ʿ��մϴ�.
		//conn.rollback();	//�ϳ��� Ʈ������� �����ϴ� ���� SQL�� �Ϻ� �����϶�. �̹� �����
		conn.close();
	}
	
	public void insert(Member member) throws SQLException {
		//Member ��ü�� ���ڷ� �޾Ƽ� insert �� ������ SQL�� ����.
		Connection conn = OracleUtil.getConnection();
		String sql = "INSERT INTO member_tbl_02 \r\n"
				+ "values(seq_score11.nextval,?,?,?,sysdate,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, member.getCustname());
		pstmt.setString(2, member.getPhone());
		pstmt.setString(3, member.getAddress());
		pstmt.setString(4, member.getGrade());
		pstmt.setString(5, member.getCity());
		
		pstmt.execute();
		pstmt.close();
		conn.close();
		
		
	}
	
	
	public List<Member> selectList() throws SQLException {		//Member ��ü�� ������ ����Ʈ�� ����
		
		Connection conn = OracleUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from member_tbl_02";
		
		pstmt = conn.prepareStatement(sql);		//Exception ó���� jvm���� throw(����. ���ѱ��)
		rs = pstmt.executeQuery();
		List<Member> memberList = new ArrayList<>();		//select ��ȸ����� �ڹ� ��ü�� ����.
		int cnt = 0;
		while(rs.next()) {
			Member m = new Member(
							rs.getInt(1),
							rs.getString(2),
							rs.getString(3),
							rs.getString(4),
							rs.getDate(5),
							rs.getString(6),
							rs.getString(7)
					);
			memberList.add(m);
		}
		rs.close();
		pstmt.close();
		conn.close();
		return memberList ;
	}
	
	
	public Member selectOne(int custno) throws SQLException {
		//pk�� custno�� ���ڷ� ���޹޾Ƽ� �ش�Ǵ� ��ȸ����� Member��ü�� ����
		Member member = null;
		Connection conn = OracleUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from member_tbl_02 where custno = ?";
		
		pstmt = conn.prepareStatement(sql);		
		pstmt.setInt(1, custno);		//***** �޼ҵ忡�� SQL ������ ���� ���ڷ� �޾ҽ��ϴ�.
		rs = pstmt.executeQuery();

		if(rs.next()) 
			member = new Member(
							rs.getInt(1),
							rs.getString(2),
							rs.getString(3),
							rs.getString(4),
							rs.getDate(5),
							rs.getString(6),
							rs.getString(7)
					);
		
		rs.close();
		pstmt.close();
		conn.close();
		return member;
	}
}

//insert, update, delete SQL�� ���� �޼ҵ� ����. and �׽�Ʈ