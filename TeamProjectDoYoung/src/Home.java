
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
public class Home extends JFrame implements Serializable{
    private MyPanel panel = new MyPanel();
    private JFrame imageFrame = new JFrame();
    private JLabel imageLabel = new JLabel();
    static int selectmenu;
    public Home() {
       //폰트랑 글자 크기
       Font font = new Font("고딕체", Font.BOLD, 20);
       
        setTitle("콘서트 메인창");
        setContentPane(panel);
        //전체화면으로 해주는 코드
        setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1920, 1080);

        Container c = getContentPane();
        c.setLayout(null);
        
        //버튼에 사용되는 이미지들을 불러옴
        ImageIcon btn1 = new ImageIcon("images/P.png");
        ImageIcon btn2 = new ImageIcon("images/T.png");
        ImageIcon btn3 = new ImageIcon("images/S.png");
        ImageIcon btn4 = new ImageIcon("images/D.png");
        
        //버튼을 생성하고 배경색이랑 폰트 지정
        JButton 예약= new JButton("예약",btn1);
        예약.setBackground(Color.WHITE);
        예약.setFont(font);
        
        JButton 조회= new JButton("조회",btn2);
        조회.setFont(font);
        조회.setBackground(Color.WHITE);
        
        JButton 취소= new JButton("취소",btn3);
        취소.setFont(font);
        취소.setBackground(Color.WHITE);
        
        JButton 종료= new JButton("종료",btn4);
        종료.setFont(font);
        종료.setBackground(Color.WHITE);

        c.add(예약);
        c.add(조회);
        c.add(취소);
        c.add(종료);
        
        //버튼에 대한 좌표랑 크기 설정
        예약.setBounds(190, 230, 150, 70);
        조회.setBounds(190, 325, 150, 70);
        취소.setBounds(190, 420, 150, 70);
        종료.setBounds(190, 515, 150, 70);

        //각 버튼에 대한 마우스 이벤트 설정
        예약.addMouseListener(new MouseAdapter() {
            
            public void mouseEntered(MouseEvent e) {
                    showImage("고버스터","images/고버스터.jpg");
            }

            
            public void mouseExited(MouseEvent e) {
                hideImage();
            }
        });
        
        예약.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
            	selectmenu = 1;
            	new Calendar();             
            }     
        });
        
        조회.addMouseListener(new MouseAdapter() {
            
            public void mouseEntered(MouseEvent e) {
                showImage("뒤","images/뒤.jpg");
            	
            }

            public void mouseExited(MouseEvent e) {
                hideImage();
            }
        });

        취소.addMouseListener(new MouseAdapter() {
            
            public void mouseEntered(MouseEvent e) {
                showImage("제이보","images/제이보.jpg");
            
            }

            
            public void mouseExited(MouseEvent e) {
                hideImage();
            }
        });

        종료.addMouseListener(new MouseAdapter() {
            
            public void mouseEntered(MouseEvent e) {
                showImage("빈석진","images/빈석진.jpg");
            }

            
            public void mouseExited(MouseEvent e) {
                hideImage();
            }
        });
        조회.addActionListener(new ActionListener() {
            //버튼이 클릭되면 Cancel 클래스의 새 인스턴스 생성
            public void actionPerformed(ActionEvent e) {
            	selectmenu = 2;
                new Calendar();              
            	}
            
        });
        
        취소.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Cancel();
            }
        });
        종료.addActionListener(new ActionListener() {
            //버튼이 클릭되면 프로그램을 종료
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        setVisible(true);
    }

    //showImage로 나오는 창의 이름을 각 멤버이름으로 지정하고 사진의 사이즈를 지정
    private void showImage(String member,String imagePath) {
        ImageIcon icon = new ImageIcon(imagePath);
        Image scaledImage = icon.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH);
        imageLabel.setIcon(new ImageIcon(scaledImage));
        imageFrame.setTitle(member);
        imageFrame.getContentPane().add(imageLabel);
        imageFrame.setSize(400, 400);
        //이미지가 화면 정중앙에 나오도록 설정
        imageFrame.setLocationRelativeTo(null);
        imageFrame.setVisible(true);
    }
    //이미지를 숨기기 
    private void hideImage() {
        imageFrame.setVisible(false);
    }

    class MyPanel extends JPanel {
        private ImageIcon icon = new ImageIcon("images/포스터000.jpg");
        private Image img = icon.getImage();

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
        }
    }

    public static void main(String[] args) {
        new Home();
    }
}