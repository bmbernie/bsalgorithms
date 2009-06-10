/*
 * Author: Brandon Bernie
 * 
 * Problem 16
 * 
 * 2^(15) = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 * 
 * What is the sum of the digits of the number 2^(1000)?
 */

import java.math.BigInteger;

public class PS016 {

	public static void main(String[] args) {
		long start, stop;
		BigInteger a = new BigInteger("2");
		start = System.currentTimeMillis();
		a = a.pow(1000);
		int sum = 0;
		for (int j = 0; j < a.toString().length(); j++)
			sum += Integer.parseInt(a.toString().substring(j, j + 1));
		stop = System.currentTimeMillis();
		System.out.println(sum + " " + (stop - start) + " ms");
		
		a = BigInteger.ONE;
		sum = 0;
		start = System.nanoTime();
		a = a.shiftLeft(1000);
		char [] b = a.toString().toCharArray();
		for(int i = 0; i < b.length; i++)
			sum += b[i] - 48;
		stop = System.nanoTime();
		System.out.println(sum + " " + (stop - start) + " ns");
	}

}
