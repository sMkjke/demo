package homework_algo.coffee_entity;

public class MarshmellowTopping extends ToppingDecorator {
    private Coffee coffee;
    private int price;

    private String type;

    public MarshmellowTopping(Coffee coffee) {
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
                coffee.getType() + this.type;
    }
    @Override
    public int getCookingTime() {
        return coffee.getCookingTime() + 30;
    }

    @Override
    public int getDrinkingTime() {
        return coffee.getDrinkingTime() + 20;
    }
}
