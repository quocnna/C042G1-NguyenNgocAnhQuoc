package _07_Abstract_Interface.Practices;

public interface Edible {
    String howToEat();
}
abstract class Animal {
    public abstract String makeSound();
}

class Tiger extends Animal implements Edible {
    @Override
    public String makeSound() {
        return "Tiger: roarrrrr!";
    }

    @Override
    public String howToEat() {
        return "Tiger could be fried";
    }
}
class Chicken extends Animal implements Edible {
    @Override
    public String makeSound() {
        return "Chicken: cluck-cluck!";
    }

    @Override
    public String howToEat() {
        return "Chicken could be fried";
    }
}

abstract class  Fruit implements Edible{ }
class Apple extends Fruit{
    @Override
    public String howToEat() {
        return "Apple could be slided";
    }
}
class Orange extends Fruit {
    @Override
    public String howToEat() {
        return "Orange could be juiced";
    }
}
class AbstractAndInterfaceTests {
    public static void main(String[] args) {
        Animal[] animals = new Animal[2];
        animals[0] = new Tiger();
        animals[1] = new Chicken();
        for (Animal animal : animals) {
            System.out.println(animal.makeSound());

            if (animal instanceof Chicken) {
                Edible edibler = (Chicken) animal;
                System.out.println(edibler.howToEat());
            }
            else if(animal instanceof  Tiger){
                System.out.println(((Tiger) animal).howToEat());
            }
        }

        Fruit[] fruits = new Fruit[2];
        fruits[0] = new Orange();
        fruits[1] = new Apple();
        for (Fruit fruit : fruits) {
            System.out.println(fruit.howToEat());
        }
    }
}