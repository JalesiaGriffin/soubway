package com.pluralsight.deli;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private Order order;

    Scanner input = new Scanner(System.in);
    public void display(){
        displayMenu();
    }

    public void startNewOrder(){
        order = new Order();

    }


    public void processAddSandwich() {

        System.out.println("Enter your bread:  \uD83E\uDD6A");
        String bread = input.next();
        System.out.println("Enter your size:  \uD83E\uDD6A");
        String size = input.next();
        ArrayList<Topping> toppings = new ArrayList<>();
        String topping = null;
        String choice = null;
        do {
            System.out.println("Add your toppings: \uD83E\uDD6A");
            topping = input.next();
            toppings.add(new RegularTopping(topping));
            System.out.println("Let's add another one! Yes or No  \uD83E\uDD6A");
            choice = input.next();
        } while (choice.equalsIgnoreCase("yes"));
        //----------------------------------
        System.out.println("Would you like extra Cheese? Press Y for Yes and N for No ");

        Sandwich nameOfSandwichObject = new Sandwich(bread,size);
        String userInput = input.next();

        boolean extraCheese;

        if ( userInput.equalsIgnoreCase("Y"))  {
            nameOfSandwichObject.isExtraCheese();
            System.out.println("You added extra Cheese");

        } else if (userInput.equalsIgnoreCase("N")) {
            extraCheese = false;
        }
      //---------------------------------------------
     System.out.println("Would you like extra Meat? Press Y for Yes and N for No ");
       userInput = input.next();

        boolean extraMeat;

        if ( userInput.equalsIgnoreCase("Y")) {
             nameOfSandwichObject.isExtraMeat();
            System.out.println("You added extra Meat");

        } else if (userInput.equalsIgnoreCase("N")) {
            extraMeat = false;
        }
        //-------------------------------------------------------
        System.out.println("Would you like for it to be toasted? Press Y for Yes and N for No ");
        userInput = input.next();
        boolean toasted ;



        if  (userInput.equalsIgnoreCase("Y")) {
            nameOfSandwichObject.isToasted();
            System.out.println("It will be toasted");
        } else if ( userInput.equalsIgnoreCase("N")) {
               toasted = false;
        }
        order.addSandwich(nameOfSandwichObject);

    }
    public void  processAddChips(){
        System.out.println("Add your chips: ");
        String name = input.next();
        System.out.println(name);
        order.addChips(new Chip(name));

    }
    public void processAddDrinks(){
            System.out.println("Select drink size: \uD83E\uDD64");
            String size = input.next();
            System.out.println(size);
        System.out.println("Select drink flavor: \uD83E\uDD64");
            String flavor = input.next();
            System.out.println(flavor);
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
                case "0":
                    acting = false;
                    break;
            }
        }
    }
        //----- Second part of the menu if they want to start a new order
    public void trueMenu() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Alright! Let's start your order!");
            System.out.println("1.) Add soub");
            System.out.println("2.) Add drink");
            System.out.println("3.) Add chips");
            System.out.println("4.) Checkout");
            System.out.println("0.) Cancel Order");
            System.out.println("You selected \uD83E\uDD6A");

            String input = scanner.nextLine().trim();
            boolean acts = true;
            while (acts) {

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


