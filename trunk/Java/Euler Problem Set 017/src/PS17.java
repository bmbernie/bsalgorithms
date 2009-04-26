/*
 * Author: Brandon Bernie
 * 
 * Problem 17
 * 
 * If the numbers 1 to 5 are written out in words: one, two, three, four, 
 * five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
 * 
 * If all the numbers from 1 to 1000 (one thousand) inclusive were written 
 * out in words, how many letters would be used?
 * 
 * NOTE: 
 * Do not count spaces or hyphens. For example, 
 * 342 (three hundred and forty-two) contains 23 letters and 
 * 115 (one hundred and fifteen) contains 20 letters. The use of "and" when 
 * writing out numbers is in compliance with British usage.
 */

public class PS17 {
	
	public static void main(String[] args) {
		int sum = 0;
		for(int i = 1; i <= 1000; i++){
			sum += getLetters(i);
		}
		
		System.out.println("total letters = " + sum);
	}
	
	public static int getLetters(int number){
		int total = 0;
		
		//split into parts
		int thousands  = (number / 1000);
		int hundreds = (number % 1000)/100;
		int tens = (number % 100)/10;
		int ones = (number % 10);
		
		//thousands
		if(thousands == 1)
			total += 3 + 8;
		
		//hundreds
		if(hundreds == 1 || hundreds == 2 || hundreds == 6)
			total += (3 + 7);
		if(hundreds == 4 || hundreds == 5 || hundreds == 9)
			total += (4 + 7);
		if(hundreds == 3 || hundreds == 7 || hundreds == 8)
			total += (5 + 7);
		if(hundreds != 0 && !(tens == 0 && ones == 0))
			total += 3;

		if(tens == 1)
			if(ones == 0)
				total += 3;
			else if(ones == 1 || ones == 2)
				total += 6;
			else if(ones == 3 || ones == 4 || ones == 8 || ones  == 9)
				total += 8;
			else if(ones == 5 || ones == 6)
				total += 7;
			else
				total += 9;
		else if(tens > 1)
			if(tens == 2 || tens == 3 || tens == 8 || tens ==9)
				total += 6;
			else if(tens == 4 || tens == 5 || tens == 6)
				total += 5;
			
			else if(tens == 7)
				total += 7;
		
		if(ones < 10 && tens != 1)
			if(ones == 1 || ones == 2 || ones == 6)
				total += 3;
			else if(ones == 4 || ones == 5 || ones == 9)
				total += 4;
			else if(ones == 3 || ones == 7 || ones == 8)
				total += 5;
			
		return total;
	}

}
