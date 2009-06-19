package project_euler;
/*
 * Problem 52
 * 
 * It can be seen that the number, 125874, and its double, 251748, contain 
 * exactly the same digits, but in a different order.
 * 
 * Find the smallest positive integer, x, such that 2x, 3x, 4x, 5x, and 6x, 
 * contain the same digits.
 */

public class PS052 {
	
	public static void main(String[] args) {

		int x = 1;
		
		long start = System.currentTimeMillis();
		while(!containsSameDigits(x))
			x++;
		long stop = System.currentTimeMillis();
		
		for(int i = 1; i <= 6; i++)
			System.out.println(x*i);
		System.out.println((stop - start) + "ms");
	}
	
	public static boolean containsSameDigits(int x){
		String[] sX =  new String[6];
		String[] sTable = new String[6]; 
		int[][] occTable = new int[6][10];
		int len;
		String compare = new String("");
		
		for(int i = 0; i < 6; i++)
			sX[i] = String.valueOf((i+1)*x);
		
		//make sure that each of the numbers is same length
		len = sX[0].length();
		for(int i = 0; i < 6; i++)
			if(sX[i].length() != len)
				return false;
		
		for(int i = 0; i < 6; i++){
			for(int j = 0; j < 10; j++){
				int result = 0;
				String searchFor = String.valueOf(j);
				int start = sX[i].indexOf(searchFor);
				while(start != -1){
					result++;
					start = sX[i].indexOf(searchFor, start+searchFor.length());
				}
				occTable[i][j] = result;
			}
		}
		
		for(int j = 0; j < 10; j++)
			compare += String.valueOf(occTable[0][j]);
		
		//initialize
		for(int i = 0; i< 6; i++)
			sTable[i] = "";
		//set
		for(int i = 0; i < 6; i++)
			for(int j = 0; j < 10; j++)
				sTable[i] += String.valueOf(occTable[i][j]);
		
		//compare
		for(int i = 0; i < 6; i++)
			if(!compare.contentEquals(sTable[i]))
				return false;
				
		return true;	
	}

}
