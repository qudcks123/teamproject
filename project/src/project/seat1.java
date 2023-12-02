package project;

import javax.swing.*;
import java.awt.*;

public class seat1 extends JFrame {
	final static int NUM_BUTTONS =13;
	private Container cp;
	public seat1() {
		setTitle("프방탄소년단 티켓");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cp = getContentPane();
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
		
		cp1.setLayout(null);
		
		JLabel la1 = new JLabel("※원하시는 영역을 선택해주세요. 공연장에서 위치를 클릭하거나, 오른쪽의 좌석을 클릭해주세요.");
		
		
		JLabel la2 = new JLabel(new ImageIcon("ImageFiles/구역이미지.PNG"));

		
		JLabel la3 = new JLabel("구역 내 상단이 무대와 가까운 쪽입니다.");

		
		JLabel la4 = new JLabel("The upper end of the section is the closest area to the stage");

		
		JLabel la5 = new JLabel("※가로로 (한줄로 나란히) 예매해 주세요.");


		
		for(int i=1; i<NUM_BUTTONS; i++)
		{
		JButton btn = new JButton("00" + Integer.toString(i));
		if(i<=4) {
			btn.setLocation(i*100,200);
		}
		else if(i>=5 && i<=8)
		{
			btn.setLocation((i-4)*100,400);	
		}
		else 
		{
			btn.setLocation((i-8)*100,600);	
		}
		btn.setSize(100,90);
		cp1.add(btn);
		}

		cp.add(cp1);
	}
	


	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new seat1();
	}

}
