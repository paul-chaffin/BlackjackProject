package com.skilldistillery.blackjack;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.skilldistillery.blackjack.cards.Dealer;
import com.skilldistillery.blackjack.cards.Deck;
import com.skilldistillery.blackjack.cards.Player;

public class BlackjackApplication {
	private Scanner kb = new Scanner(System.in);
	private boolean dealerWin = false;
	private boolean playerWin = false;
	private boolean dealerPlayed = false;

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

		checkWin(deck, d, p);

	}

	public void showDealerStanding(Dealer d) {
		System.out.print("Dealer shows:\n\t");
		System.out.println(d.showHandNoBlind());
		System.out.println("\tHand value: " + d.getHandValueNoBlind() + " (+ blind)");
//		System.out.println("\tHidden hand value: " + d.getHandValueWithBlind());
	}

	public void showDealerStandingWithBlind(Dealer d) {
		System.out.print("Dealer shows:\n\t");
		System.out.println(d.showHandWithBlind());
		System.out.println("\tHand value: " + d.getHandValueWithBlind());
	}

	public void showPlayerStanding(Player p) {
		System.out.print("You show:\n\t");
		System.out.print(p.showHand());
		System.out.println("\n\tHand value: " + p.getHandValue());
	}

	public boolean checkWin(Deck deck, Dealer d, Player p) {
		boolean result = false;
		if (p.getHandValue() == 21 || d.getHandValueWithBlind() == 21) {
			result = true;
			if (p.getHandValue() == 21) {
				playerWin = true;
				System.out.println(p.showHand());
				System.out.println("21! You win!");
				leaveGame();
			}
			if (d.getHandValueWithBlind() == 21) {
				dealerWin = true;
				System.out.println(d.showHandWithBlind());
				System.out.println("21! House wins!");
				leaveGame();
			}
		} else if (p.getHandValue() > 21 || d.getHandValueWithBlind() > 21) {
			result = true;
			if (p.getHandValue() > 21) {
				dealerWin = true;
				System.out.println("You went bust. House wins with a score of " + d.getHandValueWithBlind() + ":");
				System.out.println("\t" + d.showHandWithBlind());
				leaveGame();
			}
			if (d.getHandValueWithBlind() > 21) {
				playerWin = true;
				System.out.println("House busts! You win with a score of " + p.getHandValue());
				System.out.println(p.showHand());
				leaveGame();
			}
		} else {
			if (dealerPlayed) {
				if (p.getHandValue() > d.getHandValueWithBlind()) {
					System.out.println("You win! You were closer to 21 with a score of " + p.getHandValue());
					leaveGame();
				} else {
					dealerWin = true;
					System.out.println("House wins with a score of " + d.getHandValueWithBlind());
					leaveGame();
				}
			} else {
				playerTurn(deck, d, p);
			}
		}
		return result;
	}

	public void playerTurn(Deck deck, Dealer d, Player p) {
		int choice = 0;
		boolean keepGoing = true;
		while (keepGoing) {
			System.out.print("Your turn! Enter a choice.\n1. Hit  2. Stand > ");
			choice = kb.nextInt();
			if (choice == 1) {
				d.dealCardToPlayer(deck, p);
				showPlayerStanding(p);
				if (checkWin(deck, d, p)) {
					break;
				}
			} else if (choice == 2) {
				keepGoing = false;
				break;
			}

		}
		if (p.getHandValue() == 21) {
			playerWin = true;
			keepGoing = false;
			System.out.println(p.showHand());
			System.out.println("21! You win!");
			leaveGame();
		} else if (p.getHandValue() > 21) {
			dealerWin = true;
			keepGoing = false;
			System.out.println(p.showHand());
			System.out.println("You went bust with a score of " + p.getHandValue());
			leaveGame();
		} else {
			dealerTurn(deck, d, p);
		}

	}

	public void dealerTurn(Deck deck, Dealer d, Player p) {
		if (d.getHandValueWithBlind() < 17) {
			do {
				System.out.println("Dealer is revealing the blind");
				System.out.println(d.showHandWithBlind());
				System.out.println("Dealer is drawing...");
				d.dealCardToSelf(deck);
				showDealerStandingWithBlind(d);

			} while (d.getHandValueWithBlind() < 17);
		}
		if (d.getHandValueWithBlind() == 21) {
			dealerWin = true;
			System.out.println("21, House wins!");
			System.out.println(d.showHandWithBlind());
			leaveGame();
		} else if (d.getHandValueWithBlind() > 21) {
			playerWin = true;
			System.out.println("House busts! You win with a score of " + p.getHandValue() + ":");
			System.out.println("\t" + p.showHand());
			leaveGame();
		} else {
			dealerPlayed = true;
			checkWin(deck, d, p);
		}
	}

	public void leaveGame() {
		kb.close();
		System.exit(0);
	}
}
