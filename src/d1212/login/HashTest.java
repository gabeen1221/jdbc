package d1212.login;

import java.nio.charset.StandardCharsets;

import com.google.common.hash.Hashing;

public class HashTest {
	
	public static void main(String[] args) {
		//�ؽ��Լ� : ���ڿ��� ���޹޾Ƽ� ��ȣȭ(�� -> ��ȣȭ�� ���ڿ�). ��ȣȭ�� �޼����� ������ ��ȯ������ ����.
		//				�н����带 ������ �� �ؽð����� ����. �ؽð��� �ؽ��Լ��� ���� ������ ���̷� ����
		//				��ǥ������ sha256, sha512 �Լ����� 256��Ʈ �Ǵ� 512��Ʈ ���̷� �ؽð� ����ϴ�.
		//				�ܺζ��̺귯�� guava�� ����ϸ� sha256 �޼ҵ尡 �ֽ��ϴ�. 
	
		//�� 1122�� sha256�Լ��� �ؽð��� �����?
		String hval = Hashing.sha256()
				.hashString("1122", StandardCharsets.UTF_8)	//ù��° ���ڰ��� ���ڵ� ����
				.toString();
	
		System.out.println("�� '1122'�� sha256�Լ��� �ؽð� �����?");
		System.out.println(hval);		//256��Ʈ�� 16������ ǥ���ϸ� 64����
		
		//�ؽð����� ���� ����(���)�� �� ���� ������ �˰����� �ؽ��Լ��� �̹� ������ ���� ���.
	}
}
