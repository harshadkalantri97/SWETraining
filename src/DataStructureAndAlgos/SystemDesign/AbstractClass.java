package DataStructureAndAlgos.SystemDesign;

import java.util.Scanner;

abstract class Animal
{
   protected String name;
   protected String typeofAnimal;
   protected int animalNumber;

   abstract void makeSound();

   Animal(String name, String typeofAnimal, int animalNumber)
   {
      this.name = name;
      this.typeofAnimal = typeofAnimal;
      this.animalNumber = animalNumber;
   }
}

class Dog extends Animal
{
   Dog(String name, String typeofAnimal, int animalNumber)
   {
      super(name, typeofAnimal, animalNumber);
   }

   public void displayInfo()
   {
      System.out.println("Name: " + name);
      System.out.println("Type: " + typeofAnimal);
      System.out.println("Number: " + animalNumber);
   }

   @Override
   public void makeSound()
   {
      System.out.println("Dog goes woof");
   }
}

class Cat extends Animal
{
   Cat(String name, String typeofAnimal, int animalNumber)
   {
      super(name, typeofAnimal, animalNumber);
   }

   public void displayInfo()
   {
      System.out.println("");
      System.out.println("Name: " + name);
      System.out.println("Type: " + typeofAnimal);
      System.out.println("Number: " + animalNumber);
   }

   @Override
   public void makeSound()
   {
      System.out.println("Cat goes meow");
   }
}

public class AbstractClass
{
   public static void main(String[] args)
   {
      Scanner scanner = new Scanner(System.in);
      System.out.println("Enter Dog Name:");
      String dogName = scanner.nextLine();
      System.out.println("Enter Cat Name:");
      String catName = scanner.nextLine();
      String dogType = "Wolf-Type", catType = "FelineType";
      System.out.println("Enter Dog Number:");
      int dogNumber = scanner.nextInt();
      System.out.println("Enter Cat Number:");
      int catNumber = scanner.nextInt();
      Dog dogInfo = new Dog(dogName, dogType, dogNumber);
      dogInfo.displayInfo();
      dogInfo.makeSound();
      Cat catInfo = new Cat(catName, catType, catNumber);
      catInfo.displayInfo();
      catInfo.makeSound();
      scanner.close();
   }
}
