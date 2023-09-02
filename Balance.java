import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Balance implements ActionListener, MouseListener {
    private JFrame screen;
    private Container c;
    public JLabel label, atm, dgn, dgn1, logo, msg, back;
    private JButton quit;

    public Balance() {

        screen = new JFrame();
        screen.setSize(800, 500);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screen.setTitle("BALANCE");
        screen.setLayout(null);
        screen.setResizable(false);
        screen.setLocationRelativeTo(null);

        c = screen.getContentPane();
        c.setBackground(Color.CYAN);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icon//Sbi.png"));
        logo = new JLabel();
        logo.setBounds(60, 20, 100, 100);
        Image i = i1.getImage();
        Image i2 = i.getScaledInstance(logo.getWidth(), logo.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        logo.setIcon(i3);
        c.add(logo);

        ImageIcon imgc = new ImageIcon(ClassLoader.getSystemResource("Icon//back.png"));
        back = new JLabel();
        back.setBounds(5, 8, 45, 45);
        Image img = imgc.getImage();
        Image img1 = img.getScaledInstance(back.getWidth(), back.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon imgc1 = new ImageIcon(img1);
        back.setIcon(imgc1);
        back.addMouseListener(this);
        c.add(back);

        label = new JLabel();
        label.setBounds(165, 20, 450, 60);
        label.setFont(new Font("serif", Font.BOLD, 40));
        label.setForeground(Color.BLACK);
        label.setText("STATE BANK OF INDIA");
        c.add(label);

        dgn = new JLabel();
        dgn.setBounds(165, 63, 500, 20);
        dgn.setText("==========================");
        dgn.setFont(new Font("null", Font.BOLD, 30));
        dgn.setForeground(Color.BLACK);
        c.add(dgn);

        atm = new JLabel();
        atm.setBounds(305, 80, 150, 40);
        atm.setText("ATM");
        atm.setFont(new Font("Serif", Font.BOLD, 50));
        atm.setForeground(Color.BLACK);
        c.add(atm);

        dgn1 = new JLabel();
        dgn1.setBounds(305, 110, 200, 40);
        dgn1.setText("=======");
        dgn1.setFont(new Font("serif", Font.BOLD, 30));
        dgn1.setForeground(Color.BLACK);
        c.add(dgn1);
        msg = new JLabel();
        msg.setBounds(80, 210, 700, 40);
        msg.setText("YOUR BALANCE IS " + Deposite.balance + " IN YOUR ACCOUNT.");
        msg.setFont(new Font("serif", Font.BOLD, 28));
        msg.setForeground(Color.BLACK);
        c.add(msg);

        quit = new JButton();
        quit.setBounds(290, 350, 200, 35);
        quit.setText("QUIT");
        quit.setForeground(Color.WHITE);
        quit.setBackground(Color.BLACK);
        quit.setFont(new Font("serif", Font.BOLD, 20));
        quit.addActionListener(this);
        c.add(quit);

        screen.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == quit) {
            screen.setVisible(false);
            new Quit();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == back) {
            screen.setVisible(false);
            new SecondDisplay();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
