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

public class admin_menu extends JFrame implements ActionListener, frame {

    JButton b1, b2, b3, b4, b5, b6, b7, b8, b9;
    JFrame f1;
    JTable t1;

    public admin_menu(JFrame f) {

        f.getContentPane().removeAll();
        f.repaint();
        f.getContentPane().setBackground(Color.yellow);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setDefaultLookAndFeelDecorated(true);

        b1 = new JButton("Add a new Employee");
        b1.setBounds(630, 200, 340, 50);
        b1.setFont(new Font("Helvetica", Font.BOLD, 17));
        b1.addActionListener(this);
        f.add(b1);

        b2 = new JButton("View Employees Details");
        b2.setBounds(630, 300, 340, 50);
        b2.setFont(new Font("Helvetica", Font.BOLD, 17));
        b2.addActionListener(this);
        f.add(b2);

        b3 = new JButton("Add a Referral");
        b3.setBounds(630, 400, 340, 50);
        b3.setFont(new Font("Helvetica", Font.BOLD, 17));
        b3.addActionListener(this);
        f.add(b3);

        b4 = new JButton("Change The Status of Referral");
        b4.setBounds(630, 500, 340, 50);
        b4.setFont(new Font("Helvetica", Font.BOLD, 17));
        b4.addActionListener(this);
        f.add(b4);

        b8 = new JButton("View all the Referral Customers");
        b8.setBounds(630, 600, 340, 50);
        b8.setFont(new Font("Helvetica", Font.BOLD, 17));
        b8.addActionListener(this);
        f.add(b8);

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
            f.getContentPane().removeAll();
            f.repaint();

            b6 = new JButton("View All Employees");
            b6.setBounds(640, 200, 280, 50);
            b6.setFont(new Font("Helvetica", Font.BOLD, 17));
            b6.addActionListener(this);
            f.add(b6);

            b7 = new JButton("View Employees Perfomance");
            b7.setBounds(640, 300, 280, 50);
            b7.setFont(new Font("Helvetica", Font.BOLD, 17));
            b7.addActionListener(this);
            f.add(b7);

            b9 = new JButton("Go back to Menu");
            b9.setBounds(640, 400, 280, 50);
            b9.setFont(new Font("Helvetica", Font.BOLD, 17));
            b9.addActionListener(this);
            b9.setBackground(Color.red);
            f.add(b9);

        }

        if (e.getSource() == b9) {
            new admin_menu(f);
        }

        if (e.getSource() == b6) {
            String jdbcURL = "jdbc:postgresql://localhost:5432/mydb";
            String username_db = "postgres";
            String password_db = "paarth@2812";
            Connection connection;
            try {
                connection = DriverManager.getConnection(jdbcURL, username_db, password_db);
                f1 = new JFrame("Employee Details");
                // f1.setSize(500, 500);
                f1.setExtendedState(JFrame.MAXIMIZED_BOTH);
                f1.setDefaultLookAndFeelDecorated(true);
                f1.setVisible(true);
                f1.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

                DefaultTableModel model = new DefaultTableModel();

                t1 = new JTable(model);
                t1.setRowHeight(40);
                t1.setEnabled(false);
                model.addColumn("Employee's First name");
                model.addColumn("Employee's Middle name");
                model.addColumn("Employee's last Name");
                model.addColumn("Gender");
                model.addColumn("Employee ID");
                model.addColumn("Bonus");
                model.addColumn("Salary");
                model.addColumn("Success Ratio");
                model.addColumn("Email ID");
                model.addColumn("Contact Number");
                model.addColumn("Department Name");

                String employees = "select * from employee";

                Statement stmt_employees_data = connection.createStatement();

                ResultSet employee_data = stmt_employees_data.executeQuery(employees);

                while (employee_data.next()) {
                    String fname = employee_data.getString("fname");
                    String mname = employee_data.getString("mname");
                    String lname = employee_data.getString("lname");
                    String gender = employee_data.getString("gender");
                    String eid = employee_data.getString("eid");
                    int bonus = employee_data.getInt("bonus");
                    int salary = employee_data.getInt("salary");
                    int success_ratio = employee_data.getInt("success_ratio");
                    String email = employee_data.getString("email");
                    String e_dname = employee_data.getString("dname");
                    String contact_num = employee_data.getString("contact");

                    model.addRow(new Object[] { fname, mname, lname, gender, eid, bonus, salary, success_ratio, email,
                            contact_num, e_dname });

                }
                JScrollPane sp = new JScrollPane(t1);
                f1.add(sp);

            } catch (SQLException e1) {
                JOptionPane.showMessageDialog(f, e1);
            }
        }

