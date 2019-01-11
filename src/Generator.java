import java.math.BigInteger;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Generator {
    private static List<Integer> sieveOfEratosthenes(int n) {
        boolean prime[] = new boolean[n + 1];
        Arrays.fill(prime, true);
        for (int p = 2; p * p <= n; p++) {
            if (prime[p]) {
                for (int i = p * 2; i <= n; i += p) {
                    prime[i] = false;
                }
            }
        }
        List<Integer> primeNumbers = new LinkedList<>();
        for (int i = 2; i <= n; i++) {
            if (prime[i]) {
                primeNumbers.add(i);
            }
        }
        return primeNumbers;
    } //генерирую через решето Эратосфена

    public static int getPrime() {
        Random r = new Random(System.currentTimeMillis()); //генератор рандома
        List<Integer> primeNumbers = sieveOfEratosthenes(100);
        return primeNumbers.get(r.nextInt(primeNumbers.size())); //получаем ранд число из списка


    }
    public static BigInteger getBigPrime() {
        return BigInteger.valueOf(getPrime());
    }
}
