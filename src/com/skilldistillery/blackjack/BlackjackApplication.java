package com.skilldistillery.blackjack;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.skilldistillery.blackjack.cards.Dealer;
import com.skilldistillery.blackjack.cards.Deck;
import com.skilldistillery.blackjack.cards.Player;

public class BlackjackApplication {
	private Scanner kb = new Scanner(System.in);

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

		showDealerStanding(d);
		showPlayerStanding(p);

	}

	public void showDealerStanding(Dealer d) {
		System.out.print("Dealer shows:\n\t");
		System.out.println(d.showHand());
		System.out.println("\tHand value: " + d.getHandValueNoBlind() + " (+ blind)");
	}

	public void showPlayerStanding(Player p) {
		System.out.print("You show:\n\t");
		System.out.print(p.showHand());
		System.out.print("\n\tHand value: " + p.getHandValue());
	}

	public void playerTurn(Deck deck, Dealer d, Player p) {
		String choice = "";
		System.out.println("(S)tand or (H)it?");
		do {
			try {
				choice = kb.next().toUpperCase();
				switch (choice) {
				case "H":
					d.dealCardToPlayer(deck, p);
					break;
				case "S":
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("Please enter S to Stand or H to Hit.");
			}
		} while (choice != "S");

		dealerTurn(deck, d, p);
	}

	public void dealerTurn(Deck deck, Dealer d, Player p) {
		do {
			System.out.println("Dealer is drawing...");
			d.dealCardToSelf(deck);
			showDealerStanding(d);

		} while (d.getHandValueWithBlind() < 17);
	}
}
