package com.skilldistillery.blackjack.cards;

public class Dealer {
	private Hand hand;

	public Dealer() {
		this.hand = new BlackjackHand();
	};

	public void dealStartingHands(Deck deck, Dealer d, Player p) {
		for (int i = 0; i < 2; i++) {
			p.takeCardFromDealer(deck.dealCard());
			d.hand.addCard(deck.dealCard());
		}
	}

	public int getHandSize() {
		return hand.cards.size();
	}
	
	public Card showHand() {
		return hand.cards.get(0);
	}
	
	public Card showBlind() {
		return hand.cards.get(1);
	}

}
