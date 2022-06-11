package homework_algo.coffee_entity;

public class MarshmellowTopping extends ToppingDecorator {
    private Coffee coffee;
    private int price;

    public MarshmellowTopping(Coffee coffee) {
        this.coffee = coffee;
        this.price = 100;
    }

    @Override
    public int getPrice() {
        return coffee.getPrice() + this.price;
    }

    @Override
    public String showInfo() {
        return coffee.showInfo() + " " + "plus Marshmellow topping " + this.price;
    }
}
