//package homework_algo;
//
//import homework_algo.coffee_entity.*;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Random;
//
//
//public class Demo {
//
//    public static void main(String[] args) {
//        try {
//            start();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    static void start() throws InterruptedException {
//        ArrayList<Visitor> list = new ArrayList<>(List.of(Visitor.newBuilder().
//                        age(30).sex("male").drinkSpeed(2).
//                        name("Oleg").
//                        money(200).
//                        preferedDrink(new CaramelTopping(new Cappuccino())).build(),
//                Visitor.newBuilder().
//                        age(32).sex("male").drinkSpeed(5).
//                        name("Vasia").
//                        money(250).
//                        preferedDrink(new CaramelTopping(new Americano())).build(),
//                Visitor.newBuilder().
//                        age(15).sex("male").drinkSpeed(1).
//                        name("Alex").
//                        money(100).
//                        preferedDrink(new MarshmellowTopping(new Latte())).build(),
//                Visitor.newBuilder().
//                        age(30).sex("male").drinkSpeed(1).
//                        name("Andrey").
//                        money(300).
//                        preferedDrink(new IceCreamTopping(new Americano())).build(),
//                Visitor.newBuilder().
//                        age(30).sex("female").drinkSpeed(5).
//                        name("Masha").
//                        money(300).
//                        preferedDrink(new IceCreamTopping(new Latte())).build(),
//                Visitor.newBuilder().
//                        age(33).sex("male").drinkSpeed(5).
//                        name("Misha").
//                        money(300).
//                        preferedDrink(new MarshmellowTopping(new Latte())).build()));
//
//        Cafe cafe = new Cafe();
//        cafe.greeting();
//        Random random = new Random();
//
//        while (list.size() > 0) {
//            Visitor visitor = list.get(random.nextInt(list.size()));
//            list.remove(visitor);
//            cafe.startService(visitor);
//            Thread.sleep(1000);
//        }
//        System.out.println("Quque of visitors is EMPTY!");
//    }
//}
//
