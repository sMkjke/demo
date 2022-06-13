package homework_algo;

import java.util.ArrayList;
import java.util.List;

public class VisitorsDrinkingCoffee {

    private List<Visitor> visitors;

    public VisitorsDrinkingCoffee() {
        this.visitors = new ArrayList<>();
    }

    public synchronized void add(Visitor visitor) {
        this.visitors.add(visitor);
    }

    public synchronized void remove(Visitor visitor) {
        this.visitors.remove(visitor);
    }

    public synchronized List<Visitor> list() {
        return new ArrayList<>(this.visitors);
    }

}
