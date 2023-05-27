package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HotelManagementSystem extends JFrame implements ActionListener {

    HotelManagementSystem(){
        setBounds(100, 100, 1366, 565);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Hotel/Management/System/icons/first.jpg"));
        JLabel l1 = new JLabel(i1);
        l1.setBounds(0, 0, 1366, 565);
        add(l1);

        JLabel l2 = new JLabel("Hotel Management System");
        l2.setBounds(20, 430, 1000, 90);
        l2.setForeground(Color.RED);
        l2.setFont(new Font("Tahoma", Font.BOLD, 50));
        l1.add(l2);

        JButton b1 = new JButton("Next");
        b1.setBounds(1150, 455, 120, 40);
        b1.setBackground(Color.WHITE);
        b1.setForeground(Color.BLACK);
        b1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        b1.addActionListener(this);
        l1.add(b1);

        setLayout(null);
        setVisible(true);

        while (true) {
            l2.setVisible(false);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
            l2.setVisible(true);
            try {
                Thread.sleep(500);
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        new Login().setVisible(true);
        this.setVisible(false);
    }

    public static void main(String[] args) {
        new HotelManagementSystem();
    }
}
