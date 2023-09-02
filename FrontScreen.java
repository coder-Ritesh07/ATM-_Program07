import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class FrontScreen implements ActionListener {

    private JFrame screen;
    private Container c;
    private JLabel label, atm, dgn, dgn1, pin, id, logo, inst;
    private JTextField idField;
    private JPasswordField pinField;
    private JButton next, clr;

    public FrontScreen() {
        screen = new JFrame();
        screen.setSize(800, 500);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screen.setTitle("Automated Teller Machine");
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
        label.setFont(new Font("Serif", Font.BOLD, 40));
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
        atm.setBounds(305, 80, 250, 50);
        atm.setText("ATM");
        atm.setFont(new Font("Serif", Font.BOLD, 50));
        atm.setForeground(Color.BLACK);
        c.add(atm);

        dgn1 = new JLabel();
        dgn1.setBounds(305, 110, 150, 40);
        dgn1.setText("=========");
        dgn1.setFont(new Font("null", Font.BOLD, 20));
        dgn1.setForeground(Color.BLACK);
        c.add(dgn1);

        id = new JLabel();
        id.setBounds(130, 180, 350, 30);
        id.setText("ENTER YOUR ID :-");
        id.setFont(new Font("Serif", Font.BOLD, 30));
        id.setForeground(Color.BLACK);
        c.add(id);

        idField = new JTextField();
        idField.setBounds(430, 185, 200, 35);
        idField.setFont(new Font("Serif", Font.BOLD, 25));
        c.add(idField);

        pin = new JLabel();
        pin.setBounds(130, 250, 350, 30);
        pin.setText("ENTER YOUR PIN :-");
        pin.setFont(new Font("Serif", Font.BOLD, 30));
        pin.setForeground(Color.BLACK);
        c.add(pin);

        pinField = new JPasswordField();
        pinField.setBounds(430, 255, 200, 35);
        pinField.setFont(new Font("Serif", Font.BOLD, 25));
        c.add(pinField);

        inst = new JLabel();
        inst.setText("NOTE :-ID Example-User123,123User AND Pin=4 Digit");
        inst.setBounds(130, 300, 450, 30);
        inst.setFont(new Font("serif", Font.BOLD, 18));
        inst.setOpaque(true);
        inst.setBackground(Color.CYAN);
        inst.setForeground(Color.black);
        c.add(inst);

        next = new JButton();
        next.setBounds(430, 350, 150, 40);
        next.setText("NEXT");
        next.setBackground(Color.black);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        next.setFont(new Font("Serif", Font.BOLD, 20));
        c.add(next);

        clr = new JButton();
        clr.setBounds(180, 350, 150, 40);
        clr.setText("CLEAR");
        clr.setBackground(Color.BLACK);
        clr.setForeground(Color.WHITE);
        clr.addActionListener(this);
        clr.setFont(new Font("Serif", Font.BOLD, 20));
        c.add(clr);
        screen.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == next) {
            boolean b = pinCheckler();
            boolean c = userIdChecker();
            if (b == true && c == true) {
                screen.setVisible(false);
                new SecondDisplay();
            } else {
                JOptionPane.showMessageDialog(screen, "INPUT YOUR PIN AND ID PROPERLY", "WARNING",
                        JOptionPane.WARNING_MESSAGE);
            }
        }
        if (e.getSource() == clr) {
            pinField.setText("");
            idField.setText("");
        }
    }

    public boolean pinCheckler() {
        String digitPatten = "^\\d{4}$";
        String s = pinField.getText();
        boolean b = s.matches(digitPatten);
        return b;
    }

    public boolean userIdChecker() {
        String userPatten = "^[a-zA-Z0-9]{4,10}$";
        String s1 = idField.getText();
        boolean c = s1.matches(userPatten);
        return c;
    }
}
