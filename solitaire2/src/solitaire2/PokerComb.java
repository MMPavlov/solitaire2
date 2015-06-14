package solitaire2;

import java.util.Arrays;

public class PokerComb {

	private static int straightCount;
	Card[] fiveCards = new Card[5];
	
	public static String Combo(Card[] fiveCards) {
		
		int[] fiveRanks = new int[5];
		int[] fiveSuits = new int[5];
		int[] rankCounter = new int[5];
		int pairCounter = 0;
		int straightCount = 0;
		int flushCount = 0;
		for (int i = 0; i < fiveRanks.length; i++) {
			fiveRanks[i] = fiveCards[i].getRank();
			fiveSuits[i] = fiveCards[i].getSuit();
		}
		Arrays.sort(fiveRanks);
		for (int i = 0; i < fiveRanks.length; i++) {
			for (int j = i+1; j < fiveRanks.length; j++) {
				if (fiveRanks[i] == fiveRanks[j]) {
					rankCounter[i]++;
					pairCounter++;
				}
			}			
		} 
		
		for (int i = 0; i < rankCounter.length; i++) {
			if (rankCounter[i] == 3){
				return "каре";
			}
			if ((rankCounter[i] == 2) && (pairCounter == 4)){     //
				return "фулхаус";
			}
			
			if ((rankCounter[i] == 2) && (pairCounter == 3)){
				return "тройка";
			}
			
		}
		for (int i = 0; i < rankCounter.length; i++) {
		}
		
		if (pairCounter == 2){
			return "две пары";
		} else if (pairCounter == 1){
			return "пара";
		}
		
		for (int i = 0; i < fiveRanks.length-1; i++) {
			if (fiveRanks[i]+1 == fiveRanks[i+1]){
				straightCount++;
			}
		}
		
		
		for (int i = 0; i < fiveSuits.length-1; i++) {
			if(fiveSuits[i] == fiveSuits[i+1]){
				flushCount++;
			}
		}
		
		if (straightCount == 4 && flushCount == 4 && fiveRanks[4] == 12){
			return "роял флэш";
		}
		
		if (straightCount == 4 && flushCount == 4){
			return "стритфлэш";
		}	
		if (straightCount == 4){
			return "стрит";
		}	
		
		if (flushCount == 4){
			return "флэш";
		}
		
		return "ищи ветра в поле";
	}
	
}
