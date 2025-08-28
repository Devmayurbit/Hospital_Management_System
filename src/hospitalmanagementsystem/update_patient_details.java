/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospitalmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
//import net.proteanit.sql.DbUtils;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.util.Date;
/**
 *
 * @author Dell
 */
public class update_patient_details extends JFrame {
     update_patient_details(){
         
         
         JPanel panel = new JPanel();
        panel.setBounds(5,5,940,490);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);
         
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/updated.png"));
        Image image = imageIcon.getImage().getScaledInstance(300,300, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(500, 60, 300, 300);
        panel.add(label);
        
         JLabel labe2 = new JLabel("Update Patient Details");
        labe2.setBounds(124, 11, 262, 25);
        labe2.setFont(new Font("Tahoma",Font.BOLD,20));
        labe2.setForeground(Color.WHITE);
        panel.add(labe2);
        
        JLabel label3 = new JLabel("Name :");
        label3.setBounds(25, 88, 96, 14);
        label3.setFont(new Font("Tahoma",Font.PLAIN,14));
        label3.setForeground(Color.WHITE);
        panel.add(label3);
        
        Choice choice = new Choice();
        choice.setBounds(248, 85, 140, 25); 
        panel.add(choice);
        
        try{
           conn c = new conn();
           ResultSet resultSet = c.statement.executeQuery("select * from patient_info");
           while(resultSet.next()){
               choice.add(resultSet.getString("Name"));
           }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        JLabel label4 = new JLabel("Room Number :");
        label4.setBounds(25, 129, 120, 14);
        label4.setFont(new Font("Tahoma",Font.PLAIN,14));
        label4.setForeground(Color.WHITE);
        panel.add(label4);
        
        JTextField textFieldR = new JTextField();
        textFieldR.setBounds(248, 129, 140, 20);
        panel.add(textFieldR);
        
         JLabel label5 = new JLabel("In-Time :");
        label5.setBounds(25, 174, 96, 14);
        label5.setFont(new Font("Tahoma",Font.PLAIN,14));
        label5.setForeground(Color.WHITE);
        panel.add(label5);
         
         
        JTextField textFieldINTime = new JTextField();
        textFieldINTime.setBounds(248, 174, 140, 20);
        panel.add(textFieldINTime);
        
        
         JLabel label6 = new JLabel("Amount Paid (Rs) :");
        label6.setBounds(25, 216, 166, 14);
        label6.setFont(new Font("Tahoma",Font.PLAIN,14));
        label6.setForeground(Color.WHITE);
        panel.add(label6);
         
         
        JTextField textFieldAmount = new JTextField();
        textFieldAmount.setBounds(248, 216, 140, 20);
        panel.add(textFieldAmount);
        
        JLabel label7 = new JLabel("Pending Amount (Rs) :");
        label7.setBounds(25, 261, 166, 16);
        label7.setFont(new Font("Tahoma",Font.PLAIN,14));
        label7.setForeground(Color.WHITE);
        panel.add(label7);
         
         
        JTextField textFieldPending = new JTextField();
        textFieldPending.setBounds(248, 261, 140, 20);
        panel.add(textFieldPending);
        
        JButton check = new JButton("Check");
        check.setBounds(281, 378, 89, 23);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.white);
        panel.add(check);
        check.addActionListener(new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent e) {
              String id = choice.getSelectedItem();
              String q = "select * from patient_info where Name = '"+id+"'";
              try{
                  conn c = new conn();
                  ResultSet  resultSet = c.statement.executeQuery(q);
                  while(resultSet.next()){
                      textFieldR.setText(resultSet.getString("Room_Number"));
                      textFieldINTime.setText(resultSet.getString("Time"));
                      textFieldAmount.setText(resultSet.getString("Deposits"));
                  
                  }
                  ResultSet resultSet1 = c.statement.executeQuery("select * from Room where room_no = '"+textFieldR.getText()+"'");
               
               while(resultSet1.next()){
                   String price= resultSet1.getString("Price");
                   int amountPaid = Integer.parseInt(price) - Integer.parseInt(textFieldAmount.getText());
                   textFieldPending.setText(""+amountPaid);
                   
               }
              }catch(Exception E){
                  E.printStackTrace();
              }
             }
            
        });
        
        
        JButton update = new JButton("Update");
        update.setBounds(56, 378, 89, 23);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.white);
        panel.add(update);
        update.addActionListener(new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent e) {
try{
    conn c = new conn();
    String q = choice.getSelectedItem();
    String room = textFieldR.getText();
    String time = textFieldINTime.getText();
    String amount = textFieldAmount.getText();
    c.statement.executeUpdate("update patient_info set Room_Number ='"+room+"',Time = '"+time+"' ,Deposits  = '"+amount+"'where Name='"+q+"'");
    JOptionPane.showMessageDialog(null, "Updated Successfully ^_^ ");
    setVisible(false);
    
}catch(Exception E){
    E.printStackTrace();
}
             }
            
        });
        
        JButton Back = new JButton("Back");
        Back.setBounds(168, 378, 89, 23);
        Back.setBackground(Color.BLACK);
        Back.setForeground(Color.WHITE);
        panel.add(Back);
        Back.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
            
        });
        setUndecorated(true);
        setSize(950,500);
        setLayout(null);
        setLocation(400,250);
        setVisible(true);
    }
    public static void main(String[] args){
        new update_patient_details();
    }
}
