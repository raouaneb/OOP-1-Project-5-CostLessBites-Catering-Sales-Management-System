package main;

public class Sales {
	/**
	 * Sales Class:
	 * 
	 * Manages sales data for different meal categories in a Point of Sale (PoS).
	 * Provides methods for manipulation and comparison.
	 * 
	 * Attributes:
	 * - Counts for junior, teen, medium, big, and family meals.
	 * 
	 * Static Constants:
	 * - Meal prices for each category.
	 * 
	 * Methods:
	 * - addSales(): Increases meal category counts.
	 * - salesTotal(): Calculates and returns total sales value.
	 * - toString(): Generates formatted meal count string.
	 * - salesEqual(): Compares two Sales objects based on meal category breakdown.
	 *   Returns true if the breakdowns are the same.
	 */
	
	
	// Attributes
	private int junior;
    private int teen;
    private int medium;
    private int big;
    private int family;

    
    
    
    // Static constants for the values of the sales
    public static final int JUNIOR_PRICE = 5;
    public static final int TEEN_PRICE = 10;
    public static final int MEDIUM_PRICE = 12;
    public static final int BIG_PRICE = 15;
    public static final int FAMILY_PRICE = 20;

    
    
    
    // Default constructor
    public Sales () {
    	this.junior = 0;
    	this.teen = 0;
    	this.medium = 0;
    	this.big = 0;
    	this.family = 0;
    }
    
    
    
    
    // Constructor
    public Sales(int junior, int teen, int medium, int big, int family) {
    	this.junior = junior;
    	this.teen = teen;
    	this.medium = medium;
    	this.big = big;
    	this.family = family;
    		
    }
    
    
    
    
    // Copy constructor
    public Sales(Sales other) {
        junior = other.junior;
        teen = other.teen;
        medium = other.medium;
        big = other.big;
        family = other.family;
    	
    }

    
    
    
    // Accessors (gets)
    public int getJunior() {
        return junior;
    }

    public int getTeen() {
        return teen;
    }

    public int getMedium() {
        return medium;
    }

    public int getBig() {
        return big;
    }

    public int getFamily() {
        return family;
    }


    
    
    // Mutators (sets)
    public void setJunior(int junior) {
        this.junior = junior;
    }

    public void setTeen(int teen) {
        this.teen = teen;
    }

    public void setMedium(int medium) {
        this.medium = medium;
    }

    public void setBig(int big) {
        this.big = big;
    }

    public void setFamily(int family) {
        this.family = family;
    }

    
    
    // Methods
    
    // Method addSales() : to increase the number of each meal category by the indicated number
    public void addSales(int junior, int teen, int medium, int big, int family) {
        this.junior += junior;
        this.teen += teen;
        this.medium += medium;
        this.big += big;
        this.family += family;
    }

    
    
    
    // Method salesTotal() : to return an integer indicating the total value of the sales in the PoS
    public int salesTotal() {
        return (junior * JUNIOR_PRICE) + (teen * TEEN_PRICE) + (medium * MEDIUM_PRICE) + (big * BIG_PRICE) + (family * FAMILY_PRICE);
    }

    
    
    
    // Method toStringMeals() : to return a string indicating the count of each meal with a given format
    public String toString() {
        return junior + " x $" + JUNIOR_PRICE + " + " + teen + " x $" + TEEN_PRICE + " + " + medium + " x $" + MEDIUM_PRICE + " + " + big + " x $" + BIG_PRICE + " + " + family + " x $" + FAMILY_PRICE;
    }

    
    
    
    // Method salesEqual() : to return true if the two objects of the type Sales being compared have the same breakdown of meal category
    public boolean salesEqual(Sales sales1, Sales sales2) {
        boolean salesEqual = false;	// Initialization
       
    	if (sales1 == sales2) {	// Check if the objects are the same reference
            salesEqual = true;
        } else if (sales2 == null || getClass() != sales2.getClass()) {
        	salesEqual = false;
        }
    	
    	return salesEqual;
       
    }
}
