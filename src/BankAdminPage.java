import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankAdminPage extends JFrame {


    public BankAdminPage() {
        // Frame settings

        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setUndecorated(true);

        JButton cross = new JButton("X");
        cross.setBackground(new Color(35,35,35));
        cross.setBounds(950,0,50,30);
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


        // Create a main panel with a border layout
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(35, 35, 35));

        // Create a title panel
//        JPanel titlePanel = new JPanel();
//        titlePanel.setBackground(new Color(35, 35, 35));
//        JLabel titleLabel = new JLabel(" Admin Dashboard");
//        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 28));
//        titleLabel.setForeground(Color.WHITE);
//        titlePanel.add(titleLabel);


        // Create a side panel for navigation
        JPanel sidePanel = new JPanel(new GridBagLayout());
        sidePanel.setBackground(new Color(43, 43, 43));
        sidePanel.setPreferredSize(new Dimension(220, 0));

        // GridBag constraints for side panel
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 0, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;


        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("v.png"));
        Image image = icon.getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
        ImageIcon icon2 = new ImageIcon(image);
        JLabel label = new JLabel(icon2);
        label.setBounds(70, 70, 90, 90);
        add(label);


        // Add buttons with icons to side panel
        JButton viewCustomersButton = createStyledButton("View Customers", "v.png");
        JButton addCustomerButton = createStyledButton("Add Customer", "icons/add-user.png");
        JButton deleteCustomerButton = createStyledButton("Delete Customer", "path/to/icons/delete_icon.png");
        JButton updateCustomerButton = createStyledButton("ATM", "path/to/icons/update_icon.png");

        JButton logoutButton = createStyledButton("Logout", "path/to/icons/logout_icon.png");

        sidePanel.add(viewCustomersButton, gbc);
        gbc.gridy++;
        sidePanel.add(addCustomerButton, gbc);
        gbc.gridy++;
        sidePanel.add(deleteCustomerButton, gbc);
        gbc.gridy++;
        sidePanel.add(updateCustomerButton, gbc);
        gbc.gridy++;
        sidePanel.add(logoutButton, gbc);

        // Add action listeners for buttons
        viewCustomersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new viewCustomers();
                setVisible(false);

            }
        });

        addCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Signup();

            }
        });



        deleteCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Delete Customer button clicked");
            }
        });

        updateCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ATM();

            }
        });

        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Create a content panel
        JPanel contentPanel = new JPanel();
        contentPanel.setBackground(new Color(35, 35, 35));

        // Add panels to the main panel
//        mainPanel.add(titlePanel, BorderLayout.NORTH);
        mainPanel.add(sidePanel, BorderLayout.WEST);
        mainPanel.add(contentPanel, BorderLayout.CENTER);

        // Add the main panel to the frame
        add(mainPanel);

        // Make the frame visible
        setVisible(true);
    }

    private JButton createStyledButton(String text, String iconPath) {
        JButton button = new JButton(text, new ImageIcon(iconPath));
        button.setBackground(new Color(43, 43, 43));
        button.setForeground(Color.WHITE);
        button.setFont(new Font("SansSerif", Font.BOLD, 16));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        button.setHorizontalAlignment(SwingConstants.LEFT);
        return button;
    }


}
