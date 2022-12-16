package d1212.test;

import java.util.ArrayList;
import java.util.List;

//싱글턴
public class SaleDao {
	
	private static SaleDao dao = new SaleDao();	
	private SaleDao() { }						
	public static SaleDao getSaleDao() {			
		return dao;
}
	
	public List<SaleDto> salesTotal() {
		String sql = "SELECT mt.custno, \r\n"
				+ "	custname \"회원이름\",\r\n"
				+ "	decode(grade,'A','VIP','B','일반','C','직원')\"고객등급\",\r\n"
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
		//조회되는 결과 컬럼 : custno, custname, agrade, psum 4개는 member와 money 한 곳에 있는 데이터가 아니므로
		//							ㄴ 새로운 DTO를 만듭니다.
	
		List<SaleDto> list = new ArrayList<>();
		  
		return list;
	}
}