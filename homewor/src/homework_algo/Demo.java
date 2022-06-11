package homework_algo;

import homework_algo.coffee_entity.*;

public class Demo {

    public static void main(String[] args) throws InterruptedException {
        Coffee coffee = new Cappuccino();
        coffee = new CaramelTopping(coffee);
        System.out.printf("%s and total price = %d", coffee.showInfo(),coffee.getPrice());
        System.out.println();
        System.out.println(coffee.getType());
        System.out.println();
        Coffee coffee1 = new Americano();
        coffee1 = new IceCreamTopping(coffee1);
        System.out.println(coffee1.getType());
        System.out.printf("%s and total price = %d", coffee1.showInfo(),coffee1.getPrice());
        System.out.println();

        Visitor visitor = Visitor.newBuilder().
                age(30).sex("male").drinkSpeed(10).
                name("Oleg").
                preferedDrink(new CaramelTopping(new Cappuccino())).build();
        System.out.println(visitor);
        int wait = (coffee.getCookingTime() + coffee.getDrinkingTime()) / visitor.getDrinkSpeed();
        System.out.println(visitor.getName() + " drinks " + coffee.getType() + " " + wait + " seconds");
        Thread.sleep(wait/visitor.getDrinkSpeed() * 10);
    }
}
