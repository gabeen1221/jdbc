package d1213.book;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

//@TestMethodOrder(value=MethodOrderer.OrderAnnotation.class)
@TestMethodOrder(value=MethodOrderer.OrderAnnotation.class)
class BookRentUnitTest {
	//�Ʒ��� DAO Ŭ���� �޼ҵ带 �׽�Ʈ �ϴ� ���� �����Դϴ�.
	private BookRentDao dao = BookRentDao.getInstance();
	
	@Order(1)
	@DisplayName("�뿩 ���� ���� ����� ũ��� count �Լ����� �����ؾ��մϴ�.")
	@Test
	void selectRentBooktest() throws SQLException {
		//��¹� ��� ���������� ��¹��� �ٽ��� �ƴմϴ�.
			List<BookRentDto> list = dao.selectRentBook();
			for(BookRentDto br : list)
				System.out.println(br);	
			
			assertEquals(1, list.size());		
			//assertXXX�� ���� �޼ҵ� : ��밡 ��ġ�ϸ� ����, �׷��� ������ ����
			//Junit ������ â�� failures(����) ���ڰ� 1�̸� �׽�Ʈ �޼ҵ� ����
			//fail("Not yet implemented");		//fail �޼ҵ�� ���� ����
	}
	@Order(2)
	@DisplayName("ȸ����ȣ 10004�� ���� �뿩 ���ɿ��� - ��밪 false")
	@Test
	void isAvailableMemberTest() throws SQLException {
		boolean result = dao.isAvailableMember(10004);
		assertEquals(false, result);
		//assertFalse(result);		//���� ������ �޼ҵ�
	}
	@Order(3)
	@DisplayName("�����ڵ� ������ �����Ϳ� ���� �뿩 ���ɿ��� - ��밪 false")
	@ParameterizedTest
	@ValueSource(strings = {"C1101"})
	//@Test
	void isAvailableBookTest(String bcode) throws SQLException {		//������ �����ڵ� ���� �Ű�����
		boolean result = dao.isAvailableBook(bcode);
		assertFalse(result);
	//�������� : '��Ȯ�� �����Ϳ� ��Ȯ�� ��밪���� �׽�Ʈ�� ������' 
	//				�����Ѵٸ� �����ڵ�(�޼ҵ�)�� ���� �Դϴ�.
	}
	@Order(4)
	@DisplayName("ȸ�� ������ �����Ϳ� ���� �뿩 ���ɿ��� - ��밪 true")
	@ParameterizedTest
	@ValueSource(ints = {10001,10002,10003})
	void isAvailableMemberTest2(int mem_idx) throws SQLException {		//������ �����ڵ� ���� �Ű�����
		boolean result = dao.isAvailableMember(mem_idx);
		assertTrue(result);
}
	@Order(5)
	@DisplayName("ȸ�� 10004�� �뿩 ������ �ִ���  - ��밪 not null")
	@Test
	void rentMemberTest() throws SQLException {
		BookRentDto dto = dao.selectRentByMember(10004);
		assertNotNull(dto);
	}
	@Order(1)
	@DisplayName("ȸ�� 10009 , ���� C1101 �뿩 ���� - ��밪 0")
	@Test
	void rentTest() {
		try {
		int cnt = dao.rentBook(10009, "C1101");
		assertEquals(0, cnt);
		} catch (SQLException e ) {
			System.out.println("�뿩 ���� : �߸��� ȸ�� �Ǵ� ���� �Դϴ�.");
			}
		}
		@DisplayName("ȸ�� 10009 , ���� C1101 �뿩 ���� - ��밪 0")
		@Test
		void rentTest2() {
			try {
				int cnt = dao.rentBook(10003, "A1102");
				assertEquals(1, cnt);
			} catch (SQLException e ) {
				System.out.println("�뿩 ���� : �߸��� ȸ�� �Ǵ� ���� �Դϴ�.");
			}
		}
}
/*
 	JUnit : �����׽�Ʈ(����ڰ� ���� �޼ҵ� �߽�)�� ���� ����(�ܺζ��̺귯�� �߰�) 
	�����׽�Ʈ�� �����Ͱ� �غ�(given)�Ǹ� � �޼ҵ带 ����(when)�������� ����� 
	����ϴ�(then) ���� ���;��ϴ� ���� �����ϴ� �����Դϴ�.
	@Test ������̼��� ǥ�õ� �޼ҵ带 �����ϰ� ����.
*/