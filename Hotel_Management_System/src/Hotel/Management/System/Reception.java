package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Reception extends JFrame implements ActionListener {

    JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12;

    public Reception() {

        setBounds(400, 150, 740, 580);

        b1 = new JButton("New Customer Form");
        b1.setBounds(20, 40, 150, 30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Room");
        b2.setBounds(20, 80, 150, 30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);

        b3 = new JButton("Department");
        b3.setBounds(20, 120, 150, 30);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.addActionListener(this);
        add(b3);

        b4 = new JButton("All Employee Info");
        b4.setBounds(20, 160, 150, 30);
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);
        b4.addActionListener(this);
        add(b4);

        b5 = new JButton("Customer Info");
        b5.setBounds(20, 200, 150, 30);
        b5.setBackground(Color.BLACK);
        b5.setForeground(Color.WHITE);
        b5.addActionListener(this);
        add(b5);

        b6 = new JButton("Manager Info");
        b6.setBounds(20, 240, 150, 30);
        b6.setBackground(Color.BLACK);
        b6.setForeground(Color.WHITE);
        b6.addActionListener(this);
        add(b6);

        b7 = new JButton("Check Out");
        b7.setBounds(20, 280, 150, 30);
        b7.setBackground(Color.BLACK);
        b7.setForeground(Color.WHITE);
        b7.addActionListener(this);
        add(b7);

        b8 = new JButton("Update Check Status");
        b8.setBounds(20, 320, 150, 30);
        b8.setBackground(Color.BLACK);
        b8.setForeground(Color.WHITE);
        b8.addActionListener(this);
        add(b8);

        b9 = new JButton("Update Room Status");
        b9.setBounds(20, 360, 150, 30);
        b9.setBackground(Color.BLACK);
        b9.setForeground(Color.WHITE);
        b9.addActionListener(this);
        add(b9);

        b10 = new JButton("Pick Up Service");
        b10.setBounds(20, 400, 150, 30);
        b10.setBackground(Color.BLACK);
        b10.setForeground(Color.WHITE);
        b10.addActionListener(this);
        add(b10);

        b11 = new JButton("Search Room");
        b11.setBounds(20, 440, 150, 30);
        b11.setBackground(Color.BLACK);
        b11.setForeground(Color.WHITE);
        b11.addActionListener(this);
        add(b11);

        b12 = new JButton("Logout");
        b12.setBounds(20, 480, 150, 30);
        b12.setBackground(Color.BLACK);
        b12.setForeground(Color.WHITE);
        b12.addActionListener(this);
        add(b12);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Hotel/Management/System/icons/fourth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 470, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel li = new JLabel(i3);
        li.setBounds(190, 40, 500, 470);
        add(li);

        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == b1) {
            new CustomerForm().setVisible(true);
            this.setVisible(false);
        }
        if (ae.getSource() == b2) {
            new Room().setVisible(true);
            this.setVisible(false);
        }
        if (ae.getSource() == b3) {

        }
        if (ae.getSource() == b4) {
            new AllEmployeeInfo().setVisible(true);
            this.setVisible(false);
        }
        if (ae.getSource() == b5) {

        }
        if (ae.getSource() == b6) {
            new ManagerInfo().setVisible(true);
            this.setVisible(false);
        }
        if (ae.getSource() == b7) {

        }
        if (ae.getSource() == b8) {

        }
        if (ae.getSource() == b9) {

        }
        if (ae.getSource() == b10) {

        }
        if (ae.getSource() == b11) {

        }
        if (ae.getSource() == b12) {
            this.setVisible(false);
        }

    }

    public static void main(String[] args) {
        new Reception();
    }
}
