/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bai1;

/**
 *
 * @author VND
 */
public class HinhVuong extends HinhPhang {
    private double a;
    
    @Override
    public void input(){
        System.out.print("- Nhap vao do dai canh cua hinh vuong: ");
        a = Double.parseDouble(scan.nextLine());
    }
    
    @Override
    public String ToString(){
        return "Chu vi: " + chuVi() + ", Dien tich: " + dienTich();
    }

    @Override
    public double chuVi() {
        return a * 4;
    }

    @Override
    public double dienTich() {
        return a * a;
    }
}
