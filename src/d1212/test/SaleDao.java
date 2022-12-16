package d1212.test;

import java.util.ArrayList;
import java.util.List;

//�̱���
public class SaleDao {
	
	private static SaleDao dao = new SaleDao();	
	private SaleDao() { }						
	public static SaleDao getSaleDao() {			
		return dao;
}
	
	public List<SaleDto> salesTotal() {
		String sql = "SELECT mt.custno, \r\n"
				+ "	custname \"ȸ���̸�\",\r\n"
				+ "	decode(grade,'A','VIP','B','�Ϲ�','C','����')\"�����\",\r\n"
				+ "	spr\r\n"
				+ "FROM MEMBER_TBL_02 mt \r\n"
				+ "JOIN  \r\n"
				+ "(\r\n"
				+ "	SELECT custno,sum(price)spr\r\n"
				+ "	FROM money_tbl_02 \r\n"
				+ "	GROUP BY custno\r\n"
				+ ")sale 	 \r\n"
				+ "ON mt.CUSTNO = sale.custno\r\n"
				+ "GROUP BY mt.custno,custname,grade,spr\r\n"
				+ "ORDER BY spr DESC";
		//��ȸ�Ǵ� ��� �÷� : custno, custname, agrade, psum 4���� member�� money �� ���� �ִ� �����Ͱ� �ƴϹǷ�
		//							�� ���ο� DTO�� ����ϴ�.
	
		List<SaleDto> list = new ArrayList<>();
		  
		return list;
	}
}