import java.math.BigDecimal;
import java.util.Spliterator;

public class Rational {
	private int numerator;
	private int denominator;
	
	private int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a % b);
	}
	
	public Rational() {
		System.out.println("Init by no argument");
		
		// default to 0
		this.numerator = 0;
		this.denominator = 1;
	}
	
	public Rational(String fraction) {
		System.out.println("Init by String");

		String[] split = fraction.split("/");
		
		/*
		for (String string : split) {
			System.out.println(string);
		}
		*/
		this.numerator = Integer.parseInt(split[0]);
		this.denominator = Integer.parseInt(split[1]);
		
		int g = gcd(this.numerator, this.denominator);
		this.numerator /= g;
		this.denominator /= g;
	}
	
	public Rational(int numerator, int denominator) {
		System.out.println("Init by numerator and denominator");

		this.numerator = numerator;
		this.denominator = denominator;
				
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
	
	public static void main(String[] args) {
		Rational rational1 = new Rational();
		Rational rational2 = new Rational("7/3");
		Rational rational3 = new Rational(15, 10);
		
		System.out.println(rational3.toString());
		System.out.println(rational3.toDouble(0));
	}
}
