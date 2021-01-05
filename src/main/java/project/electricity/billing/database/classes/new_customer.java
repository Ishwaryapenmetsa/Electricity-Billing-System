package project.electricity.billing.database.classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class new_customer extends JFrame implements ActionListener {
	 JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
	 JTextField t1,t2,t3,t4,t5,t6,t7,t8;
	 JPasswordField pf;
	  
	  JButton b1,b2;
	  new_customer(){
		  
		  super("New Customer");
		  
		  setLocation(350,200);
		  setSize(650,600 );
		  JPanel p=new JPanel();
		  p.setLayout(new GridLayout(11,2,10,10));
		  
		  p.setBackground(Color.WHITE);
		  
		  l1 = new JLabel("Name");
		  t1 = new JTextField();
		  p.add(l1);
		  p.add(t1);
		  
		  l2 = new JLabel("Meter Number");
		  t2 = new JTextField();
		  p.add(l2);
		  p.add(t2);
		  
		  l3 = new JLabel("Address");
		  t3 = new JTextField();
		  p.add(l3);
		  p.add(t3);
		  
		  l4 = new JLabel("City");
		  t4 = new JTextField();
		  p.add(l4);
		  p.add(t4);
		  
		  l5 = new JLabel("State");
		  t5 = new JTextField();
		  p.add(l5);
		  p.add(t5);
		  
		  l6 = new JLabel("Phone number");
		  t6 = new JTextField();
		  p.add(l6);
		  p.add(t6);
		  
		  l7 = new JLabel("Email Address");
		  t7 = new JTextField();
		  p.add(l7);
		  p.add(t7);
		  
		  l9 = new JLabel("Set Username");
		  t8 = new JTextField();
		  p.add(l9);
		  p.add(t8);
		  
		  l10 = new JLabel("Set Password");
		  pf = new JPasswordField();
		  p.add(l10);
		  p.add(pf);
		  
		  
		  b1 = new JButton("Submit");
		  b2 = new JButton("Cancel");
		  

		  b1.setBackground(Color.BLACK);
		  b1.setForeground(Color.WHITE);
		  
		  b2.setBackground(Color.BLACK);
		  b2.setForeground(Color.WHITE);
		  
		  p.add(b1);
		  p.add(b2);
		  setLayout(new BorderLayout());
		  
		  add(p,BorderLayout.CENTER);
		  
		  ImageIcon icl = new ImageIcon(ClassLoader.getSystemResource("hicon1.jpg"));
		  Image i3 = icl.getImage().getScaledInstance(150,450,Image.SCALE_DEFAULT);
		  ImageIcon ic2 = new ImageIcon (i3);
		  l8 = new JLabel(ic2);
		  
		  add(l8,BorderLayout.WEST);
		  //for changing the color of whole 
		  getContentPane().setBackground(Color.WHITE);
		  
		  b1.addActionListener(this);
		  b2.addActionListener(this);
	  }
	  public void actionPerformed(ActionEvent ae){
		  
		 
		  String a = t1.getText();
		  String c = t2.getText();
		  String d = t3.getText();
		  String e = t4.getText();
		  String f = t5.getText();
		  String g = t6.getText();
		  String h = t7.getText();
		  String i = t8.getText();
		  String j = pf.getText();
		  
		  String q1 = "insert into emp values('"+a+"','"+c+"','"+d+"','"+e+"','"+f+"','"+g+"','"+h+"','"+i+"','"+j+"')";
		  try {
			  if(!ae.getActionCommand().equals("Cancel")) 
			  {  
					  DatabaseConnection c1 = new DatabaseConnection();
					  c1.s.executeUpdate(q1);
					  JOptionPane.showMessageDialog(null,"Employee Created");
					  this.setVisible(false);
				  
			  }
			  else {
				  this.setVisible(false);
			  }
			  
		  }catch(Exception ex) {
			  ex.printStackTrace();
		  }
	  }
		public static void main(String[] args) {
			new new_customer().setVisible(true);
		}
	}

