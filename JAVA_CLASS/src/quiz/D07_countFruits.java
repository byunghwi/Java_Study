package quiz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class D07_countFruits {
	
	private enum Fruit{
		APPLE, BANANA, ORANGE, KIWI
	}
	// 다음 리스트를 이용해 각 과일이 몇 개인지를 저장한 Map을 생성해보세요.
	
	static List<Fruit> fruits;
	
	static {
		fruits = new ArrayList<>();
		
		for (int i = 0; i < 50; i++) {
			fruits.add(Fruit.values()[(int)(Math.random() *4)]);
		}
	}
	
	public static void main(String[] args) {
		
		Map<Fruit, Integer> fruitsCountMap = new HashMap<>();
		
		for (Fruit fruit : fruits) {
			fruitsCountMap.put(fruit, Collections.frequency(fruits, fruit));
		}
		
		System.out.println(fruitsCountMap);
	}
}
