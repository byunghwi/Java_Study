package quiz;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class S02_ImageButtonQuiz2 extends JFrame {

	BufferedImage source;

	JButton[][] btns;
	private static int btn_width;
	private static int btn_height;

	public S02_ImageButtonQuiz2() {

		btns = new JButton[2][6];

// JButton test = new JButton();

		try {
			source = ImageIO.read(new File("D:\\자바SW개발자 양성과정 10월 권혁준\\assets\\image\\kakao1.png"));

			System.out.println("너비: " + source.getWidth());
			System.out.println("높이: " + source.getHeight());

			System.out.println("한칸너비: " + source.getWidth() / 6);
			System.out.println("한칸높이: " + source.getHeight() / 2);

			btn_width = source.getWidth() / 6;
			btn_height = source.getHeight() / 2;

// test.setSize(btn_width, btn_height);
// test.setIcon(new ImageIcon(source.getSubimage(0, 0, btn_width, btn_height)));

			for (int i = 0; i < btns.length; ++i) {

				for (int j = 0; j < btns[i].length; ++j) {
					btns[i][j] = new JButton();
					btns[i][j].setSize(btn_width, btn_height);
					btns[i][j].setLocation(j * btn_width, i * btn_height);
					btns[i][j].setIcon(
							new ImageIcon(source.getSubimage(j * btn_width, i * btn_height, btn_width, btn_height)));
					add(btns[i][j]);
				}

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

// add(test);

		setLayout(null);
		setLocation(2000, 100);
		setSize(1500, 1000);
		setVisible(true);
// System.exit(0);
	}

// kakao1.png를 이용해 12개의 버튼을 생성해보세요

	public static void main(String[] args) {
		new S02_ImageButtonQuiz();
	}

}