package project_euler;
/*
 * Author: Brandon Bernie
 * 
 * Problem 248
 * 
 * The first number n for which eulerPhi(n)=13! is 6227180929.
 * 
 * Find the 100,000^(th) such number.
 */

import org.bsalgorithms.math.util.NumberTheory;

public class PS248 {

	
	public static void main(String[] args) {
		long k = 6227020800L;
		long n = 6227180929L;
		int count = 0;
		
		do{
			if(NumberTheory.eulerPhi(n) == k){
				count++;
				System.out.println(count + "\t: eulerPhi(" + n + ")" + NumberTheory.factorLongInteger(n));
			}
			n++;
		}while(count != 100000);
		n--;
		
		System.out.println(n);

	}

}