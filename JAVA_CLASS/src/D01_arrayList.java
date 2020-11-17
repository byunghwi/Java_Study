import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class D01_arrayList {
//	# Java Collections
//	- 자바에서 기본으로 제공하는 자료구조 인터페이스
//	- Collections 인터페이스를 구현한 클래스로는 List, Set이 있다.
//	
//	# ArrayList 
//	- 배열과 다르게 크기가 자동으로 조절되는 배열.
//	- 배열과 유사한 형태이기 때문에 순차적으로 데이터에 접근할 때 가장 유리하다.
// 	- 타입을 지정해주지 않으면 모든 타입이 들어갈 수 있는 ArrayList가 된다.
// 	- remove(인덱스) 인덱스 위치의 요소가 삭제되고 삭제되는 값을 리턴.	
	
//	# Collection은 Collections의 기능들을 사용할 수 있다.

	public static void main(String[] args) {
		
		ArrayList<String> list = new ArrayList<>();
		
		list.add("가");
		list.add("나");
		list.add("다");
		
		Iterator<String> it = list.iterator();
		
		while(it.hasNext()) {
			System.out.print(it.next());
		}
		
		System.out.println(list);

		Collections.addAll(list, "아아ㅏ3","아아ㅏ2","아아ㅏ1","아아ㅏ4","아아ㅏ5");
		System.out.println(list);
		
		Collections.sort(list);
	}
}
