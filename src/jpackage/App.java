package jpackage;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import jpackage.*;

interface frame {
    JFrame f = new JFrame("Employee's Referral Management System");
}

class login extends JFrame implements frame, ActionListener {

    JLabel l, l1, l2, l3, l4;
    JButton b1, b2, b3;
    JTextField t1;
    JPasswordField t2;
    JCheckBox showpassword;

    public login() {

        f.getContentPane().removeAll();
        f.repaint();

        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().setBackground(Color.GRAY);
        f.setDefaultLookAndFeelDecorated(true);
        

        l = new JLabel("Welcome to Employee Referral Management System");
        l.setBounds(440, 10, 670, 150);
        l.setFont(new Font("Helvetica", Font.BOLD, 26));
        l.setForeground(Color.RED);
        f.add(l);

        l4 = new JLabel("Sign In to your Account");
        l4.setBounds(600, 170, 400, 30);
        l4.setFont(new Font("Helvetica", Font.BOLD, 26));
        l4.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        f.add(l4);

        l1 = new JLabel("Enter your Username:");
        l1.setBounds(540, 240, 225, 30);
        l1.setFont(new Font("Helvetica", Font.BOLD, 20));
        l1.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        f.add(l1);
        t1 = new RoundJTextField(15);
        t1.setBounds(765, 240, 200, 30);
        t1.setBackground(Color.white);
        t1.setForeground(Color.black);
        t1.setFont(new Font("Helvetica", Font.BOLD, 15));
        f.add(t1);

        l2 = new JLabel("Enter your Password:");
        l2.setBounds(540, 320, 225, 30);
        l2.setFont(new Font("Helvetica", Font.BOLD, 20));
        l2.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        f.add(l2);
        t2 = new RoundPasswordField(15);
        t2.setBounds(765, 320, 200, 30);
        t2.setBackground(Color.white);
        t2.setForeground(Color.black);
        t2.setFont(new Font("Helvetica", Font.BOLD, 15));
        f.add(t2);

        b1 = new JButton("Login");
        b1.setBounds(700, 415, 120, 35);
        b1.setFont(new Font("Helvetica", Font.BOLD, 17));
        b1.addActionListener(this);
        f.add(b1);

        b2 = new JButton("Forgot Password");
        b2.setBounds(665, 475, 190, 35);
        b2.setFont(new Font("Helvetica", Font.BOLD, 17));
        b2.addActionListener(this);
        f.add(b2);

        showpassword = new JCheckBox("Show Password");
        showpassword.setBounds(765, 360, 150, 30);
        showpassword.setFont(new Font("Helvetica", Font.BOLD, 14));
        showpassword.addActionListener(this);
        showpassword.setOpaque(false);
        showpassword.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        f.add(showpassword);

        l3 = new JLabel();
        l3.setBounds(590, 120, 500, 30);
        l3.setFont(new Font("Helvetica", Font.BOLD, 20));
        f.add(l3);

        f.setLayout(null);
        f.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == b1) {
            
            new admin_menu(f);
        }

        if (e.getSource() == showpassword) {
            if (showpassword.isSelected()) {
                t2.setEchoChar((char) 0);
            } else {
                t2.setEchoChar('\u2022');
            }
        }

        if (e.getSource() == b2) {

            f.getContentPane().removeAll();
            f.repaint();
            new forgotpassword(f);

        }
    }
}

class forgotpassword extends JFrame implements ActionListener {

    JLabel l1, l2, l3, l;
    JButton b1, b2;
    JTextField t1;
    JPasswordField t2, t3;
    JCheckBox showpassword, showpassword1;

