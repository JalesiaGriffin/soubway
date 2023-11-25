package com.pluralsight.deli;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    public void display(){
        displayMenu();
    }

    public void startNewOrder(){

    }


    public void processAddSandwich(){


    }
    public void processAddChips(){

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
