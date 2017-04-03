import java.util.Arrays;

// click on "default package" and click the "play button" to run the program

public class HugeInteger{
	boolean isPositive;
	private int[] numberArray;
	
	final int ARRAY_SIZE = 40;

	public HugeInteger() {
		this.numberArray = new int[ARRAY_SIZE];
		isPositive = true;
	}

	private int charToInt(char c) {
		return c - '0';
	}

	public void parse(String inp) {
		if (inp.length() > ARRAY_SIZE) {
			throw new RuntimeException("The length of the string is more than 40");
		}

		Arrays.fill(this.numberArray, 0);
		isPositive = true;
		
		for (int i = inp.length() - 1; i >= 0; i--) {
			if(inp.charAt(i) == '-') {
				isPositive = false;
				continue;
			}
			numberArray[inp.length() - 1 - i] = this.charToInt(inp.charAt(i));
		}
		
		/*
		for (int i = ARRAY_SIZE - 1; i >= 0; i--)
			System.out.printf("%3d%c", i, i == 0 ? '\n' : ' ');
		for (int i = ARRAY_SIZE - 1; i >= 0; i--)
			System.out.printf("%3d%c", numberArray[i], i == 0 ? '\n' : ' ');
		*/
	}

	public String toString() {
		String result = (isPositive ? "" : "-");
		
		int i;
		for (i = ARRAY_SIZE - 1; i >= 0; i--)
			if(numberArray[i] != 0) 
				break;
		
		for(; i >= 0; i--)
			result += String.valueOf(numberArray[i]);
		
		return result;
	}

	public HugeInteger add(HugeInteger a, HugeInteger b) {
		return null;
	}

	public HugeInteger substract(HugeInteger a, HugeInteger b) {
		return null;
	}
	
	public boolean isEqualTo(HugeInteger a, HugeInteger b) {
		return false;
	}
	
	public boolean isNotEqualTo(HugeInteger a, HugeInteger b) {
		return false;
	}
	
	public boolean isGreaterThan(HugeInteger a, HugeInteger b) {
		return false;
	}
	
	public boolean isLessThan(HugeInteger a, HugeInteger b) {
		return false;
	}
	
	public boolean isGreaterThanOrEqualTo(HugeInteger a, HugeInteger b) {
		return false;
	}
	
	public boolean isLessThanOrEqualTo(HugeInteger a, HugeInteger b) {
		return false;
	}
	
	public boolean isZero(HugeInteger a, HugeInteger b) {
		for(int i = 0; i < ARRAY_SIZE; i++) {
			if(this.numberArray[i] != 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		HugeInteger a = new HugeInteger();
		
		String aString = "8287364782348182394234682736480006283468";
		a.parse(aString);
		System.out.println(a.toString());
		System.out.println(aString);
		if(a.toString().compareTo(aString) != 0) 
			throw new RuntimeException("String differs");
	}
}
