import java.util.Arrays;

// click on "default package" and click the "play button" to run the program

// Questions:
// 1. Do we need to implement multiply, divide, and remainder?
// 2. public boolean isEqualTo(HugeInteger other) or public boolean isEqualTo(HugeInteger a, HugeInteger b)
// 3. Handle negative number, overflow?

public class HugeInteger {
	public int[] numberArray;
	final int ARRAY_SIZE = 40;

	public HugeInteger() {
		this.numberArray = new int[ARRAY_SIZE];
		Arrays.fill(this.numberArray, 0);
	}
	public HugeInteger(String inp) {
		this.numberArray = new int[ARRAY_SIZE];
		Arrays.fill(this.numberArray, 0);
		this.parse(inp);
	}

	private int charToInt(char c) {
		return c - '0';
	}

	private HugeInteger cloneObject() {
		HugeInteger result = new HugeInteger();
		result.parse(this.toString());

		return result;
	}
	
	public void parse(String inp) {
		if (inp.length() > ARRAY_SIZE) {
			throw new RuntimeException("The length of the string is more than 40");
		}

		Arrays.fill(this.numberArray, 0);

		for (int i = inp.length() - 1; i >= 0; i--) {
			numberArray[inp.length() - 1 - i] = this.charToInt(inp.charAt(i));
		}
	}

	public String toString() {
		String result = "";

		int i;
		for (i = ARRAY_SIZE - 1; i >= 0; i--)
			if (numberArray[i] != 0)
				break;

		for (; i >= 0; i--)
			result += String.valueOf(numberArray[i]);

		return result.length() == 0 ? "0" : result;
	}

	public HugeInteger add(HugeInteger other) {
		HugeInteger result = new HugeInteger();
		for (int i = 0; i < ARRAY_SIZE; i++) {
			result.numberArray[i] += this.numberArray[i] + other.numberArray[i];
			if (i + 1 < ARRAY_SIZE) {
				result.numberArray[i + 1] = result.numberArray[i] / 10;
				result.numberArray[i] %= 10;
			}
		}

		return result;
	}

	public HugeInteger subtract(HugeInteger other) {
		HugeInteger first = this.cloneObject();
		HugeInteger result = new HugeInteger();

		for (int i = 0; i < ARRAY_SIZE; i++) {
			if (first.numberArray[i] < other.numberArray[i]) {
				if (i + 1 < ARRAY_SIZE)
					first.numberArray[i + 1]--;
				result.numberArray[i] = first.numberArray[i] - other.numberArray[i] + 10;
			} else
				result.numberArray[i] = first.numberArray[i] - other.numberArray[i];
		}

		return result;
	}

	public HugeInteger multiply(HugeInteger other) {
		HugeInteger result = new HugeInteger();
		for (int j = 0; j < ARRAY_SIZE; j++) {
			for (int i = 0; i + j < ARRAY_SIZE; i++) {
				result.numberArray[i + j] += this.numberArray[i] * other.numberArray[j];
				if (i + j + 1 < ARRAY_SIZE) {
					result.numberArray[i + j + 1] += result.numberArray[i + j] / 10;
				} 
				result.numberArray[i + j] %= 10;
			}
		}

		return result;
	}

	public HugeInteger divide(HugeInteger other) {
		if(other.isZero()) {
			throw new RuntimeException("HugeInteger divide by zero");
		}
		
		if(other.isGreaterThan(this)) // return 0
			return new HugeInteger();
		
		HugeInteger toDivide = new HugeInteger();
		HugeInteger result = new HugeInteger();
		
		for(int i = 0; i < this.toString().length(); i++) {
			toDivide = toDivide.multiply(new HugeInteger("10"));
			toDivide = toDivide.add(new HugeInteger(this.toString().substring(i, i + 1)));
			
			for(int j = 1; j <= 10; j++) {
				if((other.multiply(new HugeInteger(Integer.toString(j))).isGreaterThan(toDivide))) {
					result = result.multiply(new HugeInteger("10"));
					result = result.add(new HugeInteger(Integer.toString(j - 1)));
					
					toDivide = toDivide.subtract(other.multiply(new HugeInteger(Integer.toString(j - 1))));
					break;
				}
			}
		}

		return result;
	}

	public HugeInteger remainder(HugeInteger other) {
		if(other.isZero()) {
			throw new RuntimeException("HugeInteger divide by zero");
		}
		
		HugeInteger result = new HugeInteger();
		
		HugeInteger tmp = this.divide(other);
		tmp = tmp.multiply(other);
		result = this.subtract(tmp);

		return result;
	}

	private String toCompareString() {
		String result = "";

		for (int i = ARRAY_SIZE - 1; i >= 0; i--)
			result += this.numberArray[i] + '0';

		return result;
	}

	public boolean isEqualTo(HugeInteger other) {
		return this.toCompareString().compareTo(other.toCompareString()) == 0;
	}

	public boolean isNotEqualTo(HugeInteger other) {
		return this.toCompareString().compareTo(other.toCompareString()) != 0;
	}

	public boolean isGreaterThan(HugeInteger other) {
		return this.toCompareString().compareTo(other.toCompareString()) > 0;
	}

	public boolean isLessThan(HugeInteger other) {
		return this.toCompareString().compareTo(other.toCompareString()) < 0;
	}

	public boolean isGreaterThanOrEqualTo(HugeInteger other) {
		return this.toCompareString().compareTo(other.toCompareString()) >= 0;
	}

	public boolean isLessThanOrEqualTo(HugeInteger other) {
		return this.toCompareString().compareTo(other.toCompareString()) <= 0;
	}

	public boolean isZero() {
		int count = 0;
		for (int i = 0; i < ARRAY_SIZE; i++) {
			if (this.numberArray[i] == 0)
				count++;
		}
		return count == ARRAY_SIZE;
	}
}
