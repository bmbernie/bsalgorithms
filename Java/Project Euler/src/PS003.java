/*
 * Author: Brandon Bernie
 * 
 * Problem 3
 * 
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * 
 * What is the largest prime factor of the number 
 * 600851475143 ?
 */

import org.bsalgorithms.NumberTheory;

public class PS003 {

	public static void main(String[] args) {

		long number = 600851475143L;
		long max = 0;
		long start = System.currentTimeMillis();
		for (long x = 3, end = (int) Math.sqrt(number); x <= end; x += 2)
			if (number % x == 0)
				if (NumberTheory.isPrime(x))
					if (x > max)
						max = x;
		long stop = System.currentTimeMillis();

		System.out.println(max + " " + (stop - start) + " ms");
	}
}
