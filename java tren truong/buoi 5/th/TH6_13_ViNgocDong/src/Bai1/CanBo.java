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
public class CanBo {
    protected String fullName;
    protected int yearOfBirth;
    protected String gender, address;
    
    Scanner sc = new Scanner(System.in);

    public void input(){
        System.out.print("\t+ Nhap ho ten: ");
        fullName = sc.nextLine();
        System.out.print("\t+ Nhap nam sinh: ");
        yearOfBirth = Integer.parseInt(sc.nextLine());
        System.out.print("\t+ Nhap gioi tinh: ");
        gender = sc.nextLine();
        System.out.print("\t+ Nhap dia chi: ");
        address = sc.nextLine();
    }
    
    static void title(){
        System.out.printf("%-5s %-20s %-10s %-10s %-20s ", "STT", "Ho ten", "Nam sinh", "Gioi tinh", "Dia chi");
    }
    
    public void output(int i){
        System.out.printf("%-5d %-20s %-10d %-10s %-20s ", i, fullName, yearOfBirth, gender, address);
    }

    public String getFullName() {
        return fullName;
    }

    
}
