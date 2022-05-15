/*
 * Made by Magne 
 * student 
 * 
 * last updated 29.10.20
 */
import java.util.Scanner;

public class GameRunner {

	public static void main(String[] args) {
	
		// init
		Scanner sc = new Scanner(System.in);
		Deck theDeck = new Deck(1, true);
		
		// init spiller objekter
		Player me = new Player("Magne");
		Player dealer = new Player("Dealer");
		
		// dealer to kort til spiller og to kort til dealer
		me.addCard(theDeck.dealNextCard());
		dealer.addCard(theDeck.dealNextCard());
		me.addCard(theDeck.dealNextCard());
		dealer.addCard(theDeck.dealNextCard());
		
		
		// printer start hender
		System.out.println("Cards are dealt\n");
		me.printHand(true); // true fordi vi skal se spillers kort
		dealer.printHand(false); // false fordu vi ikke skal se dealers kort
		System.out.println("\n");
		
		// flagger når spillere er ferdig med å hitte
		boolean meDone = false;
		boolean dealerDone = false;
		String ans;
		
		while (!meDone || !dealerDone) {
			
			// spillers tur
			if (!meDone) {
				
				System.out.print("Hit or Stay? (Enter H or S): ");
				ans = sc.next();
				System.out.println();
				
				// hvis spilleren hitter
				if (ans.compareToIgnoreCase("H") == 0) {
					
					// Legger neste kort i bunken hvis spiller er "busted"
					meDone = !me.addCard(theDeck.dealNextCard());
					me.printHand(true);
				} else {
					meDone = true;
				}
			}
			// dealers tur
			if (!dealerDone) {
				if (dealer.getHandSum() < 17) {
				System.out.println("The Dealer hits\n");
				dealerDone = !dealer.addCard(theDeck.dealNextCard());
				dealer.printHand(false);
				} else {
					System.out.println("The Dealer stays\n");
					dealerDone = true;
				}
			}
			
			System.out.println();
		}
	// avslutter scanner
	sc.close();
	
	// printer siste hender
	// hvem vinner?
	me.printHand(true);
	dealer.printHand(true);
	
	int mySum = me.getHandSum();
	int dealerSum = dealer.getHandSum();
	
	if (mySum > dealerSum && mySum <= 21 || dealerSum > 21) {
		System.out.println("You Win!");
	} else {
		System.out.println("Dealer wins!");
	}
	}

}
