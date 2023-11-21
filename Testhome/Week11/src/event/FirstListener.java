package event;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FirstListener extends JFrame{

	public FirstListener() {
		setTitle("First Event Listener");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setBackground(Color.CYAN);
		c.setLayout(new FlowLayout());
		
		JButton btn = new JButton("수업 시작");
		btn.setBackground(Color.RED);
		btn.setForeground(Color.WHITE);
		btn.addActionListener(new MyActionListener());
		
		c.add(btn);
		
		setSize(350,150);
		setVisible(true);
		}
	
	private class MyActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();
			if(b.getText().equals("수업 시작")) {
				b.setText("수업 끝");
			} else {
				b.setText("수업 시작");
			}
			FirstListener.this.setTitle(b.getText());
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
new FirstListener();
	}

}
