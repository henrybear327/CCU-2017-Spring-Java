import java.security.SecureRandom;

public class HugeIntegerTest {
	public static void main(String[] args) {		
		String aString = "8287364782348182394234682736480006283468";
		HugeInteger a = new HugeInteger();
		a.parse(aString);
		System.out.println(a.toString());
		System.out.println(aString);
		if(a.toString().compareTo(aString) != 0) 
			throw new RuntimeException("String differs");
		if(a.isZero() == true) 
			throw new RuntimeException("isZero() is broken");
		
		System.out.println("Here");
		String zeroString = "0";
		HugeInteger zero = new HugeInteger();
		zero.parse(zeroString);
		System.out.println(zero.toString());
		System.out.println(zeroString);
		if(zero.isZero() == false) 
			throw new RuntimeException("isZero() is broken");	
		
		// testing
		SecureRandom rnd = new SecureRandom();
		
		// addition
		
		// subtraction
		
		// multiplication
		
		// division
	}
}
