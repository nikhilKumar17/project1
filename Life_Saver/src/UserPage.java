 import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JSplitPane;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.CardLayout;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.ResultSetMetaData;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ScrollPaneConstants;

public class UserPage extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTextField searchBar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserPage frame = new UserPage();
					frame.setVisible(true);
				 
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
 
	  String returnstatement( String b , String h)
	   {
		 String m ="SELECT hospital_data.info,\r\n" + 
			  		"hospital_dis.to_hp,\r\n" + 
			  		"hospital_dis.distance ,\r\n" + 
			  		"hospital_data.Hospital_name,\r\n" +
			  		"hospital_data."+b+"\r\n"+
			  	 
			  		"FROM hospital_dis , hospital_data \r\n" + 
			  		"   WHERE   ( hospital_dis.hd_id =  hospital_data.hd_id AND hospital_dis.to_hp= '"+h +" ')"+
			  		"   ORDER BY distance ;";
		   return  m ;
	 
	   
	   }
	  
	  public void con() {
		  
	  }
	  
	  
	public  UserPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1095, 696);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//this.setOpacity(0.8f);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 128));
		panel.setBounds(250, 81, 839, 571);
		contentPane.add(panel);
		panel.setLayout(new CardLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 255, 0));
		panel_1.setBounds(0, 10, 250, 642);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
