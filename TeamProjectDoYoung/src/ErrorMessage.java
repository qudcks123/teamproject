import java.awt.*;
import javax.swing.*;

public class ErrorMessage extends JFrame {
    public ErrorMessage(String errorMessage) {
        JFrame frame = new JFrame();
        frame.setTitle("오류");

        Font mfont = new Font("고딕체", Font.BOLD, 35);
        Font font = new Font("고딕체", Font.BOLD, 20);
        Container c = frame.getContentPane();
        c.setLayout(null);

        JLabel warningSign = new JLabel(new ImageIcon("images/warningsign100.png"));
        warningSign.setBounds(40, 10, 100, 100);

        JLabel message = new JLabel(errorMessage);
        message.setHorizontalAlignment(SwingConstants.CENTER);
        message.setFont(mfont);
        message.setBounds(140, 35, 800, 50); // 일정 폭으로 고정

        JButton button = new JButton("확인");
        button.setBounds(450, 100, 150, 50);
        button.setFont(new Font("고딕체", Font.BOLD, 30));
        button.addActionListener(e -> frame.dispose());

        frame.add(warningSign);
        frame.add(message);
        frame.add(button);

        int frameWidth = 1000;
        int frameHeight = 200;
        frame.setSize(frameWidth, frameHeight);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
/*
    public static void main(String[] args) {
        new ErrorMessage("에러메세지 최대 출력이 어느 정도인지 시뮬레이션을 돌립니다.");
    }
*/
}
