package swing;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class KakaoButton extends JButton {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	final static int image_cols = 6;
	final static int image_rows = 2;

	static BufferedImage source;
	static HashMap<KakaoBtnEnum, Image> images;
	
	final static int SOURCE_IMAGE_COLS = 6;
	final static int SOURCE_IMAGE_ROWS = 2;
	
	static int SOURCE_IMAGE_WIDTH;
	static int SOURCE_IMAGE_HEIGHT;
	
	static {
		
		images = new HashMap<KakaoBtnEnum, Image>();
		
		try {
			source = ImageIO.read(new File("C:\\Users\\gpdld\\Downloads\\KakaoTalk_20201127_104534735.png"));
			
			KakaoBtnEnum[] enums = KakaoBtnEnum.values();
			
			SOURCE_IMAGE_WIDTH = source.getWidth() / SOURCE_IMAGE_COLS;
			SOURCE_IMAGE_HEIGHT = source.getHeight() / SOURCE_IMAGE_ROWS;
			
			int i = 0;
			
			for (int row = 0; row < image_rows; row++) {
				for (int col = 0; col < image_cols; col++) {
					images.put( enums[i++], source.getSubimage(col * SOURCE_IMAGE_WIDTH , row * SOURCE_IMAGE_HEIGHT, SOURCE_IMAGE_WIDTH , SOURCE_IMAGE_HEIGHT));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	KakaoBtnEnum type;
	
	//KakaoButton의 생성자가 실행되고 나면
	//JButton 인스턴스를 포함하고 있는 KakaoButton 인스턴스가 생성된다.
	public KakaoButton(KakaoBtnEnum type) {
		this.type = type;
		setSize(100);
	}
	
	public void setSize(int size) {
		super.setSize(size, size);
		
		//Enum에 설정된 타입에 따라 이미지를 고르고 사이즈를 재설정하여 아이콘으로 설정
		super.setIcon(new ImageIcon(images.get(type).getScaledInstance(size, size, Image.SCALE_FAST)));
	}
}
