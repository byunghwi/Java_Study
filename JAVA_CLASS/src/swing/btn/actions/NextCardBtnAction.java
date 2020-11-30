package swing.btn.actions;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NextCardBtnAction implements ActionListener{
	Container cardPanel;
	
	public NextCardBtnAction(Container cardPanel) {
		this.cardPanel = cardPanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		((CardLayout) cardPanel.getLayout()).next(cardPanel);
	}
}
