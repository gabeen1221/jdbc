package d1213.book;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder		//��ü �����Ҷ� ����(����������) ���. - ��ü �����ϸ鼭 �Ϻ� �Ӽ� �������� �ʱ�ȭ.
public class BookRentDto {
	private int rent_no;
	private int mem_idx;
	private String bcode;
	private Date rent_date;
	private Date exp_date;
	private Date return_date;
	private int delay_days;
	@Override
	public String toString() {
		return rent_no + "\t" 
				+ mem_idx + "\t" 
				+ bcode + "\t"
				+ rent_date + "\t"  
				+ exp_date + "\t" 
				+ return_date + "\t" 
				+ delay_days;
	}
	
	
}
/*
BookRentDto Ŭ���� - �뿩���� ����
BookRentDao Ŭ����
selectRentBook:�뿩 ���� ���� ��ȸ
selectDelay:��ü ���� ��ȸ
selectRentMember:ȸ���� �����뿩 ����. 
         ���ڴ� ȸ����ȣ , ������ �뿩���� 
rentBook �޼ҵ� :�뿩 (insert). ���� void
returnBook:�ݳ� (update). ���� void
*/