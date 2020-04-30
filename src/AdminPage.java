import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

 public class AdminPage extends JFrame {

	private JPanel contentPane;
	private JTable table;
	public static String user;
	
	Connection Connection = null;
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPage frame = new AdminPage(user);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public AdminPage(String user) {
		this.user = user;
		Connection = sqlConnection.sqlPlusData();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700, 500);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Admin Page");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(206, 11, 239, 41);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Admin Name : " + this.user);
		lblNewLabel_1.setForeground(new Color(50, 205, 50));
		lblNewLabel_1.setFont(new Font("Rockwell", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(37, 55, 324, 33);
		contentPane.add(lblNewLabel_1);
		
		JButton Doctors = new JButton("Doctors");
		Doctors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query = "select * from student";
					Statement stmt = Connection.createStatement();
					ResultSet rs = stmt.executeQuery(query);
					table.setModel(DbUtils.resultSetToTableModel(rs));
					Connection.close();
				}catch(Exception e) {
					System.out.println(e);
				}
						
			}
		});
		Doctors.setBounds(56, 131, 103, 41);
		contentPane.add(Doctors);
		
		JButton Nurses = new JButton("Nurses");
		Nurses.setBounds(224, 131, 110, 41);
		contentPane.add(Nurses);
		
		JButton Patients = new JButton("Patients");
		Patients.setBounds(381, 131, 103, 41);
		contentPane.add(Patients);
		
		JButton Records = new JButton("Records");
		Records.setFont(new Font("Tahoma", Font.PLAIN, 13));
		Records.setBounds(535, 131, 103, 41);
		contentPane.add(Records);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 195, 664, 255);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		
	}
}
