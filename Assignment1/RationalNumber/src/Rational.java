import java.math.BigDecimal;

public class Rational {
	private int numerator;
	private int denominator;

	private int gcd(int a, int b) {
		a = Math.abs(a);
		b = Math.abs(b);
		return b == 0 ? a : gcd(b, a % b);
	}

	public void setNumerator(int numerator) {
		this.numerator = numerator;
	}

	public void setDenominator(int denominator) {
		this.denominator = denominator;
	}

	public int getNumerator() {
		return this.numerator;
	}

	public int getDenominator() {
		return this.denominator;
	}

	public Rational() {
		System.out.println("Init by no argument");

		// default to 0
		this.numerator = 0;
		this.denominator = 1;
	}

	public Rational(String fraction) {
		System.err.println("Init by String");

		String[] split = fraction.split("/");

		/*
		 * for (String string : split) { System.out.println(string); }
		 */
		this.numerator = Integer.parseInt(split[0]);
		this.denominator = Integer.parseInt(split[1]);

		if (this.denominator == 0) {
			throw new RuntimeException("Denominator is zero");
		}

		int g = gcd(this.numerator, this.denominator);

		this.numerator /= g;
		this.denominator /= g;
	}

	public Rational(int numerator, int denominator) {
		System.err.println("Init by numerator and denominator");

		this.numerator = numerator;
		this.denominator = denominator;

		if (this.denominator == 0) {
			throw new RuntimeException("Denominator is zero");
		}

		int g = gcd(this.numerator, this.denominator);
		this.numerator /= g;
		this.denominator /= g;
	}

	public String toString() {
		return String.valueOf(this.numerator) + "/" + String.valueOf(this.denominator);
	}

	public String toDouble(int precision) {
		BigDecimal first = new BigDecimal(this.numerator);
		BigDecimal second = new BigDecimal(this.denominator);
		BigDecimal result = first.divide(second, precision, BigDecimal.ROUND_HALF_UP);

		return result.toString();
	}

	public static Rational add(Rational a, Rational b) {
		int lower = a.getDenominator() * b.getDenominator();
		int upper = a.getNumerator() * b.getDenominator() + b.getNumerator() * a.getDenominator();

		return new Rational(upper, lower);
	}

	public static Rational subtract(Rational a, Rational b) {
		int lower = a.getDenominator() * b.getDenominator();
		int upper = a.getNumerator() * b.getDenominator() - b.getNumerator() * a.getDenominator();

		return new Rational(upper, lower);
	}

	public static Rational multiply(Rational a, Rational b) {
		int lower = a.getDenominator() * b.getDenominator();
		int upper = a.getNumerator() * b.getNumerator();

		return new Rational(upper, lower);
	}

	public static Rational divide(Rational a, Rational b) {
		// (a / b) / (c / d) = (a / b) * (d / c)
		int lower = a.getDenominator() * b.getNumerator();
		int upper = b.getDenominator() * a.getNumerator();

		return new Rational(upper, lower);
	}

	public static void main(String[] args) {
		Rational a, b;

		// 0/1 + 1/1 = 1/1
		a = new Rational();
		b = new Rational(1, 1);
		System.out.println(Rational.add(a, b).toString());
		System.out.println(Rational.add(a, b).toDouble(6));

		// 1/2 + 1/3 = 5/6
		a = new Rational(1, 2);
		b = new Rational(1, 3);
		System.out.println(Rational.add(a, b).toString());
		System.out.println(Rational.add(a, b).toDouble(6));

		// 8/9 + 1/9 = 1/1
		a = new Rational(8, 9);
		b = new Rational(1, 9);
		System.out.println(Rational.add(a, b).toString());
		System.out.println(Rational.add(a, b).toDouble(6));

		// 1/6 - 1/12 = 1/12
		a = new Rational(1, 6);
		b = new Rational(1, 12);
		System.out.println(Rational.subtract(a, b).toString());
		System.out.println(Rational.subtract(a, b).toDouble(6));

		// 4/17 / 7/3 = 12/119
		a = new Rational(4, 17);
		b = new Rational(7, 3);
		System.out.println(Rational.divide(a, b).toString());
		System.out.println(Rational.divide(a, b).toDouble(6));

		// 203/16957 * 9299/5887 = 17/899
		a = new Rational(203, 16957);
		b = new Rational(9299, 5887);
		System.out.println(Rational.multiply(a, b).toString());
		System.out.println(Rational.multiply(a, b).toDouble(6));
	}
}
