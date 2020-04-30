import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import oracle.jdbc.OracleTypes;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class DoctorPage extends JFrame {

	private JPanel contentPane;
	private JTextField searchPatientType;
	private JTextField searchRecordType;
	public static  int idStore;
	public static  String nameStore;
	Connection connection = null;
	String PatientFName = "";
	String PatientLName = "";
	String PatientSex  = "";
	String ReportId = "";
	String PatientResult = "";
	String PatientBill = "";
	String PatientTreated= "";
	String PatientStatus= "";
	int PatientReportId ;
	int PatientNurseId ;
	JTextArea displayInfo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoctorPage frame = new DoctorPage(idStore, nameStore);
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
	public DoctorPage(int idStore, String nameStore) {
		this.idStore = idStore;
		this.nameStore = nameStore;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(700, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Doctor Page");
		lblNewLabel.setBounds(195, 11, 264, 44);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		JLabel docId = new JLabel("ID : " + idStore);
		docId.setBounds(10, 66, 96, 44);
		docId.setForeground(new Color(50, 205, 50));
		docId.setFont(new Font("Rockwell", Font.ITALIC, 15));
		contentPane.add(docId);
		
		JLabel docName = new JLabel(" Name : "+ nameStore);
		docName.setBounds(226, 66, 233, 44);
		docName.setForeground(new Color(50, 205, 50));
		docName.setFont(new Font("Rockwell", Font.ITALIC, 15));
		contentPane.add(docName);
		
		JLabel docSp = new JLabel("Specialization :");
		docSp.setBounds(476, 66, 198, 44);
		docSp.setForeground(new Color(50, 205, 50));
		docSp.setFont(new Font("Rockwell", Font.ITALIC, 15));
		contentPane.add(docSp);
		
		JLabel lblNewLabel_1 = new JLabel("Search Patient :");
		lblNewLabel_1.setBounds(20, 128, 122, 36);
		contentPane.add(lblNewLabel_1);
		
		searchPatientType = new JTextField();
		searchPatientType.setBounds(152, 136, 163, 20);
		contentPane.add(searchPatientType);
		searchPatientType.setColumns(10);
		
		JButton searchPatient = new JButton(" Search Patient");
		searchPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(searchPatientType.getText());
				
				try {
					connection = sqlConnection.sqlPlusData();
					CallableStatement stmt = null;
					stmt = connection.prepareCall("{? = call det.patientdet(?)}");
					stmt.registerOutParameter(1, OracleTypes.CURSOR);
					stmt.setInt(2, id);
					stmt.execute();
					 ResultSet rs = (ResultSet)stmt.getObject(1); 
					
					while (rs.next()) {
						 PatientFName = rs.getString(2);
						 PatientLName = rs.getString(3);
						 PatientSex = rs.getString(4);
						 ReportId = rs.getString(5);
						 PatientResult = rs.getString(6);
						 PatientBill = rs.getString(7);
					}	
					displayInfo.setText("FIRST NAME : " + PatientFName +"\n\nSECOND NAME : "+ PatientLName+
							"\n\nSEX : " + PatientSex +"\n\nReportID : "+ ReportId+
							"\n\nSTATUS : " + PatientResult);
					connection.close();
				}catch(Exception ex) {
					System.out.print(ex);
				}
				
			}
		});
		searchPatient.setBounds(152, 167, 163, 23);
		contentPane.add(searchPatient);
		
		displayInfo = new JTextArea();
		displayInfo.setFont(new Font("Rockwell", Font.PLAIN, 16));
		displayInfo.setBounds(340, 134, 334, 316);
		contentPane.add(displayInfo);
		
		JLabel lblNewLabel_3 = new JLabel("Search Record :");
		lblNewLabel_3.setBounds(20, 233, 122, 36);
		contentPane.add(lblNewLabel_3);
		
		searchRecordType = new JTextField();
		searchRecordType.setBounds(152, 241, 163, 20);
		contentPane.add(searchRecordType);
		searchRecordType.setColumns(10);
		
		JButton searchRecord = new JButton("Search Record");
		searchRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(searchRecordType.getText());
				
				try {
					connection = sqlConnection.sqlPlusData();
					CallableStatement stmt = null;
					stmt = connection.prepareCall("{? = call det.reportid(?)}");
					stmt.registerOutParameter(1, OracleTypes.CURSOR);
					stmt.setInt(2, id);
					stmt.execute();
					 ResultSet rs = (ResultSet)stmt.getObject(1); 
					
					while (rs.next()) {
						 PatientFName = rs.getString(1);
						 PatientLName = rs.getString(2);
						 PatientTreated = rs.getString(4);
						 PatientNurseId = rs.getInt(5);
					}	
					displayInfo.setText("NAME : " + PatientFName +" "+ PatientLName+
							"\n\nTREATEMENT : " + PatientTreated +
							"\n\nNURSE ID : " + PatientNurseId );
					connection.close();
				}catch(Exception ex) {
					System.out.print(ex);
				}
			}
		});
		searchRecord.setBounds(152, 279, 163, 23);
		contentPane.add(searchRecord);
		
		JButton treated = new JButton("TREATED");
		treated.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					connection = sqlConnection.sqlPlusData();
					CallableStatement stmt = null;
					stmt = connection.prepareCall("{? = call det.treated(?)}");
					stmt.registerOutParameter(1, OracleTypes.CURSOR);
					stmt.setInt(2, idStore);
					stmt.execute();
					 ResultSet rs = (ResultSet)stmt.getObject(1); 
					
					while (rs.next()) {
						 PatientReportId = rs.getInt(1);
						 PatientTreated = rs.getString(2);
						 PatientResult = rs.getString(3);
					}	
					displayInfo.setText(
							"REPORT ID : " + PatientReportId +
							"\n\nTREATEMENT : " + PatientTreated +
							"\n\nRESULT : " + PatientResult );
					connection.close();
				}catch(Exception ex) {
					System.out.print(ex);
				}
			}
		});
		treated.setBounds(152, 393, 166, 30);
		treated.setBackground(new Color(0, 102, 255));
		contentPane.add(treated);
	}
}
