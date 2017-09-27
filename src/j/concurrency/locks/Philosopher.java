package j.concurrency.locks;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by j on 2017/9/6.
 * 使用条件变量Condition 解决哲学家进餐问题
 */
public class Philosopher extends Thread{
    private boolean eating;
    private Philosopher left, right;
    private ReentrantLock table;
    private Condition condition;

    public Philosopher(ReentrantLock lock) {
        this.eating = false;
        this.table = lock;
        this.condition = this.table.newCondition();
    }

    public void setLeft(Philosopher left) {
        this.left = left;
    }

    public void setRight(Philosopher right) {
        this.right = right;
    }

    @Override
    public void run() {
        while (true) {
            try {
                think();
                eat();
            } catch (InterruptedException e) {
            }
        }
    }

    public void think() throws InterruptedException {
        table.lock();
        try {
            eating = false;
            left.condition.signal();
            right.condition.signal();
        } finally {
            table.unlock();
        }
        Thread.sleep(1000);
    }

    public void eat() throws InterruptedException {
        table.lock();
        try {
            while (left.eating || right.eating)
                condition.await();
            eating = true;
        } finally {
            table.unlock();
        }
        Thread.sleep(1000);
    }
}
