package pack1;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/*
* author kl
* 通过队列模拟栈,(队列 先进先出 栈先进后出
* */
public class TwoQueueStack<T> {
    private Queue<T> queue;
    private Queue<T> queue2;
    private static int DEFAULT_SIZE = 16;
    private int stack_size;

    public TwoQueueStack() {

        this(DEFAULT_SIZE);
    }

    public TwoQueueStack(int size) {
        this.stack_size = size;
        queue = new ConcurrentLinkedQueue<>();
        queue2 = new ConcurrentLinkedQueue<>();
    }

    public void push(T t) {
        if (queue.size() >= stack_size)
            throw new ArrayIndexOutOfBoundsException("栈满了 当前栈的大小是: " + stack_size);
        queue.add(t);
    }

    public T pop() {
        convert();  //将queue1中的元素倒入queue2 只剩一个
        T value = queue.poll();
        Queue<T> temp = queue;
        queue = queue2;
        queue2 = temp;
        return value;
    }

    public T peek() {
        convert();  // 将queue1中的元素倒入queue2 只剩一个
        T value = queue.poll();
        queue2.add(value);
        Queue<T> temp = queue;
        queue = queue2;
        queue2 = temp;
        return value;

    }

    public void convert() {
        while (queue.size() > 1)
            queue2.add(queue.poll());
    }

    public int size() {
        return queue.size();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public String toString() {
        return queue.toString();
    }

}