        if (e.getSource() == b8) {
            String jdbcURL = "jdbc:postgresql://localhost:5432/mydb";
            String username_db = "postgres";
            String password_db = "paarth@2812";
            Connection connection;
            try {
                connection = DriverManager.getConnection(jdbcURL, username_db, password_db);
                f1 = new JFrame("Customer(s) through Referrals");
                // f1.setSize(500, 500);
                f1.setExtendedState(JFrame.MAXIMIZED_BOTH);
                f1.setDefaultLookAndFeelDecorated(true);
                f1.setVisible(true);
                f1.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

                DefaultTableModel model = new DefaultTableModel();

                t1 = new JTable(model);
                t1.setRowHeight(40);
                t1.setEnabled(false);
                model.addColumn("Customer name");
                model.addColumn("Contact Number");
                model.addColumn("Email ID");
                model.addColumn("Age");
                model.addColumn("Employee's Referral ID");
                model.addColumn("Customer Requirements");

                String employees = "select * from customer_through_referralcode";

                Statement stmt_employees_data = connection.createStatement();

                ResultSet employee_data = stmt_employees_data.executeQuery(employees);

                while (employee_data.next()) {
                    String name = employee_data.getString("name");
                    String contact = employee_data.getString("mobile_no");
                    String email = employee_data.getString("email_id");
                    int age = employee_data.getInt("age");
                    int rid = employee_data.getInt("rid");
                    String requirements = employee_data.getString("requirements");

                    model.addRow(new Object[] { name, contact, email, age, rid, requirements });

                }
                JScrollPane sp = new JScrollPane(t1);
                f1.add(sp);

            } catch (SQLException e1) {
                JOptionPane.showMessageDialog(f, e1);
            }
        }

        if (e.getSource() == b7) {
            String jdbcURL = "jdbc:postgresql://localhost:5432/mydb";
            String username_db = "postgres";
            String password_db = "paarth@2812";
            Connection connection;
            try {
                connection = DriverManager.getConnection(jdbcURL, username_db, password_db);
                f1 = new JFrame("Employee's Perfomance");
                // f1.setSize(500, 500);
                f1.setExtendedState(JFrame.MAXIMIZED_BOTH);
                f1.setDefaultLookAndFeelDecorated(true);
                f1.setVisible(true);
                f1.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

                DefaultTableModel model = new DefaultTableModel();

                t1 = new JTable(model);
                t1.setRowHeight(40);
                t1.setEnabled(false);
                model.addColumn("Employee's First name");
                model.addColumn("Employee's last name");
                model.addColumn("Employee's ID");
                model.addColumn("Total Customer through Referral");
                model.addColumn("Success Referral(s)");
                model.addColumn("On Hold Referral(s)");

                String employees = "select * from total_customer_Count";

                Statement stmt_employees_data = connection.createStatement();

                ResultSet employee_data = stmt_employees_data.executeQuery(employees);

                while (employee_data.next()) {
                    String fname = employee_data.getString("employee_fname");
                    String lname = employee_data.getString("employee_lname");
                    String eid = employee_data.getString("eid");
                    int totalcustomer = employee_data.getInt("total_customer_throughreferral");
                    int success = employee_data.getInt("success_referral");
                    int hold = employee_data.getInt("onhold_referral");

                    model.addRow(new Object[] { fname, lname, eid, totalcustomer, success, hold });

                }
                JScrollPane sp = new JScrollPane(t1);
                f1.add(sp);

            } catch (SQLException e1) {
                JOptionPane.showMessageDialog(f, e1);
            }

        }

        if (e.getSource() == b4)

        {

        }

        if (e.getSource() == b5) {

            JOptionPane.showMessageDialog(f, "Logged out Successfully");
            new login();

        }

    }
}
