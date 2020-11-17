package myobj.machine;

public class Machine {

	public static void main(String[] args) {
		//	전자기기 인터페이스
		// 1. 모든 전자기기는 전력 공급을 받을 수 있다.
		// 2. 모든 전자기기는 콘솔에 한번 출력할때마다 전력 소비량 만큼의 전력을 소비한다.
		// 3. 모든 전자기기는 가지고 있는 동작을 콘솔에 출력한다
		
		CellPhone celphone = new CellPhone("cellphone");
		Radio radio = new Radio("radio");
		
		celphone.provideElec();
		radio.provideElec();
		System.out.println();
		
		celphone.sendText();
		celphone.call();
		System.out.println();
		
		radio.adjust();
		radio.playMusic();
		radio.playMusic();
		radio.playMusic();
		radio.playMusic();
		radio.playMusic();
		radio.playMusic();
		radio.playMusic();
		radio.playMusic();
		radio.playMusic();
		radio.playMusic();
		radio.playMusic();
		System.out.println();
		
		celphone.totalUseElec();
		radio.totalUseElec();
		


	}

}
