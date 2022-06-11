package homework_algo.coffee_entity;

public class CaramelTopping extends ToppingDecorator {

    private Coffee coffee;
    private int price;
    private String type;

    public CaramelTopping(Coffee coffee) {
        this.coffee = coffee;
        this.price = 30;
        this.type = "Caramel";
    }

    @Override
    public int getPrice() {
        return coffee.getPrice() + this.price;
    }

    public String getType() {
        return coffee.getType() + type;
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
    public String showInfo() {
        return coffee.showInfo() + " " + "plus Caramel topping " + this.price;
    }

}
