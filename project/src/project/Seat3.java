package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Seat3 extends JFrame {
	final static int NUM_BUTTONS =13;
	final static int NUM_SEATS = 100;
	private Container cp;
	private JRadioButton[] seat = new JRadioButton[101];
	private JToolBar uppertoolBar, righttoolBar;
	private JPanel cp1, seatPanel1, seatPanel2, seatPanel3;
	private JButton[] btnseat;
	private JLabel intro, selectedseat1, selectedseat2, selectedseat3, selectedseat4; 
	private JLabel[] row, selectedSeats;
	private JButton retry, prior;
	private int currentSeatIndex;
	
	public Seat3() {
		setTitle("프방탄소년단 티켓");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cp = getContentPane();

	    selectedseat1 = new JLabel();
	    selectedseat2 = new JLabel();
	    selectedseat3 = new JLabel();
	    selectedseat4 = new JLabel();
	    selectedSeats = new JLabel[]{selectedseat1, selectedseat2, selectedseat3, selectedseat4};
	    currentSeatIndex = 0;
	    retry = new JButton("좌석다시선택");
	    prior = new JButton("이전단계");
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
		
		
		uppertoolBar.add(new JLabel(new ImageIcon("ImageFiles/leftest.PNG")));
		uppertoolBar.addSeparator();
		uppertoolBar.add(new JLabel("프방탄소년단 2023 Concert in Seoul -서울 고척돔-"));
		uppertoolBar.add(Box.createHorizontalStrut(10));
		uppertoolBar.add(new JLabel("관람일자 선택:"));
		uppertoolBar.add(new JComboBox<>(new String[]{"일자1", "일자2", "일자3"}));
		uppertoolBar.add(new JLabel("시간:"));
		uppertoolBar.add(new JComboBox<>(new String[]{"시간1", "시간2", "시간3"}));
		
		cp.add(uppertoolBar,BorderLayout.NORTH);
	}
	
	private void createToolBarRight() {
		righttoolBar = new JToolBar();
		righttoolBar.setFloatable(false);
		righttoolBar.setOrientation(SwingConstants.VERTICAL);
		righttoolBar.setBackground(Color.LIGHT_GRAY);
		
		
		
		righttoolBar.add(new JButton(new ImageIcon("ImageFiles/right.PNG")));
		righttoolBar.addSeparator();
		righttoolBar.add(new JLabel("좌석등급 / 가격"));
		righttoolBar.add(new JLabel(new ImageIcon("ppt로 만들어야 하나?")));
		righttoolBar.addSeparator();
		righttoolBar.add(new JLabel("선택좌석"));
		righttoolBar.add(selectedseat1);
		righttoolBar.add(selectedseat2);
		righttoolBar.add(selectedseat3);
		righttoolBar.add(selectedseat4);
		righttoolBar.add(new JButton(new ImageIcon("ImageFiles/좌석선택완료.PNG")));
		righttoolBar.add(prior);
		righttoolBar.add(retry);
		retry.addActionListener(new retryActionListener());
		cp.add(righttoolBar,BorderLayout.EAST);
	}

	private void createSeatplacement() {
		createToolBarRight();
		createToolBarUpper();
		cp1 = new JPanel();
		cp1.setLayout(new BorderLayout());
		cp1.setBackground(Color.BLACK);
		
		// 그리드 레이아웃 사용
        seatPanel1 = new JPanel(new GridLayout(0, 10)); // 0은 행을 자동으로 조절
        seatPanel2= new JPanel(new GridLayout(0, 1));
        seatPanel3= new JPanel(new GridLayout(0, 1));
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
        
        intro = new JLabel("◇~~영역의 좌석배치도입니다.");
        seatPanel3.add(intro);

        
        cp1.add(seatPanel3, BorderLayout.NORTH);
        cp1.add(seatPanel2, BorderLayout.WEST);
        cp1.add(seatPanel1, BorderLayout.CENTER);
        
        cp.add(cp1, BorderLayout.CENTER);
	}
	
	private class seatActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton b = (JButton) e.getSource();

            if (currentSeatIndex < selectedSeats.length) {
                // 아직 모든 좌석이 갱신되지 않은 경우에만 갱신
                String newText = selectedSeats[currentSeatIndex].getText() + "~~열 " + b.getText();
                selectedSeats[currentSeatIndex].setText(newText);
                currentSeatIndex++;
            } // 모든 좌석이 갱신되면 더 이상의 갱신을 방지



        }
    }
	
	public class retryActionListener implements ActionListener{

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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Seat3();
	}

}
