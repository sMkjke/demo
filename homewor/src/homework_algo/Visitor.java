package homework_algo;

import homework_algo.coffee_entity.Coffee;

public class Visitor {

    private String name;
    private String sex;
    private int age;
    private int drinkSpeed;
    private Coffee preferedDrink;
    private int money;

    private Visitor(Builder builder) {
        name = builder.name;
        sex = builder.sex;
        age = builder.age;
        drinkSpeed = builder.drinkSpeed;
        preferedDrink = builder.preferedDrink;
        money = builder.money;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "Visitor{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", drinkSpeed=" + drinkSpeed +
                ", preferedDrink=" + preferedDrink +
                ", money=" + money +
                '}';
    }

    public int getDrinkSpeed() {
        return drinkSpeed;
    }

    public String getName() {
        return name;
    }

    public static final class Builder {
        private String name;
        private String sex;
        private int age;
        private int drinkSpeed;
        private Coffee preferedDrink;
        private int money;

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

        public Builder preferedDrink(Coffee val) {
            preferedDrink = val;
            return this;
        }

        public Builder money(int val) {
            money = val;
            return this;
        }

        public Visitor build() {
            return new Visitor(this);
        }
    }

}