import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JFormattedTextField;

public class InsertPatient extends JFrame {

	private JPanel contentPane;
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	private JTextField t4;
	private JTextField t5;
	private JTextField t6;
	private JTextField t7;
	Connection con = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertPatient frame = new InsertPatient();
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
	public InsertPatient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PATIENT ENTRY");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(224, 11, 208, 56);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("FIRST NAME :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 79, 127, 32);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblLastName = new JLabel("LAST NAME :");
		lblLastName.setHorizontalAlignment(SwingConstants.CENTER);
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLastName.setBounds(10, 122, 127, 32);
		contentPane.add(lblLastName);
		
		JLabel lblDob = new JLabel("DOB :");
		lblDob.setHorizontalAlignment(SwingConstants.CENTER);
		lblDob.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDob.setBounds(10, 165, 127, 32);
		contentPane.add(lblDob);
		
		JLabel lblSex = new JLabel("SEX :");
		lblSex.setHorizontalAlignment(SwingConstants.CENTER);
		lblSex.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSex.setBounds(10, 212, 127, 32);
		contentPane.add(lblSex);
		
		JLabel lblPhone = new JLabel("PHONE :");
		lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPhone.setBounds(10, 255, 127, 32);
		contentPane.add(lblPhone);
		
		JLabel lblAddress = new JLabel("ADDRESS :");
		lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddress.setBounds(20, 298, 127, 32);
		contentPane.add(lblAddress);
		
		t1 = new JTextField();
		t1.setBounds(147, 87, 156, 20);
		contentPane.add(t1);
		t1.setColumns(10);
		
		t2 = new JTextField();
		t2.setColumns(10);
		t2.setBounds(147, 130, 156, 20);
		contentPane.add(t2);
		
		t3 = new JTextField();
		t3.setColumns(10);
		t3.setBounds(147, 173, 156, 20);
		contentPane.add(t3);
		
		t4 = new JTextField();
		t4.setColumns(10);
		t4.setBounds(147, 220, 156, 20);
		contentPane.add(t4);
		
		t5 = new JTextField();
		t5.setColumns(10);
		t5.setBounds(147, 263, 156, 20);
		contentPane.add(t5);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(170, 304, 430, 91);
		contentPane.add(textArea);
		
		JLabel lblMedicalHistory = new JLabel("MEDICAL HIST.  :");
		lblMedicalHistory.setHorizontalAlignment(SwingConstants.CENTER);
		lblMedicalHistory.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMedicalHistory.setBounds(341, 79, 141, 32);
		contentPane.add(lblMedicalHistory);
		
		JLabel lblBloodGroup = new JLabel("BLOOD GROUP :");
		lblBloodGroup.setHorizontalAlignment(SwingConstants.CENTER);
		lblBloodGroup.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBloodGroup.setBounds(341, 212, 141, 32);
		contentPane.add(lblBloodGroup);
		
		JLabel lblRoomNo = new JLabel("ROOM NO :");
		lblRoomNo.setHorizontalAlignment(SwingConstants.CENTER);
		lblRoomNo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRoomNo.setBounds(341, 255, 141, 32);
		contentPane.add(lblRoomNo);
		
		t6 = new JTextField();
		t6.setBounds(492, 220, 166, 20);
		contentPane.add(t6);
		t6.setColumns(10);
		
		t7 = new JTextField();
		t7.setBounds(492, 263, 166, 20);
		contentPane.add(t7);
		t7.setColumns(10);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(492, 85, 166, 112);
		contentPane.add(textArea_1);
		
		JButton btnNewButton = new JButton("SAVE");
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(t1.getText().equals("") || t2.getText().equals("") || t3.getText().equals("") || t4.getText().equals("") || t5.getText().equals("") || t6.getText().equals("") || t7.getText().equals("") || textArea.getText().equals("") || textArea_1.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Your data is missing");
				}else {
					try {
						con = sqlConnection.sqlPlusData();
						PreparedStatement stmt = con.prepareStatement("insert into patient(FName ,LName ,DOB ,Sex ,Phone_no ,Address ,Medical_hist , Blood_group, Room_no ) values(? ,? ,? ,? ,? ,? ,? ,? ,?)");
						stmt.setString(1,t1.getText());
						stmt.setString(2,t2.getText());
						stmt.setDate(3, java.sql.Date.valueOf(t3.getText()));
						stmt.setString(4,t4.getText());
						stmt.setInt(5, Integer.parseInt(t5.getText()));
						stmt.setString(6,textArea.getText());
						stmt.setString(7,textArea_1.getText());
						stmt.setString(8,t6.getText());
						stmt.setInt(9,Integer.parseInt(t7.getText()));
					}catch(Exception e) {
						JOptionPane.showMessageDialog(null, "ERROR");
					}
				}
				
				
			}
		});
		btnNewButton.setBounds(297, 406, 135, 32);
		contentPane.add(btnNewButton);
	}
}
