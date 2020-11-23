package myobj;
import java.util.HashMap;
import java.util.Random;

//import myobj.fruit.Grape;
import myobj.item.Sword;
import myobj.vehicle.Vehicle;

public class C02_OOP {
	public static void main(String[] args) {
		
		//1. myobj.fruit 패키지에 클래스를 하나 정의하고 인스턴스를 생성하라.
		//2. myobj.vehicle 패키지에 클래스를 하나 정의 하고 인스턴스를 생성하라
		
		//생성자로 초기화
//		Vehicle vehicle1 = new Vehicle();
//		Vehicle vehicle2= new Vehicle(3, "Yellow", 9, 3);
//		Grape grape1 = new Grape();
//		Grape grape2 = new Grape("Green", 1, 3, 3);
//		
//		
//		System.out.println(vehicle1.upGrade(3));
//		System.out.println(vehicle2.upGrade(4));
//		System.out.println(vehicle1.color = "Blue");
//		System.out.println(vehicle1.toString());
//		System.out.println(grape2.toString());
		
		// 필드
		// - 공격력
		// - 강화수치
		// - 레벨별 강화확률 (등급마다 강화 확률이 다름)
		// - 레벨별 공격력 증가폭
		
		//메서드
		// - 강화하기 (성공률에 따라 성공 실패가 적용됨)
		//		* 최대 강화 레벨까지 도달하기에 걸린 강화 횟수를 출력
		// - 공격 (대상에게 공격력 만큼의 데미지를 입힘)
		// 		* 공격의 대상이 되는 객체는 HP가 있어야 한다.
		
		
		Random rd = new Random();
		
		int firstGrade = rd.nextInt(5)+1;
		
		System.out.println("처음 랜덤 등급 설정 > "+firstGrade);
		Sword sword = new Sword(firstGrade);
		System.out.println(sword.toString());
		
		//강화하기.
		System.out.println(sword.upGrade(sword.grade));
		System.out.println(sword.toString());
		
	}
		
		
}
