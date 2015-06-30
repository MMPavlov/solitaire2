package Roman;

public class RomanConvert {
	
	public static String RomanToArab(int input){
		String s = null;
		switch (input%10) {
			case 1:
				s = "I";
				break;
			case 2:
				s = "II";
				break;
			case 3:
				s = "III";
				break;
			case 4:
				s = "IV";
				break;
			case 5:
				s = "V";
				break;
			case 6:
				s = "VI";
				break;
			case 7:
				s = "VII";
				break;
			case 8:
				s = "VIII";
				break;
			case 9:
				s = "IX";
				break;		
			default:
				break;
		}
		
		switch (input/10){
			case 1:
				s = "X" + s;
				break;
			case 2:
				s = "XX" + s;
				break;
			case 3:
				s = "XXX" + s;
				break;
			case 4:
				s = "XL" + s;
				break;
			case 5:
				s = "L" + s;
				break;
			case 6:
				s = "LX" + s;
				break;
			case 7:
				s = "LXX" + s;
				break;
			case 8:
				s = "LXXX" + s;
				break;
			case 9:
				s = "XC" + s;
				break;				
			default:
				break;
		}
		
		return s;
	}

}
