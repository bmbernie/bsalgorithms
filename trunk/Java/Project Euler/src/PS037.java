/*
 * Author: Brandon Bernie
 * 
 * Problem 37
 * 
 * The number 3797 has an interesting property. Being prime itself, it is
 * possible to continuously remove digits from left to right, and remain prime 
 * t each stage: 
 * 3797, 797, 97, and 7. 
 * 
 * Similarly we can work from right to left: 
 * 3797, 379, 37, and 3.
 * 
 * Find the sum of the only eleven primes that are both truncatable from left
 * to right and right to left.
 */

import org.bsalgorithms.NumberTheory;
import java.util.List;

public class PS037 {

	public static void main(String[] args) {
		List<Integer> primes = NumberTheory.generatePrimes(1000000);	
		int counter = 0, sum = 0;
		
		long start = System.nanoTime();
		for(Integer i : primes){
			if(truncateLeft(i) && truncateRight(i)){
				counter++;
				sum += i;
			}
			if(counter == 11)
				break;
		}
		long stop = System.nanoTime();
		System.out.println(sum + " " + (stop - start)/1000000 + "ms");
	} 
	
	public static boolean truncateLeft(int n){
		int divisor = 10;
		
		do{
			if(!NumberTheory.isPrime(n % divisor))
				return false;
			
			divisor *= 10;
		}while(divisor <= n);
		
		return true;
	}
	
	public static boolean truncateRight(int n){
		int divisor = 10;
		
		do{
			if(!NumberTheory.isPrime(n /= divisor))
				return false;
			
		}while(divisor <= n);
		
		return true;
	}

}
