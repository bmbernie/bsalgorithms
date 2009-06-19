package project_euler;
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

import org.bsalgorithms.math.util.NumberTheory;
import org.bsalgorithms.util.Pair;
import org.bsalgorithms.util.Timing;

import java.util.List;

public class PS003 {

	public static void main(String[] args) {
        Timing t = new Timing();

        t.start();
        List<Pair<Long, Long>> factors = NumberTheory.factorLongInteger(600851475143L);
        t.stop();
		System.out.println(factors + " " + t);

        t.start();
        long N = 600851475143L;
        for (long i = 2; i <= N/i; i++)
            while (N % i == 0)
                N = N / i;
        t.stop();
        System.out.println(N + " " + t.diff());

    }
}
