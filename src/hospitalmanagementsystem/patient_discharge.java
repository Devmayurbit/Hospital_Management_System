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
import java.util.Date;
/**
 *
 * @author Dell
 */
public class patient_discharge extends JFrame{
    patient_discharge(){
        JPanel panel = new JPanel();
        panel.setBounds(5,5,790,390);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);
        
        JLabel label = new JLabel("Check-Out");
        label.setBounds(100, 20, 150, 20);
        label.setFont(new Font("Tahoma",Font.BOLD,20));
        label.setForeground(Color.WHITE);
        panel.add(label);
        
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/patient.png"));
        Image image = imageIcon.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label5 = new JLabel(imageIcon1);
        label5.setBounds(550, 100, 200, 200);
        panel.add(label5);
        
        JLabel label1 = new JLabel("Customer Id :");
        label1.setBounds(30, 80, 150, 20);
        label1.setFont(new Font("Tahoma",Font.BOLD,14));
        label1.setForeground(Color.WHITE);
        panel.add(label1);
        
        Choice choice = new Choice();
        choice.setBounds(200, 80, 150, 25);
        panel.add(choice);
        
        try{
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from  patient_info");
            while(resultSet.next()){
                choice.add(resultSet.getString("Number"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        JLabel label2 = new JLabel("Room Number :");
        label2.setBounds(30,130 , 150, 20);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        label2.setForeground(Color.WHITE);
        panel.add(label2);
        
        JLabel Rno = new JLabel();
        Rno.setBounds(200,130 , 150, 20);
        Rno.setFont(new Font("Tahoma",Font.BOLD,14));
        Rno.setForeground(Color.WHITE);
        panel.add(Rno);
        
        JLabel label3 = new JLabel("In Time :");
        label3.setBounds(30,180 , 150, 20);
        label3.setFont(new Font("Tahoma",Font.BOLD,14));
        label3.setForeground(Color.WHITE);
        panel.add(label3);
        
         JLabel INTime = new JLabel();
        INTime.setBounds(200,180 , 250, 20);
        INTime.setFont(new Font("Tahoma",Font.BOLD,14));
        INTime.setForeground(Color.WHITE);
        panel.add(INTime);
        
        JLabel label4 = new JLabel("Out Time :");
        label4.setBounds(30,230 , 150, 20);
        label4.setFont(new Font("Tahoma",Font.BOLD,14));
        label4.setForeground(Color.WHITE);
        panel.add(label4);
        
         Date date = new Date();
          JLabel OUTtime = new JLabel(""+date);
        OUTtime.setBounds(200,230 , 250, 20);
        OUTtime.setFont(new Font("Tahoma",Font.BOLD,14));
        OUTtime.setForeground(Color.WHITE);
        panel.add(OUTtime);
        
        
        JButton discharge = new JButton("Discharge");
        discharge.setBounds(30, 300, 120, 30);
        discharge.setBackground(Color.BLACK);
        discharge.setForeground(Color.WHITE);
        panel.add(discharge);
        discharge.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                conn c = new conn();
                try{
                c.statement.executeUpdate("delete from patient_info where Number = '"+choice.getSelectedItem()+"'");
                c.statement.executeUpdate("update Room set available = 'Available'  where room_no=  '"+Rno.getText()+"'");
                JOptionPane.showMessageDialog(null, "Done ^_^ ");
                setVisible(false);
                }catch(Exception E){
                    E.printStackTrace();
                }
            }
            
        });
        
        JButton Check = new JButton("Check");
        Check.setBounds(170, 300, 120, 30);
        Check.setBackground(Color.BLACK);
        Check.setForeground(Color.WHITE);
        panel.add(Check);
        Check.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
          conn c = new conn();
          try{
              ResultSet resultSet = c.statement.executeQuery("select * from patient_info where Number = '"+choice.getSelectedItem()+"'");
              while(resultSet.next()){
                  Rno.setText(resultSet.getString("Room_Number"));
              INTime.setText(resultSet.getString("Time"));
              }
          }catch(Exception E){
              E.printStackTrace();
          }
            }
            
        });
        
        JButton Back = new JButton("Back");
        Back.setBounds(300, 300, 120, 30);
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

        setSize(800,400);
        setLayout(null);
        setLocation(400,250);
        setVisible(true);
    }
     public static void main(String[] args){
        new patient_discharge();
    }
}
