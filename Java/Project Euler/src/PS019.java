/*
 * Author: Brandon Bernie
 * 
 * You are given the following information, but you may prefer to do some 
 * research for yourself.
 * 
 * 1 Jan 1900 was a Monday.
 * Thirty days has September,
 * April, June and November.
 * All the rest have thirty-one,
 * Saving February alone,
 * Which has twenty-eight, rain or shine.
 * And on leap years, twenty-nine.
 * A leap year occurs on any year evenly divisible by 4, but not on a century 
 *   unless it is divisible by 400.
 *   
 * How many Sundays fell on the first of the month during the twentieth 
 * century (1 Jan 1901 to 31 Dec 2000)?
 */

import java.util.Calendar;

public class PS019 {

	public static void main(String[] args) {
		long start, stop;
		Calendar c = Calendar.getInstance();
		int fomSundays = 0;
		
		start = System.nanoTime();
		for (int year = 1901; year < 2001; year++) {
			c.set(year, Calendar.JANUARY, 1);
			int month = 1;
			do {
				if (c.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)
					fomSundays++;
				c.roll(Calendar.MONTH, true);
				month++;
			} while (month <= 12);
		}
		stop = System.nanoTime();
		System.out.println(fomSundays + " " + (stop - start)/1000000 + " ms");
		
		int[] months={31,28,31,30,31,30,31,31,30,31,30,31};
		int[] lymonths={31,29,31,30,31,30,31,31,30,31,30,31};
		int day = 2;
		int count = 0;
		
		start = System.nanoTime();
		for(int year = 1901; year < 2001; year++){
			for(int i = 0; i < 12; i++){
				if(year % 4 != 0)
					day += months[i] % 7;
				else
					day += lymonths[i] % 7;
				
				if(day % 7 == 0)
					count++;
			}
		}
		stop = System.nanoTime();
		System.out.println(count + " " + (stop - start) + " ns");
	}
}
