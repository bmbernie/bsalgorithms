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
		
		//brute force method for calculating the summation
		for(int i=1; i < 1000; i++){
			if(i % 3 == 0 || i % 5 == 0)
				sum += i;
		}
		
		//a more elegant solution to avoid overflow in larger sets
		int itemsInA = 999/3;
		int itemsInB = 999/5;
		int overlap = 999/15;
		int newsum = 0;
		
		for(int i = 1; i<= itemsInA; i++)
			newsum += i*3;
		for(int i = 1; i<= itemsInB; i++)
			newsum += i*5;
		for(int i = 1; i<= overlap; i++)
			newsum -= i*15;
		
		
		System.out.println(sum);
		System.out.println(newsum);
	}

}
