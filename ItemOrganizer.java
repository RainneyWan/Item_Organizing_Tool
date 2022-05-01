package itemOrganizer;


public class ItemOrganizer {
	
    // instance variable array that holds all Item objects in the program.  
	private Item[] org;
    // integer which indicates the next available spot which can be assigned to a new Item object
    private int nextSpotAvailable = 0;
	
	public ItemOrganizer(){
        org = new Item[100];
    }
    /**
     * Default constructor which creates a Organizer with the array org set to 100
     */
	
	public ItemOrganizer(int size){
        org = new Item[size];
    }
    /**
     * Parameterized constructor which creates a Organizer with the capacity to hold 
     * an amount of Item objects indicated by the parameter
     * @param size the capacity which is assigned to the org array
     */
	
    /**
     * How many Items are currently in the organizer
     * @return Items are currently in the organizer.
     */
    public int getSize(){
        return nextSpotAvailable;
    }
    
    /**
     * Adds a new Item object into the organizer.
     * @param newItem the Item object to be added.
     */
	public void addNewItem(Item newItem) {
		org[nextSpotAvailable]=newItem;
		nextSpotAvailable++;
	}
	
    /**
     * Removes the Item object in the organizer with the corresponding name as the parameter.
     * @param itemToDelete the name of the Item to be removed from org.
     */
	public void deleteItem(String itemToDelete) {
		int n = 0;
		for(int i=0; i<nextSpotAvailable; i++) {
			if(org[i].getName().equals(itemToDelete)) {
				n=i;
				break;
			}
		}
		
		for (int j=n; j<nextSpotAvailable-1; j++) {
			org[j]=org[j+1];
		}
		
		org[nextSpotAvailable]=null;
		nextSpotAvailable--;
	}
	
    /**
     * Retrieves all valid Item objects in the organizer based on sequence of adding the items
     * @return all valid Item objects in an array, the returned array should not have any null elements.
     */
	public Item[] sortByTimeAdded() {
		Item[] array=new Item[nextSpotAvailable];
		for (int i=0; i<nextSpotAvailable; i++) {
			array[i]=org[i];
		}
		return array;
	}
	
    /**
     * Retrieves the Item with a specific input name
     * @param name 
     * @return An Item object which has the parameter name.
     */
	public Item findItem(String name) {
		Item t = null;
		for (int i=0; i<nextSpotAvailable; i++) {
			if (org[i].getName().equals(name)) {
				t=org[i];
			}
		}
		return t;
	}
	
    /**
     * Retrieves all the Items of a corresponding location
     * @param location 
     * @return an array of Item objects which are from the parameter location, 
     * no nulls in returned array.
     */
	public Item[] searchByLocation(String location) {
		Item[] array=new Item[nextSpotAvailable];
		int j=0;
		for (int i=0; i<nextSpotAvailable; i++) {
			if (org[i].getLocation().equals(location)) {
				array[j]=org[i];
				j++;
			}
		}
		Item[] shortenedArray=new Item[j];
		int k;
		for (k=0; k<=j-1; k++) {
			shortenedArray[k]=array[k];
		}
		return shortenedArray;
	}
	
    /**
     * Retrieves all the Items of a corresponding category
     * @param category 
     * @return an array of Item objects which are from the parameter category, 
     * no nulls in returned array.
     */
	public Item[] searchByCategory(String category) {
		Item[] array=new Item[nextSpotAvailable];
		int j=0;
		for (int i=0; i<nextSpotAvailable; i++) {
			if (org[i].getCategory().equals(category)) {
				array[j]=org[i];
				j++;
			}
		}
		Item[] shortenedArray=new Item[j];
		int k;
		for (k=0; k<=j-1; k++) {
			shortenedArray[k]=array[k];
		}
		return shortenedArray;
	}
	
