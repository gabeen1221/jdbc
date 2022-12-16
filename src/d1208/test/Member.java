package d1208.test;

import java.sql.Date;
//VOŬ���� : Value Object. ��ü�� ������ ���δ�. ��� �ʵ尪�� ������ ������ ���. hashcode, equals �޼ҵ� ������.
//DTOŬ���� : Data Transfer Object, �����͸� �����ϴ� �������� ����
public class Member {		//�Һ���ü(setter �����Ƿ� ���� �������.)
		private int custno;
		private String custname;
		private String phone;
		private String address;
		private Date joindate;
		private String grade;
		private String city;

		public Member(int custno, String custname, String phone, String address, Date joindate, String grade,
				String city) {
			
			this.custno = custno;
			this.custname = custname;
			this.phone = phone;
			this.address = address;
			this.joindate = joindate;
			this.grade = grade;
			this.city = city;
		}
		//
		@Override
		public String toString() {
			return "Member [custno=" + custno + ", custname=" + custname + ", phone=" + phone + ", address=" + address
					+ ", joindate=" + joindate + ", grade=" + grade + ", city=" + city + "]";
		}

		public int getCustno() {
			return custno;
		}

		public String getCustname() {
			return custname;
		}

		public String getPhone() {
			return phone;
		}

		public String getAddress() {
			return address;
		}

		public Date getJoindate() {
			return joindate;
		}

		public String getGrade() {
			return grade;
		}

		public String getCity() {
			return city;
		}
		
}

	