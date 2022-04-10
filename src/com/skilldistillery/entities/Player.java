package com.skilldistillery.entities;

import com.skilldistillery.blackjack.cards.Card;

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

	public StringBuilder showHand() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < (hand.cards.size() - 1); i++) {
			sb.append(hand.cards.get(i).toString() + " || ");
		}
		sb.append(hand.cards.get(hand.cards.size() - 1));
		return sb;
	}
}
