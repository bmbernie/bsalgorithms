/*
 * Author: Brandon Bernie
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
}
