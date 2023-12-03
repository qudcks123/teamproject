package team;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Calendar extends JFrame {
	private Container c = getContentPane();
	private JPanel month = new JPanel();
	private JPanel day = new JPanel();
	private JPanel time = new JPanel();
	protected ArrayList<String> date = new ArrayList<String>();
	protected ArrayList<String> t = new ArrayList<String>();
	static int dayNum;
	
	public Calendar() {
		setTitle("날짜/시간 선택");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		c.setLayout(null);
		c.setBackground(Color.DARK_GRAY);
		
		//년도와 달
		month.setBackground(Color.WHITE);
		JLabel m = new JLabel("2023. 12");
		m.setFont(new Font("Arial", Font.BOLD, 20));
		month.add(m);
		month.setBounds(0, 0, 400, 30);
		
		// 12월 달력 생성
		day.setBackground(Color.WHITE);
		day.setLayout(new GridLayout(7,7,5,10));
		
		// 요일 출력
		day.add(new JLabel("일",SwingConstants.CENTER));
		day.add(new JLabel("월",SwingConstants.CENTER));
		day.add(new JLabel("화",SwingConstants.CENTER));
		day.add(new JLabel("수",SwingConstants.CENTER));
		day.add(new JLabel("목",SwingConstants.CENTER));
		day.add(new JLabel("금",SwingConstants.CENTER));
		day.add(new JLabel("토",SwingConstants.CENTER));
		
		// 일자 출력
		for(int i = 0; i<42; i++) {
			if(i<5 || i>35)
				day.add(new JLabel());
			else {
				JButton num = new JButton(Integer.toString(i-4));
				num.setBackground(Color.white);
				
				if((i-4)%7 == 2)
					num.setForeground(Color.BLUE);
				else if((i-4)%7 == 3)
					num.setForeground(Color.RED);
				else if((i-4)%7 == 4)
					num.setForeground(Color.LIGHT_GRAY);
				
				// 일자 클릭시 시간 출력
				num.addActionListener(new ActionListener() {
					private static JButton last = null;
					@Override
					public void actionPerformed(ActionEvent e) {
						JButton b = (JButton)e.getSource();
						
						if (last != null && last != b) { 
				            last.setBackground(Color.WHITE);
				        }
						
						String text = b.getText();
						dayNum = Integer.parseInt(text);
						
						time.removeAll();
						if(dayNum%7 == 2 || dayNum%7 == 3) {
							JButton first = new JButton("14:30");
							JButton second = new JButton("19:30");
							first.setBackground(Color.WHITE);
							second.setBackground(Color.WHITE);
							time.add(first);
							time.add(second);
							
							first.addActionListener(new TimeActionListener());
							second.addActionListener(new TimeActionListener());
						} else if(dayNum%7 == 4) {
							time.add(new JLabel("해당 날짜에는 공연이 없습니다."));
						} else {
							JButton solo = new JButton("19:30");
							time.add(solo);
							solo.addActionListener(new TimeActionListener());
							solo.setBackground(Color.WHITE);
						}
						time.revalidate();
						time.repaint();
						b.setBackground(Color.ORANGE);
						last = b;
					}	
				});
				day.add(num);
			}
		}
		day.setBounds(0, 32, 400, 400);
		
		time.setBackground(Color.WHITE);
		time.setBounds(0, 452, 400, 60);
		
		JLabel la = new JLabel("시간", SwingConstants.CENTER);
		la.setOpaque(true);
		la.setBackground(Color.WHITE);
		la.setBounds(0,434, 400, 18);
		
		c.add(la);
		c.add(month);
		c.add(day);
		c.add(time);
		
		setSize(415, 550);
		setVisible(true);
	}
	
	class TimeActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();
			date.add(Integer.toString(dayNum));
			t.add(b.getText());
			System.out.println(date);
			System.out.println(t);
			// new 
			//setVisible(false);
		}
	}
	
	public static void main(String[] args) {	
		new Calendar();
	}
}
