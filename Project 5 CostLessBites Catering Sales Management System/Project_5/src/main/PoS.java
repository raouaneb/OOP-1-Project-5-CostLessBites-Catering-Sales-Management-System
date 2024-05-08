package main;

public class PoS {

	/**
	 * PoS Class:
	 * 
	 * Manages Point of Sale (PoS) information, including meal sales and pre-paid cards.
	 * Provides methods for sales comparison, card manipulation, and information retrieval.
	 * 
	 * Attributes:
	 * - Sales object for meal sales.
	 * - Array of PrePaidCard objects for pre-paid cards.
	 * 
	 * Methods:
	 * - totalValueOfSales(): Compares total sales values of two PoS objects.
	 * - salesBreakdown(): Compares meal sales breakdown of two PoS objects.
	 * - salesTotalPoS(): Returns the total $ sales of a PoS.
	 * - numberPrePaidCards(): Returns the number of pre-paid cards in a PoS.
	 * - appendPrePaidCard(): Adds a new PrePaidCard to the PoS.
	 * - removePrePaidCard(): Removes a pre-paid card from the PoS.
	 * - updateExpiryDate(): Updates the expiry date of a pre-paid card.
	 * - appendMealSales(): Adds meal sales to the PoS.
	 * - compareTotalAmount(): Compares total $ amount sales value and the number of pre-paid cards with another PoS object.
	 * - toString(): Generates a string indicating the number of each meal sales category and the details of each pre-paid card.
	 */
	
	
	
	// Attributes
	Sales sales;
	private PrePaidCard[] cards; // array
	
	
	
	
	// Default Constructor
	public PoS() {
		this.sales = null;
		this.cards = null;			
	}
	
	
	
	
	// Constructor
	public PoS(Sales meals, PrePaidCard[] cards) {
		this.sales = meals;
		this.cards=cards;
	}
	
	
	
	
	// Accessor (get) for the sales 
	public Sales getMeals() {
		return sales;
	} 
	
	// Accessor (get) for the array of cards
	public PrePaidCard[] getCards() {
	    
		// Create a temporary array to hold a copy of the 'cards' array
		PrePaidCard [] temp = new PrePaidCard[cards.length];
		
	    // Copy each element from the original 'cards' array to the temporary array
		for(int i=0;i<cards.length;i++)
		{
			temp[i]=cards[i];
		}
		
		return temp;	// Return to the copied array
	}
	
	
	
	
	// Methods:
	
	// Method totalValueOfSales(); for returning true if total $ value of sales of 2 PoS are equal
	public boolean totalValueOfSales(PoS pos) {
		
		boolean totalEquals = false;
		
		if (this.sales.salesTotal()== pos.sales.salesTotal()) {
			totalEquals = true;
		} else {
			totalEquals = false;
		} 
		
		return totalEquals;
	
		
	}
	
	
	
	
	// Method salesBreakdown(): for returning true if the number of each sales category 
	// of two PoS objects are equal
    public boolean salesBreakdown(PoS sales1){
        
    	boolean salesEqual = false;
    	
    	if (this.sales.equals(sales1.sales)) {
            salesEqual = true;
        } else {
        	salesEqual = false;
        }
        
    	return salesEqual;
        
    }
    

    
    
    // Method salesTotalPoS():  to return the total $ sales of a PoS
    public int salesTotalPoS(){
        return this.sales.salesTotal();
    }

    
    
    
    // Method numberPrePaidCards(): to return the number of pre-paid cards in a PoS
    public int numberPrePaidCards() {
        return cards.length;
    }
    
    
    
    
    // Method appendPrePaidCard(): to add a new PrePaidCard to the PoS
    public int appendPrePaidCard(PrePaidCard newCard) {
        
    	// Create a new array with increased length
    	PrePaidCard[] updatedCards = new PrePaidCard[this.cards.length + 1];
        
        // Copy existing cards to the new array
        for (int i = 0; i < this.cards.length; i++) {
            updatedCards[i] = this.cards[i];
        }

        // Add the new card to the end of the updated array
        updatedCards[updatedCards.length - 1] = newCard;
        this.cards = updatedCards;	// Update the reference to the array in the PoS


        return numberPrePaidCards();	// Return the count of PrePaidCards
    }
    
    
    
    
    // Method removePrePaidCard(): to remove pre-paid card from the PoS
    public boolean removePrePaidCard(PrePaidCard card) {
    	boolean cardRemoved = false;

        // Check if the array is empty
        if (cards.length == 0) {
            cardRemoved = false;
        } else {
        	// Find the index of the card in the array
        	int index = -1;  // Initialize index to identify if the card is found

            for (int i = 0; i < cards.length; i++) {
                if (cards[i].equals(card)) {
                    index = i;  // Set index if card is found
                    break;  // Exit the loop once the card is found
                }
            }
            // Remove the card if found
            if (index != -1) {
                for (int j = index; j < cards.length - 1; j++) {
                    cards[j] = cards[j + 1];
                }
                
                // Create a new array without the removed card
                PrePaidCard[] newCardArray = new PrePaidCard[cards.length - 1];
                for (int k = 0; k < newCardArray.length; k++) {
                    newCardArray[k] = cards[k];
                }
                cards = newCardArray;
                cardRemoved = true;
            }
        }

        return cardRemoved;
    }
    
    
    
    
    // Method updateExpiryDate(): to update the expiry date of a pre-paid card
    public void updateExpiryDate(PrePaidCard cards, int newExpiryDay, int newExpiryMonth)
    {
        cards.setDay(newExpiryDay);
        cards.setMonth(newExpiryMonth);
    }
    
    
    
    
    // Method appendMealSales(): to add meals sales to the PoS
    public int appendMealSales(int junior, int teen, int medium, int big, int family)
    {
        sales.addSales(junior, teen, medium, big, family);
        return sales.salesTotal();
    }
    
    
    
    
    // Method totalAmount(): to return true if total $ amount sales value and the number of pre-paid card 
    // of 1 PoS objects are equal
    public boolean compareTotalAmount(PoS otherPoS) {
    		boolean amountEquals= false;
    		if (salesTotalPoS()==otherPoS.salesTotalPoS() && numberPrePaidCards()==otherPoS.numberPrePaidCards())
    		{
    			amountEquals=true;
    		}
    		else
    		{
    			amountEquals= false;
            }
    		return amountEquals;
    	}
    
    
    
    
    // Method toStringPoS(): for returning a string indicating the number of each meal sales category 
    // and the details of each pre-paid card of the PoS
    public String toString()
    {
        String stringCard = ""; // Initialization
        
        // Check if there are any pre-paid cards. If so, add its details.
        if (cards.length==0)
        {
            stringCard = "\nNo PrePaidCards";
        }
        else
        {
            // Iterate through each pre-paid card and add its details.
            for (int i=0; i<cards.length; i++)
            {
                stringCard += "\n" + cards[i].toString();
            }
        }
        // Combine meal sales and pre-paid card details.
        String string = sales.toString()+stringCard;
        return string;
    }

    public String salesBreakdown() 
    {
        return sales.toString();
    }
    
    
    
    
}
    