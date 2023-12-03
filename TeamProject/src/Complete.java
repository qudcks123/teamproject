import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Complete extends JFrame{
	public Complete(String title, String completemessage, int ReserveNumber) {
	
			JFrame frame = new JFrame();
	        frame.setTitle(title + "성공");
	        
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        Font mfont = new Font ("고딕체", Font.BOLD, 13);
	        Font font = new Font("고딕체", Font.BOLD, 10);
	        Container c = frame.getContentPane();
	        c.setLayout(null);
	        
	        JLabel warningsign = new JLabel(new ImageIcon("images/completesign.png"));
	        warningsign.setBounds(40,10,43,41);
	        JLabel message = new JLabel(completemessage);
	        
	        message.setHorizontalAlignment(SwingConstants.CENTER);
	        message.setBounds(65,12,300,40);
	        message.setFont(mfont);
	        
	   JLabel ReserveNum = new JLabel(title +"된 번호는 " + ReserveNumber + "번 입니다.");
	   ReserveNum.setHorizontalAlignment(SwingConstants.CENTER);
	   ReserveNum.setBounds(65,35,300,40);
	   ReserveNum.setFont(mfont);
	        JButton button = new JButton("확인");
	        button.setBounds(150, 80, 100, 30);
	        button.setFont(font);
	        button.addActionListener(new ActionListener() {
	            public void actionPerformed (ActionEvent e) {
	            	frame.dispose();
	            }
	            });
	        frame.add(warningsign);
	        frame.add(message);
	        frame.add(ReserveNum);
	        frame.add(button);
	        frame.setLocationRelativeTo(null);
	        frame.setSize(420, 150);
			frame.setVisible(true);
		}
	/*public static void main(String[] args) {
    new Complete("시뮬", "시뮬레이션 성공", 0);
   
}  //Complete 시뮬 */
}



