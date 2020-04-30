import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

public class DoctorLogin extends JFrame {

	private JPanel contentPane;
	private JTextField usernameText;
	private JPasswordField passwordText;
	Connection connection = null;
	public String user;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoctorLogin frame = new DoctorLogin();
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
	public DoctorLogin() {
		connection = sqlConnection.sqlPlusData();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(99, 67, 76, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(99, 111, 76, 33);
		contentPane.add(lblNewLabel_1);
		
		usernameText = new JTextField();
		usernameText.setBounds(185, 70, 175, 26);
		contentPane.add(usernameText);
		usernameText.setColumns(10);
		
		passwordText = new JPasswordField();
		passwordText.setBounds(185, 116, 175, 26);
		contentPane.add(passwordText);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int idStore = 0;
					String nameStore = "";
					String query = "select * from doctor where doctor_id = ?";
					PreparedStatement ptr= connection.prepareStatement(query);
					ptr.setString(1, usernameText.getText());
					ResultSet rs = ptr.executeQuery();
					int count = 0;
					while(rs.next()) {
						count++;
						idStore = rs.getInt(1);
						nameStore = rs.getString(2);
					}
					if(count == 1 && passwordText.getText().equals("doc123") ) {
						JOptionPane.showMessageDialog(null, "Access Granted");
						DoctorPage obj = new DoctorPage(idStore, nameStore);
						obj.setVisible(true);
					}else if(count > 1) {
						JOptionPane.showMessageDialog(null, "Multiple Records");
					}else {
						JOptionPane.showMessageDialog(null, "Error Try again !");
					}
				}catch(Exception e1) {
					System.out.println(e1);
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(151, 167, 97, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Doctor Login");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(52, 11, 327, 33);
		contentPane.add(lblNewLabel_2);
	}
}

