package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
//import java.util.Arrays;

public class Login extends JFrame implements ActionListener {

    JLabel l1, l2;
    JButton b1, b2;
    JTextField t1;
    JPasswordField t2;

    Login(){
        setBounds(500, 300, 550, 250);

        l1 = new JLabel("Username");
        l1.setBounds(40, 20, 100, 50);
        add(l1);

        t1 = new JTextField();
        t1.setBounds(140, 30, 150, 30);
        add(t1);

        l2 = new JLabel("Password");
        l2.setBounds(40, 70, 100, 50);
        add(l2);

        t2 = new JPasswordField();
        t2.setBounds(140, 80, 150, 30);
        add(t2);

        b1 = new JButton("Login");
        b1.setBounds(40, 150, 100, 30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Cancel");
        b2.setBounds(190, 150, 100, 30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Hotel/Management/System/icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(320, 10, 200, 200);
        add(l3);

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            String username = t1.getText();
            String password = t2.getText();
            conn c = new conn();

            String str = "select * from login where username = '"+username+"' and password = '"+ password +"'";

            try {
                ResultSet rs = c.s.executeQuery(str);

                if (rs.next()) {
                    new Dashboard().setVisible(true);
                }else {
                    JOptionPane.showMessageDialog(null,"Invalid username and password");
                }
                this.setVisible(false);

            }catch (Exception e) {
                e.printStackTrace();
            }

        }else if (ae.getSource() == b2) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
