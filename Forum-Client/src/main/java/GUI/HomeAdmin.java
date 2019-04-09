package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Entities.User;
import SecurityForum.FMSLoginModule;
import services2.callabkHandler;
import services2.driver2.Action;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;
import javax.swing.ImageIcon;

public class HomeAdmin extends JFrame {
	FMSLoginModule forumLoginModule;
	private JPanel contentPane;
	Authentification authentification;
	public enum Action {
		action1, action2, logout
	};
	User user;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String u=null;
					HomeAdmin frame = new HomeAdmin(u);
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
	public HomeAdmin(String u) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 616, 353);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAdministration = new JButton("Administration");
		btnAdministration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 dispose();
			new Administration(u).setVisible(true);
			
			}
		});
		btnAdministration.setBounds(177, 73, 146, 23);
		contentPane.add(btnAdministration);
		
		JLabel lblConnectedAs = new JLabel("Connected As:");
		lblConnectedAs.setBounds(26, 11, 85, 14);
		contentPane.add(lblConnectedAs);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(117, 11, 46, 14);
		contentPane.add(lblNewLabel);
		lblNewLabel.setText(u);
		
		JButton btnMessages = new JButton("Messages");
		btnMessages.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
//			ListMessage listMessage= new ListMessage(u);
//			listMessage.setVisible(true);
			}
		});
		btnMessages.setBounds(177, 127, 146, 23);
		contentPane.add(btnMessages);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				 //User user=new User(u);
				System.exit(0);
						}
				
			
			
		});
		btnLogout.setBounds(185, 174, 89, 23);
		contentPane.add(btnLogout);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(HomeAdmin.class.getResource("/Picture/Role-of-Administration-in-Management.png")));
		lblNewLabel_1.setBounds(10, 24, 580, 290);
		contentPane.add(lblNewLabel_1);
	}
}
