
public class PS040 {

	public static void main(String[] args) {
		int counter = 0;
		int exponent = 0;
		int digit = 1;
		int total = 1;
		
		long start = System.currentTimeMillis();
		do{
			int nth = (int)Math.pow(10, exponent);
			int numlen = Integer.toString(digit).length();
			counter += numlen;
			
			if(counter >= nth){
				total *= (int)(Integer.toString(digit).charAt(numlen - (counter - nth) - 1) - 48);
				exponent++;
			}
			digit++;
		}while(counter < 1000000);
		long stop = System.currentTimeMillis();
		
		System.out.println(total + " in " + (stop - start) + " ms");
	}

}
