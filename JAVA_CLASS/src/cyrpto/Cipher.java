package cyrpto;

//# 추상클래스 : 클래스 내부에 추상메서드를 지닌 클래스
public abstract class Cipher {
	
//	# 추상메서드
//	함수의 형태만 정해놓고 자식클래스에서 오버라이드를 구현하게 만든다
//	자식 클래스에서 오버라이드 하지 않으면 컴파일 에러가 발생한다.
//	자식 클래스에 같은 형태의 해당 메서드가 100% 존재하는 것을 보장한다.
//  업캐스팅 했을 때 자식 클래스에서 구현된 코드를 사용하게 된다
	
	//자식클래스의 형태를 미리 결정.
	//자식클래스들이 메서드를 오버라이드하여 사용하게 만든다.
	abstract public String encryption(String plain); 
	
	abstract public String decryption(String crypto);
}
