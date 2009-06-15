package org.bsalgorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * The NumberTheory class provides a set of static methods which lie in the
 * mathematical domain of number theory.
 * 
 * @author Brandon Bernie
 * @version 1.0
 */
public class NumberTheory {

	/**
	 * A positive integer is concidered Deficient when the sum of its proper
	 * divisors is less than the number itself. Deficient numbers are sometimes
	 * called defective numbers. Primes, prime powers, and any divisors of a
	 * perfect or deficient number are all deficient.
	 * <p>
	 * <u>Algorithm:</u> <br>
	 * <code>sigma(n) - n < n</code>, or <code>sigma(n) < 2n</code> </ul>
	 * 
	 * @see #sigma(int)
	 * @see #sigmaProperDivisors(int)
	 * 
	 * @param n
	 *            positive integer, <code>(n < 0)</code>
	 *            
	 * @return <code>true</code> if the positive integer <code>n</code> is
	 *         Deficient
	 *         
	 * @author Brandon Bernie
	 */
	public static boolean isDeficient(int n) {
		return (sigmaProperDivisors(n) < n);
	}

	/**
	 * A positive integer is considered Perfect when the sum of its proper
	 * divisors is equal to the number itself.
	 * <p>
	 * <u>Algorithm:</u> <br>
	 * <code>sigma(n) - n == n</code>, or <code>sigma(n) == 2n </code> </ul>
	 * 
	 * @see #sigma(int)
	 * @see #sigmaProperDivisors(int)
	 * 
	 * @param n
	 *            positive integer, <code>(n < 0)</code>
	 *            
	 * @return <code>true</code> if the positive integer <code>n</code> is
	 *         Perfect
	 *         
	 * @author Brandon Bernie
	 */
	public static boolean isPerfect(int n) {
		return (sigmaProperDivisors(n) == n);
	}

	/**
	 * A positive integer is considered Abundant when the sum of its proper
	 * divisors is greater than the number itself
	 * <p>
	 * <u>Algorithm:</u> <br>
	 * <code>sigma(n) - n > n</code>, or <code>sigma(n) > 2n</code> </ul>
	 * 
	 * @see #sigma(int)
	 * @see #sigmaProperDivisors(int)
	 * 
	 * @param n
	 *            positive integer, <code>(n > 0)</code>
	 *            
	 * @return <code>true</code> if the positive integer <code>n</code> is
	 *         Abundant
	 *         
	 * @author Brandon Bernie
	 */
	public static boolean isAbundant(int n) {
		return (sigmaProperDivisors(n) > n);
	}

	/**
	 * For positive integer <code>n</code>, the sigma function returns the sum
	 * of the positive divisors of <code>n</code>
	 * <p>
	 * <u>Example:</u> <br>
	 * <code>sigma(4) == 1 + 2 + 4 == 6</code>
	 * 
	 * @see #sigmaProperDivisors(int)
	 * 
	 * @param n
	 *            positive integer, <code>(n > 0)</code>
	 *            
	 * @return the sum of all divisors for <code>n</code>
	 * 
	 * @author Brandon Bernie
	 */
	public static int sigma(int n) {
		int sum = 1;
		int p = 2;
		
		while (p * p <= n && n > 1) {
			int j;
			if (n % p == 0) {
				j = p * p;
				n /= p;
				while (n % p == 0) {
					j *= p;
					n = n / p;
				}
				sum *= (j - 1);
				sum /= (p - 1);
			}
			if (p == 2)
				p = 3;
			else
				p += 2;
		}
		if (n > 1)
			sum *= (n + 1);

		return sum;
	}

	/**
	 * For positive integer <code>n</code>, the sigmaProperDivisors function
	 * returns the sum of the positive proper divisors of <code>n</code>
	 * <p>
	 * <u>Example:</u> <br>
	 * <code>sigmaProperDivisors(4) == 1 + 2 == 3</code>
	 * 
	 * @see #sigma(int)
	 * 
	 * @param n
	 *            positive integer, <code>(n > 0)</code>
	 *            
	 * @return the sum of all the proper divisors for <code>n</code>
	 * 
	 * @author Brandon Bernie
	 */
	public static int sigmaProperDivisors(int n) {
		return sigma(n) - n;
	}

