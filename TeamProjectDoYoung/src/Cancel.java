import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Cancel extends JFrame{
	public Cancel() {
			JFrame frame = new JFrame();
	        frame.setTitle("예약 취소");
	       
	        Font mfont = new Font ("고딕체", Font.BOLD, 13);
	        Font font = new Font("고딕체", Font.BOLD, 10);
	        Container c = frame.getContentPane();
	        c.setLayout(null);
	        
	        JLabel warningsign = new JLabel(new ImageIcon("images/cautionsign.png"));
	        warningsign.setBounds(40,20,43,41);
	        JLabel message = new JLabel("취소할 예약번호를 입력해주세요");
	        
	        message.setHorizontalAlignment(SwingConstants.CENTER);
	        message.setBounds(65,12,300,40);
	        message.setFont(mfont);
	        
	   JTextField canceltext = new JTextField(15);
	   canceltext.setBounds(180,50,60,20);
	   canceltext.setFont(mfont);
	   canceltext.setHorizontalAlignment(JTextField.CENTER);
	        JButton button = new JButton("확인");
	        button.setBounds(150, 80, 100, 30);
	        button.setFont(font);
	        button.addActionListener(new ActionListener() {
	            public void actionPerformed (ActionEvent e) {
	            	String CancelNum = canceltext.getText();
	           int CancelNumber = Integer.valueOf(CancelNum);
	           if(CancelNumber == Reserve.ReserveNumber) {
	           	//예매정보 취소
	           }
	            	frame.dispose();
	            	new Complete("취소","취소가 완료되었습니다",CancelNumber);
	            }
	            });
	        frame.add(warningsign);
	        frame.add(message);
	        frame.add(canceltext);
	        frame.add(button);
	        frame.setLocation(430,300);
	        frame.setSize(420, 150);
			frame.setVisible(true);
		}
	 public static void main(String[] args) {
	    	new Cancel();
	    }
    } 

 








