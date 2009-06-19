package project_euler;
import java.io.FileReader;
import java.util.Arrays;
import java.io.BufferedReader;

public class PS042 {

	public static void main(String[] args) {
		BufferedReader br = null;
		String[] names = null;
		char[] temp = null;
		int store, triword = 0;
		
		long start = System.currentTimeMillis();
		try {
			br = new BufferedReader(new FileReader("words.txt"));
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
			if(isTri((double)store)){
				triword++;
				System.out.println(temp);
				}
		}
		
		long stop = System.currentTimeMillis();
		System.out.println(stop - start + "ms");
		System.out.println(triword);
	}
	
	public static boolean isTri(double pent){
		double a = 1, b = 1, c = -(2 * pent);
		double root1, real;
		
		real = (Math.pow(b, 2)) - (4 * a * c);
		root1 = (-b + Math.sqrt(real)) / (2 * a);

		if(root1 > 0)
			if(root1 % 1 == 0)
				return true;
				

		return false;
	}

}
