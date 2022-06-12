package homework_algo;

import homework_algo.coffee_entity.*;
import java.util.ArrayList;
import java.util.List;


public class Demo {

    public static void main(String[] args) throws InterruptedException {
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

        Visitor alex = Visitor.newBuilder().
                age(15).sex("male").drinkSpeed(1).
                name("Alex").
                money(300).
                preferedDrink(new MarshmellowTopping(new Latte())).build();
        Visitor kolya = Visitor.newBuilder().
                age(72).sex("male").drinkSpeed(2).
                name("Kolya").
                money( 80).
                preferedDrink(new Americano()).build();

        Visitor andrey = Visitor.newBuilder().
                age(30).sex("male").drinkSpeed(1).
                name("Andrey").
                money( 300).
                preferedDrink(new IceCreamTopping(new Americano())).build();
        Visitor masha = Visitor.newBuilder().
                age(30).sex("female").drinkSpeed(3).
                name("Masha").
                money( 300).
                preferedDrink(new IceCreamTopping(new Latte())).build();

        ArrayList<Visitor> list = new ArrayList<>(List.of(alex,oleg,vasia,kolya,masha,andrey));

        Cafe cafe = new Cafe();
        cafe.startService(list);
    }
}
