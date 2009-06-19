package project_euler;
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

public class PS004 {

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
		
		start = System.currentTimeMillis();
		int pd = 0;
		int a = 100;
		while(a <= 999){
			int b = a;
			while(b <= 999){
				if(isPD(a*b) && (a*b) > pd)
					pd = a*b;
				b++;
			}
			a++;
		}
		stop = System.currentTimeMillis();
		System.out.println(pd + " " + (stop - start) + " ms");
		
		start = System.nanoTime();
		pd=0;
		a=999;
		while (a > 100){
			int b = 990;
			while(b > 100){
				if((a * b) > pd)
					if(isPD(a * b))
						pd = a * b;
				b -= 11;
			}
			a--;
		}
		stop = System.nanoTime();
		System.out.println(pd + " " + (stop - start) + " ns");
	}
	
	public static int reverse(int n){
		int reversed = 0;
		while(n > 0){
			reversed = (10*reversed) + (n%10);
			n/=10;
		}
		return reversed;
	}
	
	public static boolean isPD(int n){
		if(reverse(n) == n)
			return true;
		return false;
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
