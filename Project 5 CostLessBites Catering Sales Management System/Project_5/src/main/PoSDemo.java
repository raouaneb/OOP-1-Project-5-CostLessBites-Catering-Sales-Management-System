package main;

import java.util.Scanner;

public class PoSDemo {
	
	/**
	 * CostLessBites Catering Sales Counter Algorithm:
	 * 
	 * This program simulates the Point of Sale (PoS) for CostLessBites catering,
	 * managing on-demand sales and prepaid card transactions. Users interact through a menu,
	 * performing actions such as displaying PoS content, listing PoSs with similar characteristics,
	 * adding and removing prepaid cards, updating card expiry dates, and adding sales.
	 * 
	 * Main Steps:
	 * 
	 * 1. Display a welcome message for the CostLessBites Catering Sales Counter application.
	 * 
	 * 2. Create instances of PoS with different sales categories and associated prepaid cards.
	 * 
	 * 3. Use a menu-driven loop to continuously prompt the user for actions until choosing to quit (0).
	 *    - Display a menu with options to view, list, and modify PoSs, add prepaid cards, and add sales.
	 * 
	 * 4. Implement methods for each menu option, focusing on user interactions and high-level actions.
	 *    - Options include displaying PoS content, listing PoSs with similar characteristics,
	 *      adding and removing prepaid cards, updating card expiry dates, and adding sales to PoS.
	 * 
	 * 5. Ensure validation checks for user inputs, providing feedback for invalid choices.
	 * 
	 * 6. Display closing messages and exit the program when the user chooses to quit.
	 */
	
	
	
	// Methods (before main):
	
	// Method that displays a prompting message which presents a menu to the user
	static void displayPromptingMessage(){
		System.out.print("| What would you like to do?							|\n|"
				+ " 1 >> See the content of all PoSs						|\n|"
				+ " 2 >> See the content of one PoS						|\n|"
				+ " 3 >> List PoSs with same $ amount of sales					|\n|"
				+ " 4 >> List PoSs with same number of Sales categories				|\n|"
				+ " 5 >> List PoSs with same $ amount of Sales and same number of prepaid cards	|\n|"
				+ " 6 >> Add a PrePaidCard to an existing PoS					|\n|"
				+ " 7 >> Remove an existing prepaid card from a PoS				|\n|"
				+ " 8 >> Update the expiry date of an existing Prepaid card			|\n|"
				+ " 9 >> Add Sales to a PoS							|\n|"
				+ " 0 >> To quit									|\n"
				+ "+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n"
				+ "Please enter your choice and press <Enter>: ");
	}

	
	
	// Method to get the user's selected choice of menu action
	static int getUserAction(Scanner input) {
		int selectedAction  = 0;

		// Continuously prompt the user until a valid choice is entered
	do {
		// Prompt the user to select an action from the menu
		displayPromptingMessage();
		selectedAction = input.nextInt();
		verifyActionChoice(selectedAction); // validate the choice
	
	} while(!isValidActionChoice(selectedAction));
	return selectedAction; // return the selected action
	}

	
	
	// Method to check if the selected action falls within the valid range (0 to 9)
	static boolean isValidActionChoice(int selectedAction){
		return ((selectedAction < 0 || selectedAction > 9) ? false : true);
	}

	
	// Method to check if the selected action is valid and request another entry if not
	static void verifyActionChoice(int selectedAction) {
		if(!isValidActionChoice(selectedAction)) {
			System.out.print("Sorry that is not a valid choice. Try again.\n");
		}

	}

	
	
	
	// Methods for actions that appear in the menu (1-9)
	
	// Option 1: Display of the content of all PoSs 
	static void displayAllPoSs(PoS[] PoSs) {
		System.out.println("\nContent of each PoS: " + "\n---------------------");
		for(int i=0; i<PoSs.length; i++) {
			System.out.print("\nPoS #" + i + ":\n" + PoSs[i].toString() + "\n\n");
		}
	}

	
	
