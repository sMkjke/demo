package homework_algo.coffee_entity;

public abstract class Coffee {

    String description = "Coffee";

    public abstract int getPrice();
    public String showInfo(){
        return description;
    }
    public abstract String getType();
    public abstract int getCookingTime();
    public abstract int getDrinkingTime();

}
