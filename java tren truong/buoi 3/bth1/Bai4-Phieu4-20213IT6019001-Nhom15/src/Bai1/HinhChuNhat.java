/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bai1;

/**
 *
 * @author VND
 */
public class HinhChuNhat extends HinhPhang{
    private double a, b;
    
    @Override
    public void input(){
        System.out.print("- Nhap vao chieu dai HCN: ");
        a = Double.parseDouble(scan.nextLine());
        System.out.print("- Nhap vao chieu rong HCN: ");
        b = Double.parseDouble(scan.nextLine());
    }
    
    @Override
    public String ToString(){
        return "Chu vi: " + chuVi() + ", Dien tich: " + dienTich();
    }

    @Override
    public double chuVi() {
        return (a + b) * 2;
    }

    @Override
    public double dienTich() {
        return a * b;
    }
}
