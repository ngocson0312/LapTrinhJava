/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai2phieu4;

import java.util.Scanner;

/**
 *
 * @author VND
 */
public class Ngay {
    private int ngay, thang, nam;
    
    
    public void input(){
        Scanner scan = new Scanner(System.in);
        
        System.out.println("\t+ Nhap ngay: ");
        this.ngay = Integer.parseInt(scan.nextLine());
        System.out.println("\t+ Nhap thang: ");
        this.ngay = Integer.parseInt(scan.nextLine());
        System.out.println("\t+ Nhap nam: ");
        this.ngay = Integer.parseInt(scan.nextLine());
    }

    public int getThang() {
        return thang;
    }

    public int getNam() {
        return nam;
    }
}
