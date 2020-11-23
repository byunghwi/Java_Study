package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import myobj.fruit.NoMoreCalorieException;

public class Clazz {

	// # 클래스 클래스 
	//	- 클래스의 정보를 담을 수 있는 클래스
	//	- 원하는 클래스를 불러서 해당 클래스에 속해있는 변수, 메서드를 사용할 수 있다
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, NoMoreCalorieException {
		myobj.fruit.Apple apple01 = new myobj.fruit.Apple("red");
		
		Class c = null;
		Class c2 = apple01.getClass(); 	
	
		try {
			c = Class.forName("myobj.fruit.Apple");
		} catch (ClassNotFoundException e) {			
			System.out.println("클래스 이름이 틀렸습니다!");
			System.exit(0);
		}
		
		System.out.println("forName으로 불러온 Class이름 : " + c.getName());
		System.out.println("forName으로 불러온 package이름 : " + c.getPackageName());
		System.out.println("forName으로 불러온 simpleName : " + c.getSimpleName());
		
		System.out.println("이게 인터페이스인가요? " + c.isInterface());
		System.out.println("이게 배열인가요? " + c.isArray());
		System.out.println("이게 기본형인가요? " + c.isPrimitive());
		
		Class c3;
		try {
			c3 = Class.forName("reflection.SimpleInterface");
			System.out.println("c3가 인터페이스인가요? " + c3.isInterface());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		// Class 타입 변수에 저장된 클래스들은 설계도 형태로 존재하고 있다
		//	설계도를 빼오는 방법1 : forName메서드에 패키지명을 정확하게 입력한다
		//	설계도를 빼오는 방법2 : 만들어진 인스턴스에서 getClass()메서드를 실행한다 
		
		// 이 클래스에 어떤 생성자들이 있는지 알아내는 방법 
		for (Constructor con : c.getConstructors()) {			
			System.out.println(con.getName());
			// Constructor.getParameterTypes() 
			//	- 해당 생성자가 전달받아야 하는 매개변수 타입들을 배열 형태로 반환한다
			//	- 매개변수의 타입도 클래스이기 때문에, 클래스 타입 배열로 반환된다
			printParameters(con.getParameterTypes());
		}
		
		// 클래스 이름으로 클래스를 불러온뒤 생성자를 골라서 인스턴스를 생성
		Object apple02 = c.getConstructor(
				Class.forName("java.lang.String")
		).newInstance("red");
		
		((myobj.fruit.Apple)apple02).eat().eat().eat();
		
		Object apple03 = c.getConstructor(Class.forName("java.lang.Integer"), Class.forName("java.lang.String")).newInstance(900, "green");
		
		//이 클래스에 어떤 필드값(변수)들이 있는지 알아내는 방법
		for(Field f : c.getFields()) {
			System.out.println("Accessible : " + f.getName());
		}
		for(Field f : c.getDeclaredFields()) {
			System.out.println("Declared : "+ f.getName());
		}
		
		
		try {
			Field calorie = c.getDeclaredField("calorie");
			Field color = c.getDeclaredField("color");
			
			// Field 클래스로 알아낼 수 있는 정보들
			System.out.println(calorie.getType());
			
			System.out.println("---- color Field ----");
			System.out.println("타입 : " + color.getType().getSimpleName());
			System.out.println("접근제어자 : " + Modifier.toString(color.getModifiers()));
			System.out.println("변수명 : " + color.getName());
		} catch (NoSuchFieldException e) {
			System.out.println("그런 필드 없음 익셉션");
			e.printStackTrace();
		} catch (SecurityException e) {
			System.out.println("안보임 invisible 익셉션");
			e.printStackTrace();
		}
		
		for (Method m : c.getMethods()) {
			System.out.println("Accessible Method : " + m);
		}
	}	
	
	private static void printParameters(Class[] parameters) {
		
		for (int i = 0; i < parameters.length; ++i) {
			System.out.printf("%d번째 파라미터의 타입 : %s(%s)\n", 
					i, 
					parameters[i].getSimpleName(),
					parameters[i].getName());
		}
		
	}
}
























