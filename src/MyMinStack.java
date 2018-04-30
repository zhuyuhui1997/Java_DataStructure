import org.junit.Test;

import java.util.Stack;


public class MyMinStack {
    private Stack<Integer> data = new Stack<>(); //数据栈
    /*

    最小值辅助栈  大小与数据栈同步,每一个数据进入数据栈,就会将最小值压到辅助栈(栈顶)
    结果就是 任何一个数据栈 状态对应一个 最小值
    每一个数据出栈,数据栈发生改变,help栈也会出一个数据,
    从而栈顶对应数据栈最小值
    */
    private Stack<Integer> help = new Stack<>();
    public void add(Integer value) {
        data.add(value);
        if (help.isEmpty() == true) {
            help.add(value);
        }
        else {
            if (value < help.peek())
                help.add(value);
            else
                help.add(help.peek());
        }
    }
    public int peekMin() {
        return help.peek();
    }
    public int pop() {
        help.pop();
        return data.pop();
    }
    public int peek() {
        return data.peek();
    }
    public String toString() {

        return data.toString() + "\nStack Min Value is: " + help.peek();
    }
    @Test
    public void test() {
        MyMinStack myMinStack = new MyMinStack();
        myMinStack.add(4);
        myMinStack.add(7);
        myMinStack.add(11);
        myMinStack.add(3);
        System.out.println("栈最小值是: " + myMinStack.peekMin());
        myMinStack.add(1);
        myMinStack.add(11);
        System.out.println("栈最小值是: " + myMinStack.peekMin());
        myMinStack.pop();
        myMinStack.pop();
        System.out.println("栈最小值是: " + myMinStack.peekMin());
        System.out.println(myMinStack);
    }

}
