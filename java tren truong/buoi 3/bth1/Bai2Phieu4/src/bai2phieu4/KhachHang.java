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
public class KhachHang {
    private String maKh, hoTen;
    private Ngay ngayLap = new Ngay();
    private double soDien, donGia;
    
    public void input(){
        Scanner scan = new Scanner(System.in);
        
        System.out.println("\t+ Nhap ma khach hang: ");
        this.maKh = scan.nextLine();
        System.out.println("\t+ Nhap ma ten khach hang: ");
        this.hoTen = scan.nextLine();
        
    }
}
