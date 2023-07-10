
public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat("Kitty");
        cat.eat();   // Вызов метода родительского класса
        cat.sleep(); // Вызов метода родительского класса
        cat.meow();  // Вызов метода дочернего класса
        
        Dog dog = new Dog("Buddy");
        dog.eat();   // Вызов метода родительского класса
        dog.sleep(); // Вызов метода родительского класса
        dog.bark();  // Вызов метода дочернего класса
    }
}