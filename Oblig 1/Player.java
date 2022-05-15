/*
 * Made by Magne 
 * 
 * last updated 29.10.20
 */
/* implementering av spilleren */

public class Player {
	
	/*
	 * spillerens navn
	 */
	private String name;
	/*
	 * kortene i spillerens hand
	 *  maks mengde på 10 kort 
	 */
	private Card[] hand = new Card[10]; 
	/*
	 * antall kort i spillerens hand
	 */
	private int numCards;

	/* 
	 * navnet på spilleren
	 */
	public Player(String aName) {
		
		this.name = aName;
		
		// Spilleren har en tom hand
		this.emptyHand();	
	}
	/* resetter spillerens hand til å inneholde 0 kort
	 */
	public void emptyHand() {


		
		for (int c = 0; c < 10; c++) {
			this.hand[c] = null;
		}
		this.numCards = 0;
			
	}
	
	/*
	 * legger ett kort til i spillerens hand
	 * aCard
	 */
	public boolean addCard(Card aCard) {
		
		// printer error om spiller allerede har max antall kort 
		if (this.numCards == 10) {
			System.err.printf("%s's hand already has 10 cards; " +
		             "cannot add another\n", this.name);
			System.exit(1);
		}
		// Legger til nytt kort i neste hand..icrementer med 1 kort
		this.hand[this.numCards] = aCard;
		this.numCards++;
		
		return (this.getHandSum() <= 21);
	}
	
	/* summen av kort i spillerens hand
	 * implementerer reglene i blackjack
	 * 
	 */
	public int getHandSum() {
		
		int handSum = 0;
		int cardNum;
		int numAces = 0;
		
		// kalkulerer hvert korts bidrag til hånden
		for (int c= 0; c < this.numCards; c++) {
			
			// Får nummeret til gjeldende kort
			cardNum = this.hand[c].getNumber();
			
			if (cardNum == 1) { // Ace
				numAces++;
				handSum += 11;
				
			} else if (cardNum > 10) {//billedkort jack-queen-king
			    handSum += 10;
			} else {
				handSum += cardNum;
			}
		}
		// hvis we har Ace og summen vår er over 21.
		// setter verdi 1 istede
		while (handSum > 21 && numAces > 0) {
			handSum -= 10;
			numAces--;
		}
		
		return handSum;		
	}	
	
	/* printer kortene i spillerens hånd
	 * 
	 * showFirstCard selv om første kort er skjult
	 * 
	 */
	public void printHand(boolean showFirstCard) {
	
		System.out.printf("%s's cards:\n", this.name);
		for (int c = 0; c < this.numCards; c++) {
			if (c == 0 && !showFirstCard) {
				System.out.println("  [hidden]");
			} else {
				System.out.printf("  %s\n", this.hand[c].toString());
			}
		}
	}
	
}

