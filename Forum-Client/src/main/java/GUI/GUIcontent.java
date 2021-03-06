package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Entities.Category;
import Entities.Content;
import Entities.Genre;
import businessDelegate.ContentServicesDelegate;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.SpinnerNumberModel;
import java.awt.Font;

public class GUIcontent extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;
	JComboBox comboBox = new JComboBox();
	JComboBox comboBox_1 = new JComboBox();
	JSpinner spinner = new JSpinner();
	JSpinner spinner_1 = new JSpinner();
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIcontent frame = new GUIcontent();
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
	public GUIcontent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 771, 427);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(68, 50, 612, 160);
		contentPane.add(scrollPane);
		
		table = new JTable(new TblContentModel());
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedRowIndex=table.getSelectedRow();
				
				
				//String title=table.getModel().getValueAt(table.getSelectedRow(),0).toString();
				//List q=ContentServicesDelegate.findContentByTitle(title);
				//Content c=(Content) q.get(0);
				
				
				textField.setText(table.getModel().getValueAt(selectedRowIndex, 0).toString());
				textField_1.setText(table.getModel().getValueAt(selectedRowIndex, 3).toString());
				textField_2.setText(table.getModel().getValueAt(selectedRowIndex, 2).toString());
				
				String genre = table.getModel().getValueAt(selectedRowIndex, 1).toString();
				comboBox.setSelectedIndex(Genre.valueOf(genre).ordinal());
				
				String category=table.getModel().getValueAt(selectedRowIndex, 6).toString();
				comboBox_1.setSelectedIndex(Category.valueOf(category).ordinal());
			
				spinner.setValue(Integer.parseInt(table.getModel().getValueAt(selectedRowIndex, 4).toString()));
				
				Double sp= (Double) table.getModel().getValueAt(selectedRowIndex, 5);
				spinner_1.setValue(sp);
		
			}
		});
		scrollPane.setViewportView(table);
		table.setShowVerticalLines(true);
		table.setShowHorizontalLines(true);
		table.setFillsViewportHeight(true);
		table.setAutoCreateRowSorter(true);
		
		
		
		
		JLabel label = new JLabel("Title");
		label.setFont(new Font("Tahoma", Font.BOLD, 13));
		label.setBounds(57, 240, 46, 14);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new ADDcontentJframe().setVisible(true);
			}
		});
		textField.setColumns(10);
		textField.setBounds(117, 238, 86, 20);
		contentPane.add(textField);
		
		JLabel label_1 = new JLabel("Genre");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_1.setBounds(57, 268, 46, 14);
		contentPane.add(label_1);
		comboBox.setModel(new DefaultComboBoxModel(Genre.values()));
		
		
		comboBox.setBounds(117, 265, 86, 20);
		contentPane.add(comboBox);
		
		JLabel label_2 = new JLabel("Trailer");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_2.setBounds(57, 296, 46, 14);
		contentPane.add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(117, 293, 164, 20);
		contentPane.add(textField_1);
		
		JLabel label_3 = new JLabel("Description");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_3.setBounds(57, 324, 76, 14);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("Rating");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_4.setBounds(291, 234, 46, 14);
		contentPane.add(label_4);
		comboBox_1.setModel(new DefaultComboBoxModel(Category.values()));
		
		
		comboBox_1.setBounds(369, 266, 98, 20);
		contentPane.add(comboBox_1);
		
		JLabel label_5 = new JLabel("Category");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_5.setBounds(291, 268, 68, 14);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("Release Year");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_6.setBounds(291, 302, 86, 14);
		contentPane.add(label_6);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(143, 324, 154, 52);
		contentPane.add(textField_2);
		spinner.setModel(new SpinnerNumberModel(2017, null, 2017, 1));
		
		
		spinner.setBounds(378, 300, 69, 20);
		contentPane.add(spinner);
		spinner_1.setModel(new SpinnerNumberModel(0.0, 0.0, 10.0, 1.0));
		
		
		spinner_1.setBounds(388, 238, 59, 20);
		contentPane.add(spinner_1);
		
		JButton button = new JButton("ADD");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new ADDcontentJframe().setVisible(true);
				
			}
		});
		button.setBounds(525, 227, 110, 42);
		contentPane.add(button);
		
		JButton button_1 = new JButton("DELETE");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String title=table.getModel().getValueAt(table.getSelectedRow(),0).toString();
				List q=ContentServicesDelegate.findContentByTitle(title);
				Content c=(Content) q.get(0);
				
				int a=JOptionPane.showConfirmDialog(null, "are you sure to want to delete this Content","Delete",JOptionPane.YES_NO_OPTION);
				ContentServicesDelegate.deleteContent(c);
				
				 dispose();
				  new GUIcontent().setVisible(true);
				  JOptionPane.showMessageDialog(null ,"Deleted successfully");
			}
		});
		button_1.setBounds(525, 283, 110, 42);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("UPDATE");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String title=table.getModel().getValueAt(table.getSelectedRow(),0).toString();
				List q=ContentServicesDelegate.findContentByTitle(title);
				Content c=(Content) q.get(0);
				
				int idc=c.getId();
				
				
				
				String tit = textField.getText();
				Genre genre = (Genre) comboBox.getSelectedItem();
				//content.setGenre(genre);
				String description=textField_1.getText();
				String trailer= textField_2.getText();
				int   yearReleased=(int) spinner.getValue();
			
				Double rating =2.0;
				//  Double rating= (Double) spinner.getValue();
			  Category category = (Category) comboBox_1.getSelectedItem();
			  
			  

				
			  Content content = new Content(idc,tit,genre,description,trailer,yearReleased,rating,category);
			  ContentServicesDelegate.updateContent(content);
			  
			  dispose();
			  new GUIcontent().setVisible(true);
				
			}
		});
		button_2.setBounds(525, 330, 110, 40);
		contentPane.add(button_2);
		
		JLabel lblSortBy = new JLabel("Sort By=>");
		lblSortBy.setBounds(10, 51, 56, 14);
		contentPane.add(lblSortBy);
		
		JLabel lblManageAllContents = new JLabel("MANAGE ALL CONTENTS");
		lblManageAllContents.setFont(new Font("Tw Cen MT", Font.BOLD, 17));
		lblManageAllContents.setBounds(269, 31, 198, 14);
		contentPane.add(lblManageAllContents);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Marwen\\Desktop\\sashamuradali_1295627048_11.jpg"));
		lblNewLabel.setBounds(0, 0, 755, 388);
		contentPane.add(lblNewLabel);
		
		textField_3 = new JTextField();
		textField_3.setBounds(117, 11, 110, 28);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(57, 18, 46, 14);
		contentPane.add(lblNewLabel_1);
	
	
	
	
	}
}
