package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

import net.proteanit.sql.*;

public class AllEmployeeInfo extends JFrame implements ActionListener {

    JTable t1;
    JButton b1, b2;

    public AllEmployeeInfo() {

        setBounds(270, 200, 1000, 540);

        JLabel l1 = new JLabel("Name");
        l1.setBounds(40, 5, 70, 20);
        l1.setFont(new Font(null, Font.PLAIN, 15));
        add(l1);

        JLabel l2 = new JLabel("Age");
        l2.setBounds(170, 5, 70, 20);
        l2.setFont(new Font(null, Font.PLAIN, 15));
        add(l2);

        JLabel l3 = new JLabel("Gender");
        l3.setBounds(280, 5, 70, 20);
        l3.setFont(new Font(null, Font.PLAIN, 15));
        add(l3);

        JLabel l4 = new JLabel("Job");
        l4.setBounds(420, 5, 70, 20);
        l4.setFont(new Font(null, Font.PLAIN, 15));
        add(l4);

        JLabel l5 = new JLabel("Salary");
        l5.setBounds(540, 5, 70, 20);
        l5.setFont(new Font(null, Font.PLAIN, 15));
        add(l5);

        JLabel l6 = new JLabel("Phone");
        l6.setBounds(660, 5, 70, 20);
        l6.setFont(new Font(null, Font.PLAIN, 15));
        add(l6);

        JLabel l7 = new JLabel("Aadhar");
        l7.setBounds(785, 5, 70, 20);
        l7.setFont(new Font(null, Font.PLAIN, 15));
        add(l7);

        JLabel l8 = new JLabel("Email");
        l8.setBounds(910, 5, 70, 20);
        l8.setFont(new Font(null, Font.PLAIN, 15));
        add(l8);

        t1 = new JTable();
        t1.setBounds(0, 30, 1000, 400);
        add(t1);

        b1 = new JButton("Load Data");
        b1.setBounds(380, 450, 100, 30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Back");
        b2.setBounds(520, 450, 100, 30);
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
                String str = "select * from employee";
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
        new AllEmployeeInfo().setVisible(true);
    }
}
