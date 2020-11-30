package swing;

import javax.swing.JFrame;

public class SwingTools {
	public static void initTestFrame(JFrame frame) {
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,300);
		frame.setLocation(200, 300);
		frame.setVisible(true);
	}
}
