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
import javax.swing.SwingConstants;

public class Administration extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;
	User user;
ArrayList<User>users;
Administration administration;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String u=null;
					Administration frame = new Administration(u);
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
	public Administration(String u) {
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
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		JLabel lblResponsibleof = new JLabel("ResponsibleOf");
		
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
		            administration=new Administration(u);
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
		        String bloque=table.getModel().getValueAt(table.getSelectedRow(),5).toString();  
				AccountManagementServiceDelegate.dofindUserById(id);
				 boolean en=true;
				  if (bloque=="Actif")
				        en=false;
				 AccountManagementServiceDelegate.blocUser(en, id);
				 dispose();
				 administration=new Administration(u);
					administration.setVisible(true);
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
		
		JButton btnAccountManagementFor = new JButton("Account Management For Moderator");
		btnAccountManagementFor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AdministrationModerator administrationModerator=new AdministrationModerator(u);
				administrationModerator.setVisible(true);
			}
		});
		
		JButton btnAccountManagementFor_1 = new JButton("Account Management For Users");
		btnAccountManagementFor_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AdministrationUsers administrationUsers=new AdministrationUsers(u);
				administrationUsers.setVisible(true);
			}
		});
		
		JLabel label_2 = new JLabel("Password:");
		
		JLabel label_3 = new JLabel("Role:");
		
		JLabel label_4 = new JLabel("Enabled:");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(29)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 352, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(40)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(label, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(lblId, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
												.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
													.addComponent(label_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
													.addComponent(label_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)))
											.addGap(42)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(username, 111, 111, 111)
												.addComponent(textField_1, 111, 111, 111)
												.addComponent(textField_2, 111, 111, 111)
												.addComponent(textField_3, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
												.addComponent(spinner, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(btnBack)
											.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(btnSwitchbloque)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(btnDelete)))
									.addGap(179)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblResponsibleof, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
										.addComponent(label_1, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
									.addGap(103))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(52)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(btnAccountManagementFor, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnAccountManagementFor_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblConnectedAs, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblAccountManagement, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAccountManagement)
						.addComponent(lblConnectedAs)
						.addComponent(lblNewLabel)
						.addComponent(btnAccountManagementFor))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnAccountManagementFor_1)
					.addGap(4)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(76)
									.addComponent(label_1)
									.addGap(67)
									.addComponent(lblResponsibleof, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
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
										.addComponent(label_2))
									.addGap(26)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(label_3))
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
									.addGap(33)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
												.addComponent(btnBack)
												.addComponent(btnSwitchbloque))
											.addGap(34))
										.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))))
							.addGap(25))))
		);
		
		table = new JTable(new TableUserNotAdminModel());
		scrollPane.setColumnHeaderView(table);
		
		contentPane.setLayout(gl_contentPane);
		//frame.getContentPane().add(table_1);
		table.setModel(new TableUserNotAdminModel());
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				//dure.setValue(Integer.parseInt(jTable1.getModel().getValueAt(selectedRowIndex,2).toString()));
				spinner.setValue(table.getValueAt(table.getSelectedRow(), 0));
				username.setText((String)table.getValueAt(table.getSelectedRow(), 1));
				textField_1.setText((String)table.getValueAt(table.getSelectedRow(), 2));
				textField_2.setText((String)table.getValueAt(table.getSelectedRow(), 3));
				textField_3.setText((String)table.getValueAt(table.getSelectedRow(), 5));
				
			}
		});
	}
}
