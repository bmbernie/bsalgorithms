/*
 * Author: Brandon Bernie
 * 
 * Driver for various NumberTheory functions
 */

import org.bsalgorithms.*;
import org.bsalgorithms.util.Pair;
import org.bsalgorithms.util.Timing;

import java.math.BigInteger;
import java.util.List;

public class Test {
	
	public static void main(String[] args) {
        Timing t = new Timing();

//        t.start();
//        bigFactorial(40000);
//        t.stop();
//        System.out.println(t);
//
//        t.start();
//        bigFactorial2(40000);
//        t.stop();
//        System.out.println(t);
//
//        t.start();
//        bigFactorial3(40000);
//        t.stop();
//        System.out.println(t);
        
        t.start();
        bigFactorial4(40000);
        t.stop();
        System.out.println(t);

       // if(bigFactorial3(40000).toString().equals(bigFactorial4(40000).toString()))
       //     System.out.println("equal");
    }

	public static BigInteger bigFactorial4(final int n){
		BigInteger result = BigInteger.ONE;
		List<Integer> lprimes = NumberTheory.generatePrimes(n);
		int[] primes = new int[lprimes.size()];
		int[] table = new int[n+1];
		
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
	
    public static BigInteger bigFactorial3(final int n){
        BigInteger result = BigInteger.ONE;
        int[] table = new int[n+1];

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

    public static BigInteger bigFactorial2(final int n){
        BigInteger result = BigInteger.ONE;
        int[] table = new int[n+1];

        for(int i = 2; i <= n; i++)
            for(Pair<Integer, Integer> p : NumberTheory.factorInteger(i))
                table[p.getFirst()] += p.getSecond();
        
        for(int i = table.length-1; i > 2; i--)
            result = result.multiply(BigInteger.valueOf(i).pow(table[i]));
		
		result = result.shiftLeft(table[2]);

        return result;
    }

    public static BigInteger bigFactorial(int n) {
        BigInteger result = BigInteger.ONE;

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
