/*
 * Author: Brandon Bernie
 * 
 * Problem 041
 * 
 * We shall say that an n-digit number is pandigital if it makes use of all the
 * digits 1 to n exactly once. For example, 2143 is a 4-digit pandigital and is
 * also prime.
 * 
 * What is the largest n-digit pandigital prime that exists?
 */

import org.bsalgorithms.NumberTheory;
import org.bsalgorithms.Timing;
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;

public class PS041 {

	public static void main(String[] args) {
		List<Integer> digits = new ArrayList<Integer>();
		List<Integer> primeList = NumberTheory.generatePrimes(7654321);
		HashSet<Integer> primeHT = new HashSet<Integer>(primeList.size());
		primeHT.addAll(primeList);
		
		Timing t = new Timing();
		int max = 0;
		
		t.start();
		for(int f = 7; f > 0; f--){
			digits.clear();
			
			if(max > 0)
				break;
			
			for(int i = 1; i <= f; i++)
				digits.add(i);
			
			for(int p = 1; p < qfactorial(f); p++){
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
				
				number = arrayToInteger(digits);
				
				if(primeHT.contains(number)){
					if(max < number)
						max = number;
				}
			}
		}
		t.stop();
		System.out.println(max + " " + t);
	}
	
	public static int arrayToInteger(List<Integer> d){
		int number = 0;
		
		for(int i = 0; i < d.size(); i++)
			number += d.get(i) * Math.pow(10, d.size()-i-1);
		
		return number;
	}
	
	public static int qfactorial(int n){
		int factorial = 1;
		
		for(int i = 2; i <= n; i++)
			factorial *= i;
		
		return factorial;
	}
}
