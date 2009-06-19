package project_euler;
/*
 * Author: Brandon Bernie
 * 
 * Problem 50
 * 
 * The prime 41, can be written as the sum of six consecutive primes:
 * 41 = 2 + 3 + 5 + 7 + 11 + 13
 * 
 * This is the longest sum of consecutive primes that adds to a prime below
 * one-hundred.
 * 
 * The longest sum of consecutive primes below one-thousand that adds to a
 * prime, contains 21 terms, and is equal to 953.
 * 
 * Which prime, below one-million, can be written as the sum of the most
 * consecutive primes?
 */

import org.bsalgorithms.math.util.NumberTheory;

import java.util.List;

public class PS050 {

	public static void main(String[] args) {
		long start, stop;
		final int LIMIT = 1000000;
		List<Integer> primes = NumberTheory.generatePrimes(LIMIT);
		int p = 0, terms = 1, mcp = 0, mterms = 0;
		
		start = System.nanoTime();
		for(int i = 0, numPrimes = primes.size(); i < numPrimes ; i++){
			terms = 1;
			p = primes.get(i);
			for(int j = i+1; j < numPrimes; j++){
				if(p + primes.get(j) < LIMIT){
					p += primes.get(j);
					terms++;
					if(terms > mterms && NumberTheory.isPrime(p)){
						mcp = p;
						mterms = terms;
					}
				}
				else
					break;
			}	
		}
		stop = System.nanoTime();
		
		System.out.print(mcp + " " + mterms);
		System.out.println(" " + (stop - start)/1000000 + " ms");
		
		
	}

}
