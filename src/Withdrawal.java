import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Withdrawal extends JFrame {

    JTextField acno, pin, amount, username;

    public Withdrawal() {
        // Frame settings
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setBackground(new Color(35, 35, 35)); // Change background color
        setLayout(null); // Set layout to null for absolute positioning

        // Set background color for content pane
        getContentPane().setBackground(new Color(35, 35, 35));

        JButton cross = new JButton("X");
        cross.setBackground(new Color(35, 35, 35)); // Match background color
        cross.setBounds(950, 0, 50, 30);
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

        // Create main content
        JLabel label = new JLabel(" Withdraw Funds ");
        label.setBounds(410, 30, 300, 30);
        label.setFont(new Font("Tahoma", Font.BOLD, 28));
        label.setForeground(Color.WHITE);
        add(label);

        JLabel label1 = new JLabel("Account Number:");
        label1.setBounds(150, 150, 250, 30);
        label1.setFont(new Font("SansSerif", Font.BOLD, 20));
        label1.setForeground(Color.WHITE);
        add(label1);

        acno = new JTextField(120);
        acno.setBackground(new Color(35, 35, 35)); // Match background color
        acno.setForeground(Color.WHITE);
        acno.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        acno.setBounds(400, 150, 200, 30);
        acno.setFont(new Font("SansSerif", Font.PLAIN, 18));
        add(acno);

        JLabel label2 = new JLabel("Account Pin:");
        label2.setBounds(150, 250, 300, 30);
        label2.setFont(new Font("SansSerif", Font.BOLD, 20));
        label2.setForeground(Color.WHITE);
        add(label2);

        pin = new JTextField(120);
        pin.setBackground(new Color(35, 35, 35)); // Match background color
        pin.setForeground(Color.WHITE);
        pin.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        pin.setBounds(400, 250, 200, 30);
        pin.setFont(new Font("SansSerif", Font.PLAIN, 18));
        add(pin);

        JLabel label3 = new JLabel("Enter Amount:");
        label3.setBounds(150, 350, 300, 30);
        label3.setFont(new Font("SansSerif", Font.BOLD, 20));
        label3.setForeground(Color.WHITE);
        add(label3);

        JLabel label4 = new JLabel("(in rupees)");
        label4.setBounds(170, 370, 300, 30);
        label4.setFont(new Font("SansSerif", Font.PLAIN, 16));
        label4.setForeground(Color.WHITE);
        add(label4);

        amount = new JTextField(120);
        amount.setBackground(new Color(35, 35, 35)); // Match background color
        amount.setForeground(Color.WHITE);
        amount.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        amount.setBounds(400, 350, 200, 30);
        amount.setFont(new Font("SansSerif", Font.PLAIN, 18));
        add(amount);

        JLabel label7 = new JLabel("Phone Number:");
        label7.setBounds(150, 430, 300, 30);
        label7.setFont(new Font("SansSerif", Font.BOLD, 20));
        label7.setForeground(Color.WHITE);
        add(label7);

        username = new JTextField(120);
        username.setBackground(new Color(35, 35, 35)); // Match background color
        username.setForeground(Color.WHITE);
        username.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        username.setBounds(400, 430, 200, 30);
        username.setFont(new Font("SansSerif", Font.PLAIN, 18));
        add(username);

        JButton deposit = new JButton("Withdraw");
        deposit.setBackground(new Color(43, 43, 43));
        deposit.setForeground(Color.WHITE);
        deposit.setFont(new Font("SansSerif", Font.BOLD, 16));
        deposit.setFocusPainted(false);
        deposit.setBounds(450, 500, 100, 40);
        deposit.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        deposit.setHorizontalAlignment(SwingConstants.CENTER);
        add(deposit);
        deposit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String accountNumber = acno.getText();
                String accountPin = pin.getText();
                String depositAmount = amount.getText();
                String userName = username.getText();
                String type = "Withdrawal";

                long currentTime = System.currentTimeMillis();
                Date date1 = new Date(currentTime);
                String date = date1.toString();

                if (depositAmount.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter Withdraw amount");
                } else if (validateAccount(accountNumber, accountPin)) {
                    try {
                        Conn conn = new Conn();
                        String query = "INSERT INTO `" + userName + "` (Account_Number, Pin, Type, Date, Amount) VALUES (?, ?, ?, ?, ?)";
                        PreparedStatement pst = conn.c.prepareStatement(query);
                        pst.setString(1, accountNumber);
                        pst.setString(2, accountPin);
                        pst.setString(3, type);
                        pst.setString(4, date);
                        pst.setString(5, depositAmount);
                        pst.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Withdrawal successful");
                        setVisible(false);
                        conn.close();
                    } catch (SQLException ep) {
                        ep.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Error connecting to the database", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid account number or pin", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Create and add icon
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/withdraw.png"));
        Image image = icon.getImage().getScaledInstance(180, 180, Image.SCALE_SMOOTH);
        ImageIcon icon2 = new ImageIcon(image);
        JLabel label5 = new JLabel(icon2);
        label5.setBounds(750, 160, 180, 180);
        add(label5);

        setVisible(true);
    }

    private boolean validateAccount(String accountNumber, String accountPin) {
        try {
            Conn conn = new Conn();
            String query = "SELECT Account_Number, Account_Pin FROM customer1 WHERE Account_Number = ? AND Account_Pin = ?";
            PreparedStatement pst = conn.c.prepareStatement(query);
            pst.setString(1, accountNumber);
            pst.setString(2, accountPin);
            ResultSet rs = pst.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error connecting to the database", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public static void main(String[] args) {
    }


}
