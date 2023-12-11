import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class Check3 extends JFrame implements Serializable{
	final static int NUM_BUTTONS =13;
	   final static int NUM_SEATS = 80;
	   private Container cp;
	   private JRadioButton[] seat = new JRadioButton[101];
	   private JToolBar uppertoolBar, righttoolBar;
	   private JPanel cp1, seatPanel1, seatPanel2, seatPanel3;
	   static JButton[] btnseat;
	   private JLabel intro, selectedseat1, selectedseat2, selectedseat3, selectedseat4;  // 우측 콤보박스에 선택된 좌석 선택한 거 
	   private JLabel[] row, selectedSeats;
	   private JButton retry, prior, finish;
	   private int currentSeatIndex;
	   public String [] time = {"14:30", "19:30", "--------"};
	   public int [] [] beforeSelectedSeats; //?
	   public static ArrayList<Integer> SeatNumArr = new ArrayList<>();
	   static ArrayList<Store> s = new ArrayList<Store>();
	   static ArrayList<Store> ss = new ArrayList<Store>();
	   ArrayList <Integer> a = new ArrayList<>();
	   static int SeatNumint;
	   int  size,b;
   
   
   public Check3() {
      setTitle("프방탄소년단 티켓");
      cp = getContentPane();


      beforeSelectedSeats = new int[NUM_BUTTONS][NUM_SEATS]; 
                
       selectedseat1 = new JLabel();
       selectedseat2 = new JLabel();
       selectedseat3 = new JLabel();
       selectedseat4 = new JLabel();
       selectedSeats = new JLabel[]{selectedseat1, selectedseat2, selectedseat3, selectedseat4}; // 선택 좌석은 총 4개까지 
       currentSeatIndex = 0;
       retry = new JButton("좌석다시선택");
       prior = new JButton("이전단계");
       finish = new JButton(new ImageIcon("ImageFiles/좌석선택완료.PNG"));
      btnseat = new JButton[NUM_SEATS];
      row = new JLabel[NUM_SEATS/10];
      createToolBarRight(); // 화면 우측 툴바
      createToolBarUpper(); // 화면 상단 툴바
      createSeatplacement(); // 좌석 출력 
      setSize(1100,800);
      setVisible(true);
     
   }
   
   private void createToolBarUpper() {
      uppertoolBar = new JToolBar();
      uppertoolBar.setFloatable(false);
      uppertoolBar.setBackground(Color.LIGHT_GRAY);
      
      
      uppertoolBar.add(new JLabel(new ImageIcon("ImageFiles/leftest2.jpg")));
      uppertoolBar.addSeparator();
      uppertoolBar.add(new JLabel("프방탄소년단 2023 Concert in SeoulTech -창학관 326호-우-"));
      uppertoolBar.add(Box.createHorizontalStrut(10));
      // 
      cp.add(uppertoolBar,BorderLayout.NORTH);

   }
   


   
   private void createToolBarRight() {
      righttoolBar = new JToolBar();
      righttoolBar.setFloatable(false);
      righttoolBar.setOrientation(SwingConstants.VERTICAL);
      righttoolBar.setBackground(Color.LIGHT_GRAY);
                  
      righttoolBar.addSeparator();
      righttoolBar.add(new JLabel("좌석등급 / 가격"));
      righttoolBar.add(new JLabel(new ImageIcon("ImageFiles/좌석타입.jpg")));
      righttoolBar.addSeparator();
      righttoolBar.add(prior);

      prior.addActionListener(new priorActionListener());
      
      cp.add(righttoolBar,BorderLayout.EAST);
   }

   private void createSeatplacement() {
	   JPanel[] [] [] AreaSeatnumcp = new JPanel[31] [2][12] ;
	      AreaSeatnumcp[Calendar.daynumminus][Calendar.performtime][Check.Areanum-1] = Seat.createPanel();
	      AreaSeatnumcp[Calendar.daynumminus][Calendar.performtime][Check.Areanum-1].setLayout(new BorderLayout());
	      AreaSeatnumcp[Calendar.daynumminus][Calendar.performtime][Check.Areanum-1].setBackground(Color.BLACK);
	   
      // 그리드 레이아웃 사용
        seatPanel1 = new JPanel(new GridLayout(0, 10)); // 0은 행을 자동으로 조절. 좌석 1부터 100까지
        seatPanel2= new JPanel(new GridLayout(0, 1)); // 좌석 좌측 ~~열 표현 
        seatPanel3= new JPanel(new GridLayout(0, 1)); // ~~영역의 좌석 배치도 입니다.
        seatPanel1.setBackground(Color.GREEN);
        seatPanel2.setBackground(Color.CYAN);
        seatPanel3.setBackground(Color.RED);
     // 버튼 생성 및 패널에 추가
        for (int i = 1; i <= NUM_SEATS; i++) {
            btnseat[i-1] = new JButton("" + i);
            btnseat[i-1].setForeground(Color.WHITE);
            btnseat[i-1].setBackground(Color.BLACK);
            seatPanel1.add(btnseat[i-1]);
        }
        
        for (int j = 0; j < NUM_SEATS / 10; j++) {
            row[j] = new JLabel((j + 1) + " 열");
            row[j].setForeground(Color.WHITE);
            row[j].setBackground(Color.BLACK);
            seatPanel2.add(row[j]);
            row[j].setHorizontalAlignment(SwingConstants.CENTER);
        }
        
        intro = new JLabel(Check.Areanum + "구역의 좌석배치도입니다.");
        seatPanel3.add(intro);
        
        AreaSeatnumcp[Calendar.daynumminus][Calendar.performtime][Check.Areanum-1].add(seatPanel3, BorderLayout.NORTH);
        AreaSeatnumcp[Calendar.daynumminus][Calendar.performtime][Check.Areanum-1].add(seatPanel2, BorderLayout.WEST);
        AreaSeatnumcp[Calendar.daynumminus][Calendar.performtime][Check.Areanum-1].add(seatPanel1, BorderLayout.CENTER);
        
        cp.add(AreaSeatnumcp[Calendar.daynumminus][Calendar.performtime][Check.Areanum-1], BorderLayout.CENTER);
        
        for(b=0; b<s.size(); b++)
        {
        	a.add(s.get(b).seatnum);
        	size++;
        } // 요 내용을 백번 저기 안에 넣어야 되는데 저기서 seatnum이 아래에서 순서 잖아 
        s = Info.Information("InformSeat1");
        ss = Info.Information("seat");
        //if(Reserve.ReserveNumber>=1)
        if(ss.size()>=1)
        {
        //if(Reserve.r.get(Reserve.ReserveNumber-1).ReNum>=1)
        if(ss.get(ss.size()-1).ReNum>=1)
        {   
        	int m = 0;
            for (int j = 1; j <= NUM_SEATS; j++) {
                seatPanel1.remove(btnseat[j-1]);
            }
            
            for (int i = 1; i <= NUM_SEATS; i++) {
            	
            	for(int l=0; l<s.size(); l++)
            	{	
            					
            		if(s.get(l).date == Calendar.dayNum && s.get(l).time.equals(Calendar.concertTime) && s.get(l).Areanum == Check.Areanum) 
            		{
            			if(i ==s.get(l).seatnum) 
            			{
            				JButton ReservedBtn = new JButton(""+i);
            				seatPanel1.add(ReservedBtn); // 예약된 좌석
            				m=1;
            				break;
            			
            		} 

        }
            	}
            	if(m == 0) {
        			btnseat[i-1] = new JButton("" + i);
        			btnseat[i-1].setForeground(Color.WHITE);
        			btnseat[i-1].setBackground(Color.BLACK);
        			seatPanel1.add(btnseat[i-1]);// 예약 안 된 좌석
            	}else if(m==1)
            		m=0;
            		continue;
            	}
        }
   }
   }  

   private class priorActionListener implements ActionListener{ 

	      @Override
	      public void actionPerformed(ActionEvent e) {
	         // TODO Auto-generated method stub
	    	  
	    	  for (int i = 0; i < NUM_BUTTONS; i++) {
	    		    for (int j = 0; j < NUM_SEATS; j++) {
	    		        beforeSelectedSeats[i][j] = 0;
	    		    }
	    		}
	    	 
	    	  SeatNumArr.removeAll(SeatNumArr);
	            dispose();
	      }      
	   }
  
   
}