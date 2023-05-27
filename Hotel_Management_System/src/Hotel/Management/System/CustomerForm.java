package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.awt.event.*;

public class CustomerForm extends JFrame implements ActionListener {

    JTextField t1, t2, t3, t4, t5;
    JButton b1, b2;
    JComboBox<String> c1;
    Choice c2;
    JRadioButton r1, r2;

    public CustomerForm() {

        setBounds(300, 150, 900, 560);

        JLabel l1 = new JLabel("NEW CUSTOMER FORM");
        l1.setFont(new Font(null, Font.PLAIN, 18));
        l1.setForeground(Color.BLUE);
        l1.setBounds(60, 20, 250, 30);
        add(l1);

        JLabel l2 = new JLabel("ID");
        l2.setBounds(40, 70, 100, 30);
        add(l2);

        c1 = new JComboBox<>(new String[]{"Passport", "Voter-Id Card", "Driving License", "Aadhar Card"});
        c1.setBackground(Color.WHITE);
        c1.setBounds(170, 70, 120, 30);
        add(c1);

        JLabel l3 = new JLabel("Number");
        l3.setBounds(40, 120, 100, 30);
        add(l3);

        t1 = new JTextField();
        t1.setBounds(170, 120, 120, 30);
        add(t1);

        JLabel l4 = new JLabel("Name");
        l4.setBounds(40, 170, 100, 30);
        add(l4);

        t2 = new JTextField();
        t2.setBounds(170, 170, 120, 30);
        add(t2);

        JLabel l5 = new JLabel("Gender");
        l5.setBounds(40, 220, 100, 30);
        add(l5);

        r1 = new JRadioButton("Male");
        r1.setBackground(Color.WHITE);
        r1.setBounds(165, 220, 60, 30);
        add(r1);

        r2 = new JRadioButton("Female");
        r2.setBackground(Color.WHITE);
        r2.setBounds(225, 220, 70, 30);
        add(r2);

        JLabel l6 = new JLabel("Country");
        l6.setBounds(40, 270, 100, 30);
        add(l6);

        t3 = new JTextField();
        t3.setBounds(170, 270, 120, 30);
        add(t3);

        JLabel l7 = new JLabel("Room Number");
        l7.setBounds(40, 320, 100, 30);
        add(l7);

        c2 = new Choice();
        try {
            conn c = new conn();
            String str = "select * from room";
            ResultSet rs = c.s.executeQuery(str);
            while (rs.next()){
                c2.add(rs.getString("room_number"));
            }

        }catch (Exception e){};
        c2.setBounds(170, 320, 120, 30);
        add(c2);

        JLabel l8 = new JLabel("Checked In");
        l8.setBounds(40, 370, 100, 30);
        add(l8);

        t4 = new JTextField();
        t4.setBounds(170, 370, 120, 30);
        add(t4);

        JLabel l9 = new JLabel("Deposit");
        l9.setBounds(40, 420, 100, 30);
        add(l9);

        t5 = new JTextField();
        t5.setBounds(170, 420, 120, 30);
        add(t5);

        b1 = new JButton("Submit");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(50, 470, 100, 30);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Cancel");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(180, 470, 100, 30);
        b2.addActionListener(this);
        add(b2);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Hotel/Management/System/icons/fifth.png"));
        Image i2 = i1.getImage().getScaledInstance(600, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel li = new JLabel(i3);
        li.setBounds(300, 20, 600, 500);
        add(li);

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == b1) {
            String id = (String) c1.getSelectedItem();
            String number = (String) t1.getText();
            String name = (String) t2.getText();
            String gender = null;
            if (r1.isSelected()) {
                gender = "Male";
            }else if (r2.isSelected()) {
                gender = "Female";
            }
            String country = (String) t3.getText();
            String roomNumber = (String) c2.getSelectedItem();
            String checkedIn = (String) t4.getText();
            String deposit = (String) t5.getText();

            String str = "insert into customerform values('"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+roomNumber+"','"+checkedIn+"','"+deposit+"')";
            String str1 = "update room set availability = 'Engaged' where room_number = '"+roomNumber+"'";

            try {
                conn c = new conn();
                c.s.executeUpdate(str);
                c.s.executeUpdate(str1);
                JOptionPane.showMessageDialog(null, "New Customer Added");
                new Reception().setVisible(true);
                this.setVisible(false);
            }catch (Exception e){
                System.out.println(e);
            }
        }else if (ae.getSource() == b2) {
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new CustomerForm().setVisible(true);
    }
}
