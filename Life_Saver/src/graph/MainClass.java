package graph;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.ResultSetMetaData;

 

import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class MainClass extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField get_distance;
	private JTextField to_id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainClass frame = new MainClass();
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
	public MainClass() {
		WeightedGraph graph = new WeightedGraph();
		graph.addNode("Hospital_A");
		graph.addNode("Hospital_B");
		graph.addNode("Hospital_C");
		graph.addNode("Hospital_D");
		graph.addNode("Hospital_E");
		graph.addNode("Hospital_F");
		
		
		graph.addEdge("Hospital_A" ,"Hospital_B", 17);
		graph.addEdge("Hospital_A" ,"Hospital_C" , 10);
		graph.addEdge("Hospital_C", "Hospital_B", 5);
		graph.addEdge("Hospital_C" ,"Hospital_D", 9);
		graph.addEdge("Hospital_C" ,"Hospital_E" , 11);
		graph.addEdge("Hospital_B", "Hospital_D", 1);
		graph.addEdge("Hospital_D", "Hospital_E", 6);
		graph.addEdge("Hospital_B", "Hospital_F", 8);
		
		
		
	 
	//	System.out.println(graph.getShortestPath("A", "B"));
		
	//	var path = graph.getShortestPath("A", "B");
	//	//graph.addEdge("A" ,"B", 1);
	//	System.out.println(path.priority);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 697, 670);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Hospital_A", "Hospital_B", "Hospital_C", "Hospital_D", "Hospital_E", "Hospital_F"}));
		comboBox.setBounds(149, 98, 144, 38);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Hospital_A", "Hospital_B", "Hospital_C", "Hospital_D", "Hospital_E", "Hospital_F"}));
		comboBox_1.setBounds(149, 220, 144, 41);
		contentPane.add(comboBox_1);
		
		
//		textField = new JTextField();
//		textField.setBounds(80, 275, 145, -36);
//		contentPane.add(textField);
//		textField.setColumns(10);
		
		get_distance = new JTextField();
		get_distance.setBounds(373, 98, 257, 208);
		contentPane.add(get_distance);
		get_distance.setColumns(10);
		
		to_id = new JTextField();
		to_id.setBounds(149, 271, 144, 30);
		contentPane.add(to_id);
		to_id.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
			
			String from =  (String) comboBox.getSelectedItem();
			String to     =   (String) comboBox_1.getSelectedItem();
			var path = graph.getShortestPath(from, to);
			
	 	get_distance.setText(" "+path.priority);  ;
			 String   Hdis =	 	get_distance.getText();
		 Class.forName( "com.mysql.jdbc.Driver");
			Connection signconn = DriverManager.getConnection("jdbc:mysql://localhost:3307/nikhil","root","");
			PreparedStatement signps = signconn.prepareStatement("insert into  hospital_dis(Hospital_name,distance,to_hp, hd_id) values(?,?,?,?);");
			
		 
			signps.setString(3, from);
			signps.setString(2, Hdis);
			signps.setString(1, to);
			signps.setString(4, to_id.getText());
		 	
			
			signps.executeUpdate();
//			
			  JOptionPane.showMessageDialog(null, "add succesfully");
		 
			   
		
	}catch(Exception e1) {
				System.out.println(e1);
				}
			
			
			}
			
		});
		btnNewButton.setBounds(182, 350, 155, 58);
		contentPane.add(btnNewButton);
		
		
	}
}
