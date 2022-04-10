package com.skilldistillery.entities;
import com.skilldistillery.blackjack.cards.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Hand {
	protected List<Card> cards;

	public Hand() {
		this.cards = new ArrayList<>();
	};
	
	public void addCard(Card card) {
		cards.add(card);
	}
	
	public void clear() {
		cards.clear();
	}
	
	public abstract int getHandValue();

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}
	
	
}
