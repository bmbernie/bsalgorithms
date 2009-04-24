/*
 * Author: Brandon Bernie
 * 
 * Problem 3
 * 
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * 
 * What is the largest prime factor of the number 
 * 600851475143 ?
 */

public class PS3 {

	public static void main(String[] args) {
		
		long number = 600851475143L;
		long max = 0;
		long start = System.currentTimeMillis();
		for(long x=3, end = (int)Math.sqrt(number); x <= end; x+=2)
			if(number % x == 0)
				if(isPrime(x))
					if(x>max)
						max=x;
		long stop = System.currentTimeMillis();
		
		System.out.println(max + " " + (stop-start) + " ms");
	}
	
	public static boolean isPrime(long n) {    
		// 2 is the smallest prime
        if (n <= 2)
            return n == 2;
        
        // even numbers other than 2 are not prime
        if (n % 2 == 0) 
            return false;
      
        // check odd divisors from 3
        // to the square root of n
        for (int i = 3, end = (int)Math.sqrt(n); i <= end; i += 2)
            if (n % i == 0) 
                return false;
         
        return true;
    }
}
