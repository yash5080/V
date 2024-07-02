import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ATM extends JFrame {

    private JTextField transactionIdField;
    private JTextField amountField;
    private JTextField dateField;
    private JTextField descriptionField;
    String username;

    public ATM() {
        // Frame settings
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setUndecorated(true);


        JLabel title = new JLabel("ATM");
        title.setFont(new Font("Tahoma", Font.BOLD, 20));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        add(title, BorderLayout.NORTH);


        JButton cross = new JButton("X");
        cross.setBackground(new Color(35, 35, 35));
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
                setVisible(false);
            }
        });

        // Create a main panel with a border layout
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(35, 35, 35));

        // Create a side panel for navigation
        JPanel sidePanel = new JPanel(new GridBagLayout());
        sidePanel.setBackground(new Color(43, 43, 43));
        sidePanel.setPreferredSize(new Dimension(220, 0));

        // GridBag constraints for side panel
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 20;
        gbc.insets = new Insets(10, 0, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;


        // Add buttons with icons to side panel
        JButton viewTransactionsButton = createStyledButton("Deposit", "icons/view-transactions.png");
        JButton withTransactionsButton = createStyledButton("Withdrawal", "icons/view-transactions.png");
        JButton transferTransactionButton = createStyledButton("Transfer Money", "icons/update-transaction.png");
        JButton balanceTransactionButton = createStyledButton("Balance Enquiry", "icons/update-transaction.png");
        JButton pinTransactionButton = createStyledButton("Pin Change", "icons/update-transaction.png");
        JButton estateTransactionButton = createStyledButton("Mini Statement", "icons/update-transaction.png");
        JButton logoutButton = createStyledButton("Logout", "path/to/icons/logout_icon.png");


        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("v.png"));
        Image image = icon.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        ImageIcon icon2 = new ImageIcon(image);
        JLabel label = new JLabel(icon2);
        label.setBounds(50, 50, 80, 80);
        add(label);

        sidePanel.add(viewTransactionsButton, gbc);
        gbc.gridy++;
        sidePanel.add(withTransactionsButton, gbc);
        gbc.gridy++;
        sidePanel.add(transferTransactionButton, gbc);
        gbc.gridy++;
        sidePanel.add(balanceTransactionButton, gbc);
        gbc.gridy++;
        sidePanel.add(pinTransactionButton, gbc);
        gbc.gridy++;
        sidePanel.add(estateTransactionButton, gbc);
        gbc.gridy++;
        sidePanel.add(logoutButton, gbc);

        // Add action listeners for buttons


        withTransactionsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Withdrawal();
            }
        });

        transferTransactionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TransferMoney();

            }
        });


        pinTransactionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Pinchange();

            }
        });

        estateTransactionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        viewTransactionsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Code to view transactions
                new Deposit();
            }
        });

        balanceTransactionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Balance();
                // Code to update transaction
            }
        });

        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Create a content panel
        JPanel contentPanel = new JPanel(new GridBagLayout()); // Use GridBagLayout for the form
        contentPanel.setBackground(new Color(35, 35, 35));


        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 0, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;


        // Add form fields
        GridBagConstraints formGbc = new GridBagConstraints();
        formGbc.insets = new Insets(10, 10, 10, 10);
        formGbc.gridx = 0;
        formGbc.gridy = 0;


        ImageIcon icon5 = new ImageIcon(ClassLoader.getSystemResource("icons/deposit.png"));
        Image image2 = icon5.getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
        ImageIcon icon4 = new ImageIcon(image2);
        JButton Deposit = new JButton(icon4);
        Deposit.setBounds(300, 150, 150, 150);
        Deposit.setBackground(new Color(35, 35, 35));
        Deposit.setFocusPainted(false);
        Deposit.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        Deposit.setHorizontalAlignment(SwingConstants.CENTER);
        add(Deposit);


        ImageIcon icon7 = new ImageIcon(ClassLoader.getSystemResource("icons/withdraw.png"));
        Image image5 = icon7.getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
        ImageIcon icon8 = new ImageIcon(image5);
        JButton Withdrawal = new JButton(icon8);
        Withdrawal.setBounds(550, 150, 150, 150);
        Withdrawal.setBackground(new Color(35, 35, 35));
        Withdrawal.setFocusPainted(false);
        Withdrawal.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        Withdrawal.setHorizontalAlignment(SwingConstants.CENTER);
        add(Withdrawal);

        ImageIcon icon9 = new ImageIcon(ClassLoader.getSystemResource("icons/data-transfer.png"));
        Image image6 = icon9.getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
        ImageIcon icon0 = new ImageIcon(image6);
        JButton transfer = new JButton(icon0);
        transfer.setBounds(800, 150, 150, 150);
        transfer.setBackground(new Color(35, 35, 35));
        transfer.setFocusPainted(false);
        transfer.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        transfer.setHorizontalAlignment(SwingConstants.CENTER);
        add(transfer);

        ImageIcon icon11 = new ImageIcon(ClassLoader.getSystemResource("icons/pin-code.png"));
        Image image7 = icon11.getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
        ImageIcon icon12 = new ImageIcon(image7);
        JButton pin = new JButton(icon12);
        pin.setBounds(550, 350, 150, 150);
        pin.setBackground(new Color(35, 35, 35));
        pin.setFocusPainted(false);
        pin.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        pin.setHorizontalAlignment(SwingConstants.CENTER);
        add(pin);

        ImageIcon icon13 = new ImageIcon(ClassLoader.getSystemResource("icons/bill.png"));
        Image image8 = icon13.getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
        ImageIcon icon14 = new ImageIcon(image8);
        JButton bill = new JButton(icon14);
        bill.setBounds(800, 350, 150, 150);
        bill.setBackground(new Color(35, 35, 35));
        bill.setFocusPainted(false);
        bill.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        bill.setHorizontalAlignment(SwingConstants.CENTER);
        add(bill);

        ImageIcon icon15 = new ImageIcon(ClassLoader.getSystemResource("icons/money-stack.png"));
        Image image9 = icon15.getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
        ImageIcon icon16 = new ImageIcon(image9);
        JButton money = new JButton(icon16);
        money.setBounds(300, 350, 150, 150);
        money.setBackground(new Color(35, 35, 35));
        money.setFocusPainted(false);
        money.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        money.setHorizontalAlignment(SwingConstants.CENTER);
        add(money);


        JButton back = new JButton("Back");
        back.setBounds(550, 600, 100, 30);
        back.setBackground(new Color(35, 35, 35));
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Tahoma", Font.BOLD, 20));
        back.setFocusPainted(false);
        back.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        back.setHorizontalAlignment(SwingConstants.CENTER);
        add(back);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);

            }
        });


        money.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new Balance();
            }
        });

        bill.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        pin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new Pinchange();
            }
        });

        Deposit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Deposit();

            }
        });

        Withdrawal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new Withdrawal();

            }
        });

        transfer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TransferMoney();

            }
        });

        createStyledLabel("Deposit").setBounds(340, 300, 100, 30);
        createStyledLabel("Withdrawal").setBounds(570, 300, 100, 30);
        createStyledLabel("Transfer Money").setBounds(820, 300, 200, 30);
        createStyledLabel("Balance Enquiry").setBounds(310, 500, 200, 30);
        createStyledLabel("Pin Change").setBounds(570, 500, 200, 30);
        createStyledLabel("E-Statement").setBounds(820, 500, 100, 30);

        JLabel labe22 = new JLabel("Enjoy our Services!");
        labe22.setForeground(Color.WHITE);
        labe22.setFont(new Font("Tahoma", Font.BOLD, 26));
        labe22.setBounds(420, 50, 300, 30);
        add(labe22);


