import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TransferHistory implements ActionListener {
    JFrame screen;
    Container c;
    JLabel label, atm, dgn, dgn1, logo, msg;
    JButton quit, Menu;
    static int rev = 0;

    public TransferHistory(boolean b) {

        screen = new JFrame();
        screen.setSize(850, 450);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screen.setTitle("TRANSACTION HISTORY");
        screen.setLayout(null);
        screen.setResizable(false);
        screen.setLocationRelativeTo(null);

        c = screen.getContentPane();
        c.setBackground(Color.CYAN);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icon//Sbi.png"));
        logo = new JLabel();
        logo.setBounds(80, 25, 100, 100);
        Image i = i1.getImage();
        Image i2 = i.getScaledInstance(logo.getWidth(), logo.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        logo.setIcon(i3);
        c.add(logo);

        label = new JLabel();
        label.setBounds(185, 20, 450, 60);
        label.setFont(new Font("serif", Font.BOLD, 40));
        label.setForeground(Color.BLACK);
        label.setText("STATE BANK OF INDIA");
        c.add(label);

        dgn = new JLabel();
        dgn.setBounds(185, 63, 500, 20);
        dgn.setText("======================================");
        dgn.setFont(new Font("null", Font.BOLD, 20));
        dgn.setForeground(Color.BLACK);
        c.add(dgn);

        atm = new JLabel();
        atm.setBounds(325, 80, 200, 50);
        atm.setText("ATM");
        atm.setFont(new Font("serif", Font.BOLD, 50));
        atm.setForeground(Color.BLACK);
        c.add(atm);

        dgn1 = new JLabel();
        dgn1.setBounds(325, 110, 150, 40);
        dgn1.setText("==========");
        dgn1.setFont(new Font("null", Font.BOLD, 20));
        dgn1.setForeground(Color.BLACK);
        c.add(dgn1);
        show();
        String s = Transfer.trnsamt.getText();
        Double d = Double.parseDouble(s);
        msg = new JLabel();
        msg.setBounds(20, 200, 800, 30);
        if (b == true) {
            msg.setText("An Amount of " + d + " has been Suceesfully Sent To Account Number xxxxxxxx" + rev);
        } else {
            msg.setText("Your Transfer Amount of " + d + " is Failed Please Try Again");
        }

        msg.setFont(new Font("serif", Font.BOLD, 21));
        msg.setForeground(Color.BLACK);
        c.add(msg);

        quit = new JButton();
        quit.setBounds(450, 290, 250, 35);
        quit.setText("QUIT");
        quit.setForeground(Color.white);
        quit.setBackground(Color.BLACK);
        quit.setFont(new Font("serif", Font.BOLD, 20));
        quit.addActionListener(this);
        c.add(quit);

        Menu = new JButton();
        Menu.setBounds(120, 290, 250, 35);
        Menu.setText("GO TO MAIN MENU");
        Menu.setForeground(Color.WHITE);
        Menu.setBackground(Color.BLACK);
        Menu.setFont(new Font("serif", Font.BOLD, 20));
        Menu.addActionListener(this);
        c.add(Menu);
        screen.setVisible(true);
    }

    public static void show() {
        String s = Transfer.revact.getText();
        long l = Long.parseLong(s);
        int count = 0;
        long sum = 0;
        while (count < 4) {
            sum = (sum * 10) + l % 10;
            l = l / 10;
            count++;
        }
        int store = (int) sum;
        while (store > 0) {
            rev = (rev * 10) + store % 10;
            store = store / 10;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == quit) {
            screen.setVisible(false);
            new Quit();
        }
        if (e.getSource() == Menu) {
            screen.setVisible(false);
            new SecondDisplay();
        }
    }
}
