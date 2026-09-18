interface Flyable {
    void fly();
}

interface Swimmable {
    void swim();
}

class Animal {
    private String name;
    protected int age;
    static int count = 0;
    final String TYPE = "Animal";

    // Constructor
    Animal(String name, int age) {
        this.name = name;
        this.age = age;
        count++;
    }

    // Encapsulation
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Method
    void sound() {
        System.out.println("Dong vat keu");
    }

    // Overloading
    void eat() {
        System.out.println(name + " dang an");
    }

    void eat(String food) {
        System.out.println(name + " an " + food);
    }
}

// Inheritance
class Dog extends Animal {

    Dog(String name, int age) {
        super(name, age);
    }

    // Polymorphism + Override
    @Override
    void sound() {
        System.out.println(getName() + ": Gau gau");
    }
}

// Inheritance + Interface
class Duck extends Animal implements Flyable, Swimmable {

    Duck(String name, int age) {
        super(name, age);
    }

    @Override
    void sound() {
        System.out.println(getName() + ": Cap cap");
    }

    @Override
    public void fly() {
        System.out.println(getName() + " dang bay");
    }

    @Override
    public void swim() {
        System.out.println(getName() + " dang boi");
    }
}

public class Dongvat {
    public static void main(String[] args) {

        // Object
        Dog d = new Dog("Lu", 3);
        Duck k = new Duck("Donald", 2);

        // Encapsulation
        d.setName("LuLu");
        System.out.println(d.getName());

        // Method
        d.eat();
        d.eat("xuong");
        d.eat("Cuc cho");

        // Polymorphism
        Animal a;

        a = d;
        a.sound();

        a = k;
        a.sound();

        // Interface
        k.fly();
        k.swim();

        // static
        System.out.println("So dong vat: " + Animal.count);

        // final
        System.out.println(d.TYPE);
    }
}