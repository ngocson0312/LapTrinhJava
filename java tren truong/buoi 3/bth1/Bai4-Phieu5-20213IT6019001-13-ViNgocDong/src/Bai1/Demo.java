/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bai1;

/**
 *
 * @author VND
 */
public class Demo {
    public static void main(String[] args) {
        HinhPhang x = new HinhVuong();
        HinhPhang y = new HinhChuNhat();
        HinhPhang z = new HinhTron();
         
        x.input();
        System.out.println(x.ToString());
        y.input();
        System.out.println(y.ToString());
        z.input();
        System.out.println(z.ToString());
    }
}
