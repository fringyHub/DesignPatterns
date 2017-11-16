package DecoratorPattern;


abstract class Pizza {
    public String description = "Plain Pizza";

    public String getDescription() { return description; }
    public abstract double getCost();
}

abstract class ToppingDecorator extends Pizza { }
abstract class SizeDecorator extends Pizza { }

class FarmFreshPizza extends Pizza {
    public FarmFreshPizza() { description = "FarmFresh Veg Pizza"; }
    public double getCost() { return 299; }
}

class BarbequeChickenPizza extends Pizza {
    public BarbequeChickenPizza() { description = "Barbeque Chicken NonVeg Pizza"; }
    public double getCost() { return 399; }
}

class CheeseBurst extends ToppingDecorator {
    Pizza pizza;

    public CheeseBurst(Pizza pizza) { this.pizza = pizza; }
    public String getDescription() { return pizza.getDescription() + " with CheeseBurst"; }
    public double getCost() { return pizza.getCost() + 149; }
}

class ExtraChicken extends ToppingDecorator {
    Pizza pizza;

    public ExtraChicken(Pizza pizza) { this.pizza = pizza; }
    public String getDescription() { return pizza.getDescription() + " with extra chicken"; }
    public double getCost() { return pizza.getCost() + 99; }
}


class DoubleSize extends SizeDecorator {
    Pizza pizza;

    public DoubleSize(Pizza pizza) { this.pizza = pizza; }
    public String getDescription() { return pizza.getDescription() + " Big pizza"; }
    public double getCost() { return pizza.getCost() * 2; }
}


public class Main {

    static void printBill(Pizza pizza) {
        System.out.println( pizza.getDescription() + " => " +
            pizza.getCost());
    }

    public static void main(String args[]) {
        Pizza farmFreshPizza = new FarmFreshPizza();
        printBill(farmFreshPizza);

        Pizza chickenPizza = new BarbequeChickenPizza();
        chickenPizza = new ExtraChicken(chickenPizza);
        printBill(chickenPizza);

        Pizza maxChickenPizza = new BarbequeChickenPizza();
        maxChickenPizza = new DoubleSize(new ExtraChicken(new CheeseBurst(maxChickenPizza)));
        printBill(maxChickenPizza);
    }

}
