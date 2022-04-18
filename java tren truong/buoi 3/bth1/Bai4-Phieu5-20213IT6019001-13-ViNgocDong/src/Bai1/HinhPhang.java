/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bai1;

import java.util.Scanner;

/**
 *
 * @author VND
 */
abstract public class HinhPhang {
    public Scanner scan = new Scanner(System.in);
    
    abstract public void input();
    abstract public String ToString();
    abstract public double chuVi();
    abstract public double dienTich();
}