//        contentPanel.add(createStyledLabel("Transaction ID:"), formGbc);
//        formGbc.gridx = 1;
//        transactionIdField = createStyledTextField();
//        contentPanel.add(transactionIdField, formGbc);
//
//        formGbc.gridx = 0;
//        formGbc.gridy++;
//        contentPanel.add(createStyledLabel("Amount:"), formGbc);
//        formGbc.gridx = 1;
//        amountField = createStyledTextField();
//        contentPanel.add(amountField, formGbc);
//
//        formGbc.gridx = 0;
//        formGbc.gridy++;
//        contentPanel.add(createStyledLabel("Date:"), formGbc);
//        formGbc.gridx = 1;
//        dateField = createStyledTextField();
//        contentPanel.add(dateField, formGbc);
//
//        formGbc.gridx = 0;
//        formGbc.gridy++;
//        contentPanel.add(createStyledLabel("Description:"), formGbc);
//        formGbc.gridx = 1;
//        descriptionField = createStyledTextField();
//        contentPanel.add(descriptionField, formGbc);
//
//        formGbc.gridx = 1;
//        formGbc.gridy++;
//        JButton updateButton = new JButton("Update");
//        updateButton.setBackground(new Color(43, 43, 43));
//        updateButton.setForeground(Color.WHITE);
//        updateButton.setFont(new Font("SansSerif", Font.BOLD, 16));
//        updateButton.setFocusPainted(false);
//        updateButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
//        contentPanel.add(updateButton, formGbc);
//
//        updateButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                updateTransaction();
//            }
//        });

        // Add panels to the main panel
        mainPanel.add(sidePanel, BorderLayout.WEST);
        mainPanel.add(contentPanel, BorderLayout.CENTER);

        // Add the main panel to the frame
        add(mainPanel);

        // Make the frame visible
        setVisible(true);
    }

    private JLabel createStyledLabel(String text) {
        JLabel label = new JLabel(text);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Oswald", Font.BOLD, 17));
        add(label);
        return label;
    }

    private JTextField createStyledTextField() {
        JTextField textField = new JTextField(20);
        textField.setBackground(new Color(43, 43, 43));
        textField.setForeground(Color.WHITE);
        textField.setFont(new Font("SansSerif", Font.PLAIN, 14));
        textField.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        return textField;
    }

    private void updateTransaction() {
        String transactionId = transactionIdField.getText();
        String amount = amountField.getText();
        String date = dateField.getText();
        String description = descriptionField.getText();

        String url = "jdbc:mysql://localhost:3306/your_database_name"; // Replace with your database URL
        String user = "your_username"; // Replace with your database username
        String password = "your_password"; // Replace with your database password

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            String query = "UPDATE transactions SET amount = ?, date = ?, description = ? WHERE transaction_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, amount);
            pstmt.setString(2, date);
            pstmt.setString(3, description);
            pstmt.setString(4, transactionId);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Transaction updated successfully.");
            } else {
                JOptionPane.showMessageDialog(this, "Transaction ID not found.");
            }

            pstmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error updating transaction: " + e.getMessage());
        }
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


