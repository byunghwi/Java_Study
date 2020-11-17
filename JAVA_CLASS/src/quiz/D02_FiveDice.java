package quiz;

import java.util.List;

public class D02_FiveDice {

	//랜덤으로 5개의 주사위를 굴린 다음에 (주사위의 눈은 1~6)
	//풀하우스 (같은 숫자가 2개/3개)
	//스몰스트레이트 (1234/2345/3456)
	//라지스트레이트 (12345/23456)
	//4다이스 (같은 숫자 4개)
	//5다이스 (같은 숫자 5개)
	//를 구분하는 클래스를 작성하고 테스트 해보세요
	//*다른 파일에 작성하고 여기서는 갖다 쓰기만 할 것.
	public static void main(String[] args) {
		FiveDice fd = new FiveDice();
		for (int i = 0; i < 100; i++) {
			fd.roll();
		}
	}
}
