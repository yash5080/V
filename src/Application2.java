import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;

import static javax.swing.BorderFactory.createMatteBorder;

public class Application2 extends JFrame implements ActionListener,ItemListener {

    JComboBox actype1,actype2,actype3,actype4,actype5;
    JTextField aa,income,pan;
    JRadioButton button,button2 ;
    JButton register;
    ButtonGroup grp;
    String phno;

    Application2(String Phno){
        setLayout(null);

        JLabel label1 = new JLabel("Additional Details");
        label1.setBounds(220, 20, 400, 50);
        label1.setFont(new Font("Times New Roman", Font.BOLD, 30));
        label1.setForeground(Color.WHITE);
        add(label1);

        JLabel label2 = new JLabel("Religion: ");
        label2.setBounds(110, 120, 400, 50);
        label2.setFont(new Font("Sans serif", Font.BOLD, 20));
        label2.setForeground(Color.WHITE); // Set text color for better visibility
        add(label2);

        String[] actype = {"Hindu", "Christian","Muslim","Sikh","Jain","Budhist"};
        actype1 = new JComboBox(actype);
        actype1.setBounds(260,130,180,30);
        actype1.addItemListener((ItemListener) this);
        add(actype1);

        JLabel label3 = new JLabel("Category: ");
        label3.setBounds(110, 180, 400, 50);
        label3.setFont(new Font("Sans serif", Font.BOLD, 20));
        label3.setForeground(Color.WHITE);
        add(label3);

        String[] ctype = {"General", "OBC","SC","ST"};
        actype2 = new JComboBox(ctype);
        actype2.setBounds(260,190,180,30);
        actype2.addItemListener((ItemListener) this);
        add(actype2);

        JLabel label4 = new JLabel("Occupation: ");
        label4.setBounds(110, 240, 400, 50);
        label4.setFont(new Font("Sans serif", Font.BOLD, 20));
        label4.setForeground(Color.WHITE);
        add(label4);

        String[] ctype1 = {"Teacher", "Student","Government Employee","Private Job"};
        actype3 = new JComboBox(ctype1);
        actype3.setBounds(260,250,180,30);
        actype3.addItemListener((ItemListener) this);
        add(actype3);

        JLabel label5 = new JLabel("Income: ");
        label5.setBounds(110, 300, 400, 50);
        label5.setFont(new Font("Sans serif", Font.BOLD, 20));
        label5.setForeground(Color.WHITE);
        add(label5);

        income = new JTextField(120);
        income.setBackground(new Color(35,35,35));
        income.setBorder(createMatteBorder(0,0,1,0,Color.WHITE));
        income.setForeground(Color.WHITE);
        income.setBounds(260,310,180,30);
        income.setFont(new Font("Sans seif",Font.PLAIN,18));
        add(income);

        JLabel label6 = new JLabel("PAN no: ");
        label6.setBounds(110, 360, 400, 50);
        label6.setFont(new Font("Sans serif", Font.BOLD, 20));
        label6.setForeground(Color.WHITE);
        add(label6);

        pan = new JTextField(120);
        pan.setBackground(new Color(35,35,35));
        pan.setBorder(createMatteBorder(0,0,1,0,Color.WHITE));
        pan.setForeground(Color.WHITE);
        pan.setBounds(260,360,180,30);
        pan.setFont(new Font("Sans serif",Font.PLAIN,18));
        add(pan);

        JLabel label7 = new JLabel("Aadhar no: ");
        label7.setBounds(110, 420, 400, 50);
        label7.setFont(new Font("Sans serif", Font.BOLD, 20));
        label7.setForeground(Color.WHITE);
        add(label7);


        aa = new JTextField(120);
        aa.setBackground(new Color(35,35,35));
        aa.setBorder(createMatteBorder(0,0,1,0,Color.WHITE));
        aa.setForeground(Color.WHITE);
        aa.setBounds(260,420,180,30);
        aa.setFont(new Font("Sans serif",Font.PLAIN,18));
        add(aa);

        JLabel label8 = new JLabel("Senior Citizen: ");
        label8.setBounds(110, 480, 400, 50);
        label8.setFont(new Font("Sans serif", Font.BOLD, 20));
        label8.setForeground(Color.WHITE);
        add(label8);


        button = new JRadioButton("Yes");
        button.setBackground(new Color(35,35,35));
        button.setBorder(createMatteBorder(0,0,1,0,Color.WHITE));
        button.setForeground(Color.WHITE);
        button.setBounds(265,495,50,30);
        button.addItemListener((ItemListener) this);
        button.addActionListener(this);
        add(button);

        button2 = new JRadioButton("No");
        button2.setBackground(new Color(35,35,35));
        button2.setBorder(createMatteBorder(0,0,1,0,Color.WHITE));
        button2.setForeground(Color.WHITE);
        button2.setBounds(335,495,50,30);
        button2.addItemListener((ItemListener) this);
        button2.addActionListener(this);
        add(button2);


        register = new JButton("Submit");
        register.setBackground(new Color(35,35,35));
        register.setForeground(Color.WHITE);
        register.addActionListener(this);
        register.setBounds(260,560,100,30);
        add(register);

        setUndecorated(true);

        JButton cross = new JButton("X");
        cross.setBackground(new Color(35,35,35));
        cross.setBounds(600,0,50,30);
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




        phno = Phno;

        setSize(650, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(35,35,35));
        setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==register) {

            String Relegion = actype1.getSelectedItem().toString() ;
           String Category = actype2.getSelectedItem().toString() ;
           String Occupation = actype3.getSelectedItem().toString() ;
           String Income = income.getText() ;
           String Pan = pan.getText() ;
           String Aadhar = aa.getText() ;
           String senior = null;
           if(button.isSelected())
               senior = "Yes";
           else if(button2.isSelected())
               senior = "No";


            try {
                Conn conn = new Conn();
                String query = "UPDATE customer1 SET Relegion = '" + Relegion + "', Category = '" + Category +
                        "', Occupation = '" + Occupation + "', Income = '" + Income + "', PAN = '" + Pan +
                        "', Aadhar = '" + Aadhar + "', Senior_Citizen = '" + senior + "' WHERE Phone_Number = '" + phno + "'";

                conn.s.executeUpdate(query);
                 new Acc_Details(phno);

                setVisible(false);
            } catch (SQLException ep) {
                ep.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error connecting to the database", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }

    }

    @Override
    public void itemStateChanged(ItemEvent ex) {

    }
}
