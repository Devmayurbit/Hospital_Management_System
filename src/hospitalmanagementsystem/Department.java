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
public class Department extends JFrame {
//JTable table;    

    Department(){
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 690, 490);
        panel.setLayout(null);
        panel.setBackground(new Color(90,156,163));
        add(panel);
        
        
        JTable table = new JTable();
        table.setBounds(2,40, 700, 350);
        table.setBackground(new Color(90,156,163));
        table.setFont(new Font("Tahoma" , Font.BOLD,14));
        panel.add(table);
        
        try{
            conn c = new conn();
            String q = "select * from department";
            ResultSet resultSet=c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch(Exception e){
            e.printStackTrace();
        }        
                
        JLabel label1 = new JLabel("Departments");
        label1.setBounds(135, 11, 105, 20);
        label1.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label1);
        
        JLabel label2 = new JLabel("Phone Number");
        label2.setBounds(420, 11, 156, 20);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label2);
        
        JButton back = new JButton("Back");
        back.setBounds(250, 400, 120, 30);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        panel.add(back);
        back.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
          setVisible(false);         
        } 
    });
        setUndecorated(true);
        setSize(700,500);
        setLayout(null);
        setLocation(350,250);
        setVisible(true);
    }
    public static void main(String[] args){
        new Department();
    }
}
