package quiz;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;


public class S02_ImageButtonQuiz2 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static ArrayList<JButton> arrJbtn;
	public static final int cut = 29;
	
	public S02_ImageButtonQuiz2() {
		try {
			arrJbtn = new ArrayList<JButton>();
			BufferedImage source = ImageIO.read(new File("C:\\Users\\gpdld\\Downloads\\sero.png"));
			
			int img_width = source.getWidth(); 		//이미지 가로너비
			int img_height = source.getHeight();	//이미지 세로길이
			
			int widtyByOne = img_width;	 // 문양 하나당 가로너비
			int heigthByOne = img_width; // 문양 하나당 세로너비
			
			//문양 총 갯수
			int pattern_ct = (int) img_height / img_width;

			int count = 1;
			//총 갯수/30 회 만큼 돌리기. 1회당 15개씩 찍는다.
			Loop1 :
			for(int j = 0; j <= (int)((double)Math.ceil(pattern_ct/cut)); j++) {			
				//30개씩 끊어서 보여주기.
				for (int i = 0; i < cut; i++) {
					if(count == pattern_ct)
						break Loop1;
					
					JButton btn = new JButton();
					
					btn.setSize(widtyByOne, heigthByOne);
					btn.setLocation(i * widtyByOne, j * heigthByOne);
					btn.setIcon(new ImageIcon(source.getSubimage(0, (count++) * heigthByOne, widtyByOne, heigthByOne )));
					arrJbtn.add(btn);
				}
			}
			
			for (JButton btn2 : arrJbtn) {
                add(btn2);
			}
			
			 setLayout(null);
             setDefaultCloseOperation(EXIT_ON_CLOSE);
             setLocation(500, 100);
             setSize(widtyByOne*(cut+1), heigthByOne * ((int)((double)Math.ceil(pattern_ct/cut))+2));
             setVisible(true);   
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new S02_ImageButtonQuiz2();
	}
}