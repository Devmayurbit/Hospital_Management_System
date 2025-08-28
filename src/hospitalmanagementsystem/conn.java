package hospitalmanagementsystem;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Dell
 */
public class conn {
    
    Connection connection;
    Statement  statement;
    public conn(){
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_management_system","root","jaxsky&2705");
            statement = connection.createStatement();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
