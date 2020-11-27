package swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.net.URL;
import java.awt.event.ActionEvent;

public class S02_JButton {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					S02_JButton window = new S02_JButton();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public S02_JButton() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 496, 478);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		URL searchURL;
		ImageIcon imageicon;

		searchURL = getClass().getResource("/img/2019ss3_shop1_135640.jpg");

		imageicon = new ImageIcon(searchURL);

		JButton btnNewButton= new JButton(imageicon);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		frame.getContentPane().add(btnNewButton, BorderLayout.SOUTH);
	}

}
