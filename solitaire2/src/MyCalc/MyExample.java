package MyCalc;



public class MyExample {
	
	abstract static class Command {
		
		MyCalculator _service;

		public Command(final MyCalculator service) {
			_service = service;
		}
		
		public abstract void execute();
		
	}
	
	static class Do2Command extends Command {

		public Do2Command(final MyCalculator service) {
			super(service);
		}

		@Override
		public void execute() {
		//	_service.do2();
		}
		
	}
	

	public static void main(final String[] args) {
		
		System.out.println("start");
		
		MyCalculator service = new MyCalculator();
		
	//	service.doSomething();
	//	service.do2();
	//	service.do3();
		
		Command command = new Do2Command(service);
		
		
		
		System.out.println("finish");
		
	}

}
