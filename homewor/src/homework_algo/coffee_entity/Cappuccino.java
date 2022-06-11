package homework_algo.coffee_entity;

public class Cappuccino extends Coffee {

    private String type;
    private int amountOfWater;
    private int price;
    private int beans;
    private int amountOfMilk;
    private int cookingTime;
    private int drinkingTime;

    public Cappuccino() {
        type = "Cappuccino";
        this.amountOfWater = 100;
        this.price = 150;
        this.beans = 4;
        this.amountOfMilk = 25;
        this.cookingTime = 7;
        this.drinkingTime = 12;
    }

    @Override
    public int getPrice() {
        return this.price;
    }

    @Override
    public String showInfo() {
        return String.format("It's %s coffee (%d Water, %d Beans, %d Milk) and price for it: %d",
                this.type,
                this.amountOfWater,
                this.beans,
                this.amountOfMilk,
                this.price);
    }

    @Override
    public String getType() {
        return this.type;
    }
    public int getCookingTime() {
        return cookingTime;
    }

    public int getDrinkingTime() {
        return drinkingTime;
    }
}
