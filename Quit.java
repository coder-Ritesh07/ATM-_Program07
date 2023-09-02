
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class Quit implements ActionListener, MouseListener {
    private JFrame jf;
    private Container c;
    private JLabel label, dgn, dgn1, dgn2, dgn3, sbi, atm, logo, back;
    private JButton exit;

    public Quit() {
        jf = new JFrame();
        jf.setSize(800, 500);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setTitle("QUIT");
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
        logo.setBounds(55, 25, 100, 100);
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

        dgn2 = new JLabel();
        dgn2.setBounds(165, 63, 500, 30);
        dgn2.setText("======================================");
        dgn2.setFont(new Font("null", Font.BOLD, 20));
        dgn2.setForeground(Color.BLACK);
        c.add(dgn2);

        atm = new JLabel();
        atm.setBounds(305, 80, 250, 50);
        atm.setText("ATM ");
        atm.setFont(new Font("serif", Font.BOLD, 40));
        atm.setForeground(Color.BLACK);
        c.add(atm);

        dgn3 = new JLabel();
        dgn3.setBounds(305, 110, 150, 40);
        dgn3.setText("========");
        dgn3.setFont(new Font("null", Font.BOLD, 20));
        dgn3.setForeground(Color.BLACK);
        c.add(dgn3);

        dgn = new JLabel();
        dgn.setBounds(75, 190, 700, 30);
        dgn.setText("=====================================================");
        dgn.setForeground(Color.BLACK);
        dgn.setFont(new Font("null", Font.BOLD, 20));
        c.add(dgn);

        label = new JLabel();
        label.setBounds(75, 205, 700, 50);
        label.setText("THANK YOU VISIT AGAIN");
        label.setFont(new Font("serif", Font.BOLD, 50));
        label.setForeground(Color.BLACK);
        c.add(label);

        dgn1 = new JLabel();
        dgn1.setBounds(75, 245, 700, 30);
        dgn1.setText("======================================================");
        dgn1.setForeground(Color.BLACK);
        dgn1.setFont(new Font("null", Font.BOLD, 20));
        c.add(dgn1);

        exit = new JButton();
        exit.setBounds(280, 350, 230, 35);
        exit.setText("EXIT");
        exit.setFont(new Font("serif", Font.BOLD, 20));
        exit.setBackground(Color.BLACK);
        exit.setForeground(Color.WHITE);
        exit.addActionListener(this);
        c.add(exit);
        jf.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exit) {
            jf.setVisible(false);
            System.exit(0);
        }
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

}
