import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class D03_LinkedList {
	public static void main(String[] args) {
//		# 연결 리스트
//		 - ArrayList보다 삽입/삭제에 유리한 리스트
//		 - 중간에 삽입이 일어났을 때
//		 - ArrayList는 모든 데이터를 뒤로 이동시켜야 하지만 (Shift)
//		 	LinkedList는 연결된 노드만 바꾸면 되기 때문에 훨씬 빠르다.
//		 - ArrayList는 데이터 저장, 읽기에 유리하고
//		 LinkdedList는 데이터 생성 및 삭제에 유리하다.
		
		LinkedList<String> mem = new LinkedList<String>();
		
		Stack<String> stack = new Stack<String>();
		Queue<String> queue = new LinkedList<String>();
		
//		poll() 		: 첫 번쨰 요소를 꺼내면서 사용 
//		pollLast() 	: 가장 최근에 추가한 요소를 꺼내면서 사용
//		peek() 		: 삭제는 하지 않고 맨 처음 요소를 사용하기
//		peekLast() 	: 삭제는 하지 않고 마지막 요소를 사용하기
		 
		mem.add("회1");
		mem.add("회1");
		mem.add("회1");
	}
}
