/*
 * Made by Magne Torbjørnrød
 * student nr 111096
 * email, magnegt@gmail.com/ usn@111096.no
 * last updated 29.10.20
 */
/* Implementation of a card type */
public class Card {
 /* one of the four valid suits for this card */
	private Suit mySuit;
 /* The number og hits, where Ace: 1, Jack-King: 11-13 */	
	private int myNumber;
 /* Card constructor
  * aSuit is the suit of the card
  * aNumber is the number of the card	
  */
	public Card(Suit aSuit, int aNumber) {
	
		this.mySuit = aSuit;
		
		if (aNumber >= 1 && aNumber <= 13) { /* if the card is negative */
			this.myNumber = aNumber;
		} else {
			System.err.println(aNumber + "is not a valid Card number");
			System.exit(1);
		}
		}
 /* Returns the number og the card */
	public int getNumber() {
		return myNumber;
	}
/* toString returns number and the suit of the card */
	public String toString () {
		
		String numStr = "Error";
		
		switch(this.myNumber) {
		
		case 2:
			numStr = "Two";
			break;
			
		case 3:
			numStr = "Three";
			break;
		
		case 4:
			numStr = "Four";
			break;
		
		case 5:
			numStr = "Five";
			break;
		
		case 6:
			numStr = "Six";
			break;
		
		case 7:
			numStr = "Seven";
			break;
		
		case 8:
			numStr = "Eight";
			break;
		
		case 9:
			numStr = "Nine";
			break;
		
		case 10:
			numStr = "Ten";
			break;
		
		case 11:
			numStr = "Jack";
			break;
		
		case 12:
			numStr = "Queen";
			break;
		
		case 13:
			numStr = "King";
			break;
		
		case 1:
		    numStr = "Ace";
			break;
			
		}
		
		return numStr + " of " + mySuit.toString();
	
	}	
}
