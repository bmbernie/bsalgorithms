/*
 * Author: Brandon Bernie
 * 
 * A unit fraction contains 1 in the numerator. The decimal representation of
 * the unit fractions with denominators 2 to 10 are given:
 * 
 * 1/2	= 	0.5
 * 1/3	= 	0.(3)
 * 1/4	= 	0.25
 * 1/5	= 	0.2
 * 1/6	= 	0.1(6)
 * 1/7	= 	0.(142857)
 * 1/8	= 	0.125
 * 1/9	= 	0.(1)
 * 1/10	= 	0.1
 * 
 * Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle. It can
 * be seen that 1/7 has a 6-digit recurring cycle.
 * 
 * Find the value of d < 1000 for which 1/d contains the longest
 * recurring cycle in its decimal fraction part.
 */

import java.util.ArrayList;
import java.util.List;

public class PS26 {

	public static void main(String[] args) {
		int cycleLength = 0, limit = 1000, denominator = 0;;
		List<Integer> primeList = getPrimes(limit);
		
		for(Integer p : primeList){
			int base = 10;
			int r = 1;
			int t = 0;
			StringBuffer n = new StringBuffer();
			
			if(base % p == 0)
				continue;
			
			do{
				t++;
				int x = r * base;
				int d = x / p;
				r = x % p;
				n.append(d);
			}while(r != 1);
			
			if(n.length() > cycleLength){
				cycleLength = n.length();
				denominator = p;
			}
		}
		
		System.out.println(denominator);
	}
	
	public static List<Integer> getPrimes (int upTo) {
		int size = upTo + 1;
		boolean [] flags = new boolean[size];
		List<Integer> primes = new ArrayList<Integer> ();
		double limit = Math.sqrt (size);

		// Set flags
		for (int i = 2; i < size; i++) {
			flags[i] = true;
		}

		// Cross out multiples of 2
		int j = 2;
		for (int i = j + j; i < size; i += j) {
			flags[i] = false;
		}

		// Cross out multiples of odd numbers
		for (j = 3; j <= limit; j = j + 2) {
			if (flags[j]) {
				for (int i = j + j; i < size; i = i + j) {
					flags[i] = false;
				}
			}
		}

		// Build list of primes from what is left
		for (int i = 2; i < size; i++) {
			if (flags[i]) {
				primes.add(i);
			}
		}
		return primes;
	}
}
