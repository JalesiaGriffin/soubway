package com.pluralsight.deli;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Order order;

    Scanner input = new Scanner(System.in);

    public void display() {
        displayMenu();
    }

    public void startNewOrder() {
        order = new Order();

    }


    public void processAddSandwich() {
        // ----- Bread
        List<String> breads = new ArrayList<>(Arrays.asList("Rye", "White", "Wheat", "Wrap"));
        boolean breadFound = false;
        String bread;
        do {

            System.out.println("Enter your bread:  \uD83E\uDD6A");
            bread = input.next();

            for (String b : breads) {
                if (bread.equalsIgnoreCase(b)) {
                    breadFound = true;
                    break;
                }
            }
            if (!breadFound) {
                System.out.println("Sorry, we do not carry that bread.");
            }
        } while (!breadFound);


        //------ Bread size
        List<String> sizes = new ArrayList<>(Arrays.asList("4", "8", "12"));

        boolean sizeFound = false;
        String size;
        do {
            System.out.println("Enter your size:  \uD83E\uDD6A");
            size = input.next();
            for (String b : sizes) {
                if (size.equalsIgnoreCase(b)) {
                    sizeFound = true;
                    break;
                }
            }
            if (!sizeFound) {
                System.out.println("Sorry, we do not carry that bread.");
            }
        } while (!sizeFound);


        //------------Toppings Meat

        List<String> meats = new ArrayList<>(Arrays.asList("steak", "ham", "salami", "roast beef", "chicken", "bacon"));

        ArrayList<Topping> toppings = new ArrayList<>();
        String choice = "yes";

        do {
            System.out.println("Add your meat: ");
            String topping = input.next();
            ;
            for (String b : meats) {
                if (topping.equalsIgnoreCase(b)) {
                    toppings.add(new PremiumTopping(topping));
                    break;
                }

            }
        } while (choice.equalsIgnoreCase("yes"));

        // -- Cheese
        List<String> cheese = new ArrayList<>(Arrays.asList("american", "provolone", "cheddar", "swiss"));
        System.out.println("Add your cheese: \uD83E\uDD6A");

        do {
            System.out.println("Add your cheese: ");
            String topping = input.next();
            ;
            for (String b : cheese) {
                if (topping.equalsIgnoreCase(b)) {
                    toppings.add(new PremiumTopping(topping));
                    break;
                }

            }
        } while (choice.equalsIgnoreCase("yes"));


        //-----Extra cheese


        System.out.println("Would you like extra Cheese? Press Y for Yes and N for No ");


        Sandwich nameOfSandwichObject = new Sandwich(bread, size);
        String userInput = input.next();

        boolean extraCheese;

        if (userInput.equalsIgnoreCase("Y")) {
            nameOfSandwichObject.isExtraCheese();
            System.out.println("You added extra Cheese");

        } else if (userInput.equalsIgnoreCase("N")) {
            extraCheese = false;
        }


        //---------------Extra Meat

        System.out.println("Would you like extra Meat? Press Y for Yes and N for No ");
        userInput = input.next();

        boolean extraMeat;

        if (userInput.equalsIgnoreCase("Y")) {
            nameOfSandwichObject.isExtraMeat();
            System.out.println("You added extra Meat");

        } else if (userInput.equalsIgnoreCase("N")) {
            extraMeat = false;
        }


        //------------Tosted


        System.out.println("Would you like for it to be toasted? Press Y for Yes and N for No ");
        userInput = input.next();
        boolean toasted;


        if (userInput.equalsIgnoreCase("Y")) {
            nameOfSandwichObject.isToasted();
            System.out.println("It will be toasted");
        } else if (userInput.equalsIgnoreCase("N")) {
            toasted = false;
        }
        order.addSandwich(nameOfSandwichObject);

    }

    //-------Adding Chips
    public void processAddChips() {
        List<String> chips = new ArrayList<>(Arrays.asList("Sunchip", "Doritos", "Lays", "Cheetos", "Pringles"));

        boolean nameFound = false;

        String name;

        do {
            System.out.println("Add your chips: ");
            name = input.next();

            for (String b : chips) {
                if (name.equalsIgnoreCase(b)) {
                    nameFound = true;
                    break;
                }
            }

            if (!nameFound) {
                System.out.println("Sorry, we do not carry that chip.");

            }

        } while (!nameFound);

        order.addChips(new Chip(name));
    }


    //------- Adding drinks

    public void processAddDrinks(){
        List<String> sizes = new ArrayList<>(Arrays.asList("Small", "Medium", "Large"));
        boolean sizeFound = false;
        String size;
        do {
            System.out.println("Select drink size: \uD83E\uDD64");
            size = input.next();
            for (String b : sizes) {
                if (size.equalsIgnoreCase(b)) {
                    sizeFound = true;
                    break;
                }
            }
            if (!sizeFound) {
                System.out.println("Sorry, we do not carry that size.");
            }
        } while (!sizeFound);
        List<String> flavors = new ArrayList<>(Arrays.asList("Fanta", "Coke", "Pepsi","Ginger ale", "Sprite","Root Beer"));
        boolean flavorFound = false;
        String flavor;
        do {
            System.out.println("Select drink flavor: \uD83E\uDD64");
            flavor = input.next();
            for (String b : flavors) {
                if (flavor.equalsIgnoreCase(b)) {
                    flavorFound = true;
                    break;
                }
            }
            if (!flavorFound) {
                System.out.println("Sorry, we do not carry that flavor.");
            }
        } while (!flavorFound);


        order.addDrink(new Drink(size, flavor));
        }


    public void processCheckout(){
    System.out.println("Let's finish up your order");
    order.checkOut();
    }

    // Looping through the display menu
    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean acting = true;
        while (acting) {
            System.out.println("Welcome to Soubway please choose your soub");
            System.out.println("Would you like to start a new order?");
            System.out.println("1.) Start new Order");
            System.out.println("0.) Exit");

            System.out.println("You selected \uD83E\uDD6A");
            String firstInput = scanner.nextLine().trim();
            switch (firstInput) {
                case "1":
                    startNewOrder();
                    trueMenu();
                    break;
                case "0":
                    acting = false;
                    break;
            }
        }
    }
        //----- Second part of the menu if they want to start a new order
    public void trueMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean acts = true;
        while (acts) {
            System.out.println("Alright! Let's start your order!");
            System.out.println("1.) Add soub");
            System.out.println("2.) Add chips");
            System.out.println("3.) Add drink");
            System.out.println("4.) Checkout");
            System.out.println("0.) Cancel Order");
            System.out.println("You selected \uD83E\uDD6A");

            String input = scanner.nextLine().trim();


            switch (input) {
                case "1":
                    processAddSandwich();
                    break;
                case "2":
                    processAddChips();
                    break;
                case "3":
                    processAddDrinks();
                    break;
                case "4":
                    processCheckout();
                    break;
                case "0":
                    acts = false;
                    break;
            }
        }
        }
    }


