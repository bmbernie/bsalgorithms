/*
 * Author: Brandon Bernie
 * 
 * A perfect number is a number for which the sum of its proper divisors is
 * exactly equal to the number. For example, the sum of the proper divisors
 * of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect 
 * number.
 * 
 * A number whose proper divisors are less than the number is called deficient
 * and a number whose proper divisors exceed the number is called abundant.
 * 
 * As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest
 * number that can be written as the sum of two abundant numbers is 24. By 
 * mathematical analysis, it can be shown that all integers greater than 28123
 * can be written as the sum of two abundant numbers. However, this upper 
 * limit cannot be reduced any further by analysis even though it is known
 * that the greatest number that cannot be expressed as the sum of two 
 * abundant numbers is less than this limit.
 * 
 * Find the sum of all the positive integers which cannot be written as the sum
 * of two abundant numbers.
 */

import java.util.Iterator;
import java.util.LinkedList;

public class PS23 {

	public static void main(String[] args) {
		long start = 0, stop = 0;
		int limit = 20161, result = 0;
		int[] numbers = new int[limit];
		int[] nums = new int[limit + 1];
		boolean[] abundant = new boolean[limit + 1];
		LinkedList<Integer> abundants = new LinkedList<Integer>();

		start = System.nanoTime();
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = i + 1;
			result += numbers[i];
			if (isAbundant(numbers[i]))
				abundants.add(numbers[i]);
		}

		for (int i = 0; i < abundants.size(); i++) {
			for (int j = i; j < abundants.size(); j++) {
				int index = abundants.get(i) + abundants.get(j) - 1;
				if (index < numbers.length) {
					result -= numbers[index];
					numbers[index] = 0;
				}
				else
					break;
			}
		}
		stop = System.nanoTime();
		System.out.println(result + " " + ((stop - start) / 1000000) + " ms ");

		//faster method
		start = System.nanoTime();
		for (int n = 1; n <= limit; n++) {
			nums[n] = n;
			if (abundant[n] = isAbundant(n))
				abundants.add(n);
		}
		
		for (int i = 1; i <= limit; i++) {
			Iterator<Integer> itr = abundants.iterator(); 
			while(itr.hasNext())  {
				Integer temp = itr.next();
				if (i - temp < 12)
					break;
				if (abundant[i - temp]) {
					nums[i] = 0;
					break;
				}
			}
		}
		
		result = 0;
		for (int i = 1; i <= limit; i++)
			result += nums[i];

		stop = System.nanoTime();
		System.out.println(result + " " + ((stop - start) / 1000000) + " ms ");
	}

	public static boolean isAbundant(int n) {
		return (sigma(n) > (n + n));
	}

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

	public static int sigmaProperDivisors(int n) {
		return sigma(n) - n;
	}

}
