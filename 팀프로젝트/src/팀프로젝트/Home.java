package 팀프로젝트;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame {
    private MyPanel panel = new MyPanel();
    private JFrame imageFrame = new JFrame("이미지 창");
    private JLabel imageLabel = new JLabel();

    public Home() {
        setTitle("콘서트 메인창");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel);
        setSize(1200, 800);

        Container c = getContentPane();
        c.setLayout(null);

        JButton btn1 = new JButton("예약");
        JButton btn2 = new JButton("조회");
        JButton btn3 = new JButton("취소");
        JButton btn4 = new JButton("종료");

        c.add(btn1);
        c.add(btn2);
        c.add(btn3);
        c.add(btn4);

        btn1.setBounds(200, 230, 70, 40);
        btn2.setBounds(200, 310, 70, 40);
        btn3.setBounds(200, 390, 70, 40);
        btn4.setBounds(200, 470, 70, 40);

        btn1.addMouseListener(new MouseAdapter() {
            
            public void mouseEntered(MouseEvent e) {
                showImage("images/예약.png");
            }

            
            public void mouseExited(MouseEvent e) {
                hideImage();
            }
        });

        btn2.addMouseListener(new MouseAdapter() {
            
            public void mouseEntered(MouseEvent e) {
                showImage("images/조회.png");
            }

            public void mouseExited(MouseEvent e) {
                hideImage();
            }
        });

        btn3.addMouseListener(new MouseAdapter() {
            
            public void mouseEntered(MouseEvent e) {
                showImage("images/취소.png");
            }

            
            public void mouseExited(MouseEvent e) {
                hideImage();
            }
        });

        btn4.addMouseListener(new MouseAdapter() {
            
            public void mouseEntered(MouseEvent e) {
                showImage("images/종료.png");
            }

            
            public void mouseExited(MouseEvent e) {
                hideImage();
            }
        });

        btn4.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        setVisible(true);
    }

    private void showImage(String imagePath) {
        ImageIcon icon = new ImageIcon(imagePath);
        Image scaledImage = icon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        imageLabel.setIcon(new ImageIcon(scaledImage));

        imageFrame.getContentPane().add(imageLabel);
        imageFrame.setSize(300, 300);
        imageFrame.setLocationRelativeTo(null);
        imageFrame.setVisible(true);
    }

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
