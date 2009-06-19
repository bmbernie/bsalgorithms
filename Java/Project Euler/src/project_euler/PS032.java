package project_euler;
/*
 * Author: Brandon Bernie
 * 
 * Problem 32
 * 
 * We shall say that an n-digit number is pandigital if it makes use of all
 * the digits 1 to n exactly once; for example, the 5-digit number, 15234,
 * is 1 through 5 pandigital.
 * 
 * The product 7254 is unusual, as the identity, 39 × 186 = 7254, containing 
 * multiplicand, multiplier, and product is 1 through 9 pandigital. Find the
 * sum of all products whose multiplicand/multiplier/product identity can be
 * written as a 1 through 9 pandigital.
 * 
 * HINT: Some products can be obtained in more than one way so be sure to only
 * include it once in your sum.
 */

import java.util.Set;
import java.util.TreeSet;

public class PS032 {

	public static void main(String[] args) {
		long start, stop;
		Set<Integer> products = new TreeSet<Integer>();
		int sum = 0;
		
		start = System.nanoTime();
		for(int a = 1; a <= 99; a++)
			for(int b = 1; b <= 9999; b++){
				int product = a * b;
				
				if(b < a)
					continue;
				if(products.contains(product))
					continue;	
				if(isPandigital(product,a,b))
					products.add(product);
			}
		
		for(Integer i : products){
			sum += i;
		}
		stop = System.nanoTime();
		System.out.println(sum);
		System.out.println((stop - start)/1000000 + " ms");
	}
	
	public static boolean isPandigital(int... terms ){
		Set<Integer> digits = new TreeSet<Integer>();
		
		for(int i : terms){
			while(i > 0){
				int temp = i % 10;
				
				if(temp == 0)
					return false;
				
				if(digits.add(temp) == false)
					return false;
				
				i /= 10;
			}
		}
		
		if(digits.size() != 9)
			return false;
		
		return true;
	}
}
