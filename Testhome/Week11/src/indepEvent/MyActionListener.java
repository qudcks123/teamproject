package indepEvent;

import java.awt.event.*;
import javax.swing.*;

public class MyActionListener implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton)e.getSource();
		if(b.getText().equals("방학 시작")) {
			b.setText("기말고사");
		} else {
			b.setText("방학 시작");
		}
	}
}
