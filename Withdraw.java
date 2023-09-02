import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Withdraw implements ActionListener, MouseListener {
    private JFrame screen;
    private Container c;
    private JLabel label, atm, dgn, dgn1, logo, amt, back;
    public JTextField amTextField;
    private JButton withdraw;
    public static double b;

    public Withdraw() {
        screen = new JFrame();
        screen.setSize(800, 450);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screen.setTitle("Automated Teller Machine");
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
        dgn.setText("=====================================");
        dgn.setFont(new Font("null", Font.BOLD, 20));
        dgn.setForeground(Color.BLACK);
        c.add(dgn);

        atm = new JLabel();
        atm.setBounds(305, 80, 200, 50);
        atm.setText("ATM");
        atm.setFont(new Font("serif", Font.BOLD, 50));
        atm.setForeground(Color.BLACK);
        c.add(atm);

        dgn1 = new JLabel();
        dgn1.setBounds(305, 110, 250, 40);
        dgn1.setText("==========");
        dgn1.setFont(new Font("null", Font.BOLD, 20));
        dgn1.setForeground(Color.BLACK);
        c.add(dgn1);

        amt = new JLabel();
        amt.setText("ENTER YOUR WITHDRAW AMOUNT :-");
        amt.setBounds(50, 180, 700, 40);
        amt.setFont(new Font("serif", Font.BOLD, 25));
        amt.setForeground(Color.black);
        c.add(amt);

        amTextField = new JTextField();
        amTextField.setBounds(520, 185, 210, 30);
        amTextField.setFont(new Font("serif", Font.BOLD, 20));
        amTextField.setForeground(Color.BLACK);
        c.add(amTextField);

        withdraw = new JButton();
        withdraw.setBounds(270, 280, 250, 35);
        withdraw.setText("WITHDRAW");
        withdraw.setBackground(Color.BLACK);
        withdraw.setForeground(Color.WHITE);
        withdraw.setFont(new Font("serif", Font.BOLD, 20));
        withdraw.addActionListener(this);
        c.add(withdraw);
        screen.setVisible(true);
    }

    public boolean withdraw(double b) {

        if (b <= Deposite.balance) {
            Deposite.balance = Deposite.balance - b;
            return true;
        } else {
            JOptionPane.showMessageDialog(screen, "INSUFFICIENT BALANCE", "WARNING", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == withdraw) {
            try {
                String s = amTextField.getText();
                b = Double.parseDouble(s);
                if (withdraw(b)) {
                    Data.transactionID = Data.transactionID + 1;
                    int id = Data.transactionID;
                    double withdraw = Withdraw.b;
                    double deposite = Deposite.balance;
                    TransactionHistory.setHistory(id, "Withdraw", withdraw, deposite, "Successful");
                    screen.setVisible(false);
                    new ShowwithdrawHistory(true);
                } else {
                    Data.transactionID = Data.transactionID + 1;
                    int id = Data.transactionID;
                    double withdraw = Withdraw.b;
                    double deposite = Deposite.balance;
                    TransactionHistory.setHistory(id, "Withdraw", withdraw, deposite, "Failed");
                    screen.setVisible(false);
                    new ShowwithdrawHistory(false);
                }

            } catch (Exception ex) {
                amTextField.setBorder(new LineBorder(Color.RED));
                JOptionPane.showMessageDialog(screen, "INPUT ONLY NUMBERS", "WARNING", JOptionPane.WARNING_MESSAGE);
            }

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