package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener {

    JMenuBar mb;
    JMenu m1, m2;
    JMenuItem i1, i2, i3, i4;

    Dashboard() {

        mb = new JMenuBar();
        add(mb);

        m1 = new JMenu("Hotel Management");
        m1.setForeground(Color.RED);
        mb.add(m1);

        m2 = new JMenu("Admin");
        m2.setForeground(Color.BLUE);
        mb.add(m2);

        i1 = new JMenuItem("Reception");
        i1.addActionListener(this);
        m1.add(i1);

        i2 = new JMenuItem("Add Employee");
        i2.addActionListener(this);
        m2.add(i2);

        i3 = new JMenuItem("Add Rooms");
        i3.addActionListener(this);
        m2.add(i3);

        i4 = new JMenuItem("Add Drivers");
        i4.addActionListener(this);
        m2.add(i4);

        mb.setBounds(0, 0, 1920, 30);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Hotel/Management/System/icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1920, 1080, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(0, 0, 1920, 800);
        add(l1);

        JLabel l2 = new JLabel("THE TAJ GROUPS WELCOMES YOU");
        l2.setBounds(500, 50, 600, 50);
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("Tahome", Font.PLAIN, 30));
        l1.add(l2);

        setLayout(null);
        setBounds(0, 0, 1920, 1080);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {

        switch (ae.getActionCommand()) {
            case "Reception":
                new Reception().setVisible(true);
                break;
            case "Add Employee":
                new Employees().setVisible(true);
                break;
            case "Add Rooms":
                new AddRooms().setVisible(true);
                break;
            case "Add Drivers":
                new AddDrivers().setVisible(true);
                break;
        }
    }

    public static void main(String[] args) {
        new Dashboard().setVisible(true);
    }
}
