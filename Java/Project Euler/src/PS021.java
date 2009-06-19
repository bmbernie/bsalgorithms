/*
 * Author: Brandon Bernie
 * 
 * Problem 21
 * 
 * Let d(n) be defined as the sum of proper divisors of n 
 * (numbers less than n which divide evenly into n).
 * 
 * If d(a) = b and d(b) = a, where a ? b, then a and b are an amicable pair and 
 * each of a and b are called amicable numbers.
 * 
 * For example, the proper divisors of 220 are:
 * 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284. 
 * The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.
 * 
 * Evaluate the sum of all the amicable numbers under 10000.
 */

import org.bsalgorithms.math.util.NumberTheory;

import java.util.ArrayList;
import java.util.List;
import java.lang.Integer;

public class PS021 {
	public static void main(String[] args) {
		final int MAX = 10000;
		int total = 0; 
		boolean flags[] = new boolean[MAX];
		
		long begin = System.nanoTime();
		for (int i = 1; i <= MAX; i++) {
			if(flags[i - 1])
				continue;
			
			int a = sigmaBrute(i);
			if (a == i || a == 1)
				continue;

			int b = sigmaBrute(a);
			if (b == i) 
				total += a + b;
			
			if (a < flags.length && a > 0)
				flags[a - 1] = true;
			if (b < flags.length && b > 0)
				flags[b - 1] = true;
		}
		long end = System.nanoTime();
		System.out.println(total + " " + (end - begin)/1000000 + " ms");
		
		total = 0;
		flags = new boolean[MAX];
		begin = System.nanoTime();
		for (int i = 2; i <= flags.length; i++) {
			if (flags[i - 1])
				continue;

			int a = NumberTheory.sigmaProperDivisors(i);
			if (a == i || a == 1)
				continue;
			
			int b = NumberTheory.sigmaProperDivisors(a);
			if (b == i)
				total += a + b;

			if (a < flags.length && a > 0)
				flags[a - 1] = true;
			if (b < flags.length && b > 0)
				flags[b - 1] = true;
		}
		end = System.nanoTime();
		System.out.println(total + " " + (end - begin)/1000000 + " ms");
		
		total = 0;
		flags = new boolean[MAX];
		begin = System.nanoTime();
		for (int i = 2; i <= flags.length; i++) {
			if (flags[i - 1])
				continue;

			int a = sigmaTheorem(i)-i;
			if (a == i || a == 1)
				continue;
			
			int b = sigmaTheorem(a)-a;
			if (b == i)
				total += a + b;

			if (a < flags.length && a > 0)
				flags[a - 1] = true;
			if (b < flags.length && b > 0)
				flags[b - 1] = true;
		}
		end = System.nanoTime();
		System.out.println(total + " " + (end - begin)/1000000 + " ms");
	}

	public static int sigmaTheorem(int n) {
		int sum = 1;
		int[] table = new int[n + 1];
		List<Integer> factors = primeFactors(n);
		
		for (int i : factors)
			table[i]++;

		if (table.length > 2) {
			sum <<= table[2] + 1;
			sum--;
		}
		
		for (int i = 3; i < table.length; i++) {
			if (table[i] > 0)
				sum *= (Math.pow(i, table[i] + 1) - 1) / (i - 1);
		}
		
		return sum;
	}

	public static List<Integer> primeFactors(int n) {
		List<Integer> factors = new ArrayList<Integer>();
		
		// for each potential factor i
		for (int i = 2; i <= n / i; i++) {
			// if i is a factor of N, repeatedly divide it out
			while (n % i == 0) {
				factors.add(i);
				n /= i;
			}
		}

		// if biggest factor occurs only once, n > 1
		if (n > 1)
			factors.add(n);
		
		return factors;
	}
	
	public static int sigmaBrute(int n) {
		int sum = 1;

		for (int i = 2; i <= (int)Math.sqrt(n); i++)
			if (n % i == 0)
				sum += i + (n / i);

		return sum;
	}
}
