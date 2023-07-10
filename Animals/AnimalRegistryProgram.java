package Animals;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AnimalRegistryProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Animal> animals = new ArrayList<>();

        try (Counter counter = new Counter()) {
            while (true) {
                System.out.println("Animal Registry Program");
                System.out.println("1. Add a new animal");
                System.out.println("2. Determine animal's class");
                System.out.println("3. List commands for an animal");
                System.out.println("4. Train animal a new command");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Очистка буфера сканера

                switch (choice) {
                    case 1:
                        counter.add(); // Увеличение значения счетчика при добавлении нового животного
                        System.out.print("Enter the name of the animal: ");
                        String animalName = scanner.nextLine();
                        System.out.print("Enter the type of animal (dog/cat): ");
                        String animalType = scanner.nextLine();

                        if (animalType.equalsIgnoreCase("dog")) {
                            Dog dog = new Dog(animalName);
                            animals.add(dog);
                            System.out.println("New dog added to the registry.");
                        } else if (animalType.equalsIgnoreCase("cat")) {
                            Cat cat = new Cat(animalName);
                            animals.add(cat);
                            System.out.println("New cat added to the registry.");
                        } else {
                            System.out.println("Invalid animal type.");
                        }
                        break;
                    case 2:
                        System.out.print("Enter the name of the animal: ");
                        String searchName = scanner.nextLine();

                        Animal foundAnimal = null;
                        for (Animal animal : animals) {
                            if (animal.getName().equalsIgnoreCase(searchName)) {
                                foundAnimal = animal;
                                break;
                            }
                        }

                        if (foundAnimal != null) {
                            if (foundAnimal instanceof Dog) {
                                System.out.println(foundAnimal.getName() + " is a dog.");
                            } else if (foundAnimal instanceof Cat) {
                                System.out.println(foundAnimal.getName() + " is a cat.");
                            }
                        } else {
                            System.out.println("Animal not found in the registry.");
                        }
                        break;
                    case 3:
                        System.out.print("Enter the name of the animal: ");
                        String animalName2 = scanner.nextLine();

                        Animal animal2 = null;
                        for (Animal animal : animals) {
                            if (animal.getName().equalsIgnoreCase(animalName2)) {
                                animal2 = animal;
                                break;
                            }
                        }

                        if (animal2 != null) {
                            animal2.performCommands();
                        } else {
                            System.out.println("Animal not found in the registry.");
                        }
                        break;
                    case 4:
                        System.out.print("Enter the name of the animal: ");
                        String animalName3 = scanner.nextLine();
                        System.out.print("Enter the command to train: ");
                        String command = scanner.nextLine();

                        Animal animal3 = null;
                        for (Animal animal : animals) {
                            if (animal.getName().equalsIgnoreCase(animalName3)) {
                                animal3 = animal;
                                break;
                            }
                        }

                        if (animal3 != null) {
                            if (animal3 instanceof Dog) {
                                Dog dog = (Dog) animal3;
                                dog.addCommand(command);
                                System.out.println("Command added for dog " + animalName3);
                            } else if (animal3 instanceof Cat) {
                                Cat cat = (Cat) animal3;
                                cat.addCommand(command);
                                System.out.println("Command added for cat " + animalName3);
                            }
                        } else {
                            System.out.println("Animal not found in the registry.");
                        }
                        break;
                    case 5:
                        System.out.println("Exiting the program...");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }

                System.out.println();
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
