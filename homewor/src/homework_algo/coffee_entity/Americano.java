package homework_algo.coffee_entity;

public class Americano extends Coffee {

    private String type;
    private int amountOfWater;
    private int price;
    private int beans;
    private int cookingTime;
    private int drinkingTime;

    public Americano() {
        type = "Americano";
        this.amountOfWater = 100;
        this.price = 100;
        this.beans = 6;
        this.cookingTime = 2;
        this.drinkingTime = 10;
    }

    @Override
    public int getPrice() {
        return this.price;
    }

    @Override
    public String showInfo() {
        return String.format("It's %s coffee (%d Water, %d Beans) and price for it: %d",
                this.type,
                this.amountOfWater,
                this.beans,
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
        return 0;
    }


}

