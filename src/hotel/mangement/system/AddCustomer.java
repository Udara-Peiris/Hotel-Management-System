package hotel.mangement.system;

//import com.mysql.cj.protocol.Resultset;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;
import java.awt.event.*;

public class AddCustomer extends JFrame implements ActionListener{
    
    JComboBox comboDoc;
    JTextField tfNumber, tfName, tfCountry, tfDeposit;
    JRadioButton rMale, rFemale;
    JButton add, back;
    JLabel checkInTime;
    Choice cRoom;
    

    public AddCustomer(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("NEW CUSTOMER FORM");
        text.setBounds(100, 20, 300, 30);
        text.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(text);
        
        JLabel lblDocument = new JLabel("Document");
        lblDocument.setBounds(35, 80, 100, 20);
        lblDocument.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(lblDocument);
        
        String options[] = {"NIC", "Passport", "Driving License", "Voter-id Card", "Relation Card"};
        comboDoc = new JComboBox(options);
        comboDoc.setBounds(200, 80, 150, 25);
        comboDoc.setBackground(Color.WHITE);
        add(comboDoc);
        
        JLabel lblNumber = new JLabel("Number");
        lblNumber.setBounds(35, 120, 100, 20);
        lblNumber.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(lblNumber);
        
        tfNumber = new JTextField();
        tfNumber.setBounds(200, 120, 150, 25);
        add(tfNumber);
        
        JLabel lblName = new JLabel("Name");
        lblName.setBounds(35, 160, 100, 20);
        lblName.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(lblName);
        
        tfName = new JTextField();
        tfName.setBounds(200, 160, 150, 25);
        add(tfName);
        
        JLabel lblGender = new JLabel("Gender");
        lblGender.setBounds(35, 200, 100, 20);
        lblGender.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(lblGender);
        
        rMale = new JRadioButton("Male");
        rMale.setBackground(Color.WHITE);
        rMale.setBounds(200, 200, 60, 25);
        add(rMale);
        
        rFemale = new JRadioButton("Female");
        rFemale.setBackground(Color.WHITE);
        rFemale.setBounds(270, 200, 100, 25);
        add(rFemale);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(rMale);
        bg.add(rFemale);
        
        JLabel lblCountry = new JLabel("Country");
        lblCountry.setBounds(35, 240, 100, 20);
        lblCountry.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(lblCountry);
        
        tfCountry = new JTextField();
        tfCountry.setBounds(200, 240, 150, 25);
        add(tfCountry);
        
        JLabel lblRoom = new JLabel("Room Number");
        lblRoom.setBounds(35, 280, 150, 20);
        lblRoom.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(lblRoom);
        
        cRoom = new Choice();
        
        try {
            Conn conn = new Conn();
            String query = "SELECT * FROM roomsdetails WHERE available = 'Available'";
            
            ResultSet rs = conn.s.executeQuery(query);
            
            while (rs.next()) {
                cRoom.add(rs.getString("roomNo"));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        cRoom.setBounds(200, 280, 190, 25);
        add(cRoom);
        
        JLabel lblTime = new JLabel("Checkin Time");
        lblTime.setBounds(35, 320, 150, 20);
        lblTime.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(lblTime);
        
        Date date = new Date();
        
        checkInTime = new JLabel("" + date);
        checkInTime.setBounds(200, 320, 150, 20);
        checkInTime.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(checkInTime);
        
        JLabel lblDeposit = new JLabel("Deposit");
        lblDeposit.setBounds(35, 360, 100, 20);
        lblDeposit.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(lblDeposit);
        
        tfDeposit = new JTextField();
        tfDeposit.setBounds(200, 360, 150, 25);
        add(tfDeposit);
        
        add = new JButton("Add");
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setBounds(50, 410, 120, 30);
        add.addActionListener(this);
        add(add);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(200, 410, 120, 30);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 50, 300, 400);
        add(image);
        
        
        setBounds(350, 200, 800, 550);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            
            String document = (String)comboDoc.getSelectedItem();
            String number = tfNumber.getText();
            String name = tfName.getText();
            String gender = null;
            
            if(rMale.isSelected()) {
                gender = "Male";
            } else {
                gender = "Female";
            }
            
            String country = tfCountry.getText();
            String room = cRoom.getSelectedItem();
            String time = checkInTime.getText();
            String deposit = tfDeposit.getText();
            
            try {
                
                Conn conn = new Conn();
                
                String query = "INSERT INTO customer (document, number, name, gender, country, room,checkintime, deposit) VALUES('"+ document +"', '"+ number +"', '"+ name +"', '"+ gender +"', '"+ country +"', '"+ room +"', '"+ time +"', '"+ deposit +"')";
                String query2 = "UPDATE roomsdetails SET available = 'Occupied' WHERE roomNo = '"+ room +"'";
                
                conn.s.executeUpdate(query);
                conn.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null, "New Customer Added Successfully");
                
                setVisible(false);
                new Reception();
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Reception();
        }
    }
    
    public static void main(String[] args) {
        new AddCustomer();
    }
    
    
}
