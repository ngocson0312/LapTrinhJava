/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bai3;

import java.io.IOException;
import java.io.*;
/**
 *
 * @author VND
 */
public class RandomAccessFile1 {
//    public static void main(String args[]) throws IOException {
//        double data[] = {11.2, 13.6, 255.6, 117.92, 2007.96, 8.9, 9.9, 10.0, 100.6};
//        double d;
//        RandomAccessFile1 raf;
//        try {
//            raf = new RandomAccessFile1("D:\\random.dat", "rw");
//        }
//        catch (FileNotFoundException exc) {
//            System.out.println("Cannot open file.");
//            return;
//        }
//        // Write values to the file.
//        for (int i = 0; i < data.length; i++) {
//            try {
//                raf.writeDouble(data[i]);
//            } 
//            catch (IOException exc) {
//                System.out.println("Error writing to file.");
//                return;
//            }
//        }
//        try {// Now, read back specific values
//            raf.seek(0 * 8); // seek to first double
//            d = raf.readDouble();
//            System.out.println("First value is " + d);
//            raf.seek(8 * 1); // seek to second double
//            d = raf.readDouble();
//            System.out.println("Second value is " + d);
//            raf.seek(8 * 3); // seek to fourth double
//            d = raf.readDouble();
//            System.out.println("Fourth value is " + d);
//            System.out.println();
//            //Read All data
//            System.out.println("Read all: ");
//        for (int i = 0; i < data.length; i++) {
//            raf.seek(8 * i); // seek to ith double
//            d = raf.readDouble();
//            System.out.print(d + " ");
//        }
//        System.out.println("");
//        // Now, read every other value.
//        System.out.println("Here is every other value: ");
//        for (int i = 0; i < data.length; i += 2) {
//            raf.seek(8 * i); // seek to ith double
//            d = raf.readDouble();
//            System.out.print(d + " ");
//        }
//        System.out.println("\n");
//        } catch (IOException exc) {
//            System.out.println("Error seeking or reading.");
//        }
//        raf.close();
//    }
}
