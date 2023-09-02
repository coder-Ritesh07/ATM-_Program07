import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Transfer implements MouseListener, ActionListener {
    private static JFrame jf;
    private Container c;
    private JLabel sbi, atm, dgn, dgn1, logo, back, mob, recv, name, ifsc, amt, n91;
    public static JTextField usernum, revact, revname, revifsc, trnsamt;
    private JButton next, clr;
    public static double amount;

    public Transfer() {
        jf = new JFrame();
        jf.setSize(800, 550);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setTitle("TRANSFER");
        jf.setLayout(null);
        jf.setLocationRelativeTo(null);
        jf.setResizable(false);
        c = jf.getContentPane();
        c.setBackground(Color.CYAN);

        sbi = new JLabel();
        sbi.setBounds(165, 20, 450, 60);
        sbi.setText("STATE BANK OF INDIA");
        sbi.setFont(new Font("serif", Font.BOLD, 40));
        sbi.setForeground(Color.BLACK);
        c.add(sbi);

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

        dgn = new JLabel();
        dgn.setBounds(165, 63, 500, 30);
        dgn.setText("======================================");
        dgn.setFont(new Font("null", Font.BOLD, 20));
        dgn.setForeground(Color.BLACK);
        c.add(dgn);

        atm = new JLabel();//
        atm.setBounds(305, 80, 200, 60);
        atm.setText("ATM ");
        atm.setFont(new Font("serif", Font.BOLD, 50));
        atm.setForeground(Color.BLACK);
        c.add(atm);

        dgn1 = new JLabel();
        dgn1.setBounds(305, 120, 150, 30);
        dgn1.setText("==========");
        dgn1.setFont(new Font("null", Font.BOLD, 20));
        dgn1.setForeground(Color.BLACK);
        c.add(dgn1);

        mob = new JLabel();
        mob.setBounds(60, 150, 350, 50);
        mob.setText("ENTER YOUR MOBILE NUMBER :-");
        mob.setFont(new Font("serif", Font.BOLD, 20));
        mob.setForeground(Color.BLACK);
        c.add(mob);

        n91 = new JLabel();
        n91.setBounds(430, 160, 50, 30);
        n91.setText("+91");
        n91.setFont(new Font("serif", Font.BOLD, 20));
        n91.setForeground(Color.BLACK);
        c.add(n91);

        usernum = new JTextField();
        usernum.setBounds(465, 160, 290, 30);
        usernum.setFont(new Font("serif", Font.BOLD, 20));
        usernum.setForeground(Color.BLACK);
        c.add(usernum);

        recv = new JLabel();
        recv.setBounds(60, 200, 370, 50);
        recv.setText("ACCOUNT NUMBER OF RECEIVER :-");
        recv.setFont(new Font("serif", Font.BOLD, 20));
        recv.setForeground(Color.black);
        c.add(recv);

        revact = new JTextField();
        revact.setBounds(465, 210, 290, 30);
        revact.setFont(new Font("serif", Font.BOLD, 20));
        revact.setForeground(Color.BLACK);
        c.add(revact);

        name = new JLabel();
        name.setBounds(60, 250, 420, 50);
        name.setFont(new Font("serif", Font.BOLD, 20));
        name.setText("HOLDER NAME OF RECEIVER :-");
        name.setForeground(Color.BLACK);
        c.add(name);

        revname = new JTextField();
        revname.setBounds(465, 260, 290, 30);
        revname.setForeground(Color.BLACK);
        revname.setFont(new Font("serif", Font.BOLD, 20));
        c.add(revname);

        ifsc = new JLabel();
        ifsc.setBounds(60, 300, 420, 50);
        ifsc.setText("ENTER ACCOUNT NUMBER IFSC CODE :-");
        ifsc.setFont(new Font("serif", Font.BOLD, 20));
        ifsc.setForeground(Color.BLACK);
        c.add(ifsc);

        revifsc = new JTextField();
        revifsc.setBounds(465, 310, 290, 30);
        revifsc.setFont(new Font("serif", Font.BOLD, 20));
        revifsc.setForeground(Color.BLACK);
        c.add(revifsc);

        amt = new JLabel();
        amt.setBounds(60, 350, 420, 50);
        amt.setText("ENTER YOUR AMOUNT TO TRANSFER :-");
        amt.setForeground(Color.BLACK);
        amt.setFont(new Font("serif", Font.BOLD, 20));
        c.add(amt);

        trnsamt = new JTextField();
        trnsamt.setBounds(465, 360, 290, 30);
        trnsamt.setForeground(Color.BLACK);
        trnsamt.setFont(new Font("serif", Font.BOLD, 20));
        c.add(trnsamt);

        next = new JButton();
        next.setBounds(450, 430, 230, 35);
        next.setText("NEXT");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("serif", Font.BOLD, 20));
        next.addActionListener(this);
        c.add(next);

        clr = new JButton();
        clr.setBounds(120, 430, 230, 35);
        clr.setText("CLEAR");
        clr.setForeground(Color.WHITE);
        clr.setBackground(Color.BLACK);
        clr.setFont(new Font("serif", Font.BOLD, 20));
        clr.addActionListener(this);
        c.add(clr);

        jf.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == back) {
            jf.setVisible(false);
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == next) {
            boolean b = numChecker();
            boolean c = accountChecker();
            boolean d = nameChecker();
            boolean e1 = amtChecker();
            if (b == true && c == true && d == true && e1 == true) {
                String s = trnsamt.getText();
                amount = Double.parseDouble(s);
                if (amount <= Deposite.balance) {
                    Deposite.balance = Deposite.balance - amount;
                    Data.transactionID = Data.transactionID + 1;
                    int id = Data.transactionID;
                    double deposite = Deposite.balance;
                    TransactionHistory.setHistory(id, "Transaction", Transfer.amount, deposite, "Successful");
                    jf.setVisible(false);
                    new TransferHistory(true);
                } else {
                    JOptionPane.showMessageDialog(jf, "INSUFFICIENT BALANCE", "WARNING", JOptionPane.WARNING_MESSAGE);
                    Data.transactionID = Data.transactionID + 1;
                    int id = Data.transactionID;
                    double deposite = Deposite.balance;
                    TransactionHistory.setHistory(id, "Transaction", Transfer.amount, deposite, "Failed");
                    jf.setVisible(false);
                    new TransferHistory(false);
                }

            } else {
                JOptionPane.showMessageDialog(jf, "PLEASE INPUT VALID INFORMATION AND TRY AGAIN", "WARNING",
                        JOptionPane.WARNING_MESSAGE);
            }
        }

        if (e.getSource() == clr) {
            usernum.setText("");
            revact.setText("");
            revifsc.setText("");
            revname.setText("");
            trnsamt.setText("");
        }
    }

    public boolean numChecker() {
        String digitPatten = "^\\d{10}$";
        String s = usernum.getText();
        boolean b = s.matches(digitPatten);
        return b;
    }

    public boolean accountChecker() {
        String digitPatten = "^\\d{12}$";
        String s1 = revact.getText();
        boolean c = s1.matches(digitPatten);
        return c;

    }

    public boolean nameChecker() {
        String namePatten = "^[A-Za-z\\s'-]+$";
        String s2 = revname.getText();
        boolean d = s2.matches(namePatten);
        return d;

    }

    public boolean amtChecker() {
        String digitPatten = "\\d*";
        String s3 = trnsamt.getText();
        boolean e = s3.matches(digitPatten);
        return e;
    }
}
