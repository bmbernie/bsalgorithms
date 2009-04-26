/*
 * Author: Brandon Bernie
 * 
 * Problem 16
 * 
 * 2^(15) = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 * 
 * What is the sum of the digits of the number 2^(1000)?
 */

import java.math.BigInteger;

public class PS16 {
	
	public static void main(String[] args) {
		BigInteger a= new BigInteger("2");
		a = a.pow(1000);
		int finalSum=0;
		
		for(int j=0;j<a.toString().length();j++)
			finalSum+=Integer.parseInt(a.toString().substring(j, j+1));
		
		System.out.println(finalSum);
	}

}
