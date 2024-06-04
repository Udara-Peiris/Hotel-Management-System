package hotel.mangement.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddRooms extends JFrame implements ActionListener{
    
    JButton add, cancel;
    JTextField tfRoom, tfPrice;
    JComboBox availableCombo, statusCombo, typeCombo;

    public AddRooms() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Add Rooms");
        heading.setFont(new Font("Tahoma", Font.BOLD, 18));
        heading.setBounds(150, 20, 200, 20);
        add(heading);
        
        JLabel lblRoomNo = new JLabel("Room Number");
        lblRoomNo.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblRoomNo.setBounds(60, 80, 120, 20);
        add(lblRoomNo);
        
        tfRoom = new JTextField();
        tfRoom.setBounds(200, 80, 150, 30);
        add(tfRoom);
        
        JLabel lblAvailable = new JLabel("Available");
        lblAvailable.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblAvailable.setBounds(60, 130, 120, 20);
        add(lblAvailable);
        
        String availableOption[] = {"Available", "Occupied"};
        availableCombo = new JComboBox(availableOption);
        availableCombo.setBounds(200, 130, 150, 30);
        availableCombo.setBackground(Color.WHITE);
        add(availableCombo);
        
        JLabel lblClean = new JLabel("Cleaning Status");
        lblClean.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblClean.setBounds(60, 180, 120, 20);
        add(lblClean);
        
        String statusOption[] = {"Clean", "Dirty"};
        statusCombo = new JComboBox(statusOption);
        statusCombo.setBounds(200, 180, 150, 30);
        statusCombo.setBackground(Color.WHITE);
        add(statusCombo);
        
        JLabel lblPrice = new JLabel("Price");
        lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblPrice.setBounds(60, 230, 120, 20);
        add(lblPrice);
        
        tfPrice = new JTextField();
        tfPrice.setBounds(200, 230, 150, 30);
        add(tfPrice);
        
        JLabel lblType = new JLabel("Bed Type");
        lblType.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblType.setBounds(60, 280, 120, 20);
        add(lblType);
        
        String typeOption[] = {"Single Bed", "Double Bed"};
        typeCombo = new JComboBox(typeOption);
        typeCombo.setBounds(200, 280, 150, 30);
        typeCombo.setBackground(Color.WHITE);
        add(typeCombo);
        
        add = new JButton("Add Room");
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.setBounds(60, 350, 130, 30);
        add.addActionListener(this);
        add(add);
        
        cancel = new JButton("Cancel");
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.setBounds(220, 350, 130, 30);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(400, 30, 500, 300);
        add(image);
        
        
        
        setBounds(330, 200, 940, 470);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            
            String roomNo = tfRoom.getText();
            String price = tfPrice.getText();
            
            String available = (String) availableCombo.getSelectedItem();
            String status = (String) statusCombo.getSelectedItem();
            String type = (String) typeCombo.getSelectedItem();
            
            try {
                Conn conn = new Conn();
                
                String query = "INSERT INTO roomsDetails VALUES ('"+ roomNo +"', '"+ available +"', '"+ status +"', '"+ type +"', '"+ price +"')";
                
                conn.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Room added successfully.");
                
                setVisible(false);
            }
            catch (Exception e) {
                printStackTrace();
            }
            
                    
                    
        }else {
            setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new AddRooms();
    }
    
}
