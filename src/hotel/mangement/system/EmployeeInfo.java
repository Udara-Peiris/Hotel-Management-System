package hotel.mangement.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.*;
import java.awt.event.*;

public class EmployeeInfo extends JFrame implements ActionListener{
    
    JTable table;
    JButton back;

    public EmployeeInfo() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel l1 = new JLabel("Name");
        l1.setBounds(10, 10, 100, 20);
        add(l1);
        
        JLabel l2 = new JLabel("Age");
        l2.setBounds(180, 10, 100, 20);
        add(l2);
        
        JLabel l3 = new JLabel("Gender");
        l3.setBounds(310, 10, 100, 20);
        add(l3);
        
        JLabel l4 = new JLabel("Phone");
        l4.setBounds(450, 10, 100, 20);
        add(l4);
        
        JLabel l5 = new JLabel("E-Mail");
        l5.setBounds(600, 10, 100, 20);
        add(l5);
        
        JLabel l6 = new JLabel("Job");
        l6.setBounds(750, 10, 100, 20);
        add(l6);
        
        JLabel l7 = new JLabel("Salary");
        l7.setBounds(870, 10, 100, 20);
        add(l7);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(280, 400, 120, 30);
        back.addActionListener(this);
        add(back);

        table = new JTable();
        table.setBounds(0, 50, 1000, 480);
        add(table);
        
        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("SELECT * FROM employee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
                    
        }catch (Exception e) {
            e.printStackTrace();
        }
        
        setBounds(300, 200, 1000, 480);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Reception();    
    }
    
    public static void main(String[] args) {
        new EmployeeInfo();
    }
}