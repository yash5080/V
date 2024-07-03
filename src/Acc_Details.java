import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.Random;

import static javax.swing.BorderFactory.createMatteBorder;

public class Acc_Details extends JFrame implements ActionListener, ItemListener {
    JLabel accpin, accnumber;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JButton button;
    String Phno;

    Acc_Details(String phno) {
        setLayout(null);

        JLabel label1 = new JLabel("Account Details");
        label1.setBounds(280, 20, 400, 50);
        label1.setFont(new Font("Times New Roman", Font.BOLD, 30));
        label1.setForeground(Color.WHITE);
        add(label1);

        JLabel label2 = new JLabel("Account Number: ");
        label2.setBounds(70, 100, 200, 50);
        label2.setFont(new Font("Sans serif", Font.BOLD, 22));
        label2.setForeground(Color.WHITE); // Set text color for better visibility
        add(label2);

        accnumber = new JLabel(generateRandomNumber(), SwingConstants.CENTER);
        accnumber.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        accnumber.setBounds(230, 103, 200, 50);
        accnumber.setForeground(Color.WHITE);
        add(accnumber);

        JLabel label3 = new JLabel("Account Pin: ");
        label3.setBounds(70, 160, 200, 50);
        label3.setFont(new Font("Sans serif", Font.BOLD, 25));
        label3.setForeground(Color.WHITE);
        add(label3);

        accpin = new JLabel(generateRandomPin(), SwingConstants.LEADING);
        accpin.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        accpin.setBounds(240, 163, 200, 50);
        accpin.setForeground(Color.WHITE);
        add(accpin);

        JLabel label4 = new JLabel("Services Required: ");
        label4.setBounds(70, 220, 300, 50);
        label4.setFont(new Font("Sans serif", Font.BOLD, 25));
        label4.setForeground(Color.WHITE);
        add(label4);

        c1 = new JCheckBox("ATM Card");
        c1.setBackground(new Color(35, 35, 35));
        c1.setForeground(Color.WHITE);
        c1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        c1.setBounds(70, 270, 200, 50);
        add(c1);

        c2 = new JCheckBox("Net Banking");
        c2.setBackground(new Color(35, 35, 35));
        c2.setForeground(Color.WHITE);
        c2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        c2.setBounds(290, 270, 200, 50);
        add(c2);

        c3 = new JCheckBox("Email and SMS");
        c3.setBackground(new Color(35, 35, 35));
        c3.setForeground(Color.WHITE);
        c3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        c3.setBounds(290, 330, 200, 50);
        add(c3);

        c4 = new JCheckBox("Cheque Book");
        c4.setBackground(new Color(35, 35, 35));
        c4.setForeground(Color.WHITE);
        c4.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        c4.setBounds(70, 330, 200, 50);
        add(c4);

        c5 = new JCheckBox("E-Statement");
        c5.setBackground(new Color(35, 35, 35));
        c5.setForeground(Color.WHITE);
        c5.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        c5.setBounds(70, 390, 200, 50);
        add(c5);

        c6 = new JCheckBox("Updates");
        c6.setBackground(new Color(35, 35, 35));
        c6.setForeground(Color.WHITE);
        c6.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        c6.setBounds(290, 390, 200, 50);
        add(c6);

        c7 = new JCheckBox("I hereby declare that the above entered details are correct and agree on sharing this data");
        c7.setBackground(new Color(35, 35, 35));
        c7.setForeground(Color.WHITE);
        c7.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        c7.setBounds(70, 450, 800, 30);
        add(c7);

        button = new JButton("Done");
        button.setBackground(new Color(35, 35, 35));
        button.setForeground(Color.WHITE);
        button.addActionListener(this);
        button.setBounds(320, 510, 100, 30);
        add(button);

        setUndecorated(true);

        JButton cross = new JButton("X");
        cross.setBackground(new Color(35, 35, 35));
        cross.setBounds(750, 0, 50, 30);
        cross.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        cross.setForeground(Color.WHITE);
        cross.setFont(new Font("SansSerif", Font.BOLD, 20));
        cross.setFocusable(false);
        cross.setFocusPainted(false);
        add(cross);
        cross.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        Phno = phno;
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(35, 35, 35));
        setVisible(true);
    }

    private String generateRandomNumber() {
        Random rand = new Random();
        long number = (long) (Math.pow(10, 10) + rand.nextDouble() * 9 * Math.pow(10, 10));
        return String.format("%011d", number);
    }

    private String generateRandomPin() {
        Random rand = new Random();
        int pin = rand.nextInt(9000) + 1000;
        return String.valueOf(pin);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (c7.isSelected()) {
            if (e.getSource() == button) {
                String accnum = accnumber.getText();
                String acc_pin = accpin.getText();
                String Atm = c1.isSelected() ? "Yes" : "No";
                String net = c2.isSelected() ? "Yes" : "No";
                String sms = c3.isSelected() ? "Yes" : "No";
                String cheque = c4.isSelected() ? "Yes" : "No";
                String estate = c5.isSelected() ? "Yes" : "No";
                String updates = c6.isSelected() ? "Yes" : "No";

                try {
                    Conn conn = new Conn();
                    String query = "UPDATE customer1 SET Account_Number = '" + accnum + "', Account_Pin = '" + acc_pin +
                            "', ATM_Card = '" + Atm + "', Cheque_Book = '" + cheque + "', Net_Banking = '" + net +
                            "', Email_and_SMS = '" + sms + "', E_Statement = '" + estate + "', Updates = '" + updates +
                            "' WHERE Phone_Number = '" + Phno + "'";
                    conn.s.executeUpdate(query);

                    setVisible(false);
                    new ATM();
                } catch (SQLException ep) {
                    ep.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Error connecting to the database", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            if (e.getSource() == button) {
                JOptionPane.showMessageDialog(this, "Check the Declaration field");
            }
        }
    }

    @Override
    public void itemStateChanged(ItemEvent ex) {
        // Implement if needed
    }



}
