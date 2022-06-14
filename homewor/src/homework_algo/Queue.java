package homework_algo;

import java.util.*;

public class Queue {

    private ArrayDeque<Visitor> queue = new ArrayDeque<>();

    void addVisitorToQueue(Visitor visitor) {
        queue.add(visitor);
    }

    Visitor nextVisitor() {
        if (!queue.isEmpty()) {
            return queue.peek();
        }
        return null;
    }

    int queueSize() {
        return queue.size();
    }

    void deleteVisitorFromQueue(Visitor visitor) {
        queue.remove(visitor);
    }
}
