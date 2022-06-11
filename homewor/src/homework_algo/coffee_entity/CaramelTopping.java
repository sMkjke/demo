package homework_algo.coffee_entity;

import homework_algo.Additable;

public class CaramelTopping extends Coffee {

    private Coffee coffee;
    private String type;
    private int price;

    public CaramelTopping(Coffee coffee, String type, int price) {
        this.coffee = coffee;
        this.type = "Caramel";
        this.price = 30;
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public int getPrice() {
        return this.price;
    }

    @Override
    public String showIngredients() {
        return coffee.showIngredients() + getType() + " topping";
    }

//
//    private void getInfo() {
//        System.out.printf("It's %s topping and price %d", getName(), getPrice());
//    }

}