	// Option 2: Display content of one PoS
	static void displayOnePos(Scanner userInput, PoS [] PoSs) {
		
		// Prompt the user to enter a PoS index
		System.out.print("Which PoS you want to see the content of? (Enter number 0 to 4): ");
		
		// Displays content of selected PoS
		int posIndex = userInput.nextInt();
		while(!validatePoSIndex(posIndex)) {
			System.out.print("Sorry but there is no PoS number " + posIndex + "\n--> Try again: (Enter number 0 to 4): "); // if number is invalid
			posIndex = userInput.nextInt();
		}
		
	System.out.print(PoSs[posIndex].toString()+ "\n\n");

	}

	
	// Validate if the selected PoS choice falls within the valid range (0 to 4)
	static boolean validatePoSIndex(int index) {
		return (index < 0 || index > 4) ? false : true;
	}
	
	
	// Validate the chosen PoS index and request re-entry if invalid
	static int validatePoSChoice(Scanner userInput) {
		int index = userInput.nextInt(); // validates the input
		
		// Continue looping until a valid PoS index is entered
		while(!validatePoSIndex(index)) {
			System.out.print("Sorry there is no PoS number " + index + "\n----> Please try again: "); // if PoS is invalid
			index = userInput.nextInt(); // Prompt the user to enter a valid PoS index
		}
	return index; // return the validated PoS index
	}

	
	
	
	// Option 3: Display PoSs with the same amount of sales
	static void displaySameSalesAmountPoSs(PoS [] PoSs) {	
		System.out.print("\nList of the PoSs with the same total $ sales: \n");
		
		// Iterate through each PoS
		for(int j = 0 ; j < PoSs.length ; j++) {
			// Compare with subsequent PoSs	
			for (int i = j + 1 ; i < PoSs.length ; i++) {
				// Check if the total sales value of the current PoS equals the total sales value of the compared PoS	
				if (PoSs[i].totalValueOfSales(PoSs[j])) {
						int index1 = j;
						int index2 = i;
						// Display the indices of PoSs with the same total sales and common sales amount
						System.out.print("\n	PoSs " + index1 + " and " + index2 + " both have " + PoSs[i].salesTotalPoS());

				}
			}
		}	
		System.out.print("\n\n");
	}

	
	
	
	
	// Option 4: Display PoSs with the same Sales categories
	static void displaySameSalesCategoriesPoS(PoS [] PoSs) {
		System.out.print("\nList of the PoSs with the same sales categories: \n");
		
		// Iterate through each PoS
		for(int j = 0 ; j < PoSs.length ; j++) {
			// Compare with subsequent PoSs
			for(int i = j + 1 ; i < PoSs.length ; i++){
				// Check if the sales categories of the current PoS equal the sales categories of the compared PoS
				if(PoSs[i].compareTotalAmount(PoSs[j])) {
					int index1 = j;
					int index2 = i;
					
					// Display the indices of PoSs with the same sales categories
					System.out.print("\n	PoSs "+index1+" and "+index2+" both have "+ PoSs[i].sales.toString());
				}

			}

		}
		System.out.print("\n\n");
	}

	
	
	
	// Option 5: Display the same sales amount and the same number of prepaid cards
	static void displaySamePoS(PoS [] PoSs) {
		System.out.print("\nList of PoSs with same $ amount of sales and same number of PrePaiCards :\n");
		
		// Iterate through each PoS
		for(int j = 0 ; j < PoSs.length ; j++) {
			// Compare with subsequent PoSs
			for(int i = j + 1 ; i < PoSs.length ; i++) {	
	            // Check if the total sales amount and the number of pre-paid cards are identical
				if(PoSs[i].compareTotalAmount(PoSs[j])) {
					int index1 = j;
					int index2 = i;
	                // Display the indices of PoSs with the same sales amount and pre-paid cards count
					System.out.print("\n	PoSs "+index1+" and "+index2);
				}

			}

		}

		System.out.print("\n\n");
	}

	
	
