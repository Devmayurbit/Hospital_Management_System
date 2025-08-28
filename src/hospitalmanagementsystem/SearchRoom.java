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
public class SearchRoom extends JFrame{
    Choice choice;
    JTable table;
    SearchRoom(){
        
         
         JPanel panel = new JPanel();
        panel.setBounds(5,5,690,490);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);
        
        JLabel For = new JLabel("Search For Room");
        For.setBounds(250, 11, 186, 31);
        For.setForeground(Color.white);
        For.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(For);
        
        JLabel status = new JLabel("Status :");
        status.setBounds(70, 70, 80, 14);
        status.setForeground(Color.white);
        status.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(status);
        

        choice = new Choice();
        choice.setBounds(170,70,120,20);
        choice.add("Availabil");
        choice.add("Occupied");
        panel.add(choice);
        
        
        table = new JTable();
        table.setBounds(2 , 187, 700, 210);
        table.setBackground(new Color(90,156,163));
        table.setForeground(Color.white);
        panel.add(table);
        
        try{
           conn c = new conn();
           String q = "select * from Room";
           ResultSet resultSet = c.statement.executeQuery(q);
           table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch(Exception e){
            e.printStackTrace();
        }
            
       
         JLabel Roomno = new JLabel("Romm Number");
        Roomno.setBounds(23, 162, 150, 20);
        Roomno.setForeground(Color.white);
        Roomno.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(Roomno);
        
         JLabel available = new JLabel("Availability");
        available.setBounds(170, 162, 150, 20);
        available.setForeground(Color.white);
        available.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(available);
        
        
        
         JLabel Price = new JLabel("Price");
        Price.setBounds(408, 162, 150, 20);
        Price.setForeground(Color.white);
        Price.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(Price);

        
        
         JLabel Bed = new JLabel("Bed Type");
        Bed.setBounds(580, 162, 150, 20);
        Bed.setForeground(Color.white);
        Bed.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(Bed);
        
        JButton Search = new JButton("Search");
        Search.setBounds(200, 420, 120, 25);
        Search.setBackground(Color.PINK);
        Search.setForeground(Color.red);
        panel.add(Search);
        Search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String q = "select * from Room where available = '"+choice.getSelectedItem()+"'";
                try {
                    conn c = new conn();
                    ResultSet resultSet = c.statement.executeQuery(q);
                    table.setModel(DbUtils.resultSetToTableModel(resultSet));
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });
         JButton Back = new JButton("Back");
        Back.setBounds(380, 420, 120, 25);
        Back.setBackground(Color.CYAN);
        Back.setForeground(Color.red);
        panel.add(Back);
        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        
        
        
     //  setUndecorated(true);
        setSize(700,500);
        setLayout(null);
        setLocation(400,250);
        setVisible(true); 
    }
    public static void main(String[] args){
        new SearchRoom();
    }
}
