/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hinhtron;

import java.util.Scanner;

/**
 *
 * @author VND
 */
public class HT {
    private double r;
    
    public double dienTich(){
        return r * r * Math.PI;
    }
    
    public double chuVi(){
        return r * 2 * Math.PI;
    }
    
    public static void tieuDe(){
        System.out.printf("%15s %15s %15s\n", "Ban kinh", "Chu vi", "Dien tich");
    }
    
    public void xuat(){
        System.out.printf("%15.1f %15.1f %15.1f\n", r, chuVi(), dienTich());
    }
    
    public void nhap(){
        Scanner scan = new Scanner(System.in);
        
        System.out.printf("- Ban biet ban kinh hay duong kinh (1: ban kinh; 2: duong kinh): ");
        int ch;
        ch = Integer.parseInt(scan.nextLine());
        if(ch == 1){
            System.out.print("- Nhap ban kinh: ");
            r = Double.parseDouble(scan.nextLine());
        }
        else{
            System.out.print("- Nhap ban kinh: ");
            r = Double.parseDouble(scan.nextLine());
            r /= 2;
        }
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }
    
}
