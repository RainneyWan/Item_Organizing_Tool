package itemOrganizer;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author w
 */

public class Item {
	private String name; //the name of the item
	private String location; //the location where the item is put, e.g. table
	private String category; //the category of the item, e.g. documents
	private boolean importance; //indicate whether the item is "important", true or false
	public static int count=0; // how many items have been made across the whole program. 
	
    /**
     * Parameterized constructor to constructor a Item object. 
     * @param name the the name of the item
     * @param location the location where the item is put, e.g. table
     * @param category the category of the item, e.g. documents
     * @param importance indicate whether the item is "important", true or false
     */
	
	public Item(String name, String location, String category, boolean importance) {
		this.name=name;
		this.location=location;
		this.category=category;
		this.importance=importance;
		count=count+1;
	}

	 /**
     * 
     * @return the name of the Item 
     */
	public String getName() {
		return name;
	}
	
	 /**
     * 
     * @return the location of the Item 
     */
	public String getLocation() {
		return location;
	}
	
	 /**
     * 
     * @return the category of the Item 
     */
	public String getCategory() {
		return category;
	}
	
	 /**
     * 
     * @return the importance status of the Item 
     */
	public boolean getImportance() {
		return importance;
	}
	
    /**
     * Sets the name of the Item to a new one
     * @param newName the new name for the Item
     */
	public void setName(String newName) {
		name=newName;
	}
	
    /**
     * Sets the location of the Item to a new one
     * @param newLocation the new location for the Item
     */
	public void setLocation(String newLocation) {
		location=newLocation;
	}
	
    /**
     * Sets the category of the Item to a new one
     * @param newCategory the new category for the Item
     */
	public void setCategory(String newCategory) {
		category=newCategory;
	}
	
    /**
     * Changes the importance status of the Item
     * @param newImportance the new importance status for the Item
     */
	public void setImportance(boolean newImportance) {
		importance=newImportance;
	}
	
    /**
     * 
     * @return a string representation of the Item object
     */
    public String toString(){
        return "Name: " + name + "\n"
                + "Location: " + location + "\n"
                + "Category: " + category + "\n"
                + "Im[prtance: " + importance + "\n";
    }
}
