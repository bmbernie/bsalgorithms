package project_euler;
/*
 * Author: Brandon Bernie
 * 
 * Driver for various NumberTheory functions
 * Mostly for testing out ideas before I put them in my util class
 */

import org.bsalgorithms.math.util.NumberTheory;
import org.bsalgorithms.util.HiResStopWatch;
import org.bsalgorithms.util.Pair;
import org.bsalgorithms.util.Timing;


import java.math.BigInteger;
import java.util.List;

public class Test {
	
	public static void main(String[] args) {
        HiResStopWatch t = new HiResStopWatch();

        t.start();
        bigFactorial(40000);
        t.stop();
        System.out.println(t + "1");
        t.reset();

        t.start();
        bigFactorial2(40000);
        t.stop();
        System.out.println(t + "2");
        t.reset();

        t.start();
        bigFactorial3(40000);
        t.stop();
        System.out.println(t + "3");
        t.reset();
        
       
        t.start();
        bigFactorial4(40000);
        t.stop();
        
//        long l = 237222333333L;
//        long ns,ms,s,m;
//        
//        ns = l%1000000;
//        ms = l / 1000000 % 1000;
//        s = l / 1000000000L % 60;
//        m = l / 1000000000L / 60;
//        
     
        System.out.println(t + "4");

       // if(bigFactorial3(40000).toString().equals(bigFactorial4(40000).toString()))
       //     System.out.println("equal");
    }
	
	/**
     * Returns n!. Shorthand for <code>n</code> <a
     * href="http://mathworld.wolfram.com/Factorial.html"> Factorial</a>, the
     * product of the numbers <code>1,...,n</code>.
     * <p>
     * <Strong>Preconditions</strong>:
     * <ul>
     * <li> <code>n >= 0</code> (otherwise
     * <code>IllegalArgumentException</code> is thrown)</li>
     * <li> The result is small enough to fit into a <code>long</code>. The
     * largest value of <code>n</code> for which <code>n!</code> <
     * Long.MAX_VALUE</code> is 20. If the computed value exceeds <code>Long.MAX_VALUE</code>
     * an <code>ArithMeticException </code> is thrown.</li>
     * </ul>
     * </p>
     * 
     * @param n argument
     * @return <code>n!</code>
     * @throws ArithmeticException if the result is too large to be represented
     *         by a long integer.
     */
	public static BigInteger bigFactorial4(final int n){
		BigInteger result = BigInteger.ONE;
		List<Integer> lprimes = NumberTheory.generatePrimes(n);
		int[] primes = new int[lprimes.size()];
		int[] table = new int[n+1];
		final long[] factorials = new long[] { 1, 1, 2, 6, 24, 120, 720, 5040,
				40320, 362880, 3628800, 39916800, 479001600, 6227020800l,
				87178291200l, 1307674368000l, 20922789888000l,
				355687428096000l, 6402373705728000l, 121645100408832000l,
				2432902008176640000l };
		
		if(n < 0)
			return BigInteger.ZERO;
		
		if(n < 20)
			return BigInteger.valueOf(factorials[n]);
		
		
		for(int i = 0; i < primes.length; i++)
			primes[i] = lprimes.get(i);
			
		for (int i = 2; i <= n; i++) {
			int k = i;

			while ((k & 1) == 0) {
				k >>= 1;
				table[2]++;
			}

			for (int j = 1; primes[j] <= k / primes[j]; j++) {
				int p = primes[j];
				while (k % p == 0) {
					k /= p;
					table[p]++;
				}
			}

			if (k > 1)
				table[k]++;
		}
		
		for(int i = table.length-1; i > 2; i--)
            result = result.multiply(BigInteger.valueOf(i).pow(table[i]));

		result = result.shiftLeft(table[2]);
		
		return result;
	}
	
