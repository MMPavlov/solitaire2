package MyCalc;

import java.util.Arrays;
import java.util.List;

public class MyCalculator {

	// TODO
	//  java Calculator 10 Plus 20 Plus 100 Minus 30 Get
	static boolean  flag = false;
	private static int flagPlus;
	private static int flagMinus;
	
	abstract class Command {
		public void execute() {
			realExecute();
			System.out.println(total);
		}

		abstract void realExecute();
	}
	
	public class Plus extends Command {
		
		int _value;

		Plus(final int value) {
			_value = value;
		}
		
		@Override
		void realExecute() {
			total += _value;
		}
	}
	
	public class Minus extends Plus {
		Minus(final int value) {
			super(-value);
		}
	}
	
	public class Clear extends Command {

		@Override
		void realExecute() {
			total = 0;
		}
		
	}
	
	public class Get extends Command {

		@Override
		void realExecute() {
			System.out.println(total);
		}

	}
	
	public class Set extends Command {
		
		@Override
		void realExecute() {
	//		total = 
		}
	}
	
	public static void main(String[] args) {
		
	
		
		MyCalculator calc = new MyCalculator();
		
		for (String expression : args) {
			if(!flag) {
				total = Integer.parseInt(expression);
				flag = true;
			}
			switch (expression) {
			case "Plus":
				flagPlus = 1;
				break;
			case "Minus":
				flagMinus = 1;
				break;
			case "Get":
				(calc.new Get()).execute();
				break;
			case "Clear":
				(calc.new Clear()).execute();
				break;
			default:
				if (flagPlus == 1){
					(calc.new Plus(Integer.parseInt(expression))).execute();
					flagPlus = 0;
				} else if (flagMinus == 1){
					(calc.new Minus(Integer.parseInt(expression))).execute();
					flagMinus = 0;
				} 
				
				
				break;
			}
			
		}
		
	}
	
	static int total = 0;
		

}
