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

public class add_referral extends JFrame implements ActionListener, frame {

    JLabel l, l1, l2, l3, l4, l5, l6;
    JButton b1, b2, b3;
    JTextField t1, t2, t3, t4, t5, t6;
    JRadioButton success, on_hold, denied;

    public add_referral(JFrame f) {

        f.getContentPane().removeAll();
        f.repaint();
        f.getContentPane().setBackground(Color.yellow);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setDefaultLookAndFeelDecorated(true);

        l = new JLabel("Add a Referral");
        l.setBounds(665, 30, 670, 50);
        l.setFont(new Font("Helvetica", Font.BOLD, 26));
        l.setForeground(Color.RED);
        f.add(l);

        l1 = new JLabel("Customer Name:");
        l1.setBounds(670, 100, 225, 30);
        l1.setFont(new Font("Helvetica", Font.BOLD, 20));
        l1.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        f.add(l1);
        t1 = new RoundJTextField(15);
        t1.setBounds(460, 140, 580, 30);
        t1.setBackground(Color.white);
        t1.setForeground(Color.black);
        t1.setFont(new Font("Helvetica", Font.BOLD, 15));
        f.add(t1);

        l2 = new JLabel("Email ID:");
        l2.setBounds(705, 180, 225, 30);
        l2.setFont(new Font("Helvetica", Font.BOLD, 20));
        l2.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        f.add(l2);
        t2 = new RoundJTextField(15);
        t2.setBounds(460, 220, 580, 30);
        t2.setBackground(Color.white);
        t2.setForeground(Color.black);
        t2.setFont(new Font("Helvetica", Font.BOLD, 15));
        f.add(t2);

        l3 = new JLabel("Age:");
        l3.setBounds(725, 260, 225, 30);
        l3.setFont(new Font("Helvetica", Font.BOLD, 20));
        l3.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        f.add(l3);
        t3 = new RoundJTextField(15);
        t3.setBounds(460, 300, 580, 30);
        t3.setBackground(Color.white);
        t3.setForeground(Color.black);
        t3.setFont(new Font("Helvetica", Font.BOLD, 15));
        f.add(t3);

        l4 = new JLabel("Contact Number:");
        l4.setBounds(680, 340, 225, 30);
        l4.setFont(new Font("Helvetica", Font.BOLD, 20));
        l4.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        f.add(l4);
        t4 = new RoundJTextField(15);
        t4.setBounds(460, 380, 580, 30);
        t4.setBackground(Color.white);
        t4.setForeground(Color.black);
        t4.setFont(new Font("Helvetica", Font.BOLD, 15));
        f.add(t4);

        l5 = new JLabel("Referral Code:");
        l5.setBounds(692, 420, 225, 30);
        l5.setFont(new Font("Helvetica", Font.BOLD, 20));
        l5.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        f.add(l5);
        t5 = new RoundJTextField(15);
        t5.setBounds(460, 460, 580, 30);
        t5.setBackground(Color.white);
        t5.setForeground(Color.black);
        t5.setFont(new Font("Helvetica", Font.BOLD, 15));
        f.add(t5);

        l6 = new JLabel("Customer Requirement:");
        l6.setBounds(655, 500, 225, 30);
        l6.setFont(new Font("Helvetica", Font.BOLD, 20));
        l6.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        f.add(l6);
        t6 = new RoundJTextField(15);
        t6.setBounds(460, 540, 580, 30);
        t6.setBackground(Color.white);
        t6.setForeground(Color.black);
        t6.setFont(new Font("Helvetica", Font.BOLD, 15));
        f.add(t6);

        l = new JLabel("Status Of Referral:");
        l.setBounds(460, 590, 225, 30);
        l.setFont(new Font("Helvetica", Font.BOLD, 20));
        l.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        f.add(l);
        success = new JRadioButton("Success");
        success.setBounds(640, 590, 150, 30);
        success.setFont(new Font("Helvetica", Font.BOLD, 20));
        success.addActionListener(this);
        success.setOpaque(false);
        success.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        f.add(success);
        on_hold = new JRadioButton("On Hold");
        on_hold.setBounds(800, 590, 130, 30);
        on_hold.setFont(new Font("Helvetica", Font.BOLD, 20));
        on_hold.addActionListener(this);
        on_hold.setOpaque(false);
        on_hold.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        f.add(on_hold);
        denied = new JRadioButton("Denied");
        denied.setBounds(950, 590, 150, 30);
        denied.setFont(new Font("Helvetica", Font.BOLD, 20));
        denied.addActionListener(this);
        denied.setOpaque(false);
        denied.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        f.add(denied);

        b1 = new JButton("Go Back");
        b1.setBounds(460, 640, 275, 35);
        b1.setFont(new Font("Helvetica", Font.BOLD, 17));
        b1.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        b1.setBackground(Color.RED);
        b1.addActionListener(this);
        f.add(b1);

        b2 = new JButton("Add Referral");
        b2.setBounds(760, 640, 275, 35);
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

        if (e.getSource() == b2) {
            String customer_name = t1.getText();
            String email = t2.getText();
            String age = t3.getText();
            String contact = t4.getText();
            String rcode = t5.getText();
            String requirememts = t6.getText();
            String status;
            if (success.isSelected()) {
                status = success.getText();

            } else if (on_hold.isSelected()) {
                status = on_hold.getText();
            } else if (denied.isSelected()) {
                status = denied.getText();
            } else {
                status = "";
            }
            int customer_age = Integer.parseInt(age);
            int referralcode = Integer.parseInt(rcode);

            boolean data = customer_name.matches("^[a-zA-Z\\s]*$");
            boolean data1 = email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
            boolean data2 = age.matches("[0-9]+");
            boolean data3 = contact.matches("[0-9]+");
            boolean data4 = rcode.matches("[0-9]+");

            String jdbcURL = "jdbc:postgresql://localhost:5432/mydb";
            String username_db = "postgres";
            String password_db = "paarth@2812";
            try {
                Connection connection = DriverManager.getConnection(jdbcURL, username_db, password_db);
                if ((!t1.getText().equals("")) && (!t2.getText().equals("")) && (!t3.getText().equals(""))
                        && (!t4.getText().equals("")) && (!t5.getText().equals("")) && (!t6.getText().equals(""))) {
                    if ((data) && (data1) && (data2) && (data3) && (data4) && contact.length() == 10) {

                        String rcode_check = "SELECT CASE WHEN EXISTS ( SELECT * FROM employee WHERE eid=?) THEN 'TRUE' ELSE 'FALSE' END";
                        PreparedStatement statement_check = connection.prepareStatement(rcode_check);

                        statement_check.setInt(1, referralcode);
                        ResultSet a = statement_check.executeQuery();
                        while (a.next()) {
                            String value = a.getString("case");
                            if (value.equals("TRUE")) {
                                String insert_referral = "insert into customer_through_referralcode values(?,?,?,?,?,?,?)";
                                PreparedStatement statement_insert = connection.prepareStatement(insert_referral);
                                statement_insert.setString(1, customer_name);
                                statement_insert.setString(2, contact);
                                statement_insert.setString(3, email);
                                statement_insert.setInt(4, customer_age);
                                statement_insert.setInt(5, referralcode);
                                statement_insert.setString(6, requirememts);
                                statement_insert.setString(7, status);

                                statement_insert.executeUpdate();

                                String insert_count = "update total_customer_count set total_customer_throughreferral=total_customer_throughreferral+1 where eid=?";
                                PreparedStatement statement_insert_count = connection.prepareStatement(insert_count);
                                statement_insert_count.setInt(1, referralcode);

                                statement_insert_count.executeUpdate();

                                if (status.equals("Success")) {
                                    String update = "update total_customer_count set success_referral=success_referral+1 where eid=?";
                                    PreparedStatement update_data = connection.prepareStatement(update);

                                    update_data.setInt(1, referralcode);
                                    update_data.executeUpdate();

                                    String bonus = "update employee set bonus=bonus+1000 where eid=?";
                                    PreparedStatement bonusadata = connection.prepareStatement(bonus);
                                    bonusadata.setInt(1, referralcode);

                                    bonusadata.executeUpdate();

                                }

                                if (status.equals("On Hold")) {
                                    String update = "update total_customer_count set onhold_referral=onhold_referral+1 where eid=?";
                                    PreparedStatement update_data = connection.prepareStatement(update);
                                    update_data.setInt(1, referralcode);
                                    update_data.executeUpdate();

                                }

                                if (status.equals("Denied")) {
                                    String update = "update total_customer_count set denied=denied+1 where eid=?";
                                    PreparedStatement update_data = connection.prepareStatement(update);
                                    update_data.setInt(1, referralcode);
                                    update_data.executeUpdate();
                                }

                                String select = "select total_customer_throughreferral,success_referral from total_customer_count where eid=?";
                                PreparedStatement selectdata = connection.prepareStatement(select);

                                selectdata.setInt(1, referralcode);

                                ResultSet e_data = selectdata.executeQuery();
                                float ratio = 0;
                                int total = 0;
                                int success = 0;

                                while (e_data.next()) {
                                    total = e_data.getInt("total_customer_throughreferral");
                                    success = e_data.getInt("success_referral");

                                }

                                ratio = (float) success / total;
                                ratio = ratio * 100;
                                String update_ratio = "update employee set success_ratio=? where eid=?";
                                PreparedStatement stmt_update = connection.prepareStatement(update_ratio);

                                stmt_update.setFloat(1, ratio);
                                stmt_update.setInt(2, referralcode);

                                stmt_update.executeUpdate();

                                JOptionPane.showMessageDialog(f, "Referral added Successfully");
                                new admin_menu(f);

                            } else if (value.equals("FALSE")) {
                                JOptionPane.showMessageDialog(f, "Sorry!! No Such Referral Code available");
                            }
                        }

                    } else if ((!data)) {
                        JOptionPane.showMessageDialog(f, "Only Characters are allowed for First Name");
                    } else if ((!data1)) {
                        JOptionPane.showMessageDialog(f, "Invalid Email ID");

                    } else if ((!data2)) {
                        JOptionPane.showMessageDialog(f, "Only Numbers are allowed for age");
                    } else if ((!data3)) {
                        JOptionPane.showMessageDialog(f, "Only Numbers are allowed for contact number");
                    } else if ((!data4)) {
                        JOptionPane.showMessageDialog(f, "Only Numbers are allowed for referral code");
                    } else if (contact.length() != 10) {
                        JOptionPane.showMessageDialog(f, "Invalid Mobile Number");
                    }

                } else {
                    JOptionPane.showMessageDialog(f, "All Input Fields are Required");
                }

            } catch (SQLException e1) {

            }
        }

        if (e.getSource() == success) {
            if (success.isSelected()) {
                on_hold.setEnabled(false);
                denied.setEnabled(false);
            } else if ((!success.isSelected())) {
                on_hold.setEnabled(true);
                denied.setEnabled(true);
            }

        }

        if (e.getSource() == on_hold) {
            if (on_hold.isSelected()) {
                success.setEnabled(false);
                denied.setEnabled(false);
            } else if ((!on_hold.isSelected())) {
                success.setEnabled(true);
                denied.setEnabled(true);
            }

        }

        if (e.getSource() == denied) {
            if (denied.isSelected()) {
                on_hold.setEnabled(false);
                success.setEnabled(false);
            } else if ((!success.isSelected())) {
                on_hold.setEnabled(true);
                success.setEnabled(true);
            }
        }

    }
}
