package hospitalmanagementsystem;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
    import javax.swing.*;
/**
 *
 * @author Dell
 */
public class Login extends JFrame implements ActionListener{
    JTextField textField;
    JPasswordField jpasswordfield;
    JButton B1,B2;
    Login(){
        JLabel namelabel = new JLabel("Username");
               namelabel.setBounds(40,20,100,30);
               namelabel.setFont(new Font("Tahoma" ,Font.BOLD,16));
               add(namelabel);
        
        JLabel password = new JLabel("Password");
               password.setBounds(40,70,100,30);
               password.setFont(new Font("Tahoma" ,Font.BOLD,16));
               add(password);
               
               textField = new JTextField();
               textField.setBounds(150,20,150,30);
               textField.setFont(new Font("Tahoma",Font.PLAIN,15));
               textField.setBackground(new Color(255,179,0));
               add(textField);
               
                
               jpasswordfield = new JPasswordField();
               jpasswordfield.setBounds(150,70,150,30);
               jpasswordfield.setFont(new Font("Tahoma",Font.PLAIN,15));
               jpasswordfield.setBackground(new Color(255,168,0));
               add(jpasswordfield);
               
               ImageIcon imageicon = new ImageIcon(ClassLoader.getSystemResource("icons/login1.png"));
               Image i1 = imageicon.getImage().getScaledInstance(400,400,Image.SCALE_DEFAULT);
               ImageIcon imageIcon1 = new ImageIcon(i1);
               JLabel label = new JLabel(imageIcon1);
               label.setBounds(320,-30,400,300);
               add(label);
               
               B1 = new JButton("Login");
               B1.setBounds(40,140, 120, 30);
               B1.setFont(new Font("serif" ,Font.BOLD,15));
               B1.setBackground(Color.BLACK);
               B1.setForeground(Color.WHITE);
               B1.addActionListener(this);
               add(B1);
               
               B2 = new JButton("Cancel");
               B2.setBounds(185,140, 120, 30);
               B2.setFont(new Font("serif" ,Font.BOLD,15));
               B2.setBackground(Color.BLACK);
               B2.setForeground(Color.WHITE);
               B2.addActionListener(this);
               add(B2);
    
                       
                       
               
               
               
           getContentPane().setBackground(new Color(109,164,170));     
           setSize(750,300);
           setLocation(400,270);
           setLayout(null);
           setVisible(true);
    }
    
    /**
     *
     * @param e
     */
@Override
public void actionPerformed(ActionEvent e) {
    if(e.getSource() == B1){
        try{
            conn c = new conn();
            String user = textField.getText();
           String pass = new String(jpasswordfield.getPassword());

            
            String q = "select * from login where id='" + user + "' and pw='" + pass + "'";
            ResultSet resultSet =c.statement.executeQuery(q);
            if(resultSet.next()){
                new Reception();
                setVisible(false);
            }else{
                JOptionPane.showMessageDialog(null,"Invalid");
            }
                    
        }catch(Exception E){
            E.printStackTrace();
        }   
    }else{
        System.exit(0);
    }
    
}

public static void main(String[] agrs){
    new Login();
}
}
