/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLK;

import java.util.Scanner;

/**
 *
 * @author VND
 */
public class HangHoa {
    private String maHang, tenHang;
    private double sLTon, donGia;
    
    Scanner s = new Scanner(System.in);
    
    public void input(){
        System.out.print("\t+ Nhap ma hang hoa: ");
        maHang = s.nextLine();
        System.out.print("\t+ Nhap ten hang: ");
        tenHang = s.nextLine();
        System.out.print("\t+ Nhap so luong ton: ");
        sLTon = Double.parseDouble(s.nextLine());
        System.out.print("\t+ Nhap don gia: ");
        donGia = Double.parseDouble(s.nextLine());
    }
    
    public void output(){
        
    }
}
