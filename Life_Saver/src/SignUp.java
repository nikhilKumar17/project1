
 import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JRadioButtonMenuItem;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.JToggleButton;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignUp extends JFrame {

	private JPanel contentPane;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtEmail;
	private JTextField txtPhoneNumber;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField bbbbb;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp frame = new SignUp();
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
	public SignUp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450,10 , 580, 830);
		contentPane = new JPanel();
 		 
		contentPane.setBackground(new Color(25, 25, 112));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
 
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtFirstName = new JTextField();
		txtFirstName.setBounds(44, 159, 215, 41);
		contentPane.add(txtFirstName);
		txtFirstName.setColumns(10);
		
		txtLastName = new JTextField();
		txtLastName.setBounds(316, 159, 215, 41);
		contentPane.add(txtLastName);
		txtLastName.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(44, 237, 454, 35);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtPhoneNumber = new JTextField();
		txtPhoneNumber.setBounds(44, 328, 454, 41);
		contentPane.add(txtPhoneNumber);
		txtPhoneNumber.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(44, 417, 451, 41);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(44, 506, 454, 41);
		contentPane.add(passwordField_1);
		
		JLabel lblNewLabel = new JLabel("X");
		lblNewLabel.setBounds(528, 10, 45, 41);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel.setForeground(new Color(255, 0, 0));
		contentPane.add(lblNewLabel);
		
		ButtonGroup bg =new ButtonGroup();// use one one button choose
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Male");
		rdbtnNewRadioButton.setBounds(44, 571, 135, 41);
		contentPane.add(rdbtnNewRadioButton);
		bg.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Female");
		rdbtnNewRadioButton_1.setBounds(201, 571, 135, 41);
		contentPane.add(rdbtnNewRadioButton_1);
		bg.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Other");
		rdbtnNewRadioButton_2.setBounds(354, 571, 144, 41);
		contentPane.add(rdbtnNewRadioButton_2);
		bg.add(rdbtnNewRadioButton_2);
		
	 
		
		lblNewLabel_1 = new JLabel("Sign Up");
		lblNewLabel_1.setBounds(44, 10, 440, 71);
		lblNewLabel_1.setBackground(new Color(25, 25, 112));
 
		lblNewLabel_1.setForeground(new Color(124, 252, 0));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Sitka Text", Font.BOLD, 35));
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setBounds(44, 379, 260, 28);
		lblNewLabel_2.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_2.setForeground(Color.WHITE);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel(" Confirm Password");
		lblNewLabel_2_1.setBounds(44, 468, 260, 28);
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 20));
		contentPane.add(lblNewLabel_2_1);
		
		lblNewLabel_3 = new JLabel("Date of birth");
		lblNewLabel_3.setBounds(44, 649, 135, 48);
		lblNewLabel_3.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_3.setForeground(Color.WHITE);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Sign Up");
		btnNewButton.setBounds(166, 733, 240, 70);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String firstName =	txtFirstName.getText();
				String lastname = txtLastName.getText();
				String email = txtEmail.getText();
				String PhoneNo = txtPhoneNumber.getText();
				String passowrod = passwordField.getText();
				String confirm_pass = passwordField_1.getText();
				String DOb =  bbbbb.getText();
				String gender = null;
				if(rdbtnNewRadioButton.isSelected()) {
					gender ="male";
				}
				if(rdbtnNewRadioButton_1.isSelected()) {
					gender ="female";
				}
				if(rdbtnNewRadioButton_2.isSelected()) {
					gender ="other";
				}
				//gender.getText();
				try{
				Class.forName( "com.mysql.jdbc.Driver");
				Connection signconn = DriverManager.getConnection("jdbc:mysql://localhost:3307/nikhil","root","");
				PreparedStatement signps = signconn.prepareStatement("insert into signup(first_name,last_name,email_id,phoneNo, password,gender, DOB) values( ?,?,?,?,?,?, ?)");
//			                                                                     mysqldata name^^
				signps.setString(1,firstName );
			  signps.setString(2,lastname );
			  signps.setString(3,email);
			  signps.setString(4,PhoneNo);
			  signps.setString(5, passowrod );
			 signps.setString(6,gender);
			  signps.setString(7,DOb);
			 // signps.setString(,);
			  
			  signps.executeUpdate();
			  JOptionPane.showMessageDialog(null, "sigins succesfully");
		    	
				}catch(Exception e1) {
					System.out.println(e1);
				}
			}
		});
		btnNewButton.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 30));
		btnNewButton.setBackground(Color.GREEN);
		contentPane.add(btnNewButton);
		
		bbbbb = new JTextField();
		bbbbb.setBounds(222, 667, 309, 35);
		bbbbb.setFont(new Font("Sitka Text", Font.PLAIN, 20));
		bbbbb.setText("yyyy-mm-dd");
		contentPane.add(bbbbb);
		bbbbb.setColumns(10);
		Image As = new ImageIcon(this.getClass().getResource("s1.jpeg")).getImage();
		
		JLabel lblNewLabel_4 = new JLabel("Last Name");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel_4.setBounds(305, 121, 205, 28);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("First Name");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Sitka Text", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(54, 121, 194, 28);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Phone Number");
		lblNewLabel_6.setFont(new Font("Sitka Text", Font.PLAIN, 24));
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setBounds(44, 282, 233, 36);
		contentPane.add(lblNewLabel_6);
		
		JLabel pic = new JLabel("");
		pic.setBounds(0, 0, 580, 830);
		Image A = new ImageIcon(this.getClass().getResource("s1.jpeg")).getImage();
		pic.setIcon(new ImageIcon(A));
		contentPane.add(pic);
 
		setUndecorated(true);
	}
}
