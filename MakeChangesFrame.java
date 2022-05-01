package itemOrganizer;
import itemOrganizer.Login;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class MakeChangesFrame extends JFrame {

	private JPanel contentPane;
	private JTextField ItemNameField;
	private JTextField LocationField;
	private JTextField CategoryField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MakeChangesFrame frame = new MakeChangesFrame();
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
	public MakeChangesFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(100, 149, 237));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Make Changes");
		lblNewLabel.setForeground(UIManager.getColor("Button.highlight"));
		lblNewLabel.setFont(new Font("Cooper Black", Font.BOLD, 21));
		lblNewLabel.setBounds(144, 6, 157, 40);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Item name");
		lblNewLabel_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_1.setFont(new Font("Cooper Black", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(26, 53, 103, 26);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Location");
		lblNewLabel_1_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_1_1.setFont(new Font("Cooper Black", Font.PLAIN, 17));
		lblNewLabel_1_1.setBounds(26, 91, 103, 26);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Category");
		lblNewLabel_1_1_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_1_1_1.setFont(new Font("Cooper Black", Font.PLAIN, 17));
		lblNewLabel_1_1_1.setBounds(26, 129, 103, 26);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Importance");
		lblNewLabel_1_1_1_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_1_1_1_1.setFont(new Font("Cooper Black", Font.PLAIN, 17));
		lblNewLabel_1_1_1_1.setBounds(26, 170, 103, 26);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		JComboBox ImportanceField = new JComboBox();
		ImportanceField.setFont(new Font("Cooper Black", Font.PLAIN, 14));
		ImportanceField.setModel(new DefaultComboBoxModel(new String[] {"Yes", "No"}));
		ImportanceField.setBounds(171, 172, 234, 27);
		contentPane.add(ImportanceField);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ItemNameField.setText(null);
				LocationField.setText(null);
				CategoryField.setText(null);
			}
		});
		btnReset.setForeground(new Color(0, 0, 128));
		btnReset.setFont(new Font("Cooper Black", Font.PLAIN, 18));
		btnReset.setBackground(Color.LIGHT_GRAY);
		btnReset.setBounds(26, 208, 122, 39);
		contentPane.add(btnReset);
		
		JButton btnSaveAndContinue = new JButton("Save and Continue");
		btnSaveAndContinue.addActionListener(new ActionListener() {
			private Object myOrganizer;

			public void actionPerformed(ActionEvent e) {
				try {
					String itemName=ItemNameField.getText();
					String location=LocationField.getText();
					String category=CategoryField.getText();
					boolean importance;

			        if(ImportanceField.getSelectedItem().toString().equalsIgnoreCase("Yes")){
			            importance = true;
			        }else{
			            importance = false;
			        }
			        Login.myOrganizer.changeItemInfo(itemName,location,category,importance);
					
				}
				catch (Exception exc)
				{
					JOptionPane.showMessageDialog(null, "Please enter valid information");
				}
				MainFrame main=new MainFrame();
				main.getJFrame().setVisible(true);
			}
		});
		btnSaveAndContinue.setForeground(new Color(0, 0, 128));
		btnSaveAndContinue.setFont(new Font("Cooper Black", Font.PLAIN, 18));
		btnSaveAndContinue.setBackground(Color.LIGHT_GRAY);
		btnSaveAndContinue.setBounds(223, 208, 199, 39);
		contentPane.add(btnSaveAndContinue);
		
		ItemNameField = new JTextField();
		ItemNameField.setBounds(171, 52, 234, 31);
		contentPane.add(ItemNameField);
		ItemNameField.setColumns(10);
		
		LocationField = new JTextField();
		LocationField.setColumns(10);
		LocationField.setBounds(171, 92, 234, 31);
		contentPane.add(LocationField);
		
		CategoryField = new JTextField();
		CategoryField.setColumns(10);
		CategoryField.setBounds(171, 130, 234, 31);
		contentPane.add(CategoryField);
		

	}

}
