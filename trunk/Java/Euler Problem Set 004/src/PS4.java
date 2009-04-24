/*
 * Author: Brandon Bernie
 * 
 * Problem 4
 * 
 * A palindromic number reads the same both ways. The largest palindrome made
 * from the product of two 2-digit numbers is 9009 = 91 × 99.
 * 
 * Find the largest palindrome made from the product of two 3-digit numbers.
 */

public class PS4 {

	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		int test=0;
		int comp=0;
		for(int i = 100; i<=999; i++)
			for(int j = 100; j<=999; j++){
				test = i*j;
				if(isNumericPalindrome(test)){
					if(comp < test){
						comp = test;
					}
				}
			}
		long stop = System.currentTimeMillis();
		System.out.println(comp + " " + (stop - start) + " ms");
	}
	
	public static boolean isNumericPalindrome(int n){
		String pal = "" + n;
		String reversed = reverseString(pal);
		
		if(pal.compareTo(reversed) == 0)
			return true;
		
		return false;
	}
	
	public static String reverseString(String s){
		int i = s.length()-1;
		StringBuffer dest = new StringBuffer(i+1);
		
		for(; i >= 0; i--)
			dest.append(s.charAt(i));
		
		return dest.toString();
	}
}
