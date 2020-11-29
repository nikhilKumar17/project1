 import java.awt.BorderLayout;
 
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class LoginUser extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUser frame = new LoginUser();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginUser() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(80, 100, 609, 458);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 0, 0));
		contentPane.setBackground(new Color(75, 0, 130));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(232, 101, 324, 50);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(232, 178, 324, 53);
		contentPane.add(passwordField);
	 	//setUndecorated(true);
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Sitka Text", Font.PLAIN, 20));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"User", "Admin"}));
		comboBox.setBounds(232, 258, 324, 43);
		contentPane.add(comboBox);
		comboBox.setSelectedItem("User");
//	 String  UserType = (String) comboBox.getSelectedItem();
//		  String optionOne ="User";
		 // String optionTwo ="Admin";
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBackground(new Color(50, 205, 50));
//		btnNewButton.addMouseListener(new MouseAdapter() {
//			 
//		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try{
					Class.forName( "com.mysql.jdbc.Driver");
					Connection signconn = DriverManager.getConnection("jdbc:mysql://localhost:3307/nikhil","root","");
					//PreparedStatement ps = conn.prepareStatement("insert into logintest(user_id, pass) values( ?,?);");
					//Statement stmt_1= conn.createStatement();
					//String loginstmt = "Select * from logintest where user_id='"+ textField.getText()+" '+ and pass ='"+passwordField.getText().toString()+"'";	
			 
					String UserId =  textField.getText();
					String pass =String.valueOf(passwordField.getPassword());	//  String optionTwo ="Admin";
					String  UserType = (String) comboBox.getSelectedItem();
			 	PreparedStatement login1 = signconn.prepareStatement("insert into logintest( email_id,  pass, UserType) values( ?,?,? )");
//                    mysqldata name^^
			 	login1.setString(1,UserId );
			 	login1.setString(2, pass );
			 	login1.setString(3, UserType);
			 	login1.executeUpdate();
			 	
			 	
			 	
			 	
 
					PreparedStatement signps = signconn.prepareStatement("Select * from signup where email_id=? and password=?");
					
					signps.setString(1, UserId);
			    signps.setString(2, pass);
			    
		      ResultSet rs = signps.executeQuery();
			    
					if(rs.next()) {
 
//			    	JOptionPane.showMessageDialog(null, "Logins succesfully");
			    	if(UserType.equals("User")) {
			    		JOptionPane.showMessageDialog(null, "Logins succesfully");
			    	new UserPage().setVisible(true);
					 
					  dispose();
				 
			    	}
			    	if(UserType.equals("Admin")) {
			    		JOptionPane.showMessageDialog(null, "Logins succesfully");
			    	new hospital().setVisible(true);
					 
					  dispose();
			    	}
			 
					}
			    else
			    	JOptionPane.showMessageDialog(null, "incorrect userId and Password");
 
			    
				}catch(Exception e1) {
					System.out.println(e1);
				}
			}
		});
 
		btnNewButton.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		btnNewButton.setBounds(80, 342, 159, 38);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("signUp");
		btnNewButton_1.setBackground(Color.ORANGE);
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SignUp().
				setVisible(true);
				dispose();
				 
			}
		});
 
		btnNewButton_1.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		btnNewButton_1.setBounds(338, 342, 159, 38);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("UseriD");
		lblNewLabel.setForeground(new Color(240, 248, 255));
		lblNewLabel.setFont(new Font("Sitka Text", Font.BOLD, 16));
		lblNewLabel.setBounds(53, 105, 92, 43);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setForeground(new Color(240, 248, 255));
		lblNewLabel_1.setFont(new Font("Sitka Text", Font.BOLD, 16));
		lblNewLabel_1.setBounds(53, 180, 104, 50);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(" X");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		lblNewLabel_2.setForeground(new Color(255, 0, 0));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(883, 0, 67, 28);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Login");
		lblNewLabel_3.setForeground(new Color(0, 255, 0));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Sitka Text", Font.PLAIN, 30));
		lblNewLabel_3.setBounds(159, 30, 197, 65);
		contentPane.add(lblNewLabel_3);
		
		
		
		JLabel lblNewLabel_4 = new JLabel("Slecte User type");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Sitka Text", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(80, 254, 160, 50);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("New");
		lblNewLabel_5.setBounds(0, 0, 603, 499);
		//contentPane.add(lblNewLabel_5);
		Image As = new ImageIcon(this.getClass().getResource("l.png")).getImage();
		lblNewLabel_5.setIcon(new ImageIcon(As));
		contentPane.add(lblNewLabel_5);
		
//		passwordField = new JPasswordField();
//		passwordField.setBounds(185, 178, 380, 53);
//		contentPane.add(passwordField);
	 	//setUndecorated(true);
	}
}
