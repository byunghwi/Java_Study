import java.util.HashMap;
import java.util.Map;

public class D07_HashMap {
	public static void main(String[] args) {
		Map<String, String> map01 = new HashMap<String, String>();
		
		
		map01.put("이름", "벨");
		map01.put("나이", "5세");
		map01.put("견종", "도베르만");
		
		System.out.println(map01.get("견종"));
		
		//# �ݺ������� Map Ȱ���ϱ�
		// - keySet() : key ��� �̷���� Set�� ��ȯ
		// - values() : value ��� �̷���� Collection �� ��ȯ
		// - entrySet() : Entry(K, V) ��� �̷���� Set�� ��ȯ
		
		System.out.println("map01의 keySet : "+ map01.keySet());
		System.out.println("map01의 valueSet: "+ map01.values());
		System.out.println("map01의 EntrySet : " + map01.entrySet());
		
		// remove메서드로 원하는 데이터를 지울 수 있다.
//		- Key만 가지고 지우는 경우 : 방금 삭제한 값을 반환한다.
//		- Key와 Value 모두를 가지고 지우는 경우 : 정확하게 값도 일치할 때 삭제한다.
		
		// # getOrDefault메서드를 이요해 ,null값이 반환되는 상황이라면 기본값을 반환받을 수 있다.
		System.out.println(map01.getOrDefault("이름", "기본값"));
		System.out.println(map01.getOrDefault("엄마의 이름", "기본값"));
		
		// # Map타입 내부에 Map 타입 넣기
		HashMap<String, HashMap<String, String>> phone_book = new HashMap<String, HashMap<String,String>>();
		
		phone_book.put("학원", new HashMap<String, String>());
		phone_book.put("가족", new HashMap<String, String>());
		phone_book.put("고등학교", new HashMap<String, String>());
		phone_book.put("중학교", new HashMap<String, String>());
		phone_book.put("동아리", new HashMap<String, String>());
		
		//새로운 해쉬맵 인스턴스를 값으로 저장하면, 키값으로 해당 해쉬맵을 꺼낼 수 있게 된다.
		phone_book.put("학원", new HashMap<>());
		HashMap<String, String> groupMap = phone_book.get("학원");
		
		//키값으로 이름보다는 전화번호를 사용하는 것이 좋다.
		groupMap.put("010-1234-1234", "홍길동");
		groupMap.put("010-4321-1234", "손흥민");
		
		System.out.println(phone_book);
	;}

}
