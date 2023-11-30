package com.pluralsight.deli;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptFileManager {
    public void saveReceiptFile (Order order) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter fm = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        String formattedDateTime = currentDateTime.format(fm);

        String fileName = formattedDateTime + ".txt";
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            //get receipt details from the order object
           String receiptDetails = order.receipt();


            //write date, time & receipt details to file
            writer.write("Date and Time: " + formattedDateTime + "\n" );
            writer.newLine();
            writer.write(receiptDetails);

            writer.close();


            System.out.println("Receipt file saved successfully. ");
        }catch (IOException e) {
            System.out.println("Error saving receipt file " + e.getMessage());
        }
    }




}

