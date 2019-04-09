package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Entities.User;

import businessDelegate.AccountManagementServiceDelegate;
import services2.callabkHandler;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.AccessController;
import java.security.Permission;
import java.security.Principal;
import java.security.PrivilegedAction;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;

import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;
import javax.swing.ImageIcon;

public class Authe extends JFrame {
	public enum Action{action1,action2,logout};
	private JPanel contentPane;
	private JTextField username;
	private JPasswordField passwordField;
static Authe authentification;

LoginContext loginContext = null;
boolean flag = false;
HomeAdmin homeAdmin;
ModerationMovies moderationMovies;
ModerationGames moderationGames;
ModerationMusic moderationMusic;
ModerationTV moderationTV;

static public User connected;
User user;
String u;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Authe frame = new Authe();
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
	public Authe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 589, 397);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setForeground(SystemColor.activeCaptionBorder);
		lblUsername.setBounds(24, 90, 83, 14);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setForeground(SystemColor.activeCaptionBorder);
		lblPassword.setBounds(24, 153, 83, 14);
		contentPane.add(lblPassword);
		
		username = new JTextField();
		username.setBounds(358, 90, 86, 20);
		contentPane.add(username);
		username.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(358, 150, 86, 20);
		contentPane.add(passwordField);
		
		JButton btnConnect = new JButton("Connect");
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.setProperty("java.security.auth.login.config", "fichier.config");
				//System.setProperty("java.security.auth.login.config", "jaas.policy");
				LoginContext loginContext=null;
				String u=username.getText();
				User x=new User(u);
				x.setUsername(u);
				x.setPassword(passwordField.getText());
				


				try {
						loginContext = new LoginContext("ZaJaasTutorial04", x);
						loginContext.login();
//						boolean flag = true;
						x=AccountManagementServiceDelegate.doAuthentification(u, passwordField.getText());
						if (x == null){
							JOptionPane.showMessageDialog(null,"login ou mot de passe incorrecte !");
							
						}else{
					
					
						
					
						JOptionPane.showMessageDialog(null, "Username and Password is correct");

					//x = AccountManagementServiceDelegate.dofindUserByUsername(username.getText());
				          
				connected=x;
					dispose();
			homeAdmin= new HomeAdmin(x.getUsername());
			homeAdmin.setVisible(true);
				
						}
//							flag = driver.performAction(loginContext);
					} catch (LoginException ex) {
						System.out.println(ex.getMessage());

						
					}
				
			}
		});
		
		btnConnect.setBounds(344, 248, 147, 23);
		contentPane.add(btnConnect);
		
		JLabel lblWelcomeToFms = new JLabel("Welcome To  FMS");
		lblWelcomeToFms.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblWelcomeToFms.setForeground(Color.MAGENTA);
		lblWelcomeToFms.setBounds(225, 31, 187, 36);
		contentPane.add(lblWelcomeToFms);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			System.exit(0);
			}
		});
		btnCancel.setBounds(44, 248, 124, 23);
		contentPane.add(btnCancel);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Authe.class.getResource("/Picture/certificat-authentification.png")));
		lblNewLabel.setBounds(10, 11, 553, 336);
		contentPane.add(lblNewLabel);
	}
}
