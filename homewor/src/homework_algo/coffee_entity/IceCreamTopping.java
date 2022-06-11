package homework_algo.coffee_entity;

import homework_algo.Additable;

public class IceCreamTopping implements Additable {

    private final String name;
    private final int price;

    public IceCreamTopping(String name, int price) {
        this.name = "Ice Cream";
        this.price = 15;
    }

    @Override
    public int getPrice() {
        return this.price;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
