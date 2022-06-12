package homework_algo;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Cafe {

    private Kitchen kitchen;
    private Queue queue;
//    private ArrayList<Visitor> visitorsInsideCafe = new ArrayList<>();


    public Cafe(ArrayList<Visitor> queue) {
        this.kitchen = new Kitchen();
//        this.visitorsInsideCafe = visitorsInsideCafe;

        this.queue = new Queue(queue);
    }

    public void startService() throws InterruptedException {
//        queue.addVisitorsToQueue(visitorsInsideCafe);
        Visitor currentVisitor = queue.nextZVizitorFromQueue();
        kitchen.giveCoffee(currentVisitor);
    }
}
