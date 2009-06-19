/*
 * Author: Brandon Bernie
 * 
 * Problem 10
 * 
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * 
 * Find the sum of all the primes below two million.
 */

import org.bsalgorithms.math.util.NumberTheory;

import java.util.List;

public class PS010 {

	public static void main(String[] args) {

		long sum = 0;
		long start = System.currentTimeMillis();
		for (int i = 2; i < 2000000; i++) {
			if (i == 2)
				sum += i;
			if (i % 2 != 0 && NumberTheory.isPrime(i)) {
				sum += i;
			}
		}
		long stop = System.currentTimeMillis();
		System.out.println(sum + " " + (stop - start) + " ms");
		
		sum = 0;
		start = System.currentTimeMillis();
		List<Integer> p = NumberTheory.generatePrimes(2000000);
		for (Integer l : p)
			sum += l;
		stop = System.currentTimeMillis();
		System.out.println(sum + " " + (stop - start) + " ms");
	}
}
