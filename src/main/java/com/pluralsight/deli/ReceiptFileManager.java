package com.pluralsight.deli;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptFileManager {
    public static void main(String[] args) {
            ReceiptFileManager receiptFileManager = new ReceiptFileManager("receipt.txt");
            Order order = new Order();//add parameters for order
            receiptFileManager.saveReceiptFile(order);
        }


    private String fileName;

    public ReceiptFileManager (String fileName) {
        this.fileName = fileName;
    }

    public void saveReceiptFile (Order order) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            //get receipt details from the order object
            String receiptDetails = order.checkOut();

            LocalDateTime currentDateTime = LocalDateTime.now();
            DateTimeFormatter fm = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedDateTime = currentDateTime.format(fm);

            //write date, time & receipt details to file
            writer.write("Date and Time: " + formattedDateTime + "\n" );
            writer.write(receiptDetails);

            System.out.println("Receipt file saved successfully. ");
        }catch (IOException e) {
            System.out.println("Error saving receipt file " + e.getMessage());
        }
    }




}
