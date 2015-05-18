package solitaire2;

/*
 Simple Solitaire Card Game in Java
 Written by Tim Budd, Oregon State University, 1996
 */

import java.awt.*;
import java.applet.*;

public class Solitaire extends Applet {
	static CardPile allPiles[];
	static DeckPile deckPile;
	static DiscardPile discardPile;
	static SuitPile suitPile[];
	static TablePile tableau[];

	public void init() {
		// first allocate the arrays fdsfsd
		allPiles = new CardPile[13];
		suitPile = new SuitPile[4];
		tableau = new TablePile[7];
		// then fill them in
		allPiles[0] = deckPile = new DeckPile(335, 5);
		allPiles[1] = discardPile = new DiscardPile(268, 5);
		for (int i = 0; i < 4; i++) {
			allPiles[2 + i] = suitPile[i] = new SuitPile(15 + 60 * i, 5);
		}
		for (int i = 0; i < 7; i++) {
			allPiles[6 + i] = tableau[i] = new TablePile(5 + 55 * i, 80, i + 1);
		}
	}

	int f = 17;

	@Override
	public boolean mouseDown(final Event evt, final int x, final int y) {
		for (int i = 0; i < 13; i++) {
			if (allPiles[i].includes(x, y)) {
				if (i == 0) {
					deckPile.select(x, y);
					repaint();
					return true;
				}
				if (!allPiles[i].empty() && !allPiles[i].top().isFaceUp()){
					allPiles[i].top().flip();
					repaint();
					return true;
				}
				if (f == 17) {

					if (!allPiles[i].empty()) {
						f = i;

					}
				} else if (allPiles[f].top().link != null && 6<=f && f<=13 ) {
					CardPile flyingPile = new CardPile(x,y);
					if (allPiles[f].top().link == null){
						
					}
					while (!allPiles[f].empty()  &&  allPiles[f].top().isFaceUp() ) {
						flyingPile.addCard(allPiles[f].pop());
					}	
					while (!flyingPile.empty()) {
						if (allPiles[i].canTake(flyingPile.top())) {
							allPiles[i].addCard(flyingPile.pop());
						} else {
							allPiles[f].addCard(flyingPile.pop());
						}
					}
					f = 17;
						
				
				} else if (allPiles[f].top().link == null  ||  (0<=f && f<=1)){
						Card flying = allPiles[f].pop();
						if (allPiles[i].canTake(flying)) {
							allPiles[i].addCard(flying);
						} else {
							allPiles[f].addCard(flying);
						}
					f = 17;
				}

				repaint();
				return true;
			}
		}

		return true;
	}

	@Override
	public void paint(final Graphics g) {
		for (int i = 0; i < 13; i++) {
			allPiles[i].display(g);
		}
		if (f != 17) {
			allPiles[f].displayred(g);
		}
	}
}