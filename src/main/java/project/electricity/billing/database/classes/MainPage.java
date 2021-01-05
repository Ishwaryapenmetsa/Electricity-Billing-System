package project.electricity.billing.database.classes;

import javax.swing.*;// import classes in swings
import java.awt.*;
import java.awt.event.*;// it is used for action performing buttons
import java.sql.*;

public class MainPage extends JFrame implements ActionListener{
	
	MainPage(){ //constructor
		
		super("Electricity Billing System"); //set main heading of page
		setSize(1920,1030); // to set dimensions of main page
		
		ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("backgroundimage.jpg"));
		Image i1 = ic.getImage().getScaledInstance(1300, 800, Image.SCALE_DEFAULT);
		ImageIcon a = new ImageIcon(i1);
		JLabel l1 = new JLabel(a);
		add(l1);		 //added label l1 to the frame
		
		JMenuBar Mb = new JMenuBar();  // setting a menubar
		JMenu menu = new JMenu("DETAILS"); // new customer , customer details , deposit details 
		JMenuItem m2 = new JMenuItem("Customer details");
		
		menu.setForeground(Color.BLUE); // Property of html to set the color
	
		menu.add(m2);
		
		Mb.add(menu);
		
		setJMenuBar(Mb); // sets menubar to the frame.
		
		
		
		// ------- CUSTOMER DETAILS ------
		m2.setFont(new Font("monospaced",Font.PLAIN,12));
		ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("IMAGE.png"));
		Image i3 = image1.getImage().getScaledInstance(12, 12, Image.SCALE_DEFAULT);
		m2.setIcon(new ImageIcon(i3));
		m2.setMnemonic('M');
		m2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.CTRL_MASK));
		
		// adding action 
		m2.addActionListener(this);
		
		
		// --------user related--------
		JMenu menu1 = new JMenu("BILLING");
		JMenuItem m3 = new JMenuItem("Pay Bill");
		JMenuItem m4 = new JMenuItem("Calculate bill");
		
		menu1.setForeground(Color.ORANGE);
		
		menu1.add(m3);
		menu1.add(m4);
		
		Mb.add(menu1);
		
		//--------- PAY BILL---------
		m3.setFont(new Font("monospaced",Font.PLAIN,12));
		ImageIcon image2 = new ImageIcon(ClassLoader.getSystemResource("icon4.png"));
		Image i4 = image2.getImage().getScaledInstance(20,20, Image.SCALE_DEFAULT);
		m3.setIcon(new ImageIcon(i4));
		m3.setMnemonic('P');
		m3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,ActionEvent.CTRL_MASK));
		m3.setBackground(Color.WHITE);
		
		
		// ---------- CALCULATE BILL ------------
		m4.setFont(new Font("monospaced",Font.PLAIN,12));
		ImageIcon image3 = new ImageIcon(ClassLoader.getSystemResource("icon5.png"));
		Image i5 = image3.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		m4.setIcon(new ImageIcon(i5));
		m4.setMnemonic('B');
		m4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B,ActionEvent.CTRL_MASK));
		
		m3.addActionListener(this);
		m4.addActionListener(this);
		
		//----------- REPORT----------
		JMenu menu2 = new JMenu("REPORT");
		JMenuItem m5 = new JMenuItem("Generation of bill");
		
		menu2.setForeground(Color.BLUE);
		
		menu2.add(m5);
	    Mb.add(menu2);
	    
	    
	    m5.setFont(new Font("monospaced",Font.PLAIN,12)); // setting particular font
	    ImageIcon image4 = new ImageIcon(ClassLoader.getSystemResource("icon7.png"));
	    Image i6 = image4.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
	    m5.setIcon(new ImageIcon (i6));
	    m5.setMnemonic('R');
	    m5.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,ActionEvent.CTRL_MASK));
	    m5.setBackground(Color.WHITE);
	    
	    m5.addActionListener(this);
	    
	    //----------FEED BACK-----------
	    JMenu menu3 = new JMenu("FEEDBACK");
		JMenuItem m6 = new JMenuItem("Feedback");
		
		menu3.add(m6);
		Mb.add(menu3);
		menu3.setForeground(Color.ORANGE);
		
		 m6.setFont(new Font("monospaced",Font.PLAIN,12));
		 ImageIcon image5 = new ImageIcon(ClassLoader.getSystemResource("icon6.png"));
		 Image i7 = image5.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		 m6.setIcon(new ImageIcon (i7));
	     m6.setMnemonic('F');
		 m6.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F,ActionEvent.CTRL_MASK));
		 m6.setBackground(Color.WHITE);
		 m6.addActionListener(this);
		 
		 //-------- EXIT ----------
		 JMenu menu4 = new JMenu("EXIT");
		 JMenuItem m7 = new JMenuItem("exit");
		 m7.setFont(new Font("monospaced",Font.PLAIN,12));
		 ImageIcon image6 = new ImageIcon(ClassLoader.getSystemResource("exit.jpg"));
		 Image i8 = image6.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		 m7.setIcon(new ImageIcon (i8));
	     m7.setMnemonic('X');
		 m7.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,ActionEvent.CTRL_MASK));
		 
		 m7.addActionListener(this);
			
		 menu4.add(m7);
		 Mb.add(menu4);
		 menu4.setForeground(Color.BLUE);
		
		
		
		
	}

	public void actionPerformed(ActionEvent ae) {
		
		String msg = ae.getActionCommand();  // getActionCommand() - action command identifies the button
		
		
		if(msg.equals("Customer details")) {
			new customer_details().setVisible(true);
		}else if(msg.equals("Pay Bill")) {
			new pay_bill().setVisible(true);
		}else if(msg.equals("Calculate bill")) {
			new calculate_bill().setVisible(true);
		}else if(msg.equals("Generation of bill")) {
			new Generate_bill().setVisible(true);
		}else if(msg.equals("Feedback")) {
			new Feedback().setVisible(true);
		}else if(msg.equals("exit")) {
			System.exit(0);
		}
		
		
		
	}
	
	


	public static void main(String args[]){
	
		new MainPage().setVisible(true); // setVisible is to make the mainpage visible by  default it is false.
	
	}


}
/* ClassLoader.getSystemResource() - load a resource from our pc 
 * getImage() - to returns the image
 * getScaledInstance() - is used to set the dimensions of  image
 * we cant add images to labels only imageicons can be added
 */
 