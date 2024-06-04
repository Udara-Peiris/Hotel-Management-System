package hotel.mangement.system;

import java.awt.*;
import javax.swing.*;

public class UpdateCheck extends JFrame{
    
    
    UpdateCheck() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("Update status");
        text.setFont(new Font("Tahoma", Font.PLAIN, 20));
        text.setBounds(90, 20, 200, 30);
        text.setForeground(Color.BLUE);
        add(text);
        
        JLabel lblId = new JLabel("Customer ID");
        lblId.setBounds(30, 80, 100, 20);
        add(lblId);
        
        setBounds(300, 200, 980, 500);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new UpdateCheck();
    }
}
