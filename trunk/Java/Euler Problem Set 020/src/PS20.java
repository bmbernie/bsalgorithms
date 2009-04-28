/*
 * Author: Brandon Bernie
 * 
 * n! means n * (n - 1) * (n - 2) ... 3 * 2 * 1
 * 
 * Find the sum of the digits in the number 100!
 */

import java.math.BigInteger;
import java.util.StringTokenizer;

public class PS20 {

	public static void main(String[] args) {
		long start, stop;
		BigInteger n = BigInteger.ONE;
		int[] table = new int[100];
		int sum = 0;
		
		start = System.nanoTime();
		for (int i = 2; i < 100; i++) {
			StringTokenizer st = new StringTokenizer(primeFactors(i));
			while (st.hasMoreTokens()) {
				table[Integer.parseInt(st.nextToken())]++;
			}
		}
		
		for(int i = 3; i < table.length; i++){
			BigInteger temp = BigInteger.ONE;
			if(table[i] != 0){
				temp = BigInteger.valueOf(i);
				temp = temp.pow(table[i]);
				n = n.multiply(temp);
			}
		}
		n = n.shiftLeft(table[2]);
		
		char[] b = n.toString().toCharArray();
		for(int i = 0; i < b.length; i++)
			sum += b[i] - 48;
		stop = System.nanoTime();
		
		System.out.println(sum + " " + (stop - start) + " ms");
	}

	public static String primeFactors(int n) {
		StringBuffer factors = new StringBuffer();

		// for each potential factor i
		for (int i = 2; i <= n / i; i++) {
			// if i is a factor of N, repeatedly divide it out
			while (n % i == 0) {
				factors.append(Integer.toString(i) + " ");
				n = n / i;
			}
		}
		// if biggest factor occurs only once, n > 1
		if (n > 1)
			factors.append(Integer.toString(n));

		return factors.toString();
	}
}
