package homework_algo.coffee_entity;


public class IceCreamTopping extends ToppingDecorator {

    private Coffee coffee;
    private String type;
    private int price;

    public IceCreamTopping(Coffee coffee) {
        this.coffee = coffee;
        this.price = 30;
    }

    @Override
    public int getPrice() {
        return coffee.getPrice() + this.price;
    }

    @Override
    public String showIngredients() {
        return coffee.showIngredients() + " " + "plus IceCream topping " + this.price;
    }
}
