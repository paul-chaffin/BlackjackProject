package com.skilldistillery.blackjack.cards;

import java.util.ArrayList;
import java.util.List;

public class BlackjackHand extends Hand {
	

	public BlackjackHand() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getHandValue() {
		int value = 0;
		
		for (Card card : cards) {
			value += card.getValue();
		}

		return value;
	}

	@Override
	public void addCard(Card card) {
		// TODO Auto-generated method stub
		super.addCard(card);
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		super.clear();
	}
	
	@Override
	public String toString() {
			return cards.get(0).toString() + " || " + cards.get(1).toString();
	}

}
