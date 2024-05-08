package main;
public class PrePaidCard {

	/**
	 * PrePaidCard Class:
	 * 
	 * Manages information for pre-paid cards, including type, ID, and due date.
	 * Provides methods for manipulation and comparison.
	 * 
	 * Attributes:
	 * - Type of card, unique ID, and due date (day, month).
	 * 
	 * Methods:
	 * - fixDay(): Ensures valid day for due date.
	 * - fixMonth(): Ensures valid month for due date.
	 * - toString(): Generates formatted string with card details.
	 * - cardsEqual(): Compares two PrePaidCard objects for identity.
	 *   Returns true if the objects are the same reference.
	 */
	
	// Attributes
	private String type;
	private int id;
	private int day;
	private int month;
	
	
	
	
	// Default constructor
    public PrePaidCard() {
    	this.type = "";
    	this.id = 0;
    	this.day = 0;
    	this.month = 0;
    }
    
    
    
    
    // Constructor
    public PrePaidCard(String type, int id, int day,int month) {
    	setType(type);
    	setId(id);
    	setDay(day);
    	setMonth(month);
    	
    }
    
    
    
    
    // Copy constructor (with one parameter of type PrePaidCard)
    public PrePaidCard(PrePaidCard other) {
    	
    	type = other.type;
    	id = other.id;
    	day = other.day;
    	month = other.month;
    	
    }
    
    
	
    
	// Accessors (gets)
    public String getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    

    
    // Mutators (sets)
    public void setType(String type) {
        this.type = type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDay(int day) {
        if (day < 0 || day > 31) {
        	day = 0;
        } else {
        	this.day = day;
        }
    }

    public void setMonth(int month) {
        if (month < 1 || month >12) {
        	month = 0;
        } else {
        	this.month = month;
        }
    }

    
    
    
    // Methods
    
    // Method fixDay(): for the due date
    public int fixDay(int day) {
    	if (day < 1 || day > 31) {
    		day = 0;
    	} else {
    		this.day = day;
    	}
		return day;
    }
    
    
    
    
    // Method fixMonth(): for the due month
    public int fixMonth(int month) {
    	if (month < 1 || month > 12) {
    		month = 0;
    	} else {
    		this.month = month;
    	}
		return month;
    }
		
    
    
    
    // Method toStringPrePaidCard() : to return a string indicating the type of the pre-paid card, the name of the owner and the due date
    public String toString() {
    	
    	String day1 = "";
    	String month1 = "";
    	
    	
    	if (day < 10) {
    		day1 += "0" + day;
    	} else {
    		day1 += day;
    	}

    	if (month < 10) {
    		month1 += "0" + month;
    	} else {
    		month1 += month;
    	}
    	String result = type + " - " + id + " - " + day1 + "/" + month1 + ".";
    	
    	return result;

    }
    
    
    
    
    // Method cardsEqual () : to return true if 2 objects of type PrePaidCard are identical
    
    public boolean cardsEqual(PrePaidCard card1, PrePaidCard card2) {
    	boolean cardsEqual = false;
    	if (card1 == card2) {
    		cardsEqual = true;
    	} else {
    		cardsEqual = false;
    	}
    	return cardsEqual;
    }
    
		
}


