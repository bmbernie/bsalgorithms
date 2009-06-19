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

import org.bsalgorithms.math.util.NumberTheory;

import java.util.LinkedList;

public class PS023 {

	public static void main(String[] args) {
		long start = 0, stop = 0;
		int limit = 20161, result = 0;
		int[] numbers = new int[limit];
		boolean[] abundant = new boolean[limit + 1];
		LinkedList<Integer> abundants = new LinkedList<Integer>();

		start = System.nanoTime();
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = i + 1;
			result += numbers[i];
			if (NumberTheory.isAbundant(numbers[i]))
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
		result = (limit * (limit + 1)) / 2;
		for (int n = 1; n <= limit; n++) 
			if (abundant[n] = NumberTheory.isAbundant(n))
				abundants.add(n);
		
		for (int i = 1; i <= limit; i++) {
			for(Integer temp : abundants)  {
				if (i - temp < 12)
					break;
				if (abundant[i - temp]) {
					result -= i;
					break;
				}
			}
		}

		stop = System.nanoTime();
		System.out.println(result + " " + ((stop - start) / 1000000) + " ms ");
	}
}
