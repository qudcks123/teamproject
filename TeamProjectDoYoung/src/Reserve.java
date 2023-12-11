import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.io.*;

public class Reserve extends JFrame implements Serializable{
	static String Emailcombo;
	private String[] ecombo = {"","@gmail.com", "@naver.com", "@daum.net", "@seoultech.ac.kr", "(직접 입력)"};
	//이메일 서버주소를 고를 수 있는 콤보박스 생성
    private JTextField name;
    private JTextField birth;
    private JTextField phone;
    private JTextField emailtext; //정보를 입력할 수 있는 텍스트필드 생성
    private JComboBox<String> emailcombo = new JComboBox<>(ecombo); //콤보박스에서 고른 서버를 문자열로 변경
    //예매자 정보를 저장할 수 있는 ArrayList 생성
    static ArrayList<Integer> s = new ArrayList<Integer>();
    static ArrayList<Store> r = Info.Information("seat");
    static ArrayList<Store> d = Info.Information("InformSeat1");
    static int ReserveNumber = 0;
    
    public Reserve() {
    	
    	if (!r.isEmpty()) {
    		if(!(r.get(r.size()-1).ReNum == 0))
            	ReserveNumber = r.get(r.size()-1).ReNum;
    	}
    	Font font = new Font("고딕체", Font.BOLD, 28); //기본글꼴생성
    	JLabel Logo = new JLabel(new ImageIcon("images/예약로고.png"));
        Logo.setBounds(0,0,595,419); //로고배치
        
    	Container c = getContentPane();
        setTitle("예매자 정보");
        c.setBackground(new Color(248,246,233));
        setLayout(null);

        JLabel nameLabel = new JLabel("예매자 이름");
        nameLabel.setBounds(10, 60, 200, 30);
        nameLabel.setForeground(new Color(051,051,102));
        nameLabel.setFont(font);
        name = new JTextField(8);
        name.setBounds(450, 60, 200, 50);
        name.setFont(font);
        name.setHorizontalAlignment(JTextField.CENTER); //이름 라벨 및 텍스트필드 배치

        JLabel birthLabel = new JLabel("생년월일(8자리)");
        birthLabel.setBounds(10, 120, 300, 30);
        birthLabel.setFont(font);
        birthLabel.setForeground(new Color(051,051,102)); //생년월일 라벨 및 텍스트필드 배치
        birth = new JTextField(10);
        birth.setFont(font);
        birth.setBounds(450, 120, 200, 50);
        birth.setHorizontalAlignment(JTextField.CENTER);

        JLabel phoneLabel = new JLabel("휴대번호(-제외)");
        phoneLabel.setBounds(10, 180, 300, 30);
        phoneLabel.setFont(font);
        phoneLabel.setForeground(new Color(051,051,102));
        phone = new JTextField(30);
        phone.setFont(font);
        phone.setBounds(400, 180, 250, 50);
        phone.setHorizontalAlignment(JTextField.CENTER);//휴대번호 라벨 및 텍스트필드 배치

        JLabel emailLabel = new JLabel("이메일 주소");
        emailLabel.setBounds(10, 240, 300, 30);
        emailLabel.setFont(font);
        emailLabel.setForeground(new Color(051,051,102));
        emailtext = new JTextField(15);
        emailtext.setBounds(180,240,200,50);
        emailtext.setFont(font);
        emailtext.setHorizontalAlignment(JTextField.CENTER);
        emailcombo.setBounds(380, 240, 300, 50);
        emailcombo.setFont(font);
        
        //메일주소 라벨 및 텍스트필드 배치
        
        JLabel AreaLabel = new JLabel("선택된 구역: ");
        AreaLabel.setBounds(10, 300, 300, 30);
        AreaLabel.setFont(font);
        AreaLabel.setForeground(new Color(051,051,102));
        
        JLabel AreaNum = new JLabel(Seat.Areanum + "구역");
        AreaNum.setBounds(190, 300, 100, 30);
        AreaNum.setFont(font);
        AreaNum.setForeground(new Color(051,051,102));
        
        JLabel SeatLabel = new JLabel("선택된 좌석: ");
        SeatLabel.setBounds(300,300,300,30);
        SeatLabel.setFont(font);
        SeatLabel.setForeground(new Color(051,051,102)); //메일주소 라벨 및 텍스트필드 배치
        
        for(int i = 0; i< Seat3.SeatNumArr.size();i++) {
            JLabel SeatNum = new JLabel(Integer.toString(Seat3.SeatNumArr.get(i)));
            SeatNum.setBounds(470+50*i, 300, 150, 30);
            SeatNum.setFont(font);
            SeatNum.setForeground(new Color(051,051,102));
            add(SeatNum);
            s.add(Seat3.SeatNumArr.get(i));
        }
        
       JButton b = new JButton("확인");
        b.setBounds(75, 350, 150, 50);
        b.setFont(font);
        b.setForeground(new Color(051,051,102)); //확인 버튼 배치
        
        JButton bb = new JButton("초기화");
        bb.setBounds(500, 350, 150 , 50);
        bb.setFont(font);
        bb.setForeground(new Color(051,051,102)); //초기화 버튼 배치

     bb.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
             dispose();
             new Reserve(); //초기화 버튼 누르면 기존 창닫고 새로운 Reserve 불러옴
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
        add(AreaLabel);
        add(AreaNum);
        add(SeatLabel);
        setSize(700, 450);
        setLocationRelativeTo(null);
        setVisible(true); //모든 Component 배치하고 띄우기
        
        
        emailcombo.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String selectedEmail = (String) emailcombo.getSelectedItem();
                    if (selectedEmail.equals("(직접 입력)")) {
                        JTextField emailField = new JTextField(15);
                        emailField.setBounds(380, 240, 300, 50);
                        emailField.setHorizontalAlignment(JTextField.CENTER);
                        emailField.setFont(font);
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
                    } //콤보박스 (직접 입력)을 선택했을 경우 텍스트 필드 형태로 변환하여 저장, 나머지는 선택된 거로 저장
                }
            }
        });
        

        b.addActionListener(new ActionListener() { //예매자 정보 확인 누르고 최종 확인 창 띄우기
            public void actionPerformed (ActionEvent e) {
            	String Name = name.getText();
                String Birth = birth.getText();
                String Phone = phone.getText();
                String Email = emailtext.getText();
                int fail = 0; //fail 변수가 그대로 0일 경우 예약 확인 메세지 띄우기
               
                try {
                if(Name.isEmpty() || Birth.isEmpty() || Phone.isEmpty()|| Email.isEmpty()|| Emailcombo.isEmpty()) {
                	new ErrorMessage("모든 항목을 입력하세요.");
                	fail++;
                }
                 else if (Emailcombo.contains("@")== false){
                	new ErrorMessage("올바른 이메일 형식이 아닙니다.");
                	fail++;
                }
                else{
                
               
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
            			   new ErrorMessage("이미 종강한 날입니다."); //이스터에그
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
                }
                }catch (NumberFormatException ex) {                  
                   new ErrorMessage("생년월일과 휴대번호는 숫자로 입력해주세요.");
                   fail++;
                   
               }                //생년월일과 휴대번호가 숫자가 아닐경우 오류메세지 출력
                for(int i = 0; i< r.size() ;i++) {
                	if(Phone.equals(r.get(i).tel)) {
                		new ErrorMessage("이미 등록되어 있는 정보입니다.");
                		fail++;
                		break;
                	}
                }
                
                if(fail == 0) { //fail 변수가 그대로 0일 경우 예약 최종 확인
             	   JFrame frame = new JFrame();
                    frame.setTitle("예약 확인");
                    frame.setSize(700, 350);
                    Font Ffont = new Font("고딕체", Font.BOLD, 25);
                    Container contentPane = frame.getContentPane();
                    contentPane.setBackground(new Color(248,246,233));
                    contentPane.setLayout(null);
                    frame.setForeground(Color.BLUE);


                    JLabel label1 = new JLabel("이름: " + Name);
                    label1.setBounds(60, 5, 350 ,50 );
                    label1.setFont(Ffont);
                    label1.setForeground(new Color(051,051,102));
                    
                    JLabel label2 = new JLabel("생년월일: " + Birth);
                    label2.setBounds(60, 45, 350 ,50 );
                    label2.setFont(Ffont);
                    label2.setForeground(new Color(051,051,102));
                    
                    JLabel label3 = new JLabel("휴대번호: " + Phone);
                    label3.setBounds(60, 85, 350 ,50 );
                    label3.setFont(Ffont);
                    label3.setForeground(new Color(051,051,102));
                    
                    JLabel label4 = new JLabel("이메일: " + Email + Emailcombo);
                    label4.setBounds(60, 125, 500 ,50 );
                    label4.setFont(Ffont);
                    label4.setForeground(new Color(051,051,102));
                    
                    JLabel label5 = new JLabel("입력하신 예매자 정보가 맞습니까?");
                    label5.setBounds(40, 180, 600 , 50 );
                    label5.setFont(new Font("궁서체",Font.PLAIN,35));
                    label5.setForeground(new Color(051,051,102));
                    
                    JButton jb = new JButton("Yes");
                    jb.setBounds(20,230,180,60);
                    jb.setFont(Ffont);
                    jb.setForeground(new Color(000,000,255));
                                      
                    JButton jc = new JButton("No");
                    jc.setBounds(500,230,180,60);
                    jc.setFont(Ffont);
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
        	            	
        	            	Store a = new Store(Name, Phone, Email ,Emailcombo, Birth, ReserveNumber);
        	            	for(int i = s.size()-1; i >= 0 ;i--) {	
        	            		r.add(a);
        	            	}
        	    			
        	    			Info.Information(r, "seat");
        	    			Info.Information(Seat3.s, "InformSeat1");
        	            	new Complete("예약","예약이 완료되었습니다.", ReserveNumber, Seat.Areanum,s,Seat3.s);
        	            	Seat3.SeatNumArr.clear();
        	            	s.clear();
        	            	//확인 버튼 누르면 예약성공 메세지 출력
        	            }
        	            });
                    jc.addActionListener(new ActionListener() {
        	            public void actionPerformed (ActionEvent e) {	       	            	
        	            	frame.dispose();
        	            }
        	            });
                }
                }
            
        });
    	}

  /*
    public static void main(String[] args) {
    	new Complete("시뮬","예약이 완료되었습니다",0,Seat3.SeatNumArr);
    }
    
    /*
    public static void main(String[] args) {
    	new Reserve();
    }
    */
} 

