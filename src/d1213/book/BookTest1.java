package d1213.book;

import java.sql.SQLException;
import java.util.List;

public class BookTest1 {

	public static void main(String[] args) {

		BookRentDao dao = BookRentDao.getInstance();
		System.out.println(":::��� ȸ����ȣ(PK) ��ȸ:::");
		List<Integer> members = null;
		try {
			members = dao.selectAllMember();
			System.out.println(members);
			
		} catch (SQLException e) {
			System.out.println("��� ȸ����ȣ ��ȸ ����!!");
			e.printStackTrace();
		}
		
		System.out.println(":::��� �����ڵ�(PK) ��ȸ:::");
		List<String> books = null;
		try {
			 books = dao.selectAllBook();
			System.out.println(books);
			
		} catch (SQLException e) {
			System.out.println("��� �����ڵ� ��ȸ ����!!");
			e.printStackTrace();
		}
		
		
		System.out.println("::: ��� ȸ��(PK) �뿩 ���� ��Ȳ ::: ");
		//�ݺ��� 10004 �� false
		
		
		System.out.println("::: ��� ����(PK) �뿩 ���� ��Ȳ ::: ");
		//�ݺ��� C1101 �� false
			try {
				for(String s : books)
				System.out.println(s + ":" + dao.isAvailableBook(s));
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

}