package project.electricity.billing.database.classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Generate_bill extends JFrame implements ActionListener{

	JLabel l1;
	JTextArea t1;
	JButton b1;
	Choice c1 , c2;
	JPanel p1;
	
	Generate_bill(){
		
		super("Bill");
		setSize(500 , 500);
		setLayout(new BorderLayout());
		
		p1 = new JPanel();
		
		l1 = new JLabel("Generate Bill");
		
		c1 = new Choice();
		c2 = new Choice();
		
		c1.add("1001");
		c1.add("1002");
		c1.add("1003");
		c1.add("1004");
		c1.add("1005");
		c1.add("1006");
		c1.add("1007");
		c1.add("1008");
		c1.add("1009");
		c1.add("1010");
		
		c2.add("January");
		c2.add("February");
		c2.add("March");
		c2.add("April");
		c2.add("May");
		c2.add("June");
		c2.add("July");
		c2.add("August");
		c2.add("September");
		c2.add("November");
		c2.add("December");
		
		t1 = new JTextArea(60,30); // setting dimensions of text area
		JScrollPane jsb = new JScrollPane(t1); // JScrollpane - setting scroll bar in text area
		t1.setFont(new Font("Senserif",Font.ITALIC,18));
		
		b1 = new JButton("Generate Bill");
		
		p1.add(l1);
		p1.add(c1);
		p1.add(c2);
		add(p1,"North"); // adding choices and label at north position of panel
		
		add(jsb,"Center"); //setting at center
		add(b1, "South");  // ''        south
		
		b1.addActionListener(this); //setting action to button
		
		setLocation(350,50);
	}



	public void actionPerformed(ActionEvent ae) {
		
		try {
				DatabaseConnection c = new DatabaseConnection();
				
				String cc = c1.getSelectedItem();
				
				String month1 = c2.getSelectedItem(); // selected month is stored in month String 
				
				t1.setText("\tElectricity Billing System \n The Electricity Bill generated for the month "+month1+ ", 2020 \n\n"); 
				// setting text 
				
				ResultSet rs = c.s.executeQuery("select * from emp where meter_number = "+cc);
								// executes statements the returns tabular data
				
				if(rs.next()) {
					
					t1.append("\n Customer name :" +rs.getString("name"));
					t1.append("\n Meter Number: " +rs.getString("meter_number"));
					t1.append("\n Address: " +rs.getString("address"));
					t1.append("\n State : " +rs.getString("state"));
					t1.append("\n City: " +rs.getString("city"));
					t1.append("\n Email id: " +rs.getString("email"));
					t1.append("\n Phone number: " +rs.getString("phone"));
					t1.append("\n-----------------------------------------------------");
					t1.append("\n");
				}	
					// append() - add(append) text in text area
					
					rs = c.s.executeQuery("select * from tax");
				if(rs.next()) {
				
					t1.append("\n Meter Location :"+rs.getString("meter_location"));
					t1.append("\n Meter Type: " +rs.getString("meter_type"));
					t1.append("\n Phase Code: " +rs.getString("phase_code"));
					t1.append("\n Bill type: " +rs.getString("bill_type"));
					t1.append("\n Days : " +rs.getString("days"));
					t1.append("\n-----------------------------------------------------");
					t1.append("\n");
					
					t1.append("\n Cost of each unit : Rs. 7");
					t1.append("\n Meter Rent :"+rs.getString("meter_rent"));
					t1.append("\n MCB Rent :"+rs.getString("mcb_rent"));
					t1.append("\n Service Tax :"+rs.getString("service_rent"));
					t1.append("\n GST@9% :"+rs.getString("gst"));
					t1.append("\n\n");
				}	
				
					rs = c.s.executeQuery("select * from bill where meter_number = "+c1.getSelectedItem());
				if(rs.next()) {
					
					t1.append("\n Current Month :"+rs.getString("month"));
					t1.append("\n Units Consumed :"+rs.getString("units"));
					t1.append("\n Total Charge  :"+rs.getString("amount"));
					t1.append("\n----------------------------------------------------");
					t1.append("\n Total Payable Amount :"+rs.getString("amount"));				
					
				}
				
				
		}catch(Exception e) {
			
			System.out.println(e);
		}
	}
	
	
	public static void main(String args[]) {
		
		new Generate_bill().setVisible(true);
	}



}
