package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddRooms extends JFrame implements ActionListener {

    JComboBox<String> c1, c2, c3;
    JTextField t1, t2;
    JButton b1,b2;

    public AddRooms() {

        setBounds(360, 200, 830, 440);

        JLabel l1 = new JLabel("Add Room");
        l1.setBounds(150, 15, 100, 30);
        l1.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(l1);

        JLabel l2 = new JLabel("Room Number");
        l2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        l2.setBounds(70, 70, 100, 30);
        add(l2);

        t1 = new JTextField();
        t1.setBounds(180, 75, 120, 30);
        add(t1);

        JLabel l3 = new JLabel("Availability");
        l3.setFont(new Font("Tahoma", Font.PLAIN, 14));
        l3.setBounds(70, 120, 100, 30);
        add(l3);

        String[] str1 = {"Available", "Engaged"};
        c1 = new JComboBox<>(str1);
        c1.setBackground(Color.WHITE);
        c1.setBounds(180, 125, 120, 30);
        add(c1);

        JLabel l4 = new JLabel("Clean/Dirty");
        l4.setFont(new Font("Tahoma", Font.PLAIN, 14));
        l4.setBounds(70, 170, 100, 30);
        add(l4);

        String[] str2 = {"Clean", "Dirty"};
        c2 = new JComboBox<>(str2);
        c2.setBackground(Color.WHITE);
        c2.setBounds(180, 175, 120, 30);
        add(c2);

        JLabel l5 = new JLabel("Price");
        l5.setFont(new Font("Tahoma", Font.PLAIN, 14));
        l5.setBounds(70, 220, 100, 30);
        add(l5);

        t2 = new JTextField();
        t2.setBounds(180, 225, 120, 30);
        add(t2);

        JLabel l6 = new JLabel("Bed Type");
        l6.setFont(new Font("Tahoma", Font.PLAIN, 14));
        l6.setBounds(70, 270, 100, 30);
        add(l6);

        String[] str3 = {"Single", "Double"};
        c3 = new JComboBox<>(str3);
        c3.setBackground(Color.WHITE);
        c3.setBounds(180, 275, 120, 30);
        add(c3);

        b1 = new JButton("Add Room");
        b1.setBounds(70, 330, 100, 30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Cancel");
        b2.setBounds(200, 330, 100, 30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Hotel/Management/System/icons/twelve.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 340, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel li = new JLabel(i3);
        li.setBounds(350, 20, 450, 340);
        add(li);

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == b1) {

            String roomNumber = t1.getText();
            String price = t2.getText();

            String availability = (String)c1.getSelectedItem();
            String cleanOrDirty = (String)c2.getSelectedItem();
            String bedType = (String)c3.getSelectedItem();

            conn c = new conn();

            String str = "insert into room values('"+roomNumber+"','"+availability+"','"+cleanOrDirty+"','"+price+"','"+bedType+"')";

            try {

                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "Room Added Successfully");
                this.setVisible(false);

            }catch (Exception e){
                e.printStackTrace();
            }

        }else if (ae.getSource() == b2) {
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddRooms().setVisible(true);
    }

}
