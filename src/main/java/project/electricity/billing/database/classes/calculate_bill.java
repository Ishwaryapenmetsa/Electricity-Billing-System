package project.electricity.billing.database.classes;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class calculate_bill extends JFrame implements ActionListener{
	
	JPanel p,p1;
	JButton b1,b2;
	JLabel l1,l2,l3,l4,l5;
	Choice c1,c2;
	JTextField t1;
	String change;
	
	calculate_bill(){
		
		super("Calculate Electricity Bill");
		
		p = new JPanel();
		
		p.setLayout(new GridLayout(4,2,30,30)); // GridLayout(int rows , int columns , int hgap ,int vgap);
		p.setBackground(Color.WHITE);
		
		l1 = new JLabel("Calculation of bill");
		l2 = new JLabel("Meter number");
		l3 = new JLabel("Units Consumed");
		l4 = new JLabel("Month");
		
		t1 = new JTextField(10);
		
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
		
		b1 = new JButton("Submit");
		b2 = new JButton("Cancel");
		
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hicon2.jpg"));
		Image i2 = i1.getImage().getScaledInstance(180, 270, Image.SCALE_DEFAULT );
		ImageIcon ic1 = new ImageIcon(i2);
		l5 = new JLabel(ic1);
		
		l1.setFont(new Font("Senserif",Font.PLAIN,26));
		l1.setHorizontalAlignment(JLabel.CENTER);
				
		p.add(l2);
		p.add(c1);
		p.add(l4);
		p.add(c2);
		p.add(l3);
		p.add(t1);
		p.add(b1);
		p.add(b2);
	
		
		setLayout(new BorderLayout(50,40));
		
		add(l1,"North");
		add(p,"Center");
		add(l5,"West");
	
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		getContentPane().setBackground(Color.WHITE);
		setSize(750,500);
		setLocation(350,220);
		
		
		
	}
	

	public void actionPerformed(ActionEvent ae) {
		
		String a = c1.getSelectedItem(); // returns choice of c1
		String b = t1.getText(); // returns units consumed
		String c = c2.getSelectedItem(); // returns choice of c2
		
		
	

		
		try {
			
			if(!ae.getActionCommand().equals("Cancel")) {
				
				int p1 = Integer.parseInt(b); // parseInt() - converts string 'b' into integer 
				int p2 = p1*7;
				int p3 = p2+28+22+20+48;	
				String q = "insert into bill values('"+a+"','"+c+"','"+b+"','"+p3+"')";			
				DatabaseConnection cc = new DatabaseConnection();
			
				cc.s.executeUpdate(q);
			
				JOptionPane.showMessageDialog(null, "Bill Updated....");
				JOptionPane.showMessageDialog(null, "Total bill amount :"+p3);
			
				this.setVisible(false);
			
			}else {
				
				this.setVisible(false);

			}
			
		}catch(Exception e) {
			
			e.printStackTrace(); // The printStackTrace() method in Java is a tool used to handle exceptions and errors.  printStackTrace() is very useful in diagnosing exceptions.
		}
		
	}


	


		public static void main(String args[]) {
		
		new calculate_bill().setVisible(true);
		

	}


	
 }

	

