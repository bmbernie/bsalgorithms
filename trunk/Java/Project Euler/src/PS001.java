/*
 * Author: Brandon Bernie
 * 
 * Problem 1
 * 
 * If we list all the natural numbers below 10 that are multiples of 3
 * or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
 *  
 * Find the sum of all the multiples of 3 or 5 below 1000.
*/

public class PS001 {

	public static void main(String[] args) {
		int target = 9999;
		int sum = 0;
		
		long start = System.nanoTime();
		//brute force method for calculating the summation
		for(int i=1; i <= target; i++)
			if(i % 3 == 0 || i % 5 == 0)
				sum += i;
		
		long stop = System.nanoTime();
		System.out.println(sum + " " + (stop-start) + "ns");
		
		start = System.nanoTime();
		sum = 0;
		for(int i = 3; i <= target; i+=3)
			sum+=i;
		for(int i = 5; i <= target; i+=5)
			if(i % 3 != 0)
				sum+=i;
		stop = System.nanoTime();
		System.out.println(sum + " " + (stop - start) + "ns");
		
		//a more elegant solution to avoid overflow in larger sets
		int itemsInA = target/3;
		int itemsInB = target/5;
		int overlap = target/15;
		sum = 0;
		
		start = System.nanoTime();
		for(int i = 1; i<= itemsInA; i++)
			sum += i*3;
		for(int i = 1; i<= itemsInB; i++)
			sum += i*5;
		for(int i = 1; i<= overlap; i++)
			sum -= i*15;
		stop = System.nanoTime();
		System.out.println(sum + " " + (stop-start) + "ns");
		
		//fastest and best approach
		sum = 0;
		start = System.nanoTime();
		int totalA = 3*(itemsInA * (itemsInA + 1))/2; 
		int totalB = 5*(itemsInB*(itemsInB+1))/2;
		int totalC = 15*(overlap*(overlap+1))/2;
		sum = totalA + totalB - totalC;
		
		System.out.println(sum + " " + (System.nanoTime() - start) + "ns");
	}

}