    /**
     * Retrieves all the Items of a corresponding importance status
     * @param importance 
     * @return an array of Item objects which are of the parameter importance, 
     * no nulls in returned array.
     */
	public Item[] searchByImportance(Boolean importance) {
		Item[] array=new Item[nextSpotAvailable];
		int j=0;
		for (int i=0; i<nextSpotAvailable; i++) {
			if (org[i].getImportance()==importance) {
				array[j]=org[i];
				j++;
			}
		}
		Item[] shortenedArray=new Item[j];
		int k;
		for (k=0; k<=j-1; k++) {
			shortenedArray[k]=array[k];
		}
		return shortenedArray;
	}
	
    /**
     * Sort all valid Items by alphabetic order of location.
     * @return an array of Item objects sorted by alphabetic order of location, 
     * no nulls in returned array.
     */
	public Item[] sortByLocation() {
		Item[] array=new Item[nextSpotAvailable];
        for(int i = 0; i < nextSpotAvailable - 1; i++){
            int minIndex = i;
            for(int j = i+1; j < nextSpotAvailable; j++){
                if(org[j].getLocation().compareToIgnoreCase(org[minIndex].getLocation())<0){
                    minIndex = j;
                }
            }
            Item temp = org[i];
            org[i] = org[minIndex];
            org[minIndex] = temp;
        }
        array=org;
        return array;
	}
	
    /**
     * Sort all valid Items by alphabetic order of Name.
     * @return an array of Item objects sorted by alphabetic order of item name, 
     * no nulls in returned array.
     */
	public Item[] sortByName() {
		Item[] array=new Item[nextSpotAvailable];
        for(int i = 0; i < nextSpotAvailable - 1; i++){
            int minIndex = i;
            for(int j = i+1; j < nextSpotAvailable; j++){
                if(org[j].getName().compareToIgnoreCase(org[minIndex].getName())<0){
                    minIndex = j;
                }
            }
            Item temp = org[i];
            org[i] = org[minIndex];
            org[minIndex] = temp;
        }
        array=org;
        return array;
	}
	
    /**
     * Sort all valid Items by alphabetic order of Category.
     * @return an array of Item objects sorted by alphabetic order of category, 
     * no nulls in returned array.
     */
	public Item[] sortByCategory() {
		Item[] array=new Item[nextSpotAvailable];
        for(int i = 0; i < nextSpotAvailable - 1; i++){
            int minIndex = i;
            for(int j = i+1; j < nextSpotAvailable; j++){
                if(org[j].getCategory().compareToIgnoreCase(org[minIndex].getCategory())<0){
                    minIndex = j;
                }
            }
            Item temp = org[i];
            org[i] = org[minIndex];
            org[minIndex] = temp;
        }
        array=org;
        return array;
	}
	
    /**
     * Sort all valid Items by importance level 1~5.
     * @return an array of Item objects sorted by importance level from 5 to 1, no nulls in returned array.
     */
	public void sortByImportance() {
		ImpItem[] org=(ImpItem[]) searchByImportance(true);
        for(int i = 0; i < nextSpotAvailable - 1; i++){
            int minIndex = i;
            for(int j = i+1; j < nextSpotAvailable; j++){
                if(org[j].getImportanceLevel()<(org[minIndex].getImportanceLevel())){
                    minIndex = j;
                }
            }
            ImpItem temp = org[i];
            org[i] = org[minIndex];
            org[minIndex] = temp;
        }
	}
	
    /**
     * Change information of item with a corresponding name.
     * @param changedName, changedLocation, changedCategory, changedImp. 
     */
	public void changeItemInfo(String changedName, String changedLocation, String changedCategory, Boolean changedImp) {
		boolean found=false;
		int i=0;
		while(i<nextSpotAvailable && found==false) {
			if (org[i].getName().equals(changedName)) {
				org[i].setLocation(changedLocation);
				org[i].setCategory(changedCategory);
				org[i].setImportance(changedImp);
				found=true;
			}
			i++;
		}
	}
	

}
