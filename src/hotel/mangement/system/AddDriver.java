package hotel.mangement.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddDriver extends JFrame implements ActionListener{
    
    JTextField tfName, tfAge, tfCarModel, tfLocation;
    JComboBox genderCombo, carCompanyCombo;
    JButton add, cancel;
    
    public AddDriver() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Add Drivers");
        heading.setFont(new Font("Tahoma", Font.BOLD, 18));
        heading.setBounds(150, 10, 200, 20);
        add(heading);
        
        JLabel lblName = new JLabel("Name");
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblName.setBounds(60, 70, 120, 30);
        add(lblName);
        
        tfName = new JTextField();
        tfName.setBounds(200, 70, 150, 30);
        add(tfName);
        
        JLabel lblAge = new JLabel("Age");
        lblAge.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblAge.setBounds(60, 110, 120, 30);
        add(lblAge);
        
        tfAge = new JTextField();
        tfAge.setBounds(200, 110, 150, 30);
        add(tfAge);
        
        JLabel lblGender = new JLabel("Gender");
        lblGender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblGender.setBounds(60, 150, 120, 30);
        add(lblGender);
        
        String genderOption[] = {"Male", "Female"};
        genderCombo = new JComboBox(genderOption);
        genderCombo.setBounds(200, 150, 150, 30);
        genderCombo.setBackground(Color.WHITE);
        add(genderCombo);
        
        JLabel lblCarCompany = new JLabel("Car Company");
        lblCarCompany.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblCarCompany.setBounds(60, 190, 120, 30);
        add(lblCarCompany);
        
        String carCompanyOption[] = {"BMW", "Toyota", "Susuki", "Volga", "Nissan"};
        carCompanyCombo = new JComboBox(carCompanyOption);
        carCompanyCombo.setBounds(200, 190, 150, 30);
        carCompanyCombo.setBackground(Color.WHITE);
        add(carCompanyCombo);
        
        JLabel lblCarModel = new JLabel("Car Model");
        lblCarModel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblCarModel.setBounds(60, 230, 120, 30);
        add(lblCarModel);
        
        tfCarModel = new JTextField();
        tfCarModel.setBounds(200, 230, 150, 30);
        add(tfCarModel);
        
        
        JLabel lblLocation = new JLabel("Location");
        lblLocation.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblLocation.setBounds(60, 270, 120, 20);
        add(lblLocation);
        
        tfLocation = new JTextField();
        tfLocation.setBounds(200, 270, 150, 30);
        add(tfLocation);
        
        add = new JButton("Add Driver");
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.setBounds(60, 330, 130, 30);
        add.addActionListener(this);
        add(add);
        
        cancel = new JButton("Cancel");
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.setBounds(220, 330, 130, 30);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 30, 500, 300);
        add(image);
        
        
        
        setBounds(300, 200, 980, 470);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            
            String name = tfName.getText();
            int age = Integer.parseInt(tfAge.getText());
            String gender = (String)genderCombo.getSelectedItem();
            String carCompany = (String)carCompanyCombo.getSelectedItem();
            String carModel = tfCarModel.getText();
            String location = tfLocation.getText();
            
            try {
                
                Conn conn = new Conn();
                
                String query = "INSERT INTO driversdetails VALUES ('"+ name +"', "+ age +", '"+ gender +"', '"+ carCompany +"', '"+ carModel +"', '"+ location +"')";
                
                conn.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Driver added successfully.");
                
                setVisible(false);
            }
            catch (Exception e) {
                printStackTrace(e);
            }
            
        }
        else {
            setVisible(false);
        }
        
        
    }
    
    public static void main(String[] args) {
        new AddDriver();
    }
    
}
