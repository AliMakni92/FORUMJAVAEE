package GUI;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;
import javax.transaction.Transactional.TxType;

import Entities.User;
import businessDelegate.AccountManagementServiceDelegate;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddUser extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Create the panel.
	 */
	public AddUser() {
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "AddUser", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(19)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 294, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(137, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(20, Short.MAX_VALUE))
		);
		panel.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(20, 79, 69, 14);
		panel.add(lblUsername);
		
		JLabel lblPasswoprd = new JLabel("Password:");
		lblPasswoprd.setBounds(20, 121, 69, 14);
		panel.add(lblPasswoprd);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(23, 146, 46, 14);
		panel.add(lblEmail);
		
		JLabel lblRole = new JLabel("Role:");
		lblRole.setBounds(20, 171, 49, 20);
		panel.add(lblRole);
		
		JButton btnAddUser = new JButton("Add User");
		btnAddUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			User user =new User();
			user.setUsername(textField.getText());
			user.setPassword(textField_1.getText());
			user.setEmail(textField_2.getText());
			user.setRole(textField_3.getText());
			if(AccountManagementServiceDelegate.doAddUser(user)){
				System.out.println("haha");
				JOptionPane.showMessageDialog(null, "ok");
				textField.setText("ahahah");
				textField_1.setText("ahahah");
				textField_2.setText("hhh");
				textField_3.setText("ggarr");
			}else{
				
			}
			}
		});
		btnAddUser.setBounds(99, 235, 89, 23);
		panel.add(btnAddUser);
		
		textField = new JTextField();
		textField.setBounds(102, 76, 86, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(99, 115, 86, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(102, 143, 86, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(102, 171, 86, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(102, 202, 86, 20);
		panel.add(textField_4);
		
		JLabel lblEnabled = new JLabel("Enabled:");
		lblEnabled.setBounds(20, 202, 49, 20);
		panel.add(lblEnabled);
		setLayout(groupLayout);

	}
}
