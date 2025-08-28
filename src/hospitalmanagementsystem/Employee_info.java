/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospitalmanagementsystem;


import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Dell
 */
public class Employee_info extends JFrame {
    Employee_info(){
        
        JPanel panel= new JPanel();
        panel.setBounds(5,5,990,490);
        panel.setBackground(new Color(109,164,170));
        panel.setLayout(null);
        add(panel);
        
        JTable table = new JTable();
        table.setBounds(10, 34, 980, 450);
        table.setBackground(new Color(109,164,170));
        table.setFont(new Font("Tahoma",Font.BOLD,12));
        panel.add(table);
        
        try{
            conn c = new conn();
            String q = "select * from EMP_INFO";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch(Exception e){
            e.printStackTrace();
        }
        
        JLabel label1 = new JLabel("Name");
        label1.setBounds(41, 9, 70, 20);
        label1.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label1);
        
        JLabel label2 = new JLabel("Age");
        label2.setBounds(190, 9, 70, 20);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label2);
        
        JLabel label3 = new JLabel("Phone Number");
        label3.setBounds(370, 9, 120, 20);
        label3.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label3);
        
        JLabel label4 = new JLabel("Salary");
        label4.setBounds(550, 9, 70, 20);
        label4.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label4);
        
        JLabel label5 = new JLabel("Gmail");
        label5.setBounds(700, 9, 70, 20);
        label5.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label5);
        
        JLabel label6 = new JLabel("Aadhar Number");
        label6.setBounds(850, 9, 150, 20);
        label6.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label6);
        
         JButton back = new JButton("Back");
        back.setBounds(250, 520, 120, 30);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        panel.add(back);
        back.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
          setVisible(false);         
        } 
    });
                
//        setUndecorated(true);
        setSize(1000,550);
        setLocation(300,200);
        setLayout(null);
        setVisible(true);
        
    }
    public static void main(String[] agrs){
        new Employee_info();
    }
}
