import java.math.BigDecimal;

import sun.util.logging.resources.logging;

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
		// Rational rational1 = new Rational();
		Rational rational2 = new Rational("9/7");
		Rational rational3 = new Rational(11, 2);
		
		System.out.println(rational2.toString());
		System.out.println(rational3.toString());
		
		System.out.println(rational2.toDouble(6));
		System.out.println(rational3.toDouble(6));
		
		System.out.println(Rational.add(rational2, rational3).toString());
		System.out.println(Rational.subtract(rational2, rational3).toString());
		System.out.println(Rational.multiply(rational2, rational3).toString());
		System.out.println(Rational.divide(rational2, rational3).toString());
	}
}
