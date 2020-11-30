package swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class S03_JLabel extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 연습문제 : 버튼을 하나 추가하고, 그 버튼을 누르면 사과 그림이 바나나로 변하도록 만드시오. (다시 누르면 다시 사과가 돼야 함.)
	static Image image01, image02; 
	static HashMap<Integer, Image> arrListImg;
	static JButton button;
	static JLabel label01, label02;
	static int num = 0;

	static {
		try {
			arrListImg = new HashMap<Integer, Image>();
			image01 = ImageIO.read(new File("C:\\Users\\gpdld\\Downloads\\apple.png")).getScaledInstance(200, 200, Image.SCALE_SMOOTH);
			image02 =  ImageIO.read(new File("C:\\Users\\gpdld\\Downloads\\banana.jpg")).getScaledInstance(200, 200, Image.SCALE_SMOOTH);
			System.out.println(image01.getSource());
			System.out.println(image02.getSource());
			
			arrListImg.put(0, image01);
			arrListImg.put(1, image02);
			
			button = new JButton();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	public S03_JLabel() throws IOException {

		label01 = new JLabel("Hello java Gui!!");
		label01.setBounds(100, 50, 400, 50);
		label01.setFont(new Font("Courier", Font.PLAIN, 15));
		add(label01);
		

		label02 = new JLabel(new ImageIcon(arrListImg.get(num)));
		label02.setBounds(50, 100, 200, 200);
		add(label02);
		
		button.setSize(100,30);
		button.setLocation(350, 350);
		button.setText("이미지 변경");
		add(button);
		button.addActionListener(this);
		
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,500);
		setLocation(200, 300);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button) {
			num = (num==0)?1:0;
			label02.setIcon(new ImageIcon(arrListImg.get(num)));
			this.getContentPane().setBackground(Color.PINK);
		}
	}
	public static void main(String[] args) throws IOException {
		new S03_JLabel();
	}
}
