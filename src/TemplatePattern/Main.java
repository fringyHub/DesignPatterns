package TemplatePattern;

import java.util.Scanner;

abstract class Beverage {

    final void prepareBeverage() {
        addWater();
        addMaterial();
        pourToCup();
        if(customerWantsCondinents())
            addCondiments();
    }

    void addWater() { System.out.println("adding water"); }
    void pourToCup() { System.out.println("pouring beverage to Cup"); }


    boolean customerWantsCondinents() {
        return (new Scanner(System.in).next().toLowerCase().equals("y")) ? true : false;
    }

    abstract void addMaterial();
    abstract void addCondiments();
}

class Tea extends Beverage {
    public void addMaterial() { System.out.println("adding Tea powder"); }
    public void addCondiments() { System.out.println("adding lemon"); }
}

class Coffee extends Beverage {
    public void addMaterial() { System.out.println("adding coffee powder"); }
    public void addCondiments() { System.out.println("adding sugar & milk"); }
}


public class Main {
    public static void main(String args[]) {
        Beverage tea = new Tea();
        tea.prepareBeverage();

        Beverage coffee = new Coffee();
        coffee.prepareBeverage();
    }
}
