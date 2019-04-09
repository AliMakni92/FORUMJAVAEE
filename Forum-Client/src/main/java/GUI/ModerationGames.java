package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class ModerationGames extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String u=null;
					ModerationGames frame = new ModerationGames(u);
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
	public ModerationGames(String u) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 507, 349);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGg = new JLabel("Hello Games");
		lblGg.setIcon(new ImageIcon(ModerationGames.class.getResource("/Picture/Tv-Shows.png")));
		lblGg.setBounds(0, 25, 491, 285);
		contentPane.add(lblGg);
		
		JLabel lblNewLabel = new JLabel("Connected As:");
		lblNewLabel.setBounds(24, 11, 93, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(127, 11, 75, 14);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setText(u);
		
		JButton button = new JButton("Back");
		button.setBounds(49, 188, 89, 23);
		contentPane.add(button);
	}

}
