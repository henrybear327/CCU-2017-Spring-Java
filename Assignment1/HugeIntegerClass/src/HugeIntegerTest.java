import java.math.BigInteger;
import java.security.SecureRandom;

public class HugeIntegerTest {
	private void testIsZero1() {
		HugeInteger zero = new HugeInteger("0");
		// System.out.println(zero.toString());
		// System.out.println("0");
		if (zero.isZero() == false)
			throw new RuntimeException("isZero() is broken");
	}

	private void testIsZero2() {
		String inp = "0";
		HugeInteger zero = new HugeInteger();
		zero.parse(inp);
		// System.out.println(zero.toString());
		// System.out.println("0");
		if (zero.isZero() == false)
			throw new RuntimeException("isZero() is broken");
	}

	private void testAdd(BigInteger first, BigInteger second, HugeInteger myFirst, HugeInteger mySecond) {
		BigInteger result = first.add(second);
		HugeInteger myResult = myFirst.add(mySecond);

		if (result.toString().equals(myResult.toString()) == false) {
			System.err.println("Addition test failed");
			System.err.println(first.toString() + " + " + second.toString() + " !=\n" + myFirst.toString() + " + "
					+ mySecond.toString());
			System.err.println(result.toString() + " !=\n" + myResult.toString());
		} else {
//			System.out.println("Addition test passed");
//			System.out.println(first.toString() + " + " + second.toString() + " =\n" + myFirst.toString() + " + "
//					+ mySecond.toString());
//			System.out.println(result.toString() + " =\n" + myResult.toString());
		}
		System.out.println("");
	}

	private void testSubtract(BigInteger first, BigInteger second, HugeInteger myFirst, HugeInteger mySecond) {
		BigInteger result = first.subtract(second);
		HugeInteger myResult = myFirst.subtract(mySecond);

		if (result.toString().equals(myResult.toString()) == false) {
			System.err.println("Subtraction test failed");
			System.err.println(first.toString() + " - " + second.toString() + " !=\n" + myFirst.toString() + " - "
					+ mySecond.toString());
			System.err.println(result.toString() + " !=\n" + myResult.toString());
		} else {
//			System.out.println("Subtraction test passed");
//			System.out.println(first.toString() + " - " + second.toString() + " =\n" + myFirst.toString() + " - "
//					+ mySecond.toString());
//			System.out.println(result.toString() + " =\n" + myResult.toString());
		}
		System.out.println("");
	}

	private void testMultiply(BigInteger first, BigInteger second, HugeInteger myFirst, HugeInteger mySecond) {
		BigInteger result = first.multiply(second);
		HugeInteger myResult = myFirst.multiply(mySecond);

		if (result.toString().equals(myResult.toString()) == false) {
			System.err.println("Multiplication test failed");
			System.err.println(first.toString() + " * " + second.toString() + " !=\n" + myFirst.toString() + " * "
					+ mySecond.toString());
			System.err.println(result.toString() + " !=\n" + myResult.toString());
		} else {
//			System.out.println("Multiplication test passed");
//			System.out.println(first.toString() + " * " + second.toString() + " =\n" + myFirst.toString() + " * "
//					+ mySecond.toString());
//			System.out.println(result.toString() + " =\n" + myResult.toString());
		}
		System.out.println("");
	}

	private void testDivide(BigInteger first, BigInteger second, HugeInteger myFirst, HugeInteger mySecond) {
		boolean hasDivisionError = false;
		BigInteger result = new BigInteger("0");
		HugeInteger myResult = new HugeInteger();
		try {
			result = first.divide(second);
		} catch (Exception e) {
			System.err.println(e.getLocalizedMessage());
			hasDivisionError = true;
		}
		try {
			myResult = myFirst.divide(mySecond);
		} catch (Exception e) {
			System.err.println(e.getLocalizedMessage());
			hasDivisionError = true;
		}

		if (!hasDivisionError && result.toString().equals(myResult.toString()) == false) {
			System.err.println("Division test failed");
			System.err.println(first.toString() + " / " + second.toString() + " !=\n" + myFirst.toString() + " / "
					+ mySecond.toString());
			System.err.println(result.toString() + " !=\n" + myResult.toString());
		} else if (!hasDivisionError) {
//			System.out.println("Division test passed");
//			System.out.println(first.toString() + " / " + second.toString() + " =\n" + myFirst.toString() + " / "
//					+ mySecond.toString());
//			System.out.println(result.toString() + " =\n" + myResult.toString());
		}
		System.out.println("");
	}

