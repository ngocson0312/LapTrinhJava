/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bai1;

/**
 *
 * @author VND
 */
public class HinhTron extends HinhPhang{
    private double r;
    
    @Override
    public void input(){
        System.out.print("- Nhap vao ban kinh cua hinh tron: ");
        r = Double.parseDouble(scan.nextLine());
    }
    
    @Override
    public String ToString(){
        return "Chu vi: " + chuVi() + ", Dien tich: " + dienTich();
    }

    @Override
    public double chuVi() {
        return r * 2 * Math.PI;
    }

    @Override
    public double dienTich() {
        return r * r * Math.PI;
    }
}
