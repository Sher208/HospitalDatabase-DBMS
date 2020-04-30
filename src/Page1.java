import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class Page1 extends JFrame {

	private JPanel contentPane;

	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					Page1 frame = new Page1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Page1() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("Hospital Database");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(102, 11, 223, 32);
		contentPane.add(lblNewLabel);
		
		JButton Doctor = new JButton("Doctor");
		Doctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DoctorLogin obj = new DoctorLogin();
				obj.setVisible(true);
			}
		});
		Doctor.setFont(new Font("Rockwell", Font.PLAIN, 13));
		Doctor.setBounds(234, 71, 112, 66);
		contentPane.add(Doctor);
		
		JButton Admin = new JButton("Admin");
		Admin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminLogin obj = new AdminLogin();
				obj.setVisible(true);
			}
		});
		Admin.setFont(new Font("Rockwell", Font.PLAIN, 13));
		Admin.setBounds(81, 71, 112, 66);
		contentPane.add(Admin);
		
		JButton Nurse = new JButton("Nurse");
		Nurse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NurseLogin obj = new NurseLogin();
				obj.setVisible(true);
			}
		});
		Nurse.setFont(new Font("Rockwell", Font.PLAIN, 13));
		Nurse.setBounds(81, 158, 112, 71);
		contentPane.add(Nurse);
		
		JButton Patient = new JButton("Patient");
		Patient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PatientLogin obj = new PatientLogin();
				obj.setVisible(true);
			}
		});
		Patient.setFont(new Font("Rockwell", Font.PLAIN, 13));
		Patient.setBounds(234, 158, 112, 71);
		contentPane.add(Patient);
	}
}
