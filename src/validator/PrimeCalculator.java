package validator;
import java.util.ArrayList;
import java.util.List;


public class PrimeCalculator {
    public static List<Integer> calculatePrimes(int upperBound) {
        List<Integer> primes = new ArrayList<>();
        
        boolean[] isComposite = new boolean[upperBound + 1];
        for (int i = 2; i <= Math.sqrt(upperBound); i++) {
            if (!isComposite[i]) {
                for (int j = i * i; j <= upperBound; j += i) {
                    isComposite[j] = true;
                }
            }
        }

        for (int i = 2; i <= upperBound; i++) {
            if (!isComposite[i]) {
                primes.add(i);
            }
        }
        return primes;
    }
}


