package homework_algo.coffee_entity;

public class Latte extends Coffee {
    private String type;
    private int amountOfWater;
    private int price;
    private int beans;
    private int amountOfMilk;
    private int cookingTime;
    private int drinkingTime;

    public Latte() {
        type = "Latte";
        this.amountOfWater = 100;
        this.price = 170;
        this.beans = 3;
        this.amountOfMilk = 40;
        this.cookingTime = 10;
        this.drinkingTime = 9;
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

