package project_euler;
/*
 * Problem 36
 * 
 *  The decimal number, 585 = 1001001001_(2) (binary), is palindromic in both 
 *  bases.
 *  
 * Find the sum of all numbers, less than one million, which are palindromic in
 * base 10 and base 2.
 * 
 * Please note that the palindromic number, in either base, may not include 
 * leading zeros.
 * 
 */

import java.lang.Integer;

public class PS036 {

	public static void main(String[] args) {
		long sum = 0;
		long start, stop;
		String dec = new String("");
		String bin = new String("");
	
		start = System.currentTimeMillis();
		
		for(int i = 1; i <= 1000000; i += 2){
			dec = "" + i;
			bin = "" + Integer.toBinaryString(i);
			
			if(isPalendrome(dec))
				if(isPalendrome(bin))
					sum += i;
		}
		stop =  System.currentTimeMillis();

		System.out.println(sum + " " + (stop - start) + "ms");
	}
	
	public static boolean isPalendrome(String number){
		for(int position = 0; position < number.length() / 2; position++)
			if(number.charAt(position) != number.charAt(number.length() - position - 1))
				return false;
		return true;
	}
    
}
