package project_euler;
/*
 * Author: Brandon Bernie
 * 
 * Problem 44
 * 
 * Pentagonal numbers are generated by the formula, P_(n)=n(3n-1)/2. The first
 * ten pentagonal numbers are:
 * 
 * 1, 5, 12, 22, 35, 51, 70, 92, 117, 145, ...
 * 
 * It can be seen that P_(4) + P_(7) = 22 + 70 = 92 = P_(8). However, their
 * difference, 70 - 22 = 48, is not pentagonal.
 * 
 * Find the pair of pentagonal numbers, P_(j) and P_(k), for which their sum
 * and difference is pentagonal and D = |P_(k) - P_(j)| is minimised; what is
 * the value of D?
 */

public class PS044 {

	public static void main(String[] args) {
		int[] p = new int[10000];
		int temp = 1;
		
		long start = System.nanoTime();
		for(int i = 1; i < p.length; i++){
			p[i] = temp;
			temp = temp + ((i*3) + 1);
		}
		
		for(int i = 1; i < p.length; i++)
			for(int j = 1; j < i; j++)
				if(isPentagonal(p[i]+p[j]) && isPentagonal(p[i]-p[j])){
					System.out.println(p[i] - p[j]);
					long stop = System.nanoTime();
					System.out.println((stop - start)/1000000 + " ms");
				}	
	}
	
	static boolean isPentagonal(int n){
		
		if (n > 0) {

			double a = 3, b = -1, c = -(2 * n);
			double discriminant, root1, root2;

			discriminant = (b * b - 4 * a * c);
			
			if(discriminant >= 0){
				root1 = (-b / 2.0 / a - Math.sqrt(discriminant) / 2.0 / a);
				root2 = (-b / 2.0 / a + Math.sqrt(discriminant) / 2.0 / a);
				
				if (root1 % 1 == 0 && root1 > 0) {
					//System.out.println(n + " = p[" + root1 + "]");
					return true;
				}
				if (root2 % 1 == 0 && root2 > 0) {
					//System.out.println(n + " = p[" + root2 + "]");
					return true;
				}
			}
		} 
		
		return false;
	}

}
