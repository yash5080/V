import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    private JTextField userText;
    private JPasswordField passwordText;
    private JButton loginButton, registerButton;
    private JComboBox<String> comboBox;

    Login() {
        setLayout(null);

        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("v.png"));
        Image image = icon.getImage().getScaledInstance(130, 130, Image.SCALE_SMOOTH);
        ImageIcon icon2 = new ImageIcon(image);
        JLabel label = new JLabel(icon2);
        label.setBounds(90, 110, 130, 130);
        add(label);

        JLabel label2 = new JLabel("Where VISION meets TRUST");
        label2.setBounds(40, 250, 400, 16);
        label2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        label2.setForeground(Color.WHITE);
        add(label2);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(390, 140, 90, 25);
        userLabel.setFont(new Font("Sans serif", Font.PLAIN, 18));
        userLabel.setForeground(Color.WHITE);
        add(userLabel);

        userText = new JTextField(20);
        userText.setBounds(490, 140, 165, 25);
        userText.setBackground(new Color(35,35,35));
        userText.setForeground(Color.WHITE);
        userText.setFont(new Font("Sans serif", Font.PLAIN, 18));
        userText.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
        add(userText);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(390, 210, 90, 25);
        passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setFont(new Font("Sans serif", Font.PLAIN, 18));
        add(passwordLabel);

        passwordText = new JPasswordField(20);
        passwordText.setBounds(490, 210, 165, 25);
        passwordText.setBackground(new Color(35,35,35));
        passwordText.setForeground(Color.WHITE);
        passwordText.setFont(new Font("Sans serif", Font.PLAIN, 18));
        passwordText.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
        add(passwordText);

        loginButton = new JButton("Login");
        loginButton.setBounds(490, 280, 80, 25);
        loginButton.setBackground(new Color(35,35,35));
        loginButton.setForeground(Color.WHITE);
        loginButton.addActionListener(this);
        add(loginButton);

        JLabel orLabel = new JLabel("or");
        orLabel.setBounds(520, 310, 20, 25);
        orLabel.setForeground(Color.WHITE);
        orLabel.setFont(new Font("Sans serif", Font.PLAIN, 14));
        add(orLabel);

        registerButton = new JButton("Register");
        registerButton.setBounds(480, 340, 100, 25);
        registerButton.setBackground(new Color(35,35,35));
        registerButton.setForeground(Color.WHITE);
        registerButton.addActionListener(this);
        add(registerButton);

        String[] str = {"Client", "Admin"};
        comboBox = new JComboBox<>(str);
        comboBox.setBounds(620, 40, 120, 20);
        comboBox.setBackground(new Color(35,35,35));
        comboBox.setForeground(Color.WHITE);
        add(comboBox);

        setUndecorated(true);

        JButton cross = new JButton("X");
        cross.setBackground(new Color(35,35,35));
        cross.setBounds(750,10,50,30);
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


        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(35,35,35));
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String username = userText.getText();
            String password = new String(passwordText.getPassword());
            if (comboBox.getSelectedItem().equals("Admin")) {
                handleLogin(username, password, "admin");

            } else if (comboBox.getSelectedItem().equals("Client")) {
                handleLogin1(username, password, "customer");
            }
        } else if (e.getSource() == registerButton) {
            dispose();
            new Signup();
        }
    }

//    private void handleLogin(String username, String password, String userType) {
//        try {
//            Conn conn = new Conn();
//            String query = "SELECT * FROM " + userType + " WHERE username = ? AND password = ?";
//            PreparedStatement pstmt = conn.c.prepareStatement(query);
//            pstmt.setString(1, username);
//            pstmt.setString(2, password);
//            ResultSet rs = pstmt.executeQuery();
//            if (rs.next()) {
//                JOptionPane.showMessageDialog(this, "Login successful!");
//            } else {
//                JOptionPane.showMessageDialog(this, "Invalid username or password.");
//            }
//        } catch (SQLException ep) {
//            ep.printStackTrace();
//            JOptionPane.showMessageDialog(this, "Error connecting to the database", "Error", JOptionPane.ERROR_MESSAGE);
//        }
//    }

    private void handleLogin(String username, String password, String userType) {
        try {
            Conn conn = new Conn();
            String query = "SELECT * FROM " + userType + " WHERE username = ? AND password = ?";
            PreparedStatement pstmt = conn.c.prepareStatement(query);
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            System.out.println("Executing query: " + pstmt.toString());  // Debugging line

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                System.out.println("User found: " + rs.getString("username"));  // Debugging line
                JOptionPane.showMessageDialog(this, "Login successful!");
                new BankAdminPage();
                setVisible(false);

            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password.");
            }

            rs.close();  // Always close the ResultSet
            pstmt.close();  // Always close the PreparedStatement
            conn.c.close();  // Always close the Connection
        } catch (SQLException ep) {
            ep.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error connecting to the database", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    private void handleLogin1(String username, String password, String userType) {
        try {
            Conn conn = new Conn();
            String query = "SELECT * FROM " + userType + " WHERE username = ? AND password = ?";
            PreparedStatement pstmt = conn.c.prepareStatement(query);
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            System.out.println("Executing query: " + pstmt.toString());  // Debugging line

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                System.out.println("User found: " + rs.getString("username"));  // Debugging line
                JOptionPane.showMessageDialog(this, "Login successful!");
                new ATM();

            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password.");
            }

            rs.close();  // Always close the ResultSet
            pstmt.close();  // Always close the PreparedStatement
            conn.c.close();  // Always close the Connection
        } catch (SQLException ep) {
            ep.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error connecting to the database", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }



    public static void main(String[] args) {
        new Login();
    }
}


