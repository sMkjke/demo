package homework_algo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Queue {

    private PriorityQueue queue = new PriorityQueue();

    public Queue(ArrayList queue) {
        queue.addAll(queue);
    }

//    public void addVisitorsToQueue(List<Visitor> visitorList) {
//        queue.addAll(visitorList);
//    }

    public Visitor nextZVizitorFromQueue() {
        if (!queue.isEmpty()) {

            return (Visitor) queue.peek();
        } else {
            System.out.println("The queue of visitors is empty");
        }
        return null;
    }
}