	// Check if a PoSs has no pre-paid cards
	static boolean hasNoPrePaidCard(PoS [] PoSs,int index) {
	    // Determine if the PoS at the given index has no pre-paid cards
		boolean noCard =(PoSs[index].numberPrePaidCards()==0)?true:false;
		return noCard;

	}

	
	// Validate the choice of the pre-paid card for the removal
	static int validatePrePaidCardChoice(Scanner input, PoS[] PoSs,int index) {
	    // Get the user's choice for the pre-paid card removal

		int cardIndex = input.nextInt();
		
	    // Validate the choice and prompt for re-entry if invalid
		while(cardIndex < 0 || cardIndex > PoSs[index].numberPrePaidCards()-1) {
			System.out.print("Sorry there is no PrePaidCard number " + cardIndex + "\n----> Please try again: ");
			cardIndex = input.nextInt();
		}
		return cardIndex;
	}

	
	
	
	// Option 6: Add a PrePaidCard to an existing PoS
		static void addPrePaidCard(Scanner userInput, PoS[] pos) {
			
		    // Prompt the user to select a PoS
			System.out.print("Which PoS to you want to add a PrePaiCard to? (Enter number 0 to 4): ");
			
		    // Validate and get the PoS index
			int index = validatePoSChoice(userInput);
			
		    // Prompt the user to enter PrePaidCard information
			System.out.println("\nPlease enter the following information so that we may complete the PrePaiCard-\n"
			+ " --> Type of PrePaiCard (Carnivore, Halal, Kosher, Pescatarian, Vegetarian, Vegan): ");
			
		    // Get PrePaidCard type
			String type = userInput.next();
			
		    // Get PrePaidCard owner's ID
			System.out.print(" --> Id of the prepaid card owner: ");
			int id = userInput.nextInt();
			
		    // Get PrePaidCard expiry day and month
			System.out.print(" --> Expiry day number and month (seperate by a space): ");
			int day = userInput.nextInt();
			int month = userInput.nextInt();

		    // Create a new PrePaidCard
			PrePaidCard cardToAdd = new PrePaidCard(type,id,day,month);

		    // Display the updated number of PrePaidCards
			System.out.print("\nYou now have "+pos[index].appendPrePaidCard(cardToAdd)+" PrePaidCard\n");
			System.out.println();

		    }

	
	
	
	
	// Option 7: Remove an existing prepaid card from a PoS
	static void removePrePaidCard(Scanner userInput,PoS[] pos) {
	    
		// Prompt the user to select a PoS
		System.out.print("Which PoS do you want to remove a PrePaiCard from? (Enter number 0 to 4): ");
		int index = validatePoSChoice(userInput);
		
		if(hasNoPrePaidCard(pos,index)) {
	        // Inform the user if the PoS has no PrePaidCard
			System.out.print("Sorry that PoS has no PrePaidCard\n");
			System.out.println();
		} else {
	        // Prompt the user to select a PrePaidCard from the PoS
			System.out.print("(Enter number 0 to "+(pos[index].numberPrePaidCards()-1)+"): ");
			int index2 = validatePrePaidCardChoice(userInput,pos,index);
			
			boolean success = true;
			PrePaidCard [] prePaidCard = pos[index].getCards();
	        // Attempt to remove the selected PrePaidCard
			success = pos[index].removePrePaidCard(prePaidCard[index2]);
			
	        // Display success or failure message
			if(success ==true) {
				System.out.println("PrePaidCard was removed successfully\n");
			} else {
				System.out.println("PrePaidCard was not removed\n");

			}

		}

	}

	
	
	
	
