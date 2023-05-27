package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Employees extends JFrame implements ActionListener {

    JTextField t1, t2, t3, t4, t5, t6;
    JRadioButton r1, r2;
    JComboBox<String> c1;
    JButton b1;

    public Employees() {

        setBounds(350, 150, 850, 550);

        JLabel l1 = new JLabel("NAME");
        l1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        l1.setBounds(40, 20, 100, 30);
        add(l1);

        t1 = new JTextField();
        t1.setBounds(150, 25, 150, 30);
        add(t1);

        JLabel l2 = new JLabel("AGE");
        l2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        l2.setBounds(40, 70, 100, 30);
        add(l2);

        t2 = new JTextField();
        t2.setBounds(150, 75, 150, 30);
        add(t2);

        JLabel l3 = new JLabel("GENDER");
        l3.setFont(new Font("Tahoma", Font.PLAIN, 15));
        l3.setBounds(40, 120, 100, 30);
        add(l3);

        r1 = new JRadioButton("MALE");
        r1.setBounds(150, 120, 60, 20);
        r1.setBackground(Color.WHITE);
        add(r1);

        r2 = new JRadioButton("FEMALE");
        r2.setBounds(230, 120, 80, 20);
        r2.setBackground(Color.WHITE);
        add(r2);

        JLabel l4 = new JLabel("JOB");
        l4.setFont(new Font("Tahoma", Font.PLAIN, 15));
        l4.setBounds(40, 170, 100, 30);
        add(l4);

        String[] str = {"Select your profession","Front Desk Clerks","Porters","Housekeeping","Kitchen Staff","Room Service","Waiter/Waitress","Manager","Accountant","Chef"};
        c1 = new JComboBox<>(str);
        c1.setBounds(150, 170, 150, 30);
        c1.setBackground(Color.WHITE);
        add(c1);

        JLabel l5 = new JLabel("SALARY");
        l5.setFont(new Font("Tahoma", Font.PLAIN, 15));
        l5.setBounds(40, 220, 100, 30);
        add(l5);

        t3 = new JTextField();
        t3.setBounds(150, 225, 150, 30);
        add(t3);

        JLabel l6 = new JLabel("PHONE");
        l6.setFont(new Font("Tahoma", Font.PLAIN, 15));
        l6.setBounds(40, 270, 100, 30);
        add(l6);

        t4 = new JTextField();
        t4.setBounds(150, 275, 150, 30);
        add(t4);

        JLabel l7 = new JLabel("AADHAR");
        l7.setFont(new Font("Tahoma", Font.PLAIN, 15));
        l7.setBounds(40, 320, 100, 30);
        add(l7);

        t5 = new JTextField();
        t5.setBounds(150, 325, 150, 30);
        add(t5);

        JLabel l8 = new JLabel("EMAIL");
        l8.setFont(new Font("Tahoma", Font.PLAIN, 15));
        l8.setBounds(40, 370, 100, 30);
        add(l8);

        t6 = new JTextField();
        t6.setBounds(150, 375, 150, 30);
        add(t6);

        JLabel l9 = new JLabel("ADD EMPLOYEE DETAILS");
        l9.setFont(new Font("Tahoma", Font.PLAIN, 20));
        l9.setForeground(Color.BLUE);
        l9.setBounds(450, 30, 300, 30);
        add(l9);

        b1 = new JButton("Submit");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(150, 430, 150, 30);
        b1.addActionListener(this);
        add(b1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Hotel/Management/System/icons/tenth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 550, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel li = new JLabel(i3);
        li.setBounds(320, 20, 500, 450);
        add(li);

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String name = t1.getText();
        String age = t2.getText();
        String salary = t3.getText();
        String phone = t4.getText();
        String aadhar = t5.getText();
        String email = t6.getText();

        String gender = null;

        if (r1.isSelected()) {
            gender = "Male";
        }else if (r2.isSelected()) {
            gender = "Female";
        }

        String job = (String)c1.getSelectedItem();

        conn c = new conn();

        String str = "insert into employee values('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+aadhar+"','"+email+"')";

        try {
            
            c.s.executeUpdate(str);
            JOptionPane.showMessageDialog(null, "New Employee Added");
            this.setVisible(false);

        }catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Employees();
    }
}
