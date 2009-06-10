/*
 * Author: Brandon Bernie
 * 
 * Problem 47
 * 
 * The first two consecutive numbers to have two distinct prime factors are:
 * 14 = 2 × 7
 * 15 = 3 × 5
 * 
 * The first three consecutive numbers to have three distinct prime factors
 * are:
 * 
 * 644 = 2² × 7 × 23
 * 645 = 3 × 5 × 43
 * 646 = 2 × 17 × 19.
 * 
 * Find the first four consecutive integers to have four distinct primes
 * factors. What is the first of these numbers?
 */

import org.bsalgorithms.NumberTheory;


public class PS047 {

	public static void main(String[] args) {
		long start, stop;
		
		start = System.nanoTime();
		for(int i = 210; i < Integer.MAX_VALUE; i++){
			if (NumberTheory.factorInteger(i).size() == 4
					&& NumberTheory.factorInteger(i + 1).size() == 4
					&& NumberTheory.factorInteger(i + 2).size() == 4
					&& NumberTheory.factorInteger(i + 3).size() == 4) {
				System.out.print(i);
				break;
			}
		}
		stop = System.nanoTime();
		
		System.out.println(" " + (stop - start)/1000000 + " ms");
		
	}

}
