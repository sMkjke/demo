package homework_algo.coffee_entity;

public abstract class Coffee {

    String description = "Coffee";

    public abstract int getPrice();
    public String showIngredients(){
        return description;
    }
}
