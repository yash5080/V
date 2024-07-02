import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

import static javax.swing.BorderFactory.createMatteBorder;

public class Application extends JFrame implements ActionListener,ItemListener{

    JLabel name,email;
    JTextField address,phno,city,state,city1,state1;
    JComboBox comboBox,actype1;
    String Username, name2;
    JDateChooser date;
    String password2;
    JButton Register;




    Application(String username ,String firstName, String lastName,String email1,String  password){
        setLayout(null);

        JLabel label2 = new JLabel("Additional Details");
        label2.setBounds(300, 20, 400, 50);
        label2.setFont(new Font("Times New Roman", Font.BOLD, 30));
        label2.setForeground(Color.WHITE); // Set text color for better visibility
        add(label2);

        JLabel label1 = new JLabel("Name: ");
        label1.setBounds(100, 120, 400, 50);
        label1.setFont(new Font("Sans serif", Font.BOLD, 20));
        label1.setForeground(Color.WHITE); // Set text color for better visibility
        add(label1);

        name = new JLabel();
        name.setFont(new Font("Sans serif", Font.PLAIN, 20));
        name.setBounds(210,125,400,40);
        name.setForeground(Color.WHITE);
        add(name);


        JLabel label4 = new JLabel("Email: ");
        label4.setBounds(100, 180, 400, 50);
        label4.setFont(new Font("Sans serif", Font.BOLD, 20));
        label4.setForeground(Color.WHITE);
        add(label4);

        email = new JLabel();
        email.setFont(new Font("Sans serif", Font.PLAIN, 18));
        email.setBounds(210,185,400,40);
        email.setForeground(Color.WHITE);
        add(email);



        JLabel label3 = new JLabel("Address: ");
        label3.setBounds(100, 360, 400, 50);
        label3.setFont(new Font("Sans serif", Font.BOLD, 20));
        label3.setForeground(Color.WHITE);
        add(label3);

        address = new JTextField(120);
        address.setBackground(new Color(35,35,35));
        address.setBorder(createMatteBorder(0,0,1,0,Color.WHITE));
        address.setForeground(Color.WHITE);
        address.setBounds(220,370,450,30);
        address.setFont(new Font("Sans serif",Font.PLAIN,18));
        add(address);

        JLabel label5 = new JLabel("Gender: ");
        label5.setBounds(100, 300, 400, 50);
        label5.setFont(new Font("Sans serif", Font.BOLD, 20));
        label5.setForeground(Color.WHITE);
        add(label5);

        String[] gender = {"Male", "Female","Other"};
        comboBox = new JComboBox(gender);
        comboBox.setBounds(220,320,150,30);
        comboBox.addItemListener(this);
        add(comboBox);

        JLabel label6 = new JLabel("Phone No: ");
        label6.setBounds(100, 240, 400, 50);
        label6.setFont(new Font("Sans serif", Font.BOLD, 20));
        label6.setForeground(Color.WHITE);
        add(label6);

        phno = new JTextField(10);
        phno.setBackground(new Color(35,35,35));
        phno.setBorder(createMatteBorder(0,0,1,0,Color.WHITE));
        phno.setForeground(Color.WHITE);
        phno.setBounds(220,250,150,30);
        phno.setFont(new Font("Sans serif",Font.PLAIN,18));
        add(phno);

        JLabel label7 = new JLabel("City: ");
        label7.setBounds(100, 420, 400, 50);
        label7.setFont(new Font("Sans serif", Font.BOLD, 20));
        label7.setForeground(Color.WHITE);
        add(label7);

        city = new JTextField(120);
        city.setBackground(new Color(35,35,35));
        city.setBorder(createMatteBorder(0,0,1,0,Color.WHITE));
        city.setForeground(Color.WHITE);
        city.setBounds(220,430,130,30);
        city.setFont(new Font("Sans serif",Font.PLAIN,18));
        add(city);

        JLabel label8 = new JLabel("State: ");
        label8.setBounds(380, 420, 400, 50);
        label8.setFont(new Font("Sans serif", Font.BOLD, 20));
        label8.setForeground(Color.WHITE);
        add(label8);

        state = new JTextField(120);
        state.setBackground(new Color(35,35,35));
        state.setBorder(createMatteBorder(0,0,1,0,Color.WHITE));
        state.setForeground(Color.WHITE);
        state.setBounds(500,430,180,30);
        state.setFont(new Font("Sans serif",Font.PLAIN,18));
        add(state);

        JLabel label9 = new JLabel("Zipcode: ");
        label9.setBounds(100, 480, 400, 50);
        label9.setFont(new Font("Sans serif", Font.BOLD, 20));
        label9.setForeground(Color.WHITE);
        add(label9);

        city1 = new JTextField(120);
        city1.setBackground(new Color(35,35,35));
        city1.setBorder(createMatteBorder(0,0,1,0,Color.WHITE));
        city1.setForeground(Color.WHITE);
        city1.setBounds(220,490,130,30);
        city1.setFont(new Font("Sans serif",Font.PLAIN,18));
        add(city1);

        JLabel label10 = new JLabel("Country: ");
        label10.setBounds(380, 480, 400, 50);
        label10.setFont(new Font("Sans serif", Font.BOLD, 20));
        label10.setForeground(Color.WHITE);
        add(label10);

        state1 = new JTextField(120);
        state1.setBackground(new Color(35,35,35));
        state1.setBorder(createMatteBorder(0,0,1,0,Color.WHITE));
        state1.setForeground(Color.WHITE);
        state1.setBounds(500,490,180,30);
        state1.setFont(new Font("Sans serif",Font.PLAIN,18));
        add(state1);

        JLabel label11 = new JLabel("Date of Birth: ");
        label11.setBounds(100, 540, 400, 50);
        label11.setFont(new Font("Sans serif", Font.BOLD, 20));
        label11.setForeground(Color.WHITE);
        add(label11);

        date = new JDateChooser();
        date.setBackground(new Color(35,35,35));
        date.setBorder(createMatteBorder(0,0,1,0,Color.WHITE));
        date.setForeground(Color.WHITE);
        date.setBounds(250,550,130,30);
        add(date);

        JLabel label12 = new JLabel("Account Type: ");
        label12.setBounds(100, 600, 400, 50);
        label12.setFont(new Font("Sans serif", Font.BOLD, 20));
        label12.setForeground(Color.WHITE);
        add(label12);

        String[] actype = {"Savings", "Current","Fixed Deposit","Recurring Deposit"};
        actype1 = new JComboBox(actype);
        actype1.setBounds(250,610,150,30);
        actype1.addItemListener(this);
        add(actype1);

        Register =  new JButton("Register");
        Register.setBackground(new Color(35,35,35));
        Register.setForeground(Color.WHITE);
        Register.addActionListener(this);
        Register.setFont(new Font("Sans serif",Font.PLAIN,18));
        Register.setBounds(370,700,130,30);
        add(Register);


        Username = username;
        name2 = firstName +" "+ lastName;
        name.setText(name2);
        email.setText(email1);

        password2 = password;

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
                System.exit(0);
            }
        });



        setSize(800, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(35,35,35));
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==Register) {

            String Name = name2;
            String email1 = email.getText();
            String address2 = address.getText();
            String gender1 = (String) comboBox.getSelectedItem();
            String city2 = city.getText();
            String zip = city1.getText();
            String state2 = state.getText();
            String country = state1.getText();
            String dob = ((JTextField) date.getDateEditor().getUiComponent()).getText();
            String password1 = password2;
            String phone = phno.getText();
            String actype3 = (String) actype1.getSelectedItem();


            try {
                Conn conn = new Conn();
                String query = "INSERT INTO customer1 (Name,  Email, Address, Gender, City,State,ZipCode,Phone_Number,Country,Date_of_Birth,Account_Type,Account_no,Password) VALUES ('" +
                        Name + "','" + email1 + "','" + address2 + "','" + gender1 + "','" + city2 + "','"+ state2+"','"+zip+"','"+phone+"','"+country+"','"+dob+"','"+actype3+"','"+ 2+"','"+password1+ "')";
                conn.s.executeUpdate(query);

                String q = "CREATE TABLE `" + phone + "` (Account_Number varchar(20), Pin varchar(20), Type varchar(20), Date varchar(20), Amount varchar(20))";

                conn.s.execute(q);

                setVisible(false);
                conn.close();
            } catch (SQLException ep) {
                ep.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error connecting to the database", "Error", JOptionPane.ERROR_MESSAGE);
            }

            new Application2(phone);

        }

        if(e.getSource() == comboBox){
            if(comboBox.getSelectedItem().toString().equals("Male")){
                System.out.println(comboBox.getSelectedItem().toString());
            } else if(comboBox.getSelectedItem().toString().equals("Female")){
                System.out.println(comboBox.getSelectedItem().toString());
            } else if(comboBox.getSelectedItem().toString().equals("Other")){
                System.out.println(comboBox.getSelectedItem().toString());
            }

        }
        else if(e.getSource() == actype1){
            if(actype1.getSelectedItem().toString().equals("Savings")){
                System.out.println(actype1.getSelectedItem().toString());
            } else if(actype1.getSelectedItem().toString().equals("Current")){
                System.out.println(actype1.getSelectedItem().toString());
            } else if(actype1.getSelectedItem().toString().equals("Fixed Deposit")){
                System.out.println(actype1.getSelectedItem().toString());
            } else if(actype1.getSelectedItem().toString().equals("Recurring Deposit")){
                System.out.println(actype1.getSelectedItem().toString());
            }
        }

    }

    @Override
    public void itemStateChanged(ItemEvent e) {

    }


}
