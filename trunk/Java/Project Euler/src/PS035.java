/*
 * Author: Brandon Bernie
 * 
 * Problem: 35
 * 
 * The number, 197, is called a circular prime because all rotations of the
 * digits: 197, 971, and 719, are themselves prime.
 * 
 * There are thirteen such primes below 100: 
 * 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97.
 * 
 * How many circular primes are there below one million?
 */

import org.bsalgorithms.NumberTheory;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

public class PS035 {

	public static void main(String[] args) {
		int numCircular = 0;
		BufferedReader br = null;
		String[] primes = null;
		
		long start = System.currentTimeMillis();
		try {
			br = new BufferedReader(new FileReader("primes.txt"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			primes = br.readLine().split(",");
		} catch (Exception e) {
			System.out.println("IOException");
			e.printStackTrace();
		}
		
		for(int i = 0; i < primes.length; i++)
			if(NumberTheory.isCircularPrime(Integer.parseInt(primes[i])))
				numCircular++;
				
		
		long stop = System.currentTimeMillis();
		System.out.println(numCircular + " " + (stop - start)+ "ms");
		
		numCircular = 0;
		start = System.currentTimeMillis();
		List<Integer> p = NumberTheory.generatePrimes(1000000);
		for(Integer i : p)
			if(NumberTheory.isCircularPrime(i))
				numCircular++;
		stop = System.currentTimeMillis();
		System.out.println(numCircular + " " + (stop - start)+ "ms");
		
	}
}

