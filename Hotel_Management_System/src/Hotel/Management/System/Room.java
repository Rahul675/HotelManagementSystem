package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

import net.proteanit.sql.*;

public class Room extends JFrame implements ActionListener {

    JTable t1;
    JButton b1, b2;

    public Room() {

        setBounds(270, 200, 1000, 540);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Hotel/Management/System/icons/eight.jpg"));
        Image i2 = i1.getImage().getScaledInstance(455, 480, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel li = new JLabel(i3);
        li.setBounds(520, 10, 455, 480);
        add(li);

        JLabel l1 = new JLabel("Room Number");
        l1.setBounds(10, 5, 100, 20);
        l1.setFont(new Font(null, Font.PLAIN, 15));
        add(l1);

        JLabel l2 = new JLabel("Availability");
        l2.setBounds(125, 5, 100, 20);
        l2.setFont(new Font(null, Font.PLAIN, 15));
        add(l2);

        JLabel l3 = new JLabel("Clean Status");
        l3.setBounds(215, 5, 100, 20);
        l3.setFont(new Font(null, Font.PLAIN, 15));
        add(l3);

        JLabel l4 = new JLabel("Price");
        l4.setBounds(340, 5, 70, 20);
        l4.setFont(new Font(null, Font.PLAIN, 15));
        add(l4);

        JLabel l5 = new JLabel("Bed Type");
        l5.setBounds(425, 5, 70, 20);
        l5.setFont(new Font(null, Font.PLAIN, 15));
        add(l5);

        t1 = new JTable();
        t1.setBounds(10, 30, 500, 410);
        add(t1);

        b1 = new JButton("Load Data");
        b1.setBounds(150, 460, 100, 30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Back");
        b2.setBounds(300, 460, 100, 30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);

        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {

            try {
                conn c = new conn();
                String str = "select * from room";
                ResultSet rs = c.s.executeQuery(str);
                t1.setModel(DbUtils.resultSetToTableModel(rs));

            }catch (Exception e) {
                e.printStackTrace();
            }

        }else if (ae.getSource() == b2) {
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Room().setVisible(true);
    }
}