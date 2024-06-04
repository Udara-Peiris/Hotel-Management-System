package hotel.mangement.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.*;
import java.awt.event.*;

public class CustomerInfo extends JFrame implements ActionListener{
    
    JTable table;
    JButton back;

    public CustomerInfo() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel l1 = new JLabel("Cus_Id");
        l1.setBounds(10, 10, 100, 20);
        add(l1);
        
        JLabel l2 = new JLabel("Document");
        l2.setBounds(120, 10, 100, 20);
        add(l2);
        
        JLabel l3 = new JLabel("Number");
        l3.setBounds(230, 10, 100, 20);
        add(l3);
        
        JLabel l4 = new JLabel("Name");
        l4.setBounds(360, 10, 100, 20);
        add(l4);
        
        JLabel l5 = new JLabel("Gender");
        l5.setBounds(450, 10, 100, 20);
        add(l5);
        
        JLabel l6 = new JLabel("Country");
        l6.setBounds(550, 10, 100, 20);
        add(l6);
        
        JLabel l7 = new JLabel("Room");
        l7.setBounds(700, 10, 100, 20);
        add(l7);
        
        JLabel l8 = new JLabel("Check In Time");
        l8.setBounds(780, 10, 100, 20);
        add(l8);
        
        JLabel l9 = new JLabel("Deposit");
        l9.setBounds(900, 10, 100, 20);
        add(l9);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(250, 380, 120, 30);
        back.addActionListener(this);
        add(back);

        table = new JTable();
        table.setBounds(0, 50, 1000, 480);
        add(table);
        
        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("SELECT * FROM customer");
            table.setModel(DbUtils.resultSetToTableModel(rs));
                    
        }catch (Exception e) {
            e.printStackTrace();
        }
        
        setBounds(300, 200, 1000, 480);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);
            new Reception();
        }  
    }
    
    public static void main(String[] args) {
        new CustomerInfo();
    }
}