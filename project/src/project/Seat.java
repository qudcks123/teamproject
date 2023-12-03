package project;

import javax.swing.*;
import javax.swing.border.Border;

import project.Seat3.retryActionListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Seat extends JFrame {
	final static int NUM_BUTTONS =13;
	final static int NUM_SEATS = 100;
	private Container cp;
	private JRadioButton[] seat = new JRadioButton[101];
	private JButton[] btn = new JButton[NUM_BUTTONS];
	public String[] date;
	public String [] time = {"14:30", "19:30", "--------"};
	public JButton entire,retry, prior, finish;
	public Seat() {
		setTitle("프방탄소년단 티켓");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cp = getContentPane();
		date = new String[31];
		
		
		for(int r =0; r<31; r++)
		{	
			if((r+1)% 7==4)
				{
					date[r] = new String("--------");
					continue;
				}
			date[r] = new String("12월" +(r+1) +"일");			
		} 
		

		
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
		
		uppertoolBar.add(new JLabel(new ImageIcon("ImageFiles/leftest.PNG")));
		uppertoolBar.addSeparator();
		uppertoolBar.add(new JLabel("프방탄소년단 2023 Concert in Seoul -서울 고척돔-"));
		uppertoolBar.add(Box.createHorizontalStrut(10));
		uppertoolBar.add(new JLabel("관람일자 선택:"));
		Calendar calendar = new Calendar(); // Calendar 클래스의 인스턴스 생성
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
		JToolBar righttoolBar = new JToolBar();
		righttoolBar.setFloatable(false);
		righttoolBar.setOrientation(SwingConstants.VERTICAL);
		righttoolBar.setBackground(Color.LIGHT_GRAY);
		
		entire = new JButton(new ImageIcon("ImageFiles/right.PNG"));
		finish = new JButton(new ImageIcon("ImageFiles/좌석선택완료.PNG"));
		prior = new JButton("이전단계");
		retry = new JButton("좌석다시선택");
		righttoolBar.add(entire);
		righttoolBar.addSeparator();
		righttoolBar.add(new JLabel("좌석등급 / 가격"));
		righttoolBar.add(new JLabel(new ImageIcon("ppt로 만들어야 하나?")));
		righttoolBar.addSeparator();
		righttoolBar.add(new JLabel("선택좌석"));
		righttoolBar.add(new JLabel());
		righttoolBar.add(finish);
		righttoolBar.add(prior);
		righttoolBar.add(retry);
		
		finish.addActionListener(new finishActionListener());
		prior.addActionListener(new priorActionListener());
		//retry.addActionListener(new retryActionListener());
		
		cp.add(righttoolBar,BorderLayout.EAST);
	}
	
	
	
	private class priorActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JButton b = (JButton) e.getSource();
		}
		
	}
	
	private class finishActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JButton b = (JButton) e.getSource();
		}
		
	}
	
	
	
	private void createSeatentire() {
		JPanel cp1 = new JPanel();
		JPanel cp2 = new JPanel();
		JPanel cp2a = new JPanel();
		JPanel cp3 = new JPanel();
		
		cp1.setBackground(Color.WHITE);
		cp2.setBackground(Color.WHITE);
		cp2a.setBackground(Color.WHITE);
		cp3.setBackground(Color.WHITE);
		
		
		cp1.setLayout(new BorderLayout());
		cp2.setLayout(new BorderLayout(10, 40));
		cp2a.setLayout(new BoxLayout(cp2a, BoxLayout.Y_AXIS));
		GridLayout grid = new GridLayout(3,4,10,10);
		cp3.setLayout(grid);
		
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
        
		
		//JLabel la2 = new JLabel("ㅁㅁ",new ImageIcon("ImageFiles/구역이미지.PNG"), JLabel.CENTER);
        //la2.setHorizontalTextPosition(JLabel.CENTER);
        //la2.setVerticalTextPosition(JLabel.CENTER);
		//la2.setAlignmentX(Component.CENTER_ALIGNMENT);
		JLabel la3 = new JLabel("<html>구역 내 상단이 무대와 가까운 쪽입니다. <br> The upper end of the section is the closest area to the stage</html>");	
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
		
		JLabel la5 = new JLabel("<html>ㅡㅡㅡㅡㅡㅡ<br> ※가로로 (한줄로 나란히) 예매해 주세요. <br>please reserve seats horizontally (in a row) </html>");
		la5.setAlignmentX(Component.CENTER_ALIGNMENT);
		la5.setOpaque(true);
		la5.setBackground(Color.BLUE);
		la5.setForeground(Color.white);
		Border border5 = BorderFactory.createLineBorder(Color.white, 2); // 검은색 2픽셀 라인 테두리
        la5.setBorder(border5);
        
        Font originalFont5 = la5.getFont();
        int fontSize5 = originalFont5.getSize() + 15; // 원하는 만큼 크기를 늘릴 수 있습니다.
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

		
	//	cp2a.add(la2);
		cp2a.add(la3);
		cp2a.add(la5);
		
		cp2.add(cp2a, BorderLayout.CENTER);
		
	      for (int i = 1; i < NUM_BUTTONS; i++) 
	      {
	          btn[i] = new JButton("00" + Integer.toString(i));
	          cp3.add(btn[i]);
	          if(i == 2 || i == 3 || i == 6 || i == 7 )
	          {
	        	  btn[i].setBackground(Color.CYAN);
	          }
	          else if(i == 1 || i == 4 || i == 5 || i == 8|| i == 10 || i == 11)
	          {
	        	  btn[i].setBackground(Color.GREEN);
	          }
	          else if(i == 9 || i == 12)
	          {
	        	  btn[i].setBackground(Color.GRAY);
	          }
	       }
		
		cp1.add(cp2,BorderLayout.NORTH);
		cp1.add(cp3,BorderLayout.CENTER);
		cp.add(cp1);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Seat();
	}

}
