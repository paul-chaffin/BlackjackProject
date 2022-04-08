package com.skilldistillery.blackjack;

import com.skilldistillery.blackjack.cards.*;

public class BlackjackApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BlackjackApplication app = new BlackjackApplication();
		Dealer dealer = new Dealer();
		Player player = new Player();

		app.run(dealer, player);
	}

	public void run(Dealer d, Player p) {
		Deck deck = new Deck();
		deck.shuffleDeck();
		d.dealStartingHands(deck, d, p);

		showCurrentStanding(d, p);

		displayMenu();
	}

	public void showCurrentStanding(Dealer d, Player p) {
		System.out.print("Dealer shows:\n\t");
		System.out.print(d.showHand() + " || (blind)\n");
		System.out.println("\tHand value: " + d.showHand().getValue() + " (+ blind)");
		System.out.print("You show:\n\t");
		System.out.print(p.showHand());
		System.out.print("\n\tHand value: " + p.getHandValue());
	}

	public void displayMenu() {
		// TODO
	}

}
