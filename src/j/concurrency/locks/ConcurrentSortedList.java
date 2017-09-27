package j.concurrency.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by j on 2017/9/6.
 * 交替锁实现并发的有序双向链表
 */
public class ConcurrentSortedList {
    private class Node {
        int val;
        Node prev, next;
        Lock lock = new ReentrantLock();

        Node() {}

        Node(int val, Node prev, Node next) {
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }

    private final Node head = new Node();
    private final Node tail = new Node();

    public ConcurrentSortedList() {
        head.next = tail;
        tail.prev = head;
    }

    public void insert(int value) {
        Node current = head;
        current.lock.lock();
        Node next = current.next;
        try {
            while (true) {
                next.lock.lock();
                try {
                    if (next == tail || value <= next.val) {
                        Node node = new Node(value, current, next);
                        next.prev = node;
                        current.next = node;
                        return;
                    }
                } finally {
                    current.lock.unlock();
                }
                current = current.next;
                next = current.next;
            }
        } finally {
            next.lock.unlock();
        }
    }

    // 倒序遍历链表，访问当前链表节点的个数，想想为什么要倒序？
    public int size() {
        Node current = tail;
        int count = 0;
        while (current.prev != head) {
            Lock lock = current.lock;
            lock.lock();
            try {
                ++count;
                current = current.prev;
            } finally {
                lock.unlock();
            }
        }
        return count;
    }
}
