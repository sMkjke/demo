package homework_algo;

public class ToppingDecorator implements Additable{

        private Additable additable;
        private String name;
        private int price;

        public ToppingDecorator(Additable additable, String name, int price) {
            this.additable = additable;
            this.name = name;
            this.price = price;
        }


    @Override
    public int getPrice() {
        return this.price + additable.getPrice();
    }

    @Override
    public String getName() {
        return this.name + additable    .getName();
    }
}

