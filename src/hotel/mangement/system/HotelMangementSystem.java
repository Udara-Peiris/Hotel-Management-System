package hotel.mangement.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class HotelMangementSystem extends JFrame implements ActionListener{
    
    HotelMangementSystem() {
//        setSize(1366,565);
//        setLocation(100,100);
        setBounds(0, 0, 1366, 565);
        setLayout(null);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1366, 565);  //location x, location y, length, breadth
        add(image);
        
        JLabel text = new JLabel("HOTEL MANAGEMENT SYSTEM");
        text.setBounds(20, 430, 1000, 90);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("serif", Font.PLAIN, 50));
        image.add(text);
        
        JButton next = new JButton("NEXT");
        next.setBounds(1150, 450, 150, 60);
        next.setBackground(Color.WHITE);
        next.setForeground(Color.BLACK);
        next.addActionListener(this);
        next.setFont(new Font("serif", Font.PLAIN, 20));
        image.add(next);
        
        setVisible(true);
        
        while(true) {
            text.setVisible(false);
            try {
                Thread.sleep(500);
            }
            catch (Exception e){
                e.printStackTrace();
            }
            text.setVisible(true);
//            try {
//                Thread.sleep(500);
//            }
//            catch (Exception e) {
//                e.printSlackTrace();
//            }
        }
    }
    
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Login();
    }

    public static void main(String[] args) {
        new HotelMangementSystem();
    }
    
}
