package project1;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class BoxApp {

	public static void main(String[] args) throws SQLException {
		boolean run = true;
		Scanner sc = new Scanner(System.in);
		BoxDao dao = BoxDao.getBoxDao();
		while(run) {
			System.out.println("[1] 조회 [2] 삽입 [3] 삭제");
			System.out.print("선택 >>> ");
			String sel = sc.nextLine();
			Box box = new Box(11, 1, 106);
			switch(sel) {
			case "1":
				dao.selectList();
				sc.nextLine();
				break;
			case "2":				
				dao.insert(box);
				System.out.println("추가 되었습니다.");
				break;
			case "3":
			
			}
		}
		
	}
}
