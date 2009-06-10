/*
 * Author: Brandon Bernie
 * 
 * Problem 30
 * 
 * Surprisingly there are only three numbers that can be written as the sum of
 * fourth powers of their digits:
 *   
 * 1634 = 1^(4) + 6^(4) + 3^(4) + 4^(4)
 * 8208 = 8^(4) + 2^(4) + 0^(4) + 8^(4)
 * 9474 = 9^(4) + 4^(4) + 7^(4) + 4^(4)
 * 
 * As 1 = 1^(4) is not a sum it is not included.
 * 
 * The sum of these numbers is 1634 + 8208 + 9474 = 19316.
 * Find the sum of all the numbers that can be written as the sum of fifth 
 * powers of their digits.
 */

public class PS030 {

	public static void main(String[] args) {
		int total = 0;
		int max = 6*(int)Math.pow(9, 5);
		
		long start = System.nanoTime();
		for(int i = 2; i <= max; i++){
			int sum = 0, temp;
			
			temp = i;
			do{
				sum += Math.pow(temp % 10, 5);
				temp /= 10;
			}while(temp > 0);
			
			if(sum == i)
				total += sum;	
		}
		long stop = System.nanoTime();
		System.out.println("total = " + total);
		System.out.println((stop - start)/1000000 + "ms");
	}

}
