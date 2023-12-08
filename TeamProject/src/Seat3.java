import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;



public class Seat3 extends JFrame {
   final static int NUM_BUTTONS =13;
   final static int NUM_SEATS = 100;
   private Container cp;
   private JRadioButton[] seat = new JRadioButton[101];
   private JToolBar uppertoolBar, righttoolBar;
   private JPanel cp1, seatPanel1, seatPanel2, seatPanel3;
   private JButton[] btnseat;
   private JLabel intro;
   private JLabel selectedseat1, selectedseat2, selectedseat3, selectedseat4;  // 우측 콤보박스에 선택된 좌석 선택한 거 
   private JLabel[] row, selectedSeats;
   private JButton retry, prior, finish;
   private int currentSeatIndex;
   public String[] date;
   public String [] time = {"14:30", "19:30", "--------"};
   public int [] [] beforeSelectedSeats; //?
   public static int SeatNum;
   static ArrayList<Store> s = new ArrayList<>();
   
   public Seat3() {
      setTitle("프방탄소년단 티켓");
      cp = getContentPane();

      date = new String[31];
      beforeSelectedSeats = new int[NUM_BUTTONS][NUM_SEATS];
            
      for(int r =0; r<31; r++)
      {   
         if((r+1)% 7==4)
            {
               date[r] = new String("--------");
               continue;
            }
         date[r] = new String("12월" +(r+1) +"일");         
      } 
      
      
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
      createToolBarRight();
      createToolBarUpper();
      createSeatplacement();
      setSize(1100,800);
      setVisible(true);
     
   }
   
   private void createToolBarUpper() {
      uppertoolBar = new JToolBar();
      uppertoolBar.setFloatable(false);
      uppertoolBar.setBackground(Color.LIGHT_GRAY);
      
      
      uppertoolBar.add(new JLabel(new ImageIcon("ImageFiles/leftest.jpg")));
      uppertoolBar.addSeparator();
      uppertoolBar.add(new JLabel("프방탄소년단 2023 Concert in Seoul -서울 고척돔-"));
      uppertoolBar.add(Box.createHorizontalStrut(10));
      uppertoolBar.add(new JLabel("관람일자 선택:"));
        JComboBox<String> dateComboBox = new JComboBox<String>(date);
        uppertoolBar.add(dateComboBox);
        JComboBox<String> timeComboBox = new JComboBox<String>();
        setInitialTimeOptions(timeComboBox);
        
        dateComboBox.addActionListener(e -> {
            updateTimeComboBox(dateComboBox.getSelectedIndex(), timeComboBox);
        });
        
      uppertoolBar.add(new JLabel("시간:"));
      uppertoolBar.add(timeComboBox); // 받아서 하기 
      
      cp.add(uppertoolBar,BorderLayout.NORTH);

   }
   
    private void updateTimeComboBox(int selectedIndex, JComboBox<String> timeComboBox) {
        timeComboBox.removeAllItems();
        if ((selectedIndex + 1) % 7 == 4) {
            timeComboBox.addItem("--------");
        } else if ((selectedIndex + 1) % 7 == 2 || (selectedIndex + 1) % 7 == 3) {
            timeComboBox.addItem("14:30");
            timeComboBox.addItem("19:30");
            timeComboBox.addItem("--------");
        } else {
            timeComboBox.addItem("--------");
            timeComboBox.addItem("19:30");
            timeComboBox.addItem("--------");
        }
    }
    
    private void setInitialTimeOptions(JComboBox<String> timeComboBox) {
        for (String timeOption : time) {
            timeComboBox.addItem(timeOption);
        }
    }
   
