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

public class add_employee extends JFrame implements ActionListener, frame{

    JLabel l, l1, l2, l3, l4, l5, l6, l7;
    JButton b1, b2;
    JTextField t1, t2, t3, t4, t5, t6, t7;
    JRadioButton male, female, other;

    public add_employee(JFrame f){

        f.getContentPane().removeAll();
        f.repaint();
        f.getContentPane().setBackground(Color.GRAY);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setDefaultLookAndFeelDecorated(true);

        l7 = new JLabel("Add Employee");
        l7.setBounds(650, 50, 670, 150);
        l7.setFont(new Font("Helvetica", Font.BOLD, 26));
        l7.setForeground(Color.RED);
        f.add(l7);

        l1 = new JLabel("First Name:");
        l1.setBounds(500, 190, 225, 30);
        l1.setFont(new Font("Helvetica", Font.BOLD, 20));
        l1.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        f.add(l1);
        t1 = new RoundJTextField(15);
        t1.setBounds(460, 230, 180, 30);
        t1.setBackground(Color.white);
        t1.setForeground(Color.black);
        t1.setFont(new Font("Helvetica", Font.BOLD, 15));
        f.add(t1);

        l2 = new JLabel("Middle Name:");
        l2.setBounds(685, 190, 225, 30);
        l2.setFont(new Font("Helvetica", Font.BOLD, 20));
        l2.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        f.add(l2);
        t2 = new RoundJTextField(15);
        t2.setBounds(660, 230, 180, 30);
        t2.setBackground(Color.white);
        t2.setForeground(Color.black);
        t2.setFont(new Font("Helvetica", Font.BOLD, 15));
        f.add(t2);

        l3 = new JLabel("Last Name:");
        l3.setBounds(890, 190, 225, 30);
        l3.setFont(new Font("Helvetica", Font.BOLD, 20));
        l3.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        f.add(l3);
        t3 = new RoundJTextField(15);
        t3.setBounds(860, 230, 180, 30);
        t3.setBackground(Color.white);
        t3.setForeground(Color.black);
        t3.setFont(new Font("Helvetica", Font.BOLD, 15));
        f.add(t3);

        l = new JLabel("Gender:");
        l.setBounds(460, 280, 225, 30);
        l.setFont(new Font("Helvetica", Font.BOLD, 20));
        l.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        f.add(l);
        male = new JRadioButton("Male");
        male.setBounds(570, 280, 100, 30);
        male.setFont(new Font("Helvetica", Font.BOLD, 20));
        male.addActionListener(this);
        male.setOpaque(false);
        male.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        f.add(male);
        female = new JRadioButton("Female");
        female.setBounds(760, 280, 130, 30);
        female.setFont(new Font("Helvetica", Font.BOLD, 20));
        female.addActionListener(this);
        female.setOpaque(false);
        female.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        f.add(female);
        other = new JRadioButton("Other");
        other.setBounds(950, 280, 150, 30);
        other.setFont(new Font("Helvetica", Font.BOLD, 20));
        other.addActionListener(this);
        other.setOpaque(false);
        other.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        f.add(other);

        l4 = new JLabel("Email ID:");
        l4.setBounds(705, 320, 225, 30);
        l4.setFont(new Font("Helvetica", Font.BOLD, 20));
        l4.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        f.add(l4);
        t4 = new RoundJTextField(15);
        t4.setBounds(460, 360, 580, 30);
        t4.setBackground(Color.white);
        t4.setForeground(Color.black);
        t4.setFont(new Font("Helvetica", Font.BOLD, 15));
        f.add(t4);

        l5 = new JLabel("Department Name:");
        l5.setBounds(670, 400, 225, 30);
        l5.setFont(new Font("Helvetica", Font.BOLD, 20));
        l5.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        f.add(l5);
        t5 = new RoundJTextField(15);
        t5.setBounds(460, 440, 580, 30);
        t5.setBackground(Color.white);
        t5.setForeground(Color.black);
        t5.setFont(new Font("Helvetica", Font.BOLD, 15));
        f.add(t5);

        l6 = new JLabel("Contact Number:");
        l6.setBounds(680, 480, 225, 30);
        l6.setFont(new Font("Helvetica", Font.BOLD, 20));
        l6.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        f.add(l6);
        t6 = new RoundJTextField(15);
        t6.setBounds(460, 520, 580, 30);
        t6.setBackground(Color.white);
        t6.setForeground(Color.black);
        t6.setFont(new Font("Helvetica", Font.BOLD, 15));
        f.add(t6);

        b1 = new JButton("Go Back");
        b1.setBounds(460, 590, 275, 35);
        b1.setFont(new Font("Helvetica", Font.BOLD, 17));
        b1.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        b1.setBackground(Color.RED);
        b1.addActionListener(this);
        f.add(b1);

        b2 = new JButton("Add Employee");
        b2.setBounds(760, 590, 275, 35);
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

        if (e.getSource() == male) {
            if (male.isSelected()) {
                female.setEnabled(false);
                other.setEnabled(false);
            } else if ((!male.isSelected())) {
                female.setEnabled(true);
                other.setEnabled(true);
            }

        }

        if (e.getSource() == female) {
            if (female.isSelected()) {
                male.setEnabled(false);
                other.setEnabled(false);
            } else if ((!female.isSelected())) {
                male.setEnabled(true);
                other.setEnabled(true);
            }

        }

        if (e.getSource() == other) {
            if (other.isSelected()) {
                female.setEnabled(false);
                male.setEnabled(false);
            } else if ((!male.isSelected())) {
                female.setEnabled(true);
                male.setEnabled(true);
            }
        }    
        
    }
    
}
