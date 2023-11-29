package com.pluralsight.deli;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptFileManager {


// You don't need this part in here, we would just save it in the SandwichShop main program
/*
        ReceiptFileManager receiptFileManager= new ReceiptFileManager();
        Order order= new Order();
        receiptFileManager.saveReceiptFile(order);*/


    public void saveReceiptFile (Order order) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter fm = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        String formattedDateTime = currentDateTime.format(fm);

        String fileName = formattedDateTime + ".txt";
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            //get receipt details from the order object
           // String receiptDetails = order.checkOut();


            //write date, time & receipt details to file
            writer.write("Date and Time: " + formattedDateTime + "\n" );


            writer.close();


            System.out.println("Receipt file saved successfully. ");
        }catch (IOException e) {
            System.out.println("Error saving receipt file " + e.getMessage());
        }
    }




}