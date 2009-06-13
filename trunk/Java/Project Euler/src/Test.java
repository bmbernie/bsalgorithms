/*
 * Author: Brandon Bernie
 * 
 * Driver for various NumberTheory functions
 */

import org.bsalgorithms.NumberTheory;

public class Test {
	
	public static void main(String[] args) {
		int temp = 1;
		int[] p = new int[100001];
		
		for(int i = 1; i <= 100000; i++){
			p[i] = temp;
			temp = temp + ((i*3) + 1);
		}
		
		System.out.println(p[4]);
		
		isPentagonal(70);
	}
	
	static boolean isPentagonal(int n){
		
		if (n > 0) {

			double a = 3, b = -1, c = -(2 * n);
			double discriminant, root1, root2;

			discriminant = (b * b - 4 * a * c);
			
			if(discriminant >= 0){
				root1 = (-b / 2.0 / a - Math.sqrt(discriminant) / 2.0 / a);
				root2 = (-b / 2.0 / a + Math.sqrt(discriminant) / 2.0 / a);
				
				if (root1 % 1 == 0) {
					System.out.println(root1);
					return true;
				}
				if (root2 % 1 == 0) {
					System.out.println(root2);
					return true;
				}
			}
		} 
		
		return false;
	}
	
}
