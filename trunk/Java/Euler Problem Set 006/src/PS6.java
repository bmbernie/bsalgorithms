/*
 * Problem 6
 * 
 * The sum of the squares of the first ten natural numbers is,
 * 1^(2) + 2^(2) + ... + 10^(2) = 385
 * 
 * The square of the sum of the first ten natural numbers is,
 * (1 + 2 + ... + 10)^(2) = 55^(2) = 3025
 *
 * Find the difference between the sum of the squares of the first one
 * hundred natural numbers and the square of the sum.
 */

public class PS6 {

	public static void main(String[] args) {
		long sumOfSquares=0;
		long squareOfSums=0;
		long start = System.nanoTime();
		//sum of squares
		for(int i = 1; i <= 100; i++)
			sumOfSquares += i*i;
		
		//square of sums
		for(int i = 1; i <= 100; i++)
			squareOfSums += i;
		squareOfSums *= squareOfSums;
		long stop = System.nanoTime();
		System.out.println(squareOfSums - sumOfSquares + " " + (stop - start) + " ns");
		
		start = System.nanoTime();
		long n = 100;
		squareOfSums = ((n*n)*(n+1)*(n+1))/4;
		sumOfSquares = (n*(n+1)*((2*n)+1))/6;
		stop = System.nanoTime();
		System.out.println(squareOfSums - sumOfSquares + " " + (stop - start) + " ns");
	}

}
