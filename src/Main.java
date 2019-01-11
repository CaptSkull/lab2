import java.math.BigInteger;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random r = new Random(System.currentTimeMillis()); //генератор рандома

        BigInteger p = Generator.getBigPrime();
        BigInteger G = BigInteger.valueOf(2+r.nextInt(p.intValue()-2));
        System.out.println("Начальные параметры p = "+p+" G = "+G);
        User Anya = new User("Anya",p,G);
        User Boris = new User ("Boris", p,G);
        Boris.setB(Anya.getA());
        Anya.setB(Boris.getA());

        if (Boris.genCommonSecret().equals(Anya.genCommonSecret())) {
            System.out.println("Good");
        } else {
            System.out.println("Not today");
        }

    }
}