	/**
     * Returns n!. Shorthand for <code>n</code> <a
     * href="http://mathworld.wolfram.com/Factorial.html"> Factorial</a>, the
     * product of the numbers <code>1,...,n</code>.
     * <p>
     * <Strong>Preconditions</strong>:
     * <ul>
     * <li> <code>n >= 0</code> (otherwise
     * <code>IllegalArgumentException</code> is thrown)</li>
     * <li> The result is small enough to fit into a <code>long</code>. The
     * largest value of <code>n</code> for which <code>n!</code> <
     * Long.MAX_VALUE</code> is 20. If the computed value exceeds <code>Long.MAX_VALUE</code>
     * an <code>ArithMeticException </code> is thrown.</li>
     * </ul>
     * </p>
     * 
     * @param n argument
     * @return <code>n!</code>
     * @throws ArithmeticException if the result is too large to be represented
     *         by a long integer.
     */
    public static BigInteger bigFactorial3(final int n){
        BigInteger result = BigInteger.ONE;
        int[] table = new int[n+1];
        final long[] factorials = new long[] { 1, 1, 2, 6, 24, 120, 720, 5040,
				40320, 362880, 3628800, 39916800, 479001600, 6227020800l,
				87178291200l, 1307674368000l, 20922789888000l,
				355687428096000l, 6402373705728000l, 121645100408832000l,
				2432902008176640000l };
		
		if(n < 0)
			return BigInteger.ZERO;
		
		if(n < 20)
			return BigInteger.valueOf(factorials[n]);

        for (int i = 2; i <= n; i++) {
            int k = i;

            while ((k & 1) == 0) {
				k >>= 1;
				table[2]++;
			}

            for (int j = 3; j <= k/j; j+=2) {
                while (k % j == 0) {
                    k = k / j;
                    table[j]++;
                }
            }
            
            if(k > 1)
                table[k]++; 
        }

        for(int i = table.length-1; i > 2; i--)
            result = result.multiply(BigInteger.valueOf(i).pow(table[i]));

		result = result.shiftLeft(table[2]);

        return result;
    }
    
    /**
     * Returns n!. Shorthand for <code>n</code> <a
     * href="http://mathworld.wolfram.com/Factorial.html"> Factorial</a>, the
     * product of the numbers <code>1,...,n</code>.
     * <p>
     * <Strong>Preconditions</strong>:
     * <ul>
     * <li> <code>n >= 0</code> (otherwise
     * <code>IllegalArgumentException</code> is thrown)</li>
     * <li> The result is small enough to fit into a <code>long</code>. The
     * largest value of <code>n</code> for which <code>n!</code> <
     * Long.MAX_VALUE</code> is 20. If the computed value exceeds <code>Long.MAX_VALUE</code>
     * an <code>ArithMeticException </code> is thrown.</li>
     * </ul>
     * </p>
     * 
     * @param n argument
     * @return <code>n!</code>
     * @throws ArithmeticException if the result is too large to be represented
     *         by a long integer.
     */
    public static BigInteger bigFactorial2(final int n){
        BigInteger result = BigInteger.ONE;
        int[] table = new int[n+1];
        final long[] factorials = new long[] { 1, 1, 2, 6, 24, 120, 720, 5040,
				40320, 362880, 3628800, 39916800, 479001600, 6227020800l,
				87178291200l, 1307674368000l, 20922789888000l,
				355687428096000l, 6402373705728000l, 121645100408832000l,
				2432902008176640000l };
		
		if(n < 0)
			return BigInteger.ZERO;
		
		if(n < 20)
			return BigInteger.valueOf(factorials[n]);

        for(int i = 2; i <= n; i++)
            for(Pair<Integer, Integer> p : NumberTheory.factorInteger(i))
                table[p.getFirst()] += p.getSecond();
        
        for(int i = table.length-1; i > 2; i--)
            result = result.multiply(BigInteger.valueOf(i).pow(table[i]));
		
		result = result.shiftLeft(table[2]);

        return result;
    }
    
    /**
     * Returns n!. Shorthand for <code>n</code> <a
     * href="http://mathworld.wolfram.com/Factorial.html"> Factorial</a>, the
     * product of the numbers <code>1,...,n</code>.
     * <p>
     * <Strong>Preconditions</strong>:
     * <ul>
     * <li> <code>n >= 0</code> (otherwise
     * <code>IllegalArgumentException</code> is thrown)</li>
     * <li> The result is small enough to fit into a <code>long</code>. The
     * largest value of <code>n</code> for which <code>n!</code> <
     * Long.MAX_VALUE</code> is 20. If the computed value exceeds <code>Long.MAX_VALUE</code>
     * an <code>ArithMeticException </code> is thrown.</li>
     * </ul>
     * </p>
     * 
     * @param n argument
     * @return <code>n!</code>
     * @throws ArithmeticException if the result is too large to be represented
     *         by a long integer.
     */
    public static BigInteger bigFactorial(int n) {
        BigInteger result = BigInteger.ONE;
        
        final long[] factorials = new long[] { 1, 1, 2, 6, 24, 120, 720, 5040,
				40320, 362880, 3628800, 39916800, 479001600, 6227020800l,
				87178291200l, 1307674368000l, 20922789888000l,
				355687428096000l, 6402373705728000l, 121645100408832000l,
				2432902008176640000l };
		
		if(n < 0)
			return BigInteger.ZERO;
		
		if(n < 20)
			return BigInteger.valueOf(factorials[n]);

        for (int i = 2; i <= n; i++)
            result = result.multiply(new BigInteger(Integer.toString(i)));

        return result;
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
	
}
