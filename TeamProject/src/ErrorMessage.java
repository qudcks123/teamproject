import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ErrorMessage extends JFrame{
	public ErrorMessage(String errormessage) {
			JFrame frame = new JFrame();
	        frame.setTitle("오류");
	        
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        Font mfont = new Font ("고딕체", Font.BOLD, 13);
	        Font font = new Font("고딕체", Font.BOLD, 10);
	        Container c = frame.getContentPane();
	        c.setLayout(null);
	        
	        JLabel warningsign = new JLabel(new ImageIcon("images/warningsign.png"));
	        warningsign.setBounds(40,10,43,41);
	        JLabel message = new JLabel(errormessage);
	        message.setHorizontalAlignment(SwingConstants.CENTER);
	        message.setBounds(65,12,350,40);
	        message.setFont(mfont);
	        JButton button = new JButton("확인");
	        button.setBounds(150, 60, 100, 30);
	        button.setFont(font);
	        button.addActionListener(new ActionListener() {
	            public void actionPerformed (ActionEvent e) {
	            	frame.dispose();
	            }
	            });
	        frame.add(warningsign);
	        frame.add(message);
	        frame.add(button);
	        frame.setLocationRelativeTo(null);
	        frame.setSize(420, 130);
			frame.setVisible(true);
		}
	/*public static void main(String[] args) {
    new ErrorMessage("ErrorMessage 시뮬레이션");
   
} */ //Complete 시뮬

}

