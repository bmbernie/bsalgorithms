/*
 * Author: Brandon Bernie
 * 
 * Problem 5
 * 
 * 2520 is the smallest number that can be divided by each of the numbers
 * from 1 to 10 without any remainder.
 *  
 * What is the smallest number that is evenly divisible by all of the numbers 
 * from 1 to 20?
*/

import java.util.Vector;

public class PS5 {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		for(int i = 20; i < Integer.MAX_VALUE; i+=20)
			if(i%1==0 && i%2==0 && i%3==0 && i%4==0 && i%5==0 &&
			   i%6==0 && i%7==0 && i%8==0 && i%9==0 && i%10==0 &&
			   i%11==0 && i%12==0 && i%13==0 && i%14==0 && i%15==0 &&
			   i%16==0 && i%17==0 && i%18==0 && i%19==0 && i%20==0){
				System.out.println(i);
				break;
			}
		long stop = System.currentTimeMillis();
		System.out.println((stop - start) + " ms");
		
		start = System.nanoTime();
		Vector<Long> v = getPrimes(20);
		Long[] primes = new Long[v.size()];
		v.toArray(primes);	
		int[] exp = new int[primes.length];
		int k = 20;
		int n = 1;
		int i = 0;
		boolean check = true;
		double limit = Math.sqrt(k);	
		while(i <= primes.length-1){
			exp[i] = 1;
			if(check)
				if(primes[i] <= limit)
					exp[i] = (int)Math.floor(Math.log(k) / Math.log(primes[i]));
				else
					check = false;
			n *= Math.pow(primes[i], exp[i]);
			i++;
		}
		stop = System.nanoTime();
		System.out.println(n + " " + (stop - start) + " ns");

	}
	
	public static Vector<Long> getPrimes (int upTo) {
		int size = upTo + 1;
		boolean [] flags = new boolean[size];
		Vector<Long> primes = new Vector<Long> ();
		double limit = Math.sqrt (size);

		// Set flags
		for (int i = 2; i < size; i++) {
			flags[i] = true;
		}

		// Cross out multiples of 2
		int j = 2;
		for (int i = j + j; i < size; i = i + j) {
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
				primes.addElement (new Long (i));
			}
		}
		return primes;
	}
	
	public static String primeFactors(int n){
        StringBuffer factors = new StringBuffer();
        
        // for each potential factor i
        for (int i = 2; i <= n / i; i++) {
            // if i is a factor of N, repeatedly divide it out
            while (n % i == 0) {
                factors.append(Integer.toString(i) + " "); 
                n = n / i;
            }
        }
        // if biggest factor occurs only once, n > 1
        if (n > 1) 
        	factors.append(Integer.toString(n));
        
        return factors.toString();
	}

}
