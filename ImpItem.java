package itemOrganizer;

public class ImpItem extends Item{
	private int importanceLevel;
	//importance level ranging from 1 to 5, 5 being the most important items.
	
    /**
     * Parameterized constructor to constructor a ImpItem object. 
     * @param importanceLevel how important the item is, an integer from 1 to 5.
     */
	public ImpItem(String name, String location, String category, boolean importance, int importanceLevel) {
		super(name, location, category, importance);
		importanceLevel=0;
		// TODO Auto-generated constructor stub
	}
	
	 /**
     * 
     * @return the importance level of the Item 
     */
	public int getImportanceLevel() {
		return importanceLevel;
	}
	
    /**
     * Sets the importance level of the Item to a new one
     * @param newImportanceLevel the new importanceLevel of the Item
     */
	public void setImportanceLevel(int newImportanceLevel) {
		importanceLevel=newImportanceLevel;
	}

}
