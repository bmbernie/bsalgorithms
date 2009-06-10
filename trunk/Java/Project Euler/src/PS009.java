/* 
 * Author: Brandon Bernie
 *  
 * Problem 9
 * 
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 * a^(2) + b^(2) = c^(2)
 * For example, 3^(2) + 4^(2) = 9 + 16 = 25 = 5^(2).
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * 
 * Find the product abc.
 */

/* ALGORITHM:
 * 
 * To make a Pythagorean Triangle, take any 2 numbers such as 1 and 3. 
 * In a Fibonacci-like way, add them to produce the next: 1,3,4 and 
 * extend your series once more by the same rule: 1,3,4,7. Now you can 
 * make a Pythagorean Triple as follows:
 * Multiply the middle two numbers and double the result, here 3 and 4 
 * multiply to 2 and double to 24 - this is one side of our Pythagorean 
 * Triangle.
 * Multiply the two outer numbers, here 1 and 7 giving 7 - the second side of
 * the Pythagorean triangle
 * Add the squares of the inner two numbers to get the third side: 
 * here 32 + 42 gives 25, the hypotenuse 
 * So we have found the 24, 7, 25 triangle. 
 */

public class PS009 {

	public static void main(String[] args) {
		int a = 0;
		int b = 0;
		int c = 0;

		// brute force algorithm
		long start = System.nanoTime();
		for (int i = 1; i <= 20; i++)
			for (int j = 1; j <= 20; j++) {
				int x = i + j;
				int y = j + x;

				a = j * x * 2;
				b = i * y;
				c = (j * j) + (x * x);

				if ((a + b + c) == 1000) {
					System.out.println("a:" + a + " b:" + b + " c:" + c);
					System.out.println((a * b * c));
					break;
				}
			}
		long stop = System.nanoTime();
		System.out.println((stop - start) + " ns");
	}
}
