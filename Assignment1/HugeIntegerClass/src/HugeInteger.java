import java.util.Arrays;

// click on "default package" and click the "play button" to run the program

// Questions:
// 1. Do we need to implement multiply, divide, and remainder?
// 2. public boolean isEqualTo(HugeInteger other) or public boolean isEqualTo(HugeInteger a, HugeInteger b)
// 3. Handle negative number, overflow?

public class HugeInteger{
	public int[] numberArray;
	
	final int ARRAY_SIZE = 40;

	public HugeInteger() {
		this.numberArray = new int[ARRAY_SIZE];
		Arrays.fill(this.numberArray, 0);
	}

	private int charToInt(char c) {
		return c - '0';
	}

	public void parse(String inp) {
		if (inp.length() > ARRAY_SIZE) {
			throw new RuntimeException("The length of the string is more than 40");
		}

		Arrays.fill(this.numberArray, 0);
		
		for (int i = inp.length() - 1; i >= 0; i--) {
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
		String result = "";
		
		int i;
		for (i = ARRAY_SIZE - 1; i >= 0; i--)
			if(numberArray[i] != 0) 
				break;
		
		for(; i >= 0; i--)
			result += String.valueOf(numberArray[i]);
		
		return result.length() == 0 ? "0" : result;
	}

	public HugeInteger add(HugeInteger other) {
		HugeInteger result = new HugeInteger();
		for(int i = 0; i < ARRAY_SIZE; i++) {
			result.numberArray[i] += this.numberArray[i] + other.numberArray[i];
			if(i + 1 < ARRAY_SIZE) {
				result.numberArray[i + 1] = result.numberArray[i] / 10;
				result.numberArray[i] %= 10;
			}
		}
		
		return result;
	}

	public HugeInteger subtract(HugeInteger other) {
		HugeInteger result = new HugeInteger();
		for(int i = 0; i < ARRAY_SIZE; i++) {
			
		}
		
		return result;
	}
	
	public HugeInteger multiply(HugeInteger other) {
		HugeInteger result = new HugeInteger();
		for(int i = 0; i < ARRAY_SIZE; i++) {
			
		}
		
		return result;
	}
	
	public HugeInteger divide(HugeInteger other) {
		HugeInteger result = new HugeInteger();
		for(int i = 0; i < ARRAY_SIZE; i++) {
			
		}
		
		return result;
	}
	
	public HugeInteger remainder(HugeInteger b) {
		return null;
	}
	
	public boolean isEqualTo(HugeInteger other) {
		return false;
	}
	
	public boolean isNotEqualTo(HugeInteger other) {
		return false;
	}
	
	public boolean isGreaterThan(HugeInteger other) {
		return false;
	}
	
	public boolean isLessThan(HugeInteger other) {
		return false;
	}
	
	public boolean isGreaterThanOrEqualTo(HugeInteger other) {
		return false;
	}
	
	public boolean isLessThanOrEqualTo(HugeInteger other) {
		return false;
	}
	
	public boolean isZero() {
		int count = 0;
		for(int i = 0; i < ARRAY_SIZE; i++) {
			if(this.numberArray[i] == 0)
				count++;
		}
		return count == ARRAY_SIZE;
	}
}
