package pack1;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class TwoQueueStackTest {
    private TwoQueueStack<Integer> twoQueueStack;
    private Random random = new Random(System.nanoTime());

    @Before
    public void init() {
        twoQueueStack = new TwoQueueStack<>(10);
        random = new Random();
        addThreeEle();
        System.out.println("init success");
    }

    @Test
    public void test() {
        System.out.println(twoQueueStack);
        assertEquals(twoQueueStack.size(), 3);
        assertFalse(twoQueueStack.isEmpty());
        System.out.println(twoQueueStack.pop());
        System.out.println(twoQueueStack.pop());
        addThreeEle();
        System.out.println(twoQueueStack);
        System.out.println(twoQueueStack.pop());
        assertFalse(twoQueueStack.isEmpty());
        addThreeEle();
        addThreeEle();
        addThreeEle();
        System.out.println(twoQueueStack);
        System.out.println(twoQueueStack.pop());
        System.out.println(twoQueueStack.pop());
    }
    public void addThreeEle() {
        try {
            twoQueueStack.push(random.nextInt(10));
            twoQueueStack.push(random.nextInt(10));
            twoQueueStack.push(random.nextInt(10));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}