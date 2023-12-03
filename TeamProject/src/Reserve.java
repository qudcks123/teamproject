import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Reserve extends JFrame {
	protected static String Emailcombo;
	static int ReserveNumber = 0;
	private String[] ecombo = {"","@gmail.com", "@naver.com", "@daum.net", "@seoultech.ac.kr", "(직접 입력)"};
    private JTextField name;
    private JTextField birth;
    private JTextField phone;
    private JTextField emailtext;
    private JComboBox<String> emailcombo = new JComboBox<>(ecombo);
    

    public Reserve() {
    	 
    	Font font = new Font("고딕체", Font.BOLD, 13);
    	JLabel Logo = new JLabel(new ImageIcon("images/예약로고.png"));
        Logo.setBounds(0,0,595,419);
        
    	Container c = getContentPane();
        setTitle("예매자 정보");
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 이거 있으면 아예 프로그램 종료
        c.setBackground(new Color(248,246,233));
        setLayout(null);

        JLabel nameLabel = new JLabel("예매자 이름");
        nameLabel.setBounds(100, 60, 100, 30);
        nameLabel.setFont(font);
        nameLabel.setForeground(new Color(051,051,102));
        name = new JTextField(8);
        name.setBounds(400, 60, 80, 30);
        name.setHorizontalAlignment(JTextField.CENTER);

        JLabel birthLabel = new JLabel("생년월일(8자리)");
        birthLabel.setBounds(100, 120, 100, 30);
        birthLabel.setFont(font);
        birthLabel.setForeground(new Color(051,051,102));
        birth = new JTextField(10);
        birth.setBounds(390, 120, 100, 30);
        birth.setHorizontalAlignment(JTextField.CENTER);

        JLabel phoneLabel = new JLabel("휴대번호(-제외)");
        phoneLabel.setBounds(100, 180, 100, 30);
        phoneLabel.setFont(font);
        phoneLabel.setForeground(new Color(051,051,102));
        phone = new JTextField(30);
        phone.setBounds(385, 180, 120, 30);
        phone.setHorizontalAlignment(JTextField.CENTER);

        JLabel emailLabel = new JLabel("이메일 주소");
        emailLabel.setBounds(100, 240, 100, 30);
        emailLabel.setFont(font);
        emailLabel.setForeground(new Color(051,051,102));
        emailtext = new JTextField(15);
        emailtext.setBounds(320,240,120,30);
        emailtext.setHorizontalAlignment(JTextField.CENTER);
        emailcombo.setBounds(440, 240, 140, 30);

        JButton b = new JButton("확인");
        b.setBounds(80, 300, 100, 30);
        b.setFont(font);
        b.setForeground(new Color(051,051,102));
        
        JButton bb = new JButton("초기화");
        bb.setBounds(420, 300, 100 , 30);
        bb.setForeground(new Color(051,051,102));

     bb.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
             dispose();
             new Reserve();
         }
     });

        add(nameLabel);
        add(name);
        add(birthLabel);
        add(birth);
        add(phoneLabel);
        add(phone);
        add(emailLabel);
        add(emailtext);
        add(emailcombo);
        add(Logo);
        add(b);
        add(bb);
        
        setSize(600, 400);
        setVisible(true);
        setLocationRelativeTo(null);
        
        
        emailcombo.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String selectedEmail = (String) emailcombo.getSelectedItem();
                    if (selectedEmail.equals("(직접 입력)")) {
                        JTextField emailField = new JTextField(15);
                        emailField.setBounds(440, 240, 120, 30);
                        emailField.setHorizontalAlignment(JTextField.CENTER);

                        getContentPane().remove(emailcombo);
                        getContentPane().add(emailField);
                        
                        emailField.addFocusListener(new FocusAdapter() {
                            public void focusLost(FocusEvent e) {
                                Emailcombo = emailField.getText(); 
                            }
                        });

                        repaint();
                        revalidate();
                    }
                    else {
                    	Emailcombo = selectedEmail;
                    }
                }
            }
        });
        

        b.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent e) {
            	Font font = new Font("고딕체", Font.BOLD, 12);
            	String Name = name.getText();
                String Birth = birth.getText();
                String Phone = phone.getText();
                String Email = emailtext.getText();
                int fail = 0;
               
                
                if(Name.isEmpty() || Birth.isEmpty() || Phone.isEmpty()|| Email.isEmpty()|| Emailcombo.isEmpty()) {
                	new ErrorMessage("모든 항목을 입력하세요.");
                	fail++;
                } else if (Emailcombo.contains("@")== false){
                	new ErrorMessage("올바른 이메일 형식이 아닙니다.");
                }
                else{
                
               try {
               int BirthNum = Integer.valueOf(Birth);
               int BirthYear = BirthNum / 10000;
               int BirthMonth = (BirthNum % 10000) / 100;
               int BirthDay = (BirthNum % 10000) % 100;   
               if((BirthYear < 1000 || BirthYear >= 10000)) {
            	   new ErrorMessage("생년월일 8자리를 입력해주세요.");
            	   fail++;
            	   return;
               }
            	   switch(BirthMonth) {
            	   case 1:
            		   if(BirthYear > 2023)
                       {
                    	   new ErrorMessage("아직 안 태어나셨습니다.");
                    	   fail++;
                       }
            		   else if((BirthDay > 31) || (BirthDay < 0)) {
            		   new ErrorMessage("1월은 31일까지입니다.");
            		   fail++;
            	   }
            		   break;
            	   case 2:
            		   if((BirthYear < 1900) || (BirthYear > 2023))
                       {
                    	   new ErrorMessage("출생년도를 다시 한 번 확인해주세요.");
                    	   fail++;
                       }
            		   else if(BirthYear % 4 ==0 ) {
            			   if((BirthDay > 29) || (BirthDay < 0)) {
            				   new ErrorMessage("윤년은 2월이 29일까지입니다.");
            				   fail++;
            			   }
            		   }
            		   else if((BirthDay > 28) || (BirthDay < 0)) {
            		   new ErrorMessage("2월은 28일까지입니다.");
            		   fail++;
            	   }
            		   break;
            	   case 3:
            		   if((BirthYear < 1900) || (BirthYear > 2023))
                       {
                    	   new ErrorMessage("출생년도를 다시 한 번 확인해주세요.");
                    	   fail++;
                       }
            		   else if((BirthDay > 31) || (BirthDay < 0)) {
            		   new ErrorMessage("3월은 31일까지입니다.");
            		   fail++;
            	   }
            		   break;
            	   case 4:
            		   if((BirthYear < 1900) || (BirthYear > 2023))
                       {
                    	   new ErrorMessage("출생년도를 다시 한 번 확인해주세요.");
                    	   fail++;
                       }
            		   else if((BirthDay > 30) || (BirthDay < 0)) {
            		   new ErrorMessage("4월은 30일까지입니다.");
            		   fail++;
            	   }
            		   break;
            	   case 5:
            		   if((BirthYear < 1900) || (BirthYear > 2023))
                       {
                    	   new ErrorMessage("출생년도를 다시 한 번 확인해주세요.");
                    	   fail++;
                       }
            		   else if((BirthDay > 31) || (BirthDay < 0)) {
            		   new ErrorMessage("5월은 31일까지입니다.");
            		   fail++;
            	   }
            		   break;
            	   case 6:
            		   if((BirthYear < 1900) || (BirthYear > 2023))
                       {
                    	   new ErrorMessage("출생년도를 다시 한 번 확인해주세요.");
                    	   fail++;
                       }
            		   else if((BirthDay > 30) || (BirthDay < 0)) {
            		   new ErrorMessage("6월은 30일까지입니다.");
            		   fail++;
            	   }
            		   break;
            	   case 7:
            		   if((BirthYear < 1900) || (BirthYear > 2023))
                       {
                    	   new ErrorMessage("출생년도를 다시 한 번 확인해주세요.");
                    	   fail++;
                       }
            		   else if((BirthDay > 31) || (BirthDay < 0)) {
            		   new ErrorMessage("7월은 31일까지입니다.");
            		   fail++;
            	   }
            		   break;
            	   case 8:
            		   if((BirthYear < 1900) || (BirthYear > 2023))
                       {
                    	   new ErrorMessage("출생년도를 다시 한 번 확인해주세요.");
                    	   fail++;
                       }
            		   else if((BirthDay > 31) || (BirthDay < 0)) {
            		   new ErrorMessage("8월은 31일까지입니다.");
            		   fail++;
            	   }
            		   break;
            	   case 9:
            		   if((BirthYear < 1900) || (BirthYear > 2023))
                       {
                    	   new ErrorMessage("출생년도를 다시 한 번 확인해주세요.");
                    	   fail++;
                       }
            	   else if((BirthDay > 30) || (BirthDay < 0)) {
            		   new ErrorMessage("9월은 30일까지입니다.");
            		   fail++;
            	   }
            		   break;
            	   case 10:
            		   if((BirthYear < 1900) || (BirthYear > 2023))
                       {
                    	   new ErrorMessage("출생년도를 다시 한 번 확인해주세요.");
                    	   fail++;
                       }
            		   else if((BirthDay > 31) || (BirthDay < 0)) {
            		   new ErrorMessage("10월은 31일까지입니다.");
            		   fail++;
            	   }
            		   break;
            	   case 11:
            		   if((BirthYear < 1900) || (BirthYear > 2023))
                       {
                    	   new ErrorMessage("출생년도를 다시 한 번 확인해주세요.");
                    	   fail++;
                       }
            		   else if((BirthDay > 30) || (BirthDay < 0)) {
            		   new ErrorMessage("11월은 30일까지입니다.");
            		   fail++;
            	   }
            		   break;
            	   case 12:
            		   if((BirthYear < 1900) || (BirthYear > 2023))
                       {
                    	   new ErrorMessage("출생년도를 다시 한 번 확인해주세요.");
                    	   fail++;
                       }
            		   else if(((BirthYear == 2023) && (BirthDay > 14)) && (BirthDay < 32)) {
            			   new ErrorMessage("그 날은 이미 종강입니다.");
            			   fail++;
            		   }
            		  else if((BirthDay > 31) || (BirthDay < 0)) {
            		   new ErrorMessage("12월은 31일까지입니다.");
            		   fail++;
            	   }
            		   break;
            		   default : new ErrorMessage("출생 월을 다시 한 번 확인해주세요");
            		   fail++;
            		   break;
               }
            	   
            	   long PhoneNum = Long.valueOf(Phone);
            	   if((PhoneNum/100000000 < 010) || (PhoneNum/100000000 > 100)) {           		
            		   new ErrorMessage("올바른 휴대번호 형식이 아닙니다.");
            		   return;
            	   }
               }catch (NumberFormatException ex) {                  
                   new ErrorMessage("생년월일과 휴대번호는 숫자로 입력해주세요.");
                   fail++;
                   
               }
                if(fail == 0) {
             	   JFrame frame = new JFrame();
                    frame.setTitle("예약 확인");
                    frame.setSize(350, 300);            
                    Container contentPane = frame.getContentPane();
                    contentPane.setBackground(new Color(248,246,233));
                    contentPane.setLayout(null);
                    frame.setForeground(Color.BLUE);


                    JLabel label1 = new JLabel("이름: " + Name);
                    label1.setBounds(60, 5, 80 ,30 );
                    label1.setFont(font);
                    label1.setForeground(new Color(051,051,102));
                    
                    JLabel label2 = new JLabel("생년월일: " + Birth);
                    label2.setBounds(60, 45, 120 ,30 );
                    label2.setFont(font);
                    label2.setForeground(new Color(051,051,102));
                    
                    JLabel label3 = new JLabel("휴대번호: " + Phone);
                    label3.setBounds(60, 85, 150 ,30 );
                    label3.setFont(font);
                    label3.setForeground(new Color(051,051,102));
                    
                    JLabel label4 = new JLabel("이메일: " + Email + Emailcombo);
                    label4.setBounds(60, 125, 220 ,30 );
                    label4.setFont(font);
                    label4.setForeground(new Color(051,051,102));
                    
                    JLabel label5 = new JLabel("입력하신 예매자 정보가 맞습니까?");
                    label5.setBounds(40, 165, 300 , 30 );
                    label5.setFont(new Font("궁서체",Font.PLAIN,15));
                    label5.setForeground(new Color(051,051,102));
                    
                    JButton jb = new JButton("Yes");
                    jb.setBounds(20,205,60,30);
                    jb.setFont(font);
                    jb.setForeground(new Color(000,000,255));
                                      
                    JButton jc = new JButton("No");
                    jc.setBounds(200,205,60,30);
                    jc.setFont(font);
                    jc.setForeground(new Color(255,000,000));
    
                    frame.setBackground(new Color(248,246,233));
                    frame.add(label1);
                    frame.add(label2);
                    frame.add(label3);
                    frame.add(label4);
                    frame.add(label5);
                    frame.add(jb);
                    frame.add(jc);
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                    jb.addActionListener(new ActionListener() {
        	            public void actionPerformed (ActionEvent e) {
        	            	frame.dispose();
        	            	ReserveNumber++;
        	            	new Complete("예약","예약이 완료되었습니다.", ReserveNumber);
        	            	//예매정보값 저장
        	            	
        	            }
        	            });
                    jc.addActionListener(new ActionListener() {
        	            public void actionPerformed (ActionEvent e) {	
        	            	frame.dispose();
        	            }
        	            });
                }
                }
            }
        });
    	}
    
    public static void main(String[] args) {
        new Reserve();
    }
}
