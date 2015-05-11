package solitaire2;

import java.awt.Color;
import java.awt.Graphics;

class TablePile extends DisTabPile {
	
	int topCardy;

	TablePile(final int x, final int y, final int c) {
		// initialize the parent class
		super(x, y);
		// then initialize our pile of cards
		for (int i = 0; i < c; i++) {
			addCard(Solitaire.deckPile.pop());
		}
		// flip topmost card face up
		top().flip();
		topCardy = y + (c-1)*35 ;
	}

	public boolean canTake(final Card aCard) {
		if (empty()) {
			return aCard.isKing();
		}
		Card topCard = top();
		return (aCard.color() != topCard.color())
				&& (aCard.getRank() == topCard.getRank() - 1);
	}

	public void display(final Graphics g) {
		stackDisplay(g, top());
		//g.setColor(Color.green);   //card position check for topCardy
		//g.drawLine(x + 25, topCardy, x + 35, topCardy + 35);
		
	}

	public boolean includes(final int tx, final int ty) {
		// don't test bottom of card
		return (x <= tx) && (tx <= (x + Card.width)) && (topCardy  <= ty) && (ty <= (topCardy + Card.height));
	}

//	public void select(final int tx, final int ty) {
//		if (empty()) {
//			return;
//		}
//
//		// if face down, then flip
//		Card topCard = top();
//		if (!topCard.isFaceUp()) {
//			topCard.flip();
//			return;
//		}
//
//		// else see if any suit pile can take card
//		topCard = pop();
//		for (int i = 0; i < 4; i++) {
//			if (Solitaire.suitPile[i].canTake(topCard)) {
//				Solitaire.suitPile[i].addCard(topCard);
//				return;
//			}
//		}
//		// else see if any other table pile can take card
//		for (int i = 0; i < 7; i++) {
//			if (Solitaire.tableau[i].canTake(topCard)) {
//				Solitaire.tableau[i].addCard(topCard);
//				return;
//			}
//		}
//		// else put it back on our pile
//		addCard(topCard);
//		
//	}
	
	@Override
	public void select(int tx, int ty) {
		// if face down, then flip
		Card topCard = top();
		if (!topCard.isFaceUp()) {
			topCard.flip();
			return;
		}
		super.select(tx, ty);
	}

	private int stackDisplay(final Graphics g, final Card aCard) {
		int localy;
		if (aCard == null) {
			return y;
		}
		localy = stackDisplay(g, aCard.link);
		aCard.draw(g, x, localy);
		return localy + 35;
	}
	
	@Override
	public Card pop() {
		if (!empty()){
			topCardy -= 35;
		}
		return super.pop();
	}
	
	@Override
	public void addCard(Card aCard) {
		topCardy += 35;
		super.addCard(aCard);
	}
	
	

}