    public forgotpassword(JFrame frame) {

        l = new JLabel("Change Password");
        l.setBounds(650, 170, 400, 30);
        l.setFont(new Font("Helvetica", Font.BOLD, 26));
        l.setForeground(Color.red);
        frame.add(l);

        l1 = new JLabel("Enter your Username:");
        l1.setBounds(540, 240, 225, 30);
        l1.setFont(new Font("Helvetica", Font.BOLD, 20));
        l1.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        frame.add(l1);
        t1 = new RoundJTextField(15);
        t1.setBounds(765, 240, 200, 30);
        t1.setBackground(Color.white);
        t1.setForeground(Color.black);
        t1.setFont(new Font("Helvetica", Font.BOLD, 15));
        frame.add(t1);

        l2 = new JLabel("Enter new Password:");
        l2.setBounds(540, 300, 225, 30);
        l2.setFont(new Font("Helvetica", Font.BOLD, 20));
        l2.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        frame.add(l2);
        t2 = new RoundPasswordField(15);
        t2.setBounds(765, 300, 200, 30);
        t2.setBackground(Color.white);
        t2.setForeground(Color.black);
        t2.setFont(new Font("Helvetica", Font.BOLD, 15));
        frame.add(t2);

        showpassword = new JCheckBox("Show Password");
        showpassword.setBounds(765, 340, 150, 30);
        showpassword.setFont(new Font("Helvetica", Font.BOLD, 14));
        showpassword.addActionListener(this);
        showpassword.setOpaque(false);
        showpassword.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        frame.add(showpassword);

        l3 = new JLabel("Confirm new Password:");
        l3.setBounds(540, 390, 225, 30);
        l3.setFont(new Font("Helvetica", Font.BOLD, 20));
        l3.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        frame.add(l3);
        t3 = new RoundPasswordField(15);
        t3.setBounds(770, 390, 200, 30);
        t3.setBackground(Color.white);
        t3.setForeground(Color.black);
        t3.setFont(new Font("Helvetica", Font.BOLD, 15));
        frame.add(t3);

        showpassword1 = new JCheckBox("Show Password");
        showpassword1.setBounds(765, 430, 150, 30);
        showpassword1.setFont(new Font("Helvetica", Font.BOLD, 14));
        showpassword1.addActionListener(this);
        showpassword1.setOpaque(false);
        showpassword1.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        frame.add(showpassword1);

        b1 = new JButton("Reset Password");
        b1.setBounds(540, 480, 200, 35);
        b1.setFont(new Font("Helvetica", Font.BOLD, 17));
        b1.addActionListener(this);
        frame.add(b1);

        b2 = new JButton("Go Back To Login");
        b2.setBounds(780, 480, 200, 35);
        b2.setFont(new Font("Helvetica", Font.BOLD, 17));
        b2.addActionListener(this);
        frame.add(b2);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == showpassword) {
            if (showpassword.isSelected()) {
                t2.setEchoChar((char) 0);
            } else {
                t2.setEchoChar('\u2022');
            }
        }

        if (e.getSource() == showpassword1) {
            if (showpassword1.isSelected()) {
                t3.setEchoChar((char) 0);
            } else {
                t3.setEchoChar('\u2022');
            }
        }

        if (e.getSource() == b2) {

            new login();

        }

        // if (e.getSource() == b1) {
        //     String username = t1.getText();
        //     String user_pasword = t2.getText();
        //     String confirm_password = t3.getText();
        //     String jdbcURL = "jdbc:postgresql://ec2-34-228-100-83.compute-1.amazonaws.com:5432/d1itre8d1ofteb";
        //     String username_db = "tklsjaddlzcmwj";
        //     String password_db = "0a962d95cc35d5a21dc4081cf4bca8abe21fa22727cee6e31b746df3cb4ffd47";
        //     try {

        //         Connection connection = DriverManager.getConnection(jdbcURL, username_db, password_db);

        //         String sql = "SELECT CASE WHEN EXISTS ( SELECT * FROM user_account WHERE username=?) THEN 'TRUE' ELSE 'FALSE' END";

        //         PreparedStatement statement1 = connection.prepareStatement(sql);

        //         statement1.setString(1, username);

        //         ResultSet data = statement1.executeQuery();

        //         while (data.next()) {
        //             String value = data.getString("case");
        //             if (user_pasword.equals(confirm_password)) {
        //                 if (value.equals("TRUE")) {
        //                     String sql1 = " update user_account set user_password=crypt(?,user_password) where username=?";
        //                     PreparedStatement stmt = connection.prepareStatement(sql1);
        //                     stmt.setString(1, user_pasword);
        //                     stmt.setString(2, username);
        //                     stmt.executeUpdate();
        //                     JOptionPane.showMessageDialog(null, "Password Updated Successfully");
        //                     new login();

        //                 } else {
        //                     JOptionPane.showMessageDialog(null, "No Such Username Exists");
        //                 }

        //             } else {
        //                 JOptionPane.showMessageDialog(null, "Entered password and Confirm password do not match");
        //             }
        //         }
        //         connection.close();

        //     } catch (SQLException ex) {
        //         JOptionPane.showMessageDialog(null, "Please Enter proper data in Proper Format");
        //     }

        // }
    }
}

public class App {

    public static void main(String[] args) throws Exception {
        new login();
    }

}
