package com.skilldistillery.entities;

import com.skilldistillery.blackjack.cards.Card;
import com.skilldistillery.blackjack.cards.Deck;


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

	public void dealCardToPlayer(Deck deck, Player p) {
		p.takeCardFromDealer(deck.dealCard());
	}

	public void dealCardToSelf(Deck deck) {
		hand.addCard(deck.dealCard());
	}

	public int getHandSize() {
		return hand.cards.size();
	}

	public StringBuilder showHandNoBlind() {
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < (hand.cards.size()); i++) {
			sb.append(hand.cards.get(i).toString() + " || ");
		}
		sb.append("BLIND");
		return sb;
	}

	public StringBuilder showHandWithBlind() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < (hand.cards.size()); i++) {
			sb.append(hand.cards.get(i).toString() + " || ");
		}
		return sb;
	}

	public Card showBlind() {
		return hand.cards.get(0);
	}

	public int getHandValueWithBlind() {
		int value = 0;
		for (Card c : hand.cards) {
			value += c.getValue();
		}
		return value;
	}

	public int getHandValueNoBlind() {
		int value = 0;
		for (int i = 1; i < (hand.cards.size()); i++) {
			value += hand.cards.get(i).getValue();
		}
		return value;
	}

}
