import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class Signup extends JFrame implements ActionListener {

    // Define the components outside the constructor to access them in actionPerformed
    private final JTextField nameText;
    private final JTextField emailText;
    private final JTextField userText;
    private final JTextField nameText1;
    private final JPasswordField passwordText;
    private final JPasswordField repasswordText;
    private final JButton loginButton;
    private final JButton registerButton;

    Signup() {
        setLayout(null);

        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("v.png"));
        Image image = icon.getImage().getScaledInstance(130, 130, Image.SCALE_SMOOTH);
        ImageIcon icon2 = new ImageIcon(image);
        JLabel label = new JLabel(icon2);
        label.setBounds(90, 210, 130, 130);
        add(label);

        JLabel label2 = new JLabel("Where VISION meets TRUST");
        label2.setBounds(40, 350, 400, 16);
        label2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        label2.setForeground(Color.WHITE); // Set text color for better visibility
        add(label2);

        // Top label
        JLabel topLabel = new JLabel("Create your account!");
        topLabel.setBounds(430, 50, 200, 40);
        topLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        topLabel.setForeground(Color.WHITE);
        add(topLabel);

        // Firstname label
        JLabel nameLabel = new JLabel("First Name:");
        nameLabel.setBounds(390, 120, 120, 25);
        nameLabel.setFont(new Font("Sans serif", Font.PLAIN, 18));
        nameLabel.setForeground(Color.WHITE);
        add(nameLabel);

        // firstname text field
        nameText = new JTextField(50);
        nameText.setBounds(510, 120, 165, 25);
        nameText.setBackground(new Color(35,35,35));
        nameText.setForeground(Color.WHITE);
        nameText.setFont(new Font("Sans serif", Font.PLAIN, 18));
        nameText.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
        add(nameText);

        JLabel nameLabel1 = new JLabel("Last Name:");
        nameLabel1.setBounds(390, 190, 120, 25);
        nameLabel1.setFont(new Font("Sans serif", Font.PLAIN, 18));
        nameLabel1.setForeground(Color.WHITE);
        add(nameLabel1);

        // lastname text field
        nameText1 = new JTextField(50);
        nameText1.setBounds(510, 190, 165, 25);
        nameText1.setBackground(new Color(35,35,35));
        nameText1.setForeground(Color.WHITE);
        nameText1.setFont(new Font("Sans serif", Font.PLAIN, 18));
        nameText1.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
        add(nameText1);

        // Email label
        JLabel emailLabel = new JLabel("E Mail:");
        emailLabel.setBounds(390, 260, 120, 25);
        emailLabel.setFont(new Font("Sans serif", Font.PLAIN, 18));
        emailLabel.setForeground(Color.WHITE);
        add(emailLabel);

        // Email text field
        emailText = new JTextField(80);
        emailText.setBounds(510, 260, 165, 25);
        emailText.setBackground(new Color(35,35,35));
        emailText.setForeground(Color.WHITE);
        emailText.setFont(new Font("Sans serif", Font.PLAIN, 18));
        emailText.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
        add(emailText);

        // Username label
        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(390, 330, 120, 25);
        userLabel.setFont(new Font("Sans serif", Font.PLAIN, 18));
        userLabel.setForeground(Color.WHITE);
        add(userLabel);

        // Username text field
        userText = new JTextField(20);
        userText.setBounds(510, 330, 165, 25);
        userText.setBackground(new Color(35,35,35));
        userText.setForeground(Color.WHITE);
        userText.setFont(new Font("Sans serif", Font.PLAIN, 18));
        userText.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
        add(userText);

        // Password label
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(390, 400, 120, 25);
        passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setFont(new Font("Sans serif", Font.PLAIN, 18));
        add(passwordLabel);

        // Password text field
        passwordText = new JPasswordField(20);
        passwordText.setBounds(510, 400, 165, 25);
        passwordText.setBackground(new Color(35,35,35));
        passwordText.setForeground(Color.WHITE);
        passwordText.setFont(new Font("Sans serif", Font.PLAIN, 18));
        passwordText.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
        add(passwordText);

        // Repeat Password label
        JLabel repasswordLabel = new JLabel("Repeat:");
        repasswordLabel.setBounds(390, 460, 120, 25);
        repasswordLabel.setForeground(Color.WHITE);
        repasswordLabel.setFont(new Font("Sans serif", Font.PLAIN, 18));
        add(repasswordLabel);

        // Repeat Password text field
        repasswordText = new JPasswordField(20);
        repasswordText.setBounds(510, 460, 165, 25);
        repasswordText.setBackground(new Color(35,35,35));
        repasswordText.setForeground(Color.WHITE);
        repasswordText.setFont(new Font("Sans serif", Font.PLAIN, 18));
        repasswordText.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
        add(repasswordText);

        // Signup button
        loginButton = new JButton("SignUp");
        loginButton.setBounds(510, 510, 80, 25);
        loginButton.setBackground(new Color(35,35,35));
        loginButton.setForeground(Color.WHITE);
        loginButton.addActionListener(this);
        add(loginButton);

        JLabel orLabel = new JLabel("or");
        orLabel.setBounds(545, 540, 20, 25);
        orLabel.setForeground(Color.WHITE);
        orLabel.setFont(new Font("Sans serif", Font.PLAIN, 14));
        add(orLabel);

        registerButton = new JButton("Login");
        registerButton.setBounds(510, 570, 80, 25);
        registerButton.setBackground(new Color(35,35,35));
        registerButton.setForeground(Color.WHITE);
        registerButton.addActionListener(this);
        add(registerButton);

        setUndecorated(true);

        JButton cross = new JButton("X");
        cross.setBackground(new Color(35,35,35));
        cross.setBounds(750,0,50,30);
        cross.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        cross.setForeground(Color.WHITE);
        cross.setFont(new Font("SansSerif", Font.BOLD, 20));
        cross.setFocusable(false);
        cross.setFocusPainted(false);
        add(cross);
        cross.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });


        setSize(800, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(35,35,35));
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == loginButton) {
            if (String.valueOf(passwordText.getPassword()).equals(String.valueOf(repasswordText.getPassword()))) {
                String firstName = nameText.getText();
                String lastName = nameText1.getText();
                String username = userText.getText();
                String email = emailText.getText();
                String password = String.valueOf(passwordText.getPassword());

                try {
                    Conn conn = new Conn();
                    String query = "INSERT INTO customer (FirstName, LastName, Email, Username, Password) VALUES ('" +
                            firstName + "','" + lastName + "','" + email + "','" + username + "','" + password + "')";
                    conn.s.executeUpdate(query);
                    setVisible(false);
                    new Application(username,firstName,lastName,email,password);
                } catch (SQLException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Error connecting to the database", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Passwords do not match", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (ae.getSource() == registerButton) {
            dispose();
            new Login();
        }
    }

    public static void main(String[] args) {
        new Signup();
    }
}
