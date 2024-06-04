package hotel.mangement.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class AddEmployee extends JFrame implements ActionListener{
    
    JTextField tfName, tfAge, tfSalary, tfPhone, tfEmail;
    JRadioButton rbMale, rbFemale;
    JButton submit;
    JComboBox cbJob;
    
    AddEmployee() {
        setLayout(null);
        
        JLabel lblName = new JLabel("NAME");
        lblName.setBounds(60, 30, 120, 30);
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblName);
        
        tfName = new JTextField();
        tfName.setBounds(200, 30, 150, 30);
        add(tfName);
        
        JLabel lblAge = new JLabel("AGE");
        lblAge.setBounds(60, 80, 120, 30);
        lblAge.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblAge);
        
        tfAge = new JTextField();
        tfAge.setBounds(200, 80, 150, 30);
        add(tfAge);
        
        JLabel lblGender = new JLabel("GENDER");
        lblGender.setBounds(60, 130, 120, 30);
        lblGender.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblGender);
        
        rbMale = new JRadioButton("Male");
        rbMale.setBounds(200, 130, 70, 30);
        rbMale.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(rbMale);
        
        rbFemale = new JRadioButton("Female");
        rbFemale.setBounds(280, 130, 70, 30);
        rbFemale.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(rbFemale);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbMale);
        bg.add(rbFemale);
        
        JLabel lblJob = new JLabel("JOB");
        lblJob.setBounds(60, 180, 120, 30);
        lblJob.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblJob);
        
        String str[] = {"Front Desk Clerks", "Porters", "Housekeeping", "Kitchen Staff", "Room Service", "Chefs", "Waiter/Waitress", "Manager", "Accountant"};
        cbJob = new JComboBox(str);
        cbJob.setBounds(200, 180, 150, 30);
        cbJob.setBackground(Color.WHITE);
        add(cbJob);
        
        JLabel lblSalary = new JLabel("SALARY");
        lblSalary.setBounds(60, 230, 120, 30);
        lblSalary.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblSalary);
        
        tfSalary = new JTextField();
        tfSalary.setBounds(200, 230, 150, 30);
        add(tfSalary);
        
        JLabel lblPhone = new JLabel("PHONE");
        lblPhone.setBounds(60, 280, 120, 30);
        lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblPhone);
        
        tfPhone = new JTextField();
        tfPhone.setBounds(200, 280, 150, 30);
        add(tfPhone);
        
        JLabel lblEmail = new JLabel("EMAIL");
        lblEmail.setBounds(60, 330, 120, 30);
        lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblEmail);
        
        tfEmail = new JTextField();
        tfEmail.setBounds(200, 330, 150, 30);
        add(tfEmail);
        
        submit = new JButton("SUBMIT");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(200, 430, 150, 30);
        submit.addActionListener(this);
        add(submit);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(380, 60, 450, 370);
        add(image);
        
        
        getContentPane().setBackground(Color.WHITE);
        setBounds(350, 200, 850, 540);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        String name = tfName.getText();
        String age = tfAge.getText();
        String salary = tfSalary.getText();
        String phone = tfPhone.getText();
        String email = tfEmail.getText();
        
        String job =  (String) cbJob.getSelectedItem();
        
        String gender = null;
        
        if(rbMale.isSelected()) {
            gender = "Male";
        } else if (rbFemale.isSelected()) {
            gender = "Female";
        }
        
        if (name.equals("")) {
            JOptionPane.showMessageDialog(null, "Name should not be empty.");
            return;
        }
            
//        if (email.equals("")  && contains("@") && contains(".com")) {
//            JOptionPane.showMessageDialog(null, "Name should not be empty.");
//            return;
//        }
//        
        try {
            Conn conn = new Conn();
            
            String query = "INSERT INTO employee VALUES ('"+ name +"', '"+ age +"', '"+ gender +"', '"+ phone +"', '"+ email +"', '"+ job +"', '"+ salary +"' )";
            
            conn.s.executeUpdate(query);
            
            JOptionPane.showMessageDialog(null, "Employee added successfully.");
            
            setVisible(false);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public static void main(String[] args) {
        new AddEmployee();
    }
}
