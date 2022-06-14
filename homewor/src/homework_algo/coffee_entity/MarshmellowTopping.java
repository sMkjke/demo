package homework_algo.coffee_entity;

public class MarshmellowTopping extends ToppingDecorator {
    private final Coffee coffee;
    private final int price;
    private final String type;

    public MarshmellowTopping(final Coffee coffee) {
        this.coffee = coffee;
        this.price = 100;
        this.type = "Marshmellow";
    }

    @Override
    public int getPrice() {
        return coffee.getPrice() + this.price;
    }

    @Override
    public String showInfo() {
        return coffee.showInfo() + " " + "plus Marshmellow topping " + this.price;
    }

    @Override
    public String getType() {
        return
                coffee.getType() + " with " + this.type;
    }

    @Override
    public int getCookingTime() {
        return coffee.getCookingTime() + 2;
    }

    @Override
    public int getDrinkingTime() {
        return coffee.getDrinkingTime() + 5;
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
