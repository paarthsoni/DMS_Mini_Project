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

    public login() {

        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setDefaultLookAndFeelDecorated(true);
        f.setLayout(null);
        f.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

public class App extends JFrame implements frame {

    public static void main(String[] args) throws Exception {
        new login();
    }

}
