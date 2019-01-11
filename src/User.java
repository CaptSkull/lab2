import java.math.BigInteger;
import java.util.Random;

public class User {
    private BigInteger P;
    private BigInteger G;
    private BigInteger A;
    private BigInteger a;
    private BigInteger B = BigInteger.valueOf(0);
    private String Name;
    private Random rnd;

    public User(String Name, BigInteger p, BigInteger G) {
        this.P = p;
        this.G = G;
        this.Name = Name;
        this.rnd=new Random(System.currentTimeMillis());
        this.a = BigInteger.valueOf((2 + rnd.nextInt(P.intValue() - 3)) / 3);
        System.out.println(Name + " сгенил закр ключ " + this.a);
        this.A = G.modPow(this.a, P);
        System.out.println(Name + " сгенил открытый ключ: " + this.A);
    }

    public BigInteger getA() {
        return A;
    }

    public void setB(BigInteger B) {
        this.B = B;
    }

    public BigInteger genCommonSecret() {
        if (B.equals(BigInteger.valueOf(0))) {
            throw new IllegalArgumentException("B not initialized");
        }
        BigInteger K = B.modPow(a, P);
        System.out.println(Name + " Получил общий секрет " + K);
        return (K);
    }

}
