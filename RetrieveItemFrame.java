package itemOrganizer;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.JScrollBar;
import java.awt.ScrollPane;

public class RetrieveItemFrame extends JFrame {

	private JPanel contentPane;
	private JTextField MainTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RetrieveItemFrame frame = new RetrieveItemFrame();
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
	public RetrieveItemFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(100, 149, 237));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Retrieve an Item");
		lblNewLabel.setForeground(UIManager.getColor("Button.highlight"));
		lblNewLabel.setFont(new Font("Cooper Black", Font.BOLD, 21));
		lblNewLabel.setBounds(134, 6, 183, 38);
		contentPane.add(lblNewLabel);
		
		JComboBox SelectionBox = new JComboBox();
		SelectionBox.setFont(new Font("Cooper Black", Font.PLAIN, 15));
		SelectionBox.setForeground(new Color(0, 0, 0));
		SelectionBox.setModel(new DefaultComboBoxModel(new String[] {"Name", "Location", "Category", "Importance"}));
		SelectionBox.setBounds(144, 44, 145, 27);
		contentPane.add(SelectionBox);
		
		JTextArea displayTextArea = new JTextArea();
		displayTextArea.setBounds(24, 75, 397, 147);
		contentPane.add(displayTextArea);

		JButton btnRetrieve = new JButton("Retrieve");
		btnRetrieve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(SelectionBox.getSelectedItem().toString().equals("Name")){
		            Item retrieved=Login.myOrganizer.findItem(MainTextField.getText());
		            String text="";
		            String ps[]= {"Item name: "+retrieved.getName(),"Location: "+retrieved.getLocation(),"Category: "+retrieved.getCategory(),"Importance: "+retrieved.getImportance()};
		            for (int s=0; s<ps.length;s++) {
		            	text+=ps[s]+ "\n";
		            }
		            displayTextArea.setText(text);
				}else if(SelectionBox.getSelectedItem().toString().equals("Location")){
		            Item[] retrievedList=Login.myOrganizer.searchByLocation(MainTextField.getText());
		            String allText="";
		            for (int i=0; i<retrievedList.length; i++) {
		            	Item retrieved=retrievedList[i];
		            	String text="";
			            String ps[]= {"Item name: "+retrieved.getName(),"Location: "+retrieved.getLocation(),"Category: "+retrieved.getCategory(),"Importance: "+retrieved.getImportance()};
			            for (int s=0; s<ps.length;s++) {
			            	text+=ps[s]+ "\n";
			            }
			            allText+=text+ "\n";
		            }
		            displayTextArea.setText(allText);
		        }else if(SelectionBox.getSelectedItem().toString().equals("Category")){
		        	Item[] retrievedList=Login.myOrganizer.searchByCategory(MainTextField.getText());
		        	String allText="";
		            for (int i=0; i<retrievedList.length; i++) {
		            	Item retrieved=retrievedList[i];
		            	String text="";
			            String ps[]= {"Item name: "+retrieved.getName(),"Location: "+retrieved.getLocation(),"Category: "+retrieved.getCategory(),"Importance: "+retrieved.getImportance()};
			            for (int s=0; s<ps.length;s++) {
			            	text+=ps[s]+ "\n";
			            }
			            allText+=text+ "\n";
		            }
		            displayTextArea.setText(allText);
		        }else{
		        	Item[] retrievedList=Login.myOrganizer.searchByImportance(MainTextField.getText().equalsIgnoreCase("true"));
		        	String allText="";
		            for (int i=0; i<retrievedList.length; i++) {
		            	Item retrieved=retrievedList[i];
		            	String text="";
			            String ps[]= {"Item name: "+retrieved.getName(),"Location: "+retrieved.getLocation(),"Category: "+retrieved.getCategory(),"Importance: "+retrieved.getImportance()};
			            for (int s=0; s<ps.length;s++) {
			            	text+=ps[s]+ "\n";
			            }
			            allText+=text+ "\n";
		            }
		            displayTextArea.setText(allText);
		        	
		        }
			}
		});
		btnRetrieve.setForeground(new Color(0, 0, 128));
		btnRetrieve.setFont(new Font("Cooper Black", Font.PLAIN, 17));
		btnRetrieve.setBounds(24, 234, 114, 38);
		contentPane.add(btnRetrieve);
		
		JButton btnBackToMain = new JButton("Back to Main Page");
		btnBackToMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame main=new MainFrame();
				main.getJFrame().setVisible(true);
			}
		});
		btnBackToMain.setForeground(new Color(0, 0, 128));
		btnBackToMain.setFont(new Font("Cooper Black", Font.PLAIN, 17));
		btnBackToMain.setBounds(238, 234, 183, 38);
		contentPane.add(btnBackToMain);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainTextField.setText(null);
				displayTextArea.setText(null);
			}
		});
		btnReset.setForeground(new Color(0, 0, 128));
		btnReset.setFont(new Font("Cooper Black", Font.PLAIN, 17));
		btnReset.setBounds(140, 234, 97, 38);
		contentPane.add(btnReset);
		
		JLabel lblRetrieveBy = new JLabel("Retrieve by...");
		lblRetrieveBy.setForeground(new Color(0, 0, 128));
		lblRetrieveBy.setFont(new Font("Cooper Black", Font.PLAIN, 17));
		lblRetrieveBy.setBounds(24, 42, 133, 26);
		contentPane.add(lblRetrieveBy);
		
		MainTextField = new JTextField();
		MainTextField.setBounds(294, 43, 125, 27);
		contentPane.add(MainTextField);
		MainTextField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane(displayTextArea);
		scrollPane.setBounds(24, 75, 397, 147);
		contentPane.add(scrollPane);
		

	}
}
