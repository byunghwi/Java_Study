import java.util.Comparator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import quiz.Mango;

public class D95_TreeSet {
	public static void main(String[] args) {
//		 # TreeSet 
//		 - 중복값 저장할수 없다
//		 - 데이터를 저장할 때 오름차순으로 저장한다
//		 - 요소로 null을 허용하지 않는다
//		 - 저장 속도가 느린 대신 데이터 접근 / 검색 속도가 빠르다.
		
		TreeSet<Mango> sweet_mango_tree = new TreeSet<Mango>(new Comparator<Mango>() {

			@Override
			public int compare(Mango o1, Mango o2) {
				// *주의) Set은 중복데이터를 허용하지 않으므로, 같은 당도를 지닌 망고는 사라지게됨.
				//return o1.sweet - o2.sweet;
				
				//같은 당도를 지녔을 때는 망고Id를 기준으로 다시 정렬
				int sweet_value = o1.sweet - o2.sweet;
				
				//id 대신 hashCode()를 사용해도 된다. (해당 객체를 유일하게 구분)
				return sweet_value == 0? o1.hashCode() - o2.hashCode() : sweet_value;
			}
		});
		
		for (int i = 0; i < 1000; i++) {
			sweet_mango_tree.add(new Mango());
		}	
		System.out.println(sweet_mango_tree);
		
		// descendingSet() : 내림차순으로 정렬된 Set 반환
		System.out.println(sweet_mango_tree.descendingSet());
		
		Set<Mango> hSet = sweet_mango_tree.headSet(new Mango(0, 5, 500));
		
		// HeadSet() : 맨 앞부터 원하는 위치까지의 Set을 반환
		System.out.println("HeadSet : "+ hSet);
		System.out.println( "headSet의 개수 : " + hSet.size());
		
		SortedSet<Mango> tSet = sweet_mango_tree.tailSet(new Mango(0, 5, 500));
		
		System.out.println("tailSet의 개수 : " + tSet.size());
		
		SortedSet<Mango> h_tSet = tSet.tailSet(new Mango(0, 8, 1000));
		System.out.println("h_tSet의 개수 : " + h_tSet.size());
		
		SortedSet<Mango> t_tSet = tSet.headSet(new Mango(0, 8, 1000));
		System.out.println("t_tSet의 개수 : " + t_tSet.size());
		
		
		// subSet(from , to)
		SortedSet<Mango> result = sweet_mango_tree.subSet(new Mango(0, 7, 1000), new Mango(0, 9, 1000));
		System.out.println(result);
	}
}
