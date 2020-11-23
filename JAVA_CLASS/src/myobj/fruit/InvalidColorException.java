package myobj.fruit;


// RuntimeException을 상속받은 객체는 반드시 처리하지 않아도 되는 예외 객체가 된다
public class InvalidColorException extends RuntimeException {
	public InvalidColorException() {
		super("이상한 색깔 예외");
		
		// throw는 가능하지만, 반드시 처리하라고 빨간줄은 뜨지 않음
	}
}
