package itemOrganizer;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Window;

import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.ScrollPane;

public class ViewListFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewListFrame frame = new ViewListFrame();
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
	public ViewListFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(100, 149, 237));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel ViewListLabel = new JLabel("View List");
		ViewListLabel.setForeground(UIManager.getColor("Button.highlight"));
		ViewListLabel.setFont(new Font("Cooper Black", Font.BOLD, 21));
		ViewListLabel.setBounds(173, 6, 107, 25);
		contentPane.add(ViewListLabel);
		
		JLabel SortByLabel = new JLabel("Sort by...");
		SortByLabel.setForeground(new Color(0, 0, 128));
		SortByLabel.setFont(new Font("Cooper Black", Font.PLAIN, 19));
		SortByLabel.setBounds(18, 31, 107, 25);
		contentPane.add(SortByLabel);
		
		JTextArea displayTextArea = new JTextArea();
		displayTextArea.setBounds(173, 37, 252, 185);
		contentPane.add(displayTextArea);
		
		JButton SortByLocationButton = new JButton("Location");
		SortByLocationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item[] retrievedListt=Login.myOrganizer.sortByLocation();
				//System.out.println(Arrays.deepToString(retrievedListt));
				String allText="";
	            for (int i=0; i<retrievedListt.length; i++) {
	            	Item retrievedd=retrievedListt[i];
	            	if (retrievedd!=null) {
	            	String text="";
		            String pss[]= {"Item name: "+retrievedd.getName(),"Location: "+retrievedd.getLocation(),"Category: "+retrievedd.getCategory(),"Importance: "+retrievedd.getImportance()};
		            for (int s=0; s<pss.length;s++) {
		            	text+=pss[s]+ "\n";
		            }
		            allText+=text+ "\n";
	            	}
	            }
	            displayTextArea.setText(allText);
			}
		});
		SortByLocationButton.setForeground(new Color(0, 0, 128));
		SortByLocationButton.setFont(new Font("Cooper Black", Font.PLAIN, 17));
		SortByLocationButton.setBounds(18, 100, 119, 32);
		contentPane.add(SortByLocationButton);
		
		JButton SortByCategoryButton = new JButton("Category");
		SortByCategoryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item[] retrievedListtt=Login.myOrganizer.sortByCategory();
				String allText="";
	            for (int i=0; i<retrievedListtt.length; i++) {
	            	Item retrieveddd=retrievedListtt[i];
	            	if (retrieveddd!=null) {
	            	String text="";
		            String psss[]= {"Item name: "+retrieveddd.getName(),"Location: "+retrieveddd.getLocation(),"Category: "+retrieveddd.getCategory(),"Importance: "+retrieveddd.getImportance()};
		            for (int s=0; s<psss.length;s++) {
		            	text+=psss[s]+ "\n";
		            }
		            allText+=text+ "\n";
	            	}
	            }
	            displayTextArea.setText(allText);
			}
		});
		SortByCategoryButton.setForeground(new Color(0, 0, 128));
		SortByCategoryButton.setFont(new Font("Cooper Black", Font.PLAIN, 17));
		SortByCategoryButton.setBounds(18, 144, 119, 25);
		contentPane.add(SortByCategoryButton);
		
		JButton SortByTimeAddedButton = new JButton("Time added");
		SortByTimeAddedButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item[] retrievedList=Login.myOrganizer.sortByTimeAdded();
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
		});
		SortByTimeAddedButton.setForeground(new Color(0, 0, 128));
		SortByTimeAddedButton.setFont(new Font("Cooper Black", Font.PLAIN, 17));
		SortByTimeAddedButton.setBounds(18, 67, 133, 32);
		contentPane.add(SortByTimeAddedButton);
		
		JButton SortByNameButton = new JButton("Name");
		SortByNameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item[] retrievedListtttt=Login.myOrganizer.sortByName();
				String allText="";
	            for (int i=0; i<retrievedListtttt.length; i++) {
	            	Item retrievedddd=retrievedListtttt[i];
	            	if(retrievedddd!=null) {
	            	String text="";
		            String pssss[]= {"Item name: "+retrievedddd.getName(),"Location: "+retrievedddd.getLocation(),"Category: "+retrievedddd.getCategory(),"Importance: "+retrievedddd.getImportance()};
		            for (int s=0; s<pssss.length;s++) {
		            	text+=pssss[s]+ "\n";
		            }
		            allText+=text+ "\n";
	            	}
	            }
	            displayTextArea.setText(allText);
			}
		});
		SortByNameButton.setForeground(new Color(0, 0, 128));
		SortByNameButton.setFont(new Font("Cooper Black", Font.PLAIN, 17));
		SortByNameButton.setBounds(18, 184, 119, 25);
		contentPane.add(SortByNameButton);
		
		JButton btnBackToMain = new JButton("Back to Main Page");
		btnBackToMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame main=new MainFrame();
				main.getJFrame().setVisible(true);
			}
		});
		btnBackToMain.setFont(new Font("Cooper Black", Font.PLAIN, 17));
		btnBackToMain.setForeground(new Color(0, 0, 128));
		btnBackToMain.setBounds(235, 234, 190, 38);
		contentPane.add(btnBackToMain);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayTextArea.setText(null);
			}
		});
		btnReset.setForeground(new Color(0, 0, 128));
		btnReset.setFont(new Font("Cooper Black", Font.PLAIN, 17));
		btnReset.setBounds(32, 234, 119, 38);
		contentPane.add(btnReset);
		
		JScrollPane scrollPane = new JScrollPane(displayTextArea);
		scrollPane.setBounds(173, 37, 252, 185);
		contentPane.add(scrollPane);
		

	}

}
