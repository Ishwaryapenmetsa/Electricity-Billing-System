package project.electricity.billing.database.classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class customer_details extends JFrame implements ActionListener{
	
	 JTable t1;
	 JButton b1;
	 String x[] = {"Member name","Meter number","Address","City","State","Phone","Email address"};
	 String y[][] = new String[20][8];
	 int i=0,j=0;
	 customer_details(){
		 
		 super("Customer Details");
		 setSize(1200,650);
		 setLocation(200,200);
		 
		 try { 
			 
			  DatabaseConnection c1 = new DatabaseConnection();
			  String s1 = "select * from emp ";
			  ResultSet rs = c1.s.executeQuery(s1);
			  System.out.println(rs);
			  
			  while(rs.next()) {
				  
				  y[i][j++]=rs.getString("name");
				  y[i][j++]=rs.getString("meter_number");
				  y[i][j++]=rs.getString("address");
				  y[i][j++]=rs.getString("city");
				  y[i][j++]=rs.getString("state");
				  y[i][j++]=rs.getString("phone");
				  y[i][j++]=rs.getString("email");
				  i++;
				  j=0;
				  
			  }
			  t1 = new JTable(y,x);
			  
		 }catch (Exception e) {
			 
			 	e.printStackTrace();
			 
		 	}
		 
		 b1 = new JButton("print");
		 add(b1,"South");
		 
		 JScrollPane sp = new JScrollPane(t1);
		 add(sp);
		 b1.addActionListener(this);
	 }
	 public void actionPerformed(ActionEvent ae) {
		 try {
			 
			  t1.print();
			  
		 }catch (Exception e) {
			 System.out.println(e);
		 }
	 }
	 
	 public static void main(String[] args) {
		 
		 new customer_details().setVisible(true);
		 
	 }
 }

	

