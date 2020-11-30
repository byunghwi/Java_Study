package swing;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class S05_JPanel extends JFrame {
	/**
	 * 
	 */
	//
	private static final long serialVersionUID = 1L;
	
	ArrayList<JButton> btns = new ArrayList<JButton>(25);
	JPanel center_panel = new JPanel(new CardLayout(0, 0));
	
	{
		for (int i = 1; i <= 25; i++) {
			btns.add(new JButton("button" + i));
		}

	}
	
	public JButton buttonAttr(String attr) {
		JButton btn = new JButton(attr);
		btn.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				if(attr.equals("next")) {
					((CardLayout)center_panel.getLayout()).next(center_panel);
				}else if(attr.equals("first")) {
					((CardLayout)center_panel.getLayout()).first(center_panel);
				}else if(attr.equals("previous")) {
					((CardLayout)center_panel.getLayout()).previous(center_panel);
				}else if(attr.equals("last"))
					((CardLayout)center_panel.getLayout()).last(center_panel);	
			}
		});

		return btn;
	}

	public S05_JPanel() {
		SwingTools.initTestFrame(this); //this는 JFrame이다.

//		# JPanel
//		 - 프레임 위에 추가로 붙일 수 있는 컨테이너
//		 - 컨테이너 역할을 하는 컴포넌트
		
		JPanel south_panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 10));
		south_panel.setVisible(true);
		// Q1. center_panel에 이미지를 몇 장 더 추가 하라.
		// Q2. south_panel에 first, last, prev 버튼을 추가하라.
		
		
		this.setLayout(new BorderLayout());
		this.add(center_panel, BorderLayout.CENTER);
		this.add(south_panel, BorderLayout.SOUTH);
		
		// south_panel은 flowlayout
		south_panel.add(buttonAttr("first"));
		south_panel.add(buttonAttr("next"));
		south_panel.add(buttonAttr("previous"));
		south_panel.add(buttonAttr("last"));
		
		//center_panel은 cardLayout
		try {
			
			center_panel.add("apple", new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\gpdld\\Downloads\\apple.png")).getScaledInstance(220, 220, Image.SCALE_SMOOTH))));
			center_panel.add("banana", new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\gpdld\\Downloads\\banana.jpg")).getScaledInstance(220, 220, Image.SCALE_SMOOTH))));
			center_panel.add("kiwi", new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\gpdld\\Downloads\\kiwi.jpg")).getScaledInstance(220, 220, Image.SCALE_SMOOTH))));
			center_panel.add("grape", new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\gpdld\\Downloads\\grape.jpg")).getScaledInstance(220, 220, Image.SCALE_SMOOTH))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new S05_JPanel();
	}
}