	private void testRemainder(BigInteger first, BigInteger second, HugeInteger myFirst, HugeInteger mySecond) {
		boolean hasDivisionError = false;
		BigInteger result = new BigInteger("0");
		HugeInteger myResult = new HugeInteger();
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

		if (!hasDivisionError && result.toString().equals(myResult.toString()) == false) {
			System.err.println("Remainder test failed");
			System.err.println(first.toString() + " % " + second.toString() + " !=\n" + myFirst.toString() + " % "
					+ mySecond.toString());
			 System.err.println(result.toString() + " !=\n" +
			 myResult.toString());
		} else if (!hasDivisionError) {
//			System.out.println("Remainder test passed");
//			System.out.println(first.toString() + " % " + second.toString() + " =\n" + myFirst.toString() + " % "
//					+ mySecond.toString());
//			System.out.println(result.toString() + " =\n" + myResult.toString());
		}
		System.out.println("");
	}

	public static void main(String[] args) {
		HugeIntegerTest test = new HugeIntegerTest();
		test.testIsZero1();
		test.testIsZero2();

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

			test.testAdd(first, second, myFirst, mySecond);
			test.testSubtract(first, second, myFirst, mySecond);
			test.testMultiply(first, second, myFirst, mySecond);
			test.testDivide(first, second, myFirst, mySecond);
			test.testRemainder(first, second, myFirst, mySecond);
		}
		
		for (int i = 0; i <= 10000; i++) {
			System.out.println("Round " + Integer.toString(i) + ". Generating two random numbers...\n");
			SecureRandom rnd = new SecureRandom();
			long num1 = Math.abs(rnd.nextLong()), num2 = Math.abs(rnd.nextInt());
			if (num1 < num2) {
				final long tmp = num1;
				num1 = num2;
				num2 = tmp;
			}

			BigInteger first = new BigInteger(Long.toString(num1));
			BigInteger second = new BigInteger(Long.toString(num2));

			HugeInteger myFirst = new HugeInteger(Long.toString(num1));
			HugeInteger mySecond = new HugeInteger(Long.toString(num2));

			test.testAdd(first, second, myFirst, mySecond);
			test.testSubtract(first, second, myFirst, mySecond);
			test.testMultiply(first, second, myFirst, mySecond);
			test.testDivide(first, second, myFirst, mySecond);
			test.testRemainder(first, second, myFirst, mySecond);
		}
		
		for (int i = 0; i <= 10000; i++) {
			System.out.println("Round " + Integer.toString(i) + ". Generating two random numbers...\n");
			SecureRandom rnd = new SecureRandom();
			long num1 = Math.abs(rnd.nextInt()), num2 = Math.abs(rnd.nextLong());
			if (num1 < num2) {
				final long tmp = num1;
				num1 = num2;
				num2 = tmp;
			}

			BigInteger first = new BigInteger(Long.toString(num1));
			BigInteger second = new BigInteger(Long.toString(num2));

			HugeInteger myFirst = new HugeInteger(Long.toString(num1));
			HugeInteger mySecond = new HugeInteger(Long.toString(num2));

			test.testAdd(first, second, myFirst, mySecond);
			test.testSubtract(first, second, myFirst, mySecond);
			test.testMultiply(first, second, myFirst, mySecond);
			test.testDivide(first, second, myFirst, mySecond);
			test.testRemainder(first, second, myFirst, mySecond);
		}
	}
}
