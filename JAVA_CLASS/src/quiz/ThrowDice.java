package quiz;

import java.util.List;

public interface ThrowDice {
	//랜덤으로 5개의 주사위를 굴린 다음에 (주사위의 눈은 1~6)
	//풀하우스 (같은 숫자가 2개/3개)
	//스몰스트레이트 (1234/2345/3456)
	//라지스트레이트 (12345/23456)
	//4다이스 (같은 숫자 4개)
	//5다이스 (같은 숫자 5개)
	
	abstract List<Integer> throwDice();
}
