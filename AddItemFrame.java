package itemOrganizer;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.EventQueue;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import itemOrganizer.Item;
import itemOrganizer.ItemOrganizer;
import itemOrganizer.OrganizerGUI;
import itemOrganizer.MainFrame;
import javax.swing.JInternalFrame;

public class AddItemFrame extends JFrame {

	private JPanel contentPane;
	private JTextField ItemNameField;
	private JTextField LocationField;
	private JTextField CategoryField;
	private final JButton deleteItemButton = new JButton("Reset");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddItemFrame frame = new AddItemFrame();
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
	public AddItemFrame() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(100, 149, 237));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add an Item");
		lblNewLabel.setForeground(UIManager.getColor("Button.highlight"));
		lblNewLabel.setFont(new Font("Cooper Black", Font.BOLD, 21));
		lblNewLabel.setBounds(159, 6, 139, 39);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Item name");
		lblNewLabel_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_1.setFont(new Font("Cooper Black", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(35, 57, 95, 30);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Location");
		lblNewLabel_1_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_1_1.setFont(new Font("Cooper Black", Font.PLAIN, 17));
		lblNewLabel_1_1.setBounds(35, 99, 95, 30);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Category");
		lblNewLabel_1_1_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_1_1_1.setFont(new Font("Cooper Black", Font.PLAIN, 17));
		lblNewLabel_1_1_1.setBounds(35, 144, 95, 30);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Important?");
		lblNewLabel_1_1_1_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_1_1_1_1.setFont(new Font("Cooper Black", Font.PLAIN, 17));
		lblNewLabel_1_1_1_1.setBounds(35, 187, 107, 30);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		ItemNameField = new JTextField();
		ItemNameField.setBounds(193, 57, 211, 29);
		contentPane.add(ItemNameField);
		ItemNameField.setColumns(10);
		
		LocationField = new JTextField();
		LocationField.setColumns(10);
		LocationField.setBounds(193, 101, 211, 29);
		contentPane.add(LocationField);
		
		CategoryField = new JTextField();
		CategoryField.setColumns(10);
		CategoryField.setBounds(193, 145, 211, 30);
		contentPane.add(CategoryField);
		
		JComboBox ImportanceField = new JComboBox();
		ImportanceField.setFont(new Font("Cooper Black", Font.PLAIN, 14));
		ImportanceField.setModel(new DefaultComboBoxModel(new String[] {"Yes", "No"}));
		ImportanceField.setBounds(193, 191, 211, 27);
		contentPane.add(ImportanceField);
		
		deleteItemButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ItemNameField.setText(null);
				LocationField.setText(null);
				CategoryField.setText(null);
			}
		});
		deleteItemButton.setBackground(new Color(192, 192, 192));
		deleteItemButton.setForeground(new Color(0, 0, 128));
		deleteItemButton.setFont(new Font("Cooper Black", Font.PLAIN, 18));
		deleteItemButton.setBounds(35, 222, 107, 39);
		contentPane.add(deleteItemButton);
		
		JButton SaveAndContinueButton = new JButton("Save and Continue");
		SaveAndContinueButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String itemName=ItemNameField.getText();
					String location=LocationField.getText();
					String category=CategoryField.getText();
					boolean importance;

			        if(ImportanceField.getSelectedItem().toString().equalsIgnoreCase("yes")){
			            importance = true;
			        }else{
			            importance = false;
			        }
					Item newItem=new Item(itemName,location,category,importance);
					Login.myOrganizer.addNewItem(newItem);
				}
				catch (Exception exc)
				{
					JOptionPane.showMessageDialog(null, "Please enter valid information");
				}
				MainFrame main=new MainFrame();
				main.getJFrame().setVisible(true);
			}
		});
		SaveAndContinueButton.setBackground(new Color(192, 192, 192));
		SaveAndContinueButton.setForeground(new Color(0, 0, 128));
		SaveAndContinueButton.setFont(new Font("Cooper Black", Font.PLAIN, 18));
		SaveAndContinueButton.setBounds(226, 222, 197, 39);
		contentPane.add(SaveAndContinueButton);

	}
}
