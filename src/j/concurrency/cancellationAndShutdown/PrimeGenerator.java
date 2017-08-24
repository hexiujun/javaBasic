package j.concurrency.cancellationAndShutdown;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by j on 2017/8/15.
 * :ThreadSafe
 * 一种协作式的取消任务的机制：设置某个“已请求取消”的标志，而任务定期的查看该标志。
 */

public class PrimeGenerator implements Runnable {
    private final List<BigInteger> primes = new ArrayList<>();
    private volatile boolean cancelled;

    @Override
    public void run() {
        BigInteger p = BigInteger.ONE;
        while (!cancelled) {
            p = p.nextProbablePrime();
            synchronized (this) {
                primes.add(p);
            }
        }
    }

    public void cancel() {
        cancelled = true;
    }

    public synchronized List<BigInteger> get() {
        return new ArrayList<>(primes);
    }
}
