package d1208.test;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//�Һ� ����غ���
@Getter
@Setter
@ToString
public class MemberDto {
	private int custno;
	private String custname;
	private String phone;
	private String address;
	private Date joindate;
	private String grade;
	private String city;
}
