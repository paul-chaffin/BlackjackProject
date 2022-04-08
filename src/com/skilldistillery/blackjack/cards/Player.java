package com.skilldistillery.blackjack.cards;

public class Player {
	private Hand hand;

	public Player() {
		this.hand = new BlackjackHand();
	}

	public void takeCardFromDealer(Card c) {
		hand.addCard(c);
	}

	public int getHandSize() {
		return hand.cards.size();
	}

	public int getHandValue() {
		return hand.getHandValue();
	}

	public void fold() {
		hand.clear();
	}

	public String showHand() {
		return hand.cards.get(0).toString() + " || " + hand.cards.get(1).toString();
	}
}
