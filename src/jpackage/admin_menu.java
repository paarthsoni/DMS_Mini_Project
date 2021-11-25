package jpackage;

import java.sql.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.URI;
import java.net.URISyntaxException;

import jpackage.*;

public class admin_menu extends JFrame implements ActionListener, frame {

    JButton b1, b2, b3, b4, b5;
    

    public admin_menu(JFrame f) {

        
        f.getContentPane().removeAll();
        f.repaint();
        f.getContentPane().setBackground(Color.GRAY);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setDefaultLookAndFeelDecorated(true);

        b1 = new JButton("Add an Employee");
        b1.setBounds(670, 200, 280, 50);
        b1.setFont(new Font("Helvetica", Font.BOLD, 17));
        b1.addActionListener(this);
        f.add(b1);

        b2 = new JButton("View All Employees");
        b2.setBounds(670, 300, 280, 50);
        b2.setFont(new Font("Helvetica", Font.BOLD, 17));
        b2.addActionListener(this);
        f.add(b2);

        b3 = new JButton("Add a Referral");
        b3.setBounds(670, 400, 280, 50);
        b3.setFont(new Font("Helvetica", Font.BOLD, 17));
        b3.addActionListener(this);
        f.add(b3);

        b4 = new JButton("Change The Status of Referral");
        b4.setBounds(670, 500, 280, 50);
        b4.setFont(new Font("Helvetica", Font.BOLD, 17));
        b4.addActionListener(this);
        f.add(b4);

        b5 = new JButton("Log Out");
        b5.setBounds(1330, 30, 150, 35);
        b5.setFont(new Font("Helvetica", Font.BOLD, 17));
        b5.addActionListener(this);
        b5.setBackground(Color.RED);
        b5.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        f.add(b5);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == b1) {
            new add_employee(f);
        }

        if (e.getSource() == b3) {

           
        }

        if (e.getSource() == b2) {
            
        }

        if (e.getSource() == b4) {

            

        }

        if (e.getSource() == b5) {

            JOptionPane.showMessageDialog(null, "Logged out Successfully");
            new login();

        }

    }
}
