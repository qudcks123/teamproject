package event;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LabelChangeEx extends JFrame{
	private JLabel label;
	private JButton b1, b2;
	
	public LabelChangeEx() {
		setTitle("Label Change Practice");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setBackground(Color.ORANGE);
		c.setLayout(new FlowLayout());
		
		b1 = new JButton("프로그래밍방법론");
		b2 = new JButton("컴퓨터구조");
		label = new JLabel("버튼을 눌러보세요");
		
		b1.addActionListener(new MyButtonActionListener());
		b2.addActionListener(new MyButtonActionListener());
		
		c.add(b1);
		c.add(b2);
		c.add(label);
		
		setSize(300,150);
		setVisible(true);
	}
	private class MyButtonActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			label.setText(e.getActionCommand());
		}
	}
	public static void main(String[] arge) {
		new LabelChangeEx();
	}
}
