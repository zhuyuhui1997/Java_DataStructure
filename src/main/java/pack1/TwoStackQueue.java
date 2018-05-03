package pack1;

import org.junit.Test;

import java.util.*;

/*
* 由两个栈实现队列,栈先进后出  队列:先进先出
* author kl
* 栈 Stack
*
* */
public class TwoStackQueue<E> {
    private Stack<E> dataStack;  //数据栈
    private Stack<E> popStack;  //弹出栈   因为先进后出 入另一个栈 后就会 先出
    private int capacity;
    private static int DEFAULT_CAPACITY = 16;

    protected void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public TwoStackQueue() {
        this(DEFAULT_CAPACITY);
    }

    public TwoStackQueue(int size) {
        this.capacity = size;
        dataStack = new Stack<>();
        popStack = new Stack<>();
    }

    private void convert() {
        if (popStack.size() == 0) {
            while (dataStack.isEmpty() == false) {
                popStack.add(dataStack.pop());
            }
        }
    }

    public E element() {
        convert();
        if (popStack.size() == 0)
            throw new NoSuchElementException("Null element");
        return popStack.peek();
    }

    public void add(E e) {
        if (dataStack.size() + popStack.size() >= capacity)
            throw new IllegalStateException("null free space");
        dataStack.add(e);
    }

    public E remove() {
        convert();
        if (popStack.size() == 0)
            throw new NoSuchElementException("Null element");
        else
            return popStack.pop();
    }

    public void offer(E e) {
        if (dataStack.size() + popStack.size() >= capacity)
            return;
        dataStack.add(e);
    }

    public E poll() {
        convert();
        if (popStack.size() == 0)
            return null;
        return popStack.pop();
    }

    public E peek() {
        convert();
        if (popStack.size() == 0)
            return null;
        return popStack.peek();
    }

    public int getSize() {
        return dataStack.size() + popStack.size();
    }

    public String toString() {
        Object[] pop = popStack.toArray();
        for (int i = 0; i < pop.length / 2; i++) {
            E temp = (E) pop[i];
            pop[i] = pop[pop.length - 1 - i];
            pop[pop.length - 1 - i] = temp;
        }
        Object[] da = new Object[pop.length + dataStack.size()];
        System.arraycopy(pop, 0, da, 0, pop.length);
        Iterator<E> iterator = dataStack.iterator();
        int index = pop.length;
        while (iterator.hasNext()) {
            da[index++] = iterator.next();
        }
        return Arrays.toString(da);


    }

}
