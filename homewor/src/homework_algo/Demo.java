package homework_algo;

import homework_algo.coffee_entity.*;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Demo {

    public static void main(String[] args) throws InterruptedException {
//        Coffee coffee = new Cappuccino();
//        coffee = new CaramelTopping(coffee);
//        System.out.printf("%s and total price = %d", coffee.showInfo(),coffee.getPrice());
//        System.out.println();
//        System.out.println(coffee.getType());
//        System.out.println();
//        Coffee coffee1 = new Americano();
//        coffee1 = new IceCreamTopping(coffee1);
//        System.out.println(coffee1.getType());
//        System.out.printf("%s and total price = %d", coffee1.showInfo(),coffee1.getPrice());
//        System.out.println();
//
        Visitor oleg = Visitor.newBuilder().
                age(30).sex("male").drinkSpeed(1).
                name("Oleg").
                money(200).
                preferedDrink(new CaramelTopping(new Cappuccino())).build();
        Visitor vasia = Visitor.newBuilder().
                age(32).sex("male").drinkSpeed(2).
                name("Vasia").
                money(250).
                preferedDrink(new CaramelTopping(new Americano())).build();

        ArrayList<Visitor> list = new ArrayList<>();
        list.add(oleg);
        Cafe cafe = new Cafe(list);
//        Cafe cafe = new Cafe(new ArrayList<>(List.of(oleg,vasia)));
        cafe.startService();

    }
}
