import java.math.BigInteger;
import java.security.SecureRandom;

public class HugeIntegerTest {
	public static void main(String[] args) {
		String aString = "8287364782348182394234682736480006283468";
		HugeInteger a = new HugeInteger();
		a.parse(aString);
		System.out.println(a.toString());
		System.out.println(aString);
		if (a.toString().compareTo(aString) != 0)
			throw new RuntimeException("String differs");
		if (a.isZero() == true)
			throw new RuntimeException("isZero() is broken");

		String zeroString = "0";
		HugeInteger zero = new HugeInteger();
		zero.parse(zeroString);
		System.out.println(zero.toString());
		System.out.println(zeroString);
		if (zero.isZero() == false)
			throw new RuntimeException("isZero() is broken");

		// testing
		for (int i = 1; i <= 10; i++) {
			System.out.println("Round " + Integer.toString(i) + ". Generating two random numbers...");
			SecureRandom rnd = new SecureRandom();
			long num1 = Math.abs(rnd.nextLong()), num2 = Math.abs(rnd.nextLong());
			if (num1 < num2) {
				final long tmp = num1;
				num1 = num2;
				num2 = tmp;
			}

			// addition
			BigInteger first = new BigInteger(Long.toString(num1));
			BigInteger second = new BigInteger(Long.toString(num2));
			BigInteger result = first.add(second);

			HugeInteger myFirst = new HugeInteger();
			HugeInteger mySecond = new HugeInteger();
			myFirst.parse(Long.toString(num1));
			mySecond.parse(Long.toString(num2));
			HugeInteger myResult = myFirst.add(mySecond);

			if (result.toString().equals(myResult.toString()) == false) {
				System.err.println("Addition test failed");
				System.err.println(first.toString() + " + " + second.toString() + " !=\n" + myFirst.toString() + " + "
						+ mySecond.toString());
				System.err.println(result.toString() + " !=\n" + myResult.toString());
			} else {
				System.out.println("Addition test passed");
				System.out.println(first.toString() + " + " + second.toString() + " =\n" + myFirst.toString() + " + "
						+ mySecond.toString());
				System.out.println(result.toString() + " =\n" + myResult.toString());
			}
			System.out.println("");

			// subtraction
			first = new BigInteger(Long.toString(num1));
			second = new BigInteger(Long.toString(num2));
			result = first.subtract(second);

			myFirst = new HugeInteger();
			mySecond = new HugeInteger();
			myFirst.parse(Long.toString(num1));
			mySecond.parse(Long.toString(num2));
			myResult = myFirst.subtract(mySecond);

			if (result.toString().equals(myResult.toString()) == false) {
				System.err.println("Subtraction test failed");
				System.err.println(first.toString() + " - " + second.toString() + " !=\n" + myFirst.toString() + " - "
						+ mySecond.toString());
				System.err.println(result.toString() + " !=\n" + myResult.toString());
			} else {
				System.out.println("Subtraction test passed");
				System.out.println(first.toString() + " - " + second.toString() + " =\n" + myFirst.toString() + " - "
						+ mySecond.toString());
				System.out.println(result.toString() + " =\n" + myResult.toString());
			}
			System.out.println("");

			// multiplication
			first = new BigInteger(Long.toString(num1));
			second = new BigInteger(Long.toString(num2));
			result = first.multiply(second);

			myFirst = new HugeInteger();
			mySecond = new HugeInteger();
			myFirst.parse(Long.toString(num1));
			mySecond.parse(Long.toString(num2));
			myResult = myFirst.multiply(mySecond);

			if (result.toString().equals(myResult.toString()) == false) {
				System.err.println("Multiplication test failed");
				System.err.println(first.toString() + " * " + second.toString() + " !=\n" + myFirst.toString() + " * "
						+ mySecond.toString());
				System.err.println(result.toString() + " !=\n" + myResult.toString());
			} else {
				System.out.println("Multiplication test passed");
				System.out.println(first.toString() + " * " + second.toString() + " =\n" + myFirst.toString() + " * "
						+ mySecond.toString());
				System.out.println(result.toString() + " =\n" + myResult.toString());
			}
			System.out.println("");

			// division
			first = new BigInteger(Long.toString(num1));
			second = new BigInteger(Long.toString(num2));
			result = first.multiply(second);

			myFirst = new HugeInteger();
			mySecond = new HugeInteger();
			myFirst.parse(Long.toString(num1));
			mySecond.parse(Long.toString(num2));
			myResult = myFirst.multiply(mySecond);

			if (result.toString().equals(myResult.toString()) == false) {
				System.err.println("Division test failed");
				System.err.println(first.toString() + " / " + second.toString() + " !=\n" + myFirst.toString() + " / "
						+ mySecond.toString());
				System.err.println(result.toString() + " !=\n" + myResult.toString());
			} else {
				System.out.println("Division test passed");
				System.out.println(first.toString() + " / " + second.toString() + " =\n" + myFirst.toString() + " / "
						+ mySecond.toString());
				System.out.println(result.toString() + " =\n" + myResult.toString());
			}
			System.out.println("");
		}
	}
}
