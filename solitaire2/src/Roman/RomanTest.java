package Roman;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


	@RunWith(Parameterized.class)
	public class RomanTest {
		private int _input;
		private String _output;
		
		
		@Parameters
		public static List<Object[]> data() {
			return Arrays.asList(new Object[][] {
				{1, "I"},
				{2, "II"},	
				{11, "XI"},
				{53, "LIII"},
				{99, "XCIX"}
			}
			);
		}
	
	
		public RomanTest(int input, String output){
			_input = input;
			_output = output;
		}
	
		@Test
		public void test() {
			assertEquals(_output, RomanConvert.RomanToArab(_input));
		}
		
	}

	
	
	
	
	
