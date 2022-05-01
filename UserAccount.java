package itemOrganizer;

public class UserAccount {
	private int userID; //the user ID which consists of 3 digits, unique to each user.
	private String userName; //the name of the user.
	private String password; //the password set by user, consisting of digits and alphabets.
	private ItemOrganizer myOrganizer; //item organizer for each specific user.
	
	public int initialUserID=001;
	
    /**
     * Parameterized constructor to constructor a UserAccount object. 
     * @param userName the nick name of the user.
     * @param password the password specified by the user.
     */
	
	public UserAccount(String userName, String password) {
		this.userName=userName;
		this.password=password;
		userID=initialUserID;
		initialUserID++;
		myOrganizer=new ItemOrganizer();
	}
	
	 /**
     * 
     * @return the userID of the user.
     */
	public int getuserID() {
		return userID;
	}

	 /**
     * 
     * @return the userName of the user.
     */
	public String getuserName() {
		return userName;
	}
	
	 /**
     * 
     * @return the password of the user.
     */
	public String getPassword() {
		return password;
	}
	
	 /**
     * 
     * @return the category of the Item 
     */
	public ItemOrganizer getItemOrganizer() {
		return myOrganizer;
	}
	
    /**
     * Sets the userID of the user to a new one
     * @param newUserID the new ID for the user
     */
	public void setUserID(int newUserID) {
		userID=newUserID;
	}
	
    /**
     * Sets the userName of the user to a new one
     * @param newUserName the new name for the user
     */
	public void setUserName(String newUserName) {
		userName=newUserName;
	}
	
    /**
     * Sets the password of the UserAccount to a new one
     * @param newPassword the new password for the UserAccount
     */
	public void setPassword(String newPassword) {
		password=newPassword;
	}
	
    /**
     * Sets the item organizer of the user to a new one
     * @param newItemOrganizer the new item organizer for the Item
     */
	public void setItemOrganizer(ItemOrganizer newItemOrganizer) {
		myOrganizer=newItemOrganizer;
	}
	

}