	// Option 8: Update the expiry date of an existing Prepaid card
	static void updatePrePaidCard(Scanner input, PoS [] pos) {
	    
		// Prompt the user to select a PoS
		System.out.print("Which PoS do you want to update a PrePaidCard from? (Enter number 0 to 4): ");
		
		int index = validatePoSChoice(input);
		
		if(pos[index].numberPrePaidCards() == 0) {
	        // Inform the user if the PoS has no PrePaidCard
			System.out.print("There is no PrePaidCard\n");
			System.out.println();
			
		} else {
	        // Prompt the user to select a PrePaidCard from the PoS
			System.out.println("\nWhich PrePaiCard do you want to update? (Enter number 0 to "+(pos[index].numberPrePaidCards()-1)+"): ");
			int index2 = validatePrePaidCardChoice(input,pos,index);
			PrePaidCard [] prePaidCards = pos[index].getCards();
			
	        // Prompt the user to enter a new expiry date for the PrePaidCard
			System.out.print(" --> Enter new expiry date day number and month (seperate by a space): ");
			int day1 = input.nextInt();
			int month1 = input.nextInt();
			
	        // Update the expiry date of the selected PrePaidCard
	        pos[index].updateExpiryDate(prePaidCards[index2], day1, month1);
			System.out.println("Expiry Date updated.\n");
		}

	}

	
	
	
	// Option 9 : Method to add sales to a PoS
	static void appendSales(Scanner input, PoS [] PoSs) {
	    // Prompt the user to select a PoS
		System.out.print("Which PoS do you want to add Sales to? (Enter number 0 to 4): ");
		int index =validatePoSChoice(input);
		
	    // Prompt the user to enter the number of meals to add
		System.out.print("How many junior, teen ,medium,big and family meal menu do you want to add?\n"
						+ "Enter 5 numbers seperated by a space): ");
		
	    // Get the number of meals for each category
		int junior_number = input.nextInt();
		int teen_number = input.nextInt();
		int medium_number = input.nextInt();
		int big_number = input.nextInt();
		int family_number = input.nextInt();
		
	    // Add the specified number of meals to the selected PoS
		PoSs[index].appendMealSales(junior_number, teen_number, medium_number, big_number, family_number);
		
	    // Display the updated total sales for the PoS
		System.out.println("You now have $"+PoSs[index].salesTotalPoS()+ ".0" + "\n");

	}

	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {

		// Display of a welcome message.
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println("| Welcome to Concordia CostLessBites Catring Sales Counter Application		|");
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		
			
		// Scanner for user input
		Scanner scanner = new Scanner(System.in);
		int choice=0;
		
		
		// Creating PoSs instances with different categories	
			
			// PoS Sales Categories
		Sales sale1 = new Sales(2,1,0,4,1); // same sale category distribution
		Sales sale2 = new Sales(2,1,0,4,1); // same sale category distribution
		Sales sale3 = new Sales(0,1,5,2,0);
		Sales sale4 = new Sales(3,2,4,1,2);

		
		
			// PrePaidCards associated with each PoS
		PrePaidCard card1 = new PrePaidCard("Vegetarian", 40825164,25,12);
		PrePaidCard card2 = new PrePaidCard("Carnivore",21703195,03,12);
		PrePaidCard card3 = new PrePaidCard("Vegan",40825164,7,12);
		PrePaidCard card4 = new PrePaidCard("Vegetarian", 21596387,24,8);
		PrePaidCard card5 = new PrePaidCard("Pescarian",9543206,1,6);
		PrePaidCard card6 = new PrePaidCard("Halal",42087913,18,12);
		PrePaidCard card7 = new PrePaidCard("Kosher",40735421,5,4);

		
		
		
		// Configurations of PrePaiCards
		
		// PrePaidCards arrays
		PrePaidCard [] cards1 = {card1,card2};
		PrePaidCard [] cards2 = {card3,card4};
		PrePaidCard [] cards3 = {card5,card6,card7};
		PrePaidCard [] cards4 = {}; // empty pre-paid card
		
		
		// PoS instances associated with sales and prepaid cards
		PoS pos0 = new PoS(sale1,cards1);
		PoS pos1 = new PoS(sale1,cards2);
		PoS pos2 = new PoS(sale2,cards3);
		PoS pos3 = new PoS(sale4,cards4);
		PoS pos4 = new PoS(sale4,cards4);
		
		PoS [] PoSs = {pos0,pos1,pos2,pos3,pos4};
		
		

		
	// Process user's actions until exiting the program
	do {
	    // Get user's choice from the menu
	    choice = getUserAction(scanner);

	    // Perform actions based on user's choice
	    switch (choice) {
	        case 1:
	            displayAllPoSs(PoSs);
	            break;
	        case 2:
	            displayOnePos(scanner, PoSs);
	            break;
	        case 3:
	            displaySameSalesAmountPoSs(PoSs);
	            break;
	        case 4:
	            displaySameSalesCategoriesPoS(PoSs);
	            break;
	        case 5:
	            displaySamePoS(PoSs);
	            break;
	        case 6:
	            addPrePaidCard(scanner, PoSs);
	            break;
	        case 7:
	            removePrePaidCard(scanner, PoSs);
	            break;
	        case 8:
	            updatePrePaidCard(scanner, PoSs);
	            break;
	        case 9:
	            appendSales(scanner, PoSs);
	            break;
	    }
	} while (choice != 0);

	// Display of a closing message
	System.out.print("Thank you for using Concordia CostLessBites Catering Sales Counter Application!");


	}
}
