package homework_algo;

import java.util.*;

public class Queue {

    private ArrayDeque<Visitor> queue = new ArrayDeque<>();

    public void addVisitorsToQueue(ArrayList<Visitor> list) {
        queue.addAll(list);
    }

    public Visitor nextVisitor() {
        if (!queue.isEmpty()) {
            return queue.peek();
        }
        return null;
    }

    public int queueSize(){
        return queue.size();
    }

    public void deleteVisitorFromQueue(Visitor visitor){
        queue.remove(visitor);
    }
}
