package myobj.fruit;

// Exception Ŭ������ ��ӹ����� "�ݵ�� ó���ؾ� �ϴ� ����"�� �ȴ� 
public class NoMoreCalorieException extends Exception {
	
	public NoMoreCalorieException() {
		super("�� �̻� ���� �� ���� ���");
	}
}
