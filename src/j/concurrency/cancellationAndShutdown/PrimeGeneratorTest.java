package j.concurrency.cancellationAndShutdown;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by j on 2017/8/15.
 * 取消策略需要定义：How， When， What
 * 取消策略：客户代码通过调用cancel来请求取消任务（How），任务每次搜索素数前查询取消状态（When），一旦取消状态为true结束任务（What）。
 */
public class PrimeGeneratorTest {
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
            TimeUnit.SECONDS.sleep(1);
        } finally {
            generator.cancel();
        }
        return generator.get();
    }
}
