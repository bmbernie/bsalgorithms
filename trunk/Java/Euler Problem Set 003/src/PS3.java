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
    	if(n==1)
    		return false;
    	else if(n < 4)
    		return true;
    	else if(n % 2 == 0)
    		return false;
    	else if(n < 9)
    		return true;
    	else if(n % 3 == 0)
    		return false;
    	else{
    		long r = (long)Math.floor(Math.sqrt(n));
    		long f = 5;
    		while(f <= r){
    			if(n % f == 0)
    				return false;
    			if(n % (f+2) == 0)
    				return false;
    			f+=6;
    		}
    		return true;
    	}
    }
}
