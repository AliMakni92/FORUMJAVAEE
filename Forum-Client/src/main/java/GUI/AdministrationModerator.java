package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Entities.Category;
import Entities.ResponsibilityOf;
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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class AdministrationModerator extends JFrame {

	private Category A;
	private JPanel contentPane;
	private JTextField username;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;
	User user;
ArrayList<User>users;
AdministrationModerator administrationModerator;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String u=null;
					AdministrationModerator frame = new AdministrationModerator(u);
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
	public AdministrationModerator(String u) {
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
		
		JLabel lblResponsibleof = new JLabel("ResponsibilityOf");
		
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
		            administrationModerator=new AdministrationModerator(u);
					administrationModerator.setVisible(true);
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
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(ResponsibilityOf.values()));
		
		JButton btnUpdate = new JButton("SaveOrUpdateResponsibility");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id=(AccountManagementServiceDelegate.dofindUserByUsername(table.getModel().getValueAt(table.getSelectedRow(),1).toString())).getId();
				ResponsibilityOf responsibilityOf = (ResponsibilityOf) comboBox.getSelectedItem();
				User user=new User();
				user.setId(id);
				user.setResponsibleOf(responsibilityOf);
				user=AccountManagementServiceDelegate.updateUser1(id, responsibilityOf);
				dispose();
				administrationModerator=new AdministrationModerator(u);
				administrationModerator.setVisible(true);
				
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
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
												.addComponent(lblRole)
												.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
												.addComponent(label, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
												.addComponent(btnSwitchbloque, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(lblResponsibleof, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
											.addGap(9))
										.addComponent(lblId, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
												.addComponent(spinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
												.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
												.addComponent(username, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
												.addComponent(comboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
											.addGap(44))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
											.addGap(101))))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(18)
									.addComponent(btnBack)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnUpdate))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblConnectedAs, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblNewLabel)
							.addGap(26)
							.addComponent(lblAccountManagement, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblConnectedAs)
								.addComponent(lblNewLabel)
								.addComponent(lblAccountManagement))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE))
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
								.addComponent(lblResponsibleof, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnDelete)
								.addComponent(btnSwitchbloque))
							.addGap(7)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnBack)
								.addComponent(btnUpdate))))
					.addContainerGap())
		);
		
		table = new JTable(new TableUserNotAdminModel());
		scrollPane.setColumnHeaderView(table);
		
		contentPane.setLayout(gl_contentPane);
		//frame.getContentPane().add(table_1);
		table.setModel(new TableUserNotAdminandUserModel());
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				//dure.setValue(Integer.parseInt(jTable1.getModel().getValueAt(selectedRowIndex,2).toString()));
				spinner.setValue(table.getValueAt(table.getSelectedRow(), 0));
				username.setText((String)table.getValueAt(table.getSelectedRow(), 1));
				textField_1.setText((String)table.getValueAt(table.getSelectedRow(), 2));
				textField_2.setText((String)table.getValueAt(table.getSelectedRow(), 3));
				//textField_3.setText((String)table.getValueAt(table.getSelectedRow(), 4));
				 comboBox.setSelectedItem(table.getValueAt(table.getSelectedRow(), 4));
			}
		});
	}
}
