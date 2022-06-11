package homework_algo;

public class Visitor {

    private String name;
    private String sex;
    private int age;
    private int drinkSpeed;
    private Coffee preferedCoffee;
    private int money;
    private Topping preferedTopping;

    private Visitor(Builder builder) {
        name = builder.name;
        sex = builder.sex;
        age = builder.age;
        drinkSpeed = builder.drinkSpeed;
        preferedCoffee = builder.preferedCoffee;
        money = builder.money;
        preferedTopping = builder.preferedTopping;
    }

    public static Builder newBuilder() {
        return new Builder();
    }


    public static final class Builder {
        private String name;
        private String sex;
        private int age;
        private int drinkSpeed;
        private Coffee preferedCoffee;
        private int money;
        private Topping preferedTopping;

        private Builder() {
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder sex(String val) {
            sex = val;
            return this;
        }

        public Builder age(int val) {
            age = val;
            return this;
        }

        public Builder drinkSpeed(int val) {
            drinkSpeed = val;
            return this;
        }

        public Builder preferedCoffee(Coffee val) {
            preferedCoffee = val;
            return this;
        }

        public Builder money(int val) {
            money = val;
            return this;
        }

        public Builder preferedTopping(Topping val) {
            preferedTopping = val;
            return this;
        }

        public Visitor build() {
            return new Visitor(this);
        }
    }
}
