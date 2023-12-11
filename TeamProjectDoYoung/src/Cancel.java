import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;
import java.io.*;

public class Cancel extends JFrame implements Serializable{
	public Cancel() {
		ArrayList<Store> seat_re = Info.Information("seat");
		ArrayList<Store> Seat1_re = Info.Information("InformSeat1");
		//ArrayList<Store> info_re = Info.PrintInfo("Reserve");
			JFrame frame = new JFrame();
	        frame.setTitle("예약 취소");
	       
	        Font mfont = new Font ("고딕체", Font.BOLD, 25);
	        Font font = new Font("고딕체", Font.BOLD, 22);
	        Container c = frame.getContentPane();
	        c.setLayout(null);
	        
	        JLabel warningsign = new JLabel(new ImageIcon("images/Cancel.png"));
	        warningsign.setBounds(20,20,100,100);
	        
	        JLabel message = new JLabel("취소할 예약번호를 입력해주세요.");	        
	        message.setHorizontalAlignment(SwingConstants.CENTER);
	        message.setBounds(95,35,500,40);
	        message.setFont(mfont);
	        
	   JTextField canceltext = new JTextField(15);
	   canceltext.setBounds(280,80,100,30);
	   canceltext.setFont(mfont);
	   canceltext.setHorizontalAlignment(JTextField.CENTER);
	        JButton button = new JButton("확인");
	        button.setBounds(280, 120, 100, 30);
	        button.setFont(font);
	        button.addActionListener(new ActionListener() {
	            public void actionPerformed (ActionEvent e) {
	            	try {
	            		String CancelNum = canceltext.getText();
	            		boolean found = false;
	            	int CancelNumber = Integer.valueOf(CancelNum);
	            	int CancelArea = 0;
	            	ArrayList<Integer> CancelSeat = new ArrayList<Integer>();
	            	           		            	 	            			            	
	            	 for(int i = 0 ; i <seat_re.size(); i++) {	            		 
		      	           if(CancelNumber == seat_re.get(i).ReNum) {
		      	        	   found = true;	      	        	         	        	 
		      	        	 break;	      	        	 	      	        	     	        	 
		      	           }	      	           
		            	 }
		            	 if(found) {
		            		 for(int j = 0; j< Seat1_re.size(); j++) {
		 	            		if(CancelNumber == Seat1_re.get(j).ReNum) {
		 	            			CancelArea = Seat1_re.get(j).Areanum;
		 	            			CancelSeat.add(Seat1_re.get(j).seatnum);
		 	            		}
		            		 }
		         new Complete("취소","취소가 완료되었습니다",CancelNumber,CancelArea,CancelSeat,Seat1_re);	      	        	   
	      	        	  seat_re.removeIf(info -> info.ReNum == CancelNumber);      	        	       	        	 
	      	        	  Seat1_re.removeIf(info -> info.ReNum == CancelNumber);
	            	 Info.Information(seat_re,"seat");
	            	 Info.Information(Seat1_re,"InformSeat1");
	            	 frame.dispose();
	            	 found = false;
	            	 }
	            	 else {
	            		 new ErrorMessage("해당 예약번호가 존재하지 않습니다.");     	            	
	            	 }
	            	} 
	            	catch(NumberFormatException NumError){
	            		new ErrorMessage("숫자를 입력해주세요.");
	            	}	            	
	            } 
	            });//예매정보 취소
	        frame.add(warningsign);
	        frame.add(message);
	        frame.add(canceltext);
	        frame.add(button);	        
	        frame.setSize(600, 200);
	        frame.setLocationRelativeTo(null);
			frame.setVisible(true);
		}
    } 

 








