package swing;

import javax.swing.JButton;
import javax.swing.JFrame;

public class S01_Tutorial {
	public static void main(String[] args) {
		
		// # Swing
		// - JAVA로 윈도우 프로그램을 만들 수 있는 API

		// # 컨테이너
		// - 컴포넌트를 추가하는 판
		// - JFrame, JPanel, JDialog ..
		
		// # 컴포넌트
		// - 컨테이너에 추가하는 부품들
		// - JButton, JTable, JSlider, JMenu ..

		JFrame frame = new JFrame("새로운 창");
		
		JButton button = new KakaoButton(KakaoBtnEnum.CAMERA, 100);
		
		// Jbutton에는 setSize(int, int) 밖에 없어서 JButton을 상속받은 자식 클래스에서 setSize(int) 를 추가하더라도 업캐스팅해서 사용하면 쓸 수 없게 된다.
		//button.setSize(100);
		
		button.setLocation(150, 300);
		frame.add(button);

		// frame에 기본적으로 설정되어있던 레이아웃을 제거한다.
		frame.setLayout(null);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,500);
		frame.setVisible(true);
	}
}
