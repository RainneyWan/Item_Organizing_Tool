package itemOrganizer;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;
import java.awt.Window;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class CreateAccountFrame extends JFrame {

	private JPanel contentPane;
	private JTextField UsernameTextField;
	private JLabel Picture;
	private JLabel PasswordLabel;
	private JTextField PasswordTextField;
	private JButton btnReset;
	private JButton btnSaveAndContinue;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateAccountFrame frame = new CreateAccountFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection connection=null;
	private JLabel lblUserId;
	private JTextField UserIDTextField;

	/**
	 * Create the frame.
	 */
	public CreateAccountFrame() {
		connection=sqliteConnection.dbConnector();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(100, 149, 237));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Picture = new JLabel("");
		Image img=new ImageIcon(this.getClass().getResource("/drawer.png")).getImage();
		Picture.setIcon(new ImageIcon(img));
		Picture.setBounds(25, 60, 153, 182);
		contentPane.add(Picture);
		
		JLabel lblCreateYourAccount = new JLabel("Create Your Account");
		lblCreateYourAccount.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreateYourAccount.setForeground(Color.WHITE);
		lblCreateYourAccount.setFont(new Font("Gill Sans", Font.BOLD, 22));
		lblCreateYourAccount.setBounds(98, 18, 255, 25);
		contentPane.add(lblCreateYourAccount);
		
		JLabel UsernameLabel = new JLabel("Username");
		UsernameLabel.setForeground(new Color(0, 0, 128));
		UsernameLabel.setFont(new Font("Cooper Black", Font.PLAIN, 17));
		UsernameLabel.setBounds(190, 101, 97, 26);
		contentPane.add(UsernameLabel);
		
		UsernameTextField = new JTextField();
		UsernameTextField.setColumns(10);
		UsernameTextField.setBounds(287, 102, 130, 26);
		contentPane.add(UsernameTextField);
		
		PasswordLabel = new JLabel("Password");
		PasswordLabel.setForeground(new Color(0, 0, 128));
		PasswordLabel.setFont(new Font("Cooper Black", Font.PLAIN, 17));
		PasswordLabel.setBounds(190, 145, 97, 16);
		contentPane.add(PasswordLabel);
		
		PasswordTextField = new JTextField();
		PasswordTextField.setColumns(10);
		PasswordTextField.setBounds(287, 141, 130, 26);
		contentPane.add(PasswordTextField);
		
		btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsernameTextField.setText(null);
				PasswordTextField.setText(null);
			}
		});
		btnReset.setForeground(new Color(0, 0, 128));
		btnReset.setFont(new Font("Cooper Black", Font.PLAIN, 17));
		btnReset.setBounds(190, 196, 97, 35);
		contentPane.add(btnReset);
		
		btnSaveAndContinue = new JButton("Save");
		btnSaveAndContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query="insert into UserInfo (UserID, UserName, Password) values (?,?,?)";
					PreparedStatement pst=connection.prepareStatement(query);
					pst.setString(1, UserIDTextField.getText());
					pst.setString(2, UsernameTextField.getText());
					pst.setString(3, PasswordTextField.getText());
					
					pst.execute();
					
					/* initialize a new item organizer for the new user */
					
					JOptionPane.showMessageDialog(null, "Data Saved");
					
					pst.close();
					
				} catch(Exception exc) {
					exc.printStackTrace();
				}
				Login login=new Login();
				login.getJFrame().setVisible(true);
			}
		});
		btnSaveAndContinue.setForeground(new Color(0, 0, 128));
		btnSaveAndContinue.setFont(new Font("Cooper Black", Font.PLAIN, 17));
		btnSaveAndContinue.setBounds(320, 196, 97, 35);
		contentPane.add(btnSaveAndContinue);
		
		lblUserId = new JLabel("User ID");
		lblUserId.setForeground(new Color(0, 0, 128));
		lblUserId.setFont(new Font("Cooper Black", Font.PLAIN, 17));
		lblUserId.setBounds(190, 63, 97, 26);
		contentPane.add(lblUserId);
		
		UserIDTextField = new JTextField();
		UserIDTextField.setColumns(10);
		UserIDTextField.setBounds(287, 60, 130, 26);
		contentPane.add(UserIDTextField);
	}

}
