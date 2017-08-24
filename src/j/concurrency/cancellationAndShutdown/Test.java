package j.concurrency.cancellationAndShutdown;

import java.math.BigInteger;
import java.util.List;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Created by j on 2017/8/15.
 */
public class Test {
    public static void main(String[] args) {
        try {
            System.out.println(aSecondOfPrimes());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static List<BigInteger> aSecondOfPrimes() throws InterruptedException {
        PrimeGenerator generator = new PrimeGenerator();
        new Thread(generator).start();

        try {
            SECONDS.sleep(1);
        } finally {
            generator.cancel();
        }
        return generator.get();
    }
}
