package hotel.mangement.system;

import java.awt.Color;
import javax.swing.*;
import java.awt.event.*;

public class Reception extends JFrame implements ActionListener{
    
    JButton newCus, rooms, department, employee, mngInfo, newCustomer, cusInfo;

    public Reception() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        rooms = new JButton("Rooms");
        rooms.setBounds(10, 70, 200, 30);
        rooms.setForeground(Color.WHITE);
        rooms.setBackground(Color.BLACK);
        rooms.addActionListener(this);
        add(rooms);
        
        department = new JButton("Department");
        department.setBounds(10, 110, 200, 30);
        department.setForeground(Color.WHITE);
        department.setBackground(Color.BLACK);
        department.addActionListener(this);
        add(department);
        
        employee = new JButton("All Employees");
        employee.setBounds(10, 150, 200, 30);
        employee.setForeground(Color.WHITE);
        employee.setBackground(Color.BLACK);
        employee.addActionListener(this);
        add(employee);
        
        cusInfo = new JButton("Customer Info");
        cusInfo.setBounds(10, 190, 200, 30);
        cusInfo.setForeground(Color.WHITE);
        cusInfo.setBackground(Color.BLACK);
        cusInfo.addActionListener(this);
        add(cusInfo);
        
        newCustomer = new JButton("New Customer Form");
        newCustomer.setBounds(10, 230, 200, 30);
        newCustomer.setForeground(Color.WHITE);
        newCustomer.setBackground(Color.BLACK);
        newCustomer.addActionListener(this);
        add(newCustomer);
        
        mngInfo = new JButton("Manager Info");
        mngInfo.setBounds(10, 270, 200, 30);
        mngInfo.setForeground(Color.WHITE);
        mngInfo.setBackground(Color.BLACK);
        mngInfo.addActionListener(this);
        add(mngInfo);
        
        JButton checkout = new JButton("Checkout");
        checkout.setBounds(10, 310, 200, 30);
        checkout.setForeground(Color.WHITE);
        checkout.setBackground(Color.BLACK);
        add(checkout);
        
        JButton upsStts = new JButton("Update Status");
        upsStts.setBounds(10, 350, 200, 30);
        upsStts.setForeground(Color.WHITE);
        upsStts.setBackground(Color.BLACK);
        add(upsStts);
        
        JButton upsRmStts = new JButton("Update Room Status");
        upsRmStts.setBounds(10, 390, 200, 30);
        upsRmStts.setForeground(Color.WHITE);
        upsRmStts.setBackground(Color.BLACK);
        add(upsRmStts);
        
        JButton pkupSer = new JButton("Pickup Service");
        pkupSer.setBounds(10, 430, 200, 30);
        pkupSer.setForeground(Color.WHITE);
        pkupSer.setBackground(Color.BLACK);
        add(pkupSer);
        
        JButton serchRm = new JButton("Search Room");
        serchRm.setBounds(10, 470, 200, 30);
        serchRm.setForeground(Color.WHITE);
        serchRm.setBackground(Color.BLACK);
        add(serchRm);
        
        JButton lgout = new JButton("Logout");
        lgout.setBounds(10, 510, 200, 30);
        lgout.setForeground(Color.WHITE);
        lgout.setBackground(Color.BLACK);
        add(lgout);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        JLabel image  = new JLabel(i1);
        image.setBounds(250, 30, 500, 470);
        add(image);
        
        setBounds(350, 150, 800, 600);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == newCustomer) {
            setVisible(false);
            new AddCustomer();
        }else if (ae.getSource() == rooms) {
            setVisible(false);
            new Room();
        }else if (ae.getSource() == department) {
            setVisible(false);
            new Department();
        }else if (ae.getSource() == employee) {
            setVisible(false);
            new EmployeeInfo();
        }else if (ae.getSource() == mngInfo) {
            setVisible(false);
            new ManagerInfo();
        }else if (ae.getSource() == cusInfo) {
            setVisible(false);
            new CustomerInfo();
        }
    }
    
    public static void main(String[] args) {
        new Reception();
    }
}
