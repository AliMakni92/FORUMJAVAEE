package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Entities.User;
import businessDelegate.AccountManagementServiceDelegate;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManageProfil extends JFrame {

	private JPanel contentPane;
	private JTextField usernamelb;
	private JTextField passwordlb;
	private JTextField emaillb;
	User user;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String u=null;
					ManageProfil frame = new ManageProfil(u);
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
	public ManageProfil(String u) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("UserName");
		lblUsername.setBounds(34, 59, 67, 14);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(33, 97, 68, 14);
		contentPane.add(lblPassword);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(38, 135, 46, 14);
		contentPane.add(lblEmail);
		
		usernamelb = new JTextField();
		usernamelb.setBounds(138, 56, 86, 20);
		contentPane.add(usernamelb);
		usernamelb.setColumns(10);
		
		passwordlb = new JTextField();
		passwordlb.setBounds(138, 94, 86, 20);
		contentPane.add(passwordlb);
		passwordlb.setColumns(10);
		
		emaillb = new JTextField();
		emaillb.setBounds(138, 132, 86, 20);
		contentPane.add(emaillb);
		emaillb.setColumns(10);
		
		JButton btnUpdate = new JButton("Update ");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
							
					user=AccountManagementServiceDelegate.dofindUserByUsername(u);
				String x=usernamelb.getText();
				String y=passwordlb.getText();
				String z=emaillb.getText();
				user=new User(x, y, z);
				AccountManagementServiceDelegate.doUpdateUser(user);
				dispose();
				new ModerationMovies(x).setVisible(true);
				
				
			}
		});
		btnUpdate.setBounds(119, 200, 89, 23);
		contentPane.add(btnUpdate);
		
		JLabel lblConnectedAs = new JLabel("Connected As:");
		lblConnectedAs.setBounds(10, 11, 86, 14);
		contentPane.add(lblConnectedAs);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(101, 11, 107, 14);
		contentPane.add(lblNewLabel);
		lblNewLabel.setText(u);
	}
}
