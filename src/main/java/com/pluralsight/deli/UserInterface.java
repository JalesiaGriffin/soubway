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


    public void processAddSandwich(){
        System.out.println("Enter your bread:  \uD83E\uDD6A");
        String bread = input.next();
        System.out.println(bread);
        System.out.println("Enter your size:  \uD83E\uDD6A");
        String size = input.next();
        System.out.println(size);
        while (!toppings.equals("done") ){
            System.out.println("Add your toppings:  \uD83E\uDD6A");
            System.out.println("When done type done. \uD83E\uDD6A");
            toppings = input.nextLine();

    }
    public void processAddChips(){

        System.out.println("Add your chips: ");
        String name = input.next();
        System.out.println(name);


    }
    public void processAddDrinks(){

    }
    public void processCheckout(){

    }

    public void displayMenu(){
        Scanner scanner = new Scanner(System.in);
        boolean (acting) = true;
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
