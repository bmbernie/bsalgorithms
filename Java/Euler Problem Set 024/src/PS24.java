/*
 * Author: Brandon Bernie
 * 
 * Problem 024
 * 
 * A permutation is an ordered arrangement of objects. For example, 3124 is 
 * one possible permutation of the digits 1, 2, 3 and 4. If all of the 
 * permutations are listed numerically or alphabetically, we call it 
 * lexicographic order. The lexicographic permutations of 0, 1 and 2 are:
 * 
 * 012   021   102   120   201   210
 * 
 * What is the millionth lexicographic permutation of the digits 
 * 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
 */

import java.util.ArrayList;
import java.util.List;

public class PS24 {

	public static void main(String[] args) {
		List<Integer> digits = new ArrayList<Integer>();
		long start, stop;
		
		start = System.nanoTime();
		for(int i = 0; i <= 9; i++)
			digits.add(i);
		
		for(int p = 1; p < 1000000; p++){
			int n = digits.size();
			int i = n - 1;
			int j;
			
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
		}
		stop = System.nanoTime();
		System.out.println(digits + " " + (stop - start)/1000000 + "ms");
	}

}
