package myobj.fruit;


// RuntimeException�� ��ӹ��� ��ü�� �ݵ�� ó������ �ʾƵ� �Ǵ� ���� ��ü�� �ȴ�
public class InvalidColorException extends RuntimeException {
	public InvalidColorException() {
		super("�̻��� ���� ����");
		
		// throw�� ����������, �ݵ�� ó���϶�� �������� ���� ����
	}
}
