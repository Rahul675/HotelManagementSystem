package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddDrivers extends JFrame implements ActionListener {

    JTextField t1, t2, t3, t4, t5;
    JComboBox<String> c1, c2;
    JButton b1, b2;

    public AddDrivers(){

        setBounds(380, 200, 800, 450);


        JLabel l1 = new JLabel("Add Driver");
        l1.setBounds(130, 20, 120, 30);
        l1.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(l1);

        JLabel l2 = new JLabel("Name");
        l2.setBounds(40, 60, 120, 30);
        l2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(l2);

        t1 = new JTextField();
        t1.setBounds(180, 60, 120, 35);
        add(t1);

        JLabel l3 = new JLabel("Age");
        l3.setBounds(40, 100, 120, 30);
        l3.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(l3);

        t2 = new JTextField();
        t2.setBounds(180, 100, 120, 35);
        add(t2);

        JLabel l4 = new JLabel("Gender");
        l4.setBounds(40, 140, 120, 30);
        l4.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(l4);

        String[] str1 = {"Male", "Female"};
        c1 = new JComboBox<>(str1);
        c1.setBounds(180, 140, 120, 30);
        add(c1);

        JLabel l5 = new JLabel("Car Company");
        l5.setBounds(40, 180, 120, 30);
        l5.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(l5);

        t3 = new JTextField();
        t3.setBounds(180, 180, 120, 35);
        add(t3);

        JLabel l6 = new JLabel("Car Mode");
        l6.setBounds(40, 220, 120, 30);
        l6.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(l6);

        t4 = new JTextField();
        t4.setBounds(180, 220, 120, 35);
        add(t4);

        JLabel l7 = new JLabel("Availability");
        l7.setBounds(40, 260, 120, 30);
        l7.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(l7);

        String[] str2 = {"Available", "Busy"};
        c2 = new JComboBox<>(str2);
        c2.setBounds(180, 260, 120, 30);
        add(c2);

        JLabel l8 = new JLabel("Location");
        l8.setBounds(40, 300, 120, 30);
        l8.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(l8);

        t5 = new JTextField();
        t5.setBounds(180, 300, 120, 35);
        add(t5);

        b1 = new JButton("Add Driver");
        b1.setBounds(40, 360, 120, 30);
        b1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Cancel");
        b2.setBounds(180, 360, 120, 30);
        b2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.BLACK);
        b2.addActionListener(this);
        add(b2);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("HOtel/Management/System/icons/eleven.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 360, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel li = new JLabel(i3);
        li.setBounds(320, 30, 450, 360);
        add(li);


        setLayout(null);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {

            String name = t1.getText();
            String age = t2.getText();
            String gender = (String) c1.getSelectedItem();
            String car_Company = t3.getText();
            String brand = t4.getText();
            String availability = (String) c2.getSelectedItem();
            String location = t5.getText();

            conn c = new conn();

            String str = "insert into driver values('"+name+"','"+age+"','"+gender+"','"+car_Company+"','"+brand+"','"+availability+"','"+location+"')";

            try {
                
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "New driver add");
                this.setVisible(false);

            }catch (Exception e){
                e.printStackTrace();
                this.setVisible(false);
            }


        }else if (ae.getSource() == b2) {
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddDrivers().setVisible(true);
    }
}
