/*
 * Made by Magne Torbjørnrød
 * student nr 111096
 * email, magnegt@gmail.com/ usn@111096.no
 * last updated 29.10.20
 */
import java.util.Random;
/* En implementering av en bunke med kort "52 kort" */

public class Deck {

/* Array av kort i bunken, hvor top kortet er i første index */
	private Card[] myCards;
/* Antall kort som er i bunken */
	private int numCards;
	
	public Deck() {
		
		// definerer en bunke uten å stokke den
		this(1, false);
	}
/* constructor that defines the number of decks (each has 52 cards)
 * and also wether the deck should be shuffled
 * numDeck -- the number of individual decks in this deck
 * shuffle -- wether to shuffle the cards	
 */
	public Deck(int numDecks, boolean shuffle) {

		
		
	
		this.numCards = numDecks * 52;
		this.myCards = new Card[this.numCards];
		
		    // init card index
		int c = 0;
		
            // for each deck
		for (int d = 0; d < numDecks; d++) {
			
			  // for each suit
		  for (int s = 0; s < 4; s++) {
		
			    // for each number
		    for (int n = 1; n <= 13; n++) {	
		
		          //add a new card to the deck
			  this.myCards[c] = new Card(Suit.values()[s], n);
			c++;
	}		
   }
  }
		
		// stokker kortene hvis nødvendig
		if (shuffle) {
			this.shuffle();
		}
	}
 
/* stokker kortene ved å tilfeldig bytte par med kort */
    public void shuffle() {
    	
    	// initialiserer tilfeldig nummer generator 
    	Random rng = new Random();
    	
    	// midlertidig kort
    	Card temp;
    	
    	int j;
    	for (int i = 0; i < this.numCards; i++) {
    		
    		// tilfeldig kort j bytter i`s verdi
    		j = rng.nextInt(this.numCards);
    		
    		// gjør bytting
    		temp = this.myCards[i];
    		this.myCards[i] = this.myCards[j];
    		this.myCards[j] = temp;
    	
    		
    	}
    	   } 
    	
    /* deal the next card from the top of the deck 
     * return the dealt card
     */
    public Card dealNextCard() {
    	
    	// får top kortet
    	Card top = this.myCards[0];
    	
    	// shift the rest of the cards to the left by one index
    	for (int c = 1; c < this.numCards; c++) {
    		this.myCards[c-1] = this.myCards[c];
    	}
    	this.myCards[this.numCards-1] = null;
    	
    	// decrement the number of cards in our deck
    	this.numCards--;
    	return top;
}
 /* print the top cards in the deck 
  * 
  * numToPrint the number of cards from the top of the deck to print
  */
    public void printDeck(int numToPrint) {
    	
    	for (int c = 0; c < numToPrint; c++) {
    		System.out.printf("% 3d/%d %s\n", c+1, this.numCards,
    				this.myCards[c].toString());
    	}
    	System.out.printf("\t\t[%d others]\n", this.numCards-numToPrint);
    	
}
    }  	
        
 
