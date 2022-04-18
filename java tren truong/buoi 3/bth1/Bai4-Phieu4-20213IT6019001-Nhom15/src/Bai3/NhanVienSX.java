/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai3p4;

import java.util.Scanner;

/**
 *
 * @author VND
 */
public class NhanVienSX extends NhanVien{
    private int soSanPham;
    
    public NhanVienSX(String maNv){
        super(maNv);
        soSanPham=0;
    }
    public NhanVienSX() {
        super();
        soSanPham=0;
    }
    
    public double tinhLuong(){
        return soSanPham*10000;
    }
    
    public void nhap() {
        super.nhap();
        Scanner s = new Scanner(System.in);
        System.out.print("- Nhap so san pham: ");
        soSanPham=s.nextInt();
    }
    
    public static void inTieuDe(){
        NhanVien.inTieuDe();
        System.out.printf("%-10s %-15s %-15s%n","So sp", "Phu cap","Luong");
    }
    
    public void xuatDL(){
        super.xuatDL();
        System.out.printf("%-10d %-15.2f %-15.2f%n",soSanPham, tinhPhuCap(), tinhLuong());
    }

    public void setSoSanPham(int soSanPham) {
        this.soSanPham = soSanPham;
    }
    
    public int getSoSanPham() {
        return soSanPham;
    }
}
