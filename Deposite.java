
import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Deposite implements ActionListener, MouseListener {
    private JFrame screen;
    private Container c;
    private JLabel label, atm, dgn, dgn1, logo, amt, back;
    public JTextField amtjf;
    private JButton dpsit;
    private static String s;
    public static double balance = 0, l;

    public Deposite() {

        screen = new JFrame();
        screen.setSize(800, 500);
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
        label.setFont(new Font("Serif", Font.BOLD, 40));
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
        dgn1.setBounds(305, 110, 150, 40);
        dgn1.setText("=======");
        dgn1.setFont(new Font("null", Font.BOLD, 30));
        dgn1.setForeground(Color.BLACK);
        c.add(dgn1);

        amt = new JLabel();
        amt.setBounds(60, 205, 450, 30);
        amt.setText("ENTER YOUR DEPOSITE AMOUNT :-");
        amt.setFont(new Font("Serif", Font.BOLD, 25));
        amt.setForeground(Color.BLACK);
        c.add(amt);

        amtjf = new JTextField();
        amtjf.setBounds(500, 205, 200, 30);
        amtjf.setFont(new Font("serif", Font.BOLD, 23));
        c.add(amtjf);

        dpsit = new JButton();
        dpsit.setBounds(250, 320, 250, 35);
        dpsit.setText("DEPOSITE");
        dpsit.setBackground(Color.BLACK);
        dpsit.setForeground(Color.WHITE);
        dpsit.setFont(new Font("serif", Font.BOLD, 28));
        dpsit.addActionListener(this);
        c.add(dpsit);
        screen.setVisible(true);
    }

    public void diposite() {

        try {
            s = amtjf.getText();
            l = Double.parseDouble(s);
            if (s.isEmpty() == false) {
                balance = balance + l;
                Data.transactionID = Data.transactionID + 1;
                int id = Data.transactionID;
                TransactionHistory.setHistory(id, "Deposite", Deposite.l, Deposite.balance, "Successful");
                screen.setVisible(false);
                new ShowHistory();
            }
        } catch (Exception e) {
            amtjf.setBorder(new LineBorder(Color.RED));
            JOptionPane.showMessageDialog(screen, "INPUT ONLY NUMBERS", "WARNINNG", JOptionPane.WARNING_MESSAGE);
            screen.setVisible(false);
            new SecondDisplay();
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == dpsit) {
            diposite();
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
