package patterns.structural.decorator;


abstract class Pizza {

    public abstract String getDescription();

    public abstract int getCost();
}

class Margherita extends Pizza {
    @Override
    public String getDescription() {
        return "Cheese, TomatoSauce";
    }

    @Override
    public int getCost() {
        return 60;
    }
}

abstract class ToppingDecorator extends Pizza{
    protected Pizza pizza;

    public ToppingDecorator(Pizza pizza){
        this.pizza = pizza;
    }
}

class ToppingDecoratorHam extends ToppingDecorator{

    public ToppingDecoratorHam(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Ham";
    }

    @Override
    public int getCost() {
        return pizza.getCost() + 5;
    }
}

class ToppingDecoratorPineApple extends ToppingDecorator{

    public ToppingDecoratorPineApple(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", PineApple";
    }

    @Override
    public int getCost() {
        return pizza.getCost() + 5;
    }
}

public class DecoratorExample {

    public static void main(String[] args) {
        Pizza pizza = new ToppingDecoratorPineApple(new ToppingDecoratorHam(new ToppingDecoratorHam(new Margherita())));
        System.out.println("Ingredients : " + pizza.getDescription() + " | Cost : " + pizza.getCost() );

    }
}
