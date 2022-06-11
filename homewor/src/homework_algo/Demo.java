package homework_algo;

import homework_algo.coffee_entity.*;

public class Demo {

    public static void main(String[] args) {
        Coffee coffee = new Cappuccino();
        coffee = new CaramelTopping(coffee);
        coffee = new IceCreamTopping(coffee);
        System.out.printf("%s and total price = %d", coffee.showInfo(),coffee.getPrice());
        System.out.println();
        Coffee coffee1 = new Americano();
        coffee1 = new IceCreamTopping(coffee1);
        System.out.printf("%s and total price = %d", coffee1.showInfo(),coffee1.getPrice());
        System.out.println();
    }
}
