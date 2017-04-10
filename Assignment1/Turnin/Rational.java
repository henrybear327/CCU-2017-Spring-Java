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
		// System.out.println("Init by no argument");

		// default to 0
		this.numerator = 0;
		this.denominator = 1;
	}

	public Rational(String fraction) {
		// System.err.println("Init by String");

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
		// System.err.println("Init by numerator and denominator");

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
}
