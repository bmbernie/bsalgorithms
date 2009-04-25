import java.util.Vector;

/*
 * Author: Brandon Bernie
 * 
 * Problem 10
 * 
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * 
 * Find the sum of all the primes below two million.
 */

public class PS10 {

	public static void main(String[] args) {
		
		long sum = 0;
		long start = System.currentTimeMillis();
		for (int i = 2; i < 2000000; i++) {
			if (i == 2)
				sum += i;
			if (i % 2 != 0 && isPrime(i)) {
				sum += i;
			}
		}
		long stop = System.currentTimeMillis();
		System.out.println(sum + " " + (stop - start) + " ms");
		
		sum = 0;
		start = System.currentTimeMillis();
		Vector<Long> v = getPrimes(2000000);
		for(Long l : v)
			sum += l.longValue();
		stop = System.currentTimeMillis();
		System.out.println(sum + " " + (stop - start) + " ms");
		
	}

	public static boolean isPrime(long n) {
		if (n == 1)
			return false;
		else if (n < 4)
			return true;
		else if (n % 2 == 0)
			return false;
		else if (n < 9)
			return true;
		else if (n % 3 == 0)
			return false;
		else {
			long r = (long) Math.floor(Math.sqrt(n));
			long f = 5;
			while (f <= r) {
				if (n % f == 0)
					return false;
				if (n % (f + 2) == 0)
					return false;
				f += 6;
			}
			return true;
		}
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
}
