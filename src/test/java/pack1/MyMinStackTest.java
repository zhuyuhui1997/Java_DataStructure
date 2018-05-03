package pack1;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class MyMinStackTest {
    private MyMinStack myMinStack;
    private Random random;
    @Before
    public void init() {
        myMinStack = new MyMinStack();
        random = new Random(System.nanoTime());
        for (int i = 0; i < 6; i++) {
            myMinStack.add(random.nextInt(6) + 1);
        }
        System.out.println("init success");
    }
    @Test
    public void test() {
        System.out.println(myMinStack);
        System.out.println("栈最小值是: " + myMinStack.peekMin());
        addThreeEle();
        System.out.println(myMinStack);
        System.out.println("栈最小值是: " + myMinStack.peekMin());
        myMinStack.pop();
        myMinStack.pop();
        System.out.println("栈最小值是: " + myMinStack.peekMin());
        System.out.println(myMinStack);
    }
    public void addThreeEle() {
        myMinStack.add(random.nextInt(6) + 1);
        myMinStack.add(random.nextInt(6) + 1);
        myMinStack.add(random.nextInt(6) + 1);
    }

    @Test
    public void hello() {
        System.out.println(myMinStack);
        System.out.println("hello world");
    }
}