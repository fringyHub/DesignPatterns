package StrategyPattern;

interface FlyBehaviour {
    public void fly();
}

class FlyWithWings implements FlyBehaviour {
    @Override
    public void fly() { System.out.println("i am flying !!"); }
}

class FlyNoWay implements FlyBehaviour {
    @Override
    public void fly() { System.out.println("i cant fly"); }
}



interface QuackBehaviour {
    public void quack();
}

class QuackFully implements  QuackBehaviour {
    @Override
    public void quack() { System.out.println("quacking duck!"); }
}

class Squeak implements QuackBehaviour {
    @Override
    public void quack() { System.out.println("i am squeaking !!"); }
}

class NoSound implements QuackBehaviour {
    @Override
    public void quack() { System.out.println("i am dumb"); }
}


abstract class Duck {
    FlyBehaviour flyBehaviour;
    QuackBehaviour quackBehaviour;

    public void performFly() { flyBehaviour.fly(); }
    public void performQuack() { quackBehaviour.quack(); }
    public void display() { System.out.println("generic display action"); }

    public void setQuackBehaviour(QuackBehaviour qb) {
        quackBehaviour = qb;
    }
}

class MallardDuck extends Duck {

    public MallardDuck() {
        flyBehaviour = new FlyWithWings();
        quackBehaviour = new QuackFully();
    }

    public void display() { System.out.println("modified looks for mallard duck"); }
}

class RubberDuck extends Duck {

    public RubberDuck() {
        flyBehaviour = new FlyNoWay();
        quackBehaviour = new Squeak();
    }
}

public class Main {

    public static void main(String[] args) {
        Duck mallardDuck = new MallardDuck();
        mallardDuck.performQuack();
        mallardDuck.performFly();

        Duck rubberDuck = new RubberDuck();
        rubberDuck.performQuack();
        rubberDuck.setQuackBehaviour(new NoSound());
        rubberDuck.performQuack();
        rubberDuck.performFly();
    }
}
