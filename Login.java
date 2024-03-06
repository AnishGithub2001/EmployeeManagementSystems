import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JTextField tfusername,tfpassword;

    Login()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);


        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40,20,100,30);
        add(lblusername);

        tfusername = new JTextField();
        tfusername.setBounds(150,20,150,30);
        add(tfusername);

        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(40,50,100,30);
        add(lblpassword);

        tfpassword = new JTextField();
        tfpassword.setBounds(150,50,150,30);
        add(tfpassword);

        JButton Login = new JButton("LOGIN");
        Login.setBounds(150,90,150,50);
        Login.addActionListener(this);
        add(Login);

        /*
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1100,700,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,100,200,200);
        add(image);
        */

        setSize(600,600);
        setLocation(450,200);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        try
        {
            String username = tfusername.getText();
            String password = tfpassword.getText();

            String query = "select * from login where username = '"+username+"' and password = '"+password+"'";

            Connect c = new Connect();
            ResultSet rs = c.s.executeQuery(query);
            if(rs.next())
            {
                setVisible(false);
                new Home();
            }
            else {
                JOptionPane.showMessageDialog(null,"invalid username or password");
                setVisible(false);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
