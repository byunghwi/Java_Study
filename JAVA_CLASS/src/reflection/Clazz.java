package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import myobj.fruit.NoMoreCalorieException;

public class Clazz {

	// # Ŭ���� Ŭ���� 
	//	- Ŭ������ ������ ���� �� �ִ� Ŭ����
	//	- ���ϴ� Ŭ������ �ҷ��� �ش� Ŭ������ �����ִ� ����, �޼��带 ����� �� �ִ�
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, NoMoreCalorieException {
		myobj.fruit.Apple apple01 = new myobj.fruit.Apple("red");
		
		Class c = null;
		Class c2 = apple01.getClass(); 	
	
		try {
			c = Class.forName("myobj.fruit.Apple");
		} catch (ClassNotFoundException e) {			
			System.out.println("Ŭ���� �̸��� Ʋ�Ƚ��ϴ�!");
			System.exit(0);
		}
		
		System.out.println("forName���� �ҷ��� Class�̸� : " + c.getName());
		System.out.println("forName���� �ҷ��� package�̸� : " + c.getPackageName());
		System.out.println("forName���� �ҷ��� simpleName : " + c.getSimpleName());
		
		System.out.println("�̰� �������̽��ΰ���? " + c.isInterface());
		System.out.println("�̰� �迭�ΰ���? " + c.isArray());
		System.out.println("�̰� �⺻���ΰ���? " + c.isPrimitive());
		
		Class c3;
		try {
			c3 = Class.forName("reflection.SimpleInterface");
			System.out.println("c3�� �������̽��ΰ���? " + c3.isInterface());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		// Class Ÿ�� ������ ����� Ŭ�������� ���赵 ���·� �����ϰ� �ִ�
		//	���赵�� ������ ���1 : forName�޼��忡 ��Ű������ ��Ȯ�ϰ� �Է��Ѵ�
		//	���赵�� ������ ���2 : ������� �ν��Ͻ����� getClass()�޼��带 �����Ѵ� 
		
		// �� Ŭ������ � �����ڵ��� �ִ��� �˾Ƴ��� ��� 
		for (Constructor con : c.getConstructors()) {			
			System.out.println(con.getName());
			// Constructor.getParameterTypes() 
			//	- �ش� �����ڰ� ���޹޾ƾ� �ϴ� �Ű����� Ÿ�Ե��� �迭 ���·� ��ȯ�Ѵ�
			//	- �Ű������� Ÿ�Ե� Ŭ�����̱� ������, Ŭ���� Ÿ�� �迭�� ��ȯ�ȴ�
			printParameters(con.getParameterTypes());
		}
		
		// Ŭ���� �̸����� Ŭ������ �ҷ��µ� �����ڸ� ��� �ν��Ͻ��� ����
		Object apple02 = c.getConstructor(
				Class.forName("java.lang.String")
		).newInstance("red");
		
		((myobj.fruit.Apple)apple02).eat().eat().eat();
		
		Object apple03 = c.getConstructor(Class.forName("java.lang.Integer"), Class.forName("java.lang.String")).newInstance(900, "green");
		
		//�� Ŭ������ � �ʵ尪(����)���� �ִ��� �˾Ƴ��� ���
		for(Field f : c.getFields()) {
			System.out.println("Accessible : " + f.getName());
		}
		for(Field f : c.getDeclaredFields()) {
			System.out.println("Declared : "+ f.getName());
		}
		
		
		try {
			Field calorie = c.getDeclaredField("calorie");
			Field color = c.getDeclaredField("color");
			
			// Field Ŭ������ �˾Ƴ� �� �ִ� ������
			System.out.println(calorie.getType());
			
			System.out.println("---- color Field ----");
			System.out.println("Ÿ�� : " + color.getType().getSimpleName());
			System.out.println("���������� : " + Modifier.toString(color.getModifiers()));
			System.out.println("������ : " + color.getName());
		} catch (NoSuchFieldException e) {
			System.out.println("�׷� �ʵ� ���� �ͼ���");
			e.printStackTrace();
		} catch (SecurityException e) {
			System.out.println("�Ⱥ��� invisible �ͼ���");
			e.printStackTrace();
		}
		
		for (Method m : c.getMethods()) {
			System.out.println("Accessible Method : " + m);
		}
	}	
	
	private static void printParameters(Class[] parameters) {
		
		for (int i = 0; i < parameters.length; ++i) {
			System.out.printf("%d��° �Ķ������ Ÿ�� : %s(%s)\n", 
					i, 
					parameters[i].getSimpleName(),
					parameters[i].getName());
		}
		
	}
}
























