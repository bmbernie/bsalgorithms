/*
 * Problem 45
 * 
 * Triangle, pentagonal, and hexagonal numbers are generated by the following 
 * formulae:
 * Triangle 	  	T_(n)=n(n+1)/2 	  	1, 3, 6, 10, 15, ...
 * Pentagonal 	  	P_(n)=n(3n-1)/2 	1, 5, 12, 22, 35, ...
 * Hexagonal 	  	H_(n)=n(2n-1) 	  	1, 6, 15, 28, 45, ...
 * 
 * It can be verified that T_(285) = P_(165) = H_(143) = 40755.
 * 
 * Find the next triangle number that is also pentagonal and hexagonal.
 */

public class PS045 {
	static int floor = 0;
	public static void main(String[] args) {
		int n=177;
		long start = System.currentTimeMillis();

		while(true){
		double pent = Pentagonal(n);
		if(pent %2 != 0 && isHex(pent) && isTri(pent))
				break;
		n+=2;
	}
		long stop = System.currentTimeMillis();
		System.out.println("P(" + n + ") = " + Pentagonal(n) + " in: " + (stop - start) + "ms");
	}
	
	public static boolean isTri(double pent){
		double a = 1, b = 1, c = -(2 * pent);
		double root1, real;
		
		real = (Math.pow(b, 2)) - (4 * a * c);

		root1 = (-b + Math.sqrt(real)) / (2 * a);

		if(root1 > 0)
			if(root1 % 1 == 0){
				System.out.println("T(" + (int)root1 + ") = " + Triangle((int)root1));
				return true;
				}

		return false;
	}
	
	public static boolean isHex(double pent){
		double a = 2, b = -1, c = -pent;
		double root1, real;
		
		real = (Math.pow(b, 2)) - (4 * a * c);
		root1 = (-b + Math.sqrt(real)) / (2 * a);

		if(root1 > 0)
			if(root1 % 1 == 0){
				System.out.println("H(" + (int)root1 + ") = " + Hexagonal((int)root1));
				return true;
				}

		return false;
	}
	
	public static double Triangle(double n){
		return (n*(n + 1))/2;
	}
	
	public static double Pentagonal(double n){
		return (n*((3*n) - 1))/2;
	}
	
	public static double Hexagonal(double n){
		return (n*((2*n) - 1));
	}
}
