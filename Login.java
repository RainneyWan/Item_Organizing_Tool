package itemOrganizer;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
public class Login {

	private JFrame frame;
	protected static ItemOrganizer myOrganizer = new ItemOrganizer();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection=null;
	private JTextField textFieldUN;
	private JPasswordField passwordField;
	private JLabel Title;
	private JLabel Picture;
	private JButton btnCreateAccount;
	
	
	public JFrame getJFrame() {
		return frame;
	}
	

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
		connection=sqliteConnection.dbConnector();
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
		
		JLabel UsernameLabel = new JLabel("Username");
		UsernameLabel.setForeground(new Color(0, 0, 128));
		UsernameLabel.setFont(new Font("Cooper Black", Font.PLAIN, 17));
		UsernameLabel.setBounds(190, 65, 97, 26);
		frame.getContentPane().add(UsernameLabel);
		
		JLabel PasswordLabel = new JLabel("Password");
		PasswordLabel.setForeground(new Color(0, 0, 128));
		PasswordLabel.setFont(new Font("Cooper Black", Font.PLAIN, 17));
		PasswordLabel.setBounds(190, 139, 97, 16);
		frame.getContentPane().add(PasswordLabel);
		
		textFieldUN = new JTextField();
		textFieldUN.setBounds(299, 66, 130, 26);
		frame.getContentPane().add(textFieldUN);
		textFieldUN.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setForeground(new Color(0, 0, 128));
		btnLogin.setFont(new Font("Cooper Black", Font.PLAIN, 17));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					String query="select * from UserInfo where username=? and password=?";
					PreparedStatement pst=connection.prepareStatement(query);

					pst.setString(1, textFieldUN.getText());
					pst.setString(2, passwordField.getText());
					
					ResultSet rs=pst.executeQuery();
					int count=0;
					while(rs.next()) {
						count=count+1;
						
					}
					if (count==1) {
						JOptionPane.showMessageDialog(null,"Username and password is found");
						OrganizerGUI gui=new OrganizerGUI();
						myOrganizer=gui.getOrganizer();
						MainFrame main=new MainFrame();
						main.getJFrame().setVisible(true);
					}else if(count>1) {
						JOptionPane.showMessageDialog(null,"Duplicate username and password");
					}else {
						JOptionPane.showMessageDialog(null,"Incorrect username or password");
					}
					
					rs.close();
					pst.close();
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null,e);
				}
				finally {
					try {
						
					}catch(Exception e) {
						
					}
				}
			}
		});
		btnLogin.setBounds(332, 207, 97, 35);
		frame.getContentPane().add(btnLogin);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(299, 135, 130, 26);
		frame.getContentPane().add(passwordField);
		
		Title = new JLabel("Organize Your Items!");
		Title.setHorizontalAlignment(SwingConstants.CENTER);
		Title.setForeground(Color.WHITE);
		Title.setFont(new Font("Gill Sans", Font.BOLD, 22));
		Title.setBounds(100, 17, 255, 25);
		frame.getContentPane().add(Title);
		
		Picture = new JLabel("");
		Image img=new ImageIcon(this.getClass().getResource("/drawer.png")).getImage();
		Picture.setIcon(new ImageIcon(img));
		Picture.setBounds(25, 60, 153, 182);
		frame.getContentPane().add(Picture);
		
		btnCreateAccount = new JButton("Create Account");
		btnCreateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				CreateAccountFrame createAccount=new CreateAccountFrame();
				createAccount.setVisible(true);
			}
		});
		btnCreateAccount.setForeground(new Color(0, 0, 128));
		btnCreateAccount.setFont(new Font("Cooper Black", Font.PLAIN, 17));
		btnCreateAccount.setBounds(183, 207, 147, 35);
		frame.getContentPane().add(btnCreateAccount);
	}
}
