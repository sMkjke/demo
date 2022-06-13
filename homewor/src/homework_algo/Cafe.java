package homework_algo;

import homework_algo.coffee_entity.Coffee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Cafe {

    final private Kitchen kitchen;
    final private Queue queue;
    private List<Visitor> visitorsDrinkingCoffee = Collections.synchronizedList(new ArrayList<>());


    public Cafe() {
        this.kitchen = new Kitchen();
        this.queue = new Queue();
    }

    public void startService(final ArrayList<Visitor> list) throws InterruptedException {
        queue.addVisitorsToQueue(list);

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
        visitor.setDrink(true);
        visitor.setChosenCoffee(coffee);
        executor.submit(visitor);
        visitorsDrinkingCoffee.removeIf(i -> !i.isDrink());
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

    public List<Visitor> getVisitorsDrinkingCoffee() {
        return visitorsDrinkingCoffee;
    }
}
