
import javax.swing.*;
import javax.swing.border.Border;


import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Check extends JFrame {
   final static int NUM_BUTTONS = 12;
   final static int NUM_SEATS = 100;
   
   private Container cp;
   private JRadioButton[] seat = new JRadioButton[101];
   private JButton[] btn = new JButton[NUM_BUTTONS];

   public String [] time = {"14:30", "19:30", "--------"};
   public JButton entire,retry, prior, finish;
   public static int Areanum;
   public static String [] SeatType;
   JPanel[][] daytimecp = new JPanel[31][3]; 
   
   public Check() {
      setTitle("프방탄소년단 티켓");
      cp = getContentPane();

      SeatType = new String[NUM_BUTTONS];
   

      
      createToolBarRight();
      createToolBarUpper();
      createSeatentire();
      setSize(1100,800);
      setVisible(true);
  
}  
   private void createToolBarUpper() {
      JToolBar uppertoolBar = new JToolBar();
      uppertoolBar.setFloatable(false);
      uppertoolBar.setBackground(Color.LIGHT_GRAY);
      
      uppertoolBar.add(new JLabel(new ImageIcon("ImageFiles/leftest2.jpg")));
      uppertoolBar.addSeparator();
      uppertoolBar.add(new JLabel("프방탄소년단 2023 Concert in SeoulTech -창학관 326호-"));
      uppertoolBar.add(Box.createHorizontalStrut(10));

      cp.add(uppertoolBar,BorderLayout.NORTH);
      
   }
   
 
   private void createToolBarRight() {
      JToolBar righttoolBar = new JToolBar();
      righttoolBar.setFloatable(false);
      righttoolBar.setOrientation(SwingConstants.VERTICAL);
      righttoolBar.setBackground(Color.LIGHT_GRAY);
      
     
      prior = new JButton("이전단계");

      righttoolBar.addSeparator();
      righttoolBar.add(new JLabel("좌석등급 / 가격"));
      righttoolBar.add(new JLabel(new ImageIcon("ImageFiles/좌석타입.jpg")));
      righttoolBar.addSeparator();   
      righttoolBar.add(new JLabel());

      righttoolBar.add(prior);

      prior.addActionListener(new priorActionListener());
      //retry.addActionListener(new retryActionListener());
      
      cp.add(righttoolBar,BorderLayout.EAST);
   }
   
   
   
   private class priorActionListener implements ActionListener{
      @Override
      public void actionPerformed(ActionEvent e) {
         // TODO Auto-generated method stub
         dispose();
      }
      
   }
  

   static JPanel createPanel() {
       JPanel panel = new JPanel();
       return panel;
   }
   
   private void createSeatentire() {
      JPanel cp1 = new JPanel();
      JPanel cp2 = new JPanel();
      JPanel cp2a = new JPanel();
      
      cp1.setBackground(Color.WHITE);
      cp2.setBackground(Color.WHITE);
      cp2a.setBackground(Color.WHITE);
      
      JPanel[] [] Daytimecp = new JPanel[31][2];
      
      cp1.setLayout(new BorderLayout());
      cp2.setLayout(new BorderLayout(10, 40));
      cp2a.setLayout(new BoxLayout(cp2a, BoxLayout.Y_AXIS));
      GridLayout grid = new GridLayout(3,4,10,10);
      
      for (int i =0; i<31; i++)
      {		
    	  for(int k =0; k<2; k++)
    	  {
    		  if (Calendar.daytime[Calendar.daynumminus][0] == 1) {
    			  
    			  Daytimecp[i][k] = createPanel(); // 특정 날짜 14:30에 공연이 있어서 패널을 만들었어요.
    			  Daytimecp[i][k].setLayout(grid);
    		  }
    		  else if(Calendar.daytime[Calendar.daynumminus][1] == 1)
    		  {
    			  Daytimecp[i][k] = createPanel();
    			  Daytimecp[i][k].setLayout(grid);
    		  }    		  
    	  }
      }
       // 이렇게 하면 데이타임 패널 만들었고 여기다가 저장만 하면 된다. 그리고 만든 거 여기다가 저장하게 
   		// 그리고 버튼 누르면은 패널로 들어가는 거 
      cp2.setPreferredSize(new Dimension(cp2.getPreferredSize().width, 300));
      
      JLabel la1 = new JLabel("※원하시는 영역을 선택해주세요. 공연장에서 위치를 클릭하거나, 오른쪽의 좌석을 클릭해주세요.");
      la1.setOpaque(true);
      la1.setBackground(Color.LIGHT_GRAY);
      Border border1 = BorderFactory.createLineBorder(Color.WHITE, 2); // 검은색 2픽셀 라인 테두리
        la1.setBorder(border1);
        
        Font originalFont1 = la1.getFont();
        int fontSize1 = originalFont1.getSize() + 5; // 원하는 만큼 크기를 늘릴 수 있습니다.
        Font largerFont1 = originalFont1.deriveFont((float) fontSize1);
        la1.setFont(largerFont1);
        
      
      JLabel la3 = new JLabel("<html>구역 내 상단이 PTSD와 가까운 쪽입니다. <br> The upper end of the section is the closest area to the 프방탄소년단</html>");   
      la3.setAlignmentX(Component.CENTER_ALIGNMENT);       
      
      la3.setOpaque(true);
      la3.setBackground(Color.white);
      la3.setForeground(Color.BLUE);
      Border border3 = BorderFactory.createLineBorder(Color.white, 2); // 검은색 2픽셀 라인 테두리
        la3.setBorder(border3);
        
        Font originalFont3 = la3.getFont();
        int fontSize3 = originalFont3.getSize() + 5; // 원하는 만큼 크기를 늘릴 수 있습니다.
        Font largerFont3 = originalFont3.deriveFont((float) fontSize3);
        la3.setFont(largerFont3);
      
      JLabel la5 = new JLabel("<html>ㅡㅡㅡㅡㅡ클릭은 한 번만 부탁드립니다.<br> ※ 최대 4 좌석까지만 예매 가능합니다(한 구역 내). <br> You can buy max-BONG 4 seats (only 1 in your area). </html>");
      la5.setAlignmentX(Component.CENTER_ALIGNMENT);
      la5.setOpaque(true);
      la5.setBackground(Color.BLUE);
      la5.setForeground(Color.white);
      Border border5 = BorderFactory.createLineBorder(Color.white, 2); // 검은색 2픽셀 라인 테두리
        la5.setBorder(border5);
        
        Font originalFont5 = la5.getFont();
        int fontSize5 = originalFont5.getSize() + 13; // 원하는 만큼 크기를 늘릴 수 있습니다.
        Font largerFont5 = originalFont5.deriveFont((float) fontSize5);
        la5.setFont(largerFont5);
        
      JLabel la6 = new JLabel("Stage");
      la6.setOpaque(true);
      la6.setBackground(Color.lightGray);
      la6.setForeground(Color.DARK_GRAY);
      Border border6 = BorderFactory.createLineBorder(Color.white, 2); // 검은색 2픽셀 라인 테두리
        la6.setBorder(border6);
        
        Font originalFont6 = la6.getFont();
        int fontSize6 = originalFont6.getSize() + 10; // 원하는 만큼 크기를 늘릴 수 있습니다.
        Font largerFont6 = originalFont6.deriveFont((float) fontSize6);
        la6.setFont(largerFont6);
      
      cp2.add(la1, BorderLayout.NORTH);
      cp2.add(la6, BorderLayout.SOUTH);
      la6.setHorizontalAlignment(SwingConstants.CENTER);

      
   //   cp2a.add(la2);
      cp2a.add(la3);
      cp2a.add(la5);
      
      cp2.add(cp2a, BorderLayout.CENTER);
      
         for (int i = 0; i < NUM_BUTTONS ; i++) 
         {
        	 btn[i] = new JButton( i + 1 + "");
        	 Daytimecp[Calendar.daynumminus][Calendar.performtime].add(btn[i]);
             btn[i].addActionListener(new btnActionListener());
             if(i == 1 || i == 2 || i == 5 || i == 6 )
             {
                btn[i].setBackground(Color.CYAN);
                SeatType[i] = "V";
                
             }
             else if(i == 0 || i == 3 || i == 4 || i == 7|| i == 9 || i == 10)
             {
                btn[i].setBackground(Color.GREEN);
                SeatType [i] = "R";
             }
             else if(i == 8 || i == 11)
             {
                btn[i].setBackground(Color.GRAY);
                SeatType [i] = "S";
             }
          }
      
        
      cp1.add(cp2,BorderLayout.NORTH);
      cp1.add(Daytimecp[Calendar.daynumminus][Calendar.performtime],BorderLayout.CENTER);
      cp.add(cp1);
   }
   
   public class btnActionListener implements ActionListener{

      @Override
      public void actionPerformed(ActionEvent e) {
    	  JButton b = (JButton) e.getSource();
			Areanum= Integer.parseInt(b.getText());		 // SeatType[Areanum-1] 하면 되겠다.
		// 그럼 area[10] = 11; 이라고 치면 
			new Check3();			
			}
		}
   /*
   public static void main(String[] args) {
   	new Seat();
   }
   */
	}

