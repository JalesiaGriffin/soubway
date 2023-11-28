package com.pluralsight.deli;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class ReceiptFileManager {

    private String fileName;

    public ReceiptFileManager (String fileName) {
        this.fileName = fileName;
    }

    public  saveReceiptFile (Order order) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            //get receipt details from the order object
            String receiptDetails = order.???();

            //write receipt details to file
            writer.write(receiptDetails);
        }
    }




}
