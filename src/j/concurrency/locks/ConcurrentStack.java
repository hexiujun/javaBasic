package j.concurrency.locks;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by j on 2017/9/6.
 *
 * 无锁化实现 并发栈
 */
public class ConcurrentStack<E> {
    AtomicReference<Node<E>> top = new AtomicReference<>();

    public void push(E item) {
        Node<E> newHead = new Node<E>(item);
        Node<E> oldHead;
        while (true) {
            oldHead = top.get();
            newHead.next = oldHead;
            if (top.compareAndSet(oldHead, newHead))
                return;
        }
    }

    public E pop() {
        Node<E> newHead, oldHead;
        while (true) {
            oldHead = top.get();
            if (oldHead == null) return null;
            newHead = oldHead.next;
            if (top.compareAndSet(oldHead, newHead))
                return oldHead.item;
        }
    }

    private static class Node<E> {
        E item;
        Node<E> next;

        public Node(E item) {
            this.item = item;
        }
    }
}
