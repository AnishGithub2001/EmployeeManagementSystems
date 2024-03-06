import javax.swing.*;
import java.awt.*;
import com.toedter.calendar.JDateChooser;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class AddEmployee extends JFrame implements ActionListener
{
    Random ran = new Random();
    int number = ran.nextInt(999999);
    JTextField tfname,tffname,tfaddress,tfphone,tfaadhar,tfemail,tfsalary,tfdesignation;
    JDateChooser dcdob;
    JComboBox cbeducation;
    JLabel lblempId;
    JButton add,back;

    AddEmployee()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Add Employee Details");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("SAN_SERIF",Font.BOLD,25));
        add(heading);

        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50,150,150,30);
        labelname.setFont(new Font("serif",Font.PLAIN,20));
        add(labelname);

         tfname = new JTextField();
        tfname.setBounds(200,150,150,30);
        add(tfname);

        JLabel labelfname = new JLabel("Father's Name");
        labelfname.setBounds(400,150,150,30);
        labelfname.setFont(new Font("serif",Font.PLAIN,20));
        add(labelfname);

         tffname = new JTextField();
        tffname.setBounds(600,150,150,30);
        add(tffname);

        JLabel labeldob = new JLabel("Date of Birth");
        labeldob.setBounds(50,200,150,30);
        labeldob.setFont(new Font("serif",Font.PLAIN,20));
        add(labeldob);

        dcdob = new JDateChooser();
        dcdob.setBounds(200,200,150,30);
        add(dcdob);

        JLabel labelsalary = new JLabel("Salary");
        labelsalary.setBounds(400,200,150,30);
        labelsalary.setFont(new Font("serif",Font.PLAIN,20));
        add(labelsalary);

        tfsalary = new JTextField();
        tfsalary.setBounds(600,200,150,30);
        add(tfsalary);

        JLabel labeladdress = new JLabel("Address");
        labeladdress.setBounds(50,250,150,30);
        labeladdress.setFont(new Font("serif",Font.PLAIN,20));
        add(labeladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(200,250,150,30);
        add(tfaddress);

        JLabel labelphone = new JLabel("Phone");
        labelphone.setBounds(400,250,150,30);
        labelphone.setFont(new Font("serif",Font.PLAIN,20));
        add(labelphone);

        tfphone = new JTextField();
        tfphone.setBounds(600,250,150,30);
        add(tfphone);

        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(50,300,150,30);
        labelemail.setFont(new Font("serif",Font.PLAIN,20));
        add(labelemail);

        tfemail = new JTextField();
        tfemail.setBounds(200,300,150,30);
        add(tfemail);

        JLabel labeleducation = new JLabel("Education");
        labeleducation.setBounds(400,300,150,30);
        labeleducation.setFont(new Font("serif",Font.PLAIN,20));
        add(labeleducation);

        String courses[] = {"BBA","BCA","BA","B.COM","BSC","B.TECH","MBA","MCA","MA","M.TECH","MSC","PHD"};
        cbeducation = new JComboBox(courses);
        cbeducation.setBackground(Color.WHITE);
        cbeducation.setBounds(600,300,150,30);
        add(cbeducation);

        JLabel labeldesignation = new JLabel("Designation");
        labeldesignation.setBounds(50,350,150,30);
        labeldesignation.setFont(new Font("serif",Font.PLAIN,20));
        add(labeldesignation);

        tfdesignation = new JTextField();
        tfdesignation.setBounds(200,350,150,30);
        add(tfdesignation);

        JLabel labeladdhar = new JLabel("Addhar Number");
        labeladdhar.setBounds(400,350,150,30);
        labeladdhar.setFont(new Font("serif",Font.PLAIN,20));
        add(labeladdhar);

        tfaadhar = new JTextField();
        tfaadhar.setBounds(600,350,150,30);
        add(tfaadhar);

        JLabel labelempId = new JLabel("Employee id");
        labelempId.setBounds(50,400,150,30);
        labelempId.setFont(new Font("serif",Font.PLAIN,20));
        add(labelempId);

        lblempId = new JLabel(""+number);
        lblempId.setBounds(200,400,150,30);
        lblempId.setFont(new Font("serif",Font.PLAIN,20));
        add(lblempId);

        add = new JButton("ADD DETAILS");
        add.setBounds(250,550,150,40);
        setBackground(Color.BLACK);
        setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);

        back = new JButton("BACK");
        back.setBounds(450,550,150,40);
        setBackground(Color.BLACK);
        setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        setSize(900,700);
        setLocation(300,50);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == add)
        {
            String name,fname,dob,salary,address,phone,email,education,aadhar,empId,designation;
            name = tfname.getText();
            fname = tffname.getText();
            dob = ((JTextField)dcdob.getDateEditor().getUiComponent()).getText();
            salary = tfsalary.getText();
            address = tfaddress.getText();
            phone = tfphone.getText();
            email = tfemail.getText();
            education = (String) cbeducation.getSelectedItem();
            designation = tfdesignation.getText();
            aadhar = tfaadhar.getText();
            empId = lblempId.getText();

            try{
                Connect connect = new Connect();
                String query = "insert into employee values('"+name+"','"+fname+"','"+dob+"','"+salary+"','"+address+"','"+phone+"','"+email+"','"+education+"','"+designation+"','"+aadhar+"','"+empId+"')";
                connect.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details Added Sucessfully");
                setVisible(false);
                new Home();

            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            setVisible(false);
            new Home();
        }
    }
    public static void main(String[] args) {
        new AddEmployee();
    }
}
