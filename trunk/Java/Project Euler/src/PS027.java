/*
 * Author: Brandon Bernie
 * 
 * Euler published the remarkable quadratic formula: 
 * n� + n + 41
 * 
 * It turns out that the formula will produce 40 primes for the consecutive
 * values n = 0 to 39. However, when n = 40, 40^(2) + 40 + 41 = 40(40 + 1) + 41
 * is divisible by 41, and certainly when n = 41, 41� + 41 + 41 is clearly 
 * divisible by 41.
 * 
 * Using computers, the incredible formula  n� - 79n + 1601 was discovered,
 * which produces 80 primes for the consecutive values n = 0 to 79. The product
 * of the coefficients, -79 and 1601, is -126479.
 * 
 * Considering quadratics of the form:
 * n� + an + b, where |a| < 1000 and |b| < 1000
 * 
 * where |n| is the modulus/absolute value of n
 * e.g. |11| = 11 and |-4| = 4
 * 
 * Find the product of the coefficients, a and b, for the quadratic expression
 * that produces the maximum number of primes for consecutive values of n,
 * starting with n = 0.
 */

import org.bsalgorithms.math.util.NumberTheory;

import java.util.List;

public class PS027 {

	public static void main(String[] args) {
		long start, stop;
		List<Integer> p = NumberTheory.generatePrimes(1000);
		int maxA=0, maxB=0, max=0;
		
		start = System.nanoTime();
		for (Integer b : p) {
			for (int a = -999; a < b; a++) {
				int n = 0;
				do {
					n++;
				} while (NumberTheory.isPrime((n * n) + (a * n) + b));
				
				if(n > max){
					max = n;
					maxA = a;
					maxB = b;
				}
			}
		}
		stop = System.nanoTime();
		System.out.println("a: " + maxA + " b: " + maxB + " total primes: " + max);
		System.out.println(maxA * maxB + " " + (stop - start)/1000000 + " ms" );
	}
}
