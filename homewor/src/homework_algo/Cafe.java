package homework_algo;

import homework_algo.coffee_entity.Coffee;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Cafe {

    final private Kitchen kitchen;
    final private Queue queue;
    private VisitorsDrinkingCoffee visitorsDrinkingCoffee;


    public Cafe() {
        this.kitchen = new Kitchen();
        this.queue = new Queue();
        this.visitorsDrinkingCoffee = new VisitorsDrinkingCoffee();
    }

    /**
     * Start service.
     * Manage the cafe - if we have some people in Queue - we should serve them.
     * And checks kitchen is enough ingredients and is visitor has enough money to buy coffee.
     * Give coffee to visitor based of his choise and after delete from Queue
     * and add to visitors whos drinking coffee (VisitorsDrinkingCoffee).
     *
     * @param list the list (used by class Queue(realised by ArrayDeque))
     * @throws InterruptedException the interrupted exception because Visitors uses concurrency
     */
    public void startService(final ArrayList<Visitor> list) throws InterruptedException {
        queue.addVisitorsToQueue(list);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("CAFE GRUSTNO AND VKUSNO OPENED!");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        while (queue.queueSize() > 0) {
            Visitor currentVisitor = queue.nextVisitor();
            System.out.println();
            System.out.printf("%s wants to order his/her favourite coffee %s",
                    currentVisitor.getName(), currentVisitor.getPreferedDrink().getType());
            System.out.println();
            if (isEnoughMoney(currentVisitor, currentVisitor.getPreferedDrink().getPrice())) {
                if (kitchen.isEnoughIngredients(currentVisitor.getPreferedDrink())) {
                    Coffee chosenCoffee = kitchen.giveCoffee(currentVisitor);
                    startDrinking(currentVisitor, chosenCoffee);
                }
            }
            queue.deleteVisitorFromQueue(currentVisitor);
        }
        if (queue.queueSize() == 0)
            System.out.println("The queue of visitors is empty");
    }

    private void startDrinking(final Visitor visitor, final Coffee coffee) throws InterruptedException {
        final ExecutorService executor = Executors.newFixedThreadPool(4);
        visitorsDrinkingCoffee.add(visitor);
        visitor.setChosenCoffee(coffee);
        executor.submit(visitor);
        if (!visitor.isDrink()) {
            visitorsDrinkingCoffee.remove(visitor);
        }
    }

    private boolean isEnoughMoney(final Visitor visitor, final int coffeeCost) {
        if (visitor.getMoney() >= coffeeCost) {
            return true;
        }
        System.out.printf("%s dont have enough money, he wants %s(price is: %d rubles) but he has only %d rubles.He left the Cafe!",
                visitor.getName(), visitor.getPreferedDrink().getType(), visitor.getPreferedDrink().getPrice(), visitor.getMoney());
        System.out.println();
        return false;
    }

    public VisitorsDrinkingCoffee getVisitorsDrinkingCoffee() {
        return visitorsDrinkingCoffee;
    }
}
