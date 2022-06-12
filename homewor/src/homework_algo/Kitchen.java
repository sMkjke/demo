package homework_algo;

import homework_algo.coffee_entity.Coffee;

public class Kitchen {

    private int beans;
    private int water;
    private int milk;

    public Kitchen() {
        this.beans = 18;
        this.water = 700;
        this.milk = 300;
    }

    public boolean giveCoffee(Visitor visitor) throws InterruptedException {
        Coffee chosenCoffee = visitor.getPreferedDrink();
        System.out.printf("%s try to order some coffee.",visitor.getName());
        System.out.println();
        if (isEnoughIngredients(chosenCoffee)) {
            beans = this.beans - chosenCoffee.getBeans();
            water = this.water - chosenCoffee.getAmountOfWater();
            milk = this.milk - chosenCoffee.getAmountOfMilk();
            visitor.setMoney(visitor.getMoney() - chosenCoffee.getPrice());
            System.out.printf("%s likes %s and ordered it.", visitor.getName(), chosenCoffee.getType());
            System.out.println();
            System.out.println(chosenCoffee.showInfo());
            System.out.printf("%s spent %d rubles.", visitor.getName(), chosenCoffee.getPrice());
            System.out.printf("%s has %d rubles left.", visitor.getName(), visitor.getMoney());
            System.out.println();
            System.out.println("Making delicious coffee!!!!");
            System.out.printf("Wait %d seconds please.", chosenCoffee.getCookingTime());
            System.out.println();
            Thread.sleep(1000 * chosenCoffee.getCookingTime());
            System.out.println();
            System.out.printf("%s enjoy ur coffee.", visitor.getName());
            System.out.println();
            return true;
        }
        return false;
    }

    private boolean isEnoughIngredients(Coffee chosenCoffee) {
        if (this.beans >= chosenCoffee.getBeans() &&
                this.water >= chosenCoffee.getAmountOfWater() &&
                this.milk >= chosenCoffee.getAmountOfMilk()) {
            return true;
        }
        System.out.println("Kitchen havent enough ingredients!! Choose another coffee or call an admin");
        return false;
    }
}
