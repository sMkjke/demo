package homework_algo.coffee_entity;


public class IceCreamTopping extends ToppingDecorator {

    private Coffee coffee;
    private int price;

    private String type;

    public IceCreamTopping(Coffee coffee) {
        this.coffee = coffee;
        this.price = 30;
        this.type = "IceCream";
    }

    @Override
    public int getPrice() {
        return coffee.getPrice() + this.price;
    }

    @Override
    public String showInfo() {
        return coffee.showInfo() + " " + "plus IceCream topping " + this.price;
    }

    @Override
    public String getType() {
        return coffee.getType() + this.type;
    }

    @Override
    public int getCookingTime() {
        return coffee.getCookingTime() + 10;
    }

    @Override
    public int getDrinkingTime() {
        return coffee.getDrinkingTime() - 10;
    }
}
