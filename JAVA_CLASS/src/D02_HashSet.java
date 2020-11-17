
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class D02_HashSet {
	public static void main(String[] args) {
		
//		# set
//		- 집합을 구현해놓은 클래스
//		- 요소로 같은 값이 들어오는 것을 허용하지 않는다. (중복허용X, 순서X)
//		
//		# Hash
//		- 어떤 값을 넣었을 때 전혀 예측할 수 없는 값이 생성되어야 한다는 알고리즘
//		- 생성된 값으로 원래 값을 찾는 것이 불가능에 가깝다
//		- 다시 원래 값으로 돌아갈 수 없는 단반향 알고리즘
//		- 속도가 빠르고 보안성이 뛰어난 알고리즘
		
		Set<Character> alphabet01 = new HashSet<Character>();
		Set<Character> alphabet02 = new HashSet<Character>();
		
		Collections.addAll(alphabet01, 'A','B','C','D','E');
		Collections.addAll(alphabet02, 'D','E','F','G','H');
		
		List<Character> alpha_all = new ArrayList<Character>();
		
		alpha_all.addAll(alphabet01);
		alpha_all.addAll(alphabet02);
		
		System.out.println(alpha_all);
		
		// removeAll(collection) : 	전달한 컬렉션과 일치하는 모든 값을 제거한다.
		// retainAll(collection) : 	전달한 컬렉션과 일치하는 값만 유지한다.
		// containsAll(collection):	전달한 컬레션의 모든 요소가 포함되어 있는지 확인한다.
		
		
	}
}
