package homework_algo.coffee_entity;

public class Cappuccino extends Coffee {

    private final String type;
    private final int amountOfWater;
    private final int price;
    private final int beans;
    private final int amountOfMilk;
    private final int cookingTime;
    private final int drinkingTime;

    public Cappuccino() {
        this.type = "Cappuccino";
        this.amountOfWater = 100;
        this.price = 150;
        this.beans = 4;
        this.amountOfMilk = 25;
        this.cookingTime = 2;
        this.drinkingTime = 20;
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

    @Override
    public int getAmountOfWater() {
        return this.amountOfWater;
    }

    @Override
    public int getBeans() {
        return this.beans;
    }

    @Override
    public int getAmountOfMilk() {
        return this.amountOfMilk;
    }

}
