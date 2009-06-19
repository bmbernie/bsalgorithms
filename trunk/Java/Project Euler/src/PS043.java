/*
 * Author: Brandon Bernie
 * 
 * The number, 1406357289, is a 0 to 9 pandigital number because it is made up
 * of each of the digits 0 to 9 in some order, but it also has a rather 
 * interesting sub-string divisibility property.
 * 
 * 
 * Let d(1) be the 1st digit, d(2) be the 2nd digit, and so on. In this
 * way, we note the following:
 * 
 * d(2)d(3)d(4) = 406 is divisible by 2
 * d(3)d(4)d(5) = 063 is divisible by 3
 * d(4)d(5)d(6) = 635 is divisible by 5
 * d(5)d(6)d(7) = 357 is divisible by 7
 * d(6)d(7)d(8) = 572 is divisible by 11
 * d(7)d(8)d(9) = 728 is divisible by 13
 * d(8)d(9)d(10)= 289 is divisible by 17
 * 
 * Find the sum of all 0 to 9 pandigital numbers with this property.
 */

import java.util.ArrayList;
import java.util.List;

import org.bsalgorithms.util.Timing;

public class PS043 {

	public static void main(String[] args) {
		List<Integer> digits = new ArrayList<Integer>();
		long sum = 0;
		int[] primes = {2,3,5,7,11,13,17};
		Timing x = new Timing();
		
		x.start();
		for(int i = 0; i <= 9; i++)
			digits.add(i);
		
		for(int p = 1; p < 3628800; p++){
			int n = digits.size();
			int i = n - 1;
			int j;
			int number = 0;
			
			while(digits.get(i - 1).compareTo(digits.get(i)) > 0)
				i--;
			
			j = n;
			
			while(digits.get(j - 1).compareTo(digits.get(i - 1)) < 0)
				j--;
			
			int temp = digits.get(i - 1);
			digits.set(i - 1, digits.get(j - 1));
			digits.set(j - 1, temp);
			
			i++;
			j = n;

			while (i < j) {
				temp = digits.get(i - 1);
				digits.set(i - 1, digits.get(j - 1));
				digits.set(j - 1, temp);
				i++;
				j--;
			}
			
			
			boolean interesting = false;
			for(int t = 1; t < 8; t++){
				number = 0;
				number += digits.get(t) * 100;
				number += digits.get(t+1) * 10;
				number += digits.get(t+2);
				
				if(number % (primes[t - 1]) == 0)
					interesting = true;
				else {
					interesting = false;
					break;
				}
			}
			if(interesting)
				sum += arrayToLong(digits);
			
		}
		x.stop();
		System.out.println(sum + " " + x);
	}
	
	public static long arrayToLong(List<Integer> d){
		long number = 0;
		
		for(int i = 0; i < d.size(); i++)
			number += d.get(i) * Math.pow(10, d.size()-i-1);
		
		return number;
	}
}
