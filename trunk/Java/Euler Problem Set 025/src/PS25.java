/*
 * Author: Brandon Bernie
 * 
 * Problem 025
 * 
 * The Fibonacci sequence is defined by the recurrence relation:
 * 
 * F_(n) = F_(n-1) + F_(n-2), where F_(1) = 1 and F_(2) = 1.
 * 
 * Hence the first 12 terms will be:
 * F_(1) = 1
 * F_(2) = 1
 * F_(3) = 2
 * F_(4) = 3
 * F_(5) = 5
 * F_(6) = 8
 * F_(7) = 13
 * F_(8) = 21
 * F_(9) = 34
 * F_(10) = 55
 * F_(11) = 89
 * F_(12) = 144
 * The 12th term, F_(12), is the first term to contain three digits.
 *  
 * What is the first term in the Fibonacci sequence to contain 1000 digits?
 */

import java.math.BigInteger;

public class PS25 {
	
	public static void main(String[] args) {
		long start, stop;
		BigInteger fib1 = BigInteger.ONE;
		BigInteger fib2 = BigInteger.ONE;
		BigInteger fibNext = BigInteger.ZERO;
		double phi = 1.61803399;
		double digits = 0;

		//brute force
		start = System.nanoTime();
		int n = 2; // 2 terms in
		do{
			fibNext = fib1.add(fib2);
			fib1 = fib2;
			fib2 = fibNext;
		
			n++;
		}while(fib2.toString().length() < 1000);
		stop = System.nanoTime();	
		System.out.println(n + " " + (stop - start)/1000000 + " ms");
		
		//Binets formula for nth fibbonacci
		//(1/sqrt(5)(phi^n + -phi^n)
		start = System.nanoTime();
		n = 0;
		while(digits < 999) {
			n++;
			digits = n * Math.log10(phi) - Math.log10(5.0) / 2;
		}
		stop = System.nanoTime();
		System.out.println(n + " " + (stop - start)/1000000 + " ms ");
		
	}

}