//
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(Color.GREEN);
		comboBox.setModel(new DefaultComboBoxModel(
				new String[] {"Hospital_A", "Hospital_B", "Hospital_C", "Hospital_D", "Hospital_E", "Hospital_F"}));
		comboBox.setBounds(50, 442, 153, 35);
		panel_1.add(comboBox);
		//int index = comboBox.getSelectedIndex();
		
		 
		JPanel user_pl = new JPanel();
		user_pl.setBackground(new Color(0, 0, 128));
		panel.add(user_pl, "name_537093776546900");
		
		JPanel search_pl = new JPanel();
		search_pl.setBackground(new Color(0, 128, 0));
		panel.add(search_pl  );
		search_pl.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(0, 0, 829, 571);
		search_pl.add(scrollPane);
		
		table_1 = new JTable();
		table_1.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		table_1.setBackground(Color.YELLOW);
		scrollPane.setViewportView(table_1);
		table_1.setRowHeight(110);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				  "Hospital_name" , "near Hospital", "distance" , "Blood Unit" ,"Contact details" //"blood"
			}
		));
		 
  
	// String Hospitalname  =  (String) comboBox.getSelectedItem() ;
		
		JButton btn_Apos = new JButton("");
		btn_Apos.setBounds(10, 56, 162, 196);
		btn_Apos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

					String		bloodname = "Blood_Aplus";
				
				try {
					panel.removeAll();
					 panel.add(search_pl);
					 panel.revalidate();
					 String Hospitalname  =  (String) comboBox.getSelectedItem() ;
					 	 
					  
					  Class.forName( "com.mysql.jdbc.Driver");
						Connection signconn = DriverManager.getConnection("jdbc:mysql://localhost:3307/nikhil","root","");
					 
						PreparedStatement signps1 = signconn.prepareStatement( returnstatement(bloodname ,Hospitalname));
						 
						ResultSet rs = signps1.executeQuery();  //
						int a;
					    ResultSetMetaData rd=(ResultSetMetaData) rs.getMetaData(); // 
					    a= rd.getColumnCount(); // get no column from db
					    DefaultTableModel df =(DefaultTableModel)table_1.getModel();
                    df.setRowCount(0);
                   
                    while( rs.next()  )
                    {
                    	Vector v2 = new Vector();
                  	for (int i=1;i<=a;i++)
                    	{
                    		
                    		v2.add(rs.getString("to_hp"));
                    		v2.add(rs.getString("Hospital_name"));
                             v2.add(rs.getString("distance"));
                    	 	 v2.add( rs.getString(bloodname ));
                    		  v2.add( rs.getString("info"));
                    
                    	}
 
                  	   	df.addRow(v2); 
                    	
                    }
                	 
		 
    }
		  
		  
		 catch(Exception e1) {
			System.out.println(e1);
			}
			}
		});
		 
		 
		btn_Apos.setBackground(new Color(0, 0, 128));
		btn_Apos.setBorder(null);
		btn_Apos.setHorizontalAlignment(SwingConstants.CENTER);
		 Image  A_plus = new ImageIcon(this.getClass().getResource("blood A+.png")).getImage();
		 user_pl.setLayout(null);
		 user_pl.setLayout(null);
		 btn_Apos .setIcon(new ImageIcon(A_plus));
		 user_pl.add(btn_Apos);
		
		JButton btn_Bpos = new JButton("");
		btn_Bpos.setBounds(236, 56, 128, 196);
		btn_Bpos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				 panel.add(search_pl);
				 panel.revalidate();
				
				
				try {
					String bloodname = "Blood_Bplus" ;
			//	 System.out.println(bloodname);
					String Hospitalname  =  (String) comboBox.getSelectedItem() ;
					  
					  Class.forName( "com.mysql.jdbc.Driver");
						Connection signconn = DriverManager.getConnection("jdbc:mysql://localhost:3307/nikhil","root","");
					 
						PreparedStatement signps1 = signconn.prepareStatement( returnstatement(bloodname ,Hospitalname));
						 
						ResultSet rs = signps1.executeQuery();  //
						int a;
					    ResultSetMetaData rd=(ResultSetMetaData) rs.getMetaData(); // 
					    a= rd.getColumnCount(); // get no column from db
					    DefaultTableModel df =(DefaultTableModel)table_1.getModel();
                    df.setRowCount(0);
                   
                    while( rs.next()  )
                    {
                    	Vector v2 = new Vector();
                  	for (int i=1;i<=a;i++)
                    	{
                    		
                    		v2.add(rs.getString("to_hp"));
                    		v2.add(rs.getString("Hospital_name"));

                            
                    	    
                    	 	v2.add(rs.getString("distance"));
                    	 	 
                    		  v2.add( rs.getString(bloodname));
                    		  v2.add( rs.getString("info"));
                    		  
                    	}
//                   	 b++ ;
                  	   	df.addRow(v2); 
                   
                 
//                    	
                    }
               	 
		 
   }
 
		 catch(Exception e1) {
			System.out.println(e1);
			}
			}
		});
		btn_Bpos.setBorder(null);
		btn_Bpos.setBackground(new Color(0, 0, 128));
		btn_Bpos.setHorizontalAlignment(SwingConstants.CENTER);
		 Image  B_plus = new ImageIcon(this.getClass().getResource("blood B+.png")).getImage();
		 btn_Bpos .setIcon(new ImageIcon(B_plus));
		
		 user_pl.add(btn_Bpos);
		
		
		 
		 JButton btn_ABpos = new JButton("");
		 btn_ABpos.setBounds(432, 56, 141, 196);
		 btn_ABpos.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		String bloodname = "Blood_ABplus";
				
				try {
					panel.removeAll();
					 panel.add(search_pl);
					 panel.revalidate();
					 String Hospitalname  =  (String) comboBox.getSelectedItem() ;
					 
					  
					  Class.forName( "com.mysql.jdbc.Driver");
						Connection signconn = DriverManager.getConnection("jdbc:mysql://localhost:3307/nikhil","root","");
					 
						PreparedStatement signps1 = signconn.prepareStatement( returnstatement(bloodname ,Hospitalname));
						 
						ResultSet rs = signps1.executeQuery();  //
						int a;
					    ResultSetMetaData rd=(ResultSetMetaData) rs.getMetaData(); // 
					    a= rd.getColumnCount(); // get no column from db
					    DefaultTableModel df =(DefaultTableModel)table_1.getModel();
                    df.setRowCount(0);
                   
                    while( rs.next()  )
                    {
                    	Vector v2 = new Vector();
                  	for (int i=1;i<=a;i++)
                    	{
                    		
                    		v2.add(rs.getString("to_hp"));
                    		v2.add(rs.getString("Hospital_name"));
                             v2.add(rs.getString("distance"));
                    	 	 v2.add( rs.getString(bloodname ));
                    		  v2.add( rs.getString("info"));
                    
                    	}
 
                  	   	df.addRow(v2); 
                    	
                    }
                	 
		 
    }
		  
		  
		 catch(Exception e1) {
			System.out.println(e1);
			}
		 	}
		 });
		btn_ABpos.setBackground(new Color(0, 0, 128));
		btn_ABpos.setBorder(null);
		btn_ABpos.setHorizontalAlignment(SwingConstants.CENTER);
		Image AB_plus = new ImageIcon(this.getClass().getResource("blood AB+.png")).getImage();
		btn_ABpos .setIcon(new ImageIcon(AB_plus));
		user_pl.add(btn_ABpos);
		
		JButton btn_Opos = new JButton("");
		btn_Opos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bloodname ="Blood_Oplus";
				
				try {
					panel.removeAll();
					 panel.add(search_pl);
					 panel.revalidate();
					 String Hospitalname  =  (String) comboBox.getSelectedItem() ;
					 	 
					  
					  Class.forName( "com.mysql.jdbc.Driver");
						Connection signconn = DriverManager.getConnection("jdbc:mysql://localhost:3307/nikhil","root","");
					 
						PreparedStatement signps1 = signconn.prepareStatement( returnstatement(bloodname ,Hospitalname));
						 
						ResultSet rs = signps1.executeQuery();  //
						int a;
					    ResultSetMetaData rd=(ResultSetMetaData) rs.getMetaData(); // 
					    a= rd.getColumnCount(); // get no column from db
					    DefaultTableModel df =(DefaultTableModel)table_1.getModel();
                    df.setRowCount(0);
                   
                    while( rs.next()  )
                    {
                    	Vector v2 = new Vector();
                  	for (int i=1;i<=a;i++)
                    	{
                    		
                    		v2.add(rs.getString("to_hp"));
                    		v2.add(rs.getString("Hospital_name"));
                             v2.add(rs.getString("distance"));
                    	 	 v2.add( rs.getString(bloodname ));
                    		  v2.add( rs.getString("info"));
                    
                    	}
 
                  	   	df.addRow(v2); 
                    	
                    }
                	 
		 
    }
		  
		  
		 catch(Exception e1) {
			System.out.println(e1);
			}
			}
		});
		btn_Opos.setBounds(648, 56, 128, 196);
		btn_Opos.setBorder(null);
		btn_Opos.setBackground(new Color(0, 0, 128));
		btn_Opos.setHorizontalAlignment(SwingConstants.CENTER);
		Image O_plus = new ImageIcon(this.getClass().getResource("blood O+.png")).getImage();
		btn_Opos.setIcon(new ImageIcon(O_plus));
		user_pl.add(btn_Opos);
		
		JButton btn_Aneg = new JButton("");
		btn_Aneg.setBounds(25, 300, 128, 196);
		btn_Aneg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bloodname = "Blood_Aneg";
				
				try {
					panel.removeAll();
					 panel.add(search_pl);
					 panel.revalidate();
					 String Hospitalname  =  (String) comboBox.getSelectedItem() ;
					 	 
					  
					  Class.forName( "com.mysql.jdbc.Driver");
						Connection signconn = DriverManager.getConnection("jdbc:mysql://localhost:3307/nikhil","root","");
					 
						PreparedStatement signps1 = signconn.prepareStatement( returnstatement(bloodname ,Hospitalname));
						 
						ResultSet rs = signps1.executeQuery();  //
						int a;
					    ResultSetMetaData rd=(ResultSetMetaData) rs.getMetaData(); // 
					    a= rd.getColumnCount(); // get no column from db
					    DefaultTableModel df =(DefaultTableModel)table_1.getModel();
                    df.setRowCount(0);
                   
                    while( rs.next()  )
                    {
                    	Vector v2 = new Vector();
                  	for (int i=1;i<=a;i++)
                    	{
                    		
                    		v2.add(rs.getString("to_hp"));
                    		v2.add(rs.getString("Hospital_name"));
                             v2.add(rs.getString("distance"));
                    	 	 v2.add( rs.getString(bloodname ));
                    		  v2.add( rs.getString("info"));
                    
                    	}
 
                  	   	df.addRow(v2); 
                    	
                    }
                	 
		 
    }
		  
		  
		 catch(Exception e1) {
			System.out.println(e1);
			}
			}
			
			
	
		
		});
		btn_Aneg.setBorder(null);
		btn_Aneg.setBackground(new Color(0, 0, 128));
		btn_Aneg.setHorizontalAlignment(SwingConstants.CENTER);
		Image A_minus = new ImageIcon(this.getClass().getResource("blood A-.png")).getImage();
		 btn_Aneg .setIcon(new ImageIcon(A_minus));
		 user_pl.add(btn_Aneg);
		
		JButton btn_ABneg = new JButton("");
		btn_ABneg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bloodname = "Blood_ABneg";
				
				try {
					panel.removeAll();
					 panel.add(search_pl);
					 panel.revalidate();
					 String Hospitalname  =  (String) comboBox.getSelectedItem() ;
					  
					  
					  Class.forName( "com.mysql.jdbc.Driver");
						Connection signconn = DriverManager.getConnection("jdbc:mysql://localhost:3307/nikhil","root","");
					 
						PreparedStatement signps1 = signconn.prepareStatement( returnstatement(bloodname ,Hospitalname));
						 
						ResultSet rs = signps1.executeQuery();  //
						int a;
					    ResultSetMetaData rd=(ResultSetMetaData) rs.getMetaData(); // 
					    a= rd.getColumnCount(); // get no column from db
					    DefaultTableModel df =(DefaultTableModel)table_1.getModel();
                    df.setRowCount(0);
                   
                    while( rs.next()  )
                    {
                    	Vector v2 = new Vector();
                  	for (int i=1;i<=a;i++)
                    	{
                    		
                    		v2.add(rs.getString("to_hp"));
                    		v2.add(rs.getString("Hospital_name"));
                             v2.add(rs.getString("distance"));
                    	 	 v2.add( rs.getString(bloodname ));
                    		  v2.add( rs.getString("info"));
                    
                    	}
 
                  	   	df.addRow(v2); 
                    	
                    }
                	 
		 
    }
		  
		  
		 catch(Exception e1) {
			System.out.println(e1);
			}
			}
		});
		btn_ABneg.setBounds(236, 300, 141, 196);
		btn_ABneg.setBorder(null);
		btn_ABneg.setBackground(new Color(0, 0, 128));
		btn_ABneg.setHorizontalAlignment(SwingConstants.CENTER);
		Image AB_minus = new ImageIcon(this.getClass().getResource("blood AB-.png")).getImage();
		btn_ABneg.setIcon(new ImageIcon(AB_minus));
		user_pl.add(btn_ABneg);
		
		JButton btn_Bneg = new JButton("");
		btn_Bneg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bloodname = "Blood_Bneg";
			}
		});
		btn_Bneg.setBounds(467, 300, 128, 196);
		btn_Bneg.setBackground(new Color(0, 0, 128));
		btn_Bneg.setBorder(null);
		btn_Bneg.setHorizontalAlignment(SwingConstants.CENTER);
		Image B_minus = new ImageIcon(this.getClass().getResource("blood B-.png")).getImage();
		btn_Bneg .setIcon(new ImageIcon(B_minus));
		user_pl.add(btn_Bneg);
		
		JButton btn_Oneg = new JButton("");
		btn_Oneg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bloodname = "Blood_Oneg";


				try {  panel.removeAll();
				 panel.add(search_pl);
				 panel.revalidate();
					
					String Hospitalname  =  (String) comboBox.getSelectedItem() ;
					 
					  
					  Class.forName( "com.mysql.jdbc.Driver");
						Connection signconn = DriverManager.getConnection("jdbc:mysql://localhost:3307/nikhil","root","");
					 
						PreparedStatement signps1 = signconn.prepareStatement( returnstatement(bloodname ,Hospitalname));
						 
						ResultSet rs = signps1.executeQuery();  //
						int a;
					    ResultSetMetaData rd=(ResultSetMetaData) rs.getMetaData(); // 
					    a= rd.getColumnCount(); // get no column from db
					    DefaultTableModel df =(DefaultTableModel)table_1.getModel();
                    df.setRowCount(0);
                   
                    while( rs.next()  )
                    {
                    	Vector v2 = new Vector();
                  	for (int i=1;i<=a;i++)
                    	{
                    		
                    		v2.add(rs.getString("to_hp"));
                    		v2.add(rs.getString("Hospital_name"));
                             v2.add(rs.getString("distance"));
                    	 	 v2.add( rs.getString(bloodname ));
                    		  v2.add( rs.getString("info"));
                    
                    	}
 
                  	   	df.addRow(v2); 
                    	
                    }
                	 
		 
    }
		  
		  
		 catch(Exception e1) {
			System.out.println(e1);
			}
			}
		});
		btn_Oneg.setBounds(659, 300, 117, 196);
		btn_Oneg.setBackground(new Color(0, 0, 128));
		btn_Oneg.setBorder(null);
		btn_Oneg.setHorizontalAlignment(SwingConstants.CENTER);
		Image O_minus = new ImageIcon(this.getClass().getResource("blood O-.png")).getImage();
		btn_Oneg .setIcon(new ImageIcon(O_minus));
		user_pl.add(btn_Oneg);
		
	 
		
		JLabel lblNewLabel = new JLabel("Life_saver");
		lblNewLabel.setFont(new Font("Sitka Text", Font.PLAIN, 40));
		lblNewLabel.setBounds(0, 10, 229, 107);
		panel_1.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("signUp");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SignUp().setVisible(true);
			}
		});
		btnNewButton.setBounds(0, 217, 212, 70);
		panel_1.add(btnNewButton);
		btnNewButton.setBackground(new Color(0, 255, 0));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Sitka Text", Font.BOLD, 20));
		
		JButton btnNewButton_1 = new JButton("Login");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LoginUser().setVisible(true);
                   
		
			}
		});
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setFont(new Font("Sitka Text", Font.BOLD, 20));
		btnNewButton_1.setBackground(new Color(0, 255, 0));
		btnNewButton_1.setBounds(2, 287, 210, 70);
		panel_1.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Choose starting point");
		lblNewLabel_1.setFont(new Font("Sitka Text", Font.BOLD, 20));
		lblNewLabel_1.setBounds(10, 381, 219, 44);
		panel_1.add(lblNewLabel_1);
 
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 255, 0));
		panel_2.setBounds(220, 10, 869, 76);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnNewButton_2 = new JButton("search");
		btnNewButton_2.setFont(new Font("Sitka Text", Font.BOLD, 16));
		btnNewButton_2.setBackground(new Color(255, 255, 0));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 
				 panel.removeAll();
				 panel.add(search_pl);
				 panel.revalidate();
				 
			}
		});
		btnNewButton_2.setBounds(596, 20, 121, 46);
		panel_2.add(btnNewButton_2);
		
		searchBar = new JTextField();
		searchBar.setBounds(325, 28, 232, 32);
		panel_2.add(searchBar);
		searchBar.setColumns(10);
		
		  
	}
}

