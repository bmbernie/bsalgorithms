/*
 * Author: Brandon Bernie
 * 
 * Problem 249
 * 
 * Let S = {2, 3, 5, ..., 4999} be the set of prime numbers less than 5000.
 * 
 * Find the number of subsets of S, the sum of whose elements is a prime number.
 * 
 * Enter the rightmost 16 digits as your answer.
 */

import org.bsalgorithms.NumberTheory;
import java.math.BigInteger;
import java.util.List;
import java.util.HashSet;

public class PS249 {

	public static void main(String[] args) {
		List<Integer> S = NumberTheory.generatePrimes(5000);
		List<Integer> pList = NumberTheory.generatePrimes(1548136);
		HashSet<Integer> primeHashSet = new HashSet<Integer>(pList.size());
		BigInteger sum = BigInteger.ZERO;
		
		primeHashSet.addAll(pList);
		
		
	
	}

}
