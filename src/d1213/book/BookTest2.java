package d1213.book;

import java.sql.SQLException;

public class BookTest2 {

	public static void main(String[] args) {

		BookRentDao dao = BookRentDao.getInstance();
		System.out.println("::: �뿩 :::");
//		Scanner sc = new Scanner(System.in);
		int mem_idx = 10002;
		String bcode ="C1101";
		try {
			if(!dao.isAvailableMember(mem_idx))
				System.out.println("ȸ������ �뿩 ���� ������ �־� �߰� �뿩 �Ұ�!!");
			else if(!dao.isAvailableBook(bcode))
				System.out.println("�� å�� �뿩 �� �Դϴ�.!!");
			else { 
//				dao.rentBook(mem_idx, bcode);
				//dtoŬ������ �Ϻ� �Ӽ� ������ �ʱ�ȭ �Ҷ� �Ʒ��� ���� ����� ����(������,ȿ����..)
//				dao.rentBook(new BookRentDto(0, mem_idx, bcode, null, null, null, 0));
				dao.rentBook(BookRentDto.builder()		//sataic�޼ҵ�� ������ü ����
									.mem_idx(mem_idx)	//���� ��ü���� �޼ҵ� ���� ������ ����
									.bcode(bcode)				//				   �޼ҵ� �̸��� �ʵ�(�Ӽ�����)�� ����
									.rent_no(0)
									.build());			//build() �޼ҵ� �������� dto ��ü���� �Ϸ�
				System.out.println(mem_idx + " ȸ�� "+ bcode  + "���� �뿩ó�� �Ϸ�!!");
			}	
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	
	
	
	
	}

}