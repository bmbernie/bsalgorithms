package project_euler;
/*
 * Author: Brandon Bernie
 * 
 * Problem 14
 * 
 * The following iterative sequence is defined for the set of positive 
 * integers:  n -> n/2 (n is even) || n -> 3n + 1 (n is odd)
 * 
 * Using the rule above and starting with 13, we generate the following 
 * sequence: 13 -> 40 -> 20 -> 10 -> 5 -> 16 -> 8 -> 4 -> 2 -> 1
 * 
 * It can be seen that this sequence (starting at 13 and finishing at 1) 
 * contains 10 terms. Although it has not been proved yet (Collatz Problem), 
 * it is thought that all starting numbers finish at 1.
 * 
 * Which starting number, under one million, produces the longest chain?
 */

public class PS014 {

	public static void main(String[] args) {
		int chain = 0;
		int chainlength = 0;
		long start = System.currentTimeMillis();
		for (int i = 999999; i > 1; i--) {
			int counter = 0;
			long n = i;
			while (n > 1) {
				if ((n & 1) == 0) {
					n >>= 1;
				} else {
					n += (n << 1) + 1;
				}
				counter++;
			}
			if (chainlength < counter) {
				chainlength = counter;
				chain = i;
			}
		}
		long stop = System.currentTimeMillis();
		System.out.println(chain + " " + (stop - start) + " ms");

		start = System.currentTimeMillis();
		int[] cache = new int[1000000];
		int maxstart = 0, maxcount = 0;
		for (int i = 1; i < 1000000; i++) {
			long n = i;
			int count = 1;
			do {
				if ((n & 1) == 0) {
					n >>= 1;
					if (n < i) {
						count += cache[(int) n];
						break;
					}
				} else {
					n += (n << 1) + 1;
				}
				count++;
			} while (n != 1);

			cache[i] = count;

			if (count > maxcount) {
				maxcount = count;
				maxstart = i;
			}
		}
		stop = System.currentTimeMillis();
		System.out.println(maxstart + " " + (stop - start) + " ms");
	}
}
