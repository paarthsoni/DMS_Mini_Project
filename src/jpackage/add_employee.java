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

public class add_employee extends JFrame implements ActionListener, frame {

    JLabel l, l1, l2, l3, l4, l5, l6, l7, l8;
    JButton b1, b2;
    JTextField t1, t2, t3, t4, t5, t6, t7;
    JRadioButton male, female, other;

    public add_employee(JFrame f) {

        f.getContentPane().removeAll();
        f.repaint();
        f.getContentPane().setBackground(Color.yellow);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setDefaultLookAndFeelDecorated(true);

        l7 = new JLabel("Add Employee");
        l7.setBounds(670, 50, 670, 150);
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

        l7 = new JLabel("Employee's Salary");
        l7.setBounds(670, 320, 225, 30);
        l7.setFont(new Font("Helvetica", Font.BOLD, 20));
        l7.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        f.add(l7);
        t7 = new RoundJTextField(15);
        t7.setBounds(460, 360, 580, 30);
        t7.setBackground(Color.white);
        t7.setForeground(Color.black);
        t7.setFont(new Font("Helvetica", Font.BOLD, 15));
        f.add(t7);

        l4 = new JLabel("Email ID:");
        l4.setBounds(705, 400, 225, 30);
        l4.setFont(new Font("Helvetica", Font.BOLD, 20));
        l4.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        f.add(l4);
        t4 = new RoundJTextField(15);
        t4.setBounds(460, 440, 580, 30);
        t4.setBackground(Color.white);
        t4.setForeground(Color.black);
        t4.setFont(new Font("Helvetica", Font.BOLD, 15));
        f.add(t4);

        l5 = new JLabel("Department Name:");
        l5.setBounds(670, 480, 225, 30);
        l5.setFont(new Font("Helvetica", Font.BOLD, 20));
        l5.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        f.add(l5);
        t5 = new RoundJTextField(15);
        t5.setBounds(460, 520, 580, 30);
        t5.setBackground(Color.white);
        t5.setForeground(Color.black);
        t5.setFont(new Font("Helvetica", Font.BOLD, 15));
        f.add(t5);

        l6 = new JLabel("Contact Number:");
        l6.setBounds(680, 560, 225, 30);
        l6.setFont(new Font("Helvetica", Font.BOLD, 20));
        l6.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        f.add(l6);
        t6 = new RoundJTextField(15);
        t6.setBounds(460, 600, 580, 30);
        t6.setBackground(Color.white);
        t6.setForeground(Color.black);
        t6.setFont(new Font("Helvetica", Font.BOLD, 15));
        f.add(t6);

        b1 = new JButton("Go Back");
        b1.setBounds(460, 660, 275, 35);
        b1.setFont(new Font("Helvetica", Font.BOLD, 17));
        b1.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        b1.setBackground(Color.RED);
        b1.addActionListener(this);
        f.add(b1);

        b2 = new JButton("Add Employee");
        b2.setBounds(760, 660, 275, 35);
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
            String fname = t1.getText();
            String mname = t2.getText();
            String lname = t3.getText();
            String gender;
            if (male.isSelected()) {
                gender = male.getText();

            } else if (female.isSelected()) {
                gender = female.getText();
            } else if (other.isSelected()) {
                gender = other.getText();
            } else {
                gender = "";
            }
            String salary = t7.getText();
            String email = t4.getText();
            String dname = t5.getText();
            String contact = t6.getText();
            String jdbcURL = "jdbc:postgresql://localhost:5432/mydb";
            String username_db = "postgres";
            String password_db = "paarth@2812";
            boolean data = fname.matches("[a-zA-Z]+");
            boolean data1 = mname.matches("[a-zA-Z]+");
            boolean data2 = lname.matches("[a-zA-Z]+");
            boolean data3 = contact.matches("[0-9]+");
            boolean data4 = salary.matches("[0-9]+");
            boolean data5 = email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
            int e_salary = Integer.parseInt(salary);

            try {
                Connection connection = DriverManager.getConnection(jdbcURL, username_db, password_db);

                if ((!t1.getText().equals("")) && (!t2.getText().equals("")) && (!t3.getText().equals(""))
                        && (!t4.getText().equals("")) && (!t5.getText().equals("")) && (!t6.getText().equals(""))
                        && (!t7.getText().equals(""))) {
                    if ((data) && (data1) && (data2) && (data3) && (data4) && (data5) && contact.length() == 10
                            && e_salary > 0 && dname.equals("Engineering") || dname.equals("Sales")
                            || dname.equals("Design")) {

                        String sql1 = "SELECT * FROM employee ORDER BY eid DESC LIMIT 1";
                        Statement stmt_id = connection.createStatement();
                        int eid = 0;
                        int bonus = 0;
                        int success_ratio = 0;
                        ResultSet a = stmt_id.executeQuery(sql1);
                        while (a.next()) {
                            eid = a.getInt("eid");
                            eid = eid + 1;

                        }

                        String sql = "insert into employee (fname,mname,lname,gender,eid,bonus,salary,success_ratio,email,dname,contact) values(?,?,?,?,?,?,?,?,?,?,?)";
                        PreparedStatement statement1 = connection.prepareStatement(sql);
                        statement1.setString(1, fname);
                        statement1.setString(2, mname);
                        statement1.setString(3, lname);
                        statement1.setString(4, gender);
                        statement1.setInt(5, eid);
                        statement1.setInt(6, bonus);
                        statement1.setInt(7, e_salary);
                        statement1.setInt(8, success_ratio);
                        statement1.setString(9, email);
                        statement1.setString(10, dname);
                        statement1.setString(11, contact);
                        statement1.executeUpdate();
                        int totalreferral = 0;
                        int successreferral = 0;
                        int onholdreferral = 0;
                        int deniedreferral = 0;
                        String customer_count = "insert into total_customer_count values(?,?,?,?,?,?,?)";
                        PreparedStatement stmt_count = connection.prepareStatement(customer_count);
                        stmt_count.setString(1, fname);
                        stmt_count.setString(2, lname);
                        stmt_count.setInt(3, eid);
                        stmt_count.setInt(4, totalreferral);
                        stmt_count.setInt(5, successreferral);
                        stmt_count.setInt(6, onholdreferral);
                        stmt_count.setInt(7, deniedreferral);

                        stmt_count.executeUpdate();

                        if (dname.equals("Engineering")) {
                            String engtype = JOptionPane.showInputDialog("Enter the Type of Engineer:");
                            String eng = "insert into engineer (eid,engtype,dname) values(?,?,?)";
                            PreparedStatement stmt_eng = connection.prepareStatement(eng);
                            stmt_eng.setInt(1, eid);
                            stmt_eng.setString(2, engtype);
                            stmt_eng.setString(3, dname);

                            stmt_eng.executeUpdate();

                            String department_update = "update department set total_employee=total_employee+1 where dname=?";
                            PreparedStatement update = connection.prepareStatement(department_update);
                            update.setString(1, dname);

                            update.executeUpdate();

                        }

                        if (dname.equals("Sales")) {
                            String hours = JOptionPane.showInputDialog("Enter the employee Working Hours:");
                            int hoursworked = Integer.parseInt(hours);
                            String sales = "insert into salesperson (sid,hours_worked,dname) values(?,?,?)";
                            PreparedStatement stmt_sales = connection.prepareStatement(sales);
                            stmt_sales.setInt(1, eid);
                            stmt_sales.setInt(2, hoursworked);
                            stmt_sales.setString(3, dname);

                            stmt_sales.executeUpdate();

                            String department_update = "update department set total_employee=total_employee+1 where dname=?";
                            PreparedStatement update = connection.prepareStatement(department_update);
                            update.setString(1, dname);

                            update.executeUpdate();

                        }

                        if (dname.equals("Design")) {
                            String position = JOptionPane.showInputDialog("Enter the position of the Employee:");

                            String design = "insert into architect (aid,position_of_architect,dname) values(?,?,?)";
                            PreparedStatement stmt_design = connection.prepareStatement(design);
                            stmt_design.setInt(1, eid);
                            stmt_design.setString(2, position);
                            stmt_design.setString(3, dname);

                            stmt_design.executeUpdate();

                            String department_update = "update department set total_employee=total_employee+1 where dname=?";
                            PreparedStatement update = connection.prepareStatement(department_update);
                            update.setString(1, dname);

                            update.executeUpdate();

                        }

                        JOptionPane.showMessageDialog(f, "Employee added Successfully \n Employee ID - " + eid);
                        new admin_menu(f);

                    } else if ((!data)) {
                        JOptionPane.showMessageDialog(f, "Only Characters are allowed for First Name");
                    } else if ((!data1)) {
                        JOptionPane.showMessageDialog(f, "Only Characters are allowed for Middle Name");
                    } else if ((!data2)) {
                        JOptionPane.showMessageDialog(f, "Only Characters are allowed for Last Name");
                    } else if ((!data3)) {
                        JOptionPane.showMessageDialog(f, "Only Numbers are allowed for Contact Number");
                    } else if ((!data4)) {
                        JOptionPane.showMessageDialog(f, "Only Numbers are allowed for Employee's Salary");
                    } else if ((!data5)) {
                        JOptionPane.showMessageDialog(f, "Invalid Email ID");
                    } else if (contact.length() != 10) {
                        JOptionPane.showMessageDialog(f, "Invalid Mobile Number");
                    } else if ((!dname.equals("Engineering")) || (!dname.equals("Sales"))
                            || (!dname.equals("Design"))) {
                        JOptionPane.showMessageDialog(f, "Entered Department does not exists in the Organization ");
                    } else if (e_salary <= 0) {
                        JOptionPane.showMessageDialog(f, "Salary should be greater than 0");
                    }

                } else {
                    JOptionPane.showMessageDialog(f, "All Input Fields are Required");
                }

            } catch (SQLException e1) {
                JOptionPane.showMessageDialog(f, e1);
            }

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