   private void createToolBarRight() {
      righttoolBar = new JToolBar();
      righttoolBar.setFloatable(false);
      righttoolBar.setOrientation(SwingConstants.VERTICAL);
      righttoolBar.setBackground(Color.LIGHT_GRAY);
      
      
      
      righttoolBar.add(new JButton(new ImageIcon("ImageFiles/right.PNG")));
      righttoolBar.addSeparator();
      righttoolBar.add(new JLabel("좌석등급 / 가격"));
      righttoolBar.add(new JLabel(new ImageIcon("ImageFiles/좌석타입.jpg")));
      righttoolBar.add(new JLabel(new ImageIcon("ppt로 만들어야 하나?")));
      righttoolBar.addSeparator();
      righttoolBar.add(new JLabel("선택좌석"));
      righttoolBar.add(selectedseat1);
      righttoolBar.add(selectedseat2);
      righttoolBar.add(selectedseat3);
      righttoolBar.add(selectedseat4); // 1,2,3,4는 선택된 좌석
      righttoolBar.add(finish);
      righttoolBar.add(prior);
      righttoolBar.add(retry);
      
      prior.addActionListener(new priorActionListener());
      retry.addActionListener(new retryActionListener());
      finish.addActionListener(new finishActionListener());
      
      cp.add(righttoolBar,BorderLayout.EAST);
   }

   private void createSeatplacement() {
      cp1 = new JPanel();
      cp1.setLayout(new BorderLayout());
      cp1.setBackground(Color.BLACK);
      
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
            btnseat[i-1].addActionListener(new seatActionListener());
        }
        
        for (int j = 0; j < NUM_SEATS / 10; j++) {
            row[j] = new JLabel((j + 1) + " 열");
            row[j].setForeground(Color.WHITE);
            row[j].setBackground(Color.BLACK);
            seatPanel2.add(row[j]);
            row[j].setHorizontalAlignment(SwingConstants.CENTER);
        }
        
        intro = new JLabel(Seat.Areanum + "구역의 좌석배치도입니다.");
        seatPanel3.add(intro);

        
        cp1.add(seatPanel3, BorderLayout.NORTH);
        cp1.add(seatPanel2, BorderLayout.WEST);
        cp1.add(seatPanel1, BorderLayout.CENTER);
        
        cp.add(cp1, BorderLayout.CENTER);
   }
   
   class seatActionListener implements ActionListener { // 선택 좌석을 총 4개까지 제한하는 코드
       @Override
       public void actionPerformed(ActionEvent e) {
           JButton b = (JButton) e.getSource();
           SeatNum = Integer.parseInt(b.getText());
           if (currentSeatIndex < selectedSeats.length) {
               // 아직 모든 좌석이 갱신되지 않은 경우에만 갱신
           	if(beforeSelectedSeats[Seat.Areanum][SeatNum] != SeatNum){
           	String newText = selectedSeats[currentSeatIndex].getText() + (SeatNum/10+1)+ "열 " +SeatNum + "번"; // ~~열 [좌석번호],, 그럼 나는 b.getText()로 번호만 받아가면 되겠다.
           	beforeSelectedSeats[Seat.Areanum][SeatNum] = SeatNum; // 0부터 저장이 안 돼니까 
               
               //저 정수를 받아서 예약완료 되면 저게 저장이 되는 걸로 
               // beforeselectedSeats[여기가 큰 좌석 번호][Integer.parseInt(b.getText()) - 1] = Integer.parseInt(b.getText()); 해서 일단 좌석 번호가 저장이 돼 
               // before Seat. 큰 좌석 번호가 
               // Reserve가 되면은 beforeselectedSeats에 저장된 게 finishselectedSeats[]에 저장하고 beforeselectedSeats 싹다 초기화 
               selectedSeats[currentSeatIndex].setText(newText); // ~~열 [좌석번호]를 selectedSeats 어레이어 저장 
               currentSeatIndex++;
           	}
           } // 모든 좌석이 갱신되면 더 이상의 갱신을 방지
       }
   }
   
   private class priorActionListener implements ActionListener{ 

	      @Override
	      public void actionPerformed(ActionEvent e) {
	         // TODO Auto-generated method stub	    	 
	            dispose();
	      }      
	   }
   
   private class retryActionListener implements ActionListener{ 

      @Override
      public void actionPerformed(ActionEvent e) {
         // TODO Auto-generated method stub
            for (JLabel seatLabel : selectedSeats) {
                seatLabel.setText("");
            }
            // currentSeatIndex 초기화
            currentSeatIndex = 0;
      }      
   }
   
   private class finishActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Store d = new Store(Calendar.dayNum, Calendar.concertTime, Seat.Areanum ,Seat.SeatType[Seat.Areanum-1], SeatNum);			
			s.add(d);
			System.out.println(d);
			new Reserve();
			
		}
		
	}
   public static void main(String[] args) {
   	new Seat3();
   }

}