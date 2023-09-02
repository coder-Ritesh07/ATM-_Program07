import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;

public class TransactionHistory implements ActionListener, MouseListener {
    private JFrame jf;
    private Container c;
    private JLabel sbi, atm, dgn, dgn1, logo, back;
    static JTextArea textArea;
    public JTextField jt;
    private JButton show;
    public static ArrayList history = new ArrayList();

    public TransactionHistory() {
        jf = new JFrame();
        jf.setSize(800, 600);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setTitle("TRANSFER");
        jf.setLayout(null);
        jf.setLocationRelativeTo(null);
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

        atm = new JLabel();
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

        textArea = new JTextArea();
        textArea.setBounds(0, 180, 800, 335);
        textArea.setFont(new Font("serif", Font.BOLD, 25));
        textArea.setBackground(Color.cyan);
        textArea.setEditable(false);
        c.add(textArea);

        jt = new JTextField();
        jt.setBounds(0, 143, 800, 35);
        jt.setText("ID\tTYPE\tAMOUNT       TOTAL_BALANCE      STATUS");
        jt.setFont(new Font("serif", Font.BOLD, 22));
        jt.setEditable(false);
        c.add(jt);

        show = new JButton("SHOW HISTORY");
        show.setBounds(585, 105, 200, 35);
        show.setBackground(Color.BLACK);
        show.setForeground(Color.WHITE);
        show.setFont(new Font("serif", Font.BOLD, 20));
        show.addActionListener(this);
        c.add(show);

        jf.setVisible(true);
    }

    public static void setHistory(int transactionID, String transType, double transAmount, double acbalance,
            String transStatus) {
        ArrayList store = new ArrayList();
        store.add(transactionID);
        store.add(transType);
        store.add(transAmount);
        store.add(acbalance);
        store.add(transStatus);

        history.add(store);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            if (e.getSource() == show) {
                show.setVisible(false);
                Iterator it = history.iterator();
                while (it.hasNext()) {
                    ArrayList array = (ArrayList) it.next();
                    Iterator it2 = array.iterator();
                    while (it2.hasNext()) {
                        String data = it2.next().toString();

                        if (data.equals("Successful") || data.equals("Failed")) {
                            textArea.setText(textArea.getText().concat(data
                                    + "\n--------------------------------------------------------------------------------------------------\n"));
                        } else {
                            textArea.setText(textArea.getText().concat(data + "\t"));
                        }

                    }
                }
            }

            if (textArea.getText().isEmpty()) {
                JOptionPane.showMessageDialog(jf, "NO RECORDS FOUNDS", "WARNING", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(jf, "UNKNOW ERROR ACCOUR", "WARNING", JOptionPane.WARNING_MESSAGE);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == back) {
            jf.setVisible(false);
            new SecondDisplay();
        }
    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {

    }

}
