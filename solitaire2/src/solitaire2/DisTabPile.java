package solitaire2;

import java.awt.Color;
import java.awt.Graphics;

public class DisTabPile extends CardPile {

	DisTabPile(int xl, int yl) {
		super(xl, yl);
		// TODO Auto-generated constructor stub
	}
	
	public void select(final int tx, final int ty) {
		
//		Graphics g = null;
//		g.setColor(Color.red);
//		g.drawRect(this.x, this.y, 50, 70);
		
		if (empty()) {
			return;
		}
		
		// else see if any suit pile can take card
		Card topCard = pop();
		for (int i = 0; i < 4; i++) {
			if (Solitaire.suitPile[i].canTake(topCard)) {
				Solitaire.suitPile[i].addCard(topCard);
				return;
			}
		}
		// else see if any other table pile can take card
		for (int i = 0; i < 7; i++) {
			if (Solitaire.tableau[i].canTake(topCard)) {
				Solitaire.tableau[i].addCard(topCard);
				return;
			}
		}
		// nobody can use it, put it back on our list
		addCard(topCard);
		
	}
	
	
	

}
