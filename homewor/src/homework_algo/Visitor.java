package homework_algo;

import homework_algo.coffee_entity.Coffee;

public class Visitor implements Runnable {

    private String name;
    private String sex;
    private int age;
    private int drinkSpeed;
    private Coffee preferedDrink;
    private int money;
    private boolean isDrink;

    private Visitor(Builder builder) {
        name = builder.name;
        sex = builder.sex;
        age = builder.age;
        drinkSpeed = builder.drinkSpeed;
        preferedDrink = builder.preferedDrink;
        setMoney(builder.money);
        isDrink = builder.isDrink;
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
                ", preferedDrink=" + preferedDrink.getType() +
                ", money=" + money +
                '}';
    }

    public int getDrinkSpeed() {
        return drinkSpeed;
    }

    public String getName() {
        return name;
    }

    public Coffee getPreferedDrink() {
        return preferedDrink;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public boolean isDrink() {
        return isDrink;
    }

    public void setDrink(boolean drink) {
        isDrink = drink;
    }

    @Override
    public void run() {
        try {
            drinkCoffee();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    synchronized public void drinkCoffee() throws InterruptedException {
        System.out.println();
        System.out.printf("%s start drinking his coffee", this.name);
        this.isDrink = true;
        System.out.println();
        Thread.sleep(1000 * preferedDrink.getDrinkingTime() / this.getDrinkSpeed());
        System.out.println();
        System.out.printf("%s finished with coffee", this.name);
//        System.out.printf("%s is done with coffee and left the Cafe!", this.name);
        this.isDrink = false;
    }

    public static final class Builder {
        private String name;
        private String sex;
        private int age;
        private int drinkSpeed;
        private Coffee preferedDrink;
        private int money;
        private boolean isDrink;

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

        public Builder isDrink(boolean val) {
            isDrink = val;
            return this;
        }

        public Visitor build() {
            return new Visitor(this);
        }
    }


//
//    public static final class Builder {
//        private String name;
//        private String sex;
//        private int age;
//        private int drinkSpeed;
//        private Coffee preferedDrink;
//        private int money;
//
//        private Builder() {
//        }
//
//        public Builder name(String val) {
//            name = val;
//            return this;
//        }
//
//        public Builder sex(String val) {
//            sex = val;
//            return this;
//        }
//
//        public Builder age(int val) {
//            age = val;
//            return this;
//        }
//
//        public Builder drinkSpeed(int val) {
//            drinkSpeed = val;
//            return this;
//        }
//
//        public Builder preferedDrink(Coffee val) {
//            preferedDrink = val;
//            return this;
//        }
//
//        public Builder money(int val) {
//            money = val;
//            return this;
//        }
//
//        public Visitor build() {
//            return new Visitor(this);
//        }
//    }

}