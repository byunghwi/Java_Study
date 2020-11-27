package jdbcQuiz;

import java.util.HashMap;

public class Car {
	String carNumber;
	String carType;
	String useType;
	static final char charArr[];
	static final int count;

	static HashMap<String, String> carGroup;
	
	static {
		charArr = "가나다라마거너더러머버서어저고노도로모보소오조구누두루무부수우주바사아자허하호배공해육합국".toCharArray();
		count = 100;
		carGroup = new HashMap<String, String>();
	}
	

	public Car() {
		
	}
	
	//자동으로 차량번호 세팅 및 세팅된 횟수만큼 생성 메서드
	public void createRanNumber() {

		// # 가운데 문자
		// 가,나,다,라,마,거,너,더,러,머,버,서,어,저,고,노,도,로,모,보,소,오,조,구,누,두,루,무,부,수,우,주 
		// 바,사,아,자,허
		
		// # 뒤 4자리 숫자
		// 0100-9999 랜덤
		
		//앞 두자리 숫자 세팅.
		String frontNum = Integer.toString((int)(Math.random()*699+1));

		String backNum = String.format("%04d", (int)(Math.random()*9900+100));
		
		//앞의 번호가 1자리 숫자일때 앞에 0추가해주기.
		if(frontNum.length()==1)
			frontNum = String.format("%02d", Integer.parseInt(frontNum));
		
		// 차량번호 중간 문자 세팅
		char midChar = charArr[(int)(Math.random()*charArr.length)];
		
		// 차종 확인 메서드
		checkType(Integer.parseInt(frontNum), midChar);
		
		//생성된 최종 차량번호.
		StringBuilder finalCarNum = new StringBuilder();
		finalCarNum.append(frontNum);
		finalCarNum.append(midChar);
		finalCarNum.append(backNum);
		
		this.carNumber = finalCarNum.toString();
		
		String types = this.carType + "/" + this.useType;
	
		// Map에 생성된 차량번호 세팅.
		carGroup.put(this.carNumber, types);
		
		//원하는 차량댓수까지 계속 돌리기.
		while(carGroup.size() < count) {
			createRanNumber();
		}

	}
	
	//차량 타입 세팅.
	public void checkType(int chkNumber, char midChar) {
		// # 차종기호 
		//01-69 일반승용차
		//70-79 승합차
		//80-97 화물차
		//98,99 특수차
		//100-699  일반승용차
		
		// # 용도기호는 한글 한 글자로, 다음과 같이 자동차의 사용 목적에 따라 구분된다.
		
		//차종기호
		if( (chkNumber >= 1 && chkNumber <= 69) || chkNumber >=100 && chkNumber <= 699) {
			this.carType = "일반승용차";
		}else if(chkNumber >= 70 && chkNumber <= 79 ) {
			this.carType = "승합차";
		}else if(chkNumber >= 80 && chkNumber <= 97 ) {
			this.carType = "화물차";
		}else
			this.carType = "특수차";
		
		//용도기호
		switch (midChar) {
		case '배':
			this.useType = "택배운송용";
			break;
		case '허' :
		case '하' :
		case '호' :
			this.useType = "렌트카";
			break;
		case '공' : 
			this.useType = "공군용";
			break;
		case '해' : 
			this.useType ="해군용";
			break;
		case '육' : 
			this.useType = "육군용";
			break;
		case '합' : 
			this.useType = "합동참모부용";
			break;
		case '국' : 
			this.useType = "국직부대";
			break;
		default:
			this.useType = "자가용";
			break;
		}			
	}
	
	@Override
	public String toString() {
		return "Car [carNumber=" + carNumber + ", carType=" + carType + "]";
	}
}
