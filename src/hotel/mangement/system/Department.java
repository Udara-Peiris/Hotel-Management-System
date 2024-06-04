package hotel.mangement.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.*;
import java.awt.event.*;

public class Department extends JFrame implements ActionListener{
    
    JTable table;
    JButton back;

    public Department() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel l1 = new JLabel("Department");
        l1.setBounds(150, 10, 100, 20);
        add(l1);
        
        JLabel l2 = new JLabel("Budget");
        l2.setBounds(450, 10, 100, 20);
        add(l2);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(270, 380, 120, 30);
        back.addActionListener(this);
        add(back);

        table = new JTable();
        table.setBounds(0, 50, 700, 350);
        add(table);
        
        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("SELECT * FROM department");
            table.setModel(DbUtils.resultSetToTableModel(rs));
                    
        }catch (Exception e) {
            e.printStackTrace();
        }
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(300, 50, 120, 30);
        back.addActionListener(this);
        add(back);
        
        setBounds(400, 200, 700, 480);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Reception();    
    }
    
    public static void main(String[] args) {
        new Department();
    }
}