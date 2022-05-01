package itemOrganizer;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author w
 */

public class OrganizerCLI {
	
	// ItemOrganizer as our instance variable, it is used to process data we pass in from the CLI.
    private ItemOrganizer organizer;
    // The constant used to separate individual attributes read from records in the text file
    private static final String SEPARATOR = ",";

    /**
     * Constructor used to initialize the organizer and read the text input.
     */
    public OrganizerCLI() {
        // Instantiate the back end by initializing the ItemOrganizer variable organizer.
        organizer = new ItemOrganizer();
        // An attempt will be made to open the CSV file storing the item data, and read the data into the organizer.
        try {
            // A built in Scanner object is used to open the file Items.csv
            Scanner textScanner = new Scanner(new File("Items.csv"));
            // The Scanner object textScanner will check each line in the file, stopping when there are no more lines. 
            while (textScanner.hasNextLine()) {
                // Reads the next line and store it into a string
                String nextLine = textScanner.nextLine();
                // The split() method in String is used to get each attributes of a record separated, separatedRecord is an array of individual attributes of each record. 
                String[] separatedRecord = nextLine.split(SEPARATOR);
                // Each attribute has been separated, but since they are stored in a String[] all values are still Strings
                
                String name=separatedRecord[0];
               
                String location=separatedRecord[1];
                  
                String category = separatedRecord[2];

                
                // Whether or not the item is important is stored as "Yes" or "No" in the array separatedRecord, but we need true/false, so the following is done to process it. 
                boolean important = false;
                if (separatedRecord[3].equals("yes")) {
                    important = true;
                }
                
                // Create a new SalesRecord object using the values we have retrieved and processed from the text file.  
                Item newItem = new Item(name, location, category, important);
                
                
                // Add the newly instantiated Items to the manager using the ItemOrganizer method
                organizer.addNewItem(newItem);
                

            }
            System.out.println("System initialized");
            
            // the following will output an error if the file is not found, but because we are using a try - catch block, we will not crash the program.  
        } catch (FileNotFoundException ex) {
            System.out.println("Error file not found");
        }
    }

    /**
     * The following method will handle the running of the CLI.
     * Notice that all other methods have the attribute private, that is because they don't need to be called in a client class, they just need to be called here.
     */
    public void run() {
        boolean keepRunning = true;
        Scanner inputReader = new Scanner(System.in);
        while (keepRunning) {
            displayMenu();
            int choice;
            try {
                choice = inputReader.nextInt();

            } catch (Exception e) {
                inputReader.nextLine();
                choice = -1;
            }
            if (choice == 1) {
                displayByTimeAdded();
            } else if (choice == 2) {
                addItem();
            } else if (choice == 3) {
                deleteItem();
            } else if (choice == 4) {
                searchByName();
            } else if (choice == 5) {
                searchByLocation();
            } else if (choice == 6) {
                searchByCategory();
            } else if (choice == 7) {
                displayImportantItems();
            } else if (choice == 8) {
                sortByName();
            } else if (choice == 9) {
                sortByLocation();
            } else if (choice == 10) {
                sortByCategory();
            } else if (choice == 11) {
                modifyInformation();
            } else if (choice == 12) {
                sortByImportance();
            } else if (choice == 13) {
                keepRunning = false;
            } else {
                System.out.println("Invalid choice, please enter an available menu option.");

            }

        }
    }
    /**
     * Displays the main CLI menu to the user. 
     */
    private void displayMenu() {
        System.out.println("Please select an option below.");
        System.out.println("1. Display all items by time added");
        System.out.println("2. Add an item");
        System.out.println("3. Delete an item");
        System.out.println("4. Search item by item name");
        System.out.println("5. Display items by location");
        System.out.println("6. Display items by category");
        System.out.println("7. Display important items");
        System.out.println("8. Sort all items by item name");
        System.out.println("9. Sort all items by location");
        System.out.println("10.Sort all items by category");
        System.out.println("11.Modify item information");
        System.out.println("12.Sort all items by importance level in descending order");
        System.out.println("13.Exit");
    }
    /**
     * Outputs all Items in the organizer to the user. 
     */
    private void displayByTimeAdded() {
        Item[] allItems = organizer.sortByTimeAdded();
        for (int i = 0; i < allItems.length; i++) {
            System.out.println("Item name: " + allItems[i].getName());
            System.out.println("Location: " + allItems[i].getLocation());
            System.out.println("Category: " + allItems[i].getCategory());
            System.out.println("Importance: " + allItems[i].getImportance());
            System.out.println();

        }
    }
    /**
     * Helper method to output an individual Item
     * @param record the items to be output. 
     */
    private void displayItems(Item item) {
        System.out.println("Item name: " + item.getName());
        System.out.println("Location: " + item.getLocation());
        System.out.println("Category: " + item.getCategory());
        System.out.println("Importance: " + item.getImportance());
        System.out.println();
    }


