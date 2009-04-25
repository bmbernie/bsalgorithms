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
		BigInteger total = BigInteger.ZERO;
		BufferedReader br = null;
		String temp = null;
		String[] lines = new String[100];
		int[] arr = new int[50];
		int tmpint = 0;
		
		long start = System.nanoTime();
		try {
			br = new BufferedReader(new FileReader("numbers.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		int i = 0;
		try {
			while ((temp = br.readLine()) != null) {
				bInt[i] = new BigInteger(temp);
				lines[i] = temp;
				i++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for(int j = 0; j <100; j++)
			total = total.add(bInt[j]);
		long stop = System.nanoTime();
		System.out.println(total.toString().substring(0, 10) + " ");
		System.out.println((stop - start) + " ns ");
		
		start = System.nanoTime();
		for(int a = 49; a >= 0; a--){
			for(int b = 0; b < 100; b++){
				tmpint += lines[b].charAt(a) - 48;
			}
			arr[a] = tmpint;
			tmpint = 0;
		}
		for(int a = 49; a >= 1; a--) {
			tmpint = arr[a];
			arr[a] = tmpint % 10;
			tmpint /= 10;
			arr[a-1] += tmpint;
		}
		tmpint = arr[0];
		i = 0;
		while(tmpint > 0){
			tmpint /= 10;
			i++;
		}
		for(int a = 0; a <= 9-(i-1); a++)
			System.out.print(arr[a]);
		stop = System.nanoTime();
		
		System.out.println("\n" + (stop - start) + " ns");
	}

}
