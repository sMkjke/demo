package homework_algo.coffee_entity;

public class CaramelTopping extends ToppingDecorator {

    private Coffee coffee;
    private int price;

    public CaramelTopping(Coffee coffee) {
        this.coffee = coffee;
        this.price = 30;
    }

    @Override
    public int getPrice() {
        return coffee.getPrice() + this.price;
    }

    @Override
    public String showIngredients() {
        return coffee.showIngredients() + " " + "plus Caramel topping " + this.price;
    }

}
