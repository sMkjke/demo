package homework_algo;

public class CaramelTopping implements Additable {

    private final String name;
    private final int price;

    public CaramelTopping(String name, int price) {
        this.name = "Caramel";
        this.price = 10;
    }
//
//    private void getInfo() {
//        System.out.printf("It's %s topping and price %d", getName(), getPrice());
//    }


    @Override
    public int getPrice() {
        return this.price;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
