package jpackage;

import java.sql.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.URI;
import java.net.URISyntaxException;

import jpackage.*;

public class change_status extends JFrame implements ActionListener, frame {

    JLabel l, l1, l2, l3, l4, l5, l6;
    JButton b1, b2, b3;
    JTextField t1, t2, t3, t4, t5, t6;
    JRadioButton success, on_hold, denied;

    public change_status(JFrame f){
        
        f.getContentPane().removeAll();
        f.repaint();
        f.getContentPane().setBackground(Color.yellow);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setDefaultLookAndFeelDecorated(true);

        l = new JLabel("Change Status Of Referral Code");
        l.setBounds(565, 60, 670, 50);
        l.setFont(new Font("Helvetica", Font.BOLD, 26));
        l.setForeground(Color.RED);
        f.add(l);

        l1 = new JLabel("Customer Name:");
        l1.setBounds(670, 160, 225, 30);
        l1.setFont(new Font("Helvetica", Font.BOLD, 20));
        l1.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        f.add(l1);
        t1 = new RoundJTextField(15);
        t1.setBounds(460, 200, 580, 30);
        t1.setBackground(Color.white);
        t1.setForeground(Color.black);
        t1.setFont(new Font("Helvetica", Font.BOLD, 15));
        f.add(t1);

        l2 = new JLabel("Contact Number:");
        l2.setBounds(670, 240, 225, 30);
        l2.setFont(new Font("Helvetica", Font.BOLD, 20));
        l2.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        f.add(l2);
        t2 = new RoundJTextField(15);
        t2.setBounds(460, 280, 580, 30);
        t2.setBackground(Color.white);
        t2.setForeground(Color.black);
        t2.setFont(new Font("Helvetica", Font.BOLD, 15));
        f.add(t2);

        l3 = new JLabel("Referral Code:");
        l3.setBounds(682, 320, 225, 30);
        l3.setFont(new Font("Helvetica", Font.BOLD, 20));
        l3.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        f.add(l3);
        t3 = new RoundJTextField(15);
        t3.setBounds(460, 360, 580, 30);
        t3.setBackground(Color.white);
        t3.setForeground(Color.black);
        t3.setFont(new Font("Helvetica", Font.BOLD, 15));
        f.add(t3);

        b1 = new JButton("Go Back");
        b1.setBounds(460, 410, 275, 35);
        b1.setFont(new Font("Helvetica", Font.BOLD, 17));
        b1.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        b1.setBackground(Color.RED);
        b1.addActionListener(this);
        f.add(b1);

        b2 = new JButton("Check Status");
        b2.setBounds(760, 410, 275, 35);
        b2.setFont(new Font("Helvetica", Font.BOLD, 17));
        b2.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        b2.setBackground(Color.GREEN);
        b2.addActionListener(this);
        f.add(b2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

        if (e.getSource() == b1) {
            new admin_menu(f);
        }
        
    }
    
}
