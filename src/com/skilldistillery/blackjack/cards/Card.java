package com.skilldistillery.blackjack.cards;

import java.util.Objects;

public class Card {
	private Rank rank;
	private Suit suit;

	public Card(Rank r, Suit s) {
		rank = r;
		suit = s;
	}

	@Override
	public int hashCode() {
		return Objects.hash(rank, suit);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		return rank == other.rank && suit == other.suit;
	};

	public int getValue() {
		return rank.getValue();
	}

	public String toString() {

		return rank + " of " + suit;
	}

}
