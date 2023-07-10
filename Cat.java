// Дочерний класс "Кошка" наследует от класса "Животное"
public class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }
    
    public void meow() {
        System.out.println("Meow!");
    }
}