package homework_algo;

public abstract class Coffee {

    private String type;
    private int amountOfWater;
    private int price;
    private int beans;

    public abstract String getType();
    public abstract int getPrice();
    public abstract void showIngredients();
}
