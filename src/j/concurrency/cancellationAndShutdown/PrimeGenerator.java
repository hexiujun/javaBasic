package j.concurrency.cancellationAndShutdown;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by j on 2017/8/15.
 * :ThreadSafe
 *
 * 一种协作式的取消任务的机制：设置某个“已请求取消”的标志，而任务定期的查看该标志。
 *
 * 问题：1. 任务响应取消请求到任务退出过程，需要花费一定的时间。
 *      2. 使用该方法的任务调用一个阻塞方法时，任务可能永远不会检查取消标志，因此永远不会结束。
 * @see BrokenPrimeProducer
 * @see BrokenPrimeConsumer
 *
 * 解决方案：中断
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
