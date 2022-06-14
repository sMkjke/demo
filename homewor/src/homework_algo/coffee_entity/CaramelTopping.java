package homework_algo.coffee_entity;

public class CaramelTopping extends ToppingDecorator {

    private final Coffee coffee;
    private final int price;
    private final String type;

    public CaramelTopping(final Coffee coffee) {
        this.coffee = coffee;
        this.price = 30;
        this.type = "Caramel";
    }

    @Override
    public int getPrice() {
        return coffee.getPrice() + this.price;
    }

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

    @Override
    public String showInfo() {
        return coffee.showInfo() + " " + "plus Caramel topping " + this.price;
    }

}