    /**
     * User will enter an item name as the name of the Item they wish to
     * find, Output all information of the corresponding Item if found,
     * otherwise output a message informing the user the corresponding
     * Item does not exist.
     */
    private void searchByName() {
        Scanner inputReader = new Scanner(System.in);
        System.out.println("Please enter an item name");
        String itemName = inputReader.next();
        Item retrieved = organizer.findItem(itemName);
        if(retrieved != null){
            displayItems(retrieved);
        }else{
            System.out.println("No item with that name exists.");
        }

    }

    /**
     * Allows the user to enter all the information needed to create a new
     * Item object, once this is done, create the object and add it to
     * the ItemOrganizer object organizer.
     */
    private void addItem() {
        
        String name;
        String location;
        String category;
        boolean importance;
        
        Scanner inputReader = new Scanner(System.in);
        
        System.out.println("Please enter the name for the new item");
        name = inputReader.next();
        
        System.out.println("Please enter the location for the new item");
        location = inputReader.next();

        
        System.out.println("Please enter the category for the new item:");
        category = inputReader.next();
        
        System.out.println("Is the item important? Y/N");
        
        if(inputReader.next().equalsIgnoreCase("Y")){
            importance = true;
        }else{
            importance = false;
        }
        
        
        Item newItem = new Item(name,location,category,importance);
        
        organizer.addNewItem(newItem);
        
        System.out.println("New item added.");
        System.out.println();
        
        
    }

    /**
     * Allows the user to delete a sales record object from manager by inputting
     * the corresponding sales ID.
     */
    private void deleteItem() {
        Scanner inputReader = new Scanner(System.in);
        System.out.println("Please enter the name of the item you wish to delete:");
        String name = inputReader.next();
        organizer.deleteItem(name);
        System.out.println("Item removed");
        System.out.println();
    }

    /**
     * Allows the user to enter a location, e.g. desk, kitchen, bedside, etc. and
     * outputs the information of all Items in organizer with the same
     * location.
     */
    private void searchByLocation() {
        Scanner inputReader = new Scanner(System.in);
        System.out.println("Please enter the location you wish to search:");
        String location = inputReader.next();
        Item[] retrieved = organizer.searchByLocation(location);
        for(int i = 0; i < retrieved.length; i++){
            displayItems(retrieved[i]);
        }
        
    }
    
    /**
     * Allows the user to enter a category, and
     * outputs the information of all Items in organizer with the same
     * category.
     */
    private void searchByCategory() {
        Scanner inputReader = new Scanner(System.in);
        System.out.println("Please enter the category you wish to search:");
        String category = inputReader.next();
        Item[] retrieved = organizer.searchByCategory(category);
        for(int i = 0; i < retrieved.length; i++){
            displayItems(retrieved[i]);
        }
        
    }

    /**
     * Allows the user to search and output the information of all Item
     * objects that are important.
     */
    private void displayImportantItems() {
        Scanner inputReader = new Scanner(System.in);
        Item[] retrieved = organizer.searchByImportance(true);
        for(int i = 0; i < retrieved.length; i++){
            displayItems(retrieved[i]);
        }
    }

    /**
     * Sorts all Items by ascending alphabetic order of item name.
     */
    private void sortByName() {
        organizer.sortByName();
        System.out.println("Sales records have been sorted by item name");
        displayByTimeAdded();
    }
    
    /**
     * Sorts all Items by ascending alphabetic order of location.
     */
    private void sortByLocation() {
        organizer.sortByLocation();
        System.out.println("Sales records have been sorted by location");
        displayByTimeAdded();
    }
    
    /**
     * Sorts all Items by ascending alphabetic order of category.
     */
    private void sortByCategory() {
        organizer.sortByCategory();
        System.out.println("Sales records have been sorted by category");
        displayByTimeAdded();
    }
    
    /**
     * Sorts all Items by ascending descending order of importance level.
     */
    private void sortByImportance() {
        organizer.sortByImportance();
        System.out.println("Sales records have been sorted by importance level");
        displayByTimeAdded();
    }
    
    /**
     * Allows the user to enter modified information of an item, and
     * modify the attributes accordingly.
     */
    private void modifyInformation() {
        Scanner inputReader = new Scanner(System.in);
        System.out.println("Please enter the name of item you wish to modify:");
        String name = inputReader.next();
        System.out.println("Please enter the modified location:");
        String location = inputReader.next();
        System.out.println("Please enter the modified category:");
        String category = inputReader.next();
        System.out.println("Please enter the modified importance (Y/N):");
        boolean importance;
        if(inputReader.next().equalsIgnoreCase("Y")){
            importance = true;
        }else{
            importance = false;
        }
        
        organizer.changeItemInfo(name,location,category,importance);
        System.out.println("Item information successfully modified");
    }
        
}
    
