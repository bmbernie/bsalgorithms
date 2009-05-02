import java.util.ArrayList;
import java.util.List;

/*
 * Author: Brandon Bernie
 * 
 * Euler published the remarkable quadratic formula: 
 * n² + n + 41
 * 
 * It turns out that the formula will produce 40 primes for the consecutive
 * values n = 0 to 39. However, when n = 40, 40^(2) + 40 + 41 = 40(40 + 1) + 41
 * is divisible by 41, and certainly when n = 41, 41² + 41 + 41 is clearly 
 * divisible by 41.
 * 
 * Using computers, the incredible formula  n² - 79n + 1601 was discovered,
 * which produces 80 primes for the consecutive values n = 0 to 79. The product
 * of the coefficients, -79 and 1601, is -126479.
 * 
 * Considering quadratics of the form:
 * n² + an + b, where |a| < 1000 and |b| < 1000
 * 
 * where |n| is the modulus/absolute value of n
 * e.g. |11| = 11 and |-4| = 4
 * 
 * Find the product of the coefficients, a and b, for the quadratic expression
 * that produces the maximum number of primes for consecutive values of n,
 * starting with n = 0.
 */

public class PS27 {

	public static void main(String[] args) {
		long start, stop;
		List<Integer> p = getPrimes(1000);
		int maxA=0, maxB=0, max=0;
		
		start = System.nanoTime();
		for (Integer b : p) {
			for (int a = -999; a < b; a++) {
				int n = 0;
				do {
					n++;
				} while (isPrime((n * n) + (a * n) + b));
				
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
	
	public static List<Integer> getPrimes(int upTo) {
		int size = upTo + 1;
		boolean[] flags = new boolean[size];
		List<Integer> primes = new ArrayList<Integer>();
		double limit = Math.sqrt(size);

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
	
    public static boolean isPrime(long n) {
    	if(n < 2)
    		return false;
    	else if(n < 4)
    		return true;
    	else if(n % 2 == 0)
    		return false;
    	else if(n < 9)
    		return true;
    	else if(n % 3 == 0)
    		return false;
    	else{
    		long r = (long)Math.floor(Math.sqrt(n));
    		long f = 5;
    		while(f <= r){
    			if(n % f == 0)
    				return false;
    			if(n % (f+2) == 0)
    				return false;
    			f+=6;
    		}
    		return true;
    	}
    }
}
