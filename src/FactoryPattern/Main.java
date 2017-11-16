package FactoryPattern;
import java.util.concurrent.ThreadLocalRandom;


abstract class Animal {
    public abstract String getDescription();
}

class Dog extends Animal { public String getDescription() { return "Dog"; } }
class Cat extends Animal { public String getDescription() { return "Cat"; } }
class Duck extends Animal { public String getDescription() { return "Duck"; } }

abstract class AnimalFactory {
    public abstract Animal createAnimal(String choice);
    public abstract Animal createAnimal();
}

class RandomAnimalFactory extends AnimalFactory {
    public Animal createAnimal() {
        int randomNum = ThreadLocalRandom.current().nextInt(0, 3);
        return (randomNum == 0) ? new Dog() : (randomNum == 1) ? new Cat() : new Duck();
    }

    public Animal createAnimal(String choice) { return createAnimal(); }
}

class OrderedAnimalFactory extends AnimalFactory {

    public Animal createAnimal(String choise) {
        if(choise == "Dog") return new Dog();
        else if(choise == "Cat") return new Cat();
        else return new Duck();
    }

    public Animal createAnimal() { return createAnimal("Dog"); }
}

public class Main {

    public static void main(String args[]) {
        AnimalFactory animalFactory = new RandomAnimalFactory();
        Animal animal = animalFactory.createAnimal();
        System.out.println(animal.getDescription());

        animalFactory = new OrderedAnimalFactory();
        animal = animalFactory.createAnimal("Dog");
        System.out.println("selected : " + animal.getDescription());
    }
}