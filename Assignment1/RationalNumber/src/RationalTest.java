
public class RationalTest {
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
