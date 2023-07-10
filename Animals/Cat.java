package Animals;

import java.util.ArrayList;
import java.util.List;

// Дочерний класс Кошка
class Cat extends Animal {
    private List<String> commands;

    public Cat(String name) {
        super(name);
        commands = new ArrayList<>();
    }

    public void addCommand(String command) {
        commands.add(command);
    }

    @Override
    public void performCommands() {
        System.out.println("Cat " + getName() + " can perform the following commands:");
        for (String command : commands) {
            System.out.println("- " + command);
        }
    }
}
