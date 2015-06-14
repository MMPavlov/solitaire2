package solitaire2;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;



	@RunWith(Parameterized.class)
	public class PokerTest {
		
		private Card[] _input;
		private String _output;
		static Card[] Pair = new Card[] {new Card(0,0), new Card(0,1), new Card(1,1), new Card(2,2), new Card(3,3)};
		static Card[] TwoPair = new Card[] {new Card(0,0), new Card(0,0), new Card(1,1), new Card(1,1), new Card(3,3)};
		static Card[] ThreeOfAKind = new Card[] {new Card(0,0), new Card(0,0), new Card(0,0), new Card(1,1), new Card(3,3)};
		static Card[] FourOfAKind = new Card[] {new Card(0,0), new Card(0,0), new Card(0,0), new Card(0,0), new Card(3,3)};
		static Card[] FullHouse = new Card[] {new Card(0,0), new Card(0,0), new Card(0,0), new Card(3,3), new Card(3,3)};
		static Card[] Straight = new Card[] {new Card(0,0), new Card(1,1), new Card(2,2), new Card(3,3), new Card(2,4)};
		static Card[] Flush = new Card[] {new Card(0,3), new Card(0,5), new Card(0,7), new Card(0,9), new Card(0,12)};
		static Card[] StraightFlush = new Card[] {new Card(0,1), new Card(0,2), new Card(0,3), new Card(0,4), new Card(0,5)};
		static Card[] RoyalFlush = new Card[] {new Card(0,8), new Card(0,9), new Card(0,10), new Card(0,11), new Card(0,12)};
		
		
		
		@Parameters
		public static List<Object[]> data() {
			return Arrays.asList(new Object[][] {
					{Pair, "пара"},
					{TwoPair, "две пары"},
					{ThreeOfAKind, "тройка"},
					{FourOfAKind, "каре"},
					{FullHouse, "фулхаус"},
					{Straight, "стрит"},
					{Flush, "флэш"},
					{StraightFlush, "стритфлэш"},
					{RoyalFlush, "роял флэш"},
					
					
			}
			);
		}
		
		public PokerTest(final Card[] input, final String output) {
			_input = input;
			_output = output;
		}

		@Test
		public void test() {
			assertEquals(_output, PokerComb.Combo(_input));
		}

	}
	

