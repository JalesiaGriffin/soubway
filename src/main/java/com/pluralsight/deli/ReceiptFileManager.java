package com.pluralsight.deli;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ReceiptFileManager {

    private String fileName;

    public ReceiptFileManager (String fileName) {
        this.fileName = fileName;
    }

    public void saveReceiptFile (Order order) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            //get receipt details from the order object
            String receiptDetails = order.checkOut();

            //write receipt details to file
            writer.write(receiptDetails);
            System.out.println("Receipt file saved successfully. ");
        }catch (IOException e) {
            System.out.println("Error saving receipt file " + e.getMessage());
        }
    }




}
