package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class ModerationMusic extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String u=null;
					ModerationMusic frame = new ModerationMusic(u);
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
	public ModerationMusic(String u) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 512, 348);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHelloMusic = new JLabel("Hello Music");
		lblHelloMusic.setIcon(new ImageIcon(ModerationMusic.class.getResource("/Picture/music-colour-splash.jpg")));
		lblHelloMusic.setBounds(10, 36, 476, 266);
		contentPane.add(lblHelloMusic);
		
		JLabel lblNewLabel = new JLabel("Connected As:");
		lblNewLabel.setBounds(27, 11, 90, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(140, 11, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton button = new JButton("Back");
		button.setBounds(226, 7, 89, 23);
		contentPane.add(button);
		
	}

}
