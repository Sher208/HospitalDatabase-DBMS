import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import oracle.jdbc.OracleTypes;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextArea;
import javax.swing.JSplitPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PatientPage extends JFrame {

	private JPanel contentPane;
	public static  int idStore;
	public static  String nameStore;
	Connection connection = null;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientPage frame = new PatientPage(idStore, nameStore);
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
	public PatientPage(int idStore, String nameStore) {
		this.idStore = idStore;
		this.nameStore = nameStore;
		String PatientFName = "";
		String PatientLName = "";
		String PatientSex  = "";
		String ReportId = "";
		String PatientResult = "";
		String PatientBill = "";
		try {
			connection = sqlConnection.sqlPlusData();
			CallableStatement stmt = null;
			stmt = connection.prepareCall("{? = call det.patientdet(?)}");
			stmt.registerOutParameter(1, OracleTypes.CURSOR);
			stmt.setInt(2, idStore);
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
			connection.close();
		}catch(Exception e) {
			System.out.print(e);
		}
		
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(700, 500);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Patient Page");
		lblNewLabel.setBounds(195, 11, 264, 44);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Patient ID :");
		lblNewLabel_1.setFont(new Font("Rockwell", Font.BOLD, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(122, 66, 134, 44);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblName = new JLabel("Name        :");
		lblName.setFont(new Font("Rockwell", Font.BOLD, 15));
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(122, 121, 134, 44);
		contentPane.add(lblName);
		
		JLabel lblSex = new JLabel("Sex            :");
		lblSex.setFont(new Font("Rockwell", Font.BOLD, 15));
		lblSex.setHorizontalAlignment(SwingConstants.CENTER);
		lblSex.setBounds(122, 176, 134, 44);
		contentPane.add(lblSex);
		
		JLabel lblReportId = new JLabel("Report ID :");
		lblReportId.setFont(new Font("Rockwell", Font.BOLD, 15));
		lblReportId.setHorizontalAlignment(SwingConstants.CENTER);
		lblReportId.setBounds(122, 231, 134, 44);
		contentPane.add(lblReportId);
		
		JLabel lblDraftedBy = new JLabel("Status       :");
		lblDraftedBy.setFont(new Font("Rockwell", Font.BOLD, 15));
		lblDraftedBy.setHorizontalAlignment(SwingConstants.CENTER);
		lblDraftedBy.setBounds(122, 287, 134, 44);
		contentPane.add(lblDraftedBy);
		
		JLabel lblTotalAmount = new JLabel("Total Amount :");
		lblTotalAmount.setFont(new Font("Rockwell", Font.BOLD, 15));
		lblTotalAmount.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalAmount.setBounds(110, 342, 134, 44);
		contentPane.add(lblTotalAmount);
		
		JLabel patientId = new JLabel(""+ idStore);
		patientId.setForeground(new Color(124, 252, 0));
		patientId.setHorizontalAlignment(SwingConstants.CENTER);
		patientId.setFont(new Font("Rockwell", Font.PLAIN, 15));
		patientId.setBounds(325, 66, 134, 44);
		contentPane.add(patientId);
		
		JLabel name = new JLabel(PatientFName + "  "+ PatientLName);
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setFont(new Font("Rockwell", Font.PLAIN, 15));
		name.setBounds(325, 121, 134, 44);
		contentPane.add(name);
		
		JLabel sex = new JLabel(PatientSex);
		sex.setHorizontalAlignment(SwingConstants.CENTER);
		sex.setFont(new Font("Rockwell", Font.PLAIN, 15));
		sex.setBounds(325, 176, 134, 44);
		contentPane.add(sex);
		
		JLabel reportId = new JLabel(ReportId);
		reportId.setHorizontalAlignment(SwingConstants.CENTER);
		reportId.setFont(new Font("Rockwell", Font.PLAIN, 15));
		reportId.setBounds(325, 231, 134, 44);
		contentPane.add(reportId);
		
		JLabel draftedBy = new JLabel(PatientResult);
		draftedBy.setHorizontalAlignment(SwingConstants.CENTER);
		draftedBy.setFont(new Font("Rockwell", Font.PLAIN, 15));
		draftedBy.setBounds(325, 287, 134, 44);
		contentPane.add(draftedBy);
		
		JLabel amount = new JLabel(PatientBill);
		amount.setHorizontalAlignment(SwingConstants.CENTER);
		amount.setFont(new Font("Rockwell", Font.PLAIN, 15));
		amount.setBounds(325, 342, 134, 44);
		contentPane.add(amount);
		
		JButton btnNewButton = new JButton("PAY BILL");
		btnNewButton.setToolTipText("Proceed to pay\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 try {
						connection = sqlConnection.sqlPlusData();
						CallableStatement stmt = null;
						stmt = connection.prepareCall("{call det.updateBill(?)}");
						stmt.setInt(1, idStore);
						stmt.execute();
						connection.close();
					}catch(Exception ex) {
						System.out.print(ex);
					}
				 
				JOptionPane opt = new JOptionPane("Processing", JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}); // no buttons
				  final JDialog dlg = opt.createDialog("Error");
				  new Thread(new Runnable()
				        {
				          public void run()
				          {
				            try
				            {
				              Thread.sleep(4000);
				              dlg.dispose();

				            }
				            catch ( Throwable th )
				            {
				              System.out.println("Error");
				            }
				          }
				        }).start();
				  dlg.setVisible(true);
				  PatientPage obj1 = new PatientPage(idStore, nameStore);
				  obj1.setVisible(true);
				  
			}
		});
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.setBounds(286, 397, 134, 44);
		contentPane.add(btnNewButton);
	}
}
