package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class ModerationMovies extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String u=null;
					ModerationMovies frame = new ModerationMovies(u);
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
	public ModerationMovies(String u) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 544, 356);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Connected As:");
		lblNewLabel.setBounds(57, 11, 89, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(156, 11, 83, 14);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setText(u);
		
		JButton btnManageProfile = new JButton("Manage Profil");
		btnManageProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ManageProfil manageProfil=new ManageProfil(u);
				manageProfil.setVisible(true);
			}
		});
		btnManageProfile.setBounds(186, 101, 163, 23);
		contentPane.add(btnManageProfile);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Authentification authentification=new Authentification(); 
				authentification.setVisible(true);
			}
		});
		btnNewButton.setBounds(57, 215, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(ModerationMovies.class.getResource("/Picture/cover.jpg")));
		lblNewLabel_2.setBounds(10, 24, 518, 293);
		contentPane.add(lblNewLabel_2);
		
	}
}