class Complete extends JFrame implements Serializable{
	public Complete(String title, String completemessage, int ReserveNumber, int selectedArea,ArrayList<Integer> selectedSeats,ArrayList<Store> StoreInfo) {
		
		int SeatPrice = 0;
			JFrame frame = new JFrame();
	        frame.setTitle(title + "성공");
	        
	        Font mfont = new Font ("고딕체", Font.BOLD, 25);
	        Font font = new Font("고딕체", Font.BOLD, 22);
	        Container c = frame.getContentPane();
	        c.setLayout(null);
	        
	        JLabel warningsign = new JLabel(new ImageIcon("images/completesign100.png"));
	        warningsign.setBounds(20,20,100,100);
	        
	        JLabel message = new JLabel(completemessage);	        
	        message.setHorizontalAlignment(SwingConstants.CENTER);
	        message.setBounds(143,30,500,40);
	        message.setFont(mfont);
	        
	   JLabel ReserveNum = new JLabel(title +"된 번호는 " + ReserveNumber + "번 입니다.");
	   //예약을 성공하면 예약번호 출력
	   ReserveNum.setHorizontalAlignment(SwingConstants.CENTER);
	   ReserveNum.setBounds(160,85,500,40);
	   ReserveNum.setFont(mfont);
	   int count = 0;
	   String type = "";
	   for(int i =0;i < StoreInfo.size();i++ ) {
		   if(ReserveNumber == StoreInfo.get(i).ReNum) {
			   type = StoreInfo.get(i).seattype;
			   count++;
		   }
	   }
	   		    if (type.equals("V")) {
		        SeatPrice = 500000* count;
		    } else if (type.equals("R")) {
		        SeatPrice = 400000 *count;
		    } else if (type.equals("S")) {
		        SeatPrice = 300000* count;
		    }
				  
	   
		   
	   
	   JLabel Price = new JLabel(title + "된 좌석 총 가격은 " + SeatPrice + "원 입니다.");
	   Price.setBounds(230, 140, 500, 30);
	   Price.setFont(mfont);

	   
	   JLabel AreaLabel = new JLabel(title + "된 구역:");
       AreaLabel.setBounds(100, 200, 180, 30);
       AreaLabel.setFont(mfont);
       
       JLabel AreaNum = new JLabel(selectedArea + "구역,");
       AreaNum.setBounds(270, 200, 180, 30);
       AreaNum.setFont(mfont);
       
       JLabel SeatLabel = new JLabel(title + "된 좌석:");
       SeatLabel.setBounds(370,200,180,30);
       SeatLabel.setFont(mfont);

       for(int i = 0; i< selectedSeats.size();i++) {
           JLabel SeatNum = new JLabel(Integer.toString(selectedSeats.get(i)));
           SeatNum.setBounds(520 + 50*i, 200, 150, 30);
           SeatNum.setFont(mfont);
           frame.add(SeatNum);
    	   
       }
       
	        JButton button = new JButton("확인");
	        button.setBounds(330,300, 140, 50);
	        button.setFont(font);
	        button.addActionListener(new ActionListener() {
	            public void actionPerformed (ActionEvent e) {
	            	frame.dispose();
	            	Window[] windows = Window.getWindows();
	                for (Window window : windows) {
	                	 if (window instanceof JFrame && !(window instanceof Home)) {
	                	        window.dispose();
	                	    }
	                	 // 확인버튼 누르면 Home 창 제외 모두닫기
	                } 
	            }
	            });
	        frame.addWindowListener(new WindowAdapter() {
	            @Override
	            public void windowClosing(WindowEvent e) {
	                // 창을 닫는 기능 구현 (원하는 작업 수행)
	                Window[] windows = Window.getWindows();
	                for (Window window : windows) {
	                    if (window instanceof JFrame && !(window instanceof Home)) {
	                        window.dispose();
	                    }
	                    // 창을 닫을 때 Home 창을 제외한 모든 창을 닫음
	                }
	            }
	        });

	        frame.add(warningsign);
	        frame.add(message);
	        frame.add(ReserveNum);
	        frame.add(button);
	        frame.add(AreaLabel);
	        frame.add(AreaNum);
	        frame.add(SeatLabel);
	        frame.add(Price);
	        frame.setSize(800, 400);
	        frame.setLocationRelativeTo(null);
	                
			frame.setVisible(true);
			SeatPrice = 0;
			count = 0;
		}
	
}




