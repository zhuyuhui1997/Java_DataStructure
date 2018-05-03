package pack1;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.Random;

import static org.junit.Assert.*;

public class TwoStackQueueTest {
    private  TwoStackQueue<Integer> twoStackQueue;
    private Random random;
    @Before
    public void init() {
        twoStackQueue = new TwoStackQueue<>(10);
        random = new Random(System.nanoTime());
        addThreeEle();
        System.out.println("init success");
    }
    @Test
    public void test() {
        System.out.println(twoStackQueue);
        System.out.println("size is: " + twoStackQueue.getSize());
        System.out.println(twoStackQueue.peek());
        System.out.println(twoStackQueue.poll());
        addThreeEle();
        System.out.println(twoStackQueue);
        System.out.println(twoStackQueue.peek());
        System.out.println(twoStackQueue.poll());
        addThreeEle();
        addThreeEle();
        addThreeEle();
        twoStackQueue.offer(4);
        System.out.println(twoStackQueue);
        while (twoStackQueue.getSize() != 0) {
            System.out.println(twoStackQueue.poll());
        }
    }
    @Test
    public void test2() {
        System.out.println(twoStackQueue);
        addJuti();
        System.out.println(twoStackQueue);
        while (twoStackQueue.getSize() != 0) {
            System.out.println(twoStackQueue.poll());
        }

    }
    public void addThreeEle() {
        try {
            twoStackQueue.add(random.nextInt(10));
            twoStackQueue.add(random.nextInt(10));
            twoStackQueue.add(random.nextInt(10));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void addJuti() {
        twoStackQueue.offer(1);
        twoStackQueue.offer(2);
        twoStackQueue.offer(3);
        twoStackQueue.offer(4);
        twoStackQueue.offer(5);
    }
}