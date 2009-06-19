package project_euler;
/*
 * Author: Brandon Bernie
 * 
 * Problem 22
 * 
 * Using names.txt (right click and 'Save Link/Target As...'), a 46K text file
 * containing over five-thousand first names, begin by sorting it into 
 * alphabetical order. Then working out the alphabetical value for each name,
 * multiply this value by its alphabetical position in the list to obtain a 
 * name score.
 * 
 * For example, when the list is sorted into alphabetical order, COLIN, which 
 * is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. 
 * So, COLIN would obtain a score of 938 × 53 = 49714.
 * 
 * What is the total of all the name scores in the file?
 * 
 * first run = 625ms
 * second run = 31ms
 */

import java.io.FileReader;
import java.util.Arrays;
import java.io.BufferedReader;


public class PS022 {

	public static void main(String[] args) throws Exception {	
		BufferedReader br = null;
		String[] names = null;
		char[] temp = null;
		int store, total = 0;
		
		long start = System.currentTimeMillis();
		try {
			br = new BufferedReader(new FileReader("names.txt"));
		} catch (Exception e) {
			System.out.println(e.toString() + "FileNotFound");
			e.printStackTrace();
		}
		
		try {
			names = br.readLine().split(",");
		} catch (Exception e) {
			System.out.println("IOException");
			e.printStackTrace();
		}
		Arrays.sort(names);
		
		for(int i = 0; i < names.length; i++){
			store = 0;
			temp = names[i].toCharArray();
			for(int j = 0; j < temp.length; j++)
				if(temp[j] != '\"')
					store += (int)temp[j] - 64;

			total += store * (i+1);
		}
		
		long stop = System.currentTimeMillis();
		System.out.println(stop - start + "ms");
		System.out.println(total);
	}

}
