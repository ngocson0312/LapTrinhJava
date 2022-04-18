/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai1p4;

/**
 *
 * @author VND
 */
public class HinhVuong extends HinhPhang{
    public double canh;

    @Override
    double tinhCV() {
        return 4 * canh; 
    }

    @Override
    double tinhDT() {
        return canh * canh;
    }

    public HinhVuong(double canh) {
        this.canh = canh;
    }
    
    
    
}
