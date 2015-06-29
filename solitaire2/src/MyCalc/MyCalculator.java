package MyCalc;



public class MyCalculator {

	// TODO
	//  java Calculator 10 plus 20 plus 100 minus 30 get
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
				calc.new Get();
				break;
			case "Clear":
				calc.new Clear();
				break;
			default:
				if (flagPlus == 1){
					calc.new Plus(Integer.parseInt(expression));
					flagPlus = 0;
				} else if (flagMinus == 1){
					calc.new Minus(Integer.parseInt(expression));
					flagMinus = 0;
				} 
				
				
				break;
			}
			
		}
		
	}
	
	static int total = 0;
		

}
