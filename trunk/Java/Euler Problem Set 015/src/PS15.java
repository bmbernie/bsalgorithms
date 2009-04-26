/*
 * Author: Brandon Bernie
 * 
 * Starting in the top left corner of a 2×2 grid, there are 6 routes 
 * (without backtracking) to the bottom right corner.
 * 
 * How many routes are there through a 20×20 grid?
 */

import java.math.BigInteger;

public class PS15 {

	public static void main(String[] args) {
		BigInteger numerator = BigInteger.ONE;
		BigInteger denominator = BigInteger.ONE;
		long start, stop;
		
		//Full formula
		start = System.nanoTime();
		numerator = bigFactorial(40);
		denominator = bigFactorial(20);
		denominator = denominator.multiply(denominator);
		numerator = numerator.divide(denominator);
		stop = System.nanoTime();
		System.out.println(numerator.toString() + " " + (stop - start) + " ns");
		
		//pre calculated algebra
		numerator = BigInteger.ONE;
		start = System.nanoTime();
		for(int i = 21; i <= 40; i++)
			numerator = numerator.multiply(new BigInteger(Integer.toString(i)));
		denominator = bigFactorial (20);
		numerator = numerator.divide(denominator);
		stop = System.nanoTime();
		System.out.println(numerator.toString() + " " + (stop - start) + " ns");	
	}
	
	public static BigInteger bigFactorial(int n){
		BigInteger result = BigInteger.ONE;
		for(int i = 2; i <=n; i++)
			result = result.multiply(new BigInteger(Integer.toString(i)));
		return result;
	}
}
