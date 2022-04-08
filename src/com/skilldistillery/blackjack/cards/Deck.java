package com.skilldistillery.blackjack.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private List<Card> cards;

	public Deck() {
		cards = new ArrayList<>();

		for (Suit s : Suit.values()) {
			for (Rank r : Rank.values()) {
				cards.add(new Card(r, s));
			}
		}
	}

	public int checkDeckSize() {
		int size = cards.size();
		return size;
	}

	public Card dealCard() {
		return cards.remove(0);
	}

	public void shuffleDeck() {
		Collections.shuffle(cards);
	}

}
