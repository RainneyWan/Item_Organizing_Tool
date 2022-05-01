package itemOrganizer;
import java.sql.*;
import javax.swing.*;
public class sqliteConnection {
	Connection conn=null;
	public static Connection dbConnector () {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn=DriverManager.getConnection("jdbc:sqlite:/Users/wanru_000/Desktop/IB/CS/forIA/product/IOTUserData.db");
			JOptionPane.showMessageDialog(null, "Connection successful");
			return conn;
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,e);
			return null;
		}
	}

}

