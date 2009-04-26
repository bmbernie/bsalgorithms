/*
 * Author: Brandon Bernie
 * 
 * Starting in the top left corner of a 2×2 grid, there are 6 routes 
 * (without backtracking) to the bottom right corner.
 * 
 * How many routes are there through a 20×20 grid?
 */

import java.math.BigInteger;
import java.util.StringTokenizer;

public class PS15 {

	public static void main(String[] args) {
		BigInteger numerator = BigInteger.ONE;
		BigInteger denominator = BigInteger.ONE;
		long start, stop;
		
		//Full formula
		start = System.nanoTime();
		numerator = bigFactorial(40);
		denominator = bigFactorial(20);
		denominator = denominator.multiply(denominator);
		numerator = numerator.divide(denominator);
		stop = System.nanoTime();
		System.out.println(numerator.toString() + " " + (stop - start) + " ns");
		
		//pre calculated algebra
		numerator = BigInteger.ONE;
		start = System.nanoTime();
		for(int i = 21; i <= 40; i++)
			numerator = numerator.multiply(new BigInteger(Integer.toString(i)));
		denominator = bigFactorial (20);
		numerator = numerator.divide(denominator);
		stop = System.nanoTime();
		System.out.println(numerator.toString() + " " + (stop - start) + " ns");
		
		//3rd attempt
		start = System.nanoTime();
		int[] table = new int[40];
		long result = 1;
		for(int i = 2; i <= 40; i++){
			StringTokenizer st = new StringTokenizer(primeFactors(i));
			while(st.hasMoreTokens()){
				table[Integer.parseInt(st.nextToken())]++;
			}
		}
		for(int i = 2; i <= 20; i++){
			StringTokenizer st = new StringTokenizer(primeFactors(i));
			while(st.hasMoreTokens()){
				table[Integer.parseInt(st.nextToken())] -= 2;
			}
		}
		for(int i = 39; i > 2; i--){
			result *= Math.pow(i, table[i]);
		}
		result = result << table[2];
		stop = System.nanoTime();
		System.out.println(result + " " + (stop - start) + " ns");
		
	}
	
	public static String primeFactors(int n){
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
	
	public static BigInteger bigFactorial(int n){
		BigInteger result = BigInteger.ONE;
		for(int i = 2; i <=n; i++)
			result = result.multiply(new BigInteger(Integer.toString(i)));
		return result;
	}
}
