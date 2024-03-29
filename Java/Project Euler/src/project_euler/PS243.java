package project_euler;
/*
 * Author: Brandon Bernie
 * 
 * Problem 243
 * 
 * A positive fraction whose numerator is less than its denominator is called a
 * proper fraction. For any denominator, d, there will be d-1 proper fractions;
 * for example, with d?=?12: 
 * 1/12, 2/12, 3/12, 4/12, 5/12, 6/12, 7/12, 8/12, 9/12, 10/12, 11/12 .
 * 
 * We shall call a fraction that cannot be cancelled down a resilient fraction.
 * Furthermore we shall define the resilience of a denominator, R(d), to be
 * the ratio of its proper fractions that are resilient; for example, 
 * R(12) = 4/11.
 * In fact, d?=?12 is the smallest denominator having a resilience R(d) < 4/10.
 * 
 * Find the smallest denominator d, having a resilience R(d) < 15499/94744 .
 * 
 */

import java.util.List;

import org.bsalgorithms.math.util.NumberTheory;

public class PS243 {

	public static void main(String[] args) {
//		long start, stop;
//		final int PCHUNK = 3000000;
//		int chunk = 0;
		double tollerance = 15499d / 94744d;
		
		List<Integer> primes = NumberTheory.generatePrimes(50000000);
		System.out.println(primes.size());
		for(Integer i : primes)
			if((double)NumberTheory.eulerPhi(i+1)/(i) < tollerance)
				System.out.println(i);
	}
}
