package homework_algo.coffee_entity;


public class IceCreamTopping extends ToppingDecorator {

    private Coffee coffee;
    private int price;

    private String type;

    public IceCreamTopping(final Coffee coffee) {
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
        return coffee.getType() + " with " + this.type;
    }

    @Override
    public int getCookingTime() {
        return coffee.getCookingTime() + 1;
    }

    @Override
    public int getDrinkingTime() {
        return coffee.getDrinkingTime() - 1;
    }

    @Override
    public int getAmountOfWater() {
        return coffee.getAmountOfWater() + 0;
    }

    @Override
    public int getBeans() {
        return coffee.getBeans() + 0;
    }

    @Override
    public int getAmountOfMilk() {
        return coffee.getAmountOfMilk() + 0;
    }
}
