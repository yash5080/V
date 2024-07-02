import com.toedter.components.JTitlePanel;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class viewCustomers extends JFrame {

    private JPanel contentPanel; // Make contentPanel an instance variable

    public viewCustomers() {
        // Frame settings
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setUndecorated(true);

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
                System.exit(0);
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
        JButton updateCustomerButton = createStyledButton("Transfer Money", "path/to/icons/update_icon.png");
        JButton checkbalaceButton = createStyledButton("Check Balance", "path/to/icons/update_icon.png");
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
                showCustomerTable();
            }
        });

        addCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Signup();
            }
        });

        checkbalaceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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
                JOptionPane.showMessageDialog(null, "Update Customer button clicked");
            }
        });

        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Create a content panel
        contentPanel = new JPanel(new BorderLayout()); // Initialize with BorderLayout
        contentPanel.setBackground(new Color(35, 35, 35));

        // Add panels to the main panel
        mainPanel.add(sidePanel, BorderLayout.WEST);
        mainPanel.add(contentPanel, BorderLayout.CENTER);

        // Add the main panel to the frame
        add(mainPanel);

        // Make the frame visible
        setVisible(true);
    }

    private void showCustomerTable() {
        // Column names
        String[] columnNames = {"Sno","Name", "Address", "Mobile Number", "Gender", "Account Type", "Account Number"};



        // Create table with no data initially
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(model);
        getColorModel();

        // Style the table
        table.setBackground(new Color(35, 35, 35));
        table.setForeground(Color.WHITE);
        table.setFont(new Font("SansSerif", Font.PLAIN, 14));
        table.setRowHeight(20);
        table.setGridColor(new Color(255,255,255));



        // Center table content
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        // Add table to a scroll pane
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(500, 300));

        // Style the scroll pane
        scrollPane.setBackground(new Color(35, 35, 35));
        scrollPane.getViewport().setBackground(new Color(35, 35, 35));

        // Create a panel to add spacing at the top
        JPanel topSpacer = new JPanel();
        topSpacer.setBackground(new Color(35, 35, 35));
        topSpacer.setPreferredSize(new Dimension(500, 100));


        JLabel label = new JLabel("Customer Table");
        label.setForeground(Color.WHITE);
        label.setFont(new Font("SansSerif", Font.PLAIN, 24));
        topSpacer.add(label);


        // Clear the content panel and add the spacer and table
        contentPanel.removeAll();
        contentPanel.add(topSpacer, BorderLayout.NORTH);
        contentPanel.add(scrollPane, BorderLayout.CENTER);
        contentPanel.revalidate();
        contentPanel.repaint();

        // Fetch data from the database and populate the table
        fetchData(model);
    }

    private void fetchData(DefaultTableModel model) {

        try {
            Conn conn = new Conn();
            String query = "SELECT  Name, Address,Gender,Phone_Number,Account_Type,Account_Number FROM customer1";
            ResultSet rs = conn.s.executeQuery(query);
            int no = 1;

            while (rs.next()) {
                String gender = rs.getString("Gender");
                String Mobile_no = rs.getString("Phone_Number");
                String AccType = rs.getString("Account_Type");
                String AccNum = rs.getString("Account_Number");
                String name = rs.getString("Name");
                String address = rs.getString("Address");
                model.addRow(new Object[]{no,name, address, Mobile_no, gender, AccType, AccNum});
                no++;

            }

            rs.close();
            conn.s.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
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
