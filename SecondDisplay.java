import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SecondDisplay implements ActionListener {
    private JFrame jf;
    private Container c;
    private JLabel sbi, atm, dgn, dgn1, logo;
    private JButton ts, withdraw, deposite, transfer, quit, checkbal;

    public SecondDisplay() {
        jf = new JFrame();
        jf.setSize(800, 500);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setTitle("Automated Teller Machine");
        jf.setLayout(null);
        jf.setLocationRelativeTo(null);
        jf.setResizable(false);
        c = jf.getContentPane();
        c.setBackground(Color.CYAN);

        sbi = new JLabel();
        sbi.setBounds(175, 20, 450, 60);
        sbi.setText("STATE BANK OF INDIA");
        sbi.setFont(new Font("Serif", Font.BOLD, 40));
        sbi.setForeground(Color.BLACK);
        c.add(sbi);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icon//Sbi.png"));
        logo = new JLabel();
        logo.setBounds(70, 25, 100, 100);
        Image i = i1.getImage();
        Image i2 = i.getScaledInstance(logo.getWidth(), logo.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        logo.setIcon(i3);
        c.add(logo);

        dgn = new JLabel();
        dgn.setBounds(175, 63, 500, 30);
        dgn.setText("=====================================");
        dgn.setFont(new Font("null", Font.BOLD, 20));
        dgn.setForeground(Color.BLACK);
        c.add(dgn);

        atm = new JLabel();
        atm.setBounds(315, 80, 250, 50);
        atm.setText("ATM ");
        atm.setFont(new Font("Serif", Font.BOLD, 50));
        atm.setForeground(Color.BLACK);
        c.add(atm);

        dgn1 = new JLabel();
        dgn1.setBounds(315, 120, 150, 30);
        dgn1.setText("=========");
        dgn1.setFont(new Font("null", Font.BOLD, 20));
        dgn1.setForeground(Color.BLACK);
        c.add(dgn1);

        ts = new JButton();
        ts.setBounds(50, 180, 300, 40);
        ts.setText("TRANSACTIONS HISTORY");
        ts.setBackground(Color.BLACK);
        ts.setForeground(Color.WHITE);
        ts.setFont(new Font("Serif", Font.PLAIN, 20));
        ts.addActionListener(this);
        c.add(ts);

        withdraw = new JButton();
        withdraw.setBounds(450, 180, 300, 40);
        withdraw.setText("WITHDRAW");
        withdraw.setBackground(Color.BLACK);
        withdraw.setForeground(Color.WHITE);
        withdraw.setFont(new Font("Serif", Font.BOLD, 20));
        withdraw.addActionListener(this);
        c.add(withdraw);

        deposite = new JButton();
        deposite.setBounds(50, 280, 300, 40);
        deposite.setText("DEPOSITE");
        deposite.setBackground(Color.BLACK);
        deposite.setForeground(Color.WHITE);
        deposite.setFont(new Font("Serif", Font.BOLD, 20));
        deposite.addActionListener(this);
        c.add(deposite);

        transfer = new JButton();
        transfer.setBounds(450, 280, 300, 40);
        transfer.setText("TRANSFER");
        transfer.setForeground(Color.WHITE);
        transfer.setBackground(Color.BLACK);
        transfer.setFont(new Font("Serif", Font.BOLD, 20));
        transfer.addActionListener(this);
        c.add(transfer);

        quit = new JButton();
        quit.setBounds(420, 370, 300, 40);
        quit.setText("QUIT");
        quit.setBackground(Color.BLACK);
        quit.setForeground(Color.WHITE);
        quit.setFont(new Font("Serif", Font.BOLD, 20));
        quit.addActionListener(this);
        c.add(quit);

        checkbal = new JButton();
        checkbal.setBounds(60, 370, 300, 40);
        checkbal.setText("CHECK BALANCE");
        checkbal.setBackground(Color.BLACK);
        checkbal.setForeground(Color.WHITE);
        checkbal.setFont(new Font("Serif", Font.BOLD, 20));
        checkbal.addActionListener(this);
        c.add(checkbal);
        jf.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == quit) {
            jf.setVisible(false);
            new Quit();
        }
        if (e.getSource() == transfer) {
            jf.setVisible(false);
            new Transfer();
        }
        if (e.getSource() == deposite) {
            jf.setVisible(false);
            new Deposite();
        }
        if (e.getSource() == checkbal) {
            jf.setVisible(false);
            new Balance();
        }
        if (e.getSource() == withdraw) {
            jf.setVisible(false);
            new Withdraw();
        }
        if (e.getSource() == ts) {
            jf.setVisible(false);
            new TransactionHistory();
        }
    }

}
