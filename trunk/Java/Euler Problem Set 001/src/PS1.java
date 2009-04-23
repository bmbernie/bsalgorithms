/*
 * Problem 1
 * 
 * If we list all the natural numbers below 10 that are multiples of 3
 * or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
 *  
 * Find the sum of all the multiples of 3 or 5 below 1000.
*/

public class PS1 {

	public static void main(String[] args) {
		int sum = 0;
		
		long start = System.nanoTime();
		//brute force method for calculating the summation
		for(int i=1; i < 1000; i++)
			if(i % 3 == 0 || i % 5 == 0)
				sum += i;
		
		long stop = System.nanoTime();
		System.out.println(sum + " " + (stop-start) + "ns");
		
		start = System.nanoTime();
		sum = 0;
		for(int i = 3; i < 1000; i+=3)
			sum+=i;
		for(int i = 5; i < 1000; i+=5)
			if(i % 3 != 0)
				sum+=i;
		stop = System.nanoTime();
		System.out.println(sum + " " + (stop - start) + "ns");
		
		//a more elegant solution to avoid overflow in larger sets
		int itemsInA = 999/3;
		int itemsInB = 999/5;
		int overlap = 999/15;
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
	}

}
