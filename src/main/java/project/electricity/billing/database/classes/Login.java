package project.electricity.billing.database.classes;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
	
	JLabel l1,l2,l3;
	JTextField tf1;
	JPasswordField pf1;
	JButton b1 , b2 , b3;
	JPanel p1,p2,p3,p4;
	
	Login(){
		
		super("Login Page");
		
		l1 = new JLabel("Username");
		l2 = new JLabel("Password");
		tf1 = new JTextField(15); //Creates a new empty TextField with the specified number of columns.
		pf1 = new JPasswordField(15);
		
		ImageIcon ic1 = new ImageIcon(ClassLoader.getSystemResource("login.png"));
		Image i1 = ic1.getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT);
		b1 = new JButton("Login", new ImageIcon(i1));
		
		ImageIcon ic2 = new ImageIcon(ClassLoader.getSystemResource("cancel.jpg"));
		Image i2 = ic2.getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT);
		b2 = new JButton("Cancel", new ImageIcon(i2));
		
		ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("newcustomer.jpg"));
		Image i5 = image.getImage().getScaledInstance(25,25, Image.SCALE_DEFAULT);
		b3 = new JButton("New Customer ??",new ImageIcon(i5));
		
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		
		ImageIcon ic3 = new ImageIcon(ClassLoader.getSystemResource("pop.png"));
		Image i3 = ic3.getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT);
		ImageIcon icc3 = new ImageIcon(i3);
		l3 = new JLabel(icc3);
		
		setLayout(new BorderLayout());
		
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		p4 = new JPanel();

		
		p1.add(l3);
		add(p1 ,BorderLayout.WEST); // adding label 3 to the west side of login page
		
		p2.add(l1);
		p2.add(tf1);
		p2.add(l2);
		p2.add(pf1);
		
		p2.add(b3);
		
		add(p2,BorderLayout.CENTER);
				
		p4.add(b1);
		p4.add(b2);
		
		add(p4,BorderLayout.SOUTH);
		
		p2.setBackground(Color.WHITE);
		p3.setBackground(Color.WHITE);
		p4.setBackground(Color.WHITE);
		
		setSize(400,250);
		setLocation(400,400);
		setVisible(true);
		
		
		
	}

	
	
	public void actionPerformed(ActionEvent ae) {
		try {
			if(ae.getActionCommand().equals("New Customer ??")) {
				
				new new_customer().setVisible(true); 
				
				this.setVisible(false);
			}
			else {
				DatabaseConnection c1 = new DatabaseConnection();
				String a = tf1.getText();
				String b = pf1.getText();
				String q = "select * from login where username = \'"+a+"\' and password = \'"+b+"\'";
				ResultSet rs = c1.s.executeQuery(q);
				
				if(!ae.getActionCommand().equals("Cancel")) {
				
					if(rs.next()) {
					
						new MainPage().setVisible(true);
						this.setVisible(false);
					
					}else {
					
						JOptionPane.showMessageDialog(null , "Invalid login");
						setVisible(false);
					}
					
				}else {
				
					this.setVisible(false);
				}
			}
		}catch(Exception e) {
			
			e.printStackTrace(); //  printStackTrace() method in Java is a tool used to handle exceptions and errors.
			
			System.out.println(e);
		}
		
	}

	public static void main(String args[]) {
		
		new Login().setVisible(true);
	}
	
	
}
