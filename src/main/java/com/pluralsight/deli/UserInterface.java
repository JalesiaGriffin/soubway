package com.pluralsight.deli;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Order order = new Order();

    Scanner input = new Scanner(System.in);
    public void display(){
        displayMenu();
    }

    public void startNewOrder(){

    }


    public void processAddSandwich() {

        System.out.println("Enter your bread:  \uD83E\uDD6A");
        String bread = input.next();
        System.out.println(bread);
        System.out.println("Enter your size:  \uD83E\uDD6A");
        String size = input.next();
        System.out.println(getSize);
        ArrayList<Topping> toppings = new ArrayList<>();
        String topping = null;
        String choice = null;
        do {
            System.out.println("Add your toppings: \uD83E\uDD6A");
            topping = input.next();
            System.out.println("Let's add another one! \uD83E\uDD6A");
            choice = input.next();
        } while (choice.equalsIgnoreCase("yes"));
        System.out.println("Would you like extra Cheese? Press Y for Yes and N for No ");

        Boolean extraCheese = isExtraCheese();
        switch (input){
            case "Y":
                System.out.println("You added extra Cheese");
            case "N" :
                extraCheese = false;
                break;
        }
     System.out.println("Would you like extra Meat? Press Y for Yes and N for No ");
        Boolean extraMeat = isExtraMeat;
        switch (input){
            case "Y":
                System.out.println("You added extra Meat");
            case "N" :
               extraMeat = false;
                break;
        }
        System.out.println("Would you like for it to be toasted? Press Y for Yes and N for No ");
        Boolean toasted = isToasted;
        switch (input){
            case "Y":
                System.out.println("It will be toasted");
            case "N" :
               toasted = false;
                break;
        }
        order.addSandwich(new Sandwich(bread,toasted,extraCheese,extraMeat,size));

    }
    public void  processAddChips(){
        System.out.println("Add your chips: ");
        String name = input.next();
        System.out.println(name);


    }
    public void processAddDrinks(){
            System.out.println("Add your drink: ");
            String size = input.next();
            System.out.println(size);
            String flavor = input.next();
            System.out.println(flavor);
        order.addDrink(new Drink(size, flavor));
        }


    public void processCheckout(){
    System.out.println("Let's finish up your order");
    System.out.println(checkOut);

    }

    public void displayMenu(){
        Scanner scanner = new Scanner(System.in);
        Boolean acting = true;
        while (acting) {
            System.out.println("Welcome to Soubway please choose your soub");
            System.out.println("Would you like to start a new order?");
            System.out.println("1.) Start new Order");
            System.out.println("0.) Exit");

            System.out.println("You selected \uD83E\uDD6A");
            String firstInput = scanner.nextLine().trim();
            switch (firstInput){
                case "1":
                    startNewOrder();
                case "0":
                    acting = false;
                    break;
            }
            System.out.println("Alright! Let's start your order!");
            System.out.println("1.) Add soub");
            System.out.println("2.) Add drink");
            System.out.println("3.) Add chips");
            System.out.println("4.) Checkout");
            System.out.println("0.) Cancel Order");

            System.out.println("You selected \uD83E\uDD6A");
            String input = scanner.nextLine().trim();

            switch (input) {
                case "1":
                    processAddSandwich();
                    break;
                case "2":
                    processAddDrinks();
                    break;
                case "3":
                    processAddChips();
                    break;
                case "4":
                    processCheckout();
                    break;
                case "0":
                    acting = false;
                    break;
            }

        }
    }

}
