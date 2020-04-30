import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NursePage extends JFrame {

	private JPanel contentPane;
	private JTextField searchPatientType;
	private JTextField searchRecordType;
	public static  int idStore;
	public static  String nameStore;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NursePage frame = new NursePage(idStore, nameStore);
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
	public NursePage(int idStore, String nameStore) {
		this.idStore = idStore;
		this.nameStore = nameStore;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(700, 500);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nurse Page");
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
		docName.setBounds(418, 66, 233, 44);
		docName.setForeground(new Color(50, 205, 50));
		docName.setFont(new Font("Rockwell", Font.ITALIC, 15));
		contentPane.add(docName);
		
		JLabel lblNewLabel_1 = new JLabel("Search Patient :");
		lblNewLabel_1.setBounds(20, 128, 96, 36);
		contentPane.add(lblNewLabel_1);
		
		searchPatientType = new JTextField();
		searchPatientType.setBounds(126, 136, 163, 20);
		contentPane.add(searchPatientType);
		searchPatientType.setColumns(10);
		
		JButton searchPatient = new JButton(" Search Patient");
		searchPatient.setBounds(126, 167, 163, 23);
		contentPane.add(searchPatient);
		
		JTextArea displayInfo = new JTextArea();
		displayInfo.setBounds(340, 134, 334, 316);
		contentPane.add(displayInfo);
		
		JLabel lblNewLabel_3 = new JLabel("Search Record :");
		lblNewLabel_3.setBounds(20, 215, 86, 36);
		contentPane.add(lblNewLabel_3);
		
		searchRecordType = new JTextField();
		searchRecordType.setBounds(126, 223, 163, 20);
		contentPane.add(searchRecordType);
		searchRecordType.setColumns(10);
		
		JButton searchRecord = new JButton("Search Record");
		searchRecord.setBounds(126, 254, 163, 23);
		contentPane.add(searchRecord);
		
		JButton treated = new JButton("ROOM");
		treated.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		treated.setBounds(142, 303, 130, 30);
		treated.setBackground(new Color(0, 102, 255));
		contentPane.add(treated);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(142, 344, 130, 30);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("INSERT PATIENT");
		btnNewButton_1.setBackground(Color.GREEN);
		btnNewButton_1.setBounds(142, 387, 130, 30);
		contentPane.add(btnNewButton_1);
	}
}
