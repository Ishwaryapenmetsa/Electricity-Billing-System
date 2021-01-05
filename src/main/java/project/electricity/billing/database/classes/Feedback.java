package project.electricity.billing.database.classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class Feedback extends JFrame implements ActionListener {
	
	JLabel l1 , l2;
	Choice c1;
	JButton b1;
	JTextArea a1;
	JPanel p1 , p2 , p3;
	
	Feedback(){
		
		super("Feed Back Forum");
		setSize(300,300);
		setLayout(new BorderLayout());
		
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		
		l1 = new JLabel("Meter Number");
		l2 = new JLabel("Feed back");
		
		c1 = new Choice();
		
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
		
		a1 = new JTextArea(5 , 15);
		a1.setFont(new Font("monospaced",Font.PLAIN,15));
		
		ImageIcon ic1 = new ImageIcon(ClassLoader.getSystemResource("login.png"));
		Image i1 = ic1.getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT);
		b1 = new JButton("Submit", new ImageIcon(i1));
		
		b1.addActionListener(this);
		
		p1.add(l1);
		p1.add(c1);
		add(p1,BorderLayout.NORTH);
		
		p3.add(l2);
		p3.add(a1);
		add(p3,BorderLayout.CENTER);
		
		p2.add(b1);
		add(p2,BorderLayout.SOUTH);
		
		
	}

	public void actionPerformed(ActionEvent ae) {
		
		
		try {
			
			String a = a1.getText();
			
			if(a!=null && !a.equals("")) {
			
				JOptionPane.showMessageDialog(null, "Feedback submitted.. Thank you for your feedback");
			
				this.setVisible(false);
			}else {
				
				JOptionPane.showMessageDialog(null, "Plz enter the feedback");
			}
				
			
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		
	}

	public static void main(String args[]) {
		
		new Feedback().setVisible(true);
	}
}
