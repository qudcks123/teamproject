package project;

import javax.swing.*;
import java.awt.*;


public class Seat extends JFrame {
	final static int NUM_BUTTONS =13;
	final static int NUM_SEATS = 100;
	private Container cp;
	private JRadioButton[] seat = new JRadioButton[101];
	public Seat() {
		setTitle("프방탄소년단 티켓");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cp = getContentPane();
		
		createToolBarRight();
		createToolBarUpper();
		createSeatentire();
		createSeatplacement();
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
		uppertoolBar.add(new JComboBox<>(new String[]{"일자1", "일자2", "일자3"}));
		uppertoolBar.add(new JLabel("시간:"));
		uppertoolBar.add(new JComboBox<>(new String[]{"시간1", "시간2", "시간3"}));
		
		cp.add(uppertoolBar,BorderLayout.NORTH);
	}
	
	private void createToolBarRight() {
		JToolBar righttoolBar = new JToolBar();
		righttoolBar.setFloatable(false);
		righttoolBar.setOrientation(SwingConstants.VERTICAL);
		righttoolBar.setBackground(Color.LIGHT_GRAY);
		
		
		
		righttoolBar.add(new JButton(new ImageIcon("ImageFiles/right.PNG")));
		righttoolBar.addSeparator();
		righttoolBar.add(new JLabel("좌석등급 / 가격"));
		righttoolBar.add(new JLabel(new ImageIcon("ppt로 만들어야 하나?")));
		righttoolBar.addSeparator();
		righttoolBar.add(new JLabel("선택좌석"));
		righttoolBar.add(new JLabel());
		righttoolBar.add(new JButton(new ImageIcon("ImageFiles/좌석선택완료.PNG")));
		righttoolBar.add(new JButton("이전단계"));
		righttoolBar.add(new JButton("좌석다시선택"));
		
		cp.add(righttoolBar,BorderLayout.EAST);
	}
	
	private void createSeatentire() {
		JPanel cp1 = new JPanel();
		JPanel cp2 = new JPanel();
		JPanel cp2a = new JPanel();
		JPanel cp3 = new JPanel();
		
		cp2.setBackground(Color.BLUE);
		cp3.setBackground(Color.GREEN);
		cp1.setBackground(Color.WHITE);
		
		cp1.setLayout(new BorderLayout());
		cp2.setLayout(new BorderLayout(5, 40));
		GridLayout grid = new GridLayout(3,4);
		cp3.setLayout(grid);
		
		cp2.setPreferredSize(new Dimension(cp2.getPreferredSize().width, 300));
		
		JLabel la1 = new JLabel("※원하시는 영역을 선택해주세요. 공연장에서 위치를 클릭하거나, 오른쪽의 좌석을 클릭해주세요.");

		cp2.add(la1, BorderLayout.NORTH);
		
		JLabel la2 = new JLabel(new ImageIcon("ImageFiles/구역이미지.PNG"));
		JLabel la3 = new JLabel("구역 내 상단이 무대와 가까운 쪽입니다.");	
		JLabel la4 = new JLabel("The upper end of the section is the closest area to the stage");
		JLabel la5 = new JLabel("※가로로 (한줄로 나란히) 예매해 주세요.");
		JLabel la6 = new JLabel("Stage");
		
		cp2.add(la6, BorderLayout.SOUTH);
		cp2a.add(la2);
		cp2a.add(la3);
		cp2a.add(la4);
		cp2a.add(la5);
		cp2.add(cp2a, BorderLayout.CENTER);
		
		for(int i=1; i<NUM_BUTTONS; i++)
		{
		JButton btn = new JButton("00" + Integer.toString(i));
		cp3.add(btn);
		}
		
		cp1.add(cp2,BorderLayout.NORTH);
		cp1.add(cp3,BorderLayout.CENTER);
		cp.add(cp1);
	}
	
	private void createSeatplacement() {
		createToolBarRight();
		createToolBarUpper();
		JPanel cp1 = new JPanel();
		JPanel cp2 = new JPanel();
		cp1.setLayout(new BorderLayout());
		
		ButtonGroup group = new ButtonGroup();
		
		for(int i =1; i<= NUM_SEATS; i++)
		{
			seat[i] = new JRadioButton();
			seat[i].setSize(1, 1);
			group.add(seat[i]);
			cp1.add(seat[i],BorderLayout.CENTER);
			seat[i].setHorizontalAlignment(SwingConstants.CENTER);
		}
		for(int j=1; j<=10; j++)
		{
			JLabel Line = new JLabel(j+"열");
			cp1.add(Line, BorderLayout.WEST);
			Line.setHorizontalAlignment(SwingConstants.CENTER);
		}
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Seat();
	}

}
