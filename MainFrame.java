package itemOrganizer;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


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

public class MainFrame {

	private JFrame frame;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = new MainFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public JFrame getJFrame() {
		return frame;
	}

	/**
	 * Create the application.
	 */
	public MainFrame() {
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(100, 149, 237));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Add an item");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				AddItemFrame addItem=new AddItemFrame();
				addItem.setVisible(true);
			}
		});
		btnNewButton.setBackground(SystemColor.scrollbar);
		btnNewButton.setForeground(new Color(0, 0, 128));
		btnNewButton.setFont(new Font("Cooper Black", Font.PLAIN, 13));
		btnNewButton.setBounds(153, 59, 151, 37);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnMakeChanges = new JButton("Make changes");
		btnMakeChanges.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				MakeChangesFrame makeChanges=new MakeChangesFrame();
				makeChanges.setVisible(true);
			}
		});
		btnMakeChanges.setForeground(new Color(0, 0, 128));
		btnMakeChanges.setFont(new Font("Cooper Black", Font.PLAIN, 13));
		btnMakeChanges.setBackground(SystemColor.scrollbar);
		btnMakeChanges.setBounds(153, 108, 151, 37);
		frame.getContentPane().add(btnMakeChanges);
		
		JButton btnRetriev = new JButton("Retrieve an item");
		btnRetriev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				RetrieveItemFrame retrieveItem=new RetrieveItemFrame();
				retrieveItem.setVisible(true);
			}
		});
		btnRetriev.setForeground(new Color(0, 0, 128));
		btnRetriev.setFont(new Font("Cooper Black", Font.PLAIN, 13));
		btnRetriev.setBackground(SystemColor.scrollbar);
		btnRetriev.setBounds(153, 157, 151, 37);
		frame.getContentPane().add(btnRetriev);
		
		JButton btnViewList = new JButton("View list");
		btnViewList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				ViewListFrame viewList=new ViewListFrame();
				viewList.setVisible(true);
			}
		});
		btnViewList.setForeground(new Color(0, 0, 128));
		btnViewList.setFont(new Font("Cooper Black", Font.PLAIN, 13));
		btnViewList.setBackground(SystemColor.scrollbar);
		btnViewList.setBounds(153, 204, 151, 37);
		frame.getContentPane().add(btnViewList);
		
		JLabel Title = new JLabel("Organize Your Items!");
		Title.setHorizontalAlignment(SwingConstants.CENTER);
		Title.setForeground(UIManager.getColor("Button.highlight"));
		Title.setFont(new Font("Gill Sans", Font.BOLD, 22));
		Title.setBounds(100, 22, 255, 25);
		frame.getContentPane().add(Title);
	}
}
