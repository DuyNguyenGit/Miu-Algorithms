package Labs.Lab1;

import java.util.LinkedList;
import java.util.Queue;

public class MyStackWithOnlyOneQueue {
    final Queue<Integer> queue;
    public MyStackWithOnlyOneQueue() {
        queue = new LinkedList<>();
    }
    public void push(int x) {
        queue.offer(x);
        int iterator = queue.size();
        while (iterator > 1) {
            queue.offer(queue.poll());
            iterator--;
        }

    }
    public int pop() {
        return queue.poll();
    }
    public int top() {
        return queue.peek();
    }
    public boolean empty() {
        return queue.isEmpty();
    }
}
