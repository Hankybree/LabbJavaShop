package patterns.creational.factory;


import java.util.List;

interface Transportation {
}

class Truck implements Transportation {
}

class Ship implements Transportation {
}

enum TransportationDestination {
    Asia, Europe, America
}

class TransportationFactory {
    public Transportation getTransportation(TransportationDestination destination) {
        return switch (destination) {
            case Asia, America -> new Ship();
            case Europe -> new Truck();
        };
    }
}

public class FactoryExample {

    public static void main(String[] args) {
        Transportation transportation = new TransportationFactory()
                .getTransportation(TransportationDestination.Asia);

        //Do something with transportation
        Integer integer = new Integer(1);
        Integer integer1 = Integer.valueOf(1);



    }
}

interface Animal {
    void sound();
}

class Cat implements Animal {
    @Override
    public void sound() {
        System.out.println("Mjau");
    }
}

class Dog implements Animal {
    @Override
    public void sound() {
        System.out.println("Voff");
    }
}

class Tiger implements Animal {
    @Override
    public void sound() {
        System.out.println("Mjau");
    }
}

class Wolf implements Animal {
    @Override
    public void sound() {
        System.out.println("Voff");
    }
}

enum AnimalType {Cat, Dog}

interface AnimalFactory {
    Animal getAnimal(AnimalType type);
}

class DomesticAnimalFactory implements AnimalFactory{
    public Animal getAnimal(AnimalType type) {
        switch (type) {
            case Cat:
                return new Cat();
            case Dog:
                return new Dog();
            default:
                return null;
        }
    }
}
class WildAnimalFactory implements AnimalFactory{
    public Animal getAnimal(AnimalType type) {
        switch (type) {
            case Cat:
                return new Tiger();
            case Dog:
                return new Wolf();
            default:
                return null;
        }
    }
}



