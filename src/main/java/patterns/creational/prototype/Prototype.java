package patterns.creational.prototype;

import java.util.ArrayList;
import java.util.List;

class Adress {
    String city;
    String street;
    int houseNumber;

    public Adress(String city, String street, int houseNumber) {
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
    }

    @Override
    public String toString() {
        return "Adress{" +
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", houseNumber=" + houseNumber +
                '}';
    }

    public Adress copy() {
        return new Adress(this.city,this.street,this.houseNumber);
    }
}

class AdressWithCountry extends Adress{
    String country;

    public AdressWithCountry(String country, String city, String street, int houseNumber) {
        super(city, street, houseNumber);
        this.country = country;
    }

    //If we forget this, copies will be of wrong type. Breaking LSP
    @Override
    public Adress copy() {
        return new AdressWithCountry(this.country,this.city,this.street,this.houseNumber);
    }

    @Override
    public String toString() {
        return "AdressWithCountry{" +
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", houseNumber=" + houseNumber +
                ", country='" + country + '\'' +
                '}';
    }
}

class Person {
    String name;
    private int age;
    Adress adress;  //Reference to an object

    public Person(String name, int age, Adress adress) {
        this.name = name;
        this.age = age;
        this.adress = adress;
    }

    public Person copy() {
        //Shallow copy
        //return new Person(this.name, this.age, this.adress);
        //Deep copy
        return new Person(this.name, this.age, this.adress.copy());
    }

    public static Person copyOf(Person prototype) {
        return new Person(prototype.name, prototype.age, prototype.adress.copy());
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", adress=" + adress +
                '}';
    }
}

public class Prototype {

    public static void main(String[] args) {
        Person person = new Person("Martin", 43, new AdressWithCountry("Sweden","Kalmar", "Nickebo", 1));
        System.out.println(person);

        Person person2 = person.copy();

        person2.name = "Kalle";
        person2.adress.city="Göteborg";

        System.out.println(person);
        System.out.println(person2);

        Person person3 = Person.copyOf(person);


    }




}
