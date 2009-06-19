package project_euler;
/*
 * Author: Brandon Bernie
 * 
 * Problem 34
 * 
 * 145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.
 * 
 * Find the sum of all numbers which are equal to the sum of the factorial of
 * their digits.
 * 
 * Note: as 1! = 1 and 2! = 2 are not sums they are not included.
 */
public class PS034 {

	public static void main(String[] args) {
		int limit = 2309171;
		int sum = 0;
		
		long start = System.nanoTime();
		for(int n = 10; n < limit; n++){
			if(sumFactorialDigits(n) == n)
				sum += n;
		}
		long stop = System.nanoTime();
		System.out.println(sum + " " + (stop - start)/1000000 + " ms");
		
	}
	
	public static int sumFactorialDigits(int n){
		int[] factorial = {1,1,2,6,24,120,720,5040,40320,362880};
		int sumOfDigits = 0;
		
		while(n > 0){
			sumOfDigits += factorial[n % 10];
			n /= 10;
		}
		
		return sumOfDigits;
	}

}
