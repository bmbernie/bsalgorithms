/*
 * Author: Brandon Bernie
 * 
 * Problem 21
 * 
 * Let d(n) be defined as the sum of proper divisors of n 
 * (numbers less than n which divide evenly into n).
 * 
 * If d(a) = b and d(b) = a, where a ? b, then a and b are an amicable pair and 
 * each of a and b are called amicable numbers.
 * 
 * For example, the proper divisors of 220 are:
 * 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284. 
 * The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.
 * 
 * Evaluate the sum of all the amicable numbers under 10000.
 */

import java.util.LinkedList;
import java.lang.Integer;

public class PS21 {
	public static void main(String[] args) {
		int first = 0, second = 0, total = 0;
		boolean willContinue = false;
		LinkedList<Integer> pairList = new LinkedList<Integer>();
		
		long begin = System.currentTimeMillis();
		for(int i = 1; i <= 10000; i ++){
			willContinue = false;
			
			for(int j = 0; j <= pairList.size()-1; j++)
				if(((Integer)pairList.get(j)).intValue() == i)
					willContinue = true;		
			if(willContinue)
				continue;
			
			first = addDivisors(i);
			
			if(first == i)
				continue;
			
			second = addDivisors(first);
			if(second == i){
				total += first + second; 
				pairList.add(new Integer(first));
				pairList.add(new Integer(second));
			}
			
		}
		long end = System.currentTimeMillis();
		
		System.out.println(end - begin + "ms");
		System.out.println("sum of all amicable pairs = " + total);
	}
	
	public static int addDivisors(int num){
		int sum = 1;
		
		//slow and clunky
		//900ms
		//for(int i = 2; i <= num/2; i++)
		//	if(num % i == 0)
		//		sum += i;
		
		//optimized slightly using a better brute force approach
		//47ms
		for(int i = 2; i <= Math.sqrt(num); i++)
			if(num%i == 0)
				sum += i + (num/i);
			
		return sum;
				
	}
}
