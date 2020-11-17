package quiz;

import java.util.HashMap;
import java.util.Map;

public class D07_PhoneBook {
	
	public static void main(String[] args) {
		
		// # HashMap을 이용한 PhoneBook을 구현하라
		
		// 1. 그룹 / 전화번호 / 이름  을 저장해야한다.
		// 2. 그룹 이름을 키값으로 넣으면 해당 그룹의 전화번호 목록이 나온다.
		// 3. 전화번호 목록에 전화번호를 키로 넣으면 이름이 나온다.
		
		// # 구현해야할 메서드
		// 1. 새로운 그룹을 추가하는 메서드
		// 2. 존재하는 그룹에 새로운 전화번호를 등록하는 메서드
		// 3. 등록된 모든 전화번호를 보기좋게 출력하는 메서드
		// 4. 이름의 일부를 입력하면 일치하는 모든 전화번호가 출력되는 메서드
		// 5. 전화번호의 일부를 입력하면 일치하는 모든 전화번호가 출력되는 메서드
		
		
		PhoneBook pb = new PhoneBook();
		
		//그룹추가
		pb.addGroup("학원");
		pb.addGroup("교회");
		pb.addGroup("친구");
		pb.addGroup("교회");
		pb.addGroup("축구");
		pb.addGroup("축구");
		
		//전화번호 추가
		pb.addPhoneNum("010-123-1234", "서연준", "학원");
		pb.addPhoneNum("010-2465-1234", "고병휘", "친구");
		pb.addPhoneNum("010-4885-1234", "김길동", "친구");
		pb.addPhoneNum("010-1237-7821", "김병휘", "교회");
		pb.addPhoneNum("010-1872-2018", "홍길동", "교회");
		pb.addPhoneNum("010-1764-1234", "박태희", "교회");
		pb.addPhoneNum("010-1764-1547", "박연준", "축구");
		pb.addPhoneNum("010-1457-1234", "박민수", "축구");
		
		//이쁘게 찍기
		pb.printPhoneBook();
		
		//번호, 이름으로 조회
		pb.findName("병휘");
		pb.findNum("65");
		
		
	}
}
