package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Entities.User;
import businessDelegate.AccountManagementServiceDelegate;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JSpinner;

public class AdministrationUsers extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;
	User user;
ArrayList<User>users;
AdministrationUsers administration;
AdministrationModerator administrationModerator;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String u=null;
					AdministrationUsers frame = new AdministrationUsers(u);
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
	public AdministrationUsers(String u) {
		setTitle("AccountManagement");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 738, 399);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("Username:");
		
		username = new JTextField();
		username.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JLabel label_1 = new JLabel("Password:");
		
		JLabel lblRole = new JLabel("Role:");
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		JLabel lblResponsibleof = new JLabel("Enabled:");
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  User user = new User();
		           // AccountManagementServiceDelegate accountManagementServiceDelegate =new AccountManagementServiceDelegate();
		            int id=(AccountManagementServiceDelegate.dofindUserByUsername(table.getModel().getValueAt(table.getSelectedRow(),1).toString())).getId();
		            user.setId(id);
		            int a=JOptionPane.showConfirmDialog(null, "are you sure to want to delete this Account?","Delete",JOptionPane.YES_NO_OPTION);
		            //if(a==0) &&(user.) ){
		            	
		            	AccountManagementServiceDelegate.dodeleteUser(user);
		          
		            dispose();
		            JOptionPane.showMessageDialog(null ,"Deleted successfully");
		            administration=new AdministrationUsers(u);
					administration.setVisible(true);
		            //}
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblAccountManagement = new JLabel("Account Management");
		lblAccountManagement.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblAccountManagement.setForeground(Color.RED);
		
		JLabel lblId = new JLabel("Id:");
		
		JLabel lblConnectedAs = new JLabel("Connected As:");
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setText(u);
		JSpinner spinner = new JSpinner();
		
		JButton btnSwitchbloque = new JButton("SwitchBloque");
		btnSwitchbloque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id=(AccountManagementServiceDelegate.dofindUserByUsername(table.getModel().getValueAt(table.getSelectedRow(),1).toString())).getId();
		        String bloque=table.getModel().getValueAt(table.getSelectedRow(),4).toString();  
				AccountManagementServiceDelegate.dofindUserById(id);
				 boolean en=true;
				  if (bloque=="Actif")
				        en=false;
				 AccountManagementServiceDelegate.blocUser(en, id);
				 dispose();
				 administration=new AdministrationUsers(u);
					administration.setVisible(true);
			}
		});
		
		JButton btnNewButton = new JButton("SwitchRole");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id=(AccountManagementServiceDelegate.dofindUserByUsername(table.getModel().getValueAt(table.getSelectedRow(),1).toString())).getId();
		        String role=table.getModel().getValueAt(table.getSelectedRow(),3).toString();  
		        AccountManagementServiceDelegate.dofindUserById(id);
		   	 String x ="user";
		   	 if (role.equals("moderator")){
		   		role="user";
		   	 AccountManagementServiceDelegate.updateUser(id, role);}
		   	 else if (role.equals("user"))
			   		role="moderator";
		   	 AccountManagementServiceDelegate.updateUser(id, role);
		   	 dispose();
		   	administrationModerator=new AdministrationModerator(u);
		   	administrationModerator.setVisible(true);
			}
		});
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				HomeAdmin homeAdmin =new HomeAdmin(u);
				homeAdmin.setVisible(true);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(77)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 352, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addComponent(lblResponsibleof, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
											.addComponent(lblRole)
											.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
											.addComponent(label, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
											.addComponent(btnSwitchbloque))
										.addComponent(lblId, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
												.addComponent(spinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
												.addComponent(textField_3, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
												.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
												.addComponent(username, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE))
											.addGap(44))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
											.addGap(21))))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(66)
									.addComponent(btnNewButton))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(18)
									.addComponent(btnBack))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblConnectedAs, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
							.addGap(29)
							.addComponent(lblNewLabel)
							.addGap(35)
							.addComponent(lblAccountManagement, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(lblConnectedAs)
						.addComponent(lblAccountManagement))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(15, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(64)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblId)
						.addComponent(spinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(username, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1))
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRole)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblResponsibleof, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnDelete)
						.addComponent(btnSwitchbloque))
					.addGap(7)
					.addComponent(btnBack))
		);
		
		table = new JTable(new TableUserNotAdminModel());
		scrollPane.setColumnHeaderView(table);
		
		contentPane.setLayout(gl_contentPane);
		//frame.getContentPane().add(table_1);
		table.setModel(new TableUserNotAdminandModeratorModel());
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				//dure.setValue(Integer.parseInt(jTable1.getModel().getValueAt(selectedRowIndex,2).toString()));
				spinner.setValue(table.getValueAt(table.getSelectedRow(), 0));
				username.setText((String)table.getValueAt(table.getSelectedRow(), 1));
				textField_1.setText((String)table.getValueAt(table.getSelectedRow(), 2));
				textField_2.setText((String)table.getValueAt(table.getSelectedRow(), 3));
				textField_3.setText((String)table.getValueAt(table.getSelectedRow(), 4));
				
			}
		});
	}
}