	/**
	 * For integer <code>n</code>, the isOdd function returns <code>true</code>
	 * if the integer is odd and returns <code>false</code> if the integer is
	 * even
	 * 
	 * @param n
	 *            positive integer, <code>(n > 0)</code>
	 *            
	 * @return <code>true</code> if the integer <code>n</code> is odd and<br>
	 *         <code>false</code> if the integer <code>n</code> is even
	 *         
	 * @author Brandon Bernie
	 */
	public static boolean isOdd(int n) {
		return ((n & 1) != 0);
	}

	/**
	 * A prime number (or prime integer, often simply called a "prime" for
	 * short) is a positive integer p>1 that has no positive integer divisors
	 * other than 1 and p itself. More concisely, a prime number p is a positive
	 * integer having exactly one positive divisor other than 1.
	 * <p>
	 * <u>Assumptions:</u>
	 * <li>All primes except 2 are odd.
	 * <li>All primes greater than 3 can be written in the form 6k+/-1. </ul>
	 * 
	 * @param n
	 *            positive integer, <code>(n > 0)</code>
	 *            
	 * @return <code>true</code> if the integer <code>n</code> is prime and
	 *         <code>false</code> if the integer <code>n</code> is not prime
	 *         
	 * @author Brandon Bernie
	 */
	public static boolean isPrime(long n) {
		if (n < 2)
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
	
	/**
	 * A circular prime is a positive integer p>1 such that it remains prime on
	 * any cyclic rotation of its digits. Any one digit prime is circular by
	 * default. In base ten, any circular prime with two or more digits can only
	 * contain the digits 1, 3, 7 and 9.
	 * <p>
	 * 
	 * @param n
	 *            positive integer, <code>(n > 0)</code>
	 *            
	 * @return <code>true</code> if the integer <code>n</code> is a circular
	 *         prime <br>
	 *         <code>false</code> if the integer <code>n</code> is not a
	 *         circular prime
	 * 
	 * @author Brandon Bernie
	 */
	public static boolean isCircularPrime(int n){
		int exp = 0;
		
		while((int)(n / (int)Math.pow(10, exp)) != 0)
			exp++;
		exp--;
		
		if(exp == 0)
			return true;
		
		for(int i = 0; i < exp; i++){
			int digit =  n / (int)Math.pow(10, i) % 10;
			if(digit % 2 == 0 || digit % 5 == 0 || digit == 0)
				return false;
		}
		
		for(int i = 0; i < exp; i++){
			int temp = n / 10;		
			n = (n%10) * (int)Math.pow(10, exp) + temp;
			if(!NumberTheory.isPrime(n))
				return false;
		}
		return true;	
	}

	/**
	 * For integer <code>n</code>, the function factorInteger returns a list of
	 * the prime factors of the integer <code>n</code> together with their
	 * exponents.
	 * <p>
	 * <u>Examples:</u> <br>
	 * <code>factorInteger(2) == [[2,1]]</code> <br>
	 * <code>factorInteger(8) == [[2,3]]</code> <br>
	 * <code>factorInteger(12) == [[2,2],[3,1]]</code>
	 * 
	 * 
	 * @param n
	 *            positive integer, <code>(n > 0)</code>
	 *            
	 * @return A list of prime factors for the integer <code>n</code> in
	 *         [coefficient, exponent] pairs
	 *         
	 * @author Brandon Bernie
	 */
	public static List<Pair<Integer, Integer>> factorInteger(int n) {
		List<Pair<Integer, Integer>> factors = new ArrayList<Pair<Integer, Integer>>();

		if (n == 0) {
			factors.add(new Pair<Integer, Integer>(0, 1));
			return factors;
		}

		// for each potential factor i
		for (int i = 2; i <= n / i; i++) {
			int exponent = 0;
			
			// if i is a factor of N, repeatedly divide it out
			while (n % i == 0) {
				exponent++;
				n = n / i;
			}

			if (exponent > 0)
				factors.add(new Pair<Integer, Integer>(i, exponent));
		}
		
		// if biggest factor occurs only once, n > 1
		if (n > 1)
			factors.add(new Pair<Integer, Integer>(n, 1));

		return factors;
	}
	
	/**
	 * For integer <code>n</code>, the function factorInteger returns a list of
	 * the prime factors of the integer <code>n</code> together with their
	 * exponents.
	 * <p>
	 * <u>Examples:</u> <br>
	 * <code>factorInteger(2) == [[2,1]]</code> <br>
	 * <code>factorInteger(8) == [[2,3]]</code> <br>
	 * <code>factorInteger(12) == [[2,2],[3,1]]</code>
	 * 
	 * 
	 * @param n
	 *            positive integer, <code>(n > 0)</code>
	 *            
	 * @return A list of prime factors for the integer <code>n</code> in
	 *         [coefficient, exponent] pairs
	 *         
	 * @author Brandon Bernie
	 */
	public static List<Pair<Long, Long>> factorLongInteger(long n) {
		List<Pair<Long, Long>> factors = new ArrayList<Pair<Long, Long>>();

		if (n == 0) {
			factors.add(new Pair<Long, Long>(0L, 1L));
			return factors;
		}

		// for each potential factor i
		for (long i = 2; i <= n / i; i++) {
			long exponent = 0;
			
			// if i is a factor of N, repeatedly divide it out
			while (n % i == 0) {
				exponent++;
				n = n / i;
			}

			if (exponent > 0)
				factors.add(new Pair<Long, Long>(i, exponent));
		}
		
		// if biggest factor occurs only once, n > 1
		if (n > 1)
			factors.add(new Pair<Long, Long>(n, 1L));

		return factors;
	}

	/**
	 * For integer <code>n</code>, the prime counting function,
	 * <code>primePi(n)</code>, is the number of primes less than or equal to
	 * <code>n</code>.
	 * <p>
	 * <u>Examples:</u> <br>
	 * The primes under 25 are 2,3,5,7,11,13,17,19, and 23<br>
	 * <code>primePi(25) == 9</code><br>
	 * <code>primePi(3) == 2</code><br>
	 * <code>primePi(10) == 4</code>
	 * 
	 * @param n
	 *            positive integer, <code>(n > 0)</code>
	 *            
	 * @return the number of primes upto the integer <code>n</code>
	 * 
	 * @author Brandon Bernie
	 */
	public static int primePi(int n) {
		int size = n + 1, count = 0;
		boolean[] flags = new boolean[size];
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

		// count the primes
		for (int i = 2; i < size; i++) {
			if (flags[i]) {
				count++;
			}
		}
		
		return count;
	}

	/**
	 * For integer <code>n</code>, the prime generating function,
	 * <code>generatePrimes(n)</code>, will generate a list of prime numbers
	 * upto and uncluding <code>n</code> if <code>n</code> is prime.
	 * 
	 * @param upTo
	 *            positive integer, <code>(upTo >0)</code>
	 *            
	 * @return a list of prime numbers upto <code>n</code>
	 * 
	 * @author Brandon Bernie
	 */
	public static List<Integer> generatePrimes(int upTo) {
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

	/**
	 * The totient function <code>phi(n)</code>, also called Euler's totient
	 * function, is defined as the number of positive integers <code><=</code>
	 * <code>n</code> that are relatively prime to (i.e., do not contain any
	 * factor in common with) <code>n</code>, where 1 is counted as being
	 * relatively prime to all numbers. Since a number less than or equal to and
	 * relatively prime to a given number is called a totative, the totient
	 * function <code>euelerPhi(n)</code> can be simply defined as the number of
	 * totatives of <code>n</code>.
	 * <p>
	 * <u>Example:</u><br>
	 * There are eight totatives of 24: (1, 5, 7, 11, 13, 17, 19, and 23) <br>
	 * <code>eulerPhi(24) == 8</code>.
	 * 
	 * @param n
	 *            positive integer, <code>(n > 0)</code>
	 *            
	 * @return the number of totatives of positive integer n
	 * 
	 * @author Brandon Bernie
	 */
	public static int eulerPhi(int n) {
		int totient, q, k;
		if (n > 0) {
			totient = q = n;
			if (q % 2 == 0) {
				totient /= 2;
				do {
					q /= 2;
				} while (q % 2 == 0);
			}
			if (q % 3 == 0) {
				totient = totient * 2 / 3;
				do {
					q /= 3;
				} while (q % 3 == 0);
			}
			k = 5;
			while (k * k <= q) {
				if (k % 3 != 0 && q % k == 0) {
					totient = totient * (k - 1) / k;
					do {
						q /= k;
					} while (q % k == 0);
				}
				k += 2;
			}
			if (q > 1) {
				totient = totient * (q - 1) / q;
			}
			return totient;
		}
		else 
			return 0;
	}
	
	/**
	 * The totient function <code>phi(n)</code>, also called Euler's totient
	 * function, is defined as the number of positive integers <code><=</code>
	 * <code>n</code> that are relatively prime to (i.e., do not contain any
	 * factor in common with) <code>n</code>, where 1 is counted as being
	 * relatively prime to all numbers. Since a number less than or equal to and
	 * relatively prime to a given number is called a totative, the totient
	 * function <code>euelerPhi(n)</code> can be simply defined as the number of
	 * totatives of <code>n</code>.
	 * <p>
	 * <u>Example:</u><br>
	 * There are eight totatives of 24: (1, 5, 7, 11, 13, 17, 19, and 23) <br>
	 * <code>eulerPhi(24) == 8</code>.
	 * 
	 * @param n
	 *            positive integer, <code>(n > 0)</code>
	 *            
	 * @return the number of totatives of positive integer n
	 * 
	 * @author Brandon Bernie
	 */
	public static long eulerPhi(long n) {
		long totient, q, k;
		if (n > 0) {
			totient = q = n;
			if (q % 2 == 0) {
				totient /= 2;
				do {
					q /= 2;
				} while (q % 2 == 0);
			}
			if (q % 3 == 0) {
				totient = totient * 2 / 3;
				do {
					q /= 3;
				} while (q % 3 == 0);
			}
			k = 5;
			while (k * k <= q) {
				if (k % 3 != 0 && q % k == 0) {
					totient = totient * (k - 1) / k;
					do {
						q /= k;
					} while (q % k == 0);
				}
				k += 2;
			}
			if (q > 1) {
				totient = totient * (q - 1) / q;
			}
			return totient;
		}
		else 
			return 0;
	}
	
	/**
	 * The Möbius function is a number theoretic function defined by:
	 * <p>
	 * <code>mobiusMu(n) = 1</code> if <code>n</code> is a square-free positive
	 * integer with an even number of distinct prime factors.<br>
	 * <code>mobiusMu(n) = -1</code> if <code>n</code> is a square-free positive
	 * integer with an odd number of distinct prime factors.<br>
	 * <code>mobiusMu(n) = 0 </code> if <code>n</code> is not square-free.<br>
	 * 
	 * @param n
	 *            positive integer, <code>(n > 0)</code>
	 * @return <code>{-1, 0, 1}</code> depending on the factorization of n into
	 *         prime factors
	 * 
	 */
	public static int mobiusMu(int n){
		int moebius, q, k;

		if (n > 0) {
			moebius = 1;
			q = n;
			if (q % 2 == 0) {
				moebius = -moebius;
				q /= 2;
				if (q % 2 == 0) {
					return 0;
				}
			}
			if (q % 3 == 0) {
				moebius = -moebius;
				q /= 3;
				if (q % 3 == 0) {
					return 0;
				}
			}
			k = 5;
			while (k * k <= q) {
				if (k % 3 != 0) {
					while (q % k == 0) {
						moebius = -moebius;
						q /= k;
						if (q % k == 0) {
							return 0;
						}
					}
				}
				k += 2;
			}
			if (q > 1) {
				moebius = -moebius;
			}
			return moebius;
		} else {
			return 0;
		}
	}
	

	/**
	 * The binary GCD algorithm is an algorithm which computes the greatest
	 * common divisor of two nonnegative integers. It gains a measure of
	 * efficiency over the ancient Euclidean algorithm by replacing divisions
	 * and multiplications with shifts, which are cheaper when operating on the
	 * binary representation used by modern computers.
	 * <p>
	 * 
	 * <u><b>Algorithm:</b></u> Binary GCD [Stien's Algorithm]<br>
	 * The algorithm reduces the problem of finding the GCD by repeatedly
	 * applying these identities:<br>
	 * <br>
	 * 
	 * 1. <code>gcd(0, v) = v</code>, because everything divides zero, and
	 * <code>v</code> is the largest number that divides <code>v</code>.
	 * Similarly, <code>gcd(u, 0) = u</code>. <code>gcd(0, 0)</code> is not
	 * defined.<p>
	 * 
	 * 2. If <code>u</code> and <code>v</code> are both even, then
	 * <code>gcd(u, v) = 2·gcd(u/2, v/2)</code>, because <code>2</code> is a
	 * common divisor.<p>
	 * 
	 * 3. If <code>u</code> is even and <code>v</code> is odd, then
	 * <code>gcd(u, v) = gcd(u/2, v)</code>, because <code>2</code> is not a
	 * common divisor. Similarly, if <code>u</code> is odd and <code>v</code>
	 * is even, then <code>gcd(u, v) = gcd(u, v/2)</code>.<p>
	 * 
	 * 4. If <code>u</code> and <code>v</code> are both odd, and
	 * <code>u = v</code>, then <code>gcd(u, v) = gcd((u-v)/2, v)</code>. If
	 * both are odd and <code>u < v</code>, then
	 * <code>gcd(u, v) = gcd((v-u)/2, u)</code>. These are combinations of one
	 * step of the simple Euclidean algorithm, which uses subtraction at each
	 * step, and an application of step 3 above. The division by <code>2</code>
	 * results in an integer because the difference of two odd numbers iseven.
	 * <p>
	 * 
	 * 5. Repeat steps 3–4 until <code>u=v</code>, or (one more step) until
	 * <code>u = 0</code>. In either case, the result is <code>(2^k)v</code>,
	 * where <code>k</code> is the number of common factors of <code>2</code>
	 * found in step 2. <br>
	 * 
	 * @param u
	 *            positive integer, <code>(u > 0)</code>
	 * @param v
	 *            positive integer, <code>(v > 0)</code>
	 *            
	 * @return the greatest common divisor of u and v
	 * 
	 * @author Brandon Bernie
	 */
	public static int gcd(int u, int v)
	 {
	     int shift;
	 
	     /* GCD(0,x) := x */
	     if (u == 0 || v == 0)
	       return u | v;
	 
	     /* Let shift := lg K, where K is the greatest power of 2
	        dividing both u and v. */
	     for (shift = 0; ((u | v) & 1) == 0; ++shift) {
	         u >>= 1;
	         v >>= 1;
	     }
	 
	     while ((u & 1) == 0)
	       u >>= 1;
	 
	     /* From here on, u is always odd. */
	     do {
	         while ((v & 1) == 0)  /* Loop X */
	           v >>= 1;
	 
	         /* Now u and v are both odd, so diff(u, v) is even.
	            Let u = min(u, v), v = diff(u, v)/2. */
	         if (u < v) {
	             v -= u;
	         } else {
	             int diff = u - v;
	             u = v;
	             v = diff;
	         }
	         v >>= 1;
	     } while (v != 0);
	 
	     return u << shift;
	 }
}
