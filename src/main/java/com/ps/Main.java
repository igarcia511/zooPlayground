package com.ps;

import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Scanner commandScanner = new Scanner(System.in);

    static Scanner inputScanner = new Scanner(System.in);

    static ArrayList<Animal> animals = new ArrayList<>();

    public static void main(String[] args) {
        loadAnimals();
        // loadAnimals();
//        Animal animal1 = new Animal(
//                "Billi",
//                "Billy Goat",
//                5,
//                "Americas",
//                true
//
//                  );
//        animals.add(animal1);


        //System.out.println("Give me a new name for billy goat: ");
        //String newName = scanner.nextLine();
        //firstAnimal.setName(newName);
        //System.out.println(firstAnimal);
        // beginning

        // create menu instructions
        // use scanner to store the users command inpiut into a variable (int mainMenuCommand)
        int mainMenuCommand;


        // create a do-while loop that will run as long as mainMenuCommand does not equal "exit"
        do {
            System.out.println("Welcome to The Zoo! select an option. . .");
            System.out.println("1) Add animal");
            System.out.println("2) Display Animals");
            System.out.println("0) Exit");

            try {
                mainMenuCommand = commandScanner.nextInt();
            } catch (InputMismatchException ime) {
                // ime.printStackTrace();
                mainMenuCommand = 0;
            }

            switch (mainMenuCommand) {
                case 1:
                    addAnimal();
                    break;
                case 2:
                    displaySubMenu();
                    break;
                case 0:
                    System.out.println("Exiting. . .");
                    break;
                default:
                    System.out.println("Invalid Command, try again. . .");
            }

        } while (mainMenuCommand != 0);

        // switch that checks for the case to compare mainMenuCommand and match to the various cases

        // create static methods that match the corresponding command
        // create code for each static method(command Option)
        //handle incorrect commands

        // END


        // keep track of all of the animals at a zoo
        // load initial animals from a file *
        // ********* home *************
        // add animal
        // display animals
        // all
        // public animals
        // search for animals by name
        // search by type
        // search by age range
        // search by 0rigin

        // exit

        // have the ability to
        //  -Add an animal from the cli
        // - write the animal to a file *


        // -To see all animals
        //  Display all animals
        // display alll publicly available animals
        // search for an animal
        // search by location


    }

    public static void loadAnimals() {

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("animals.csv"));
            String header = bufferedReader.readLine();
            String input;
            //System.out.println("Here are our animals. . .");
            // System.out.println(header);
            while ((input = bufferedReader.readLine()) != null) {

                String[] animalsArr = input.split("\\|");

                String animalName = animalsArr[0];
                String animalType = animalsArr[1];
                int animalAge = Integer.parseInt(animalsArr[2]);
                String animalOrigin = animalsArr[3];
                boolean isAnimalDisplayed = Boolean.parseBoolean(animalsArr[4]);

                Animal animal = new Animal(animalName, animalType, animalAge, animalOrigin, isAnimalDisplayed);

                animals.add(animal);
            }

            bufferedReader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
//        for(int i = 0; i < animals.size(); i++){
//            Animal a = animals.get(i);
//            //System.out.printf("%s  %s  %d  %s %b \n", a.getName(), a.getType(), a.getAge(), a.getOrigin(), a.isPubliclyAvailable() );
//            System.out.println(a);
//        }

    }

    public static void addAnimal() {

        System.out.print("Enter the name of the animal: ");
        String animalName = inputScanner.nextLine();

        System.out.print("Enter the animal type: ");
        String animalType = inputScanner.nextLine();

        System.out.print("Enter animal age: ");
        int animalAge = inputScanner.nextInt();

        inputScanner.nextLine();

        System.out.print("Enter the origin of the animal: ");
        String animalOrigin = inputScanner.nextLine();

        System.out.print("is animal publicly available ? true or false ");
        boolean isPubliclyAvailable = inputScanner.nextBoolean();

        Animal animal = new Animal(animalName, animalType, animalAge, animalOrigin, isPubliclyAvailable);
        animals.add(animal);

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("animals.csv", true));
            bufferedWriter.write(String.format("\n%s|%s|%d|%s|%b", animal.getName(), animal.getType(), animal.getAge(), animal.getOrigin(), animal.isPubliclyAvailable()));
