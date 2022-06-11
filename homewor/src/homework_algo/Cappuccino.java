package homework_algo;

public class Cappuccino extends Coffee {

    private String type;
    private int amountOfWater;
    private int price;
    private int beans;
    private int amountOfMilk;

    public Cappuccino() {
        this.type = "Cappuccino";
        this.amountOfWater = 100;
        this.price = 150;
        this.beans = 4;
        this.amountOfMilk = 25;
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
    public void showIngredients() {
        System.out.printf("It's %s coffee (%n Water, %n Beans, %n Milk) and price for it: %n",
                this.type,
                this.amountOfMilk,
                this.beans,
                this.amountOfMilk,
                this.price);
    }
}
