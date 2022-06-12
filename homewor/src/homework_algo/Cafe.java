package homework_algo;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Cafe {

    final private Kitchen kitchen;
    final private Queue queue;
    private ArrayList<Visitor> visitorsDrinkingCoffee = new ArrayList<>();


    public Cafe() {
        this.kitchen = new Kitchen();
        this.queue = new Queue();
    }

    public void startService(ArrayList<Visitor> list) throws InterruptedException {
        final ExecutorService executor = Executors.newFixedThreadPool(4);
        queue.addVisitorsToQueue(list);
        boolean isWorks;
        while (queue.queueSize() > 0) {
            Visitor currentVisitor = queue.nextVisitor();
            if (isEnoughMoney(currentVisitor, currentVisitor.getPreferedDrink().getPrice())) {
                isWorks = kitchen.giveCoffee(currentVisitor);
                queue.deleteVisitorFromQueue(currentVisitor);
                if (isWorks) {
                    visitorsDrinkingCoffee.add(currentVisitor);
                    executor.submit(currentVisitor);
                }
            }
            queue.deleteVisitorFromQueue(currentVisitor);
            //TODO допили кофе - убрать из arraylist
            if (!currentVisitor.isDrink()) {
                System.out.println();
                System.out.printf("%s has left from Cafe.", currentVisitor.getName());
                System.out.println();
            }

//            currentVisitor = queue.nextVisitor();
//            if (isWorks) {
//                visitorsDrinkingCoffee.add(currentVisitor);
//                executor.submit(currentVisitor);
//            }
//                if (!currentVisitor.isDrink() && !visitorsDrinkingCoffee.isEmpty()) {
//                    visitorsDrinkingCoffee.remove(currentVisitor);
//                    System.out.printf("%s is done with coffee and left the Cafe!", currentVisitor.getName());
//                    System.out.println(visitorsDrinkingCoffee.toString());
//                }

        }
        if (queue.queueSize() == 0)
            System.out.println("The queue of visitors is empty");
    }

    private boolean isEnoughMoney(Visitor visitor, int coffeeCost) {
        if (visitor.getMoney() >= coffeeCost) {
            return true;
        }
        System.out.printf("%s dont have enough money, he wants %s(price is: %d rubles) but he has only %d rubles.He left the Cafe!",
                visitor.getName(), visitor.getPreferedDrink().getType(), visitor.getPreferedDrink().getPrice(), visitor.getMoney());
        System.out.println();
        return false;
    }
}
