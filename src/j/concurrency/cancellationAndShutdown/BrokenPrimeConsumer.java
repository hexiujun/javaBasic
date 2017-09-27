package j.concurrency.cancellationAndShutdown;

import java.math.BigInteger;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by j on 2017/8/24.
 */
public class BrokenPrimeConsumer {
    public void consumePrimes() throws InterruptedException {
        BlockingQueue<BigInteger> primes = new ArrayBlockingQueue<BigInteger>(1000);
        BrokenPrimeProducer producer = new BrokenPrimeProducer(primes);
        producer.start();

        int needPrimes = 10000;
        try {
            while (needPrimes-- > 0)
                primes.take();
        } finally {
            producer.cancel();
        }
    }
}
