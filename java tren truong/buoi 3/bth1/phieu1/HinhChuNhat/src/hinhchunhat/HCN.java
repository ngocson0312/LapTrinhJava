/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hinhchunhat;

import java.util.Scanner;

/**
 *
 * @author VND
 */
public class HCN {
    private double dai, rong;
    
    public double area(){
        return dai * rong;
    }
    
    public double perimeter(){
        return 2 * (dai + rong);
    }
    
    public void input(){
        Scanner scan = new Scanner(System.in);
        
        System.out.println("\n- Nhap thong tin cua hinh chu nhat:");
        System.out.print("\t+ Nhap chieu dai: ");
        dai = Double.parseDouble(scan.nextLine());
        System.out.print("\t+ Nhap chieu rong: ");
        rong = Double.parseDouble(scan.nextLine());
    }
    
    public static void title(){
        System.out.printf("%-15s%-15s%-15s%-15s%n","Chiều dài","Chiều rộng","chu vi","Diện tich");
    }
    
    public void output() {
        System.out.printf("%-15.1f%-15.1f%-15.1f%-15.1f%n",dai,rong,area(),perimeter());
    }
}
