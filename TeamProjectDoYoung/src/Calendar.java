import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class Calendar extends JFrame implements Serializable{
	private Container c = getContentPane();
	private JPanel month = new JPanel();
	private JPanel day = new JPanel();
	private JPanel time = new JPanel();
	static int dayNum;
	static int daynumminus;
	static String concertTime;
	static int [][] daytime = new int[31][2];
	static int performtime;
	
	public Calendar() {
		setTitle("날짜/시간 선택");
		
		c.setLayout(null);
		c.setBackground(Color.DARK_GRAY);
		
		//년도와 달
		month.setBackground(Color.WHITE);
		JLabel m = new JLabel("2023. 12");
		m.setFont(new Font("Arial", Font.BOLD, 35));
		month.add(m);
		
		
		// 12월 달력 생성
		day.setBackground(Color.WHITE);
		day.setLayout(new GridLayout(7,7,5,10));
		
		String [] Week = {"일", "월", "화", "수", "목", "금", "토"};
		
		// 요일 출력
		for(int i = 0; i<7; i++) {
			JLabel w = new JLabel(Week[i], SwingConstants.CENTER);
			w.setFont(new Font("고딕", Font.BOLD, 25));
			day.add(w);
		}
		
		// 일자 출력
		for(int i = 0; i<42; i++) {
			if(i<5 || i>35)
				day.add(new JLabel());
			else {
				JButton num = new JButton(Integer.toString(i-4));
				num.setFont(new Font("Arial", Font.PLAIN, 25));
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
						daynumminus = dayNum -1;
						
						time.removeAll();
						if(dayNum%7 == 2 || dayNum%7 == 3) {
							JButton first = new JButton("14:30");
							JButton second = new JButton("19:30");
							first.setFont(new Font("Arial", Font.PLAIN, 25));
							second.setFont(new Font("Arial", Font.PLAIN, 25));
							first.setBackground(Color.WHITE);
							second.setBackground(Color.WHITE);
							time.add(first);
							time.add(second);
							
							daytime[daynumminus][0] =1; // 14:30에 콘서트가 있다.
							daytime[daynumminus][1] =1; // 19:30에 콘서트가 있다.
							
							
							first.addActionListener(new TimeActionListener());
							second.addActionListener(new TimeActionListener());
						} else if(dayNum%7 == 4) {
							JLabel no = new JLabel("해당 날짜에는 공연이 없습니다.");
							no.setFont(new Font("고딕체", Font.PLAIN, 25));
							time.add(no);
						} else {
							JButton solo = new JButton("19:30");
							solo.setFont(new Font("Arial", Font.PLAIN, 25));
							time.add(solo);
							solo.addActionListener(new TimeActionListener());
							solo.setBackground(Color.WHITE);
							daytime[daynumminus][1] =1;
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
		month.setBounds(0, 0, 500, 50);
		day.setBounds(0, 52, 500, 400);
		
		time.setBackground(Color.WHITE);
		time.setBounds(0, 489, 500, 73);
		
		JLabel la = new JLabel("공연 시간", SwingConstants.CENTER);
		la.setFont(new Font("고딕", Font.BOLD,20));
		la.setOpaque(true);
		la.setBackground(Color.WHITE);
		la.setBounds(0,454, 500, 35);
		
		c.add(la);
		c.add(month);
		c.add(day);
		c.add(time);
		
		setSize(515, 600);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	class TimeActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();
			concertTime = b.getText();
			if(concertTime=="14:30")
			{
				performtime =0;
			}
			else if (concertTime =="19:30")
			{
				performtime =1;
			}
			 if(Home.selectmenu == 1) {
				 new Seat();
			 }
			 if(Home.selectmenu == 2) {
				 new Check();
			 }
			//setVisible(false);
		}
	}

}
