//
//package algo;
//
//import java.awt.BorderLayout;
//import java.awt.EventQueue;
//
//import javax.swing.JFrame;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;
//import javax.swing.JTextArea;
//import javax.swing.JButton;
//import java.awt.event.ActionListener;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.util.Vector;
//import java.awt.event.ActionEvent;
//import java.awt.Color;
//import javax.swing.JTable;
//import javax.swing.table.DefaultTableModel;
//
//import com.mysql.jdbc.ResultSetMetaData;
//
//import javax.swing.JScrollPane;
//import javax.swing.JTextField;
//import javax.swing.JLabel;
//import javax.swing.JComboBox;
//import javax.swing.DefaultComboBoxModel;
//
//public class DijkstraMain extends JFrame {
//	private JTable table_1;
//	private JTextField get_id;
//	private JTextField get_distance;
//	private JTextField get_hdid;
//
//	 
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					DijkstraMain frame = new DijkstraMain();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
// 
//	 
//	  public DijkstraMain() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 792, 593);
//		getContentPane().setLayout(null);
//		
//		JPanel panel = new JPanel();
//		panel.setBackground(Color.ORANGE);
//		panel.setBounds(0, 10, 768, 536);
//		getContentPane().add(panel);
//		panel.setLayout(null);
//		
//		JScrollPane scrollPane = new JScrollPane();
//		scrollPane.setBounds(336, 5, 428, 429);
//		panel.add(scrollPane);
//		
//		table_1 = new JTable();
//		scrollPane.setViewportView(table_1);
//		table_1.setModel(new DefaultTableModel(
//			new Object[][] {
//			},
//			new String[] {
//				"id", "Hospital_name", "distance", "to_hp", "hd_id"
//			}
//		));
//		JComboBox comboBox = new JComboBox();
//		comboBox.setModel(new DefaultComboBoxModel(new String[] {"vertexA", "vertexB", "vertexC", "vertexD", "vertexE", "vertexF"}));
//		comboBox.setBounds(149, 98, 144, 38);
//		panel.add(comboBox);
//		
//		JComboBox comboBox_1 = new JComboBox();
//		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"vertexA", "vertexB", "vertexC", "vertexD", "vertexE", "vertexF"}));
//		comboBox_1.setBounds(149, 220, 144, 41);
//		panel.add(comboBox_1);
//		
//		get_id = new JTextField();
//		get_id.setBounds(161, 50, 132, 38);
//		panel.add(get_id);
//		get_id.setColumns(10);
//		
//		get_distance = new JTextField();
//		get_distance.setBounds(161, 146, 132, 38);
//		panel.add(get_distance);
//		get_distance.setColumns(10);
//		
//		get_hdid = new JTextField();
//		get_hdid.setBounds(161, 270, 132, 38);
//		panel.add(get_hdid);
//		get_hdid.setColumns(10);
//		
//		JButton btn = new JButton("addItem");
//		btn.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				try
//				{	Vertex vertexA = new Vertex();
//				Vertex vertexB = new Vertex();
//				Vertex vertexC = new Vertex();
//				Vertex vertexD = new Vertex();
//				Vertex vertexE = new Vertex();
//				Vertex vertexF = new Vertex();
//				
//				vertexA.addNeighbour(new Edge(10,vertexA,vertexC));//
//				vertexA.addNeighbour(new Edge(17,vertexA,vertexB));//
//				vertexB.addNeighbour(new Edge(5,vertexB,vertexC));//
//			 
//				vertexC.addNeighbour(new Edge(9,vertexC,vertexD));//
//				vertexC.addNeighbour(new Edge(11,vertexC,vertexE));//
//				vertexB.addNeighbour(new Edge(1,vertexB,vertexD));//
//				vertexD.addNeighbour(new Edge(6,vertexD,vertexE));
//				vertexD.addNeighbour(new Edge(8,vertexD,vertexF));
//				//	vertexB.addNeighbour(new Edge(5,vertexB,vertexC));
////				vertexC.addNeighbour(new Edge(10,vertexC,vertexA));
////				vertexB.addNeighbour(new Edge(17,vertexB,vertexA));
////				vertexD.addNeighbour(new Edge(9,vertexD,vertexC));
////				vertexE.addNeighbour(new Edge(11,vertexE,vertexC));
////				vertexD.addNeighbour(new Edge(1,vertexD,vertexB));
////				vertexE.addNeighbour(new Edge(6,vertexE,vertexD));
////				vertexF.addNeighbour(new Edge(8,vertexF,vertexD));
//				
//				DijkstraShortestPath shortestPath = new DijkstraShortestPath();
//				
//			//	try {
//			 
//					 String from =  (String) comboBox.getSelectedItem();
//					 String to =  (String) comboBox_1.getSelectedItem();
//					 
//				
//					 
//					 
//					 
//					 
//					 
//					 
//					 
////					 if(from.equals("vertexA"));
////					 
////			        	{ shortestPath.computeShortestPaths(vertexA);}
////			       	 
////			        	
////			        		if(from.equals("vertexB"));
////				        	{ shortestPath.computeShortestPaths(vertexB);} 
//				     
//				         
//////				       	 
//							 if(from.equals("vertexC"));
//					        	{ shortestPath.computeShortestPaths(vertexC);}
////					        	
////					        	if(from.equals("vertexD"));
////						        	{ shortestPath.computeShortestPaths(vertexD);}
////						        	 if(from.equals("vertexE"));
////							        	{ shortestPath.computeShortestPaths(vertexE);}
////							        	 if(from.equals("vertexF"));
////								        	{ shortestPath.computeShortestPaths(vertexF);}
//
////								        	else {
////								        		shortestPath.computeShortestPaths(vertexF);
////								        	}
//
//
//		    		
//						if	( to.equals("vertexA" ))
//					{   get_distance.setText("   "+ vertexA.getDistance());}
//			        	
//						if	( to.equals("vertexB" ))
//		    		{   get_distance.setText("   "+ vertexB.getDistance());}
//		    			
//		    			if	( to.equals("vertexC" ))
//			    		{   get_distance.setText("   "+ vertexC.getDistance());}
//		    			
//
//		    			if	( to.equals("vertexD" ))
//			    		{   get_distance.setText("   "+ vertexD.getDistance());}
//
//		    			if	( to.equals("vertexE" ))
//			    		{   get_distance.setText("   "+ vertexE.getDistance());}
//
//		    			if	( to.equals("vertexF" ))
//			    		{   get_distance.setText("   "+ vertexF.getDistance());}
//			    			 
//			    		 
//		    			
//		    			
//		    			
//		    			
//		    			
//		    			
//		    			
//		    			
//		    			
//		    			
//		    			
//		    			
//		    			
//		    			
//		    			String  Hdis =  get_distance .getText();
//					 Class.forName( "com.mysql.jdbc.Driver");
//						Connection signconn = DriverManager.getConnection("jdbc:mysql://localhost:3307/nikhil","root","");
//						PreparedStatement signps = signconn.prepareStatement("insert into  hospital_dis(id,Hospital_name,distance,to_hp,hd_id) values(?,?,?,?,?);");
//						
//						signps.setString(1,get_id.getText());
//						signps.setString(2, from);
//						signps.setString(3, Hdis);
//						signps.setString(4, to);
//						signps.setString(5, get_hdid.getText());
//						
//						
//						signps.executeUpdate();
////						
//						  JOptionPane.showMessageDialog(null, "add succesfully");
//						  
//						 // get_id.setText("");
//						//  get_distance.setText("");
//			//			  get_dis.setText("");
//						  
//						  
//						  int a ;
//							PreparedStatement signps1 = signconn.prepareStatement("select * from  hospital_dis");//get data from darabase
//		
//							ResultSet rs = signps1.executeQuery();  //
//						    ResultSetMetaData rd=(ResultSetMetaData) rs.getMetaData(); //
//						    
//						    a= rd.getColumnCount(); // get no column from db
//						    DefaultTableModel df =(DefaultTableModel)table_1.getModel();
//	                        df.setRowCount(0);
//	                        while(rs.next())
//	                        {
//	                        	Vector v2 = new Vector();
//	                        	for (int i=1;i<=a;i++)
//	                        	{
//	                        	 
//	                        		v2.add(rs.getString("id"));
//	                        		v2.add(rs.getString("Hospital_name"));
//	                        		v2.add(rs.getString("distance"));
//	                        		v2.add(rs.getString("to_hp"));
//	                        		v2.add(rs.getString("hd_id"));
//	                        		
//	                        	}
//	                        	df.addRow(v2);}
//					
//				}catch(Exception e1) {
//							System.out.println(e1);
//							}
//	
//			
//			}
//		});
//		btn.setBounds(167, 337, 126, 47);
//		panel.add(btn);
//		
// 
// 
//	}
//}
//
//
//
//
