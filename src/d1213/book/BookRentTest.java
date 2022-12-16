package d1213.book;

import java.sql.SQLException;
import java.util.List;

public class BookRentTest {

	public static void main(String[] args) {
		BookRentDao dao = BookRentDao.getInstance();
		
		try {
			List<BookRentDto> list = dao.selectRentBook();
			for(BookRentDto br : list)
				System.out.println(br);			//toString() ������ ���� �ϱ� 
			
		} catch (SQLException e) {
			System.out.println("�뿩���� ���� ��ȸ ����!");
		}
		
		
	}

}