//            bufferedWriter.write(animalName);
//            bufferedWriter.write(animalType);
//            bufferedWriter.write(animalAge);
//            bufferedWriter.write(animalOrigin);
//            bufferedWriter.write(isPubliclyAvailable);
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void displaySubMenu() {
        // initialize variable to store command
        int subMenuCommand;
        do {

            System.out.println("Select an option");
            System.out.println("1) Display All");
            System.out.println("2) Display publicly available");
            System.out.println("3) Search by name");
            System.out.println("4) Search by type");
            System.out.println("5) Search by age range");
            System.out.println("6) Search by origin");

            System.out.println("0) Exit");

            System.out.print("Command: ");
            // get input from user

            subMenuCommand = commandScanner.nextInt();

            // switch statement to trigger according static methods
            switch (subMenuCommand) {
                case 1:
                    displayAllAnimals();
                    break;
                case 2:
                    displayPubliclyAvailable();
                    break;
                case 3:
                    searchByName();
                    break;
                case 4:
                    searchByType();
                    break;
                case 5:
                    searchByAgeRange();
                    break;
                case 6:
                    searchByOrigin();
                    break;
                case 0:
                    System.out.println("Exiting . . .");
                    break;
                default:
                    System.out.println("Invalid Command, try again . . .");

            }

        } while (subMenuCommand != 0);

    }

    public static void displayAllAnimals() {
        for (int i = 0; i < animals.size(); i++) {
            Animal a = animals.get(i);
            System.out.printf("%s %s %d %s %b \n", a.getName(), a.getType(), a.getAge(), a.getOrigin(), a.isPubliclyAvailable());
            // System.out.println(a);

        }
    }

    public static void displayPubliclyAvailable() {

        for (int i = 0; i < animals.size(); i++) {
            Animal a = animals.get(i);
            if (a.isPubliclyAvailable()) {
                System.out.printf("%s  %s  %d  %s %b \n", a.getName(), a.getType(), a.getAge(), a.getOrigin(), a.isPubliclyAvailable());
            }
        }

    }

    public static void searchByName() {
        System.out.print("Enter the name of the animal you are looking for:");
        String animalName = inputScanner.nextLine();

        for (int i = 0; i < animals.size(); i++) {
            Animal a = animals.get(i);
            if (a.getName().equalsIgnoreCase(animalName)) {
                System.out.printf("%s  %s  %d  %s %b \n", a.getName(), a.getType(), a.getAge(), a.getOrigin(), a.isPubliclyAvailable());
            }
        }
    }

    public static void searchByType() {
        System.out.print("Enter the type of animal you are searching for: ");
        String animalType = inputScanner.nextLine();

        for (int i = 0; i < animals.size(); i++) {
            Animal a = animals.get(i);
            if (a.getType().equals(animalType)) {
                System.out.printf("%s  %s  %d  %s %b \n", a.getName(), a.getType(), a.getAge(), a.getOrigin(), a.isPubliclyAvailable());
            }
        }
    }

    public static void searchByAgeRange() {
        System.out.println("Enter a range of numbers to find animals within that range");

        System.out.print("Enter the minimum age: ");
        int minAge = inputScanner.nextInt();

        inputScanner.nextLine();

        System.out.print("Enter the maximum age: ");
        int maxAge = inputScanner.nextInt();

        for (Animal a : animals) {
            if (a != null) {
                if (a.getAge() > minAge && a.getAge() < maxAge) {
                    System.out.printf("%s %s %d %s %b \n", a.getName(), a.getType(), a.getAge(), a.getOrigin(), a.isPubliclyAvailable());
                }
            }
        }


    }

    public static void searchByOrigin() {
        System.out.println("Search by origin");
    }


}
