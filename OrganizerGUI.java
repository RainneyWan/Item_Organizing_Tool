package itemOrganizer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import itemOrganizer.Item;
import itemOrganizer.ItemOrganizer;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author w
 */
public class OrganizerGUI {
	// ItemOrganizer as our instance variable, it is used to process data we pass in from the GUI.
    protected ItemOrganizer myOrganizer;
    // The constant used to separate individual attributes read from records in the text file
    private static final String SEPARATOR = ",";
    
    public ItemOrganizer getOrganizer() {
    	return myOrganizer;
    }

    /**
     * Constructor used to initialize the organizer and read the text input.
     */
    public OrganizerGUI() {
        // Instantiate the back end by initializing the ItemOrganizer variable organizer.
        myOrganizer = new ItemOrganizer();
        // An attempt will be made to open the CSV file storing the item data, and read the data into the organizer.
        try {
            // A built in Scanner object is used to open the file Items.csv
            Scanner textScanner = new Scanner(new File("Items.csv"));
            // The Scanner object textScanner will check each line in the file, stopping when there are no more lines. 
            while (textScanner.hasNextLine()) {
                // Reads the next line and store it into a string
                String nextLine = textScanner.nextLine();
                String[] separatedRecord = nextLine.split(SEPARATOR);
                // Each attribute has been separated, but since they are stored in a String[] all values are still Strings
                String name=separatedRecord[0];
                String location=separatedRecord[1];
                String category = separatedRecord[2];
                // Convert "Yes" or "No" in the array separatedRecord to true/false. 
                boolean important = false;
                if (separatedRecord[3].equals("yes")) {
                    important = true;
                }
                // Create a new SalesRecord object using the values we have retrieved and processed from the text file.  
                Item newItem = new Item(name, location, category, important);
                // Add the newly instantiated Items to the manager using the ItemOrganizer method
                myOrganizer.addNewItem(newItem);
            }
            System.out.println("System initialized");
            // the following will output an error if the file is not found, 
            // but because we are using a try - catch block, we will not crash the program.  
        } catch (FileNotFoundException ex) {
            System.out.println("Error file not found");
        }

    }
}
