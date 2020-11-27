package swing.oop;

import javax.swing.JButton;

import swing.KakaoButton;

public class Main {
	public static void main(String[] args) {

		JButton j = new JButton();
		JButton j2 = new KakaoButton(null);
		j.setText("abc");
		j.setText("acb");
		
		//Apple a = new RottenApple();
		System.out.println(j);
	}
}
