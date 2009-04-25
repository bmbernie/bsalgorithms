/*
 * Author: Brandon Bernie 
 * 
 * Problem 7
 * 
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
 * that the 6th prime is 13.
 * 
 * What is the 10001th prime number?
 */

public class PS7 {

	public static void main(String[] args) {
		int counter = 2;
		long number = 3;
		long start = System.currentTimeMillis();
		do {
			number += 2;
			if (isPrime(number))
				counter++;
		} while (counter < 10001);
		long stop = System.currentTimeMillis();
		System.out.println(number + " " + (stop - start) + " ms");

		start = System.currentTimeMillis();
		System.out.println(getNthPrime(10001) + " "
				+ (System.currentTimeMillis() - start) + " ms");
	}

	public static long getNthPrime(long n) {
		if (n == 1)
			return 2;
		if (n == 2)
			return 3;
		if (n == 3)
			return 5;
		if (n == 4)
			return 7;

		long i = 4;
		long p = 7;
		while (true) {
			if (isPrime(p += 4))
				i++;
			if (i == n)
				return p;
			if (isPrime(p += 2))
				i++;
			if (i == n)
				return p;
			if (isPrime(p += 4))
				i++;
			if (i == n)
				return p;
			if (isPrime(p += 2))
				i++;
			if (i == n)
				return p;
			if (isPrime(p += 4))
				i++;
			if (i == n)
				return p;
			if (isPrime(p += 6))
				i++;
			if (i == n)
				return p;
			if (isPrime(p += 2))
				i++;
			if (i == n)
				return p;
			if (isPrime(p += 6))
				i++;
			if (i == n)
				return p;
		}
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
