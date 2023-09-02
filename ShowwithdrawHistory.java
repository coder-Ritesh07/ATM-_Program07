
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShowwithdrawHistory implements ActionListener {
    JFrame screen;
    Container c;
    JLabel label, atm, dgn, dgn1, logo, msg;
    JButton exit, Menu;

    public ShowwithdrawHistory(boolean b) {
        screen = new JFrame();
        screen.setSize(800, 450);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screen.setTitle("DEPOSITE");
        screen.setLayout(null);
        screen.setResizable(false);
        screen.setLocationRelativeTo(null);

        c = screen.getContentPane();
        c.setBackground(Color.CYAN);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icon//Sbi.png"));
        logo = new JLabel();
        logo.setBounds(60, 25, 100, 100);
        Image i = i1.getImage();
        Image i2 = i.getScaledInstance(logo.getWidth(), logo.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        logo.setIcon(i3);
        c.add(logo);

        label = new JLabel();
        label.setBounds(165, 20, 450, 60);
        label.setFont(new Font("serif", Font.BOLD, 40));
        label.setForeground(Color.BLACK);
        label.setText("STATE BANK OF INDIA");
        c.add(label);

        dgn = new JLabel();
        dgn.setBounds(165, 63, 500, 20);
        dgn.setText("=====================================");
        dgn.setForeground(Color.BLACK);
        dgn.setFont(new Font("null", Font.BOLD, 20));
        c.add(dgn);

        atm = new JLabel();
        atm.setBounds(305, 80, 150, 40);
        atm.setText("ATM");
        atm.setFont(new Font("serif", Font.BOLD, 50));
        atm.setForeground(Color.BLACK);
        c.add(atm);

        dgn1 = new JLabel();
        dgn1.setBounds(305, 120, 150, 30);
        dgn1.setText("===========");
        dgn1.setFont(new Font("null", Font.BOLD, 20));
        dgn1.setForeground(Color.BLACK);
        c.add(dgn1);

        JLabel msg = new JLabel();
        msg.setBounds(70, 200, 700, 30);
        if (b == true) {
            msg.setText("AMOUNT " + Withdraw.b + " HAS BEEN WITHDRAW IN YOUR ACCOUNT");
        } else {
            msg.setText("AMOUNT " + Withdraw.b + " CAN't BE WITHDRAWN");
        }
        msg.setFont(new Font("serif", Font.BOLD, 21));
        msg.setForeground(Color.BLACK);
        c.add(msg);

        exit = new JButton();
        exit.setBounds(430, 280, 240, 35);
        exit.setText("EXIT");
        exit.setForeground(Color.WHITE);
        exit.setBackground(Color.BLACK);
        exit.setFont(new Font("serif", Font.BOLD, 20));
        exit.addActionListener(this);
        c.add(exit);

        Menu = new JButton();
        Menu.setBounds(100, 280, 240, 35);
        Menu.setText("GO TO MAIN MENU");
        Menu.setBackground(Color.BLACK);
        Menu.setForeground(Color.WHITE);
        Menu.setFont(new Font("serif", Font.BOLD, 20));
        Menu.addActionListener(this);
        c.add(Menu);
        screen.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exit) {
            System.exit(0);
        }
        if (e.getSource() == Menu) {
            screen.setVisible(false);
            new SecondDisplay();
        }
    }
}
