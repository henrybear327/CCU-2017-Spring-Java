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
		long mod = 1;
		for (int i = 0; i <= 18; i++) {
			System.out.println("Round " + Integer.toString(i) + ". Generating two random numbers...\n");
			SecureRandom rnd = new SecureRandom();
			long num1 = Math.abs(rnd.nextLong()) % mod, num2 = Math.abs(rnd.nextLong()) % mod;
			if (num1 < num2) {
				final long tmp = num1;
				num1 = num2;
				num2 = tmp;
			}
			mod *= 10;

			BigInteger first = new BigInteger(Long.toString(num1));
			BigInteger second = new BigInteger(Long.toString(num2));

			HugeInteger myFirst = new HugeInteger();
			HugeInteger mySecond = new HugeInteger();
			myFirst.parse(Long.toString(num1));
			mySecond.parse(Long.toString(num2));

			// addition
			BigInteger result = first.add(second);
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
			result = first.subtract(second);
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
			result = first.multiply(second);
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
			boolean hasDivisionError = false;
			try {
				result = first.divide(second);
			} catch (Exception e) {
				System.err.println(e.getMessage());
				hasDivisionError = true;
			}
			try {
				myResult = myFirst.divide(mySecond);
			} catch (Exception e) {
				System.err.println(e.getMessage());
				hasDivisionError = true;
			}

			if (hasDivisionError || result.toString().equals(myResult.toString()) == false) {
				System.err.println("Division test failed");
				System.err.println(first.toString() + " / " + second.toString() + " !=\n" + myFirst.toString() + " / "
						+ mySecond.toString());
				// System.err.println(result.toString() + " !=\n" + myResult.toString());
			} else {
				System.out.println("Division test passed");
				System.out.println(first.toString() + " / " + second.toString() + " =\n" + myFirst.toString() + " / "
						+ mySecond.toString());
				System.out.println(result.toString() + " =\n" + myResult.toString());
			}
			System.out.println("");

			// remainder
			hasDivisionError = false;
			try {
				result = first.remainder(second);
			} catch (Exception e) {
				System.err.println(e.getMessage());
				hasDivisionError = true;
			}
			try {
				myResult = myFirst.remainder(mySecond);
			} catch (Exception e) {
				System.err.println(e.getMessage());
				hasDivisionError = true;
			}

			if (hasDivisionError || result.toString().equals(myResult.toString()) == false) {
				System.err.println("Remainder test failed");
				System.err.println(first.toString() + " % " + second.toString() + " !=\n" + myFirst.toString() + " % "
						+ mySecond.toString());
				// System.err.println(result.toString() + " !=\n" + myResult.toString());
			} else {
				System.out.println("Remainder test passed");
				System.out.println(first.toString() + " % " + second.toString() + " =\n" + myFirst.toString() + " % "
						+ mySecond.toString());
				System.out.println(result.toString() + " =\n" + myResult.toString());
			}
			System.out.println("");
		}
	}
}
