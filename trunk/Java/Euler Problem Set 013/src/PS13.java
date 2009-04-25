/*
 * Author: Brandon Bernie
 * 
 * Problem 13
 * 
 * Work out the first ten digits of the sum of the following one-hundred 
 * 50-digit numbers.
 * 
 * [edited out]
 */

import java.math.BigInteger;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PS13 {

	public static void main(String[] args) {
		BigInteger[] bInt = new BigInteger[100];
		BigInteger total = new BigInteger("0");
		BufferedReader br = null;
		String temp = null;
		
		long start = System.currentTimeMillis();
		try {
			br = new BufferedReader(new FileReader("numbers.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		int i = 0;
		try {
			while ((temp = br.readLine()) != null) {
				bInt[i] = new BigInteger(temp);
				i++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for(int j = 0; j <100; j++)
			total = total.add(bInt[j]);
		long stop = System.currentTimeMillis();
		System.out.println(total.toString().substring(0, 9));
		System.out.println((stop - start) + " ms");
		
	}

}
