package AdapterPattern;

interface Duck {
    void quack();
    void fly();
}

class MallardDuck implements Duck {
    public void quack() { System.out.println("Mallard Duck is quacking"); }
    public void fly() { System.out.println("Mallard Duck is flying"); }
}

interface Turkey {
    void gobble();
    void fly();
}

class RandomTurkey implements  Turkey {
    public void gobble() { System.out.println("Random Turkey is gobbling"); }
    public void fly() { System.out.println("Random Turkey is flyihn"); }
}

class TurkeyAdapter implements Duck {
    Turkey turkey;
    public TurkeyAdapter(Turkey turkey) { this.turkey = turkey; }

    public void quack() { turkey.gobble();}
    public void fly() { turkey.fly(); }
}


public class Main {
    static void callMethods(Duck duck) {
        duck.quack();
        duck.fly();
    }

    public static void main(String args[]) {
        Duck duck = new MallardDuck();
        callMethods(duck);

        Turkey turkey = new RandomTurkey();
        turkey.gobble();

        Duck tAdapter = new TurkeyAdapter(turkey);
        callMethods(tAdapter);
    }
}
