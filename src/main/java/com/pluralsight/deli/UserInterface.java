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
            System.out.println("\nBREAD OPTIONS - Rye, White, Wheat, or Wrap");
            System.out.print("Enter your bread  \uD83E\uDD6A : ");
            bread = input.nextLine();

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
        System.out.println("\nSIZE OPTIONS - 4, 8, or 12 (inches)");
        do {
            System.out.print("Enter your size  \uD83E\uDD6A : ");
            size = input.nextLine();
            for (String s : sizes) {
                if (size.equalsIgnoreCase(s)) {
                    sizeFound = true;
                    break;
                }
            }
            if (!sizeFound) {
                System.out.println("Sorry, we do not carry that bread.");
            }
        } while (!sizeFound);

        Sandwich nameOfSandwichObject = new Sandwich(bread, size);
        //------------Toppings Meat

        List<String> meats = new ArrayList<>(Arrays.asList("steak", "ham", "salami", "roast beef", "chicken", "bacon"));

        ArrayList<Topping> toppings = new ArrayList<>();
        boolean meatFound = false;

        System.out.println("\nMEAT OPTIONS - Steak, Ham, Salami, Roast Beef, Chicken, or Bacon");
        do {
            System.out.print("Add your meat: ");
            String meat = input.nextLine();
            ;
            for (String m : meats) {
                if (meat.equalsIgnoreCase(m) || meat.contains(m)) {
                    meatFound = true;
                    nameOfSandwichObject.addTopping(new PremiumTopping(meat));
                    break;
                }
            }
        } while (!meatFound);

        // -- Cheese
        List<String> cheeses = new ArrayList<>(Arrays.asList("american", "provolone", "cheddar", "swiss"));
        System.out.println("\nCHEESE OPTIONS - American, Provolone, Cheddar, and Swiss");

        boolean cheeseFound = false;
        do {
            System.out.print("Add your cheese \uD83E\uDD6A : ");
            String cheese = input.nextLine();
            ;
            for (String c : cheeses) {
                if (cheese.equalsIgnoreCase(c)) {
                    cheeseFound = true;
                    nameOfSandwichObject.addTopping(new PremiumTopping(cheese));
                    break;
                }
            }
        } while (!cheeseFound);

        // -- Regular Toppings
        List<String> regularToppings = new ArrayList<>(Arrays.asList("Lettuce", "Peppers", "Onions", "Tomatoes", "Jalepenos", "Cucumbers"));
        System.out.println("\nTOPPING OPTIONS - Lettuce, Peppers, Onions, Tomatoes, Jalepenos, Cucumbers");
        boolean toppingFound = false;
        boolean selectingToppings = true;

        while(selectingToppings) {
            do {
                System.out.print("Add topping: ");
                String topping = input.nextLine();

                for (String t : regularToppings){
                    if(topping.equalsIgnoreCase(t)){
                        toppingFound = true;
                        nameOfSandwichObject.addTopping(new RegularTopping(topping));
                        break;
                    }
                } if (!toppingFound){
                    System.out.println("Sorry, we don't carry that topping");
                }
            } while(!toppingFound);

            System.out.print("Would you like to add another topping? ");
            String userToppingChoice = input.nextLine();

            if (userToppingChoice.equalsIgnoreCase("no"))  {
                selectingToppings = false;
            }
        }



        //-----Extra cheese
        System.out.print("\nWould you like extra Cheese(Y for Yes and N for No)? ");
        String userInput = input.nextLine();

        if (userInput.equalsIgnoreCase("Y")) {
            nameOfSandwichObject.isExtraCheese();
            System.out.println("You added extra Cheese");
        }


        //---------------Extra Meat
        System.out.print("\nWould you like extra Meat (Press Y for Yes and N for No)? ");
        userInput = input.nextLine();

        if (userInput.equalsIgnoreCase("Y")) {
            nameOfSandwichObject.isExtraMeat();
            System.out.println("You added extra Meat");
        }


        //------------Toasted
        System.out.print("\nWould you like for it to be toasted (Press Y for Yes and N for No)? ");
        userInput = input.nextLine();

        if (userInput.equalsIgnoreCase("Y")) {
            nameOfSandwichObject.isToasted();
            System.out.println("It will be toasted");
        }

        order.addSandwich(nameOfSandwichObject);
    }

    //-------Adding Chips
    public void  processAddChips() {
        List<String> chips = new ArrayList<>(Arrays.asList("Sunchip", "Doritos", "Lays","Cheetos","Pringles"));
        boolean chipFound = false;
        String chip;
        System.out.println("\nCHIP OPTIONS - Sunchip, Doritos, Lays, Cheetos, or Pringles");
        do {
            System.out.print("Add your chips: ");
            chip = input.nextLine();
            for (String c : chips) {
                if (chip.equalsIgnoreCase(c)) {
                    chipFound = true;
                    break;
                }
            }
            if (!chipFound) {
                System.out.println("Sorry, we do not carry that chip.");

            }
        } while (!chipFound);


        order.addChips(new Chip(chip));
    }


    //------- Adding drinks

    public void processAddDrinks(){
        List<String> sizes = new ArrayList<>(Arrays.asList("Small", "Medium", "Large"));
        boolean sizeFound = false;
        String size;
        do {
            System.out.print("\nSelect drink size (small, medium, or large) \uD83E\uDD64 : ");
            size = input.nextLine();
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
        System.out.println("\nDRINK FLAVORS - Fanta, Coke, Pepsi, Ginger Ale, Sprite, or Root Beer");
        do {
            System.out.print("Select drink flavor \uD83E\uDD64 : ");
            flavor = input.nextLine();
            for (String f : flavors) {
                if (flavor.equalsIgnoreCase(f)) {
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

            System.out.print("You selected \uD83E\uDD6A : ");
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
        boolean running = true;
        while(running) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("\nAlright! Let's complete your order!");
            System.out.println("1.) Add soub");
            System.out.println("2.) Add chips");
            System.out.println("3.) Add drink");
            System.out.println("4.) Checkout");
            System.out.println("0.) Cancel Order");
            System.out.print("You selected \uD83E\uDD6A : ");

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
                    running = false;
                    break;
            }
        }
    }
}


