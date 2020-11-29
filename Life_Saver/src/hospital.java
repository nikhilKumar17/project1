import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class hospital extends JFrame {

	private JPanel contentPane;
	private JTextField textAplus;
	private JTextField textA_neg;
	private JTextField textABplus;
	private JTextField textAB_neg;
	private JTextField textBplus;
	private JTextField textB_neg;
	private JTextField textOplus;
	private JTextField textO_neg;
	private JTextField textHospital_name;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					hospital frame = new hospital();
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
	public hospital() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1012, 701);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLUE);
		panel.setBounds(292, 10, 743, 667);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textAplus = new JTextField();
		textAplus.setBounds(164, 128, 147, 41);
		panel.add(textAplus);
		textAplus.setColumns(10);
		
		textA_neg = new JTextField();
		textA_neg.setColumns(10);
		textA_neg.setBounds(530, 140, 147, 41);
		panel.add(textA_neg);
		
		textABplus = new JTextField();
		textABplus.setColumns(10);
		textABplus.setBounds(164, 225, 147, 41);
		panel.add(textABplus);
		
		textAB_neg = new JTextField();
		textAB_neg.setColumns(10);
		textAB_neg.setBounds(530, 213, 147, 41);
		panel.add(textAB_neg);
		
		textBplus = new JTextField();
		textBplus.setColumns(10);
		textBplus.setBounds(164, 342, 147, 41);
		panel.add(textBplus);
		
		textB_neg = new JTextField();
		textB_neg.setColumns(10);
		textB_neg.setBounds(530, 323, 147, 41);
		panel.add(textB_neg);
		
		textOplus = new JTextField();
		textOplus.setColumns(10);
		textOplus.setBounds(164, 472, 147, 41);
		panel.add(textOplus);
		
		textO_neg = new JTextField();
		textO_neg.setColumns(10);
		textO_neg.setBounds(530, 472, 147, 41);
		panel.add(textO_neg);
 
	
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 128));
		panel_1.setBounds(10, 10, 294, 667);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		textHospital_name = new JTextField();
		textHospital_name.setBounds(22, 139, 240, 41);
		panel_1.add(textHospital_name);
		textHospital_name.setColumns(10);
		
		JButton btnNewButton = new JButton("ENTER");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			//	String  Hdis =  get_distance .getText();
				 try {
					Class.forName( "com.mysql.jdbc.Driver");
			 
					Connection signconn = DriverManager.getConnection("jdbc:mysql://localhost:3307/nikhil","root","");
					PreparedStatement signps = signconn.prepareStatement("insert into  hospital_data(Hospital_name,Blood_Aplus,Blood_Aneg,Blood_Bplus,Blood_Bneg,Blood_ABplus,Blood_ABneg,Blood_Oplus,Blood_Oneg) values(?,?,?,?,?,?,?,?,?)");
					                                                                                           //1      2                                                                                   1 2 3 4 5  6 7 8 9
					signps.setString(1, textHospital_name.getText());
					
					signps.setString(2,textAplus.getText() );
					signps.setString(3,textA_neg.getText() );
					
					signps.setString(4,textABplus.getText());
					signps.setString(5, textAB_neg.getText());
					
					signps.setString(6, textBplus.getText());
					signps.setString(7, textB_neg.getText());
					
					signps.setString(8, textOplus.getText());
					signps.setString(9, textO_neg.getText());
					
					
					signps.executeUpdate();
					
					  JOptionPane.showMessageDialog(null, "add succesfully");
					} catch (Exception e1) {
					 
						e1.printStackTrace();
					}
				
			}
		});
		btnNewButton.setBounds(53, 270, 189, 61);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("EDIT");
		btnNewButton_1.setBounds(53, 389, 191, 61);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("DELECT");
		btnNewButton_2.setBounds(55, 544, 189, 68);
		panel_1.add(btnNewButton_2);
		
		 
		
		JLabel lblNewLabel_1 = new JLabel("Hospital_name");
		lblNewLabel_1.setForeground(new Color(240, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
		lblNewLabel_1.setBounds(41, 69, 181, 68);
		panel_1.add(lblNewLabel_1);
		JLabel lblNewLabel = new JLabel("A+");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBackground(new Color(127, 255, 0));
		lblNewLabel.setBounds(33, 125, 87, 48);
		panel.add(lblNewLabel);
		
		JLabel lblAb = new JLabel("AB+");
		lblAb.setHorizontalAlignment(SwingConstants.CENTER);
		lblAb.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 20));
		lblAb.setBackground(new Color(127, 255, 0));
		lblAb.setBounds(33, 225, 87, 48);
		panel.add(lblAb);
		
		JLabel lblB = new JLabel("B+");
		lblB.setHorizontalAlignment(SwingConstants.CENTER);
		lblB.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 20));
		lblB.setBackground(new Color(127, 255, 0));
		lblB.setBounds(33, 352, 87, 48);
		panel.add(lblB);
		
		JLabel lblO = new JLabel("O+");
		lblO.setHorizontalAlignment(SwingConstants.CENTER);
		lblO.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 20));
		lblO.setBackground(new Color(127, 255, 0));
		lblO.setBounds(56, 469, 87, 48);
		panel.add(lblO);
		
		JLabel lblA = new JLabel("A-");
		lblA.setHorizontalAlignment(SwingConstants.CENTER);
		lblA.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 20));
		lblA.setBackground(new Color(127, 255, 0));
		lblA.setBounds(415, 125, 87, 48);
		panel.add(lblA);
		
		JLabel lblAb_1 = new JLabel("AB-");
		lblAb_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblAb_1.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 20));
		lblAb_1.setBackground(new Color(127, 255, 0));
		lblAb_1.setBounds(415, 213, 87, 48);
		panel.add(lblAb_1);
		
		JLabel lblB_1 = new JLabel("B-");
		lblB_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblB_1.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 20));
		lblB_1.setBackground(new Color(127, 255, 0));
		lblB_1.setBounds(402, 320, 87, 48);
		panel.add(lblB_1);
		
		JLabel lblO_1 = new JLabel("O-");
		lblO_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblO_1.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 20));
		lblO_1.setBackground(new Color(127, 255, 0));
		lblO_1.setBounds(415, 446, 87, 48);
		panel.add(lblO_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(0, 0, 743, 667);
		Image As = new ImageIcon(this.getClass().getResource("s2.jpeg")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(As));
		panel.add(lblNewLabel_2);

	}
}
