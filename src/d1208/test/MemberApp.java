package d1208.test;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class MemberApp {

	public static void main(String[] args) throws SQLException {
		boolean run = true;
		Scanner sc = new Scanner(System.in);
		//SQL ������ Dao ��ü ����
		MemberDao dao = MemberDao.getMemberDao();
		while (run) {
			System.out.println("[i] insert  [s]select ��ü [p]select PK [e]����");
			System.out.print("�޴� ���� >>> ");
			String sel = sc.nextLine();

			switch (sel) {
			case "i":
				System.out.print("�̸� �Է� >>> ");
				String name = sc.nextLine();
				System.out.print("�ּ� �Է� >>> ");
				String addr = sc.nextLine();
				Member member = new Member(0, name, null, addr, null, null, null);
				dao.insert(member);
				break;
			case "s":
				List<Member> list = dao.selectList();
				for(Member m : list)
					System.out.println(m.getCustno() + "\t" +
								m.getCustname() + "\t" +
								m.getAddress() + "\t" +
								m.getPhone() + "\t" +
								m.getJoindate() + "\t" +
								m.getGrade() + "\t" +
								m.getCity() );
				
				break;
			case "p":

				break;
			case "e":
				run = false;
				System.out.println("���α׷��� ���� �մϴ�.");
				break;

			default:
				break;
			}

		}

	}

}
