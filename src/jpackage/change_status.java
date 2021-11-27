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

    public change_status(JFrame f) {

        f.getContentPane().removeAll();
        f.repaint();
        f.getContentPane().setBackground(Color.yellow);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setDefaultLookAndFeelDecorated(true);

        l = new JLabel("Change Status Of Referral to Success");
        l.setBounds(520, 60, 670, 50);
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

        b2 = new JButton("Change Status");
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

        if (e.getSource() == b2) {
            String name = t1.getText();
            String contact = t2.getText();
            String rcode = t3.getText();
            int referralcode = Integer.parseInt(rcode);
            boolean data = name.matches("^[a-zA-Z\\s]*$");
            boolean data1 = contact.matches("[0-9]+");
            boolean data2 = rcode.matches("[0-9]+");

            String jdbcURL = "jdbc:postgresql://localhost:5432/mydb";
            String username_db = "postgres";
            String password_db = "paarth@2812";
            if ((!t1.getText().equals("")) && (!t2.getText().equals("")) && (!t3.getText().equals(""))) {

                if ((data) && (data1) && (data2) && contact.length() == 10) {
                    try {
                        Connection connection = DriverManager.getConnection(jdbcURL, username_db, password_db);

                        String check = "SELECT CASE WHEN EXISTS ( SELECT * FROM customer_through_referralcode where name=? and mobile_no=? and rid=?) THEN 'TRUE' ELSE 'FALSE' END";
                        PreparedStatement statement_check = connection.prepareStatement(check);

                        statement_check.setString(1, name);
                        statement_check.setString(2, contact);
                        statement_check.setInt(3, referralcode);

                        ResultSet b = statement_check.executeQuery();

                        while (b.next()) {
                            String value = b.getString("case");
                            if (value.equals("TRUE")) {
                                String sql = "select referral_status from customer_through_referralcode where name=? and mobile_no=? and rid=?";
                                PreparedStatement statement_status = connection.prepareStatement(sql);

                                statement_status.setString(1, name);
                                statement_status.setString(2, contact);
                                statement_status.setInt(3, referralcode);

                                ResultSet a = statement_status.executeQuery();

                                while (a.next()) {
                                    String value1 = a.getString("referral_status");
                                    if ((!value1.equals("Success"))) {
                                        String update = "update customer_through_referralcode set referral_status='Success' where name=? and mobile_no=? and rid=?  ";
                                        PreparedStatement statement_update = connection.prepareStatement(update);
                                        statement_update.setString(1, name);
                                        statement_update.setString(2, contact);
                                        statement_update.setInt(3, referralcode);

                                        statement_update.executeUpdate();

                                        String update_perfomance = "update total_customer_count set success_referral=success_referral+1 where eid=?";
                                        PreparedStatement statement_update_perfomance = connection
                                                .prepareStatement(update_perfomance);
                                        statement_update_perfomance.setInt(1, referralcode);

                                        statement_update_perfomance.executeUpdate();

                                        if (value1.equals("On Hold")) {
                                            String reduce = "update total_customer_count set onhold_referral=onhold_referral-1 where eid=?";
                                            PreparedStatement statement_reduce = connection.prepareStatement(reduce);
                                            statement_reduce.setInt(1, referralcode);
                                            statement_reduce.executeUpdate();
                                        }

                                        if (value1.equals("Denied") || value1.equals("denied")) {
                                            String reduce = "update total_customer_count set denied=denied-1 where eid=?";
                                            PreparedStatement statement_reduce = connection.prepareStatement(reduce);
                                            statement_reduce.setInt(1, referralcode);
                                            statement_reduce.executeUpdate();
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
                                        JOptionPane.showMessageDialog(f,
                                                "Referral Status Changed Successfully ");
                                        new admin_menu(f);

                                    } else {
                                        JOptionPane.showMessageDialog(f,
                                                "Can't Change the Status!! Already a Success Referral ");
                                    }

                                }

                            } else {
                                JOptionPane.showMessageDialog(f, "Sorry!! No such Customer");
                            }
                        }

                    } catch (SQLException e1) {
                        JOptionPane.showMessageDialog(f, e1);
                    }
                } else if ((!data)) {
                    JOptionPane.showMessageDialog(f, "Only Characters are allowed for First Name");
                } else if ((!data1)) {
                    JOptionPane.showMessageDialog(f, "only Numbers are allowed for contact number");

                } else if ((!data2)) {
                    JOptionPane.showMessageDialog(f, "only Numbers are allowed for referral code");

                } else if (contact.length() != 10) {
                    JOptionPane.showMessageDialog(f, "Invalid Contact Number");

                }

            } else {
                JOptionPane.showMessageDialog(f, "All Input Fields are Required");
            }

        }

    }

}
