package j.concurrency.cancellationAndShutdown;

import java.math.BigInteger;
import java.util.concurrent.BlockingQueue;

/**
 * Created by j on 2017/8/24.
 */
public class BrokenPrimeProducer extends Thread {
    private final BlockingQueue<BigInteger> queue;
    private volatile boolean cancelled = false;

    public BrokenPrimeProducer(BlockingQueue<BigInteger> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            BigInteger p = BigInteger.ONE;
            while (!cancelled)
                queue.put(p = p.nextProbablePrime());
        } catch (InterruptedException e) {
            // 通过捕捉中断异常，允许线程退出
        }
    }

    public void cancel() {
        cancelled = true;
    }
}
