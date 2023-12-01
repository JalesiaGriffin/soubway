package com.pluralsight.deli;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Order order;
    private Scanner input;

    public UserInterface() {input = new Scanner(System.in);}

    public void display() {
        displayMenu();
    }

    public void startNewOrder() {
        order = new Order();
    }

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean acting = true;
        while (acting) {
            System.out.println("\nWelcome to Soubway please choose your soub");
            System.out.println("Would you like to start a new order?");
            System.out.println("1.) Start new Order");
            System.out.println("0.) Exit");

            System.out.print("You selected \uD83E\uDD6A : ");
            String firstInput = scanner.nextLine().trim();
            switch (firstInput) {
                case "1":
                    startNewOrder();
                    orderMenu();
                    break;
                case "0":
                    acting = false;
                    break;
            }
        }
    }

    public void orderMenu() {
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
                    running = false;
                    break;
                case "0":
                    running = false;
                    break;
                default:
                    System.out.println("invalid response.");
            }
        }
    }

//***************************************************SANDWICH SECTION***************************************************
    public void processAddSandwich() {
        // ----------------------------------------------Bread----------------------------------------------------------
        List<String> breads = new ArrayList<>(Arrays.asList("Rye", "White", "Wheat", "Wrap"));
        boolean breadFound = false;
        String bread;
        do {
            System.out.println("\nBREADS - Rye, White, Wheat, or Wrap");
            System.out.print("Enter your bread  \uD83E\uDD6A : ");
            bread = input.nextLine();

            for (String b : breads) {
                if (bread.toLowerCase().contains(b.toLowerCase())) {
                    breadFound = true;
                    bread = b;
                    break;
                }
            }
            if (!breadFound) {
                System.out.println("Sorry, we do not carry that bread.");
            }
        } while (!breadFound);


        //----------------------------------------------Bread size------------------------------------------------------
        List<String> sizes = new ArrayList<>(Arrays.asList("4", "8", "12"));

        boolean sizeFound = false;
        String size;
        System.out.println("\nSIZES - 4, 8, or 12 (inches)");
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


        //---------------------------------------------Meat-------------------------------------------------------------
        List<String> meats = new ArrayList<>(Arrays.asList("steak", "ham", "salami", "roast beef", "chicken", "bacon"));
        boolean meatFound = false;

        System.out.println("\nMEATS - Steak, Ham, Salami, Roast Beef, Chicken, or Bacon");
        do {
            System.out.print("Add your meat: ");
            String meat = input.nextLine();
            ;
            for (String m : meats) {
                if (meat.toLowerCase().contains(m)) {
                    meatFound = true;
                    nameOfSandwichObject.addTopping(new PremiumTopping(m));
                    break;
                }
            }
        } while (!meatFound);


        //-----------------------------------------------Cheese---------------------------------------------------------
        List<String> cheeses = new ArrayList<>(Arrays.asList("american", "provolone", "cheddar", "swiss"));
        System.out.println("\nCHEESES - American, Provolone, Cheddar, and Swiss");

        boolean cheeseFound = false;
        do {
            System.out.print("Add your cheese \uD83E\uDD6A : ");
            String cheese = input.nextLine();
            ;
            for (String c : cheeses) {
                if (cheese.toLowerCase().contains(c)) {
                    cheeseFound = true;
                    nameOfSandwichObject.addTopping(new PremiumTopping(c));
                    break;
                }
            }
        } while (!cheeseFound);

        // ---------------------------------------------Regular Toppings------------------------------------------------
        List<String> regularToppings = new ArrayList<>(Arrays.asList("lettuce", "peppers", "onions", "tomatoes", "jalepenos", "cucumbers"));
        System.out.println("\nTOPPINGS - Lettuce, Peppers, Onions, Tomatoes, Jalepenos, Cucumbers");
        boolean toppingFound = false;
        boolean selectingToppings = true;

        while(selectingToppings) {
            do {
                System.out.print("Add topping: ");
                String topping = input.nextLine();

                for (String t : regularToppings){
                    if(topping.toLowerCase().contains(t)){
                        toppingFound = true;
                        nameOfSandwichObject.addTopping(new RegularTopping(t));
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
        //---------------------------------------------Sauces-----------------------------------------------------------
        List<String> sauces = new ArrayList<>(Arrays.asList("mayo", "mustard", "ketchup", "ranch", "thousand island", "vinaigrette"));
        System.out.println("\nSAUCES - Mayo, Mustard, Ketchup, Ranch, Thousand Island, Vinaigrette");
        boolean sauceFound = false;
        boolean selectingSauces = true;

        while(selectingSauces) {
            do {
                System.out.print("Add sauce: ");
                String sauce = input.nextLine();

                for (String s : sauces){
                    if(sauce.toLowerCase().contains(s)){
                        sauceFound = true;
                        nameOfSandwichObject.addTopping(new RegularTopping(s));
                        break;
                    }
                } if (!sauceFound){
                    System.out.println("Sorry, we don't carry that sauce");
                }
            } while(!sauceFound);

            System.out.print("Would you like to add another sauce? ");
            String userSauceChoice = input.nextLine();

            if (userSauceChoice.equalsIgnoreCase("no"))  {
                selectingSauces = false;
            }
        }

        //---------------------------------------------Extra meat-------------------------------------------------------
        System.out.print("\nWould you like extra Meat ('Y' for Yes and 'N' for No)? ");
        String extraMeat = input.nextLine();

        if (extraMeat.equalsIgnoreCase("Y")) {
            nameOfSandwichObject.addExtraMeat();
            System.out.println("You added extra Meat");
        }

        //---------------------------------------------Extra cheese-----------------------------------------------------
        System.out.print("\nWould you like extra Cheese('Y' for Yes and 'N' for No)? ");
        String extraCheese = input.nextLine();

        if (extraCheese.equalsIgnoreCase("Y")) {
            nameOfSandwichObject.addExtraCheese();
            System.out.println("You added extra Cheese");
        }

        //---------------------------------------------Toasted----------------------------------------------------------
        System.out.print("\nWould you like for it to be toasted (Press 'Y' for Yes and 'N' for No)? ");
        String toasted = input.nextLine();

        if (toasted.equalsIgnoreCase("Y")) {
            nameOfSandwichObject.toast();
            System.out.println("It will be toasted");
        }

        order.addSandwich(nameOfSandwichObject);
    }
//********************************************************END***********************************************************

    public void  processAddChips() {
        List<String> chips = new ArrayList<>(Arrays.asList("Sunchip", "Doritos", "Lays","Cheetos","Pringles"));
        boolean chipFound = false;
        String chip;
        System.out.println("\nCHIPS - Sunchip, Doritos, Lays, Cheetos, or Pringles");
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


    public void processAddDrinks(){
    //------------------------------------------------Drink Size--------------------------------------------------------
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


    //------------------------------------------------Drink Flavor------------------------------------------------------
        List<String> flavors = new ArrayList<>(Arrays.asList("Fanta", "Coke", "Pepsi","Ginger ale", "Sprite","Root Beer"));
        boolean flavorFound = false;
        String flavor;
        System.out.println("\nFLAVORS - Fanta, Coke, Pepsi, Ginger Ale, Sprite, or Root Beer");
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

    System.out.print("\nSelect 'c' to confirm order: ");
    String confirm = input.nextLine();

    ReceiptFileManager rfm = new ReceiptFileManager();
    rfm.saveReceiptFile(order);
    }
}
